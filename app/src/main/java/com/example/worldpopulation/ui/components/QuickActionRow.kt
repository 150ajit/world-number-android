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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.CompareArrows
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuickActionRow(
    onMapClick: () -> Unit,
    onCompareClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        // 1. Explore the World Card
        Card(
            modifier = Modifier
                .weight(1f)
                .height(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(onClick = onMapClick),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF101728)),
            border = BorderStroke(1.dp, Color(0xFF1E2B45))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Header
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF10B981).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Explore,
                            contentDescription = null,
                            tint = Color(0xFF10B981),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Explore the World",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 12.5.sp
                        )
                        Text(
                            text = "Interactive World Map",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF94A3B8),
                            fontSize = 10.sp
                        )
                    }
                }

                // Stylized colorful world map graphic in center
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .padding(horizontal = 4.dp),
                    contentAlignment = Alignment.Center
                ) {
                    StylizedMiniWorldMap()
                }

                // Action Pill Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF152238))
                        .padding(vertical = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Explore Map",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
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

        // 2. Compare Countries Card
        Card(
            modifier = Modifier
                .weight(1f)
                .height(160.dp)
                .clip(RoundedCornerShape(16.dp))
                .clickable(onClick = onCompareClick),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF101728)),
            border = BorderStroke(1.dp, Color(0xFF1E2B45))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Header
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFF97316).copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.CompareArrows,
                            contentDescription = null,
                            tint = Color(0xFFF97316),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column {
                        Text(
                            text = "Compare Countries",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            fontSize = 12.5.sp
                        )
                        Text(
                            text = "Compare up to 3 countries",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFF94A3B8),
                            fontSize = 10.sp
                        )
                    }
                }

                // Flags Visual: USA vs India
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // USA Flag Card
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF1A263D))
                            .padding(horizontal = 6.dp, vertical = 3.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🇺🇸", fontSize = 26.sp)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "VS",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Black,
                        color = Color.White,
                        letterSpacing = 1.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    // India Flag Card
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .background(Color(0xFF1A263D))
                            .padding(horizontal = 6.dp, vertical = 3.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "🇮🇳", fontSize = 26.sp)
                    }
                }

                // Action Pill Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0xFF152238))
                        .padding(vertical = 5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Start Compare",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.width(4.dp))
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

@Composable
private fun StylizedMiniWorldMap() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val w = size.width
        val h = size.height

        // Americas (Cyan / Teal)
        val americasPath = Path().apply {
            moveTo(w * 0.12f, h * 0.15f)
            lineTo(w * 0.32f, h * 0.18f)
            lineTo(w * 0.28f, h * 0.42f)
            lineTo(w * 0.20f, h * 0.48f)
            lineTo(w * 0.24f, h * 0.78f)
            lineTo(w * 0.16f, h * 0.85f)
            lineTo(w * 0.14f, h * 0.52f)
            close()
        }
        drawPath(americasPath, color = Color(0xFF06B6D4).copy(alpha = 0.85f))

        // Europe (Green)
        val europePath = Path().apply {
            moveTo(w * 0.44f, h * 0.16f)
            lineTo(w * 0.58f, h * 0.14f)
            lineTo(w * 0.56f, h * 0.36f)
            lineTo(w * 0.42f, h * 0.38f)
            close()
        }
        drawPath(europePath, color = Color(0xFF10B981).copy(alpha = 0.85f))

        // Africa (Orange / Amber)
        val africaPath = Path().apply {
            moveTo(w * 0.44f, h * 0.42f)
            lineTo(w * 0.60f, h * 0.42f)
            lineTo(w * 0.58f, h * 0.72f)
            lineTo(w * 0.48f, h * 0.78f)
            lineTo(w * 0.42f, h * 0.55f)
            close()
        }
        drawPath(africaPath, color = Color(0xFFF59E0B).copy(alpha = 0.85f))

        // Asia (Red / Orange / Coral)
        val asiaPath = Path().apply {
            moveTo(w * 0.60f, h * 0.12f)
            lineTo(w * 0.90f, h * 0.18f)
            lineTo(w * 0.86f, h * 0.48f)
            lineTo(w * 0.68f, h * 0.52f)
            lineTo(w * 0.60f, h * 0.38f)
            close()
        }
        drawPath(asiaPath, color = Color(0xFFEF4444).copy(alpha = 0.85f))

        // Australia (Bright Pink / Coral)
        drawCircle(
            color = Color(0xFFF43F5E).copy(alpha = 0.85f),
            radius = w * 0.07f,
            center = Offset(w * 0.82f, h * 0.72f)
        )
    }
}
