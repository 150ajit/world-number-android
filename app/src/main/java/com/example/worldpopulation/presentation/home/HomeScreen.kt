package com.example.worldpopulation.presentation.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.R
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.ui.components.CategoryGrid
import com.example.worldpopulation.ui.components.GlobalSearchBar
import com.example.worldpopulation.ui.components.PopulationHistoryChart
import com.example.worldpopulation.ui.components.QuickActionRow
import com.example.worldpopulation.ui.components.TodayDiscoveryCard
import com.example.worldpopulation.ui.components.WorldPopulationHeroCard
import com.example.worldpopulation.ui.components.WorldPopulationMap
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.EmeraldGreen
import com.example.worldpopulation.ui.theme.RoseRed
import com.example.worldpopulation.util.NumberFormatType
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onCountryClick: (String) -> Unit,
    onCategoryClick: (String) -> Unit = {},
    onMapClick: () -> Unit = {},
    onCompareClick: () -> Unit = {},
    onRankingsClick: () -> Unit = {},
    onStoriesClick: () -> Unit = {},
    onSettingsClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    val shareFact: (DailyDiscoveryEntity) -> Unit = { fact ->
        val text = "🌍 World Number Discovery:\n\n${fact.headline}\n${fact.stat}\n\n${fact.detail}\n\nSource: ${fact.source}\nDiscover the world through numbers with World Number."
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, text)
            type = "text/plain"
        }
        context.startActivity(Intent.createChooser(sendIntent, "Share Global Discovery"))
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF080C16))
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Top Bar: App Logo, World Number title, subtitle, Search & Settings icons
        item {
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.app_logo),
                        contentDescription = "World Number logo",
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "World ",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 21.sp,
                                letterSpacing = (-0.3).sp
                            )
                            Text(
                                text = "Number",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF38BDF8),
                                fontSize = 21.sp,
                                letterSpacing = (-0.3).sp
                            )
                        }
                        Text(
                            text = "Discover the World Through Numbers",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFF94A3B8),
                            fontSize = 11.5.sp
                        )
                    }
                }

                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = { viewModel.onSearchQueryChange(state.searchQuery) },
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(4.dp))
                    IconButton(
                        onClick = onSettingsClick,
                        modifier = Modifier.size(36.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings",
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
            }
        }

        // 2. Global Search Bar (Pill design matching screenshot)
        item {
            GlobalSearchBar(
                query = state.searchQuery,
                onQueryChange = { viewModel.onSearchQueryChange(it) },
                placeholderText = "Search countries, categories, or facts..."
            )
        }

        // 3. Featured World Population Hero Card
        if (state.searchQuery.isBlank()) {
            item {
                WorldPopulationHeroCard(
                    liveCount = state.liveWorldCount,
                    birthsToday = state.liveBirthsToday,
                    deathsToday = state.liveDeathsToday,
                    growthToday = state.liveGrowthToday,
                    formatType = state.numberFormat,
                    onViewDetailsClick = onRankingsClick
                )
            }
        }

        // 4. Today's Global Discovery Card
        if (state.searchQuery.isBlank()) {
            item {
                TodayDiscoveryCard(
                    discovery = state.todayDiscovery,
                    onShareClick = shareFact,
                    onSeeMoreClick = onStoriesClick
                )
            }
        }

        // 5. Two Quick-Action Cards Side-by-Side: Explore the World & Compare Countries
        if (state.searchQuery.isBlank()) {
            item {
                QuickActionRow(
                    onMapClick = onMapClick,
                    onCompareClick = onCompareClick
                )
            }
        }

        // 6. Explore 20 Global Categories Section Header
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.GridView,
                            contentDescription = null,
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(19.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = if (state.searchQuery.isBlank()) "Explore 20 Global Categories" else "Matching Categories",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 15.sp
                        )
                    }

                    Row(
                        modifier = Modifier.clickable { onCategoryClick("population") },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "View All",
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFF38BDF8),
                            fontSize = 12.sp
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "View All",
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                CategoryGrid(
                    categories = state.displayedCategories,
                    onCategoryClick = onCategoryClick
                )
            }
        }

        // 7. Dynamic Tabs for Demographics: TABLE | MAP | CHART
        if (state.searchQuery.isBlank()) {
            item {
                Spacer(modifier = Modifier.height(6.dp))
                TabRow(
                    selectedTabIndex = state.selectedTab.ordinal,
                    containerColor = Color(0xFF101728),
                    contentColor = Color(0xFF38BDF8),
                    indicator = { tabPositions ->
                        TabRowDefaults.SecondaryIndicator(
                            Modifier.tabIndicatorOffset(tabPositions[state.selectedTab.ordinal]),
                            color = Color(0xFF38BDF8)
                        )
                    },
                    modifier = Modifier.clip(RoundedCornerShape(10.dp))
                ) {
                    Tab(
                        selected = state.selectedTab == HomeViewTab.TABLE,
                        onClick = { viewModel.selectTab(HomeViewTab.TABLE) },
                        text = { Text("TABLE", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                    Tab(
                        selected = state.selectedTab == HomeViewTab.MAP,
                        onClick = { viewModel.selectTab(HomeViewTab.MAP) },
                        text = { Text("MAP", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                    Tab(
                        selected = state.selectedTab == HomeViewTab.CHART,
                        onClick = { viewModel.selectTab(HomeViewTab.CHART) },
                        text = { Text("CHART", fontWeight = FontWeight.Bold, fontSize = 12.sp) }
                    )
                }
            }

            // Year Selector Controls (< 2026 >)
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when (state.selectedTab) {
                            HomeViewTab.TABLE -> "TOP COUNTRIES"
                            HomeViewTab.MAP -> "WORLD POPULATION TIERS"
                            HomeViewTab.CHART -> "HISTORICAL & PROJECTION TREND"
                        },
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFFE2E8F0),
                        letterSpacing = 1.sp
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFF101728))
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                    ) {
                        IconButton(
                            onClick = { viewModel.selectYear(state.selectedYear - 1) },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(Icons.Default.ChevronLeft, contentDescription = "Previous Year", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                        Text(
                            text = "${state.selectedYear}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF38BDF8),
                            modifier = Modifier.padding(horizontal = 6.dp)
                        )
                        IconButton(
                            onClick = { viewModel.selectYear(state.selectedYear + 1) },
                            modifier = Modifier.size(28.dp)
                        ) {
                            Icon(Icons.Default.ChevronRight, contentDescription = "Next Year", tint = Color.White, modifier = Modifier.size(18.dp))
                        }
                    }
                }
            }

            // Dynamic Tab Content
            when (state.selectedTab) {
                HomeViewTab.TABLE -> {
                    itemsIndexed(
                        items = state.countries.take(20),
                        key = { _, country -> country.isoCode }
                    ) { index, country ->
                        CountryListItem(
                            rank = index + 1,
                            country = country,
                            formatType = state.numberFormat,
                            onClick = { onCountryClick(country.isoCode) }
                        )
                    }
                }
                HomeViewTab.MAP -> {
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF101728)),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = "GLOBAL POPULATION DENSITY & TIERS",
                                    style = MaterialTheme.typography.labelSmall,
                                    letterSpacing = 1.sp,
                                    color = Color(0xFF94A3B8)
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                WorldPopulationMap(
                                    countries = state.countries,
                                    onCountryClick = onCountryClick,
                                    formatType = state.numberFormat
                                )
                            }
                        }
                    }
                }
                HomeViewTab.CHART -> {
                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF101728)),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Text(
                                    text = "WORLD POPULATION TRAJECTORY (1950 – 2100)",
                                    style = MaterialTheme.typography.labelSmall,
                                    letterSpacing = 1.sp,
                                    color = Color(0xFF94A3B8)
                                )
                                Spacer(modifier = Modifier.height(10.dp))
                                PopulationHistoryChart(
                                    data = state.historicalData
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun CountryListItem(
    rank: Int,
    country: CountryPopulation,
    formatType: NumberFormatType,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF101728)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Rank
            Text(
                text = "$rank",
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF64748B),
                modifier = Modifier.width(28.dp)
            )

            // Flag
            Text(
                text = country.flagEmoji,
                fontSize = 20.sp,
                modifier = Modifier.padding(end = 12.dp)
            )

            // Name & Region
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = country.countryName,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
                Text(
                    text = "${country.region ?: ""} • ${country.subregion ?: ""}",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color(0xFF94A3B8),
                    fontSize = 11.sp
                )
            }

            // Population & Growth Rate
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = NumberFormatter.format(country.population, formatType),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                country.growthRate?.let { rate ->
                    val isPositive = rate >= 0
                    Text(
                        text = "${if (isPositive) "+" else ""}${String.format("%.2f%%", rate)}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isPositive) EmeraldGreen else RoseRed
                    )
                }
            }

            Spacer(modifier = Modifier.width(6.dp))

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Country details",
                tint = Color(0xFF64748B),
                modifier = Modifier.size(18.dp)
            )
        }
    }
}
