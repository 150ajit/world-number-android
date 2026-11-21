package com.example.worldpopulation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.worldpopulation.data.local.entity.AgeGenderPopulationEntity
import com.example.worldpopulation.data.local.entity.CountryPopulationEntity
import com.example.worldpopulation.data.local.entity.DataSourceMetadataEntity
import com.example.worldpopulation.data.local.entity.DemographicIndicatorEntity
import com.example.worldpopulation.data.local.entity.HistoricalPopulationEntity
import com.example.worldpopulation.data.local.entity.WorldPopulationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WorldPopulationDao {
    @Query("SELECT * FROM world_population WHERE id = 1 LIMIT 1")
    fun getWorldPopulation(): Flow<WorldPopulationEntity?>

    @Query("SELECT * FROM world_population WHERE id = 1 LIMIT 1")
    suspend fun getWorldPopulationDirect(): WorldPopulationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWorldPopulation(entity: WorldPopulationEntity)
}

@Dao
interface CountryPopulationDao {
    @Query("SELECT * FROM country_populations ORDER BY population DESC")
    fun getAllCountryPopulations(): Flow<List<CountryPopulationEntity>>

    @Query("SELECT * FROM country_populations WHERE isoCode = :isoCode LIMIT 1")
    fun getCountryPopulation(isoCode: String): Flow<CountryPopulationEntity?>

    @Query("SELECT * FROM country_populations WHERE isoCode = :isoCode LIMIT 1")
    suspend fun getCountryPopulationDirect(isoCode: String): CountryPopulationEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountryPopulations(list: List<CountryPopulationEntity>)

    @Query("SELECT COUNT(*) FROM country_populations")
    suspend fun getCount(): Int
}

@Dao
interface HistoricalPopulationDao {
    @Query("SELECT * FROM historical_populations WHERE isoCode = :isoCode ORDER BY year ASC")
    fun getHistoryForCountry(isoCode: String): Flow<List<HistoricalPopulationEntity>>

    @Query("SELECT * FROM historical_populations WHERE isoCode = :isoCode ORDER BY year ASC")
    suspend fun getHistoryForCountryDirect(isoCode: String): List<HistoricalPopulationEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoricalPopulations(list: List<HistoricalPopulationEntity>)
}

@Dao
interface AgeGenderPopulationDao {
    @Query("SELECT * FROM age_gender_populations WHERE isoCode = :isoCode AND year = :year ORDER BY ageStart ASC")
    fun getAgeGenderDistribution(isoCode: String, year: Int): Flow<List<AgeGenderPopulationEntity>>

    @Query("SELECT * FROM age_gender_populations WHERE isoCode = :isoCode AND year = :year ORDER BY ageStart ASC")
    suspend fun getAgeGenderDistributionDirect(isoCode: String, year: Int): List<AgeGenderPopulationEntity>

    @Query("SELECT DISTINCT year FROM age_gender_populations WHERE isoCode = :isoCode ORDER BY year ASC")
    fun getAvailableYearsForCountry(isoCode: String): Flow<List<Int>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAgeGenderPopulations(list: List<AgeGenderPopulationEntity>)
}

@Dao
interface DemographicIndicatorDao {
    @Query("SELECT * FROM demographic_indicators WHERE isoCode = :isoCode AND year = :year")
    fun getIndicatorsForYear(isoCode: String, year: Int): Flow<List<DemographicIndicatorEntity>>

    @Query("SELECT * FROM demographic_indicators WHERE isoCode = :isoCode ORDER BY year DESC")
    fun getAllIndicatorsForCountry(isoCode: String): Flow<List<DemographicIndicatorEntity>>

    @Query("SELECT * FROM demographic_indicators WHERE isoCode = :isoCode AND indicatorKey = :key ORDER BY year ASC")
    fun getIndicatorTrend(isoCode: String, key: String): Flow<List<DemographicIndicatorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIndicators(list: List<DemographicIndicatorEntity>)
}

@Dao
interface DataSourceMetadataDao {
    @Query("SELECT * FROM data_source_metadata")
    fun getAllMetadata(): Flow<List<DataSourceMetadataEntity>>

    @Query("SELECT * FROM data_source_metadata WHERE provider = :provider LIMIT 1")
    suspend fun getMetadataByProvider(provider: String): DataSourceMetadataEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMetadata(metadata: DataSourceMetadataEntity)
}
