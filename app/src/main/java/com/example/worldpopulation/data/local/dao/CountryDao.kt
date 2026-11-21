package com.example.worldpopulation.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.worldpopulation.data.local.entity.CountryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Query("SELECT * FROM countries ORDER BY name ASC")
    fun getAllCountries(): Flow<List<CountryEntity>>

    @Query("SELECT * FROM countries WHERE isoCode = :isoCode LIMIT 1")
    suspend fun getCountryByIso(isoCode: String): CountryEntity?

    @Query("""
        SELECT * FROM countries 
        WHERE name LIKE '%' || :query || '%' 
           OR aliases LIKE '%' || :query || '%' 
           OR isoCode LIKE '%' || :query || '%'
        ORDER BY name ASC
    """)
    fun searchCountries(query: String): Flow<List<CountryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Query("SELECT COUNT(*) FROM countries")
    suspend fun getCountryCount(): Int
}
