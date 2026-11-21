package com.example.worldpopulation.data.local.fallback

import com.example.worldpopulation.data.local.entity.AgeGenderPopulationEntity
import com.example.worldpopulation.data.local.entity.CountryEntity
import com.example.worldpopulation.data.local.entity.CountryPopulationEntity
import com.example.worldpopulation.data.local.entity.DataSourceMetadataEntity
import com.example.worldpopulation.data.local.entity.DemographicIndicatorEntity
import com.example.worldpopulation.data.local.entity.HistoricalPopulationEntity
import com.example.worldpopulation.data.local.entity.WorldPopulationEntity

object BundledPopulationData {

    val metadata = DataSourceMetadataEntity(
        provider = "United Nations Population Division",
        datasetName = "World Population Prospects",
        datasetVersion = "2024 Revision",
        referenceYear = 2026,
        retrievedAt = 1719792000000L, // UN WPP 2024 release date
        sourceUrl = "https://population.un.org/wpp/",
        dataType = "PROJECTION",
        projectionVariant = "Medium variant"
    )

    // Baseline: July 1, 2026 reference projection calibrated to UN WPP 2024 (Medium Variant)
    val worldPopulation = WorldPopulationEntity(
        id = 1,
        population = 8_301_598_844L,
        populationYear = 2026,
        baselineTimestamp = 1782864000000L, // July 1, 2026 00:00:00 UTC
        annualChange = 71_000_000.0,
        growthRate = 0.86,
        dataType = "PROJECTION"
    )

    val countries = listOf(
        CountryEntity("IND", "India", "Bharat,Hindustan,IN", "🇮🇳", "Asia", "Southern Asia", 2973190.0),
        CountryEntity("CHN", "China", "People's Republic of China,PRC,CN", "🇨🇳", "Asia", "Eastern Asia", 9388211.0),
        CountryEntity("USA", "United States", "USA,United States of America,US", "🇺🇸", "Americas", "Northern America", 9147420.0),
        CountryEntity("IDN", "Indonesia", "Republic of Indonesia,ID", "🇮🇩", "Asia", "South-Eastern Asia", 1811570.0),
        CountryEntity("PAK", "Pakistan", "Islamic Republic of Pakistan,PK", "🇵🇰", "Asia", "Southern Asia", 770880.0),
        CountryEntity("NGA", "Nigeria", "Federal Republic of Nigeria,NG", "🇳🇬", "Africa", "Western Africa", 910770.0),
        CountryEntity("BRA", "Brazil", "Brasil,Federative Republic of Brazil,BR", "🇧🇷", "Americas", "South America", 8358140.0),
        CountryEntity("BGD", "Bangladesh", "People's Republic of Bangladesh,BD", "🇧🇩", "Asia", "Southern Asia", 130170.0),
        CountryEntity("RUS", "Russia", "Russian Federation,RU", "🇷🇺", "Europe", "Eastern Europe", 16376870.0),
        CountryEntity("ETH", "Ethiopia", "Federal Democratic Republic of Ethiopia,ET", "🇪🇹", "Africa", "Eastern Africa", 1000000.0),
        CountryEntity("MEX", "Mexico", "United Mexican States,MX", "🇲🇽", "Americas", "Central America", 1943950.0),
        CountryEntity("JPN", "Japan", "Nihon,Nippon,JP", "🇯🇵", "Asia", "Eastern Asia", 364500.0),
        CountryEntity("PHL", "Philippines", "Republic of the Philippines,PH", "🇵🇭", "Asia", "South-Eastern Asia", 298170.0),
        CountryEntity("EGY", "Egypt", "Arab Republic of Egypt,EG", "🇪🇬", "Africa", "Northern Africa", 995450.0),
        CountryEntity("COD", "DR Congo", "Democratic Republic of the Congo,Congo-Kinshasa,CD", "🇨🇩", "Africa", "Middle Africa", 2267050.0),
        CountryEntity("VNM", "Vietnam", "Socialist Republic of Vietnam,VN", "🇻🇳", "Asia", "South-Eastern Asia", 310070.0),
        CountryEntity("TUR", "Turkey", "Türkiye,Republic of Turkey,TR", "🇹🇷", "Asia", "Western Asia", 769630.0),
        CountryEntity("IRN", "Iran", "Islamic Republic of Iran,IR", "🇮🇷", "Asia", "Southern Asia", 1628760.0),
        CountryEntity("DEU", "Germany", "Deutschland,Federal Republic of Germany,DE", "🇩🇪", "Europe", "Western Europe", 349380.0),
        CountryEntity("GBR", "United Kingdom", "UK,Great Britain,Britain,England,GB", "🇬🇧", "Europe", "Northern Europe", 241930.0),
        CountryEntity("FRA", "France", "French Republic,FR", "🇫🇷", "Europe", "Western Europe", 547557.0),
        CountryEntity("ITA", "Italy", "Italia,Italian Republic,IT", "🇮🇹", "Europe", "Southern Europe", 294140.0),
        CountryEntity("ZAF", "South Africa", "Republic of South Africa,ZA", "🇿🇦", "Africa", "Southern Africa", 1213090.0),
        CountryEntity("KOR", "South Korea", "Republic of Korea,Korea,KR", "🇰🇷", "Asia", "Eastern Asia", 97600.0),
        CountryEntity("CAN", "Canada", "Dominion of Canada,CA", "🇨🇦", "Americas", "Northern America", 8965590.0),
        CountryEntity("AUS", "Australia", "Commonwealth of Australia,AU", "🇦🇺", "Oceania", "Australia and New Zealand", 7682300.0)
    )

