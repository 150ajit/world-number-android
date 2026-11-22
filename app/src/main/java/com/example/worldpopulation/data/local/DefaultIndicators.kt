package com.example.worldpopulation.data.local

import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity

object DefaultIndicators {
    val list: List<CategoryIndicatorEntity> = listOf(
        // 1. Population
        CategoryIndicatorEntity(
            categoryId = "population",
            indicatorId = "pop_total",
            name = "Total Population",
            unit = "People",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            indicatorId = "pop_growth_rate",
            name = "Annual Growth Rate",
            unit = "%",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            indicatorId = "pop_fertility",
            name = "Fertility Rate (TFR)",
            unit = "births/woman",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            indicatorId = "pop_median_age",
            name = "Median Age",
            unit = "years",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),

        // 2. Economy
        CategoryIndicatorEntity(
            categoryId = "economy",
            indicatorId = "gdp_nominal",
            name = "Nominal GDP",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "World Bank / IMF"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            indicatorId = "gdp_ppp",
            name = "GDP (PPP)",
            unit = "Billion Int$",
            sortDirection = "DESC",
            sourceName = "World Bank / IMF"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            indicatorId = "gdp_per_capita",
            name = "GDP Per Capita",
            unit = "USD",
            sortDirection = "DESC",
            sourceName = "World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            indicatorId = "gdp_growth",
            name = "Real GDP Growth",
            unit = "%",
            sortDirection = "DESC",
            sourceName = "World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            indicatorId = "inflation_rate",
            name = "Inflation Rate (CPI)",
            unit = "%",
            sortDirection = "ASC",
            sourceName = "IMF WEO"
        ),

        // 3. Environment
        CategoryIndicatorEntity(
            categoryId = "environment",
            indicatorId = "co2_per_capita",
            name = "CO2 Emissions Per Capita",
            unit = "Metric Tons",
            sortDirection = "ASC",
            sourceName = "Global Carbon Project"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            indicatorId = "forest_area_pct",
            name = "Forest Area Share",
            unit = "% of land",
            sortDirection = "DESC",
            sourceName = "World Bank / FAO"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            indicatorId = "renewable_energy_share",
            name = "Renewable Energy Share",
            unit = "% of final energy",
            sortDirection = "DESC",
            sourceName = "IEA"
        ),

        // 4. Health
        CategoryIndicatorEntity(
            categoryId = "health",
            indicatorId = "life_expectancy",
            name = "Life Expectancy at Birth",
            unit = "years",
            sortDirection = "DESC",
            sourceName = "WHO"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            indicatorId = "mortality_under5",
            name = "Under-5 Mortality Rate",
            unit = "per 1,000 births",
            sortDirection = "ASC",
            sourceName = "WHO / UNICEF"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            indicatorId = "health_expenditure_gdp",
            name = "Health Expenditure",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "WHO"
        ),

        // 5. Education
        CategoryIndicatorEntity(
            categoryId = "education",
            indicatorId = "literacy_rate",
            name = "Adult Literacy Rate",
            unit = "%",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            indicatorId = "tertiary_enrollment",
            name = "Tertiary Enrollment",
            unit = "% gross",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            indicatorId = "education_expenditure",
            name = "Education Spending",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "World Bank"
        ),

        // 6. Technology
        CategoryIndicatorEntity(
            categoryId = "technology",
            indicatorId = "internet_users_pct",
            name = "Internet Penetration",
            unit = "% of pop",
            sortDirection = "DESC",
            sourceName = "ITU"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            indicatorId = "mobile_subscriptions",
            name = "Mobile Subscriptions",
            unit = "per 100 people",
            sortDirection = "DESC",
            sourceName = "ITU"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            indicatorId = "patent_applications",
            name = "Patent Applications",
            unit = "annual filings",
            sortDirection = "DESC",
            sourceName = "WIPO"
        ),

        // 7. Military
        CategoryIndicatorEntity(
            categoryId = "military",
            indicatorId = "military_expenditure_gdp",
            name = "Military Expenditure",
            unit = "% of GDP",
            sortDirection = "ASC",
            sourceName = "SIPRI 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            indicatorId = "defense_budget_usd",
            name = "Defense Budget",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "SIPRI 2024"
        ),

        // 8. Global Indices
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            indicatorId = "hdi_score",
            name = "Human Development Index",
            unit = "Score (0-1)",
            sortDirection = "DESC",
            sourceName = "UNDP HDR"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            indicatorId = "cpi_score",
            name = "Corruption Perceptions Index",
            unit = "Score (0-100)",
            sortDirection = "DESC",
            sourceName = "Transparency Int."
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            indicatorId = "innovation_index",
            name = "Global Innovation Index",
            unit = "Score (0-100)",
            sortDirection = "DESC",
            sourceName = "WIPO GII"
        ),

