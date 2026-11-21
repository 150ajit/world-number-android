package com.example.worldpopulation.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.domain.model.AgeGenderPopulation
import com.example.worldpopulation.ui.theme.FemaleColor
import com.example.worldpopulation.ui.theme.MaleColor
import com.example.worldpopulation.util.NumberFormatType
import com.example.worldpopulation.util.NumberFormatter
import kotlin.math.max

enum class PyramidDisplayMode {
    POPULATION,
    PERCENTAGE
}

@Composable
fun PopulationPyramidChart(
    brackets: List<AgeGenderPopulation>,
    mode: PyramidDisplayMode = PyramidDisplayMode.PERCENTAGE,
    formatType: NumberFormatType = NumberFormatType.INTERNATIONAL,
    modifier: Modifier = Modifier
) {
    if (brackets.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Data not available",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
        return
    }

    var selectedBracket by remember { mutableStateOf<AgeGenderPopulation?>(null) }

    // Reverse so oldest (100+) is at top, youngest (0-4) is at bottom
    val sortedBrackets = remember(brackets) {
        brackets.sortedByDescending { it.ageStart }
    }

    val totalPop = remember(brackets) {
        val sum = brackets.sumOf { it.totalPopulation }
        if (sum > 0) sum else 1L
    }

    // Determine max value for normalising bar widths
    val maxBarValue = remember(brackets, mode) {
        var m = 1.0
        for (b in brackets) {
            val maleVal = if (mode == PyramidDisplayMode.POPULATION) {
                (b.malePopulation ?: 0L).toDouble()
            } else {
                ((b.malePopulation ?: 0L).toDouble() / totalPop) * 100.0
            }
            val femaleVal = if (mode == PyramidDisplayMode.POPULATION) {
                (b.femalePopulation ?: 0L).toDouble()
            } else {
                ((b.femalePopulation ?: 0L).toDouble() / totalPop) * 100.0
            }
            m = max(m, max(maleVal, femaleVal))
        }
        m
    }

    Column(modifier = modifier.fillMaxWidth()) {
        // Legend Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(MaleColor)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "MALE",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaleColor
                )
            }

            Text(
                text = "AGE GROUP",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "FEMALE",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = FemaleColor
                )
                Spacer(modifier = Modifier.width(6.dp))
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(RoundedCornerShape(2.dp))
                        .background(FemaleColor)
                )
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        // Pyramid Rows (100+ down to 0-4)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(3.dp)
        ) {
            sortedBrackets.forEach { bracket ->
                val isSelected = selectedBracket == bracket

                val maleVal = if (mode == PyramidDisplayMode.POPULATION) {
                    (bracket.malePopulation ?: 0L).toDouble()
                } else {
                    ((bracket.malePopulation ?: 0L).toDouble() / totalPop) * 100.0
                }

                val femaleVal = if (mode == PyramidDisplayMode.POPULATION) {
                    (bracket.femalePopulation ?: 0L).toDouble()
                } else {
                    ((bracket.femalePopulation ?: 0L).toDouble() / totalPop) * 100.0
                }

                val maleFraction = (maleVal / maxBarValue).toFloat().coerceIn(0f, 1f)
                val femaleFraction = (femaleVal / maxBarValue).toFloat().coerceIn(0f, 1f)

                val animatedMaleFraction by animateFloatAsState(
                    targetValue = maleFraction,
                    animationSpec = tween(durationMillis = 400),
                    label = "MaleBarAnimation"
                )
                val animatedFemaleFraction by animateFloatAsState(
                    targetValue = femaleFraction,
                    animationSpec = tween(durationMillis = 400),
                    label = "FemaleBarAnimation"
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                            else Color.Transparent
                        )
                        .clickable {
                            selectedBracket = if (isSelected) null else bracket
                        }
                        .padding(vertical = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Male Bar (Extends LEFT towards center)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(14.dp),
                        contentAlignment = Alignment.CenterEnd
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(animatedMaleFraction)
                                .clip(RoundedCornerShape(topStart = 3.dp, bottomStart = 3.dp))
                                .background(MaleColor)
                        )
                    }

                    // Age Group Label (Center)
                    Text(
                        text = bracket.ageGroupLabel,
                        modifier = Modifier.width(52.dp),
                        textAlign = TextAlign.Center,
                        fontSize = 11.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )

                    // Female Bar (Extends RIGHT from center)
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(14.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(animatedFemaleFraction)
                                .clip(RoundedCornerShape(topEnd = 3.dp, bottomEnd = 3.dp))
                                .background(FemaleColor)
                        )
                    }
                }
            }
        }

        // Interactive Selected Bracket Detail Sheet / Card
        selectedBracket?.let { bracket ->
            Spacer(modifier = Modifier.height(12.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Age Group: ${bracket.ageGroupLabel}",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        val share = (bracket.totalPopulation.toDouble() / totalPop) * 100.0
                        Text(
                            text = "Share: ${NumberFormatter.formatPercentage(share)}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(
                                text = "Male Population",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaleColor
                            )
                            Text(
                                text = NumberFormatter.format(bracket.malePopulation ?: 0L, formatType),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            bracket.malePercentage?.let {
                                Text(
                                    text = "(${NumberFormatter.formatPercentage(it)} of bracket)",
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "Female Population",
                                style = MaterialTheme.typography.labelSmall,
                                color = FemaleColor
                            )
                            Text(
                                text = NumberFormatter.format(bracket.femalePopulation ?: 0L, formatType),
                                style = MaterialTheme.typography.bodyMedium,
                                fontWeight = FontWeight.Bold
                            )
                            bracket.femalePercentage?.let {
                                Text(
                                    text = "(${NumberFormatter.formatPercentage(it)} of bracket)",
                                    fontSize = 10.sp,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Total in group: ${NumberFormatter.format(bracket.totalPopulation, formatType)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

private fun Modifier.size(size: androidx.compose.ui.unit.Dp): Modifier =
    this.width(size).height(size)
