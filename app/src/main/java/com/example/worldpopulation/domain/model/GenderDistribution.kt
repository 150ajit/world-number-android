package com.example.worldpopulation.domain.model

data class GenderDistribution(
    val isoCode: String,
    val year: Int,
    val malePopulation: Long,
    val femalePopulation: Long,
    val totalPopulation: Long,
    val malePercentage: Double,
    val femalePercentage: Double,
    val sexRatio: Double? = if (femalePopulation > 0) (malePopulation.toDouble() / femalePopulation) * 100.0 else null,
    val dataType: DataType = DataType.ESTIMATE
)

data class AgeDistribution(
    val isoCode: String,
    val year: Int,
    val ageGroup: String,
    val population: Long,
    val percentage: Double,
    val dataType: DataType = DataType.ESTIMATE
)
