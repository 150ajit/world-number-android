package com.example.worldpopulation.data.local.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class CategoryEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val orderIndex: Int,
    val iconKey: String,
    val headlineStatistic: String,
    val summary: String,
    val sourceOrganization: String
)

@Entity(
    tableName = "subcategories",
    indices = [Index(value = ["categoryId"])]
)
data class SubcategoryEntity(
    @PrimaryKey
    val id: String,
    val categoryId: String,
    val name: String,
    val description: String,
    val orderIndex: Int,
    val iconKey: String? = null
)

@Entity(
    tableName = "category_indicators",
    indices = [
        Index(value = ["categoryId"]),
        Index(value = ["subcategoryId"])
    ]
)
data class CategoryIndicatorEntity(
    @PrimaryKey
    val indicatorId: String,
    val categoryId: String,
    val subcategoryId: String? = null,
    val name: String,
    val unit: String,
    val sortDirection: String, // "ASC" or "DESC"
    val sourceName: String
)

@Entity(
    tableName = "country_indicator_values",
    primaryKeys = ["isoCode", "indicatorId", "year"],
    indices = [
        Index(value = ["categoryId"]),
        Index(value = ["indicatorId"]),
        Index(value = ["isoCode"]),
        Index(value = ["year"])
    ]
)
data class CountryIndicatorValueEntity(
    val isoCode: String,
    val indicatorId: String,
    val categoryId: String,
    val year: Int,
    val value: Double,
    val formattedValue: String?,
    val globalRank: Int? = null,
    val status: String = "OBSERVED"
)

@Entity(tableName = "daily_discoveries")
data class DailyDiscoveryEntity(
    @PrimaryKey
    val dayOfYear: Int,
    val categoryId: String,
    val headline: String,
    val stat: String,
    val detail: String,
    val source: String,
    val isoCode: String?
)

@Entity(tableName = "data_stories")
data class DataStoryEntity(
    @PrimaryKey
    val id: String,
    val title: String,
    val subtitle: String,
    val category: String,
    val source: String,
    val readTimeMinutes: Int,
    val slidesJson: String
)

@Entity(tableName = "sync_manifest")
data class SyncManifestEntity(
    @PrimaryKey
    val datasetId: String,
    val version: String,
    val sha256: String,
    val lastSyncedTimestamp: Long
)
