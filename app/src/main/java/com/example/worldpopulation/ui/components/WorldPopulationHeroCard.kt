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
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.ChildCare
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocalHospital
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
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldpopulation.util.NumberFormatType
import com.example.worldpopulation.util.NumberFormatter

@Composable
fun WorldPopulationHeroCard(
    liveCount: Long,
    birthsToday: Long,
    deathsToday: Long,
    growthToday: Long,
    formatType: NumberFormatType,
    onViewDetailsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B1426)
        ),
        border = BorderStroke(1.dp, Color(0xFF1E2D4A))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF0C1629), Color(0xFF091222))
                    )
                )
        ) {
            // Earth Globe on right background
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(width = 190.dp, height = 150.dp)
            ) {
                GlowingEarthGlobe()
            }

            // Foreground Content
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // 1. "Our World Today" Pill Badge
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF11253C))
                        .padding(horizontal = 9.dp, vertical = 4.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(6.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF10B981))
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "Our World Today",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFE2E8F0)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // 2. Headline & Big Count
                Text(
                    text = "World Population",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF94A3B8),
                    fontSize = 13.5.sp
                )

                Spacer(modifier = Modifier.height(2.dp))

                val billionVal = liveCount / 1_000_000_000.0
                val formattedBillion = String.format(java.util.Locale.US, "%.2f Billion", billionVal)

                Text(
                    text = formattedBillion,
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 33.sp,
                    letterSpacing = (-0.5).sp
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Precise Ticking Counter
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Groups,
                        contentDescription = null,
                        tint = Color(0xFF38BDF8),
                        modifier = Modifier.size(15.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "≈ ${NumberFormatter.format(liveCount, formatType)}",
                        style = MaterialTheme.typography.bodySmall,
                        color = Color(0xFFCBD5E1),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // Subtle horizontal divider line
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp)
                        .background(Color(0xFF1A263D))
                )

                Spacer(modifier = Modifier.height(12.dp))

                // 3. Bottom Row: 3 Metrics + View Details Button
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Births Today
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.ChildCare,
                            contentDescription = "Births",
                            tint = Color(0xFFFBBF24),
                            modifier = Modifier.size(18.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text("Births Today", fontSize = 10.sp, color = Color(0xFF94A3B8))
                            Text(
                                "≈ ${NumberFormatter.format(birthsToday, formatType)}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFFFBBF24)
                            )
                        }
                    }

                    // Deaths Today
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.LocalHospital,
                            contentDescription = "Deaths",
                            tint = Color(0xFF38BDF8),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text("Deaths Today", fontSize = 10.sp, color = Color(0xFF94A3B8))
                            Text(
                                "≈ ${NumberFormatter.format(deathsToday, formatType)}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF38BDF8)
                            )
                        }
                    }

                    // Net Change
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.TrendingUp,
                            contentDescription = "Net Change",
                            tint = Color(0xFF34D399),
                            modifier = Modifier.size(17.dp)
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Column {
                            Text("Net Change", fontSize = 10.sp, color = Color(0xFF94A3B8))
                            Text(
                                "+${NumberFormatter.format(growthToday, formatType)}",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF34D399)
                            )
                        }
                    }

                    // View Details Button
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .background(Color(0xFF14243C))
                            .clickable(onClick = onViewDetailsClick)
                            .padding(horizontal = 9.dp, vertical = 5.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "View Details",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Icon(
                                imageVector = Icons.Default.ChevronRight,
                                contentDescription = null,
                                tint = Color(0xFF38BDF8),
                                modifier = Modifier.size(13.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun GlowingEarthGlobe() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height
        val globeRadius = w * 0.58f
        val globeCenter = Offset(w * 0.90f, h * 0.40f)

        // Outer atmospheric blue radiant glow
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFF38BDF8).copy(alpha = 0.45f),
                    Color(0xFF0284C7).copy(alpha = 0.20f),
                    Color.Transparent
                ),
                center = globeCenter,
                radius = globeRadius * 1.35f
            ),
            radius = globeRadius * 1.35f,
            center = globeCenter
        )

        // Inner Globe deep ocean blue
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color(0xFF1E3A8A),
                    Color(0xFF0F172A),
                    Color(0xFF020617)
                ),
                center = Offset(globeCenter.x - globeRadius * 0.2f, globeCenter.y - globeRadius * 0.2f),
                radius = globeRadius
            ),
            radius = globeRadius,
            center = globeCenter
        )

        // Stylized glowing continents (Europe & Africa & Americas curvature)
        val continentColor = Color(0xFF10B981).copy(alpha = 0.70f)
        val cloudColor = Color(0xFFFFFFFF).copy(alpha = 0.35f)

        // Green continent swirls
        drawCircle(
            color = continentColor,
            radius = globeRadius * 0.35f,
            center = Offset(globeCenter.x - globeRadius * 0.35f, globeCenter.y + globeRadius * 0.1f)
        )
        drawCircle(
            color = Color(0xFF059669).copy(alpha = 0.65f),
            radius = globeRadius * 0.28f,
            center = Offset(globeCenter.x - globeRadius * 0.15f, globeCenter.y - globeRadius * 0.25f)
        )

        // Atmosphere edge halo
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Transparent,
                    Color(0xFF38BDF8).copy(alpha = 0.3f),
                    Color(0xFF67E8F9).copy(alpha = 0.85f)
                ),
                center = globeCenter,
                radius = globeRadius
            ),
            radius = globeRadius,
            center = globeCenter
        )

        // Cloud swirls
        drawCircle(
            color = cloudColor,
            radius = globeRadius * 0.22f,
            center = Offset(globeCenter.x - globeRadius * 0.45f, globeCenter.y - globeRadius * 0.10f)
        )
    }
}
