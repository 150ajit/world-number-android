package com.example.worldpopulation.domain.model

data class HistoricalPopulation(
    val isoCode: String,
    val year: Int,
    val population: Long,
    val dataType: DataType
)

data class WorldPopulation(
    val population: Long,
    val populationYear: Int,
    val baselineTimestamp: Long,
    val annualChange: Double?,
    val growthRate: Double?,
    val dataType: DataType
)

data class CountryPopulation(
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
    val dataType: DataType,
    val flagEmoji: String = ""
)
