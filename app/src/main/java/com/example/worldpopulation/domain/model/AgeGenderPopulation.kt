package com.example.worldpopulation.domain.model

data class AgeGenderPopulation(
    val isoCode: String,
    val year: Int,
    val ageStart: Int,
    val ageEnd: Int?,
    val malePopulation: Long?,
    val femalePopulation: Long?,
    val totalPopulation: Long,
    val dataType: DataType
) {
    val ageGroupLabel: String
        get() = when {
            ageEnd == null || ageStart >= 100 -> "$ageStart+"
            else -> "$ageStart–$ageEnd"
        }

    val malePercentage: Double?
        get() = if (malePopulation != null && totalPopulation > 0) {
            (malePopulation.toDouble() / totalPopulation) * 100.0
        } else null

    val femalePercentage: Double?
        get() = if (femalePopulation != null && totalPopulation > 0) {
            (femalePopulation.toDouble() / totalPopulation) * 100.0
        } else null
}
