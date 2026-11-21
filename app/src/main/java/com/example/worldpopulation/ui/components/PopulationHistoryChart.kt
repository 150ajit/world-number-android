package com.example.worldpopulation.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.domain.model.DataType
import com.example.worldpopulation.domain.model.HistoricalPopulation
import com.example.worldpopulation.ui.theme.CyanAccent
import com.example.worldpopulation.ui.theme.EmeraldGreen
import com.example.worldpopulation.util.NumberFormatter
import kotlin.math.max

@Composable
fun PopulationHistoryChart(
    data: List<HistoricalPopulation>,
    modifier: Modifier = Modifier
) {
    if (data.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(180.dp),
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

    val sorted = data.sortedBy { it.year }
    val maxPop = max(sorted.maxOfOrNull { it.population } ?: 1L, 1L).toFloat()
    val minPop = 0f

    val histColor = EmeraldGreen
    val projColor = CyanAccent

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(histColor, RoundedCornerShape(2.dp))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Historical / Estimate", fontSize = 11.sp, color = histColor)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .background(projColor, RoundedCornerShape(2.dp))
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text("Projection (UN Medium)", fontSize = 11.sp, color = projColor)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            val width = size.width
            val height = size.height
            val bottomPadding = 30f
            val chartHeight = height - bottomPadding
            val barSpacing = width / sorted.size

            sorted.forEachIndexed { index, point ->
                val barHeight = ((point.population - minPop) / (maxPop - minPop)) * (chartHeight - 10f)
                val left = index * barSpacing + (barSpacing * 0.15f)
                val barWidth = barSpacing * 0.7f
                val top = chartHeight - barHeight

                val isProjection = point.dataType == DataType.PROJECTION || point.year > 2024
                val color = if (isProjection) projColor else histColor

                // Bar
                drawRect(
                    color = color.copy(alpha = if (isProjection) 0.75f else 0.9f),
                    topLeft = Offset(left, top),
                    size = Size(barWidth, barHeight)
                )

                // Baseline line
                drawLine(
                    color = Color.Gray.copy(alpha = 0.3f),
                    start = Offset(0f, chartHeight),
                    end = Offset(width, chartHeight),
                    strokeWidth = 1f
                )
            }
        }

        // Year labels row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val sampleYears = listOfNotNull(
                sorted.firstOrNull()?.year,
                sorted.find { it.year in 1990..2000 }?.year,
                sorted.find { it.year == 2026 }?.year,
                sorted.find { it.year in 2050..2060 }?.year,
                sorted.lastOrNull()?.year
            ).distinct()

            sampleYears.forEach { yr ->
                Text(
                    text = "$yr",
                    fontSize = 10.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
