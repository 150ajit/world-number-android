package com.example.worldpopulation.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.data.local.entity.DataStoryEntity
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.estimator.LivePopulationEngine
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.domain.model.WorldPopulation
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

enum class HomeViewTab {
    TABLE,
    MAP,
    CHART
}

data class HomeUiState(
    val worldPopulation: WorldPopulation? = null,
    val liveWorldCount: Long = 0L,
    val liveBirthsToday: Long = 0L,
    val liveDeathsToday: Long = 0L,
    val liveGrowthToday: Long = 0L,
    val countries: List<CountryPopulation> = emptyList(),
    val historicalData: List<HistoricalPopulation> = emptyList(),
    val categories: List<CategoryEntity> = com.example.worldpopulation.data.local.DefaultCategories.list,
    val todayDiscovery: DailyDiscoveryEntity? = null,
    val dataStories: List<DataStoryEntity> = emptyList(),
    val searchQuery: String = "",
    val selectedTab: HomeViewTab = HomeViewTab.TABLE,
    val selectedYear: Int = 2026,
    val lastSyncTimestamp: Long = 0L,
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL,
    val animateLiveNumbers: Boolean = true,
    val isLoading: Boolean = false
) {
    val displayedCategories: List<CategoryEntity>
        get() = if (searchQuery.isBlank()) {
            categories
        } else {
            categories.filter {
                it.name.contains(searchQuery, ignoreCase = true) ||
                it.summary.contains(searchQuery, ignoreCase = true) ||
                it.headlineStatistic.contains(searchQuery, ignoreCase = true)
            }
        }
}

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PopulationRepository,
    private val liveEngine: LivePopulationEngine,
    private val preferencesRepository: UserPreferencesRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.ensureDatabaseInitialized()
        }

        liveEngine.start(viewModelScope)

        // Observe Room cached world data
        viewModelScope.launch {
            repository.getWorldPopulation().collect { world ->
                _uiState.value = _uiState.value.copy(
                    worldPopulation = world,
                    liveWorldCount = liveEngine.calculateLiveWorldPopulation(world)
                )
            }
        }

        // Observe country populations
        viewModelScope.launch {
            repository.getCountryPopulations().collect { list ->
                _uiState.value = _uiState.value.copy(countries = list)
            }
        }

        // Observe all 20 categories
        viewModelScope.launch {
            repository.getAllCategories().collect { catList ->
                if (catList.isNotEmpty()) {
                    _uiState.value = _uiState.value.copy(categories = catList)
                }
            }
        }

        // Observe today's discovery fact
        val dayOfYear = Calendar.getInstance().get(Calendar.DAY_OF_YEAR)
        viewModelScope.launch {
            // Map 1-365 into available facts deterministic range
            val lookupDay = ((dayOfYear - 1) % 16) + 1
            repository.getDailyDiscovery(lookupDay).collect { fact ->
                _uiState.value = _uiState.value.copy(todayDiscovery = fact)
            }
        }

        // Observe data stories
        viewModelScope.launch {
            repository.getDataStories().collect { stories ->
                _uiState.value = _uiState.value.copy(dataStories = stories)
            }
        }

        // Observe historical world data for charts
        viewModelScope.launch {
            repository.getHistoricalPopulations("WLD").collect { history ->
                _uiState.value = _uiState.value.copy(historicalData = history)
            }
        }

        // Observe user preferences
        viewModelScope.launch {
            combine(
                preferencesRepository.numberFormat,
                preferencesRepository.liveAnimationEnabled,
                preferencesRepository.lastSyncTimestamp
            ) { format, animate, lastSync ->
                Triple(format, animate, lastSync)
            }.collect { (format, animate, lastSync) ->
                _uiState.value = _uiState.value.copy(
                    numberFormat = format,
                    animateLiveNumbers = animate,
                    lastSyncTimestamp = lastSync
                )
            }
        }

        // 1-second in-memory live calculations
        viewModelScope.launch {
            liveEngine.currentTimestamp.collect { now ->
                val currentWorld = _uiState.value.worldPopulation
                if (currentWorld != null) {
                    val count = liveEngine.calculateLiveWorldPopulation(currentWorld, now)
                    val births = liveEngine.calculateBirthsToday(132_586_000.0, now)
                    val deaths = liveEngine.calculateDeathsToday(62_480_000.0, now)
                    val growth = liveEngine.calculateGrowthToday(70_106_000.0, now)

                    _uiState.value = _uiState.value.copy(
                        liveWorldCount = count,
                        liveBirthsToday = births,
                        liveDeathsToday = deaths,
                        liveGrowthToday = growth
                    )
                }
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(searchQuery = query)
    }

    fun selectTab(tab: HomeViewTab) {
        _uiState.value = _uiState.value.copy(selectedTab = tab)
    }

    fun selectYear(year: Int) {
        _uiState.value = _uiState.value.copy(selectedYear = year)
    }

    override fun onCleared() {
        super.onCleared()
        liveEngine.stop()
    }
}