        // 9. Geography
        CategoryIndicatorEntity(
            categoryId = "geography",
            indicatorId = "land_area",
            name = "Total Land Area",
            unit = "km²",
            sortDirection = "DESC",
            sourceName = "World Bank / CIA"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            indicatorId = "coastline_length",
            name = "Coastline Length",
            unit = "km",
            sortDirection = "DESC",
            sourceName = "World Factbook"
        ),

        // 10. Tourism
        CategoryIndicatorEntity(
            categoryId = "tourism",
            indicatorId = "tourist_arrivals",
            name = "International Tourist Arrivals",
            unit = "Million Visitors",
            sortDirection = "DESC",
            sourceName = "UN Tourism"
        ),
        CategoryIndicatorEntity(
            categoryId = "tourism",
            indicatorId = "tourism_receipts",
            name = "Tourism Receipts",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "UN Tourism"
        ),

        // 11. Energy
        CategoryIndicatorEntity(
            categoryId = "energy",
            indicatorId = "electricity_generation",
            name = "Electricity Generation",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "Energy Institute"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            indicatorId = "clean_power_share",
            name = "Clean Power Generation Share",
            unit = "%",
            sortDirection = "DESC",
            sourceName = "Ember / Energy Institute"
        ),

        // 12. Agriculture
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            indicatorId = "agricultural_land_pct",
            name = "Agricultural Land Share",
            unit = "%",
            sortDirection = "DESC",
            sourceName = "FAO"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            indicatorId = "cereal_yield",
            name = "Cereal Yield",
            unit = "kg / hectare",
            sortDirection = "DESC",
            sourceName = "FAO / World Bank"
        ),

        // 13. Politics
        CategoryIndicatorEntity(
            categoryId = "politics",
            indicatorId = "women_in_parliament",
            name = "Women in Parliament",
            unit = "% of seats",
            sortDirection = "DESC",
            sourceName = "IPU"
        ),
        CategoryIndicatorEntity(
            categoryId = "politics",
            indicatorId = "voter_turnout",
            name = "Voter Turnout Rate",
            unit = "% registered",
            sortDirection = "DESC",
            sourceName = "IDEA / IPU"
        ),

        // 14. Infrastructure
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            indicatorId = "rail_network_km",
            name = "Rail Network Length",
            unit = "km",
            sortDirection = "DESC",
            sourceName = "UIC / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            indicatorId = "port_traffic_teu",
            name = "Port Container Traffic",
            unit = "Million TEU",
            sortDirection = "DESC",
            sourceName = "World Bank LPI"
        ),

        // 15. Climate
        CategoryIndicatorEntity(
            categoryId = "climate",
            indicatorId = "avg_temperature",
            name = "Mean Annual Temperature",
            unit = "°C",
            sortDirection = "DESC",
            sourceName = "Berkeley Earth"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            indicatorId = "annual_precipitation",
            name = "Annual Precipitation",
            unit = "mm / year",
            sortDirection = "DESC",
            sourceName = "World Bank Climate Portal"
        ),

        // 16. Employment
        CategoryIndicatorEntity(
            categoryId = "employment",
            indicatorId = "unemployment_rate",
            name = "Total Unemployment Rate",
            unit = "% of labor",
            sortDirection = "ASC",
            sourceName = "ILOSTAT"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            indicatorId = "labor_participation",
            name = "Labor Force Participation",
            unit = "%",
            sortDirection = "DESC",
            sourceName = "ILOSTAT"
        ),

        // 17. Science
        CategoryIndicatorEntity(
            categoryId = "science",
            indicatorId = "rnd_expenditure_gdp",
            name = "R&D Spending Share",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "UNESCO"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            indicatorId = "scientific_publications",
            name = "Scientific Journal Articles",
            unit = "articles / year",
            sortDirection = "DESC",
            sourceName = "NSF / Scopus"
        ),

        // 18. Sports
        CategoryIndicatorEntity(
            categoryId = "sports",
            indicatorId = "olympic_medals_total",
            name = "Olympic Medals Total",
            unit = "Medals (All-time)",
            sortDirection = "DESC",
            sourceName = "IOC Official"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            indicatorId = "fifa_ranking",
            name = "FIFA World Ranking",
            unit = "Rank Position",
            sortDirection = "ASC",
            sourceName = "FIFA Official"
        ),

        // 19. City Rankings
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            indicatorId = "largest_metro_pop",
            name = "Largest Metro Population",
            unit = "Million Residents",
            sortDirection = "DESC",
            sourceName = "UN Habitat"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            indicatorId = "urbanization_rate",
            name = "Urban Population Share",
            unit = "% of total",
            sortDirection = "DESC",
            sourceName = "UN DESA"
        ),

        // 20. UN SDG Goals
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            indicatorId = "sdg_overall_score",
            name = "SDG Index Global Score",
            unit = "Score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge"
        )
    )

    fun getIndicatorsForCategory(categoryId: String): List<CategoryIndicatorEntity> {
        return list.filter { it.categoryId.equals(categoryId, ignoreCase = true) }
    }
}
