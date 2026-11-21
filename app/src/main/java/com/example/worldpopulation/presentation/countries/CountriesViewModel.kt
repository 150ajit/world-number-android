package com.example.worldpopulation.presentation.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.estimator.LivePopulationEngine
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class CountrySortOption(val displayName: String) {
    POPULATION_DESC("Population: High to Low"),
    POPULATION_ASC("Population: Low to High"),
    NAME_ASC("Name: A to Z"),
    NAME_DESC("Name: Z to A"),
    GROWTH_RATE_DESC("Growth Rate: High to Low"),
    DENSITY_DESC("Density: High to Low"),
    AREA_DESC("Land Area: High to Low")
}

data class CountriesUiState(
    val searchQuery: String = "",
    val selectedRegion: String = "All",
    val sortOption: CountrySortOption = CountrySortOption.POPULATION_DESC,
    val countries: List<CountryPopulation> = emptyList(),
    val filteredCountries: List<CountryPopulation> = emptyList(),
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL,
    val isLoading: Boolean = false
)

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val repository: PopulationRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CountriesUiState())
    val uiState: StateFlow<CountriesUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(countries = list)
                applyFiltersAndSorting()
            }
        }

        viewModelScope.launch {
            preferencesRepository.numberFormat.collect { format ->
                _uiState.value = _uiState.value.copy(numberFormat = format)
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
        applyFiltersAndSorting()
    }

    fun onRegionSelected(region: String) {
        _uiState.value = _uiState.value.copy(selectedRegion = region)
        applyFiltersAndSorting()
    }

    fun onSortOptionSelected(sort: CountrySortOption) {
        _uiState.value = _uiState.value.copy(sortOption = sort)
        applyFiltersAndSorting()
    }

    private fun applyFiltersAndSorting() {
        val current = _uiState.value
        val query = current.searchQuery.trim()
        val region = current.selectedRegion

        var filtered = current.countries

        // Filter by Region
        if (region != "All") {
            filtered = filtered.filter { it.region.equals(region, ignoreCase = true) }
        }

        // Filter by Query (name, isoCode)
        if (query.isNotEmpty()) {
            filtered = filtered.filter {
                it.countryName.contains(query, ignoreCase = true) ||
                it.isoCode.contains(query, ignoreCase = true)
            }
        }

        // Sort
        filtered = when (current.sortOption) {
            CountrySortOption.POPULATION_DESC -> filtered.sortedByDescending { it.population }
            CountrySortOption.POPULATION_ASC -> filtered.sortedBy { it.population }
            CountrySortOption.NAME_ASC -> filtered.sortedBy { it.countryName }
            CountrySortOption.NAME_DESC -> filtered.sortedByDescending { it.countryName }
            CountrySortOption.GROWTH_RATE_DESC -> filtered.sortedByDescending { it.growthRate ?: -999.0 }
            CountrySortOption.DENSITY_DESC -> filtered.sortedByDescending { it.density ?: 0.0 }
            CountrySortOption.AREA_DESC -> filtered.sortedByDescending { it.landArea ?: 0.0 }
        }

        _uiState.value = current.copy(filteredCountries = filtered)
    }
}
