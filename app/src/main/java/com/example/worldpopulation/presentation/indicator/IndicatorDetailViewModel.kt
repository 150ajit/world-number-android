package com.example.worldpopulation.presentation.indicator

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.repository.PopulationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class IndicatorDetailUiState(
    val indicator: CategoryIndicatorEntity? = null,
    val indicatorValues: List<CountryIndicatorValueEntity> = emptyList(),
    val historicalValuesA: List<CountryIndicatorValueEntity> = emptyList(),
    val historicalValuesB: List<CountryIndicatorValueEntity> = emptyList(),
    val countriesMap: Map<String, CountryPopulation> = emptyMap(),
    val searchQuery: String = "",
    val compareCountryA: String? = null,
    val compareCountryB: String? = null,
    val isLoading: Boolean = false
)

@HiltViewModel
class IndicatorDetailViewModel @Inject constructor(
    private val repository: PopulationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val indicatorId: String = checkNotNull(savedStateHandle["indicatorId"])

    private val defaultInd = com.example.worldpopulation.data.local.DefaultIndicators.list.find {
        it.indicatorId.equals(indicatorId, ignoreCase = true)
    }
    private val defaultValues = defaultInd?.let {
        val sortDesc = it.sortDirection.equals("DESC", ignoreCase = true)
        com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(it.indicatorId, sortDesc)
    } ?: emptyList()

    private val _uiState = MutableStateFlow(
        IndicatorDetailUiState(
            indicator = defaultInd,
            indicatorValues = defaultValues,
            compareCountryA = defaultValues.firstOrNull()?.isoCode,
            compareCountryB = defaultValues.getOrNull(1)?.isoCode,
            isLoading = false
        )
    )
    val uiState: StateFlow<IndicatorDetailUiState> = _uiState.asStateFlow()

    init {
        // Load Country Metadata Map (flags, names)
        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(
                    countriesMap = list.associateBy { it.isoCode }
                )
            }
        }

        // Load Indicator info
        viewModelScope.launch {
            repository.getIndicator(indicatorId).collect { ind ->
                if (ind != null) {
                    _uiState.value = _uiState.value.copy(indicator = ind)
                    loadValues(ind)
                }
            }
        }
    }

    private fun loadValues(ind: CategoryIndicatorEntity) {
        viewModelScope.launch {
            val sortDesc = ind.sortDirection.equals("DESC", ignoreCase = true)
            repository.getIndicatorValues(ind.indicatorId, sortDesc).collect { values ->
                val fallback = if (values.isEmpty()) {
                    com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(ind.indicatorId, sortDesc)
                } else {
                    values
                }
                val activeValues = if (fallback.isNotEmpty()) fallback else _uiState.value.indicatorValues
                val targetA = _uiState.value.compareCountryA ?: activeValues.firstOrNull()?.isoCode
                val targetB = _uiState.value.compareCountryB ?: activeValues.getOrNull(1)?.isoCode
                _uiState.value = _uiState.value.copy(
                    indicatorValues = activeValues,
                    compareCountryA = targetA,
                    compareCountryB = targetB
                )
                loadHistorical()
            }
        }
    }

    private var histAJob: kotlinx.coroutines.Job? = null
    private var histBJob: kotlinx.coroutines.Job? = null

    private fun loadHistorical() {
        val isoA = _uiState.value.compareCountryA
        val isoB = _uiState.value.compareCountryB
        if (isoA != null) {
            histAJob?.cancel()
            histAJob = viewModelScope.launch {
                repository.getHistoricalValues(isoA, indicatorId).collect { hist ->
                    _uiState.value = _uiState.value.copy(historicalValuesA = hist)
                }
            }
        }
        if (isoB != null) {
            histBJob?.cancel()
            histBJob = viewModelScope.launch {
                repository.getHistoricalValues(isoB, indicatorId).collect { hist ->
                    _uiState.value = _uiState.value.copy(historicalValuesB = hist)
                }
            }
        }
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun selectCompareCountryA(iso: String) {
        _uiState.value = _uiState.value.copy(compareCountryA = iso)
        loadHistorical()
    }

    fun selectCompareCountryB(iso: String) {
        _uiState.value = _uiState.value.copy(compareCountryB = iso)
        loadHistorical()
    }
}
