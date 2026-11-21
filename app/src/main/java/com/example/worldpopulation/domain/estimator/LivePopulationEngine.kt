package com.example.worldpopulation.domain.estimator

import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LivePopulationEngine @Inject constructor(
    private val estimator: PopulationEstimator
) {

    private val _currentTimestamp = MutableStateFlow(System.currentTimeMillis())
    val currentTimestamp: StateFlow<Long> = _currentTimestamp.asStateFlow()

    private var tickerJob: Job? = null
    private var activeSubscribersCount = 0

    @Synchronized
    fun start(scope: CoroutineScope) {
        activeSubscribersCount++
        if (tickerJob == null || tickerJob?.isActive == false) {
            tickerJob = scope.launch {
                while (isActive) {
                    _currentTimestamp.value = System.currentTimeMillis()
                    delay(1000L)
                }
            }
        }
    }

    @Synchronized
    fun stop() {
        activeSubscribersCount--
        if (activeSubscribersCount <= 0) {
            activeSubscribersCount = 0
            tickerJob?.cancel()
            tickerJob = null
        }
    }

    fun calculateLiveWorldPopulation(world: WorldPopulation?, now: Long = _currentTimestamp.value): Long {
        if (world == null) return 0L
        val annualChange = world.annualChange ?: (world.population * ((world.growthRate ?: 0.86) / 100.0))
        return estimator.estimate(
            baselinePopulation = world.population,
            baselineTimestampMillis = world.baselineTimestamp,
            annualChange = annualChange,
            currentTimestampMillis = now
        )
    }

    fun calculateLiveCountryPopulation(country: CountryPopulation, now: Long = _currentTimestamp.value): Long {
        val baseline = country.baselineTimestamp ?: return country.population
        val annualChange = country.annualChange ?: (country.population * ((country.growthRate ?: 0.0) / 100.0))
        return estimator.estimate(
            baselinePopulation = country.population,
            baselineTimestampMillis = baseline,
            annualChange = annualChange,
            currentTimestampMillis = now
        )
    }

    fun calculateBirthsToday(annualBirths: Double = 132_586_000.0, now: Long = _currentTimestamp.value): Long {
        return estimator.estimateCountToday(annualBirths, now)
    }

    fun calculateDeathsToday(annualDeaths: Double = 62_480_000.0, now: Long = _currentTimestamp.value): Long {
        return estimator.estimateCountToday(annualDeaths, now)
    }

    fun calculateGrowthToday(annualChange: Double = 70_106_000.0, now: Long = _currentTimestamp.value): Long {
        return estimator.estimateCountToday(annualChange, now)
    }
}
