package com.example.worldpopulation.domain.validator

import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.WorldPopulation
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataValidator @Inject constructor() {

    fun isValidIsoCode(isoCode: String): Boolean {
        return isoCode.isNotBlank() && (isoCode.length == 2 || isoCode.length == 3 || isoCode == "WLD")
    }

    fun validateWorldPopulation(world: WorldPopulation?): Boolean {
        if (world == null) return false
        // Valid world population should be positive and between 1 billion and 20 billion
        if (world.population < 1_000_000_000L || world.population > 20_000_000_000L) return false
        if (world.populationYear < 1950 || world.populationYear > 2100) return false
        if (world.baselineTimestamp <= 0) return false
        return true
    }

    fun validateCountry(country: CountryPopulation): Boolean {
        if (!isValidIsoCode(country.isoCode)) return false
        if (country.countryName.isBlank()) return false
        if (country.population <= 0) return false
        if (country.populationYear < 1950 || country.populationYear > 2100) return false
        return true
    }

    fun validateCountryPopulations(list: List<CountryPopulation>?): Boolean {
        if (list.isNullOrEmpty()) return false
        if (list.size < 5) return false // Authoritative dataset must have at least core countries
        val seenCodes = mutableSetOf<String>()
        for (item in list) {
            if (!validateCountry(item)) return false
            if (!seenCodes.add(item.isoCode.uppercase())) return false // Duplicate check
        }
        return true
    }

    fun validateAgeGenderBrackets(list: List<AgeGenderPopulation>?): Boolean {
        if (list.isNullOrEmpty()) return false
        var prevStart = -1
        for (bracket in list) {
            if (!isValidIsoCode(bracket.isoCode)) return false
            if (bracket.year < 1950 || bracket.year > 2100) return false
            if (bracket.ageStart < 0 || bracket.ageStart > 120) return false
            if (bracket.ageEnd != null && bracket.ageEnd < bracket.ageStart) return false
            if (bracket.totalPopulation < 0) return false
            if (bracket.malePopulation != null && bracket.malePopulation < 0) return false
            if (bracket.femalePopulation != null && bracket.femalePopulation < 0) return false
            if (bracket.ageStart <= prevStart) return false // Monotonic age check
            prevStart = bracket.ageStart
        }
        return true
    }

    fun validateDemographicIndicators(list: List<DemographicIndicator>?): Boolean {
        if (list == null) return false
        for (ind in list) {
            if (!isValidIsoCode(ind.isoCode)) return false
            if (ind.indicatorKey.isBlank()) return false
            if (ind.year < 1950 || ind.year > 2100) return false
        }
        return true
    }
}