    val countryPopulations = listOf(
        CountryPopulationEntity("IND", "India", 1_450_935_791L, 2026, 1767225600000L, 12_900_000.0, 0.89, 2973190.0, 488.0, "Asia", "Southern Asia", "PROJECTION", 1),
        CountryPopulationEntity("CHN", "China", 1_419_321_278L, 2026, 1767225600000L, -2_200_000.0, -0.15, 9388211.0, 151.0, "Asia", "Eastern Asia", "PROJECTION", 2),
        CountryPopulationEntity("USA", "United States", 345_426_571L, 2026, 1767225600000L, 1_850_000.0, 0.53, 9147420.0, 38.0, "Americas", "Northern America", "PROJECTION", 3),
        CountryPopulationEntity("IDN", "Indonesia", 283_487_931L, 2026, 1767225600000L, 2_150_000.0, 0.76, 1811570.0, 156.0, "Asia", "South-Eastern Asia", "PROJECTION", 4),
        CountryPopulationEntity("PAK", "Pakistan", 251_269_164L, 2026, 1767225600000L, 4_900_000.0, 1.95, 770880.0, 326.0, "Asia", "Southern Asia", "PROJECTION", 5),
        CountryPopulationEntity("NGA", "Nigeria", 232_679_478L, 2026, 1767225600000L, 5_450_000.0, 2.34, 910770.0, 255.0, "Africa", "Western Africa", "PROJECTION", 6),
        CountryPopulationEntity("BRA", "Brazil", 211_998_573L, 2026, 1767225600000L, 1_080_000.0, 0.51, 8358140.0, 25.0, "Americas", "South America", "PROJECTION", 7),
        CountryPopulationEntity("BGD", "Bangladesh", 173_562_364L, 2026, 1767225600000L, 1_720_000.0, 0.99, 130170.0, 1333.0, "Asia", "Southern Asia", "PROJECTION", 8),
        CountryPopulationEntity("RUS", "Russia", 144_820_423L, 2026, 1767225600000L, -280_000.0, -0.19, 16376870.0, 8.8, "Europe", "Eastern Europe", "PROJECTION", 9),
        CountryPopulationEntity("ETH", "Ethiopia", 132_059_767L, 2026, 1767225600000L, 3_200_000.0, 2.42, 1000000.0, 132.0, "Africa", "Eastern Africa", "PROJECTION", 10),
        CountryPopulationEntity("MEX", "Mexico", 130_739_927L, 2026, 1767225600000L, 950_000.0, 0.73, 1943950.0, 67.0, "Americas", "Central America", "PROJECTION", 11),
        CountryPopulationEntity("JPN", "Japan", 123_753_041L, 2026, 1767225600000L, -660_000.0, -0.53, 364500.0, 339.0, "Asia", "Eastern Asia", "PROJECTION", 12),
        CountryPopulationEntity("PHL", "Philippines", 115_843_670L, 2026, 1767225600000L, 1_710_000.0, 1.48, 298170.0, 388.0, "Asia", "South-Eastern Asia", "PROJECTION", 13),
        CountryPopulationEntity("EGY", "Egypt", 116_538_258L, 2026, 1767225600000L, 1_780_000.0, 1.53, 995450.0, 117.0, "Africa", "Northern Africa", "PROJECTION", 14),
        CountryPopulationEntity("COD", "DR Congo", 109_276_265L, 2026, 1767225600000L, 3_420_000.0, 3.13, 2267050.0, 48.0, "Africa", "Middle Africa", "PROJECTION", 15),
        CountryPopulationEntity("VNM", "Vietnam", 99_863_200L, 2026, 1767225600000L, 680_000.0, 0.68, 310070.0, 322.0, "Asia", "South-Eastern Asia", "PROJECTION", 16),
        CountryPopulationEntity("TUR", "Turkey", 86_260_700L, 2026, 1767225600000L, 480_000.0, 0.56, 769630.0, 112.0, "Asia", "Western Asia", "PROJECTION", 17),
        CountryPopulationEntity("IRN", "Iran", 89_809_700L, 2026, 1767225600000L, 640_000.0, 0.71, 1628760.0, 55.0, "Asia", "Southern Asia", "PROJECTION", 18),
        CountryPopulationEntity("DEU", "Germany", 84_552_242L, 2026, 1767225600000L, 95_000.0, 0.11, 349380.0, 242.0, "Europe", "Western Europe", "PROJECTION", 19),
        CountryPopulationEntity("GBR", "United Kingdom", 68_265_209L, 2026, 1767225600000L, 230_000.0, 0.34, 241930.0, 282.0, "Europe", "Northern Europe", "PROJECTION", 20),
        CountryPopulationEntity("FRA", "France", 66_548_530L, 2026, 1767225600000L, 130_000.0, 0.20, 547557.0, 122.0, "Europe", "Western Europe", "PROJECTION", 21),
        CountryPopulationEntity("ITA", "Italy", 58_697_744L, 2026, 1767225600000L, -165_000.0, -0.28, 294140.0, 199.0, "Europe", "Southern Europe", "PROJECTION", 22),
        CountryPopulationEntity("ZAF", "South Africa", 64_007_187L, 2026, 1767225600000L, 840_000.0, 1.31, 1213090.0, 53.0, "Africa", "Southern Africa", "PROJECTION", 23),
        CountryPopulationEntity("KOR", "South Korea", 51_717_590L, 2026, 1767225600000L, -75_000.0, -0.14, 97600.0, 530.0, "Asia", "Eastern Asia", "PROJECTION", 24),
        CountryPopulationEntity("CAN", "Canada", 39_742_430L, 2026, 1767225600000L, 480_000.0, 1.21, 8965590.0, 4.4, "Americas", "Northern America", "PROJECTION", 25),
        CountryPopulationEntity("AUS", "Australia", 26_713_205L, 2026, 1767225600000L, 330_000.0, 1.24, 7682300.0, 3.5, "Oceania", "Australia and New Zealand", "PROJECTION", 26)
    )

