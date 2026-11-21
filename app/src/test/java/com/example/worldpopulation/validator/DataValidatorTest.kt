package com.example.worldpopulation.validator

import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DataType
import com.example.worldpopulation.domain.model.WorldPopulation
import com.example.worldpopulation.domain.validator.DataValidator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DataValidatorTest {

    private lateinit var validator: DataValidator

    @Before
    fun setUp() {
        validator = DataValidator()
    }

    @Test
    fun validateWorldPopulation_valid_returnsTrue() {
        val validWorld = WorldPopulation(
            population = 8_203_000_000L,
            populationYear = 2026,
            baselineTimestamp = 1767225600000L,
            annualChange = 71_000_000.0,
            growthRate = 0.86,
            dataType = DataType.PROJECTION
        )
        assertTrue(validator.validateWorldPopulation(validWorld))
    }

    @Test
    fun validateWorldPopulation_invalidNegativeOrUnrealistic_returnsFalse() {
        val negativeWorld = WorldPopulation(
            population = -500L,
            populationYear = 2026,
            baselineTimestamp = 1767225600000L,
            annualChange = 71_000_000.0,
            growthRate = 0.86,
            dataType = DataType.PROJECTION
        )
        assertFalse(validator.validateWorldPopulation(negativeWorld))

        val zeroTimestamp = WorldPopulation(
            population = 8_200_000_000L,
            populationYear = 2026,
            baselineTimestamp = 0L,
            annualChange = 71_000_000.0,
            growthRate = 0.86,
            dataType = DataType.PROJECTION
        )
        assertFalse(validator.validateWorldPopulation(zeroTimestamp))
    }

    @Test
    fun validateCountryPopulations_duplicateIso_returnsFalse() {
        val duplicates = listOf(
            CountryPopulation("IND", "India", 1450000000L, 2026, 1767225600000L, 12000000.0, 0.89, null, null, null, null, DataType.PROJECTION),
            CountryPopulation("IND", "India Duplicate", 1450000000L, 2026, 1767225600000L, 12000000.0, 0.89, null, null, null, null, DataType.PROJECTION),
            CountryPopulation("USA", "United States", 345000000L, 2026, 1767225600000L, 1800000.0, 0.53, null, null, null, null, DataType.PROJECTION),
            CountryPopulation("JPN", "Japan", 123000000L, 2026, 1767225600000L, -600000.0, -0.5, null, null, null, null, DataType.PROJECTION),
            CountryPopulation("BRA", "Brazil", 211000000L, 2026, 1767225600000L, 1100000.0, 0.5, null, null, null, null, DataType.PROJECTION)
        )
        assertFalse(validator.validateCountryPopulations(duplicates))
    }

    @Test
    fun validateAgeGenderBrackets_nonMonotonicAge_returnsFalse() {
        val nonMonotonic = listOf(
            AgeGenderPopulation("IND", 2026, 0, 4, 100L, 100L, 200L, DataType.PROJECTION),
            AgeGenderPopulation("IND", 2026, 10, 14, 100L, 100L, 200L, DataType.PROJECTION),
            AgeGenderPopulation("IND", 2026, 5, 9, 100L, 100L, 200L, DataType.PROJECTION) // Out of order!
        )
        assertFalse(validator.validateAgeGenderBrackets(nonMonotonic))
    }
}
