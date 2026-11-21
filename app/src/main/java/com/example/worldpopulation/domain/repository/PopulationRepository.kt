package com.example.worldpopulation.domain.repository

import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import kotlinx.coroutines.flow.Flow

interface PopulationRepository {
    fun getWorldPopulation(): Flow<WorldPopulation?>
    fun getCountryPopulations(): Flow<List<CountryPopulation>>
    fun getCountryDetails(isoCode: String): Flow<CountryPopulation?>
    fun searchCountries(query: String): Flow<List<CountryPopulation>>
    fun getHistoricalPopulations(isoCode: String): Flow<List<HistoricalPopulation>>
    fun getAgeGenderDistribution(isoCode: String, year: Int): Flow<List<AgeGenderPopulation>>
    fun getAvailableYears(isoCode: String): Flow<List<Int>>
    fun getDemographicIndicators(isoCode: String, year: Int): Flow<List<DemographicIndicator>>
    fun getDataSourceMetadata(): Flow<List<DataSourceMetadata>>
    suspend fun syncData(): Result<Boolean>
    suspend fun ensureDatabaseInitialized()
}
