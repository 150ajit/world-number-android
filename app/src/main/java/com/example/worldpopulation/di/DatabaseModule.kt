package com.example.worldpopulation.di

import android.content.Context
import androidx.room.Room
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
import com.example.worldpopulation.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "world_population.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideCountryDao(db: AppDatabase): CountryDao = db.countryDao()

    @Provides
    fun provideWorldPopulationDao(db: AppDatabase): WorldPopulationDao = db.worldPopulationDao()

    @Provides
    fun provideCountryPopulationDao(db: AppDatabase): CountryPopulationDao = db.countryPopulationDao()

    @Provides
    fun provideHistoricalPopulationDao(db: AppDatabase): HistoricalPopulationDao = db.historicalPopulationDao()

    @Provides
    fun provideAgeGenderPopulationDao(db: AppDatabase): AgeGenderPopulationDao = db.ageGenderPopulationDao()

    @Provides
    fun provideDemographicIndicatorDao(db: AppDatabase): DemographicIndicatorDao = db.demographicIndicatorDao()

    @Provides
    fun provideDataSourceMetadataDao(db: AppDatabase): DataSourceMetadataDao = db.dataSourceMetadataDao()

    @Provides
    fun provideCategoryDao(db: AppDatabase): CategoryDao = db.categoryDao()

    @Provides
    fun provideIndicatorDao(db: AppDatabase): IndicatorDao = db.indicatorDao()

    @Provides
    fun provideDiscoveryDao(db: AppDatabase): DiscoveryDao = db.discoveryDao()

    @Provides
    fun provideStoryDao(db: AppDatabase): StoryDao = db.storyDao()

    @Provides
    fun provideSyncManifestDao(db: AppDatabase): SyncManifestDao = db.syncManifestDao()
}