    fun getHistoricalPopulations(): List<HistoricalPopulationEntity> {
        val list = mutableListOf<HistoricalPopulationEntity>()
        val years = listOf(1950, 1960, 1970, 1980, 1990, 2000, 2010, 2020, 2026, 2030, 2040, 2050, 2070, 2100)
        
        // World historical & projected (UN WPP 2024 Medium Variant)
        val worldHistory = mapOf(
            1950 to 2_499_000_000L,
            1960 to 3_034_000_000L,
            1970 to 3_700_000_000L,
            1980 to 4_458_000_000L,
            1990 to 5_327_000_000L,
            2000 to 6_143_000_000L,
            2010 to 6_956_000_000L,
            2020 to 7_840_000_000L,
            2026 to 8_203_000_000L,
            2030 to 8_512_000_000L,
            2040 to 9_188_000_000L,
            2050 to 9_709_000_000L,
            2070 to 10_250_000_000L,
            2100 to 10_180_000_000L
        )
        for ((y, pop) in worldHistory) {
            val type = when {
                y < 2024 -> "HISTORICAL"
                y == 2024 -> "ESTIMATE"
                else -> "PROJECTION"
            }
            list.add(HistoricalPopulationEntity("WLD", y, pop, type))
        }

        // India historical & projected
        val indHistory = mapOf(
            1950 to 376_325_200L,
            1960 to 449_649_900L,
            1970 to 557_501_300L,
            1980 to 696_828_385L,
            1990 to 870_452_165L,
            2000 to 1_059_633_675L,
            2010 to 1_240_613_620L,
            2020 to 1_396_387_127L,
            2026 to 1_450_935_791L,
            2030 to 1_515_000_000L,
            2040 to 1_605_000_000L,
            2050 to 1_670_000_000L,
            2070 to 1_685_000_000L,
            2100 to 1_530_000_000L
        )
        for ((y, pop) in indHistory) {
            val type = if (y <= 2023) "HISTORICAL" else "PROJECTION"
            list.add(HistoricalPopulationEntity("IND", y, pop, type))
        }

        // China
        val chnHistory = mapOf(
            1950 to 543_979_233L,
            1960 to 667_070_000L,
            1970 to 818_315_000L,
            1980 to 981_235_000L,
            1990 to 1_135_185_000L,
            2000 to 1_262_645_000L,
            2010 to 1_348_191_368L,
            2020 to 1_424_929_781L,
            2026 to 1_419_321_278L,
            2030 to 1_400_000_000L,
            2040 to 1_360_000_000L,
            2050 to 1_295_000_000L,
            2070 to 1_080_000_000L,
            2100 to 766_000_000L
        )
        for ((y, pop) in chnHistory) {
            val type = if (y <= 2023) "HISTORICAL" else "PROJECTION"
            list.add(HistoricalPopulationEntity("CHN", y, pop, type))
        }

        // USA
        val usaHistory = mapOf(
            1950 to 158_804_395L,
            1960 to 186_808_228L,
            1970 to 209_588_150L,
            1980 to 229_763_052L,
            1990 to 252_529_950L,
            2000 to 282_398_554L,
            2010 to 311_182_845L,
            2020 to 335_942_003L,
            2026 to 345_426_571L,
            2030 to 352_000_000L,
            2040 to 366_000_000L,
            2050 to 375_000_000L,
            2070 to 388_000_000L,
            2100 to 394_000_000L
        )
        for ((y, pop) in usaHistory) {
            val type = if (y <= 2023) "HISTORICAL" else "PROJECTION"
            list.add(HistoricalPopulationEntity("USA", y, pop, type))
        }

        // Japan
        val jpnHistory = mapOf(
            1950 to 82_199_470L,
            1960 to 92_500_572L,
            1970 to 104_665_171L,
            1980 to 117_060_396L,
            1990 to 123_611_167L,
            2000 to 126_843_000L,
            2010 to 128_070_000L,
            2020 to 126_261_000L,
            2026 to 123_753_041L,
            2030 to 119_500_000L,
            2040 to 110_900_000L,
            2050 to 104_000_000L,
            2070 to 87_000_000L,
            2100 to 74_000_000L
        )
        for ((y, pop) in jpnHistory) {
            val type = if (y <= 2023) "HISTORICAL" else "PROJECTION"
            list.add(HistoricalPopulationEntity("JPN", y, pop, type))
        }

        // Nigeria
        val ngaHistory = mapOf(
            1950 to 37_859_744L,
            1960 to 45_138_458L,
            1970 to 55_981_400L,
            1980 to 73_460_724L,
            1990 to 95_214_257L,
            2000 to 122_851_984L,
            2010 to 160_952_853L,
            2020 to 208_327_405L,
            2026 to 232_679_478L,
            2030 to 263_000_000L,
            2040 to 326_000_000L,
            2050 to 377_000_000L,
            2070 to 470_000_000L,
            2100 to 546_000_000L
        )
        for ((y, pop) in ngaHistory) {
            val type = if (y <= 2023) "HISTORICAL" else "PROJECTION"
            list.add(HistoricalPopulationEntity("NGA", y, pop, type))
        }

        // Germany
        val deuHistory = mapOf(
            1950 to 70_000_000L,
            1970 to 78_000_000L,
            1990 to 79_000_000L,
            2010 to 81_700_000L,
            2020 to 83_200_000L,
            2026 to 84_552_242L,
            2050 to 80_500_000L,
            2100 to 68_900_000L
        )
        for ((y, pop) in deuHistory) {
            val type = if (y <= 2023) "HISTORICAL" else "PROJECTION"
            list.add(HistoricalPopulationEntity("DEU", y, pop, type))
        }

        return list
    }

