package com.example.worldpopulation.presentation.indicator

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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndicatorDetailScreen(
    viewModel: IndicatorDetailViewModel,
    onBackClick: () -> Unit,
    onCountryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    val ind = state.indicator

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = ind?.name ?: "Indicator Details",
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
            // 1. Hero Card
            if (ind != null) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color(0xFF161C26)),
                        border = BorderStroke(1.dp, Color(0xFF263040))
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = ind.categoryId.uppercase(),
                                style = MaterialTheme.typography.labelSmall,
                                letterSpacing = 1.sp,
                                color = Color(0xFF38BDF8)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = ind.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Measurement Unit: ${ind.unit}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color(0xFF10B981),
                                fontWeight = FontWeight.SemiBold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Authoritative Source: ${ind.sourceName}",
                                style = MaterialTheme.typography.labelSmall,
                                color = Color(0xFF94A3B8),
                                fontSize = 11.sp
                            )
                        }
                    }
                }
            }

            // 2. Statistical Highlights
            if (state.indicatorValues.isNotEmpty()) {
                val highest = state.indicatorValues.first()
                val lowest = state.indicatorValues.last()
                val highestCountry = state.countriesMap[highest.isoCode]
                val lowestCountry = state.countriesMap[lowest.isoCode]

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Card(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF141923)),
                            border = BorderStroke(1.dp, Color(0xFF222B3A))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(text = "HIGHEST", style = MaterialTheme.typography.labelSmall, color = Color(0xFF10B981), fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "${highestCountry?.flagEmoji ?: ""} ${highestCountry?.countryName ?: highest.isoCode}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                    maxLines = 1
                                )
                                Text(
                                    text = "${highest.formattedValue ?: highest.value} ${ind?.unit ?: ""}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(0xFF38BDF8),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }

                        Card(
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF141923)),
                            border = BorderStroke(1.dp, Color(0xFF222B3A))
                        ) {
                            Column(modifier = Modifier.padding(12.dp)) {
                                Text(text = "LOWEST", style = MaterialTheme.typography.labelSmall, color = Color(0xFFF59E0B), fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "${lowestCountry?.flagEmoji ?: ""} ${lowestCountry?.countryName ?: lowest.isoCode}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White,
                                    maxLines = 1
                                )
                                Text(
                                    text = "${lowest.formattedValue ?: lowest.value} ${ind?.unit ?: ""}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color(0xFF38BDF8),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }

                // 3. Country Comparison Section
                val compA = state.indicatorValues.find { it.isoCode == state.compareCountryA }
                val compB = state.indicatorValues.find { it.isoCode == state.compareCountryB }
                if (compA != null && compB != null && compA.isoCode != compB.isoCode) {
                    val countryA = state.countriesMap[compA.isoCode]
                    val countryB = state.countriesMap[compB.isoCode]
                    val diff = compA.value - compB.value
                    val ratio = if (compB.value != 0.0) compA.value / compB.value else 1.0

                    item {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(14.dp),
                            colors = CardDefaults.cardColors(containerColor = Color(0xFF161C26)),
                            border = BorderStroke(1.dp, Color(0xFF0284C7).copy(alpha = 0.4f))
                        ) {
                            Column(modifier = Modifier.padding(14.dp)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = Icons.AutoMirrored.Filled.CompareArrows,
                                        contentDescription = null,
                                        tint = Color(0xFF38BDF8),
                                        modifier = Modifier.size(20.dp)
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(
                                        text = "COUNTRY COMPARISON",
                                        style = MaterialTheme.typography.labelSmall,
                                        fontWeight = FontWeight.Bold,
                                        letterSpacing = 1.sp,
                                        color = Color(0xFF38BDF8)
                                    )
                                }

                                Spacer(modifier = Modifier.height(10.dp))

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "${countryA?.flagEmoji ?: ""} ${countryA?.countryName ?: compA.isoCode}",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = "${compA.formattedValue ?: compA.value} ${ind?.unit ?: ""}",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color(0xFF38BDF8)
                                        )
                                    }

                                    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
                                        Text(
                                            text = "${countryB?.flagEmoji ?: ""} ${countryB?.countryName ?: compB.isoCode}",
                                            style = MaterialTheme.typography.bodyMedium,
                                            fontWeight = FontWeight.Bold,
                                            color = Color.White
                                        )
                                        Text(
                                            text = "${compB.formattedValue ?: compB.value} ${ind?.unit ?: ""}",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = Color(0xFF38BDF8)
                                        )
                                    }
                                }

                                Spacer(modifier = Modifier.height(8.dp))

                                val diffText = if (diff >= 0) "+%,.2f".format(diff) else "-%,.2f".format(kotlin.math.abs(diff))
                                Text(
                                    text = "Difference: $diffText ${ind?.unit ?: ""} (${"%.1f".format(ratio)}x ratio)",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(0xFF94A3B8),
                                    fontSize = 11.sp
                                )
                            }
                        }
                    }

                    // 3b. Historical Multi-Year Trend Card (2015 – 2024)
                    if (state.historicalValuesA.isNotEmpty() || state.historicalValuesB.isNotEmpty()) {
                        val allYears = (state.historicalValuesA.map { it.year } + state.historicalValuesB.map { it.year }).distinct().sorted()
                        if (allYears.size > 1) {
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    shape = RoundedCornerShape(14.dp),
                                    colors = CardDefaults.cardColors(containerColor = Color(0xFF161C26)),
                                    border = BorderStroke(1.dp, Color(0xFF263040))
                                ) {
                                    Column(modifier = Modifier.padding(14.dp)) {
                                        Text(
                                            text = "HISTORICAL TREND (2015 – 2024)",
                                            style = MaterialTheme.typography.labelSmall,
                                            fontWeight = FontWeight.Bold,
                                            letterSpacing = 1.sp,
                                            color = Color(0xFF10B981)
                                        )
                                        Spacer(modifier = Modifier.height(10.dp))

                                        allYears.forEach { yr ->
                                            val valA = state.historicalValuesA.find { it.year == yr }
                                            val valB = state.historicalValuesB.find { it.year == yr }

                                            Row(
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(vertical = 4.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(
                                                    text = "$yr",
                                                    fontWeight = FontWeight.Bold,
                                                    color = Color(0xFF94A3B8),
                                                    fontSize = 12.sp,
                                                    modifier = Modifier.width(42.dp)
                                                )

                                                if (valA != null) {
                                                    Text(
                                                        text = "${countryA?.countryName?.take(10) ?: compA.isoCode}: ${valA.formattedValue ?: valA.value}",
                                                        color = Color(0xFF38BDF8),
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.SemiBold
                                                    )
                                                }

                                                if (valB != null) {
                                                    Text(
                                                        text = "${countryB?.countryName?.take(10) ?: compB.isoCode}: ${valB.formattedValue ?: valB.value}",
                                                        color = Color(0xFFF59E0B),
                                                        fontSize = 12.sp,
                                                        fontWeight = FontWeight.SemiBold
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 4. Rankings Header & Search Filter
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "GLOBAL RANKINGS",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.sp,
                        color = Color(0xFF94A3B8)
                    )

                    Text(
                        text = "${state.indicatorValues.size} countries",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF38BDF8)
                    )
                }
            }

            item {
                OutlinedTextField(
                    value = state.searchQuery,
                    onValueChange = viewModel::onSearchQueryChanged,
                    placeholder = { Text("Search country...", color = Color(0xFF64748B), fontSize = 13.sp) },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = null, tint = Color(0xFF64748B), modifier = Modifier.size(18.dp))
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF38BDF8),
                        unfocusedBorderColor = Color(0xFF222B3A),
                        focusedContainerColor = Color(0xFF141923),
                        unfocusedContainerColor = Color(0xFF141923),
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White
                    )
                )
            }

            // 5. Filtered Rankings List
            val filtered = if (state.searchQuery.isBlank()) {
                state.indicatorValues
            } else {
                state.indicatorValues.filter { item ->
                    val name = state.countriesMap[item.isoCode]?.countryName ?: ""
                    name.contains(state.searchQuery, ignoreCase = true) || item.isoCode.contains(state.searchQuery, ignoreCase = true)
                }
            }

            if (filtered.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 32.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = if (state.searchQuery.isNotBlank()) "No matching countries" else "Loading verified statistics...",
                            color = Color(0xFF94A3B8),
                            fontSize = 13.sp
                        )
                    }
                }
            } else {
                val maxValue = filtered.maxOfOrNull { it.value } ?: 1.0
                val ranks = com.example.worldpopulation.util.NumberFormatter.computeCompetitionRanks(filtered)

                itemsIndexed(
                    items = filtered,
                    key = { _, item -> item.isoCode }
                ) { index, item ->
                    val country = state.countriesMap[item.isoCode]
                    RankingRow(
                        rank = ranks[index],
                        item = item,
                        country = country,
                        maxValue = maxValue,
                        unit = ind?.unit ?: "",
                        onClick = { onCountryClick(item.isoCode) }
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
private fun RankingRow(
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
                    text = com.example.worldpopulation.util.NumberFormatter.formatIndicatorWithUnit(
                        item.formattedValue, item.value, unit
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF38BDF8)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

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
