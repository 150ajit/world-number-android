package com.example.worldpopulation.sync

import com.example.worldpopulation.data.local.entity.CategoryEntity
import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity
import com.example.worldpopulation.data.local.entity.CountryEntity
import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity
import com.example.worldpopulation.data.local.entity.DailyDiscoveryEntity
import com.example.worldpopulation.data.local.entity.DataStoryEntity
import com.example.worldpopulation.data.local.entity.SyncManifestEntity
import com.example.worldpopulation.data.sync.DatasetSyncManager
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class DatasetAssetsJsonTest {

    private val gson = Gson()
    private val assetsDir = File("src/main/assets/data")

    @Test
    fun testParseCountriesJson() {
        val file = File(assetsDir, "countries.json")
        assertTrue("countries.json should exist", file.exists())
        val json = file.readText()
        val type = object : TypeToken<List<DatasetSyncManager.CountryDto>>() {}.type
        val dtos: List<DatasetSyncManager.CountryDto> = gson.fromJson(json, type)
        assertFalse("Countries should not be empty", dtos.isEmpty())
        println("Loaded countries: ${dtos.size}")
    }

    @Test
    fun testParseCategoriesJson() {
        val file = File(assetsDir, "categories.json")
        assertTrue("categories.json should exist", file.exists())
        val json = file.readText()
        val type = object : TypeToken<List<CategoryEntity>>() {}.type
        val categories: List<CategoryEntity> = gson.fromJson(json, type)
        assertFalse("Categories should not be empty", categories.isEmpty())
        println("Loaded categories: ${categories.size}")
    }

    @Test
    fun testParseCategoryIndicatorsJson() {
        val file = File(assetsDir, "category_indicators.json")
        assertTrue("category_indicators.json should exist", file.exists())
        val json = file.readText()
        val type = object : TypeToken<List<CategoryIndicatorEntity>>() {}.type
        val indicators: List<CategoryIndicatorEntity> = gson.fromJson(json, type)
        assertFalse("Indicators should not be empty", indicators.isEmpty())
        val popIndicators = indicators.filter { it.categoryId == "population" }
        assertFalse("Population indicators should not be empty", popIndicators.isEmpty())
        println("Loaded total indicators: ${indicators.size}, population indicators: ${popIndicators.size}")
    }

    @Test
    fun testDefaultIndicatorsListIntegrity() {
        val indicators = com.example.worldpopulation.data.local.DefaultIndicators.list
        assertTrue("DefaultIndicators should have at least 40 items", indicators.size >= 40)
        val categories = com.example.worldpopulation.data.local.DefaultCategories.list
        for (cat in categories) {
            val catIndicators = com.example.worldpopulation.data.local.DefaultIndicators.getIndicatorsForCategory(cat.id)
            assertFalse("Category ${cat.id} must have default indicators", catIndicators.isEmpty())
        }
    }

    @Test
    fun testDefaultIndicatorValuesIntegrity() {
        val values = com.example.worldpopulation.data.local.DefaultIndicatorValues.list
        assertTrue("DefaultIndicatorValues should have >= 500 items", values.size >= 500)
        
        // Verify Economy indicators specifically
        val gdpNominal = com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator("gdp_nominal", true)
        assertFalse("gdp_nominal should have countries", gdpNominal.isEmpty())
        assertTrue("gdp_nominal should have >= 10 countries", gdpNominal.size >= 10)
        
        // Verify Population indicators
        val popTotal = com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator("pop_total", true)
        assertFalse("pop_total should have countries", popTotal.isEmpty())

        // Verify across all categories
        val categories = com.example.worldpopulation.data.local.DefaultCategories.list
        for (cat in categories) {
            val indicators = com.example.worldpopulation.data.local.DefaultIndicators.getIndicatorsForCategory(cat.id)
            for (ind in indicators) {
                val indValues = com.example.worldpopulation.data.local.DefaultIndicatorValues.getValuesForIndicator(ind.indicatorId)
                assertFalse("Indicator ${ind.indicatorId} in category ${cat.id} must have data points", indValues.isEmpty())
            }
        }
    }

    @Test
    fun testParseDailyDiscoveriesJson() {
        val file = File(assetsDir, "daily_discoveries.json")
        assertTrue("daily_discoveries.json should exist", file.exists())
        val json = file.readText()
        val type = object : TypeToken<List<DailyDiscoveryEntity>>() {}.type
        val discoveries: List<DailyDiscoveryEntity> = gson.fromJson(json, type)
        assertFalse("Discoveries should not be empty", discoveries.isEmpty())
        println("Loaded discoveries: ${discoveries.size}")
    }

    @Test
    fun testParseDataStoriesJson() {
        val file = File(assetsDir, "data_stories.json")
        assertTrue("data_stories.json should exist", file.exists())
        val json = file.readText()
        val array = JsonParser.parseString(json).asJsonArray
        assertFalse("Stories should not be empty", array.isEmpty)
        println("Loaded stories: ${array.size()}")
    }

    @Test
    fun testParseManifestAndAllDatasets() {
        val file = File(assetsDir, "manifest.json")
        assertTrue("manifest.json should exist", file.exists())
        val json = file.readText()
        val manifestObj = JsonParser.parseString(json).asJsonObject
        val datasetsArray = manifestObj.getAsJsonArray("datasets")
        assertNotNull(datasetsArray)
        assertFalse(datasetsArray.isEmpty)

        var totalValues = 0
        for (datasetElement in datasetsArray) {
            val dsObj = datasetElement.asJsonObject
            val dsId = dsObj.get("id").asString
            val dsPath = dsObj.get("path").asString
            val dsFile = File(assetsDir, dsPath)
            assertTrue("Dataset file $dsPath must exist", dsFile.exists())
            val dsJson = dsFile.readText()
            val payload = JsonParser.parseString(dsJson).asJsonObject
            val categoryKey = payload.get("categoryKey").asString
            val catId = categoryKey.substringAfter("_")
            val countriesObj = payload.getAsJsonObject("countries")
            assertNotNull("countries object should exist in $dsPath", countriesObj)
            for (iso in countriesObj.keySet()) {
                val countryData = countriesObj.getAsJsonObject(iso)
                for (ind in countryData.keySet()) {
                    totalValues++
                }
            }
        }
        println("Successfully parsed all datasets, total indicator values: $totalValues")
    }

    @Test
    fun generateDefaultIndicatorValuesFile() {
        val manifestFile = File(assetsDir, "manifest.json")
        val manifestObj = JsonParser.parseString(manifestFile.readText()).asJsonObject
        val datasetsArray = manifestObj.getAsJsonArray("datasets")

        val sb = StringBuilder()
        sb.appendLine("package com.example.worldpopulation.data.local")
        sb.appendLine()
        sb.appendLine("import com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity")
        sb.appendLine()
        sb.appendLine("object DefaultIndicatorValues {")
        sb.appendLine("    val list: List<CountryIndicatorValueEntity> by lazy {")
        sb.appendLine("        listOf(")

        var count = 0
        for (datasetElement in datasetsArray) {
            val dsObj = datasetElement.asJsonObject
            val dsPath = dsObj.get("path").asString
            val dsFile = File(assetsDir, dsPath)
            val payload = JsonParser.parseString(dsFile.readText()).asJsonObject
            val categoryKey = payload.get("categoryKey").asString
            val catId = categoryKey.substringAfter("_")
            val year = if (payload.has("year")) payload.get("year").asInt else 2024
            val countriesObj = payload.getAsJsonObject("countries") ?: continue

            for (isoKey in countriesObj.keySet()) {
                val countryData = countriesObj.getAsJsonObject(isoKey)
                for (indicatorKey in countryData.keySet()) {
                    val value = countryData.get(indicatorKey).asDouble
                    val formatted = when {
                        value >= 1_000_000_000 -> "%.2fB".format(java.util.Locale.US, value / 1_000_000_000.0)
                        value >= 1_000_000 -> "%.2fM".format(java.util.Locale.US, value / 1_000_000.0)
                        value >= 1_000 -> "%,.0f".format(java.util.Locale.US, value)
                        value % 1.0 == 0.0 -> "%.0f".format(java.util.Locale.US, value)
                        else -> "%.2f".format(java.util.Locale.US, value)
                    }
                    sb.append("            CountryIndicatorValueEntity(")
                    sb.append("isoCode = \"$isoKey\", ")
                    sb.append("indicatorId = \"$indicatorKey\", ")
                    sb.append("categoryId = \"$catId\", ")
                    sb.append("year = $year, ")
                    sb.append("value = $value, ")
                    sb.append("formattedValue = \"$formatted\", ")
                    sb.append("status = \"OBSERVED\")")
                    sb.appendLine(",")
                    count++
                }
            }
        }
        sb.appendLine("        )")
        sb.appendLine("    }")
        sb.appendLine()
        sb.appendLine("    fun getValuesForIndicator(indicatorId: String, sortDesc: Boolean = true): List<CountryIndicatorValueEntity> {")
        sb.appendLine("        val filtered = list.filter { it.indicatorId.equals(indicatorId, ignoreCase = true) }")
        sb.appendLine("        return if (sortDesc) filtered.sortedByDescending { it.value } else filtered.sortedBy { it.value }")
        sb.appendLine("    }")
        sb.appendLine("}")

        val targetFile = File("src/main/java/com/example/worldpopulation/data/local/DefaultIndicatorValues.kt")
        targetFile.writeText(sb.toString())
        println("Generated DefaultIndicatorValues.kt with $count records at ${targetFile.absolutePath}")
    }
}