    // UN WPP 2024 5-year Age brackets (0-4 to 100+)
    fun getAgeGenderBrackets(): List<AgeGenderPopulationEntity> {
        val list = mutableListOf<AgeGenderPopulationEntity>()

        // Helper to add 21 5-year age groups: 0-4, 5-9 ... 95-99, 100+
        fun addPyramid(
            iso: String,
            year: Int,
            dataType: String,
            maleCounts: List<Long>,
            femaleCounts: List<Long>
        ) {
            for (i in 0 until 21) {
                val start = i * 5
                val end = if (i == 20) null else start + 4
                val m = maleCounts.getOrElse(i) { 0L }
                val f = femaleCounts.getOrElse(i) { 0L }
                list.add(
                    AgeGenderPopulationEntity(
                        isoCode = iso,
                        year = year,
                        ageStart = start,
                        ageEnd = end,
                        malePopulation = m,
                        femalePopulation = f,
                        totalPopulation = m + f,
                        dataType = dataType
                    )
                )
            }
        }

        // India 2026 UN WPP (Medium projection)
        // 1.45B total (~748M male, ~702M female)
        val ind2026M = listOf(
            58_200_000L, 59_800_000L, 62_100_000L, 62_400_000L, 60_800_000L,
            57_900_000L, 55_400_000L, 53_100_000L, 50_200_000L, 46_800_000L,
            42_900_000L, 38_100_000L, 32_800_000L, 26_100_000L, 19_400_000L,
            12_800_000L, 7_500_000L, 3_800_000L, 1_600_000L, 500_000L, 110_000L
        )
        val ind2026F = listOf(
            53_500_000L, 55_200_000L, 57_900_000L, 58_400_000L, 57_200_000L,
            54_800_000L, 52_600_000L, 50_500_000L, 48_000_000L, 44_900_000L,
            41_300_000L, 37_000_000L, 32_500_000L, 26_600_000L, 20_500_000L,
            14_100_000L, 8_900_000L, 4_900_000L, 2_200_000L, 800_000L, 210_000L
        )
        addPyramid("IND", 2026, "PROJECTION", ind2026M, ind2026F)

        // India 1970 UN WPP Historical
        val ind1970M = listOf(
            46_100_000L, 40_200_000L, 34_800_000L, 29_100_000L, 24_300_000L,
            20_800_000L, 18_100_000L, 15_900_000L, 13_800_000L, 11_900_000L,
            10_200_000L, 8_500_000L, 6_800_000L, 5_100_000L, 3_600_000L,
            2_200_000L, 1_100_000L, 500_000L, 200_000L, 60_000L, 10_000L
        )
        val ind1970F = listOf(
            43_500_000L, 37_900_000L, 32_500_000L, 27_200_000L, 22_700_000L,
            19_500_000L, 17_000_000L, 14_900_000L, 12_900_000L, 11_000_000L,
            9_400_000L, 7_800_000L, 6_200_000L, 4_700_000L, 3_300_000L,
            2_000_000L, 1_000_000L, 450_000L, 180_000L, 50_000L, 8_000L
        )
        addPyramid("IND", 1970, "HISTORICAL", ind1970M, ind1970F)

        // India 2050 UN WPP Projection
        val ind2050M = listOf(
            45_200_000L, 46_800_000L, 48_100_000L, 49_900_000L, 52_000_000L,
            54_800_000L, 57_200_000L, 59_100_000L, 60_200_000L, 59_400_000L,
            57_100_000L, 54_000_000L, 50_500_000L, 46_200_000L, 40_500_000L,
            33_500_000L, 25_100_000L, 16_800_000L, 9_500_000L, 4_200_000L, 1_500_000L
        )
        val ind2050F = listOf(
            42_100_000L, 43_800_000L, 45_200_000L, 47_100_000L, 49_400_000L,
            52_300_000L, 54_800_000L, 56_900_000L, 58_100_000L, 57_600_000L,
            55_700_000L, 53_200_000L, 50_600_000L, 47_100_000L, 42_200_000L,
            36_200_000L, 28_700_000L, 20_500_000L, 12_800_000L, 6_500_000L, 2_800_000L
        )
        addPyramid("IND", 2050, "PROJECTION", ind2050M, ind2050F)

        // China 2026 UN WPP
        val chn2026M = listOf(
            33_200_000L, 38_500_000L, 42_100_000L, 43_800_000L, 44_200_000L,
            47_500_000L, 56_900_000L, 66_400_000L, 54_100_000L, 51_500_000L,
            64_800_000L, 65_200_000L, 52_100_000L, 45_500_000L, 36_800_000L,
            24_200_000L, 15_100_000L, 8_200_000L, 3_500_000L, 1_100_000L, 250_000L
        )
        val chn2026F = listOf(
            29_800_000L, 34_100_000L, 37_200_000L, 38_900_000L, 39_500_000L,
            42_800_000L, 51_800_000L, 61_200_000L, 50_200_000L, 48_100_000L,
            61_200_000L, 62_400_000L, 50_700_000L, 45_800_000L, 38_500_000L,
            27_100_000L, 18_400_000L, 11_200_000L, 5_600_000L, 2_100_000L, 650_000L
        )
        addPyramid("CHN", 2026, "PROJECTION", chn2026M, chn2026F)

        // United States 2026 UN WPP
        val usa2026M = listOf(
            9_800_000L, 10_200_000L, 10_500_000L, 10_800_000L, 11_400_000L,
            11_900_000L, 12_200_000L, 11_800_000L, 11_200_000L, 10_800_000L,
            10_400_000L, 10_200_000L, 10_500_000L, 10_100_000L, 8_900_000L,
            6_800_000L, 4_500_000L, 2_600_000L, 1_200_000L, 400_000L, 110_000L
        )
        val usa2026F = listOf(
            9_400_000L, 9_800_000L, 10_100_000L, 10_400_000L, 10_900_000L,
            11_400_000L, 11_700_000L, 11_400_000L, 10_900_000L, 10_600_000L,
            10_300_000L, 10_300_000L, 10_800_000L, 10_700_000L, 9_800_000L,
            7_900_000L, 5_600_000L, 3_600_000L, 1_900_000L, 750_000L, 250_000L
        )
        addPyramid("USA", 2026, "PROJECTION", usa2026M, usa2026F)

        // Japan 2026 UN WPP (Inverted pyramid, aging population)
        val jpn2026M = listOf(
            2_050_000L, 2_250_000L, 2_450_000L, 2_700_000L, 3_050_000L,
            3_200_000L, 3_350_000L, 3_550_000L, 3_750_000L, 4_100_000L,
            4_850_000L, 4_700_000L, 3_950_000L, 3_800_000L, 4_400_000L,
            3_850_000L, 2_800_000L, 1_650_000L, 750_000L, 220_000L, 45_000L
        )
        val jpn2026F = listOf(
            1_950_000L, 2_150_000L, 2_350_000L, 2_550_000L, 2_850_000L,
            3_000_000L, 3_150_000L, 3_350_000L, 3_550_000L, 3_900_000L,
            4_650_000L, 4_550_000L, 3_900_000L, 3_900_000L, 4_700_000L,
            4_450_000L, 3_600_000L, 2_550_000L, 1_500_000L, 620_000L, 160_000L
        )
        addPyramid("JPN", 2026, "PROJECTION", jpn2026M, jpn2026F)

        // Nigeria 2026 UN WPP (Expansive pyramid, very young population)
        val nga2026M = listOf(
            18_500_000L, 16_800_000L, 15_100_000L, 13_400_000L, 11_700_000L,
            10_100_000L, 8_600_000L, 7_200_000L, 5_900_000L, 4_700_000L,
            3_700_000L, 2_800_000L, 2_100_000L, 1_500_000L, 1_000_000L,
            650_000L, 380_000L, 190_000L, 80_000L, 25_000L, 5_000L
        )
        val nga2026F = listOf(
            17_800_000L, 16_100_000L, 14_400_000L, 12_800_000L, 11_200_000L,
            9_700_000L, 8_300_000L, 7_000_000L, 5_800_000L, 4_700_000L,
            3_800_000L, 2_950_000L, 2_250_000L, 1_650_000L, 1_150_000L,
            780_000L, 490_000L, 270_000L, 120_000L, 45_000L, 12_000L
        )
        addPyramid("NGA", 2026, "PROJECTION", nga2026M, nga2026F)

        // World 2026 UN WPP
        val wld2026M = listOf(
            345_000_000L, 342_000_000L, 338_000_000L, 329_000_000L, 322_000_000L,
            312_000_000L, 305_000_000L, 292_000_000L, 274_000_000L, 252_000_000L,
            230_000_000L, 204_000_000L, 175_000_000L, 142_000_000L, 108_000_000L,
            74_000_000L, 44_000_000L, 23_000_000L, 9_500_000L, 3_000_000L, 700_000L
        )
        val wld2026F = listOf(
            324_000_000L, 321_000_000L, 317_000_000L, 309_000_000L, 303_000_000L,
            295_000_000L, 289_000_000L, 278_000_000L, 262_000_000L, 244_000_000L,
            226_000_000L, 204_000_000L, 179_000_000L, 151_000_000L, 121_000_000L,
            90_000_000L, 59_000_000L, 34_000_000L, 16_000_000L, 5_800_000L, 1_600_000L
        )
        addPyramid("WLD", 2026, "PROJECTION", wld2026M, wld2026F)

        return list
    }

