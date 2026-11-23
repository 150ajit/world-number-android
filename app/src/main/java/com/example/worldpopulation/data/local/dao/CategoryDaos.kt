package com.example.worldpopulation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.data.local.entity.DataStoryEntity
import com.example.worldpopulation.data.local.entity.SyncManifestEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories ORDER BY orderIndex ASC")
    fun getAllCategories(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM categories ORDER BY orderIndex ASC")
    suspend fun getAllCategoriesDirect(): List<CategoryEntity>

    @Query("SELECT * FROM categories WHERE id = :id LIMIT 1")
    fun getCategory(id: String): Flow<CategoryEntity?>

    @Query("SELECT COUNT(*) FROM categories")
    suspend fun getCategoryCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<CategoryEntity>)
}

@Dao
interface SubcategoryDao {
    @Query("SELECT * FROM subcategories WHERE categoryId = :categoryId ORDER BY orderIndex ASC")
    fun getSubcategoriesForCategory(categoryId: String): Flow<List<com.example.worldpopulation.data.local.entity.SubcategoryEntity>>

    @Query("SELECT * FROM subcategories WHERE categoryId = :categoryId ORDER BY orderIndex ASC")
    suspend fun getSubcategoriesForCategoryDirect(categoryId: String): List<com.example.worldpopulation.data.local.entity.SubcategoryEntity>

    @Query("SELECT * FROM subcategories WHERE id = :id LIMIT 1")
    fun getSubcategory(id: String): Flow<com.example.worldpopulation.data.local.entity.SubcategoryEntity?>

    @Query("SELECT * FROM subcategories WHERE id = :id LIMIT 1")
    suspend fun getSubcategoryDirect(id: String): com.example.worldpopulation.data.local.entity.SubcategoryEntity?

    @Query("SELECT COUNT(*) FROM subcategories")
    suspend fun getSubcategoryCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubcategories(subcategories: List<com.example.worldpopulation.data.local.entity.SubcategoryEntity>)
}

@Dao
interface IndicatorDao {
    @Query("SELECT * FROM category_indicators WHERE categoryId = :categoryId")
    fun getIndicatorsForCategory(categoryId: String): Flow<List<CategoryIndicatorEntity>>

    @Query("SELECT * FROM category_indicators WHERE subcategoryId = :subcategoryId")
    fun getIndicatorsForSubcategory(subcategoryId: String): Flow<List<CategoryIndicatorEntity>>

    @Query("SELECT * FROM category_indicators")
    fun getAllIndicators(): Flow<List<CategoryIndicatorEntity>>

    @Query("SELECT COUNT(*) FROM category_indicators")
    suspend fun getIndicatorCount(): Int

    @Query("SELECT * FROM category_indicators WHERE indicatorId = :indicatorId LIMIT 1")
    suspend fun getIndicatorDirect(indicatorId: String): CategoryIndicatorEntity?

    @Query("SELECT * FROM country_indicator_values WHERE indicatorId = :indicatorId ORDER BY CASE WHEN :sortDesc = 1 THEN value END DESC, CASE WHEN :sortDesc = 0 THEN value END ASC")
    fun getValuesForIndicator(indicatorId: String, sortDesc: Boolean): Flow<List<CountryIndicatorValueEntity>>

    @Query("SELECT * FROM country_indicator_values WHERE isoCode = :isoCode")
    fun getValuesForCountry(isoCode: String): Flow<List<CountryIndicatorValueEntity>>

    @Query("SELECT * FROM country_indicator_values WHERE isoCode = :isoCode AND categoryId = :categoryId")
    fun getValuesForCountryAndCategory(isoCode: String, categoryId: String): Flow<List<CountryIndicatorValueEntity>>

    @Query("SELECT * FROM country_indicator_values WHERE isoCode = :isoCode")
    suspend fun getValuesForCountryDirect(isoCode: String): List<CountryIndicatorValueEntity>

    @Query("SELECT COUNT(*) FROM country_indicator_values")
    suspend fun getValuesCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIndicators(indicators: List<CategoryIndicatorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertValues(values: List<CountryIndicatorValueEntity>)
}

@Dao
interface DiscoveryDao {
    @Query("SELECT * FROM daily_discoveries WHERE dayOfYear = :day LIMIT 1")
    fun getDiscoveryForDay(day: Int): Flow<DailyDiscoveryEntity?>

    @Query("SELECT * FROM daily_discoveries WHERE dayOfYear = :day LIMIT 1")
    suspend fun getDiscoveryForDayDirect(day: Int): DailyDiscoveryEntity?

    @Query("SELECT * FROM daily_discoveries ORDER BY dayOfYear ASC")
    fun getAllDiscoveries(): Flow<List<DailyDiscoveryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiscoveries(discoveries: List<DailyDiscoveryEntity>)
}

@Dao
interface StoryDao {
    @Query("SELECT * FROM data_stories")
    fun getAllStories(): Flow<List<DataStoryEntity>>

    @Query("SELECT * FROM data_stories WHERE id = :id LIMIT 1")
    fun getStory(id: String): Flow<DataStoryEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStories(stories: List<DataStoryEntity>)
}

@Dao
interface SyncManifestDao {
    @Query("SELECT * FROM sync_manifest")
    suspend fun getAllSynced(): List<SyncManifestEntity>

    @Query("SELECT * FROM sync_manifest WHERE datasetId = :datasetId LIMIT 1")
    suspend fun getSynced(datasetId: String): SyncManifestEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManifest(entry: SyncManifestEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entries: List<SyncManifestEntity>)
}
