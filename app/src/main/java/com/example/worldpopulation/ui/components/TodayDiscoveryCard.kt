package com.example.worldpopulation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity

@Composable
fun TodayDiscoveryCard(
    discovery: DailyDiscoveryEntity?,
    onShareClick: (DailyDiscoveryEntity) -> Unit = {},
    onSeeMoreClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    // If discovery is null (e.g. during initial Room cold start), use verified Dubai fact from the reference design
    val activeDiscovery = discovery ?: DailyDiscoveryEntity(
        dayOfYear = 1,
        categoryId = "city_rankings",
        headline = "Dubai: A Global City",
        stat = "3.6 Million",
        detail = "Dubai's population is over 3.6 million, making it one of the world's largest cities.",
        source = "Dubai Statistics Center / UN Habitat",
        isoCode = "UAE"
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onSeeMoreClick),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF101728)),
        border = BorderStroke(1.dp, Color(0xFF1E2B45))
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            // Header Row: Lightbulb icon + "Today's Global Discovery" + "See More ->"
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFFBBF24).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Lightbulb,
                            contentDescription = null,
                            tint = Color(0xFFFBBF24),
                            modifier = Modifier.size(15.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Today's Global Discovery",
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 13.5.sp
                    )
                }

                Row(
                    modifier = Modifier.clickable(onClick = onSeeMoreClick),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "See More",
                        style = MaterialTheme.typography.labelSmall,
                        color = Color(0xFF94A3B8),
                        fontSize = 11.5.sp
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Icon(
                        imageVector = Icons.Default.ChevronRight,
                        contentDescription = "See More",
                        tint = Color(0xFF94A3B8),
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Body Row: Thumbnail on Left + Details on Right
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                // Topic Thumbnail (Stylized skyscraper city skyline)
                Box(
                    modifier = Modifier
                        .size(width = 84.dp, height = 64.dp)
                        .clip(RoundedCornerShape(10.dp))
                        .background(
                            Brush.linearGradient(
                                colors = listOf(Color(0xFF1B2E4B), Color(0xFF0F1A2C))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    DiscoveryThumbnailVisual(isoCode = activeDiscovery.isoCode ?: "GLB")
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = activeDiscovery.headline,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 13.5.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = activeDiscovery.detail,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFF94A3B8),
                        fontSize = 11.5.sp,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 15.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    // Location Tag Pill (e.g. UAE or Category)
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(Color(0xFF152238))
                            .padding(horizontal = 6.dp, vertical = 2.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(11.dp)
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = activeDiscovery.isoCode ?: activeDiscovery.categoryId.replace('_', ' ').uppercase(),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF38BDF8)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun DiscoveryThumbnailVisual(isoCode: String) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Background horizon glow
        drawRect(
            brush = Brush.verticalGradient(
                colors = listOf(Color(0xFF2A4365), Color(0xFF1A263D), Color(0xFF0D1526))
            )
        )

        // Stylized skyline silhouettes / golden lights
        drawLine(
            color = Color(0xFF38BDF8).copy(alpha = 0.6f),
            start = Offset(0f, h * 0.75f),
            end = Offset(w, h * 0.75f),
            strokeWidth = 1.5f
        )

        // Spire / Burj Khalifa / Landmark silhouette in center
        val center = w * 0.5f
        drawLine(
            color = Color(0xFFFBBF24).copy(alpha = 0.9f),
            start = Offset(center, h * 0.2f),
            end = Offset(center, h * 0.75f),
            strokeWidth = 2.5f
        )
        // Tower crown beacon
        drawCircle(
            color = Color(0xFFFFFFFF),
            radius = 2.dp.toPx(),
            center = Offset(center, h * 0.2f)
        )

        // Building blocks left & right
        drawRect(
            color = Color(0xFF101B2E),
            topLeft = Offset(w * 0.2f, h * 0.45f),
            size = androidx.compose.ui.geometry.Size(w * 0.15f, h * 0.3f)
        )
        drawRect(
            color = Color(0xFF101B2E),
            topLeft = Offset(w * 0.65f, h * 0.40f),
            size = androidx.compose.ui.geometry.Size(w * 0.16f, h * 0.35f)
        )
    }
}
