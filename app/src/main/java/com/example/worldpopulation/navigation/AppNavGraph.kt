package com.example.worldpopulation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.worldpopulation.presentation.compare.CompareCountriesScreen
import com.example.worldpopulation.presentation.compare.CompareCountriesViewModel
import com.example.worldpopulation.presentation.countries.CountriesScreen
import com.example.worldpopulation.presentation.countries.CountriesViewModel
import com.example.worldpopulation.presentation.countrydetails.CountryDetailsScreen
import com.example.worldpopulation.presentation.countrydetails.CountryDetailsViewModel
import com.example.worldpopulation.presentation.datasource.DataSourceInfoScreen
import com.example.worldpopulation.presentation.home.HomeScreen
import com.example.worldpopulation.presentation.home.HomeViewModel
import com.example.worldpopulation.presentation.methodology.MethodologyScreen
import com.example.worldpopulation.presentation.pyramid.PopulationPyramidScreen
import com.example.worldpopulation.presentation.pyramid.PyramidViewModel
import com.example.worldpopulation.presentation.settings.SettingsScreen
import com.example.worldpopulation.presentation.settings.SettingsViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val configuration = LocalConfiguration.current
    val isTablet = configuration.screenWidthDp >= 600

    val showBottomBar = BottomNavItems.any { it.route == currentRoute }

    if (isTablet && showBottomBar) {
        // Tablet Navigation Rail
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationRail(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                BottomNavItems.forEach { screen ->
                    val selected = currentRoute == screen.route
                    NavigationRailItem(
                        selected = selected,
                        onClick = {
                            val targetRoute = if (screen == Screen.Pyramid) Screen.Pyramid.createRoute("IND") else screen.route
                            navController.navigate(targetRoute) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            screen.icon?.let { Icon(it, contentDescription = screen.title) }
                        },
                        label = { Text(screen.title) },
                        colors = NavigationRailItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            }

            Box(modifier = Modifier.weight(1f)) {
                NavHostContent(navController)
            }
        }
    } else {
        // Phone Layout with Bottom Navigation Bar
        Scaffold(
            bottomBar = {
                if (showBottomBar) {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        tonalElevation = 8.dp
                    ) {
                        BottomNavItems.forEach { screen ->
                            val selected = currentRoute == screen.route
                            NavigationBarItem(
                                selected = selected,
                                onClick = {
                                    val targetRoute = if (screen == Screen.Pyramid) Screen.Pyramid.createRoute("IND") else screen.route
                                    navController.navigate(targetRoute) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    screen.icon?.let { Icon(it, contentDescription = screen.title) }
                                },
                                label = { Text(screen.title) },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primary
                                )
                            )
                        }
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                NavHostContent(navController)
            }
        }
    }
}

@Composable
private fun NavHostContent(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            val vm: HomeViewModel = hiltViewModel()
            HomeScreen(
                viewModel = vm,
                onCountryClick = { iso -> navController.navigate(Screen.CountryDetails.createRoute(iso)) }
            )
        }

        composable(Screen.Countries.route) {
            val vm: CountriesViewModel = hiltViewModel()
            CountriesScreen(
                viewModel = vm,
                onCountryClick = { iso -> navController.navigate(Screen.CountryDetails.createRoute(iso)) }
            )
        }

        composable(
            route = Screen.Pyramid.route,
            arguments = listOf(
                navArgument("isoCode") {
                    type = NavType.StringType
                    defaultValue = "IND"
                }
            )
        ) {
            val vm: PyramidViewModel = hiltViewModel()
            PopulationPyramidScreen(viewModel = vm)
        }

        composable(Screen.Compare.route) {
            val vm: CompareCountriesViewModel = hiltViewModel()
            CompareCountriesScreen(viewModel = vm)
        }

        composable(Screen.Settings.route) {
            val vm: SettingsViewModel = hiltViewModel()
            SettingsScreen(
                viewModel = vm,
                onNavigateMethodology = { navController.navigate(Screen.Methodology.route) },
                onNavigateDataSourceInfo = { navController.navigate(Screen.DataSourceInfo.route) }
            )
        }

        composable(
            route = Screen.CountryDetails.route,
            arguments = listOf(navArgument("isoCode") { type = NavType.StringType })
        ) {
            val vm: CountryDetailsViewModel = hiltViewModel()
            CountryDetailsScreen(
                viewModel = vm,
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(Screen.Methodology.route) {
            MethodologyScreen(onBackClick = { navController.popBackStack() })
        }

        composable(Screen.DataSourceInfo.route) {
            val settingsVm: SettingsViewModel = hiltViewModel()
            val state by settingsVm.uiState.collectAsState()
            DataSourceInfoScreen(
                metadataList = state.metadataList,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
