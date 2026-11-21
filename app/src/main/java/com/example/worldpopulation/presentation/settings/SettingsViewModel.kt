package com.example.worldpopulation.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldpopulation.data.local.preferences.AppThemeMode
import com.example.worldpopulation.data.local.preferences.UserPreferencesRepository
import com.example.worldpopulation.domain.model.DataSourceMetadata
import com.example.worldpopulation.domain.repository.PopulationRepository
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import javax.inject.Inject

data class SettingsUiState(
    val themeMode: AppThemeMode = AppThemeMode.DARK,
    val numberFormat: NumberFormatType = NumberFormatType.INTERNATIONAL,
    val liveAnimationEnabled: Boolean = true,
    val lastSyncTimestamp: Long = 0L,
    val isSyncing: Boolean = false,
    val syncMessage: String? = null,
    val metadataList: List<DataSourceMetadata> = emptyList()
)

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val preferencesRepository: UserPreferencesRepository,
    private val repository: PopulationRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(SettingsUiState())
    val uiState: StateFlow<SettingsUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                preferencesRepository.themeMode,
                preferencesRepository.numberFormat,
                preferencesRepository.liveAnimationEnabled,
                preferencesRepository.lastSyncTimestamp
            ) { theme, format, animation, lastSync ->
                _uiState.value = _uiState.value.copy(
                    themeMode = theme,
                    numberFormat = format,
                    liveAnimationEnabled = animation,
                    lastSyncTimestamp = lastSync
                )
            }.collect {}
        }

        viewModelScope.launch {
            repository.getDataSourceMetadata().collect { list ->
                _uiState.value = _uiState.value.copy(metadataList = list)
            }
        }
    }

    fun setThemeMode(mode: AppThemeMode) {
        viewModelScope.launch {
            preferencesRepository.setThemeMode(mode)
        }
    }

    fun setNumberFormat(format: NumberFormatType) {
        viewModelScope.launch {
            preferencesRepository.setNumberFormat(format)
        }
    }

    fun setLiveAnimationEnabled(enabled: Boolean) {
        viewModelScope.launch {
            preferencesRepository.setLiveAnimationEnabled(enabled)
        }
    }

    fun refreshData() {
        if (_uiState.value.isSyncing) return
        _uiState.value = _uiState.value.copy(isSyncing = true, syncMessage = "Synchronizing authoritative data...")

        viewModelScope.launch {
            val result = repository.syncData()
            if (result.isSuccess) {
                val now = System.currentTimeMillis()
                preferencesRepository.setLastSyncTimestamp(now)
                _uiState.value = _uiState.value.copy(
                    isSyncing = false,
                    syncMessage = "Data successfully synchronized."
                )
            } else {
                _uiState.value = _uiState.value.copy(
                    isSyncing = false,
                    syncMessage = "Network sync unavailable. Retaining cached UN WPP estimates."
                )
            }
        }
    }

    fun clearSyncMessage() {
        _uiState.value = _uiState.value.copy(syncMessage = null)
    }
}
