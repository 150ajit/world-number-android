package com.example.worldpopulation.estimator

import com.example.worldpopulation.domain.estimator.PopulationEstimator
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import kotlin.math.abs

class PopulationEstimatorTest {

    private lateinit var estimator: PopulationEstimator

    @Before
    fun setUp() {
        estimator = PopulationEstimator()
    }

    @Test
    fun estimate_positiveGrowth_afterOneYear_matchesExpectedAnnualChange() {
        val baselinePop = 1_400_000_000L
        val baselineTime = 1_704_067_200_000L // Jan 1 2024 00:00:00 UTC
        val annualChange = 12_000_000.0

        // Exactly one solar year later
        val oneYearLater = baselineTime + (PopulationEstimator.SECONDS_PER_YEAR * 1000.0).toLong()

        val estimated = estimator.estimate(
            baselinePopulation = baselinePop,
            baselineTimestampMillis = baselineTime,
            annualChange = annualChange,
            currentTimestampMillis = oneYearLater
        )

        val expected = baselinePop + 12_000_000L
        val diff = abs(estimated - expected)
        // Allow maximum rounding difference of 1 person due to floating point precision
        assertTrue("Difference should be <= 1, but was $diff", diff <= 1L)
    }

    @Test
    fun estimate_negativeGrowth_afterOneYear_decreasesAppropriately() {
        val baselinePop = 125_000_000L
        val baselineTime = 1_704_067_200_000L
        val annualChange = -600_000.0

        val oneYearLater = baselineTime + (PopulationEstimator.SECONDS_PER_YEAR * 1000.0).toLong()

        val estimated = estimator.estimate(
            baselinePopulation = baselinePop,
            baselineTimestampMillis = baselineTime,
            annualChange = annualChange,
            currentTimestampMillis = oneYearLater
        )

        val expected = baselinePop - 600_000L
        val diff = abs(estimated - expected)
        assertTrue("Difference should be <= 1, but was $diff", diff <= 1L)
    }

    @Test
    fun estimate_zeroGrowth_remainsUnchanged() {
        val baselinePop = 50_000_000L
        val baselineTime = 1_704_067_200_000L
        val annualChange = 0.0

        val halfYearLater = baselineTime + (PopulationEstimator.SECONDS_PER_YEAR * 500.0).toLong()

        val estimated = estimator.estimate(
            baselinePopulation = baselinePop,
            baselineTimestampMillis = baselineTime,
            annualChange = annualChange,
            currentTimestampMillis = halfYearLater
        )

        assertEquals(baselinePop, estimated)
    }

    @Test
    fun estimateCountToday_midDay_returnsApproximatelyHalfDailyCount() {
        val annualBirths = 365_242.5 // Exactly 1,000 births per day
        val midDayTimestamp = 43_200_000L // 12 hours (noon UTC) into day

        val countToday = estimator.estimateCountToday(
            annualRateOrCount = annualBirths,
            currentTimestampMillis = midDayTimestamp,
            timeZone = java.util.TimeZone.getTimeZone("UTC")
        )

        // At noon, should be ~500
        val diff = abs(countToday - 500L)
        assertTrue("Expected ~500 births at noon, but was $countToday", diff <= 2L)
    }

    @Test
    fun testUnWpp2026BaselineProjection() {
        val baselinePop = 8_301_598_844L
        val baselineEpoch = 1782864000000L // July 1, 2026 00:00:00 UTC
        val annualChange = 71_000_000.0

        // Test estimate on October 1, 2026 (92 days later = ~0.25188 solar years)
        val oct1_2026 = 1790869649032L
        val est = estimator.estimate(
            baselinePopulation = baselinePop,
            baselineTimestampMillis = baselineEpoch,
            annualChange = annualChange,
            currentTimestampMillis = oct1_2026
        )

        // Expected: ~8.319 Billion
        assertTrue("Estimated population on Oct 1, 2026 should be > 8.318B, but was $est", est > 8_318_000_000L)
        assertTrue("Estimated population on Oct 1, 2026 should be < 8.321B, but was $est", est < 8_321_000_000L)
    }
}


