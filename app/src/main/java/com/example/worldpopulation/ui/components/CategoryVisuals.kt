package com.example.worldpopulation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Balance
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material.icons.filled.WorkOutline
import androidx.compose.ui.graphics.vector.ImageVector

object CategoryVisuals {
    fun getIcon(categoryId: String): ImageVector {
        return when (categoryId.lowercase()) {
            "population" -> Icons.Default.Groups
            "economy" -> Icons.Default.AccountBalance
            "environment" -> Icons.Default.Air
            "health" -> Icons.Default.MonitorHeart
            "education" -> Icons.Default.School
            "technology" -> Icons.Default.Memory
            "military" -> Icons.Default.Security
            "global_indices" -> Icons.AutoMirrored.Filled.TrendingUp
            "geography" -> Icons.Default.Public
            "tourism" -> Icons.Default.Flight
            "energy" -> Icons.Default.Bolt
            "agriculture" -> Icons.Default.Agriculture
            "politics" -> Icons.Default.Balance
            "infrastructure" -> Icons.Default.Apartment
            "climate" -> Icons.Default.WbSunny
            "employment" -> Icons.Default.WorkOutline
            "science" -> Icons.Default.Science
            "sports" -> Icons.Default.EmojiEvents
            "city_rankings" -> Icons.Default.GpsFixed
            "un_sdg_goals" -> Icons.Default.TrackChanges
            else -> Icons.Default.Public
        }
    }
}
