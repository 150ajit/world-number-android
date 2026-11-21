package com.example.worldpopulation.presentation.category

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.ui.components.CategoryVisuals

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDetailScreen(
    viewModel: CategoryDetailViewModel,
    onBackClick: () -> Unit,
    onCountryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    val category = state.category

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = category?.name ?: "Category Details",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        modifier = modifier
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(paddingValues)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // 1. Category Overview Hero Card
            if (category != null) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF161C26)),
                        border = BorderStroke(1.dp, Color(0xFF263040))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Start
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(12.dp))
                                        .background(Color(0xFF06B6D4).copy(alpha = 0.15f)),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = CategoryVisuals.getIcon(category.id),
                                        contentDescription = null,
                                        tint = Color(0xFF38BDF8),
                                        modifier = Modifier.size(24.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(12.dp))

                                Column {
                                    Text(
                                        text = category.name.uppercase(),
                                        style = MaterialTheme.typography.labelSmall,
                                        letterSpacing = 1.sp,
                                        color = Color(0xFF94A3B8)
                                    )
                                    Text(
                                        text = category.headlineStatistic,
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = Color(0xFF10B981)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = category.summary,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFFCBD5E1),
                                fontSize = 13.sp,
                                lineHeight = 18.sp
                            )

                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = "Authoritative Source: ${category.sourceOrganization}",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF64748B),
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }

            // 2. Indicator Selector Chips
            if (state.indicators.isNotEmpty()) {
                item {
                    Column {
                        Text(
                            text = "AVAILABLE INDICATORS",
                            style = MaterialTheme.typography.labelSmall,
                            letterSpacing = 1.sp,
                            color = Color(0xFF94A3B8)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            items(state.indicators, key = { it.indicatorId }) { ind ->
                                val selected = state.selectedIndicator?.indicatorId == ind.indicatorId
                                FilterChip(
                                    selected = selected,
                                    onClick = { viewModel.selectIndicator(ind) },
                                    label = {
                                        Text(
                                            text = ind.name,
                                            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal,
                                            fontSize = 12.sp
                                        )
                                    },
                                    colors = FilterChipDefaults.filterChipColors(
                                        selectedContainerColor = Color(0xFF0284C7),
                                        selectedLabelColor = Color.White,
                                        containerColor = Color(0xFF1A212E),
                                        labelColor = Color(0xFFCBD5E1)
                                    ),
                                    border = FilterChipDefaults.filterChipBorder(
                                        enabled = true,
                                        selected = selected,
                                        borderColor = Color(0xFF2B3648),
                                        selectedBorderColor = Color(0xFF38BDF8)
                                    )
                                )
                            }
                        }
                    }
                }
            } else {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Loading official category indicators...",
                            color = Color(0xFF94A3B8),
                            fontSize = 13.sp
                        )
                    }
                }
            }

            // 3. Selected Indicator Details Header
            val selectedInd = state.selectedIndicator
            if (selectedInd != null) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = selectedInd.name,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = "Unit: ${selectedInd.unit} • Source: ${selectedInd.sourceName}",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF64748B),
                                fontSize = 11.sp
                            )
                        }

                        Text(
                            text = "${state.indicatorValues.size} countries",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF38BDF8)
                        )
                    }
                }

                if (state.indicatorValues.isEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Loading verified indicator statistics...",
                                color = Color(0xFF94A3B8),
                                fontSize = 13.sp
                            )
                        }
                    }
                } else {
                    // 4. Country Indicator Rankings Table / Bars
                    val maxValue = state.indicatorValues.maxOfOrNull { it.value } ?: 1.0

                    itemsIndexed(
                        items = state.indicatorValues,
                        key = { _, item -> item.isoCode }
                    ) { index, item ->
                        val country = state.countriesMap[item.isoCode]
                        CountryIndicatorRow(
                            rank = index + 1,
                            item = item,
                            country = country,
                            maxValue = maxValue,
                            unit = selectedInd.unit,
                            onClick = { onCountryClick(item.isoCode) }
                        )
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun CountryIndicatorRow(
    rank: Int,
    item: CountryIndicatorValueEntity,
    country: CountryPopulation?,
    maxValue: Double,
    unit: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF141923)),
        border = BorderStroke(1.dp, Color(0xFF222B3A))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$rank",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF64748B),
                    modifier = Modifier.width(26.dp)
                )

                Text(
                    text = country?.flagEmoji ?: "🌐",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 8.dp)
                )

                Text(
                    text = country?.countryName ?: item.isoCode,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "${item.formattedValue ?: item.value} $unit",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // Proportional Indicator Value Bar
            val fraction = if (maxValue > 0) (item.value / maxValue).coerceIn(0.02, 1.0).toFloat() else 0.05f
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color(0xFF1E2837))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(fraction)
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(Color(0xFF06B6D4))
                )
            }
        }
    }
}
