package com.example.worldpopulation.data.remote.provider

import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation

interface PopulationDataProvider {
    val providerId: String
    val providerName: String

    suspend fun getMetadata(): DataSourceMetadata
    
    suspend fun fetchWorldPopulation(): Result<WorldPopulation>
    
    suspend fun fetchCountryPopulations(): Result<List<CountryPopulation>>
    
    suspend fun fetchHistoricalPopulations(isoCode: String): Result<List<HistoricalPopulation>>
    
    suspend fun fetchAgeGenderDistribution(isoCode: String, year: Int): Result<List<AgeGenderPopulation>>
    
    suspend fun fetchDemographicIndicators(isoCode: String, year: Int): Result<List<DemographicIndicator>>
}
