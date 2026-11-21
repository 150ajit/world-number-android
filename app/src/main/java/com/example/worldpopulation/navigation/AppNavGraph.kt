package com.example.worldpopulation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.example.worldpopulation.presentation.category.CategoryDetailScreen
import com.example.worldpopulation.presentation.category.CategoryDetailViewModel
import com.example.worldpopulation.presentation.compare.CompareCountriesScreen
import com.example.worldpopulation.presentation.compare.CompareCountriesViewModel
import com.example.worldpopulation.presentation.countries.CountriesScreen
import com.example.worldpopulation.presentation.countries.CountriesViewModel
import com.example.worldpopulation.presentation.countrydetails.CountryDetailsScreen
import com.example.worldpopulation.presentation.countrydetails.CountryDetailsViewModel
import com.example.worldpopulation.presentation.datasource.DataSourceInfoScreen
import com.example.worldpopulation.presentation.home.HomeScreen
import com.example.worldpopulation.presentation.home.HomeViewModel
import com.example.worldpopulation.presentation.home.HomeViewTab
import com.example.worldpopulation.presentation.methodology.MethodologyScreen
import com.example.worldpopulation.presentation.pyramid.PopulationPyramidScreen
import com.example.worldpopulation.presentation.pyramid.PyramidViewModel
import com.example.worldpopulation.presentation.saved.SavedItemsScreen
import com.example.worldpopulation.presentation.saved.SavedItemsViewModel
import com.example.worldpopulation.presentation.settings.SettingsScreen
import com.example.worldpopulation.presentation.settings.SettingsViewModel
import com.example.worldpopulation.presentation.stories.DataStoriesScreen
import com.example.worldpopulation.presentation.stories.DataStoriesViewModel

@Composable
fun AppNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val configuration = LocalConfiguration.current
    val isTablet = configuration.screenWidthDp >= 600

    val showBottomBar = currentRoute in listOf(
        Screen.Home.route,
        Screen.Explore.route,
        "countries",
        Screen.Compare.route,
        Screen.Saved.route
    )

    if (isTablet && showBottomBar) {
        // Tablet Navigation Rail
        Row(modifier = Modifier.fillMaxSize()) {
            NavigationRail(
                containerColor = Color(0xFF080C16),
                contentColor = Color(0xFF38BDF8)
            ) {
                BottomNavItems.forEach { screen ->
                    val selected = currentRoute == screen.route || (screen == Screen.Explore && currentRoute == "countries")
                    NavigationRailItem(
                        selected = selected,
                        onClick = {
                            val targetRoute = screen.route
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
                            selectedIconColor = Color(0xFF38BDF8),
                            unselectedIconColor = Color(0xFF94A3B8),
                            selectedTextColor = Color(0xFF38BDF8),
                            unselectedTextColor = Color(0xFF94A3B8),
                            indicatorColor = Color(0xFF101728)
                        )
                    )
                }
            }

            Box(modifier = Modifier.weight(1f)) {
                NavHostContent(navController)
            }
        }
    } else {
        // Phone Layout with Fixed Bottom Navigation Bar matching reference design
        Scaffold(
            bottomBar = {
                if (showBottomBar) {
                    NavigationBar(
                        containerColor = Color(0xFF080C16),
                        tonalElevation = 8.dp,
                        modifier = Modifier.height(68.dp)
                    ) {
                        BottomNavItems.forEach { screen ->
                            val selected = currentRoute == screen.route || (screen == Screen.Explore && currentRoute == "countries")
                            NavigationBarItem(
                                selected = selected,
                                onClick = {
                                    val targetRoute = screen.route
                                    navController.navigate(targetRoute) {
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Column(
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.padding(top = 2.dp)
                                    ) {
                                        screen.icon?.let {
                                            Icon(
                                                imageVector = it,
                                                contentDescription = screen.title,
                                                tint = if (selected) Color(0xFF38BDF8) else Color(0xFF64748B),
                                                modifier = Modifier.size(24.dp)
                                            )
                                        }
                                        if (selected) {
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Box(
                                                modifier = Modifier
                                                    .width(18.dp)
                                                    .height(2.dp)
                                                    .background(Color(0xFF38BDF8), shape = RoundedCornerShape(1.dp))
                                            )
                                        } else {
                                            Spacer(modifier = Modifier.height(6.dp))
                                        }
                                    }
                                },
                                label = {
                                    Text(
                                        text = screen.title,
                                        color = if (selected) Color(0xFF38BDF8) else Color(0xFF64748B),
                                        fontSize = 11.sp,
                                        fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = Color(0xFF38BDF8),
                                    unselectedIconColor = Color(0xFF64748B),
                                    selectedTextColor = Color(0xFF38BDF8),
                                    unselectedTextColor = Color(0xFF64748B),
                                    indicatorColor = Color.Transparent
                                )
                            )
                        }
                    }
                }
            },
            containerColor = Color(0xFF080C16)
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
                onCountryClick = { iso -> navController.navigate(Screen.CountryDetails.createRoute(iso)) },
                onCategoryClick = { categoryId -> navController.navigate(Screen.CategoryDetails.createRoute(categoryId)) },
                onMapClick = { vm.selectTab(HomeViewTab.MAP) },
                onCompareClick = { navController.navigate(Screen.Compare.route) },
                onRankingsClick = { navController.navigate(Screen.Explore.route) },
                onStoriesClick = { navController.navigate(Screen.Stories.route) },
                onSettingsClick = { navController.navigate(Screen.Settings.route) }
            )
        }

        composable(Screen.Explore.route) {
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

        composable(Screen.Saved.route) {
            val vm: SavedItemsViewModel = hiltViewModel()
            SavedItemsScreen(
                viewModel = vm,
                onCountryClick = { iso -> navController.navigate(Screen.CountryDetails.createRoute(iso)) }
            )
        }

        composable(Screen.Settings.route) {
            val vm: SettingsViewModel = hiltViewModel()
            SettingsScreen(
                viewModel = vm,
                onNavigateMethodology = { navController.navigate(Screen.Methodology.route) },
                onNavigateDataSourceInfo = { navController.navigate(Screen.DataSourceInfo.route) },
                onNavigateSaved = { navController.navigate(Screen.Saved.route) },
                onNavigateStories = { navController.navigate(Screen.Stories.route) }
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

        composable(
            route = Screen.CategoryDetails.route,
            arguments = listOf(navArgument("categoryId") { type = NavType.StringType })
        ) {
            val vm: CategoryDetailViewModel = hiltViewModel()
            CategoryDetailScreen(
                viewModel = vm,
                onBackClick = { navController.popBackStack() },
                onCountryClick = { iso -> navController.navigate(Screen.CountryDetails.createRoute(iso)) }
            )
        }

        composable(Screen.Stories.route) {
            val vm: DataStoriesViewModel = hiltViewModel()
            DataStoriesScreen(
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
