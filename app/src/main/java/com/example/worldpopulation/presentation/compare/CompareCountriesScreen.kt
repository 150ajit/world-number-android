package com.example.worldpopulation.presentation.compare

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.EmeraldGreen
import com.example.worldpopulation.ui.theme.RoseRed
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun CompareCountriesScreen(
    viewModel: CompareCountriesViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    var addMenuExpanded by remember { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "COUNTRY COMPARISON",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
            Text(
                text = "Compare factual demographic indicators across 2 to 5 countries",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Selected Countries Chips
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                state.selectedIsoCodes.forEach { iso ->
                    val c = state.allCountries.find { it.isoCode == iso }
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(c?.flagEmoji ?: "🌐", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = c?.countryName ?: iso,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                        if (state.selectedIsoCodes.size > 2) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Remove country",
                                modifier = Modifier
                                    .size(16.dp)
                                    .clickable { viewModel.removeCountry(iso) }
                            )
                        }
                    }
                }

                // Add Country Button
                if (state.selectedIsoCodes.size < 5) {
                    Box {
                        Row(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))
                                .clickable { addMenuExpanded = true }
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                Icons.Default.Add,
                                contentDescription = "Add country",
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(16.dp)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                "Add",
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp
                            )
                        }

                        DropdownMenu(
                            expanded = addMenuExpanded,
                            onDismissRequest = { addMenuExpanded = false }
                        ) {
                            state.allCountries.filter { !state.selectedIsoCodes.contains(it.isoCode) }.take(10).forEach { c ->
                                DropdownMenuItem(
                                    text = { Text("${c.flagEmoji} ${c.countryName}") },
                                    onClick = {
                                        viewModel.addCountry(c.isoCode)
                                        addMenuExpanded = false
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        // Comparison Table / Cards
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp)
                ) {
                    // Header Row with Country Flags & Names
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "METRIC",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.weight(1.2f)
                        )
                        state.comparedItems.forEach { item ->
                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(item.country.flagEmoji, fontSize = 20.sp)
                                Text(
                                    text = item.country.countryName,
                                    fontSize = 10.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    // Row: Population
                    CompareMetricRow(
                        title = "Population",
                        subtitle = "UN WPP 2026",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        NumberFormatter.formatCompact(item.country.population)
                    }

                    // Row: Annual Growth Rate
                    CompareMetricRow(
                        title = "Growth Rate",
                        subtitle = "Annual %",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        val rate = item.country.growthRate ?: 0.0
                        "${if (rate >= 0) "+" else ""}${String.format("%.2f%%", rate)}"
                    }

                    // Row: Population Density
                    CompareMetricRow(
                        title = "Density",
                        subtitle = "people/km²",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        "${item.country.density?.toInt() ?: "N/A"}"
                    }

                    // Row: Median Age
                    CompareMetricRow(
                        title = "Median Age",
                        subtitle = "years",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        item.indicators["MEDIAN_AGE"]?.value?.let { String.format("%.1f", it) } ?: "N/A"
                    }

                    // Row: Fertility Rate
                    CompareMetricRow(
                        title = "Fertility Rate",
                        subtitle = "births/woman",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        item.indicators["FERTILITY_RATE"]?.value?.let { String.format("%.2f", it) } ?: "N/A"
                    }

                    // Row: Life Expectancy
                    CompareMetricRow(
                        title = "Life Expectancy",
                        subtitle = "years",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        item.indicators["LIFE_EXPECTANCY"]?.value?.let { String.format("%.1f", it) } ?: "N/A"
                    }

                    // Row: Urban Population
                    CompareMetricRow(
                        title = "Urban Population",
                        subtitle = "% of total",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        item.indicators["URBAN_POP_PCT"]?.value?.let { String.format("%.1f%%", it) } ?: "N/A"
                    }

                    // Row: Land Area
                    CompareMetricRow(
                        title = "Land Area",
                        subtitle = "km²",
                        items = state.comparedItems,
                        weight = 1.2f
                    ) { item ->
                        NumberFormatter.formatCompact(item.country.landArea?.toLong() ?: 0L)
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun CompareMetricRow(
    title: String,
    subtitle: String,
    items: List<CountryComparisonItem>,
    weight: Float,
    valueExtractor: (CountryComparisonItem) -> String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(weight)) {
                Text(title, style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.SemiBold)
                Text(subtitle, fontSize = 9.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            items.forEach { item ->
                Text(
                    text = valueExtractor(item),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.weight(1f),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(0.5.dp)
                .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))
        )
    }
}
