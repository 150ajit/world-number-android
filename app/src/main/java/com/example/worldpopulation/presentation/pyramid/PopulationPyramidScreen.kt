package com.example.worldpopulation.presentation.pyramid

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.ChevronRight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.ui.components.BroadAgeStructureCard
import com.example.worldpopulation.ui.components.PopulationPyramidChart
import com.example.worldpopulation.ui.components.PyramidDisplayMode
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.FemaleColor
import com.example.worldpopulation.ui.theme.MaleColor
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun PopulationPyramidScreen(
    viewModel: PyramidViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.uiState.collectAsState()
    var countryMenuExpanded by remember { mutableStateOf(false) }
    var compareCountryMenuExpanded by remember { mutableStateOf(false) }

    val selectedCountry = state.countries.find { it.isoCode == state.selectedCountryIso }
    val compareCountry = state.countries.find { it.isoCode == state.compareCountryIso }

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
                text = "POPULATION PYRAMID",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp
            )
        }

        // Country Selector and Compare Mode bar
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Primary Country Dropdown
                Box {
                    Row(
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .clickable { countryMenuExpanded = true }
                            .padding(horizontal = 12.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(selectedCountry?.flagEmoji ?: "🌐", fontSize = 18.sp)
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = selectedCountry?.countryName ?: state.selectedCountryIso,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(Icons.Default.ArrowDropDown, contentDescription = "Select country")
                    }

                    DropdownMenu(
                        expanded = countryMenuExpanded,
                        onDismissRequest = { countryMenuExpanded = false }
                    ) {
                        state.countries.take(15).forEach { c ->
                            DropdownMenuItem(
                                text = { Text("${c.flagEmoji} ${c.countryName}") },
                                onClick = {
                                    viewModel.selectCountry(c.isoCode)
                                    countryMenuExpanded = false
                                }
                            )
                        }
                    }
                }

                // Year Selector (< 2026 >)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(horizontal = 4.dp, vertical = 2.dp)
                ) {
                    val years = listOf(1970, 2026, 2050)
                    val currentIndex = years.indexOf(state.selectedYear)

                    IconButton(
                        onClick = { if (currentIndex > 0) viewModel.selectYear(years[currentIndex - 1]) },
                        enabled = currentIndex > 0,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(Icons.Default.ChevronLeft, contentDescription = "Prev", modifier = Modifier.size(16.dp))
                    }
                    Text(
                        text = "${state.selectedYear}",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )
                    IconButton(
                        onClick = { if (currentIndex < years.size - 1) viewModel.selectYear(years[currentIndex + 1]) },
                        enabled = currentIndex < years.size - 1,
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(Icons.Default.ChevronRight, contentDescription = "Next", modifier = Modifier.size(16.dp))
                    }
                }
            }
        }

        // Data Source & Classification Banner
        item {
            val isProj = state.selectedYear > 2024
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        if (isProj) CyanAccent.copy(alpha = 0.1f)
                        else MaterialTheme.colorScheme.surfaceVariant
                    )
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "UN World Population Prospects (2024 Revision)",
                        fontSize = 10.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        text = if (isProj) "PROJECTION (Medium Variant)" else "ESTIMATE / HISTORICAL",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = if (isProj) CyanAccent else MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // Mode Toggles (Population / Percentage & Single / Compare)
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Population vs Percentage
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(2.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                if (state.displayMode == PyramidDisplayMode.PERCENTAGE) MaterialTheme.colorScheme.primary
                                else Color.Transparent
                            )
                            .clickable { viewModel.setDisplayMode(PyramidDisplayMode.PERCENTAGE) }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "Percentage (%)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (state.displayMode == PyramidDisplayMode.PERCENTAGE) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                if (state.displayMode == PyramidDisplayMode.POPULATION) MaterialTheme.colorScheme.primary
                                else Color.Transparent
                            )
                            .clickable { viewModel.setDisplayMode(PyramidDisplayMode.POPULATION) }
                            .padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            "Population",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (state.displayMode == PyramidDisplayMode.POPULATION) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                // Compare Mode Dropdown / Button
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable {
                            val nextMode = when (state.compareMode) {
                                PyramidCompareMode.SINGLE -> PyramidCompareMode.COUNTRY_VS_COUNTRY
                                PyramidCompareMode.COUNTRY_VS_COUNTRY -> PyramidCompareMode.YEAR_VS_YEAR
                                PyramidCompareMode.YEAR_VS_YEAR -> PyramidCompareMode.SINGLE
                            }
                            viewModel.setCompareMode(nextMode)
                        }
                        .padding(horizontal = 10.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = when (state.compareMode) {
                            PyramidCompareMode.SINGLE -> "Mode: Single"
                            PyramidCompareMode.COUNTRY_VS_COUNTRY -> "Vs Country"
                            PyramidCompareMode.YEAR_VS_YEAR -> "Vs Year"
                        },
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        // Summary Header for Primary Pyramid
        item {
            val gender = state.primaryGender
            if (gender != null) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(
                                text = "TOTAL POPULATION",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Text(
                                text = NumberFormatter.formatCompact(gender.totalPopulation),
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("MALE", style = MaterialTheme.typography.labelSmall, color = MaleColor)
                            Text(
                                text = NumberFormatter.formatPercentage(gender.malePercentage),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Column(horizontalAlignment = Alignment.End) {
                            Text("FEMALE", style = MaterialTheme.typography.labelSmall, color = FemaleColor)
                            Text(
                                text = NumberFormatter.formatPercentage(gender.femalePercentage),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        // Primary Population Pyramid Chart
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = "${selectedCountry?.countryName ?: state.selectedCountryIso} • ${state.selectedYear}",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    PopulationPyramidChart(
                        brackets = state.primaryBrackets,
                        mode = state.displayMode,
                        formatType = state.numberFormat
                    )
                }
            }
        }

        // Comparison Pyramid (if active)
        if (state.compareMode != PyramidCompareMode.SINGLE) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        val compTitle = if (state.compareMode == PyramidCompareMode.COUNTRY_VS_COUNTRY) {
                            "${compareCountry?.countryName ?: state.compareCountryIso} • ${state.selectedYear}"
                        } else {
                            "${selectedCountry?.countryName ?: state.selectedCountryIso} • ${state.compareYear}"
                        }

                        Text(
                            text = "COMPARISON: $compTitle",
                            style = MaterialTheme.typography.titleSmall,
                            fontWeight = FontWeight.Bold,
                            color = CyanAccent
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        PopulationPyramidChart(
                            brackets = state.compareBrackets,
                            mode = state.displayMode,
                            formatType = state.numberFormat
                        )
                    }
                }
            }
        }

        // Age Structure Card
        item {
            BroadAgeStructureCard(structure = state.primaryStructure)
        }

        item {
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
