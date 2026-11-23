package com.example.worldpopulation.domain.repository

import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.data.local.entity.DataStoryEntity
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

    // 20 Categories & Global Information
    fun getAllCategories(): Flow<List<CategoryEntity>>
    fun getCategory(id: String): Flow<CategoryEntity?>
    fun getSubcategoriesForCategory(categoryId: String): Flow<List<com.example.worldpopulation.data.local.entity.SubcategoryEntity>>
    fun getSubcategory(id: String): Flow<com.example.worldpopulation.data.local.entity.SubcategoryEntity?>
    fun getIndicatorsForCategory(categoryId: String): Flow<List<CategoryIndicatorEntity>>
    fun getIndicatorsForSubcategory(subcategoryId: String): Flow<List<CategoryIndicatorEntity>>
    fun getIndicator(indicatorId: String): Flow<CategoryIndicatorEntity?>
    fun getIndicatorValues(indicatorId: String, sortDesc: Boolean = true): Flow<List<CountryIndicatorValueEntity>>
    fun getValuesForCountry(isoCode: String): Flow<List<CountryIndicatorValueEntity>>
    fun getDailyDiscovery(dayOfYear: Int): Flow<DailyDiscoveryEntity?>
    fun getDataStories(): Flow<List<DataStoryEntity>>

    suspend fun syncData(): Result<Boolean>
    suspend fun ensureDatabaseInitialized()
}
