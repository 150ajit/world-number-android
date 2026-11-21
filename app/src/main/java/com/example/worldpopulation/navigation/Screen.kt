package com.example.worldpopulation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Explore : Screen("countries", "Explore", Icons.Default.Explore)
    object Compare : Screen("compare", "Compare", Icons.Default.Balance)
    object Saved : Screen("saved", "Saved", Icons.Default.Bookmark)
    
    // Sub-screens & other routes
    object Countries : Screen("countries", "Countries", Icons.Default.Language)
    object Pyramid : Screen("pyramid?isoCode={isoCode}", "Pyramid", Icons.Default.BarChart) {
        fun createRoute(isoCode: String = "IND"): String = "pyramid?isoCode=$isoCode"
    }
    object Settings : Screen("settings", "Settings", Icons.Default.Settings)
    object CountryDetails : Screen("country/{isoCode}", "Details") {
        fun createRoute(isoCode: String): String = "country/$isoCode"
    }
    object CategoryDetails : Screen("category/{categoryId}", "Category") {
        fun createRoute(categoryId: String): String = "category/$categoryId"
    }
    object Stories : Screen("stories", "Stories", Icons.Default.AutoAwesome)
    object Methodology : Screen("methodology", "Methodology")
    object DataSourceInfo : Screen("data_source_info", "Data Sources")
}

val BottomNavItems = listOf(
    Screen.Home,
    Screen.Explore,
    Screen.Compare,
    Screen.Saved
)
