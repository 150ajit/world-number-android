package com.example.worldpopulation.presentation.countrydetails

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.ui.components.BroadAgeStructureCard
import com.example.worldpopulation.ui.components.DemographicIndicatorsGrid
import com.example.worldpopulation.ui.components.GenderDistributionCard
import com.example.worldpopulation.ui.components.LiveCounterDisplay
import com.example.worldpopulation.ui.components.PopulationHistoryChart
import com.example.worldpopulation.ui.components.PopulationPyramidChart
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.EmeraldGreen
import com.example.worldpopulation.ui.theme.RoseRed
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun CountryDetailsScreen(
    viewModel: CountryDetailsViewModel,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    val country = state.country

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // App Bar & Title
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Navigate back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.width(6.dp))
                if (country != null) {
                    Text(
                        text = country.flagEmoji,
                        fontSize = 24.sp
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = country.countryName,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "${country.isoCode} • ${country.region ?: ""} (${country.subregion ?: ""})",
                            fontSize = 11.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    IconButton(onClick = { viewModel.toggleBookmark() }) {
                        Icon(
                            imageVector = if (state.isBookmarked) Icons.Default.Bookmark else Icons.Default.BookmarkBorder,
                            contentDescription = "Save country",
                            tint = if (state.isBookmarked) Color(0xFF38BDF8) else Color(0xFF94A3B8)
                        )
                    }
                }
            }
        }

        // Live Country Counter
        item {
            if (country != null) {
                LiveCounterDisplay(
                    title = country.countryName,
                    population = state.livePopulation,
                    subtitle = "Estimated live country population",
                    formatType = state.numberFormat,
                    animateTransitions = state.animateLiveNumbers
                )
            }
        }

        // Tabs: OVERVIEW | DEMOGRAPHICS | HISTORY | PROJECTION
        item {
            TabRow(
                selectedTabIndex = state.selectedTab.ordinal,
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
                contentColor = MaterialTheme.colorScheme.primary,
                indicator = { tabPositions ->
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[state.selectedTab.ordinal]),
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            ) {
                Tab(
                    selected = state.selectedTab == CountryDetailTab.OVERVIEW,
                    onClick = { viewModel.selectTab(CountryDetailTab.OVERVIEW) },
                    text = { Text("OVERVIEW", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = state.selectedTab == CountryDetailTab.DEMOGRAPHICS,
                    onClick = { viewModel.selectTab(CountryDetailTab.DEMOGRAPHICS) },
                    text = { Text("DEMO", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = state.selectedTab == CountryDetailTab.HISTORY,
                    onClick = { viewModel.selectTab(CountryDetailTab.HISTORY) },
                    text = { Text("HISTORY", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                )
                Tab(
                    selected = state.selectedTab == CountryDetailTab.PROJECTION,
                    onClick = { viewModel.selectTab(CountryDetailTab.PROJECTION) },
                    text = { Text("PROJECTION", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                )
            }
        }

        // Tab Content
        when (state.selectedTab) {
            CountryDetailTab.OVERVIEW -> {
                item {
                    if (country != null) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Column(modifier = Modifier.padding(16.dp)) {
                                Text(
                                    text = "KEY DEMOGRAPHIC METRICS",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    letterSpacing = 1.sp
                                )

                                Spacer(modifier = Modifier.height(14.dp))

                                // World Share & Rank
                                val worldPop = state.worldPopulation?.population ?: 8_203_000_000L
                                val share = (country.population.toDouble() / worldPop) * 100.0

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text("World Population Share", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text(NumberFormatter.formatPercentage(share), style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = CyanAccent)
                                    }
                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("Annual Growth Rate", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        val isPos = (country.growthRate ?: 0.0) >= 0
                                        Text(
                                            "${if (isPos) "+" else ""}${String.format("%.2f%%", country.growthRate ?: 0.0)}",
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold,
                                            color = if (isPos) EmeraldGreen else RoseRed
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text("Population Density", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text("${country.density?.toInt() ?: 0} people/km²", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                                    }
                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("Land Area", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text("${NumberFormatter.format(country.landArea?.toLong() ?: 0L, state.numberFormat)} km²", style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold)
                                    }
                                }

                                Spacer(modifier = Modifier.height(16.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column {
                                        Text("Annual Net Change", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        val change = country.annualChange ?: 0.0
                                        val isPosChange = change >= 0
                                        Text(
                                            "${if (isPosChange) "+" else ""}${NumberFormatter.format(change.toLong(), state.numberFormat)}/yr",
                                            style = MaterialTheme.typography.bodyLarge,
                                            fontWeight = FontWeight.SemiBold,
                                            color = if (isPosChange) EmeraldGreen else RoseRed
                                        )
                                    }
                                    Column(horizontalAlignment = Alignment.End) {
                                        Text("Data Classification", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Text(country.dataType.name, style = MaterialTheme.typography.bodyLarge, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
                                    }
                                }
                            }
                        }
                    }
                }

                // Global Category Indicators Section
                if (state.categoryValues.isNotEmpty()) {
                    item {
                        Spacer(modifier = Modifier.height(6.dp))
                        Text(
                            text = "GLOBAL INDICATORS ACROSS CATEGORIES",
                            style = MaterialTheme.typography.labelSmall,
                            letterSpacing = 1.sp,
                            color = Color(0xFF94A3B8)
                        )
                    }

                    val groupedByCategory = state.categoryValues.groupBy { it.categoryId }
                    groupedByCategory.forEach { (catId, values) ->
                        val cat = state.categoryMap[catId]
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF141923)),
                                border = androidx.compose.foundation.BorderStroke(1.dp, Color(0xFF222B3A))
                            ) {
                                Column(modifier = Modifier.padding(14.dp)) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Icon(
                                            imageVector = com.example.worldpopulation.ui.components.CategoryVisuals.getIcon(catId),
                                            contentDescription = null,
                                            tint = Color(0xFF38BDF8),
                                            modifier = Modifier.size(18.dp)
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Text(
                                            text = cat?.name ?: catId.replace('_', ' ').uppercase(),
                                            style = MaterialTheme.typography.titleSmall,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                    }

                                    Spacer(modifier = Modifier.height(10.dp))

                                    values.forEachIndexed { idx, v ->
                                        if (idx > 0) {
                                            Spacer(modifier = Modifier.height(8.dp))
                                        }
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Text(
                                                text = v.indicatorId.replace('_', ' '),
                                                style = MaterialTheme.typography.bodySmall,
                                                color = Color(0xFFCBD5E1)
                                            )
                                            Text(
                                                text = v.formattedValue ?: "${v.value}",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.Bold,
                                                color = Color(0xFF10B981)
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            CountryDetailTab.DEMOGRAPHICS -> {
                // Year selector for demographics
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "REFERENCE YEAR",
                            style = MaterialTheme.typography.labelSmall,
                            letterSpacing = 1.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .clip(RoundedCornerShape(8.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .padding(horizontal = 4.dp, vertical = 2.dp)
                        ) {
                            val available = state.availableYears
                            val currentIndex = available.indexOf(state.selectedYear)

                            IconButton(
                                onClick = {
                                    if (currentIndex > 0) viewModel.selectYear(available[currentIndex - 1])
                                },
                                enabled = currentIndex > 0,
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(Icons.Default.ChevronLeft, contentDescription = "Prev Year", modifier = Modifier.size(18.dp))
                            }
                            Text(
                                text = "${state.selectedYear}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp)
                            )
                            IconButton(
                                onClick = {
                                    if (currentIndex < available.size - 1) viewModel.selectYear(available[currentIndex + 1])
                                },
                                enabled = currentIndex < available.size - 1,
                                modifier = Modifier.size(28.dp)
                            ) {
                                Icon(Icons.Default.ChevronRight, contentDescription = "Next Year", modifier = Modifier.size(18.dp))
                            }
                        }
                    }
                }

                // Gender Distribution
                item {
                    GenderDistributionCard(
                        distribution = state.genderDistribution,
                        formatType = state.numberFormat
                    )
                }

                // Broad Age Structure
                item {
                    BroadAgeStructureCard(
                        structure = state.broadAgeStructure
                    )
                }

                // Population Pyramid Chart
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "POPULATION PYRAMID (${state.selectedYear})",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                letterSpacing = 1.sp
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            PopulationPyramidChart(
                                brackets = state.ageGenderBrackets,
                                formatType = state.numberFormat
                            )
                        }
                    }
                }

                // Demographic Indicators
                item {
                    DemographicIndicatorsGrid(
                        indicators = state.indicators,
                        formatType = state.numberFormat
                    )
                }
            }

            CountryDetailTab.HISTORY -> {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "HISTORICAL POPULATION",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "United Nations WPP 2024 Estimates (1950–2023)",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            PopulationHistoryChart(data = state.historicalList)
                        }
                    }
                }

                items(state.historicalList) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${item.year}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = NumberFormatter.format(item.population, state.numberFormat),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = item.dataType.name,
                                fontSize = 10.sp,
                                color = EmeraldGreen
                            )
                        }
                    }
                }
            }

            CountryDetailTab.PROJECTION -> {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(14.dp)) {
                            Text(
                                text = "POPULATION PROJECTIONS",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                letterSpacing = 1.sp
                            )
                            Text(
                                text = "UN WPP 2024 Medium Variant Projection",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            PopulationHistoryChart(data = state.projectionList)
                        }
                    }
                }

                items(state.projectionList) { item ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${item.year}",
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = NumberFormatter.format(item.population, state.numberFormat),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "PROJECTION",
                                fontSize = 10.sp,
                                color = CyanAccent
                            )
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
