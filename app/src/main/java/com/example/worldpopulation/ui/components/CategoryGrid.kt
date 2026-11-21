package com.example.worldpopulation.ui.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.data.local.entity.CategoryEntity

@Composable
fun CategoryGrid(
    categories: List<CategoryEntity>,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // Symmetrical 2-Column layout matching the reference screenshot exactly
    val rowCount = (categories.size + 1) / 2

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        for (i in 0 until rowCount) {
            val leftCat = categories.getOrNull(i * 2)
            val rightCat = categories.getOrNull(i * 2 + 1)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (leftCat != null) {
                    Box(modifier = Modifier.weight(1f)) {
                        CategoryCard(category = leftCat, onClick = { onCategoryClick(leftCat.id) })
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }

                if (rightCat != null) {
                    Box(modifier = Modifier.weight(1f)) {
                        CategoryCard(category = rightCat, onClick = { onCategoryClick(rightCat.id) })
                    }
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
fun CategoryCard(
    category: CategoryEntity,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(58.dp)
            .clip(RoundedCornerShape(14.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF1C212B) // Clean dark card surface matching the screenshot
        ),
        border = BorderStroke(1.dp, Color(0xFF2B3342))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                imageVector = CategoryVisuals.getIcon(category.id),
                contentDescription = category.name,
                tint = Color(0xFFE2E8F0),
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = category.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 13.5.sp
                )
                if (category.headlineStatistic.isNotBlank()) {
                    Text(
                        text = category.headlineStatistic,
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF38BDF8),
                        fontSize = 10.5.sp,
                        maxLines = 1
                    )
                }
            }
        }
    }
}
