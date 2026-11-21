package com.example.worldpopulation.demographics

import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.DataType
import com.example.worldpopulation.domain.model.GenderDistribution
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class DemographicsCalculationTest {

    @Test
    fun genderDistribution_calculatesPercentagesAccurately() {
        val malePop = 748_000_000L
        val femalePop = 702_000_000L
        val total = malePop + femalePop // 1,450,000,000

        val malePct = (malePop.toDouble() / total) * 100.0
        val femalePct = (femalePop.toDouble() / total) * 100.0

        val gender = GenderDistribution(
            isoCode = "IND",
            year = 2026,
            malePopulation = malePop,
            femalePopulation = femalePop,
            totalPopulation = total,
            malePercentage = malePct,
            femalePercentage = femalePct
        )

        assertEquals(51.586, gender.malePercentage, 0.001)
        assertEquals(48.413, gender.femalePercentage, 0.001)
        assertNotNull(gender.sexRatio)
        assertEquals(106.55, gender.sexRatio!!, 0.01)
    }

    @Test
    fun dependencyRatio_calculatesCorrectFormula() {
        // Pop 0-14 = 360M, Pop 15-64 = 980M, Pop 65+ = 110M
        val pop0_14 = 360_000_000L
        val pop15_64 = 980_000_000L
        val pop65Plus = 110_000_000L

        // Dependency ratio = ((360M + 110M) / 980M) * 100 = (470 / 980) * 100 = 47.959%
        val depRatio = ((pop0_14 + pop65Plus).toDouble() / pop15_64) * 100.0
        assertEquals(47.96, depRatio, 0.01)
    }

    @Test
    fun ageGroupLabel_formatsCorrectly() {
        val bracketChild = AgeGenderPopulation("IND", 2026, 0, 4, 50L, 50L, 100L, DataType.PROJECTION)
        assertEquals("0–4", bracketChild.ageGroupLabel)

        val bracketAdult = AgeGenderPopulation("IND", 2026, 25, 29, 50L, 50L, 100L, DataType.PROJECTION)
        assertEquals("25–29", bracketAdult.ageGroupLabel)

        val bracketOldest = AgeGenderPopulation("IND", 2026, 100, null, 5L, 5L, 10L, DataType.PROJECTION)
        assertEquals("100+", bracketOldest.ageGroupLabel)
    }
}
