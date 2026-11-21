package com.example.worldpopulation.domain.estimator

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.math.roundToLong

@Singleton
class PopulationEstimator @Inject constructor() {

    companion object {
        // Average solar year in seconds: 365.2425 days * 86,400 seconds/day
        const val SECONDS_PER_YEAR = 31_556_952.0
        const val MILLIS_PER_YEAR = SECONDS_PER_YEAR * 1000.0
        const val MILLIS_PER_DAY = 86_400_000.0
    }

    /**
     * Calculates the estimated population at [currentTimestampMillis] based on
     * [baselinePopulation], [baselineTimestampMillis], and [annualChange].
     *
     * Handles positive, negative, and zero growth rates seamlessly.
     */
    fun estimate(
        baselinePopulation: Long,
        baselineTimestampMillis: Long,
        annualChange: Double,
        currentTimestampMillis: Long
    ): Long {
        if (baselinePopulation <= 0) return 0L
        if (annualChange == 0.0) return baselinePopulation

        val elapsedMillis = currentTimestampMillis - baselineTimestampMillis
        val elapsedYears = elapsedMillis / MILLIS_PER_YEAR
        val populationDelta = (elapsedYears * annualChange).roundToLong()

        val result = baselinePopulation + populationDelta
        return if (result < 0L) 0L else result
    }

    /**
     * Estimates natural event counts today (births, deaths, or net growth)
     * elapsed since midnight in the given [timeZone] (defaults to device's local timezone,
     * matching the methodology of live clocks like Worldometer).
     */
    fun estimateCountToday(
        annualRateOrCount: Double,
        currentTimestampMillis: Long,
        timeZone: java.util.TimeZone = java.util.TimeZone.getDefault()
    ): Long {
        val calendar = java.util.Calendar.getInstance(timeZone).apply {
            timeInMillis = currentTimestampMillis
            set(java.util.Calendar.HOUR_OF_DAY, 0)
            set(java.util.Calendar.MINUTE, 0)
            set(java.util.Calendar.SECOND, 0)
            set(java.util.Calendar.MILLISECOND, 0)
        }
        val startOfDayMillis = calendar.timeInMillis
        val millisIntoDay = (currentTimestampMillis - startOfDayMillis).coerceIn(0L, 86_400_000L)
        val fractionOfDay = millisIntoDay.toDouble() / MILLIS_PER_DAY
        val dailyCount = annualRateOrCount / 365.2425
        return (dailyCount * fractionOfDay).roundToLong()
    }
}
