package com.example.worldpopulation.data.sync

import android.content.Context
import com.example.worldpopulation.data.local.database.AppDatabase
import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.data.local.entity.DataStoryEntity
import com.example.worldpopulation.data.local.entity.SyncManifestEntity
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStreamReader
import java.security.MessageDigest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DatasetSyncManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val database: AppDatabase,
    private val gson: Gson
) {
    private val categoryDao = database.categoryDao()
    private val subcategoryDao = database.subcategoryDao()
    private val indicatorDao = database.indicatorDao()
    private val countryDao = database.countryDao()
    private val discoveryDao = database.discoveryDao()
    private val storyDao = database.storyDao()
    private val syncManifestDao = database.syncManifestDao()

    companion object {
        const val DEFAULT_REMOTE_DATA_BASE_URL = "https://150ajit.github.io/world-number-data/data/"
    }

    suspend fun seedFromAssetsIfEmpty(): Boolean = withContext(Dispatchers.IO) {
        // Guarantee static baseline is inserted immediately into Room
        try {
            if (categoryDao.getCategoryCount() < 20) {
                categoryDao.insertCategories(com.example.worldpopulation.data.local.DefaultCategories.list)
            }
            if (subcategoryDao.getSubcategoryCount() < 270) {
                subcategoryDao.insertSubcategories(com.example.worldpopulation.data.local.DefaultSubcategories.list)
            }
            if (indicatorDao.getIndicatorCount() < 270) {
                indicatorDao.insertIndicators(com.example.worldpopulation.data.local.DefaultIndicators.list)
            }
            if (indicatorDao.getValuesCount() < 500) {
                com.example.worldpopulation.data.local.DefaultIndicatorValues.list.chunked(250).forEach {
                    indicatorDao.insertValues(it)
                }
            }
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to insert default baseline", e)
        }

        val valuesCount = indicatorDao.getValuesCount()
        val categoryCount = categoryDao.getCategoryCount()
        val indicatorCount = indicatorDao.getIndicatorCount()
        if (categoryCount >= 20 && indicatorCount >= 270 && valuesCount >= 50000) {
            return@withContext false
        }

        val assetManager = context.assets

        // 1. Seed Countries
        try {
            val countriesJson = assetManager.open("data/countries.json").use {
                InputStreamReader(it).readText()
            }
            val countriesType = object : TypeToken<List<CountryDto>>() {}.type
            val countryDtos: List<CountryDto> = gson.fromJson(countriesJson, countriesType)
            val countryEntities = countryDtos.map {
                CountryEntity(
                    isoCode = it.isoCode,
                    name = it.name,
                    aliases = it.aliases ?: it.name,
                    flagEmoji = it.flagEmoji,
                    region = it.region,
                    subregion = it.subregion ?: "",
                    landArea = it.landArea
                )
            }
            countryDao.insertCountries(countryEntities)
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed countries", e)
        }

        // 2. Seed Categories
        try {
            val categoriesJson = assetManager.open("data/categories.json").use {
                InputStreamReader(it).readText()
            }
            val categoriesType = object : TypeToken<List<CategoryEntity>>() {}.type
            val categoryEntities: List<CategoryEntity> = gson.fromJson(categoriesJson, categoriesType)
            categoryDao.insertCategories(categoryEntities)
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed categories", e)
        }

        // 2b. Seed Subcategories
        try {
            val subcatJson = assetManager.open("data/subcategories.json").use {
                InputStreamReader(it).readText()
            }
            val subcatType = object : TypeToken<List<com.example.worldpopulation.data.local.entity.SubcategoryEntity>>() {}.type
            val subcatEntities: List<com.example.worldpopulation.data.local.entity.SubcategoryEntity> = gson.fromJson(subcatJson, subcatType)
            subcategoryDao.insertSubcategories(subcatEntities)
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed subcategories", e)
        }

        // 3. Seed Indicators
        val indicatorUnitMap = com.example.worldpopulation.data.local.DefaultIndicators.list
            .associate { it.indicatorId to it.unit }
            .toMutableMap()
        try {
            val indicatorsJson = assetManager.open("data/category_indicators.json").use {
                InputStreamReader(it).readText()
            }
            val indicatorsType = object : TypeToken<List<CategoryIndicatorEntity>>() {}.type
            val indicatorEntities: List<CategoryIndicatorEntity> = gson.fromJson(indicatorsJson, indicatorsType)
            indicatorEntities.forEach { indicatorUnitMap[it.indicatorId] = it.unit }
            indicatorDao.insertIndicators(indicatorEntities)
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed indicators", e)
        }

        // 4. Seed Discoveries
        try {
            val discoveriesJson = assetManager.open("data/daily_discoveries.json").use {
                InputStreamReader(it).readText()
            }
            val discoveriesType = object : TypeToken<List<DailyDiscoveryEntity>>() {}.type
            val discoveryEntities: List<DailyDiscoveryEntity> = gson.fromJson(discoveriesJson, discoveriesType)
            discoveryDao.insertDiscoveries(discoveryEntities)
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed discoveries", e)
        }

        // 5. Seed Stories
        try {
            val storiesJson = assetManager.open("data/data_stories.json").use {
                InputStreamReader(it).readText()
            }
            val storiesArray = JsonParser.parseString(storiesJson).asJsonArray
            val storyEntities = mutableListOf<DataStoryEntity>()
            for (element in storiesArray) {
                val obj = element.asJsonObject
                storyEntities.add(
                    DataStoryEntity(
                        id = obj.get("id").asString,
                        title = obj.get("title").asString,
                        subtitle = obj.get("subtitle").asString,
                        category = obj.get("category").asString,
                        source = obj.get("source").asString,
                        readTimeMinutes = obj.get("readTimeMinutes").asInt,
                        slidesJson = obj.get("slides").toString()
                    )
                )
            }
            storyDao.insertStories(storyEntities)
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed stories", e)
        }

        // 6. Read Manifest & Process Datasets
        try {
            val manifestJson = assetManager.open("data/manifest.json").use {
                InputStreamReader(it).readText()
            }
            val manifestObj = JsonParser.parseString(manifestJson).asJsonObject
            val datasetsArray = manifestObj.getAsJsonArray("datasets")
            val manifestEntities = mutableListOf<SyncManifestEntity>()

            for (datasetElement in datasetsArray) {
                val dsObj = datasetElement.asJsonObject
                val dsId = dsObj.get("id").asString
                val dsPath = dsObj.get("path").asString
                val dsSha256 = dsObj.get("sha256").asString
                val dsVersion = dsObj.get("schemaVersion").asString

                try {
                    val datasetJson = assetManager.open("data/$dsPath").use {
                        InputStreamReader(it).readText()
                    }

                    val datasetPayload = JsonParser.parseString(datasetJson).asJsonObject
                    if (dsId == "historical_trends" || dsPath.contains("historical_trends")) {
                        val histDataObj = datasetPayload.getAsJsonObject("data")
                        val histValues = mutableListOf<CountryIndicatorValueEntity>()
                        if (histDataObj != null) {
                            for (isoKey in histDataObj.keySet()) {
                                val isoObj = histDataObj.getAsJsonObject(isoKey)
                                for (indKey in isoObj.keySet()) {
                                    val seriesObj = isoObj.getAsJsonObject(indKey)
                                    for (yrStr in seriesObj.keySet()) {
                                        val yr = yrStr.toIntOrNull() ?: 2024
                                        val v = seriesObj.get(yrStr).asDouble
                                        histValues.add(
                                            CountryIndicatorValueEntity(
                                                isoCode = isoKey,
                                                indicatorId = indKey,
                                                categoryId = "historical",
                                                year = yr,
                                                value = v,
                                                formattedValue = formatVal(v, indicatorUnitMap[indKey] ?: "")
                                            )
                                        )
                                    }
                                }
                            }
                        }
                        if (histValues.isNotEmpty()) {
                            histValues.chunked(250).forEach { chunk ->
                                indicatorDao.insertValues(chunk)
                            }
                        }
                    } else {
                        val categoryKey = if (datasetPayload.has("categoryKey")) datasetPayload.get("categoryKey").asString else dsId
                        val catId = categoryKey.substringAfter("_")
                        val year = if (datasetPayload.has("year")) datasetPayload.get("year").asInt else 2024
                        val countriesObj = datasetPayload.getAsJsonObject("countries")

                        val dsIndicatorValues = mutableListOf<CountryIndicatorValueEntity>()
                        if (countriesObj != null) {
                            for (isoKey in countriesObj.keySet()) {
                                val countryData = countriesObj.getAsJsonObject(isoKey)
                                for (indicatorKey in countryData.keySet()) {
                                    val value = countryData.get(indicatorKey).asDouble
                                    dsIndicatorValues.add(
                                        CountryIndicatorValueEntity(
                                            isoCode = isoKey,
                                            indicatorId = indicatorKey,
                                            categoryId = catId,
                                            year = year,
                                            value = value,
                                            formattedValue = formatVal(value, indicatorUnitMap[indicatorKey] ?: "")
                                        )
                                    )
                                }
                            }
                        }

                        // Insert each dataset's values immediately so categories are instantly available
                        if (dsIndicatorValues.isNotEmpty()) {
                            dsIndicatorValues.chunked(250).forEach { chunk ->
                                indicatorDao.insertValues(chunk)
                            }
                        }
                    }

                    manifestEntities.add(
                        SyncManifestEntity(
                            datasetId = dsId,
                            version = dsVersion,
                            sha256 = dsSha256,
                            lastSyncedTimestamp = System.currentTimeMillis()
                        )
                    )
                } catch (e: Exception) {
                    android.util.Log.e("DatasetSyncManager", "Failed to parse bundled dataset: $dsPath", e)
                }
            }

            if (manifestEntities.isNotEmpty()) {
                syncManifestDao.insertAll(manifestEntities)
            }
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to process manifest datasets", e)
        }
        true
    }

    suspend fun syncRemoteDatasets(baseUrl: String = DEFAULT_REMOTE_DATA_BASE_URL): Boolean = withContext(Dispatchers.IO) {
        try {
            val client = okhttp3.OkHttpClient.Builder()
                .connectTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
                .readTimeout(15, java.util.concurrent.TimeUnit.SECONDS)
                .build()

            val manifestRequest = okhttp3.Request.Builder()
                .url("${baseUrl.trimEnd('/')}/manifest.json")
                .build()

            val manifestResponse = client.newCall(manifestRequest).execute()
            if (!manifestResponse.isSuccessful) return@withContext false

            val manifestBody = manifestResponse.body?.string() ?: return@withContext false
            val remoteManifest = JsonParser.parseString(manifestBody).asJsonObject
            val datasetsArray = remoteManifest.getAsJsonArray("datasets") ?: return@withContext false

            val localManifestMap = syncManifestDao.getAllSynced().associateBy { it.datasetId }

            for (elem in datasetsArray) {
                val dsObj = elem.asJsonObject
                val dsId = dsObj.get("id").asString
                val dsVersion = if (dsObj.has("schemaVersion")) dsObj.get("schemaVersion").asString
                    else if (dsObj.has("version")) dsObj.get("version").asString
                    else "1.0.0"
                val dsPath = dsObj.get("path").asString
                val dsSha256 = if (dsObj.has("sha256")) dsObj.get("sha256").asString else ""

                val localEntry = localManifestMap[dsId]
                if (localEntry == null || localEntry.sha256 != dsSha256 || localEntry.version != dsVersion) {
                    val fileRequest = okhttp3.Request.Builder()
                        .url("${baseUrl.trimEnd('/')}/$dsPath")
                        .build()
                    val fileResponse = client.newCall(fileRequest).execute()
                    if (!fileResponse.isSuccessful) continue
                    val fileBody = fileResponse.body?.string() ?: continue

                    try {
                        val parsed = JsonParser.parseString(fileBody).asJsonObject
                        val countriesObj = if (parsed.has("countries")) parsed.getAsJsonObject("countries")
                            else parsed.getAsJsonObject("data") ?: continue
                        val catId = if (parsed.has("categoryKey")) parsed.get("categoryKey").asString.substringAfter("_")
                            else dsId.substringAfter("_")
                        val year = if (parsed.has("year")) parsed.get("year").asInt else 2024
                        val updatedValues = mutableListOf<CountryIndicatorValueEntity>()

                        val remoteUnitMap = com.example.worldpopulation.data.local.DefaultIndicators.list
                            .associate { it.indicatorId to it.unit }
                        for (iso in countriesObj.keySet()) {
                            val isoData = countriesObj.getAsJsonObject(iso)
                            for (indKey in isoData.keySet()) {
                                val value = isoData.get(indKey).asDouble
                                updatedValues.add(
                                    CountryIndicatorValueEntity(
                                        isoCode = iso,
                                        indicatorId = indKey,
                                        categoryId = catId,
                                        year = year,
                                        value = value,
                                        formattedValue = formatVal(value, remoteUnitMap[indKey] ?: "")
                                    )
                                )
                            }
                        }

                        if (updatedValues.isNotEmpty()) {
                            updatedValues.chunked(250).forEach { chunk ->
                                indicatorDao.insertValues(chunk)
                            }
                        }
                        syncManifestDao.insertAll(
                            listOf(
                                SyncManifestEntity(
                                    datasetId = dsId,
                                    version = dsVersion,
                                    sha256 = dsSha256,
                                    lastSyncedTimestamp = System.currentTimeMillis()
                                )
                            )
                        )
                    } catch (e: Exception) {
                        android.util.Log.e("DatasetSyncManager", "Failed to parse remote dataset $dsPath", e)
                    }
                }
            }
            true
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }

    private fun calculateSha256(text: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(text.toByteArray(Charsets.UTF_8))
        return hash.joinToString("") { "%02x".format(it) }
    }

    private fun formatVal(value: Double, unit: String = ""): String {
        val u = unit.lowercase()
        val hasMagnitudeOrMetricUnit = u.contains("thousand") ||
            u.contains("million") ||
            u.contains("billion") ||
            u.contains("trillion") ||
            u.contains("twh") ||
            u.contains("kwh") ||
            u.contains("gwh") ||
            u.contains("usd") ||
            u.contains("eur") ||
            u.contains("mt") ||
            u.contains("bcm") ||
            u.contains("bpd") ||
            u.contains("km") ||
            u.contains("%") ||
            u.contains("score") ||
            u.contains("index")

        return when {
            !hasMagnitudeOrMetricUnit && value >= 1_000_000_000 -> "%.2fB".format(value / 1_000_000_000.0)
            !hasMagnitudeOrMetricUnit && value >= 1_000_000 -> "%.2fM".format(value / 1_000_000.0)
            value >= 1_000 -> "%,.0f".format(value)
            value % 1.0 == 0.0 -> "%.0f".format(value)
            else -> "%.2f".format(value)
        }
    }

    @androidx.annotation.Keep
    data class CountryDto(
        @com.google.gson.annotations.SerializedName("isoCode") val isoCode: String,
        @com.google.gson.annotations.SerializedName("name") val name: String,
        @com.google.gson.annotations.SerializedName("capital") val capital: String?,
        @com.google.gson.annotations.SerializedName("region") val region: String,
        @com.google.gson.annotations.SerializedName("subregion") val subregion: String?,
        @com.google.gson.annotations.SerializedName("flagEmoji") val flagEmoji: String,
        @com.google.gson.annotations.SerializedName("landArea") val landArea: Double?,
        @com.google.gson.annotations.SerializedName("lat") val lat: Double?,
        @com.google.gson.annotations.SerializedName("lng") val lng: Double?,
        @com.google.gson.annotations.SerializedName("aliases") val aliases: String?
    )
}