    // Authoritative Demographic Indicators (UN WPP 2024 / World Bank)
    fun getDemographicIndicators(): List<DemographicIndicatorEntity> {
        val list = mutableListOf<DemographicIndicatorEntity>()
        fun addInd(iso: String, key: String, name: String, value: Double, unit: String, src: String = "UN WPP 2024") {
            list.add(
                DemographicIndicatorEntity(
                    isoCode = iso,
                    year = 2026,
                    indicatorKey = key,
                    indicatorName = name,
                    value = value,
                    unit = unit,
                    source = src,
                    dataType = "PROJECTION"
                )
            )
        }

        // World
        addInd("WLD", "MEDIAN_AGE", "Median Age", 30.5, "years")
        addInd("WLD", "FERTILITY_RATE", "Fertility Rate", 2.25, "births/woman")
        addInd("WLD", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 73.4, "years")
        addInd("WLD", "BIRTH_RATE", "Crude Birth Rate", 16.4, "per 1,000")
        addInd("WLD", "DEATH_RATE", "Crude Death Rate", 7.8, "per 1,000")
        addInd("WLD", "INFANT_MORTALITY", "Infant Mortality Rate", 26.7, "per 1,000 live births")
        addInd("WLD", "URBAN_POP_PCT", "Urban Population", 57.5, "%", "World Bank 2024")
        addInd("WLD", "RURAL_POP_PCT", "Rural Population", 42.5, "%", "World Bank 2024")
        addInd("WLD", "DEPENDENCY_RATIO", "Dependency Ratio", 53.8, "per 100 working-age")

        // India
        addInd("IND", "MEDIAN_AGE", "Median Age", 28.7, "years")
        addInd("IND", "FERTILITY_RATE", "Fertility Rate", 1.98, "births/woman")
        addInd("IND", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 71.2, "years")
        addInd("IND", "BIRTH_RATE", "Crude Birth Rate", 15.8, "per 1,000")
        addInd("IND", "DEATH_RATE", "Crude Death Rate", 6.9, "per 1,000")
        addInd("IND", "INFANT_MORTALITY", "Infant Mortality Rate", 25.3, "per 1,000 live births")
        addInd("IND", "NET_MIGRATION", "Net Migration", -510000.0, "annual net migrants")
        addInd("IND", "URBAN_POP_PCT", "Urban Population", 36.4, "%", "World Bank 2024")
        addInd("IND", "RURAL_POP_PCT", "Rural Population", 63.6, "%", "World Bank 2024")
        addInd("IND", "DEPENDENCY_RATIO", "Dependency Ratio", 46.2, "per 100 working-age")

        // China
        addInd("CHN", "MEDIAN_AGE", "Median Age", 39.6, "years")
        addInd("CHN", "FERTILITY_RATE", "Fertility Rate", 1.00, "births/woman")
        addInd("CHN", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 78.6, "years")
        addInd("CHN", "BIRTH_RATE", "Crude Birth Rate", 6.4, "per 1,000")
        addInd("CHN", "DEATH_RATE", "Crude Death Rate", 7.9, "per 1,000")
        addInd("CHN", "INFANT_MORTALITY", "Infant Mortality Rate", 5.2, "per 1,000 live births")
        addInd("CHN", "NET_MIGRATION", "Net Migration", -310000.0, "annual net migrants")
        addInd("CHN", "URBAN_POP_PCT", "Urban Population", 66.2, "%", "World Bank 2024")
        addInd("CHN", "RURAL_POP_PCT", "Rural Population", 33.8, "%", "World Bank 2024")
        addInd("CHN", "DEPENDENCY_RATIO", "Dependency Ratio", 46.8, "per 100 working-age")

        // USA
        addInd("USA", "MEDIAN_AGE", "Median Age", 38.9, "years")
        addInd("USA", "FERTILITY_RATE", "Fertility Rate", 1.62, "births/woman")
        addInd("USA", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 79.5, "years")
        addInd("USA", "BIRTH_RATE", "Crude Birth Rate", 11.0, "per 1,000")
        addInd("USA", "DEATH_RATE", "Crude Death Rate", 8.8, "per 1,000")
        addInd("USA", "INFANT_MORTALITY", "Infant Mortality Rate", 5.4, "per 1,000 live births")
        addInd("USA", "NET_MIGRATION", "Net Migration", 1200000.0, "annual net migrants")
        addInd("USA", "URBAN_POP_PCT", "Urban Population", 83.3, "%", "World Bank 2024")
        addInd("USA", "RURAL_POP_PCT", "Rural Population", 16.7, "%", "World Bank 2024")
        addInd("USA", "DEPENDENCY_RATIO", "Dependency Ratio", 54.9, "per 100 working-age")

        // Japan
        addInd("JPN", "MEDIAN_AGE", "Median Age", 49.1, "years")
        addInd("JPN", "FERTILITY_RATE", "Fertility Rate", 1.20, "births/woman")
        addInd("JPN", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 84.8, "years")
        addInd("JPN", "BIRTH_RATE", "Crude Birth Rate", 6.0, "per 1,000")
        addInd("JPN", "DEATH_RATE", "Crude Death Rate", 12.1, "per 1,000")
        addInd("JPN", "INFANT_MORTALITY", "Infant Mortality Rate", 1.8, "per 1,000 live births")
        addInd("JPN", "NET_MIGRATION", "Net Migration", 110000.0, "annual net migrants")
        addInd("JPN", "URBAN_POP_PCT", "Urban Population", 92.0, "%", "World Bank 2024")
        addInd("JPN", "RURAL_POP_PCT", "Rural Population", 8.0, "%", "World Bank 2024")
        addInd("JPN", "DEPENDENCY_RATIO", "Dependency Ratio", 71.2, "per 100 working-age")

        // Nigeria
        addInd("NGA", "MEDIAN_AGE", "Median Age", 17.7, "years")
        addInd("NGA", "FERTILITY_RATE", "Fertility Rate", 4.95, "births/woman")
        addInd("NGA", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 54.1, "years")
        addInd("NGA", "BIRTH_RATE", "Crude Birth Rate", 35.8, "per 1,000")
        addInd("NGA", "DEATH_RATE", "Crude Death Rate", 11.2, "per 1,000")
        addInd("NGA", "INFANT_MORTALITY", "Infant Mortality Rate", 67.2, "per 1,000 live births")
        addInd("NGA", "NET_MIGRATION", "Net Migration", -60000.0, "annual net migrants")
        addInd("NGA", "URBAN_POP_PCT", "Urban Population", 54.3, "%", "World Bank 2024")
        addInd("NGA", "RURAL_POP_PCT", "Rural Population", 45.7, "%", "World Bank 2024")
        addInd("NGA", "DEPENDENCY_RATIO", "Dependency Ratio", 86.4, "per 100 working-age")

        // Germany
        addInd("DEU", "MEDIAN_AGE", "Median Age", 45.3, "years")
        addInd("DEU", "FERTILITY_RATE", "Fertility Rate", 1.46, "births/woman")
        addInd("DEU", "LIFE_EXPECTANCY", "Life Expectancy at Birth", 81.3, "years")
        addInd("DEU", "BIRTH_RATE", "Crude Birth Rate", 8.5, "per 1,000")
        addInd("DEU", "DEATH_RATE", "Crude Death Rate", 12.2, "per 1,000")
        addInd("DEU", "INFANT_MORTALITY", "Infant Mortality Rate", 3.1, "per 1,000 live births")
        addInd("DEU", "NET_MIGRATION", "Net Migration", 380000.0, "annual net migrants")
        addInd("DEU", "URBAN_POP_PCT", "Urban Population", 77.8, "%", "World Bank 2024")
        addInd("DEU", "RURAL_POP_PCT", "Rural Population", 22.2, "%", "World Bank 2024")
        addInd("DEU", "DEPENDENCY_RATIO", "Dependency Ratio", 56.1, "per 100 working-age")

        return list
    }
}
