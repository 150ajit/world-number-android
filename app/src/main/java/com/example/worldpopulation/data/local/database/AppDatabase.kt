package com.example.worldpopulation.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.worldpopulation.data.local.dao.AgeGenderPopulationDao
import com.example.worldpopulation.data.local.dao.CategoryDao
import com.example.worldpopulation.data.local.dao.CountryDao
import com.example.worldpopulation.data.local.dao.CountryPopulationDao
import com.example.worldpopulation.data.local.dao.DataSourceMetadataDao
import com.example.worldpopulation.data.local.dao.DemographicIndicatorDao
import com.example.worldpopulation.data.local.dao.DiscoveryDao
import com.example.worldpopulation.data.local.dao.HistoricalPopulationDao
import com.example.worldpopulation.data.local.dao.IndicatorDao
import com.example.worldpopulation.data.local.dao.StoryDao
import com.example.worldpopulation.data.local.dao.SyncManifestDao
import com.example.worldpopulation.data.local.dao.WorldPopulationDao
import com.example.worldpopulation.data.local.entity.AgeGenderPopulationEntity
import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.entity.CountryPopulationEntity
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.data.local.entity.DataSourceMetadataEntity
import com.example.worldpopulation.data.local.entity.DataStoryEntity
import com.example.worldpopulation.data.local.entity.DemographicIndicatorEntity
import com.example.worldpopulation.data.local.entity.HistoricalPopulationEntity
import com.example.worldpopulation.data.local.entity.SyncManifestEntity
import com.example.worldpopulation.data.local.entity.WorldPopulationEntity

@Database(
    entities = [
        CountryEntity::class,
        WorldPopulationEntity::class,
        CountryPopulationEntity::class,
        HistoricalPopulationEntity::class,
        AgeGenderPopulationEntity::class,
        DemographicIndicatorEntity::class,
        DataSourceMetadataEntity::class,
        CategoryEntity::class,
        CategoryIndicatorEntity::class,
        CountryIndicatorValueEntity::class,
        DailyDiscoveryEntity::class,
        DataStoryEntity::class,
        SyncManifestEntity::class
    ],
    version = 7,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
    abstract fun worldPopulationDao(): WorldPopulationDao
    abstract fun countryPopulationDao(): CountryPopulationDao
    abstract fun historicalPopulationDao(): HistoricalPopulationDao
    abstract fun ageGenderPopulationDao(): AgeGenderPopulationDao
    abstract fun demographicIndicatorDao(): DemographicIndicatorDao
    abstract fun dataSourceMetadataDao(): DataSourceMetadataDao
    abstract fun categoryDao(): CategoryDao
    abstract fun indicatorDao(): IndicatorDao
    abstract fun discoveryDao(): DiscoveryDao
    abstract fun storyDao(): StoryDao
    abstract fun syncManifestDao(): SyncManifestDao
}
