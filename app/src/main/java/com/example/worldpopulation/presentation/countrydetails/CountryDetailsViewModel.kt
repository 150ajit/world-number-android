package com.example.worldpopulation.presentation.countrydetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.estimator.LivePopulationEngine
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.domain.model.BroadAgeStructure
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.DemographicIndicator
import com.example.worldpopulation.domain.model.GenderDistribution
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.UrbanRuralPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class CountryDetailTab {
    OVERVIEW,
    DEMOGRAPHICS,
    HISTORY,
    PROJECTION
}

data class CountryDetailsUiState(
    val isoCode: String = "",
    val country: CountryPopulation? = null,
    val livePopulation: Long = 0L,
    val worldPopulation: WorldPopulation? = null,
    val selectedTab: CountryDetailTab = CountryDetailTab.OVERVIEW,
    val selectedYear: Int = 2026,
    val availableYears: List<Int> = emptyList(),
    val ageGenderBrackets: List<AgeGenderPopulation> = emptyList(),
    val genderDistribution: GenderDistribution? = null,
    val broadAgeStructure: BroadAgeStructure? = null,
    val indicators: List<DemographicIndicator> = emptyList(),
    val historicalList: List<HistoricalPopulation> = emptyList(),
    val projectionList: List<HistoricalPopulation> = emptyList(),
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL,
    val animateLiveNumbers: Boolean = true,
    val isLoading: Boolean = false
)

@HiltViewModel
class CountryDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: PopulationRepository,
    private val liveEngine: LivePopulationEngine,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val isoCode: String = checkNotNull(savedStateHandle["isoCode"])

    private val _uiState = MutableStateFlow(CountryDetailsUiState(isoCode = isoCode))
    val uiState: StateFlow<CountryDetailsUiState> = _uiState.asStateFlow()

    init {
        liveEngine.start(viewModelScope)

        // Observe country details
        viewModelScope.launch {
            repository.getCountryDetails(isoCode).collect { country ->
                if (country != null) {
                    _uiState.value = _uiState.value.copy(
                        country = country,
                        livePopulation = liveEngine.calculateLiveCountryPopulation(country)
                    )
                }
            }
        }

        // Observe world population for share calculation
        viewModelScope.launch {
            repository.getWorldPopulation().collect { world ->
                _uiState.value = _uiState.value.copy(worldPopulation = world)
            }
        }

        // Observe available years for pyramid/demographics
        viewModelScope.launch {
            repository.getAvailableYears(isoCode).collect { years ->
                val yearList = if (years.isEmpty()) listOf(2026) else years
                val defaultYear = if (yearList.contains(2026)) 2026 else yearList.first()
                _uiState.value = _uiState.value.copy(
                    availableYears = yearList,
                    selectedYear = defaultYear
                )
                loadYearData(defaultYear)
            }
        }

        // Observe history & projection
        viewModelScope.launch {
            repository.getHistoricalPopulations(isoCode).collect { list ->
                val hist = list.filter { it.year <= 2024 }
                val proj = list.filter { it.year >= 2024 }
                _uiState.value = _uiState.value.copy(
                    historicalList = hist,
                    projectionList = proj
                )
            }
        }

        // Preferences
        viewModelScope.launch {
            preferencesRepository.numberFormat.collect { format ->
                _uiState.value = _uiState.value.copy(numberFormat = format)
            }
        }

        // Live engine ticking for country live population
        viewModelScope.launch {
            liveEngine.currentTimestamp.collect { now ->
                val country = _uiState.value.country
                if (country != null) {
                    val livePop = liveEngine.calculateLiveCountryPopulation(country, now)
                    _uiState.value = _uiState.value.copy(livePopulation = livePop)
                }
            }
        }
    }

    fun selectTab(tab: CountryDetailTab) {
        _uiState.value = _uiState.value.copy(selectedTab = tab)
    }

    fun selectYear(year: Int) {
        _uiState.value = _uiState.value.copy(selectedYear = year)
        loadYearData(year)
    }

    private fun loadYearData(year: Int) {
        viewModelScope.launch {
            repository.getAgeGenderDistribution(isoCode, year).collect { brackets ->
                val maleSum = brackets.sumOf { it.malePopulation ?: 0L }
                val femaleSum = brackets.sumOf { it.femalePopulation ?: 0L }
                val total = maleSum + femaleSum

                val gender = if (total > 0) {
                    val mPct = (maleSum.toDouble() / total) * 100.0
                    val fPct = (femaleSum.toDouble() / total) * 100.0
                    GenderDistribution(
                        isoCode = isoCode,
                        year = year,
                        malePopulation = maleSum,
                        femalePopulation = femaleSum,
                        totalPopulation = total,
                        malePercentage = mPct,
                        femalePercentage = fPct
                    )
                } else null

                // Age structure 0-14, 15-64, 65+
                val structure = if (total > 0) {
                    val pop0_14 = brackets.filter { it.ageStart < 15 }.sumOf { it.totalPopulation }
                    val pop15_64 = brackets.filter { it.ageStart in 15..64 }.sumOf { it.totalPopulation }
                    val pop65Plus = brackets.filter { it.ageStart >= 65 }.sumOf { it.totalPopulation }

                    val p0_14 = (pop0_14.toDouble() / total) * 100.0
                    val p15_64 = (pop15_64.toDouble() / total) * 100.0
                    val p65Plus = (pop65Plus.toDouble() / total) * 100.0

                    val depRatio = if (pop15_64 > 0) {
                        ((pop0_14 + pop65Plus).toDouble() / pop15_64) * 100.0
                    } else null

                    BroadAgeStructure(
                        isoCode = isoCode,
                        year = year,
                        age0To14Percentage = p0_14,
                        age15To64Percentage = p15_64,
                        age65PlusPercentage = p65Plus,
                        dependencyRatio = depRatio
                    )
                } else null

                _uiState.value = _uiState.value.copy(
                    ageGenderBrackets = brackets,
                    genderDistribution = gender,
                    broadAgeStructure = structure
                )
            }
        }

        viewModelScope.launch {
            repository.getDemographicIndicators(isoCode, year).collect { list ->
                _uiState.value = _uiState.value.copy(indicators = list)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        liveEngine.stop()
    }
}
