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
    val subcategories: List<com.example.worldpopulation.data.local.entity.SubcategoryEntity> = emptyList(),
    val indicators: List<CategoryIndicatorEntity> = emptyList(),
    val selectedIndicator: CategoryIndicatorEntity? = null,
    val indicatorValues: List<CountryIndicatorValueEntity> = emptyList(),
    val countriesMap: Map<String, CountryPopulation> = emptyMap(),
    val selectedTab: Int = 0, // 0: Subcategories, 1: Key Indicators
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

    private val defaultSubcategories = com.example.worldpopulation.data.local.DefaultSubcategories.getSubcategoriesForCategory(categoryId)
    private val defaultIndicators = com.example.worldpopulation.data.local.DefaultIndicators.getIndicatorsForCategory(categoryId)
    private val initialIndicator = defaultIndicators.firstOrNull()
    private val initialValues = initialIndicator?.let {
        val sortDesc = it.sortDirection.equals("DESC", ignoreCase = true)
        com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(it.indicatorId, sortDesc)
    } ?: emptyList()

    private val _uiState = MutableStateFlow(
        CategoryDetailUiState(
            category = defaultCategory,
            subcategories = defaultSubcategories,
            indicators = defaultIndicators,
            selectedIndicator = initialIndicator,
            indicatorValues = initialValues,
            selectedTab = 0,
            isLoading = false
        )
    )
    val uiState: StateFlow<CategoryDetailUiState> = _uiState.asStateFlow()

    init {
        // Trigger initial values load immediately for default selected indicator
        initialIndicator?.let { initialInd ->
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

        // Load Subcategories for Category
        viewModelScope.launch {
            repository.getSubcategoriesForCategory(categoryId).collect { subcatList ->
                val active = if (subcatList.isNotEmpty()) subcatList else defaultSubcategories
                _uiState.value = _uiState.value.copy(subcategories = active)
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

    fun setTab(index: Int) {
        _uiState.value = _uiState.value.copy(selectedTab = index)
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

    private var valuesJob: kotlinx.coroutines.Job? = null

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
