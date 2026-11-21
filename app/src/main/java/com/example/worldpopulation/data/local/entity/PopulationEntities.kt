package com.example.worldpopulation.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "countries",
    indices = [Index(value = ["name"]), Index(value = ["isoCode"], unique = true)]
)
data class CountryEntity(
    @PrimaryKey
    val isoCode: String,
    val name: String,
    val aliases: String,
    val flagEmoji: String,
    val region: String,
    val subregion: String,
    val landArea: Double?
)

@Entity(tableName = "world_population")
data class WorldPopulationEntity(
    @PrimaryKey
    val id: Int = 1,
    val population: Long,
    val populationYear: Int,
    val baselineTimestamp: Long,
    val annualChange: Double?,
    val growthRate: Double?,
    val dataType: String
)

@Entity(
    tableName = "country_populations",
    indices = [
        Index(value = ["population"]),
        Index(value = ["countryName"]),
        Index(value = ["rank"])
    ]
)
data class CountryPopulationEntity(
    @PrimaryKey
    val isoCode: String,
    val countryName: String,
    val population: Long,
    val populationYear: Int,
    val baselineTimestamp: Long?,
    val annualChange: Double?,
    val growthRate: Double?,
    val landArea: Double?,
    val density: Double?,
    val region: String?,
    val subregion: String?,
    val dataType: String,
    val rank: Int = 0
)

@Entity(
    tableName = "historical_populations",
    primaryKeys = ["isoCode", "year"],
    indices = [Index(value = ["isoCode", "year"])]
)
data class HistoricalPopulationEntity(
    val isoCode: String,
    val year: Int,
    val population: Long,
    val dataType: String
)

@Entity(
    tableName = "age_gender_populations",
    primaryKeys = ["isoCode", "year", "ageStart"],
    indices = [Index(value = ["isoCode", "year"])]
)
data class AgeGenderPopulationEntity(
    val isoCode: String,
    val year: Int,
    val ageStart: Int,
    val ageEnd: Int?,
    val malePopulation: Long?,
    val femalePopulation: Long?,
    val totalPopulation: Long,
    val dataType: String
)

@Entity(
    tableName = "demographic_indicators",
    primaryKeys = ["isoCode", "year", "indicatorKey"],
    indices = [Index(value = ["isoCode", "year"])]
)
data class DemographicIndicatorEntity(
    val isoCode: String,
    val year: Int,
    val indicatorKey: String,
    val indicatorName: String,
    val value: Double,
    val unit: String,
    val source: String,
    val dataType: String
)

@Entity(tableName = "data_source_metadata")
data class DataSourceMetadataEntity(
    @PrimaryKey
    val provider: String,
    val datasetName: String,
    val datasetVersion: String?,
    val referenceYear: Int?,
    val retrievedAt: Long,
    val sourceUrl: String?,
    val dataType: String,
    val projectionVariant: String?
)
