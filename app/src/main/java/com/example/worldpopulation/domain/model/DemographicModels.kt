package com.example.worldpopulation.domain.model

data class DemographicIndicator(
    val id: String,
    val isoCode: String,
    val year: Int,
    val indicatorName: String,
    val indicatorKey: String,
    val value: Double,
    val unit: String,
    val source: String,
    val dataType: DataType
)

data class DataSourceMetadata(
    val provider: String,
    val datasetName: String,
    val datasetVersion: String?,
    val referenceYear: Int?,
    val retrievedAt: Long,
    val sourceUrl: String?,
    val dataType: DataType,
    val projectionVariant: String? = null
)

data class BroadAgeStructure(
    val isoCode: String,
    val year: Int,
    val age0To14Percentage: Double,
    val age15To64Percentage: Double,
    val age65PlusPercentage: Double,
    val dependencyRatio: Double?,
    val dataType: DataType = DataType.ESTIMATE
)

data class UrbanRuralPopulation(
    val isoCode: String,
    val year: Int,
    val urbanPopulation: Long?,
    val urbanPercentage: Double?,
    val ruralPopulation: Long?,
    val ruralPercentage: Double?,
    val dataType: DataType = DataType.ESTIMATE
)

data class PopulationChangeComponents(
    val isoCode: String,
    val year: Int,
    val births: Long?,
    val deaths: Long?,
    val naturalIncrease: Long?,
    val netMigration: Long?,
    val overallChange: Long?,
    val dataType: DataType = DataType.ESTIMATE
)

data class PyramidData(
    val isoCode: String,
    val countryName: String,
    val year: Int,
    val brackets: List<AgeGenderPopulation>,
    val totalPopulation: Long,
    val malePopulation: Long,
    val femalePopulation: Long,
    val malePercentage: Double,
    val femalePercentage: Double,
    val medianAge: Double?,
    val dependencyRatio: Double?,
    val dataType: DataType,
    val projectionVariant: String? = null
)
