package com.example.worldpopulation.data.mapper

import com.example.worldpopulation.data.local.fallback.BundledPopulationData
import com.example.worldpopulation.domain.model.DataType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test

class PopulationMappersTest {

    @Test
    fun testBundledWorldPopulationToDomain() {
        val domain = BundledPopulationData.worldPopulation.toDomain()
        assertNotNull(domain)
        assertEquals(DataType.CALIBRATED_ESTIMATE, domain.dataType)
    }

    @Test
    fun testBundledMetadataToDomain() {
        val domain = BundledPopulationData.metadata.toDomain()
        assertNotNull(domain)
        assertEquals(DataType.ESTIMATE_AND_PROJECTION, domain.dataType)
    }

    @Test
    fun testBundledCountryPopulationsToDomain() {
        for (cp in BundledPopulationData.countryPopulations) {
            val domain = cp.toDomain("🇮🇳")
            assertNotNull(domain)
            assertEquals(DataType.PROJECTION, domain.dataType)
        }
    }

    @Test
    fun testDataTypeFromStringFallback() {
        assertEquals(DataType.CALIBRATED_ESTIMATE, DataType.fromString("CALIBRATED_ESTIMATE"))
        assertEquals(DataType.ESTIMATE_AND_PROJECTION, DataType.fromString("ESTIMATE_AND_PROJECTION"))
        assertEquals(DataType.ESTIMATE, DataType.fromString("UNKNOWN_VALUE_XYZ"))
        assertEquals(DataType.ESTIMATE, DataType.fromString(null))
        assertEquals(DataType.ESTIMATE, DataType.fromString(""))
    }
}
