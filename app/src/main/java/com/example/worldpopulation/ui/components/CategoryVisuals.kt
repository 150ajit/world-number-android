package com.example.worldpopulation.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.TrendingUp
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Agriculture
import androidx.compose.material.icons.filled.Apartment
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Eco
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationCity
import androidx.compose.material.icons.filled.Memory
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Science
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

object CategoryVisuals {
    fun getIcon(categoryId: String): ImageVector {
        return when (categoryId.lowercase()) {
            "population" -> Icons.Default.Groups
            "economy" -> Icons.Default.MonetizationOn
            "environment" -> Icons.Default.Eco
            "health" -> Icons.Default.MonitorHeart
            "education" -> Icons.Default.School
            "technology" -> Icons.Default.Memory
            "military" -> Icons.Default.Shield
            "global_indices" -> Icons.AutoMirrored.Filled.TrendingUp
            "geography" -> Icons.Default.Public
            "tourism" -> Icons.Default.Flight
            "energy" -> Icons.Default.Bolt
            "agriculture" -> Icons.Default.Agriculture
            "politics" -> Icons.Default.AccountBalance
            "infrastructure" -> Icons.Default.Apartment
            "climate" -> Icons.Default.AcUnit
            "employment" -> Icons.Default.Work
            "science" -> Icons.Default.Science
            "sports" -> Icons.Default.EmojiEvents
            "city_rankings" -> Icons.Default.LocationCity
            "un_sdg_goals" -> Icons.Default.TrackChanges
            else -> Icons.Default.Public
        }
    }

    fun getColor(categoryId: String): Color {
        return when (categoryId.lowercase()) {
            "population" -> Color(0xFF38BDF8) // Sky cyan
            "economy" -> Color(0xFFFBBF24) // Gold
            "environment" -> Color(0xFF34D399) // Emerald green
            "health" -> Color(0xFFF87171) // Red / Coral
            "education" -> Color(0xFF60A5FA) // Soft blue
            "technology" -> Color(0xFF38BDF8) // Cyan
            "military" -> Color(0xFFA3E635) // Olive lime
            "global_indices" -> Color(0xFF38BDF8) // Blue
            "geography" -> Color(0xFF60A5FA) // Blue
            "tourism" -> Color(0xFF4ADE80) // Light green
            "energy" -> Color(0xFFFACC15) // Bright yellow
            "agriculture" -> Color(0xFFFBBF24) // Golden wheat
            "politics" -> Color(0xFF818CF8) // Indigo
            "infrastructure" -> Color(0xFFA855F7) // Purple
            "climate" -> Color(0xFF38BDF8) // Cyan
            "employment" -> Color(0xFFFB923C) // Orange
            "science" -> Color(0xFF818CF8) // Indigo
            "sports" -> Color(0xFFFBBF24) // Gold
            "city_rankings" -> Color(0xFF60A5FA) // Blue
            "un_sdg_goals" -> Color(0xFFF43F5E) // Rose red
            else -> Color(0xFF38BDF8)
        }
    }

    fun getSubtitle(categoryId: String, headline: String = ""): String {
        return when (categoryId.lowercase()) {
            "population" -> if (headline.isNotBlank()) "$headline people worldwide" else "8.11B people worldwide"
            "economy" -> "Global wealth & growth"
            "environment" -> "Our planet's health"
            "health" -> "Health for all"
            "education" -> "Global learning"
            "technology" -> "Innovation & access"
            "military" -> "Global defense"
            "global_indices" -> "Key world indices"
            "geography" -> "Our world in numbers"
            "tourism" -> "Explore the world"
            "energy" -> "Powering the world"
            "agriculture" -> "Feeding the planet"
            "politics" -> "Governance & systems"
            "infrastructure" -> "Building a connected world"
            "climate" -> "A changing climate"
            "employment" -> "Jobs & work"
            "science" -> "Discovery & research"
            "sports" -> "Global sports"
            "city_rankings" -> "World's top cities"
            "un_sdg_goals" -> "A sustainable future"
            else -> headline.ifBlank { "World statistics" }
        }
    }
}
