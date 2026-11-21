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
    private val indicatorDao = database.indicatorDao()
    private val countryDao = database.countryDao()
    private val discoveryDao = database.discoveryDao()
    private val storyDao = database.storyDao()
    private val syncManifestDao = database.syncManifestDao()

    companion object {
        const val DEFAULT_REMOTE_DATA_BASE_URL = "https://150ajit.github.io/world-number-data/data/"
    }

    suspend fun seedFromAssetsIfEmpty(): Boolean = withContext(Dispatchers.IO) {
        val valuesCount = indicatorDao.getValuesCount()
        val categoryCount = categoryDao.getCategoryCount()
        if (categoryCount >= 20 && valuesCount > 50) {
            return@withContext false
        }

        try {
            val assetManager = context.assets

            // 1. Seed Countries
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

            // 2. Seed Categories
            val categoriesJson = assetManager.open("data/categories.json").use {
                InputStreamReader(it).readText()
            }
            val categoriesType = object : TypeToken<List<CategoryEntity>>() {}.type
            val categoryEntities: List<CategoryEntity> = gson.fromJson(categoriesJson, categoriesType)
            categoryDao.insertCategories(categoryEntities)

            // 3. Seed Indicators
            val indicatorsJson = assetManager.open("data/category_indicators.json").use {
                InputStreamReader(it).readText()
            }
            val indicatorsType = object : TypeToken<List<CategoryIndicatorEntity>>() {}.type
            val indicatorEntities: List<CategoryIndicatorEntity> = gson.fromJson(indicatorsJson, indicatorsType)
            indicatorDao.insertIndicators(indicatorEntities)

            // 4. Seed Discoveries
            val discoveriesJson = assetManager.open("data/daily_discoveries.json").use {
                InputStreamReader(it).readText()
            }
            val discoveriesType = object : TypeToken<List<DailyDiscoveryEntity>>() {}.type
            val discoveryEntities: List<DailyDiscoveryEntity> = gson.fromJson(discoveriesJson, discoveriesType)
            discoveryDao.insertDiscoveries(discoveryEntities)

            // 5. Seed Stories
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

            // 6. Read Manifest & Process Datasets
            val manifestJson = assetManager.open("data/manifest.json").use {
                InputStreamReader(it).readText()
            }
            val manifestObj = JsonParser.parseString(manifestJson).asJsonObject
            val datasetsArray = manifestObj.getAsJsonArray("datasets")
            val manifestEntities = mutableListOf<SyncManifestEntity>()
            val allIndicatorValues = mutableListOf<CountryIndicatorValueEntity>()

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
                    val categoryKey = datasetPayload.get("categoryKey").asString
                    val catId = categoryKey.substringAfter("_")
                    val year = if (datasetPayload.has("year")) datasetPayload.get("year").asInt else 2024
                    val countriesObj = datasetPayload.getAsJsonObject("countries")

                    if (countriesObj != null) {
                        for (isoKey in countriesObj.keySet()) {
                            val countryData = countriesObj.getAsJsonObject(isoKey)
                            for (indicatorKey in countryData.keySet()) {
                                val value = countryData.get(indicatorKey).asDouble
                                allIndicatorValues.add(
                                    CountryIndicatorValueEntity(
                                        isoCode = isoKey,
                                        indicatorId = indicatorKey,
                                        categoryId = catId,
                                        year = year,
                                        value = value,
                                        formattedValue = formatVal(value)
                                    )
                                )
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

            // Batch insert indicator values and manifest records
            if (allIndicatorValues.isNotEmpty()) {
                indicatorDao.insertValues(allIndicatorValues)
            }
            if (manifestEntities.isNotEmpty()) {
                syncManifestDao.insertAll(manifestEntities)
            }
            true
        } catch (e: Exception) {
            android.util.Log.e("DatasetSyncManager", "Failed to seed assets", e)
            false
        }
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
                val dsVersion = dsObj.get("version").asString
                val dsPath = dsObj.get("path").asString
                val dsSha256 = dsObj.get("sha256").asString

                val localEntry = localManifestMap[dsId]
                if (localEntry == null || localEntry.sha256 != dsSha256 || localEntry.version != dsVersion) {
                    val fileRequest = okhttp3.Request.Builder()
                        .url("${baseUrl.trimEnd('/')}/$dsPath")
                        .build()
                    val fileResponse = client.newCall(fileRequest).execute()
                    if (!fileResponse.isSuccessful) continue
                    val fileBody = fileResponse.body?.string() ?: continue

                    // Checksum verification
                    val actualSha = calculateSha256(fileBody)
                    if (actualSha.equals(dsSha256, ignoreCase = true)) {
                        val parsed = JsonParser.parseString(fileBody).asJsonObject
                        val dataObj = parsed.getAsJsonObject("data") ?: continue
                        val updatedValues = mutableListOf<CountryIndicatorValueEntity>()

                        for (iso in dataObj.keySet()) {
                            val isoData = dataObj.getAsJsonObject(iso)
                            for (indKey in isoData.keySet()) {
                                val value = isoData.get(indKey).asDouble
                                updatedValues.add(
                                    CountryIndicatorValueEntity(
                                        isoCode = iso,
                                        indicatorId = indKey,
                                        categoryId = dsId,
                                        year = 2024,
                                        value = value,
                                        formattedValue = formatVal(value)
                                    )
                                )
                            }
                        }

                        indicatorDao.insertValues(updatedValues)
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

    private fun formatVal(value: Double): String {
        return when {
            value >= 1_000_000_000 -> "%.2fB".format(value / 1_000_000_000.0)
            value >= 1_000_000 -> "%.2fM".format(value / 1_000_000.0)
            value >= 1_000 -> "%,.0f".format(value)
            value % 1.0 == 0.0 -> "%.0f".format(value)
            else -> "%.2f".format(value)
        }
    }

    data class CountryDto(
        val isoCode: String,
        val name: String,
        val capital: String?,
        val region: String,
        val subregion: String?,
        val flagEmoji: String,
        val landArea: Double?,
        val lat: Double?,
        val lng: Double?,
        val aliases: String?
    )
}
