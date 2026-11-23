package com.example.worldpopulation.presentation.subcategory

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.entity.SubcategoryEntity
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.repository.PopulationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SubcategoryDetailUiState(
    val subcategory: SubcategoryEntity? = null,
    val parentCategory: CategoryEntity? = null,
    val indicators: List<CategoryIndicatorEntity> = emptyList(),
    val selectedIndicator: CategoryIndicatorEntity? = null,
    val indicatorValues: List<CountryIndicatorValueEntity> = emptyList(),
    val countriesMap: Map<String, CountryPopulation> = emptyMap(),
    val searchQuery: String = "",
    val isLoading: Boolean = false
)

@HiltViewModel
class SubcategoryDetailViewModel @Inject constructor(
    private val repository: PopulationRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val subcategoryId: String = checkNotNull(savedStateHandle["subcategoryId"])

    private val defaultSubcat = com.example.worldpopulation.data.local.DefaultSubcategories.getSubcategory(subcategoryId)
    private val defaultIndicators = com.example.worldpopulation.data.local.DefaultIndicators.getIndicatorsForSubcategory(subcategoryId)
    private val initialIndicator = defaultIndicators.firstOrNull()
    private val initialValues = initialIndicator?.let {
        val sortDesc = it.sortDirection.equals("DESC", ignoreCase = true)
        com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(it.indicatorId, sortDesc)
    } ?: emptyList()

    private val _uiState = MutableStateFlow(
        SubcategoryDetailUiState(
            subcategory = defaultSubcat,
            indicators = defaultIndicators,
            selectedIndicator = initialIndicator,
            indicatorValues = initialValues,
            isLoading = false
        )
    )
    val uiState: StateFlow<SubcategoryDetailUiState> = _uiState.asStateFlow()

    init {
        // Trigger initial values load
        initialIndicator?.let { ind ->
            loadValuesForIndicator(ind)
        }

        // Load country flags & metadata
        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(
                    countriesMap = list.associateBy { it.isoCode }
                )
            }
        }

        // Load Subcategory info
        viewModelScope.launch {
            repository.getSubcategory(subcategoryId).collect { subcat ->
                if (subcat != null) {
                    _uiState.value = _uiState.value.copy(subcategory = subcat)
                    // Also load parent category
                    repository.getCategory(subcat.categoryId).collect { cat ->
                        _uiState.value = _uiState.value.copy(parentCategory = cat)
                    }
                }
            }
        }

        // Load Indicators for Subcategory
        viewModelScope.launch {
            repository.getIndicatorsForSubcategory(subcategoryId).collect { indList ->
                val active = if (indList.isNotEmpty()) indList else defaultIndicators
                val current = _uiState.value.selectedIndicator
                val target = active.find { it.indicatorId == current?.indicatorId } ?: active.firstOrNull()
                _uiState.value = _uiState.value.copy(
                    indicators = active,
                    selectedIndicator = target
                )
                if (target != null) {
                    loadValuesForIndicator(target)
                }
            }
        }
    }

    fun selectIndicator(indicator: CategoryIndicatorEntity) {
        val sortDesc = indicator.sortDirection.equals("DESC", ignoreCase = true)
        val immediateFallback = com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(indicator.indicatorId, sortDesc)
        _uiState.value = _uiState.value.copy(
            selectedIndicator = indicator,
            indicatorValues = if (immediateFallback.isNotEmpty()) immediateFallback else _uiState.value.indicatorValues
        )
        loadValuesForIndicator(indicator)
    }

    fun onSearchQueryChanged(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    private var valuesJob: Job? = null

    private fun loadValuesForIndicator(indicator: CategoryIndicatorEntity) {
        valuesJob?.cancel()
        valuesJob = viewModelScope.launch {
            val sortDesc = indicator.sortDirection.equals("DESC", ignoreCase = true)
            repository.getIndicatorValues(indicator.indicatorId, sortDesc).collect { values ->
                val fallback = if (values.isEmpty()) {
                    com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(indicator.indicatorId, sortDesc)
                } else {
                    values
                }
                _uiState.value = _uiState.value.copy(
                    indicatorValues = if (fallback.isNotEmpty()) fallback else _uiState.value.indicatorValues
                )
            }
        }
    }
}
