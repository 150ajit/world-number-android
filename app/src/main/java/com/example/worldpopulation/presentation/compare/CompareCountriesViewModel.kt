package com.example.worldpopulation.presentation.compare

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CountryComparisonItem(
    val country: CountryPopulation,
    val indicators: Map<String, DemographicIndicator> = emptyMap(),
    val categoryValues: Map<String, CountryIndicatorValueEntity> = emptyMap()
)

data class CompareUiState(
    val allCountries: List<CountryPopulation> = emptyList(),
    val selectedIsoCodes: List<String> = listOf("IND", "CHN", "USA"),
    val comparedItems: List<CountryComparisonItem> = emptyList(),
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL,
    val isLoading: Boolean = false
)

@HiltViewModel
class CompareCountriesViewModel @Inject constructor(
    private val repository: PopulationRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CompareUiState())
    val uiState: StateFlow<CompareUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.ensureDatabaseInitialized()
        }

        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(allCountries = list)
                loadComparisons()
            }
        }

        viewModelScope.launch {
            preferencesRepository.numberFormat.collect { format ->
                _uiState.value = _uiState.value.copy(numberFormat = format)
            }
        }
    }

    fun addCountry(isoCode: String) {
        val current = _uiState.value.selectedIsoCodes
        if (current.size < 5 && !current.contains(isoCode)) {
            _uiState.value = _uiState.value.copy(selectedIsoCodes = current + isoCode)
            loadComparisons()
        }
    }

    fun removeCountry(isoCode: String) {
        val current = _uiState.value.selectedIsoCodes
        if (current.size > 2) {
            _uiState.value = _uiState.value.copy(selectedIsoCodes = current - isoCode)
            loadComparisons()
        }
    }

    private fun loadComparisons() {
        val isos = _uiState.value.selectedIsoCodes
        val all = _uiState.value.allCountries
        if (all.isEmpty()) return

        viewModelScope.launch {
            val items = mutableListOf<CountryComparisonItem>()
            for (iso in isos) {
                val country = all.find { it.isoCode == iso }
                if (country != null) {
                    val indicatorsMap = mutableMapOf<String, DemographicIndicator>()
                    val categoryMap = mutableMapOf<String, CountryIndicatorValueEntity>()
                    try {
                        val indList = repository.getDemographicIndicators(iso, 2026).first()
                        indList.forEach { ind ->
                            indicatorsMap[ind.indicatorKey] = ind
                        }
                    } catch (_: Exception) {}
                    try {
                        val catList = repository.getValuesForCountry(iso).first()
                        catList.forEach { v ->
                            categoryMap[v.indicatorId] = v
                        }
                    } catch (_: Exception) {}
                    items.add(CountryComparisonItem(country, indicatorsMap, categoryMap))
                }
            }
            _uiState.value = _uiState.value.copy(comparedItems = items)
        }
    }
}
