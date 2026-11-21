package com.example.worldpopulation.presentation.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
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

data class SavedItemsUiState(
    val savedCountries: List<CountryPopulation> = emptyList(),
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL,
    val isLoading: Boolean = false
)

@HiltViewModel
class SavedItemsViewModel @Inject constructor(
    private val repository: PopulationRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SavedItemsUiState(isLoading = true))
    val uiState: StateFlow<SavedItemsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.ensureDatabaseInitialized()
        }

        viewModelScope.launch {
            combine(
                repository.getCountryPopulations(),
                preferencesRepository.savedCountries,
                preferencesRepository.numberFormat
            ) { countries, savedSet, format ->
                val filtered = countries.filter { it.isoCode in savedSet }
                Triple(filtered, format, false)
            }.collect { (filtered, format, loading) ->
                _uiState.value = _uiState.value.copy(
                    savedCountries = filtered,
                    numberFormat = format,
                    isLoading = loading
                )
            }
        }
    }

    fun removeSavedCountry(isoCode: String) {
        viewModelScope.launch {
            preferencesRepository.toggleSaveCountry(isoCode)
        }
    }
}
