package com.example.worldpopulation.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.worldpopulation.util.NumberFormatType
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

enum class AppThemeMode {
    SYSTEM,
    LIGHT,
    DARK
}

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_settings")

@Singleton
class UserPreferencesRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private object Keys {
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val NUMBER_FORMAT = stringPreferencesKey("number_format")
        val LIVE_ANIMATION = booleanPreferencesKey("live_animation_enabled")
        val LAST_SYNC = longPreferencesKey("last_sync_timestamp")
    }

    val themeMode: Flow<AppThemeMode> = context.dataStore.data.map { preferences ->
        when (preferences[Keys.THEME_MODE]) {
            AppThemeMode.LIGHT.name -> AppThemeMode.LIGHT
            AppThemeMode.DARK.name -> AppThemeMode.DARK
            else -> AppThemeMode.DARK // Default dark theme as requested in Section 9 & 48
        }
    }

    val numberFormat: Flow<NumberFormatType> = context.dataStore.data.map { preferences ->
        when (preferences[Keys.NUMBER_FORMAT]) {
            NumberFormatType.INDIAN.name -> NumberFormatType.INDIAN
            else -> NumberFormatType.INTERNATIONAL
        }
    }

    val liveAnimationEnabled: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[Keys.LIVE_ANIMATION] ?: true
    }

    val lastSyncTimestamp: Flow<Long> = context.dataStore.data.map { preferences ->
        preferences[Keys.LAST_SYNC] ?: System.currentTimeMillis()
    }

    suspend fun setThemeMode(mode: AppThemeMode) {
        context.dataStore.edit { preferences ->
            preferences[Keys.THEME_MODE] = mode.name
        }
    }

    suspend fun setNumberFormat(format: NumberFormatType) {
        context.dataStore.edit { preferences ->
            preferences[Keys.NUMBER_FORMAT] = format.name
        }
    }

    suspend fun setLiveAnimationEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[Keys.LIVE_ANIMATION] = enabled
        }
    }

    suspend fun setLastSyncTimestamp(timestamp: Long) {
        context.dataStore.edit { preferences ->
            preferences[Keys.LAST_SYNC] = timestamp
        }
    }
}
