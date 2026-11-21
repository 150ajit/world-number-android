package com.example.worldpopulation.data.mapper

import com.example.worldpopulation.data.local.entity.AgeGenderPopulationEntity
import com.example.worldpopulation.data.local.entity.CountryEntity
import com.example.worldpopulation.data.local.entity.CountryPopulationEntity
import com.example.worldpopulation.data.local.entity.DataSourceMetadataEntity
import com.example.worldpopulation.data.local.entity.DemographicIndicatorEntity
import com.example.worldpopulation.data.local.entity.HistoricalPopulationEntity
import com.example.worldpopulation.data.local.entity.WorldPopulationEntity
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.model.DataType
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation

fun WorldPopulationEntity.toDomain(): WorldPopulation {
    return WorldPopulation(
        population = population,
        populationYear = populationYear,
        baselineTimestamp = baselineTimestamp,
        annualChange = annualChange,
        growthRate = growthRate,
        dataType = DataType.valueOf(dataType)
    )
}

fun WorldPopulation.toEntity(): WorldPopulationEntity {
    return WorldPopulationEntity(
        id = 1,
        population = population,
        populationYear = populationYear,
        baselineTimestamp = baselineTimestamp,
        annualChange = annualChange,
        growthRate = growthRate,
        dataType = dataType.name
    )
}

fun CountryPopulationEntity.toDomain(flagEmoji: String = ""): CountryPopulation {
    return CountryPopulation(
        isoCode = isoCode,
        countryName = countryName,
        population = population,
        populationYear = populationYear,
        baselineTimestamp = baselineTimestamp,
        annualChange = annualChange,
        growthRate = growthRate,
        landArea = landArea,
        density = density,
        region = region,
        subregion = subregion,
        dataType = DataType.valueOf(dataType),
        flagEmoji = flagEmoji
    )
}

fun CountryPopulation.toEntity(rank: Int = 0): CountryPopulationEntity {
    return CountryPopulationEntity(
        isoCode = isoCode,
        countryName = countryName,
        population = population,
        populationYear = populationYear,
        baselineTimestamp = baselineTimestamp,
        annualChange = annualChange,
        growthRate = growthRate,
        landArea = landArea,
        density = density,
        region = region,
        subregion = subregion,
        dataType = dataType.name,
        rank = rank
    )
}

fun HistoricalPopulationEntity.toDomain(): HistoricalPopulation {
    return HistoricalPopulation(
        isoCode = isoCode,
        year = year,
        population = population,
        dataType = DataType.valueOf(dataType)
    )
}

fun HistoricalPopulation.toEntity(): HistoricalPopulationEntity {
    return HistoricalPopulationEntity(
        isoCode = isoCode,
        year = year,
        population = population,
        dataType = dataType.name
    )
}

fun AgeGenderPopulationEntity.toDomain(): AgeGenderPopulation {
    return AgeGenderPopulation(
        isoCode = isoCode,
        year = year,
        ageStart = ageStart,
        ageEnd = ageEnd,
        malePopulation = malePopulation,
        femalePopulation = femalePopulation,
        totalPopulation = totalPopulation,
        dataType = DataType.valueOf(dataType)
    )
}

fun AgeGenderPopulation.toEntity(): AgeGenderPopulationEntity {
    return AgeGenderPopulationEntity(
        isoCode = isoCode,
        year = year,
        ageStart = ageStart,
        ageEnd = ageEnd,
        malePopulation = malePopulation,
        femalePopulation = femalePopulation,
        totalPopulation = totalPopulation,
        dataType = dataType.name
    )
}

fun DemographicIndicatorEntity.toDomain(): DemographicIndicator {
    return DemographicIndicator(
        id = "${isoCode}_${year}_${indicatorKey}",
        isoCode = isoCode,
        year = year,
        indicatorName = indicatorName,
        indicatorKey = indicatorKey,
        value = value,
        unit = unit,
        source = source,
        dataType = DataType.valueOf(dataType)
    )
}

fun DemographicIndicator.toEntity(): DemographicIndicatorEntity {
    return DemographicIndicatorEntity(
        isoCode = isoCode,
        year = year,
        indicatorKey = indicatorKey,
        indicatorName = indicatorName,
        value = value,
        unit = unit,
        source = source,
        dataType = dataType.name
    )
}

fun DataSourceMetadataEntity.toDomain(): DataSourceMetadata {
    return DataSourceMetadata(
        provider = provider,
        datasetName = datasetName,
        datasetVersion = datasetVersion,
        referenceYear = referenceYear,
        retrievedAt = retrievedAt,
        sourceUrl = sourceUrl,
        dataType = DataType.valueOf(dataType),
        projectionVariant = projectionVariant
    )
}

fun DataSourceMetadata.toEntity(): DataSourceMetadataEntity {
    return DataSourceMetadataEntity(
        provider = provider,
        datasetName = datasetName,
        datasetVersion = datasetVersion,
        referenceYear = referenceYear,
        retrievedAt = retrievedAt,
        sourceUrl = sourceUrl,
        dataType = dataType.name,
        projectionVariant = projectionVariant
    )
}
