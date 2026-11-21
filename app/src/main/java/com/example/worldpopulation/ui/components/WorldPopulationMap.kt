package com.example.worldpopulation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.worldpopulation.domain.model.CountryPopulation
import com.example.worldpopulation.util.NumberFormatType
import com.example.worldpopulation.util.NumberFormatter

enum class PopulationTier(val label: String, val color: Color, val min: Long, val max: Long) {
    TIER_OVER_1B("> 1 Billion", Color(0xFFEF4444), 1_000_000_000L, Long.MAX_VALUE),
    TIER_500M_1B("500M – 1B", Color(0xFFF97316), 500_000_000L, 1_000_000_000L),
    TIER_100M_500M("100M – 500M", Color(0xFFFBBF24), 100_000_000L, 500_000_000L),
    TIER_50M_100M("50M – 100M", Color(0xFF34D399), 50_000_000L, 100_000_000L),
    TIER_10M_50M("10M – 50M", Color(0xFF38BDF8), 10_000_000L, 50_000_000L),
    TIER_UNDER_10M("< 10 Million", Color(0xFF818CF8), 0L, 10_000_000L)
}

@Composable
fun WorldPopulationMap(
    countries: List<CountryPopulation>,
    onCountryClick: (String) -> Unit,
    formatType: NumberFormatType = NumberFormatType.INTERNATIONAL,
    modifier: Modifier = Modifier
) {
    var selectedTier by remember { mutableStateOf<PopulationTier?>(null) }

    val filteredCountries = remember(countries, selectedTier) {
        if (selectedTier == null) countries
        else countries.filter { it.population in selectedTier!!.min until selectedTier!!.max }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "GLOBAL POPULATION TIERS",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)
        )

        // Tier Filters Chip Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            PopulationTier.values().take(3).forEach { tier ->
                TierChip(
                    tier = tier,
                    isSelected = selectedTier == tier,
                    onClick = { selectedTier = if (selectedTier == tier) null else tier },
                    modifier = Modifier.weight(1f)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            PopulationTier.values().drop(3).forEach { tier ->
                TierChip(
                    tier = tier,
                    isSelected = selectedTier == tier,
                    onClick = { selectedTier = if (selectedTier == tier) null else tier },
                    modifier = Modifier.weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Countries list in selected tier
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = "${selectedTier?.label ?: "All Tiers"} (${filteredCountries.size} Countries)",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = selectedTier?.color ?: MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                filteredCountries.take(12).forEach { c ->
                    val tier = PopulationTier.values().firstOrNull { c.population >= it.min && c.population < it.max }
                        ?: PopulationTier.TIER_UNDER_10M

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable { onCountryClick(c.isoCode) }
                            .padding(vertical = 8.dp, horizontal = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(CircleShape)
                                .background(tier.color)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = c.flagEmoji,
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = c.countryName,
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.SemiBold
                            )
                            Text(
                                text = "${c.region} • ${c.density?.toInt() ?: 0}/km²",
                                fontSize = 11.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Text(
                            text = NumberFormatter.format(c.population, formatType),
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Open country details",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TierChip(
    tier: PopulationTier,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) tier.color.copy(alpha = 0.25f)
                else MaterialTheme.colorScheme.surfaceVariant
            )
            .clickable(onClick = onClick)
            .padding(vertical = 6.dp, horizontal = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(tier.color)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = tier.label,
                fontSize = 10.sp,
                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                color = if (isSelected) tier.color else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
