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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.domain.model.BroadAgeStructure
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.EmeraldGreen
import com.example.worldpopulation.ui.theme.RoseRed
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun BroadAgeStructureCard(
    structure: BroadAgeStructure?,
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "AGE STRUCTURE",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    letterSpacing = 1.sp
                )
                Text(
                    text = "Calculated",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            if (structure == null) {
                Text(
                    text = "Data not available",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                return@Column
            }

            val p0_14 = (structure.age0To14Percentage / 100.0).toFloat().coerceIn(0f, 1f)
            val p15_64 = (structure.age15To64Percentage / 100.0).toFloat().coerceIn(0f, 1f)
            val p65Plus = (structure.age65PlusPercentage / 100.0).toFloat().coerceIn(0f, 1f)

            val colorYoung = CyanAccent
            val colorWork = EmeraldGreen
            val colorOld = RoseRed

            // Multi-segment horizontal bar
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clip(RoundedCornerShape(6.dp))
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(if (p0_14 > 0) p0_14 else 0.001f)
                            .background(colorYoung)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(if (p15_64 > 0) p15_64 else 0.001f)
                            .background(colorWork)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(if (p65Plus > 0) p65Plus else 0.001f)
                            .background(colorOld)
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // 0-14
                Column {
                    Text("0–14 years", fontSize = 11.sp, color = colorYoung, fontWeight = FontWeight.Bold)
                    Text(
                        text = NumberFormatter.formatPercentage(structure.age0To14Percentage, 1),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Children & Youth", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }

                // 15-64
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("15–64 years", fontSize = 11.sp, color = colorWork, fontWeight = FontWeight.Bold)
                    Text(
                        text = NumberFormatter.formatPercentage(structure.age15To64Percentage, 1),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Working Age", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }

                // 65+
                Column(horizontalAlignment = Alignment.End) {
                    Text("65+ years", fontSize = 11.sp, color = colorOld, fontWeight = FontWeight.Bold)
                    Text(
                        text = NumberFormatter.formatPercentage(structure.age65PlusPercentage, 1),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Elderly", fontSize = 10.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }

            structure.dependencyRatio?.let { ratio ->
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surface.copy(alpha = 0.5f))
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Dependency Ratio",
                            style = MaterialTheme.typography.bodySmall,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "((Pop 0–14 + Pop 65+) / Pop 15–64) × 100",
                            fontSize = 9.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    Text(
                        text = String.format("%.1f", ratio),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}
