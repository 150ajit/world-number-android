package com.example.worldpopulation.presentation.pyramid

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.BroadAgeStructure
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.GenderDistribution
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.ui.components.PyramidDisplayMode
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class PyramidCompareMode {
    SINGLE,
    COUNTRY_VS_COUNTRY,
    YEAR_VS_YEAR
}

data class PyramidUiState(
    val selectedCountryIso: String = "IND",
    val compareCountryIso: String = "JPN",
    val selectedYear: Int = 2026,
    val compareYear: Int = 2050,
    val compareMode: PyramidCompareMode = PyramidCompareMode.SINGLE,
    val displayMode: PyramidDisplayMode = PyramidDisplayMode.PERCENTAGE,
    val countries: List<CountryPopulation> = emptyList(),
    val availableYears: List<Int> = emptyList(),
    // Primary pyramid data
    val primaryBrackets: List<AgeGenderPopulation> = emptyList(),
    val primaryGender: GenderDistribution? = null,
    val primaryStructure: BroadAgeStructure? = null,
    val primaryIndicators: List<DemographicIndicator> = emptyList(),
    // Comparison pyramid data
    val compareBrackets: List<AgeGenderPopulation> = emptyList(),
    val compareGender: GenderDistribution? = null,
    val compareStructure: BroadAgeStructure? = null,
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL
)

@HiltViewModel
class PyramidViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: PopulationRepository,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val initialIso = savedStateHandle.get<String>("isoCode")?.takeIf { it.isNotBlank() && it != "{isoCode}" } ?: "IND"

    private val _uiState = MutableStateFlow(PyramidUiState(selectedCountryIso = initialIso))
    val uiState: StateFlow<PyramidUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.ensureDatabaseInitialized()
        }

        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(countries = list)
            }
        }

        viewModelScope.launch {
            repository.getAvailableYears(initialIso).collect { years ->
                val yearList = if (years.isEmpty()) listOf(1970, 2026, 2050) else years
                val defaultYear = if (yearList.contains(2026)) 2026 else yearList.first()
                _uiState.value = _uiState.value.copy(
                    availableYears = yearList,
                    selectedYear = defaultYear
                )
                refreshData()
            }
        }

        viewModelScope.launch {
            preferencesRepository.numberFormat.collect { format ->
                _uiState.value = _uiState.value.copy(numberFormat = format)
            }
        }
    }

    fun selectCountry(iso: String) {
        _uiState.value = _uiState.value.copy(selectedCountryIso = iso)
        refreshData()
    }

    fun selectCompareCountry(iso: String) {
        _uiState.value = _uiState.value.copy(compareCountryIso = iso)
        refreshData()
    }

    fun selectYear(year: Int) {
        _uiState.value = _uiState.value.copy(selectedYear = year)
        refreshData()
    }

    fun selectCompareYear(year: Int) {
        _uiState.value = _uiState.value.copy(compareYear = year)
        refreshData()
    }

    fun setCompareMode(mode: PyramidCompareMode) {
        _uiState.value = _uiState.value.copy(compareMode = mode)
        refreshData()
    }

    fun setDisplayMode(mode: PyramidDisplayMode) {
        _uiState.value = _uiState.value.copy(displayMode = mode)
    }

    private fun refreshData() {
        val s = _uiState.value
        // Primary
        viewModelScope.launch {
            repository.getAgeGenderDistribution(s.selectedCountryIso, s.selectedYear).collect { brackets ->
                val male = brackets.sumOf { it.malePopulation ?: 0L }
                val female = brackets.sumOf { it.femalePopulation ?: 0L }
                val tot = male + female
                val gender = if (tot > 0) {
                    GenderDistribution(
                        isoCode = s.selectedCountryIso,
                        year = s.selectedYear,
                        malePopulation = male,
                        femalePopulation = female,
                        totalPopulation = tot,
                        malePercentage = (male.toDouble() / tot) * 100.0,
                        femalePercentage = (female.toDouble() / tot) * 100.0
                    )
                } else null

                val structure = if (tot > 0) {
                    val p0_14 = brackets.filter { it.ageStart < 15 }.sumOf { it.totalPopulation }
                    val p15_64 = brackets.filter { it.ageStart in 15..64 }.sumOf { it.totalPopulation }
                    val p65 = brackets.filter { it.ageStart >= 65 }.sumOf { it.totalPopulation }
                    BroadAgeStructure(
                        isoCode = s.selectedCountryIso,
                        year = s.selectedYear,
                        age0To14Percentage = (p0_14.toDouble() / tot) * 100.0,
                        age15To64Percentage = (p15_64.toDouble() / tot) * 100.0,
                        age65PlusPercentage = (p65.toDouble() / tot) * 100.0,
                        dependencyRatio = if (p15_64 > 0) ((p0_14 + p65).toDouble() / p15_64) * 100.0 else null
                    )
                } else null

                _uiState.value = _uiState.value.copy(
                    primaryBrackets = brackets,
                    primaryGender = gender,
                    primaryStructure = structure
                )
            }
        }

        viewModelScope.launch {
            repository.getDemographicIndicators(s.selectedCountryIso, s.selectedYear).collect { list ->
                _uiState.value = _uiState.value.copy(primaryIndicators = list)
            }
        }

        // Comparison if in compare mode
        if (s.compareMode != PyramidCompareMode.SINGLE) {
            val compareIso = if (s.compareMode == PyramidCompareMode.COUNTRY_VS_COUNTRY) s.compareCountryIso else s.selectedCountryIso
            val compareYr = if (s.compareMode == PyramidCompareMode.YEAR_VS_YEAR) s.compareYear else s.selectedYear

            viewModelScope.launch {
                repository.getAgeGenderDistribution(compareIso, compareYr).collect { brackets ->
                    val male = brackets.sumOf { it.malePopulation ?: 0L }
                    val female = brackets.sumOf { it.femalePopulation ?: 0L }
                    val tot = male + female
                    val gender = if (tot > 0) {
                        GenderDistribution(
                            isoCode = compareIso,
                            year = compareYr,
                            malePopulation = male,
                            femalePopulation = female,
                            totalPopulation = tot,
                            malePercentage = (male.toDouble() / tot) * 100.0,
                            femalePercentage = (female.toDouble() / tot) * 100.0
                        )
                    } else null

                    val structure = if (tot > 0) {
                        val p0_14 = brackets.filter { it.ageStart < 15 }.sumOf { it.totalPopulation }
                        val p15_64 = brackets.filter { it.ageStart in 15..64 }.sumOf { it.totalPopulation }
                        val p65 = brackets.filter { it.ageStart >= 65 }.sumOf { it.totalPopulation }
                        BroadAgeStructure(
                            isoCode = compareIso,
                            year = compareYr,
                            age0To14Percentage = (p0_14.toDouble() / tot) * 100.0,
                            age15To64Percentage = (p15_64.toDouble() / tot) * 100.0,
                            age65PlusPercentage = (p65.toDouble() / tot) * 100.0,
                            dependencyRatio = if (p15_64 > 0) ((p0_14 + p65).toDouble() / p15_64) * 100.0 else null
                        )
                    } else null

                    _uiState.value = _uiState.value.copy(
                        compareBrackets = brackets,
                        compareGender = gender,
                        compareStructure = structure
                    )
                }
            }
        }
    }
}
