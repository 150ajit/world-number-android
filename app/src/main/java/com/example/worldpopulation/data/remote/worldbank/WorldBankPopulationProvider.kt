package com.example.worldpopulation.data.remote.worldbank

import com.example.worldpopulation.data.remote.provider.PopulationDataProvider
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.model.DataType
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WorldBankPopulationProvider @Inject constructor(
    private val apiService: WorldBankApiService,
    private val gson: Gson
) : PopulationDataProvider {

    override val providerId: String = "WORLD_BANK"
    override val providerName: String = "World Bank Open Data"

    override suspend fun getMetadata(): DataSourceMetadata {
        return DataSourceMetadata(
            provider = providerName,
            datasetName = "World Development Indicators",
            datasetVersion = "2024",
            referenceYear = 2023,
            retrievedAt = System.currentTimeMillis(),
            sourceUrl = "https://data.worldbank.org/",
            dataType = DataType.ESTIMATE
        )
    }

    override suspend fun fetchWorldPopulation(): Result<WorldPopulation> {
        return try {
            val response = apiService.getCountryIndicator("WLD", "SP.POP.TOTL", dateRange = "2023:2023")
            if (response.isSuccessful && response.body() != null && response.body()!!.size() > 1) {
                val dataArray = response.body()!!.get(1).asJsonArray
                if (dataArray.size() > 0) {
                    val item = dataArray.get(0).asJsonObject
                    val rawPop = item.get("value")?.asDouble?.toLong() ?: 8062923417L
                    val censusYear = item.get("date")?.asString?.toIntOrNull() ?: 2023
                    val annualGrowth = 71500000.0
                    val growthRate = 0.86

                    val calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC")).apply {
                        set(java.util.Calendar.YEAR, censusYear)
                        set(java.util.Calendar.MONTH, java.util.Calendar.JULY)
                        set(java.util.Calendar.DAY_OF_MONTH, 1)
                        set(java.util.Calendar.HOUR_OF_DAY, 0)
                        set(java.util.Calendar.MINUTE, 0)
                        set(java.util.Calendar.SECOND, 0)
                        set(java.util.Calendar.MILLISECOND, 0)
                    }
                    val baselineEpoch = calendar.timeInMillis

                    return Result.success(
                        WorldPopulation(
                            population = rawPop,
                            populationYear = censusYear,
                            baselineTimestamp = baselineEpoch,
                            annualChange = annualGrowth,
                            growthRate = growthRate,
                            dataType = DataType.ESTIMATE
                        )
                    )
                }
            }
            Result.failure(Exception("Empty World Bank world response"))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun fetchCountryPopulations(): Result<List<CountryPopulation>> {
        return Result.failure(Exception("Country populations batch from World Bank handled via local cache"))
    }

    override suspend fun fetchHistoricalPopulations(isoCode: String): Result<List<HistoricalPopulation>> {
        return try {
            val response = apiService.getCountryIndicator(isoCode, "SP.POP.TOTL", dateRange = "1960:2023")
            if (response.isSuccessful && response.body() != null && response.body()!!.size() > 1) {
                val dataArray = response.body()!!.get(1).asJsonArray
                val list = mutableListOf<HistoricalPopulation>()
                for (elem in dataArray) {
                    val obj = elem.asJsonObject
                    val year = obj.get("date")?.asString?.toIntOrNull()
                    val value = obj.get("value")
                    if (year != null && value != null && !value.isJsonNull) {
                        list.add(
                            HistoricalPopulation(
                                isoCode = isoCode,
                                year = year,
                                population = value.asDouble.toLong(),
                                dataType = DataType.HISTORICAL
                            )
                        )
                    }
                }
                Result.success(list.sortedBy { it.year })
            } else {
                Result.failure(Exception("World bank history empty"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun fetchAgeGenderDistribution(isoCode: String, year: Int): Result<List<AgeGenderPopulation>> {
        return Result.failure(Exception("Age brackets not provided in fine 5-year granularity by World Bank API"))
    }

    override suspend fun fetchDemographicIndicators(isoCode: String, year: Int): Result<List<DemographicIndicator>> {
        return Result.failure(Exception("Use cached demographic indicators"))
    }
}
