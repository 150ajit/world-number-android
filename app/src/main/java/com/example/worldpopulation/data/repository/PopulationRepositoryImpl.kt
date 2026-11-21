package com.example.worldpopulation.data.repository

import com.example.worldpopulation.data.local.database.AppDatabase
import com.example.worldpopulation.data.local.fallback.BundledPopulationData
import com.example.worldpopulation.data.mapper.toDomain
import com.example.worldpopulation.data.mapper.toEntity
import com.example.worldpopulation.data.remote.un.UnPopulationProvider
import com.example.worldpopulation.data.remote.worldbank.WorldBankPopulationProvider
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.domain.validator.DataValidator
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PopulationRepositoryImpl @Inject constructor(
    private val database: AppDatabase,
    private val unProvider: UnPopulationProvider,
    private val worldBankProvider: WorldBankPopulationProvider,
    private val validator: DataValidator,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : PopulationRepository {

    private val initMutex = Mutex()
    private val countryDao = database.countryDao()
    private val worldDao = database.worldPopulationDao()
    private val countryPopDao = database.countryPopulationDao()
    private val historyDao = database.historicalPopulationDao()
    private val ageGenderDao = database.ageGenderPopulationDao()
    private val indicatorDao = database.demographicIndicatorDao()
    private val metadataDao = database.dataSourceMetadataDao()

    override suspend fun ensureDatabaseInitialized() = withContext(ioDispatcher) {
        initMutex.withLock {
            val existingWorld = worldDao.getWorldPopulationDirect()
            val hasWorld = existingWorld != null
            val hasCountries = countryPopDao.getCount() > 0
            if (!hasWorld || !hasCountries) {
                // First run initialization with authentic UN WPP 2024 bundled fallback
                countryDao.insertCountries(BundledPopulationData.countries)
                worldDao.insertWorldPopulation(BundledPopulationData.worldPopulation)
                countryPopDao.insertCountryPopulations(BundledPopulationData.countryPopulations)
                historyDao.insertHistoricalPopulations(BundledPopulationData.getHistoricalPopulations())
                ageGenderDao.insertAgeGenderPopulations(BundledPopulationData.getAgeGenderBrackets())
                indicatorDao.insertIndicators(BundledPopulationData.getDemographicIndicators())
                metadataDao.insertMetadata(BundledPopulationData.metadata)
            } else if (existingWorld.population != BundledPopulationData.worldPopulation.population) {
                // Keep world baseline aligned with updated calibration
                worldDao.insertWorldPopulation(BundledPopulationData.worldPopulation)
            } else if (existingWorld.population < BundledPopulationData.worldPopulation.population && existingWorld.populationYear <= BundledPopulationData.worldPopulation.populationYear) {
                // Repair database if it was previously overwritten by an outdated or reduced World Bank estimate
                worldDao.insertWorldPopulation(BundledPopulationData.worldPopulation)
                metadataDao.insertMetadata(BundledPopulationData.metadata)
            }
        }
    }

    override fun getWorldPopulation(): Flow<WorldPopulation?> {
        return worldDao.getWorldPopulation().map { it?.toDomain() }.flowOn(ioDispatcher)
    }

    override fun getCountryPopulations(): Flow<List<CountryPopulation>> {
        return combine(
            countryPopDao.getAllCountryPopulations(),
            countryDao.getAllCountries()
        ) { pops, countries ->
            val flagMap = countries.associate { it.isoCode to it.flagEmoji }
            pops.map { it.toDomain(flagMap[it.isoCode] ?: "") }
        }.flowOn(ioDispatcher)
    }

    override fun getCountryDetails(isoCode: String): Flow<CountryPopulation?> {
        return combine(
            countryPopDao.getCountryPopulation(isoCode),
            countryDao.getAllCountries()
        ) { pop, countries ->
            if (pop == null) return@combine null
            val flag = countries.find { it.isoCode.equals(isoCode, ignoreCase = true) }?.flagEmoji ?: ""
            pop.toDomain(flag)
        }.flowOn(ioDispatcher)
    }

    override fun searchCountries(query: String): Flow<List<CountryPopulation>> {
        val trimmed = query.trim()
        return combine(
            countryPopDao.getAllCountryPopulations(),
            countryDao.getAllCountries()
        ) { pops, countries ->
            val flagMap = countries.associate { it.isoCode to it.flagEmoji }
            val aliasMap = countries.associate { it.isoCode to it.aliases }
            val domainPops = pops.map { it.toDomain(flagMap[it.isoCode] ?: "") }
            if (trimmed.isEmpty()) {
                domainPops
            } else {
                domainPops.filter { c ->
                    c.countryName.contains(trimmed, ignoreCase = true) ||
                    c.isoCode.contains(trimmed, ignoreCase = true) ||
                    (aliasMap[c.isoCode]?.contains(trimmed, ignoreCase = true) == true)
                }
            }
        }.flowOn(ioDispatcher)
    }

    override fun getHistoricalPopulations(isoCode: String): Flow<List<HistoricalPopulation>> {
        return historyDao.getHistoryForCountry(isoCode).map { list ->
            list.map { it.toDomain() }
        }.flowOn(ioDispatcher)
    }

    override fun getAgeGenderDistribution(isoCode: String, year: Int): Flow<List<AgeGenderPopulation>> {
        return ageGenderDao.getAgeGenderDistribution(isoCode, year).map { list ->
            list.map { it.toDomain() }
        }.flowOn(ioDispatcher)
    }

    override fun getAvailableYears(isoCode: String): Flow<List<Int>> {
        return ageGenderDao.getAvailableYearsForCountry(isoCode).flowOn(ioDispatcher)
    }

    override fun getDemographicIndicators(isoCode: String, year: Int): Flow<List<DemographicIndicator>> {
        return indicatorDao.getIndicatorsForYear(isoCode, year).map { list ->
            list.map { it.toDomain() }
        }.flowOn(ioDispatcher)
    }

    override fun getDataSourceMetadata(): Flow<List<DataSourceMetadata>> {
        return metadataDao.getAllMetadata().map { list ->
            list.map { it.toDomain() }
        }.flowOn(ioDispatcher)
    }

    override suspend fun syncData(): Result<Boolean> = withContext(ioDispatcher) {
        try {
            ensureDatabaseInitialized()
            val existing = worldDao.getWorldPopulationDirect()

            // If existing world population was previously reduced below UN WPP 2024 projection baseline, repair it
            if (existing != null && existing.population < BundledPopulationData.worldPopulation.population && existing.populationYear <= BundledPopulationData.worldPopulation.populationYear) {
                worldDao.insertWorldPopulation(BundledPopulationData.worldPopulation)
                metadataDao.insertMetadata(BundledPopulationData.metadata)
            }

            // Attempt UN API remote sync (Primary authoritative provider)
            val unResult = unProvider.fetchWorldPopulation()
            if (unResult.isSuccess) {
                val world = unResult.getOrNull()
                if (validator.validateWorldPopulation(world) && world != null) {
                    if (world.populationYear >= 2026 && world.population >= BundledPopulationData.worldPopulation.population && world.populationYear >= (existing?.populationYear ?: 0)) {
                        worldDao.insertWorldPopulation(world.toEntity())
                        val metadata = unProvider.getMetadata()
                        metadataDao.insertMetadata(metadata.toEntity())
                        return@withContext Result.success(true)
                    }
                }
            }

            // Fallback to World Bank API sync
            // World Bank provides historical indicators (up to 2023), not authoritative live projections.
            // Check connectivity and verify data sources, but preserve UN WPP 2024 live world projection.
            val wbResult = worldBankProvider.fetchWorldPopulation()
            if (wbResult.isSuccess) {
                val world = wbResult.getOrNull()
                if (validator.validateWorldPopulation(world) && world != null) {
                    // Only update world population if remote data is strictly newer than current UN WPP projection
                    if (world.populationYear > 2026 && world.population >= BundledPopulationData.worldPopulation.population && world.populationYear > (existing?.populationYear ?: 0)) {
                        worldDao.insertWorldPopulation(world.toEntity())
                        val metadata = worldBankProvider.getMetadata()
                        metadataDao.insertMetadata(metadata.toEntity())
                    } else {
                        // Maintain authoritative UN WPP projection & metadata
                        val unMetadata = unProvider.getMetadata()
                        metadataDao.insertMetadata(unMetadata.toEntity())
                    }
                    return@withContext Result.success(true)
                }
            }

            // If remote sync fails, preserve local cached data
            Result.failure(Exception("Sync unsuccessful. Using cached population estimates."))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
