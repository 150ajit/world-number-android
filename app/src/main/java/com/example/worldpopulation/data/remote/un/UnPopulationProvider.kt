package com.example.worldpopulation.data.remote.un

import com.example.worldpopulation.data.remote.provider.PopulationDataProvider
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.model.DataType
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnPopulationProvider @Inject constructor(
    private val apiService: UnPopulationApiService
) : PopulationDataProvider {

    override val providerId: String = "UN_WPP"
    override val providerName: String = "United Nations Population Division"

    override suspend fun getMetadata(): DataSourceMetadata {
        return DataSourceMetadata(
            provider = providerName,
            datasetName = "World Population Prospects",
            datasetVersion = "2024 Revision",
            referenceYear = 2026,
            retrievedAt = System.currentTimeMillis(),
            sourceUrl = "https://population.un.org/wpp/",
            dataType = DataType.PROJECTION,
            projectionVariant = "Medium variant"
        )
    }

    override suspend fun fetchWorldPopulation(): Result<WorldPopulation> {
        return try {
            val response = apiService.getIndicatorLatest(indicatorId = 46, locationId = 900)
            if (response.isSuccessful && response.body()?.data?.isNotEmpty() == true) {
                val record = response.body()!!.data!!.first()
                val popCount = if (record.value != null && record.value > 0) {
                    (record.value * 1000.0).toLong() // UN reports in thousands
                } else {
                    8_301_598_844L
                }
                val year = record.timeMid?.toInt() ?: 2026
                val dataType = if (year <= 2023) DataType.ESTIMATE else DataType.PROJECTION
                val calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC")).apply {
                    set(java.util.Calendar.YEAR, year)
                    set(java.util.Calendar.MONTH, java.util.Calendar.JULY)
                    set(java.util.Calendar.DAY_OF_MONTH, 1)
                    set(java.util.Calendar.HOUR_OF_DAY, 0)
                    set(java.util.Calendar.MINUTE, 0)
                    set(java.util.Calendar.SECOND, 0)
                    set(java.util.Calendar.MILLISECOND, 0)
                }
                val baselineEpoch = calendar.timeInMillis

                Result.success(
                    WorldPopulation(
                        population = popCount,
                        populationYear = year,
                        baselineTimestamp = baselineEpoch,
                        annualChange = 71000000.0,
                        growthRate = 0.86,
                        dataType = dataType
                    )
                )
            } else {
                Result.failure(Exception("Failed to fetch UN world population: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun fetchCountryPopulations(): Result<List<CountryPopulation>> {
        // Returned empty failure so repository gracefully falls back to Room / Bundled Authoritative UN WPP dataset
        return Result.failure(Exception("Network batch endpoint not configured, using local database cache"))
    }

    override suspend fun fetchHistoricalPopulations(isoCode: String): Result<List<HistoricalPopulation>> {
        return Result.failure(Exception("Historical population query requires local cached WPP"))
    }

    override suspend fun fetchAgeGenderDistribution(isoCode: String, year: Int): Result<List<AgeGenderPopulation>> {
        return Result.failure(Exception("Age gender distribution query requires local cached WPP"))
    }

    override suspend fun fetchDemographicIndicators(isoCode: String, year: Int): Result<List<DemographicIndicator>> {
        return Result.failure(Exception("Demographic indicators query requires local cached WPP"))
    }
}
