package com.example.worldpopulation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Public
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Home : Screen("home", "World", Icons.Default.Public)
    object Countries : Screen("countries", "Countries", Icons.Default.Language)
    object Pyramid : Screen("pyramid?isoCode={isoCode}", "Pyramid", Icons.Default.BarChart) {
        fun createRoute(isoCode: String = "IND"): String = "pyramid?isoCode=$isoCode"
    }
    object Compare : Screen("compare", "Compare", Icons.AutoMirrored.Filled.CompareArrows)
    object Settings : Screen("settings", "More", Icons.Default.MoreHoriz)
    
    // Sub-screens
    object CountryDetails : Screen("country/{isoCode}", "Details") {
        fun createRoute(isoCode: String): String = "country/$isoCode"
    }
    object Methodology : Screen("methodology", "Methodology")
    object DataSourceInfo : Screen("data_source_info", "Data Sources")
}

val BottomNavItems = listOf(
    Screen.Home,
    Screen.Countries,
    Screen.Pyramid,
    Screen.Compare,
    Screen.Settings
)
