package com.example.worldpopulation.presentation.category

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.entity.CategoryEntity
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

data class CategoryDetailUiState(
    val category: CategoryEntity? = null,
    val indicators: List<CategoryIndicatorEntity> = emptyList(),
    val selectedIndicator: CategoryIndicatorEntity? = null,
    val indicatorValues: List<CountryIndicatorValueEntity> = emptyList(),
    val countriesMap: Map<String, CountryPopulation> = emptyMap(),
    val isLoading: Boolean = false
)

@HiltViewModel
class CategoryDetailViewModel @Inject constructor(
    private val repository: PopulationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val categoryId: String = checkNotNull(savedStateHandle["categoryId"])

    private val defaultCategory = com.example.worldpopulation.data.local.DefaultCategories.list.find {
        it.id.equals(categoryId, ignoreCase = true)
    }

    private val defaultIndicators = com.example.worldpopulation.data.local.DefaultIndicators.getIndicatorsForCategory(categoryId)

    private val _uiState = MutableStateFlow(
        CategoryDetailUiState(
            category = defaultCategory,
            indicators = defaultIndicators,
            selectedIndicator = defaultIndicators.firstOrNull(),
            isLoading = false
        )
    )
    val uiState: StateFlow<CategoryDetailUiState> = _uiState.asStateFlow()

    init {
        // Trigger initial values load immediately for default selected indicator
        defaultIndicators.firstOrNull()?.let { initialInd ->
            loadValuesForIndicator(initialInd)
        }

        viewModelScope.launch {
            repository.ensureDatabaseInitialized()
        }

        // Load Country Metadata Map (flags, names)
        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(
                    countriesMap = list.associateBy { it.isoCode }
                )
            }
        }

        // Load Category Info
        viewModelScope.launch {
            repository.getCategory(categoryId).collect { cat ->
                if (cat != null) {
                    _uiState.value = _uiState.value.copy(category = cat)
                }
            }
        }

        // Load Indicators for Category
        viewModelScope.launch {
            repository.getIndicatorsForCategory(categoryId).collect { indicatorList ->
                val activeIndicators = if (indicatorList.isNotEmpty()) indicatorList else defaultIndicators
                val currentSelected = _uiState.value.selectedIndicator
                val targetSelected = activeIndicators.find { it.indicatorId == currentSelected?.indicatorId }
                    ?: activeIndicators.firstOrNull()
                _uiState.value = _uiState.value.copy(
                    indicators = activeIndicators,
                    selectedIndicator = targetSelected,
                    isLoading = false
                )
                if (targetSelected != null) {
                    loadValuesForIndicator(targetSelected)
                }
            }
        }
    }

    fun selectIndicator(indicator: CategoryIndicatorEntity) {
        _uiState.value = _uiState.value.copy(selectedIndicator = indicator)
        loadValuesForIndicator(indicator)
    }

    private var valuesJob: kotlinx.coroutines.Job? = null

    private fun loadValuesForIndicator(indicator: CategoryIndicatorEntity) {
        valuesJob?.cancel()
        valuesJob = viewModelScope.launch {
            val sortDesc = indicator.sortDirection.equals("DESC", ignoreCase = true)
            repository.getIndicatorValues(indicator.indicatorId, sortDesc).collect { values ->
                _uiState.value = _uiState.value.copy(indicatorValues = values)
            }
        }
    }
}
