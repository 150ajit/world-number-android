package com.example.worldpopulation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.domain.model.GenderDistribution
import com.example.worldpopulation.ui.theme.FemaleColor
import com.example.worldpopulation.ui.theme.MaleColor
import com.example.worldpopulation.util.NumberFormatType
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun GenderDistributionCard(
    distribution: GenderDistribution?,
    formatType: NumberFormatType = NumberFormatType.INTERNATIONAL,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "GENDER DISTRIBUTION",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                letterSpacing = 1.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            if (distribution == null || distribution.totalPopulation <= 0) {
                Text(
                    text = "Data not available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                return@Column
            }

            // Percentage Bar
            val maleFraction = (distribution.malePercentage / 100.0).toFloat().coerceIn(0f, 1f)
            val femaleFraction = (distribution.femalePercentage / 100.0).toFloat().coerceIn(0f, 1f)

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(if (maleFraction > 0) maleFraction else 0.001f)
                            .background(MaleColor)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(if (femaleFraction > 0) femaleFraction else 0.001f)
                            .background(FemaleColor)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            // Counts & Percentages Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Male
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(MaleColor)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Male",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaleColor,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Text(
                        text = NumberFormatter.formatPercentage(distribution.malePercentage),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = NumberFormatter.format(distribution.malePopulation, formatType),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                // Sex Ratio (if calculable)
                distribution.sexRatio?.let { ratio ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Sex Ratio",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            text = String.format("%.1f", ratio),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "males per 100 females",
                            fontSize = 9.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Female
                Column(horizontalAlignment = Alignment.End) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Female",
                            style = MaterialTheme.typography.bodySmall,
                            color = FemaleColor,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(FemaleColor)
                        )
                    }
                    Text(
                        text = NumberFormatter.formatPercentage(distribution.femalePercentage),
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = NumberFormatter.format(distribution.femalePopulation, formatType),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}
