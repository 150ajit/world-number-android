package com.example.worldpopulation.data.local

import com.example.worldpopulation.data.local.entity.CategoryIndicatorEntity

object DefaultIndicators {
    val list: List<CategoryIndicatorEntity> = listOf(
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_total_pop",
            indicatorId = "pop_total",
            name = "Total Population",
            unit = "People",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_density",
            indicatorId = "pop_density",
            name = "Population Density",
            unit = "people/km²",
            sortDirection = "DESC",
            sourceName = "UN Statistics / FAO"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_age_distribution",
            indicatorId = "pop_median_age",
            name = "Median Age",
            unit = "years",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_gender_distribution",
            indicatorId = "pop_sex_ratio",
            name = "Sex Ratio (Male per 100 Female)",
            unit = "males/100 females",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_births_fertility",
            indicatorId = "pop_fertility",
            name = "Fertility Rate (TFR)",
            unit = "births/woman",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_deaths_mortality",
            indicatorId = "pop_crude_death_rate",
            name = "Crude Death Rate",
            unit = "per 1,000 people",
            sortDirection = "ASC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_life_expectancy",
            indicatorId = "life_expectancy",
            name = "Life Expectancy at Birth",
            unit = "years",
            sortDirection = "DESC",
            sourceName = "UN DESA / WHO"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_migration",
            indicatorId = "pop_net_migration",
            name = "Net Migration Rate",
            unit = "net migrants/1k",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_urban_rural",
            indicatorId = "urbanization_rate",
            name = "Urban Population Share",
            unit = "% of total",
            sortDirection = "DESC",
            sourceName = "UN Habitat / UN DESA"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_projections",
            indicatorId = "pop_growth_rate",
            name = "Annual Population Growth Rate",
            unit = "% annual",
            sortDirection = "DESC",
            sourceName = "UN DESA WPP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_family_household",
            indicatorId = "pop_household_size",
            name = "Average Household Size",
            unit = "persons/household",
            sortDirection = "DESC",
            sourceName = "UN DESA / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "population",
            subcategoryId = "pop_milestones",
            indicatorId = "pop_annual_net_change",
            name = "Annual Net Population Addition",
            unit = "people/year",
            sortDirection = "DESC",
            sourceName = "UN DESA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_gdp",
            indicatorId = "gdp_nominal",
            name = "Nominal Gross Domestic Product",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "World Bank / IMF WEO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_gdp_per_capita",
            indicatorId = "gdp_per_capita",
            name = "GDP Per Capita",
            unit = "USD",
            sortDirection = "DESC",
            sourceName = "World Bank / IMF WEO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_inflation",
            indicatorId = "inflation_rate",
            name = "Consumer Price Inflation",
            unit = "% annual",
            sortDirection = "ASC",
            sourceName = "IMF WEO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_currency_rates",
            indicatorId = "currency_usd_rate",
            name = "Exchange Rate to USD",
            unit = "local currency/USD",
            sortDirection = "ASC",
            sourceName = "IMF IFS / Central Banks"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_govt_finance",
            indicatorId = "govt_revenue_gdp",
            name = "Government Revenue Share",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "IMF Fiscal Monitor 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_public_debt",
            indicatorId = "public_debt_gdp",
            name = "General Government Gross Debt",
            unit = "% of GDP",
            sortDirection = "ASC",
            sourceName = "IMF WEO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_trade",
            indicatorId = "trade_pct_gdp",
            name = "Trade Openness Ratio",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "World Bank / WTO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_foreign_investment",
            indicatorId = "fdi_inflow_gdp",
            name = "FDI Net Inflows",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "UNCTAD WIR 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_banking_interest",
            indicatorId = "central_bank_rate",
            name = "Central Bank Policy Interest Rate",
            unit = "%",
            sortDirection = "ASC",
            sourceName = "Bank for Int. Settlements / Central Banks"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_stock_markets",
            indicatorId = "market_cap_gdp",
            name = "Stock Market Capitalization",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "World Federation of Exchanges"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_poverty_inequality",
            indicatorId = "gini_index",
            name = "Income Gini Coefficient",
            unit = "index (0-100)",
            sortDirection = "ASC",
            sourceName = "World Bank Poverty & Inequality Platform"
        ),
        CategoryIndicatorEntity(
            categoryId = "economy",
            subcategoryId = "eco_foreign_reserves",
            indicatorId = "foreign_reserves_usd",
            name = "Total Foreign Reserves (incl. Gold)",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "IMF International Financial Statistics"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_air_pollution",
            indicatorId = "pm25_concentration",
            name = "PM2.5 Air Pollution Exposure",
            unit = "µg/m³",
            sortDirection = "ASC",
            sourceName = "WHO Ambient Air Quality 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_water_resources",
            indicatorId = "renewable_water_pc",
            name = "Renewable Internal Freshwater",
            unit = "m³/capita",
            sortDirection = "DESC",
            sourceName = "FAO AQUASTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_water_quality",
            indicatorId = "drinking_water_access",
            name = "Safely Managed Drinking Water",
            unit = "% population",
            sortDirection = "DESC",
            sourceName = "WHO / UNICEF JMP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_forests",
            indicatorId = "forest_area_pct",
            name = "Forest Area Coverage",
            unit = "% of land",
            sortDirection = "DESC",
            sourceName = "FAO Global Forest Resources (FRA 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_biodiversity",
            indicatorId = "red_list_index",
            name = "Red List Biodiversity Index",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "IUCN Species Survival Commission"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_wildlife",
            indicatorId = "protected_species_pct",
            name = "Key Biodiversity Areas Protected",
            unit = "% of sites",
            sortDirection = "DESC",
            sourceName = "UNEP-WCMC / BirdLife International"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_land_soil",
            indicatorId = "soil_degradation_pct",
            name = "Degraded Land Share",
            unit = "% of total land",
            sortDirection = "ASC",
            sourceName = "UNCCD / FAO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_waste_management",
            indicatorId = "waste_recycled_pct",
            name = "Municipal Waste Recycling Rate",
            unit = "% of waste",
            sortDirection = "DESC",
            sourceName = "World Bank What a Waste / UNEP"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_marine_environment",
            indicatorId = "marine_protected_pct",
            name = "Marine Protected Areas Coverage",
            unit = "% of territorial waters",
            sortDirection = "DESC",
            sourceName = "UNEP-WCMC World Database on Protected Areas"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_natural_resources",
            indicatorId = "natural_resource_depletion",
            name = "Natural Resource Depletion Rate",
            unit = "% of GNI",
            sortDirection = "ASC",
            sourceName = "World Bank WDI 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_protected_areas",
            indicatorId = "protected_land_pct",
            name = "Terrestrial Protected Land Area",
            unit = "% of land area",
            sortDirection = "DESC",
            sourceName = "UNEP-WCMC WDPA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "environment",
            subcategoryId = "env_ecological_footprint",
            indicatorId = "co2_per_capita",
            name = "Carbon Emissions Per Capita",
            unit = "tonnes CO₂/person",
            sortDirection = "ASC",
            sourceName = "Global Carbon Project / CDIAC 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_life_expectancy",
            indicatorId = "healthy_life_expectancy",
            name = "Healthy Life Expectancy (HALE)",
            unit = "years",
            sortDirection = "DESC",
            sourceName = "WHO Global Health Observatory 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_infant_child",
            indicatorId = "mortality_under5",
            name = "Under-5 Child Mortality Rate",
            unit = "per 1,000 live births",
            sortDirection = "ASC",
            sourceName = "UN Inter-agency Group for Child Mortality Estimation (UN IGME)"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_maternal",
            indicatorId = "maternal_mortality_ratio",
            name = "Maternal Mortality Ratio",
            unit = "per 100k live births",
            sortDirection = "ASC",
            sourceName = "WHO / UNICEF / UNFPA / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_diseases",
            indicatorId = "ncd_mortality_rate",
            name = "Premature NCD Mortality Probability",
            unit = "% (ages 30-70)",
            sortDirection = "ASC",
            sourceName = "WHO Global Health Observatory 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_causes_death",
            indicatorId = "cvd_death_rate",
            name = "Cardiovascular Death Rate",
            unit = "per 100,000 people",
            sortDirection = "ASC",
            sourceName = "WHO GHO / IHME Global Burden of Disease"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_healthcare_infra",
            indicatorId = "hospital_beds_per_1k",
            name = "Hospital Bed Density",
            unit = "beds per 1,000 people",
            sortDirection = "DESC",
            sourceName = "WHO GHO / OECD Health Statistics"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_medical_workforce",
            indicatorId = "physicians_per_1k",
            name = "Physician Density",
            unit = "doctors per 1,000 people",
            sortDirection = "DESC",
            sourceName = "WHO Global Health Workforce Statistics"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_expenditure",
            indicatorId = "health_expenditure_gdp",
            name = "Current Health Expenditure",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "WHO Global Health Expenditure Database"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_vaccination",
            indicatorId = "dpt3_immunization_pct",
            name = "DPT3 Vaccine Coverage Rate",
            unit = "% of 1-year-olds",
            sortDirection = "DESC",
            sourceName = "WHO / UNICEF Immunization Coverage 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_nutrition",
            indicatorId = "undernourishment_pct",
            name = "Prevalence of Undernourishment",
            unit = "% of population",
            sortDirection = "ASC",
            sourceName = "FAO SOFI Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_mental_health",
            indicatorId = "suicide_rate",
            name = "Age-Standardized Suicide Rate",
            unit = "per 100,000 people",
            sortDirection = "ASC",
            sourceName = "WHO Global Health Observatory 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "health",
            subcategoryId = "health_sanitation_hygiene",
            indicatorId = "sanitation_access_pct",
            name = "Safely Managed Sanitation Services",
            unit = "% population",
            sortDirection = "DESC",
            sourceName = "WHO / UNICEF JMP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_literacy",
            indicatorId = "literacy_rate",
            name = "Adult Literacy Rate",
            unit = "% (age 15+)",
            sortDirection = "DESC",
            sourceName = "UNESCO Institute for Statistics (UIS 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_primary",
            indicatorId = "primary_completion_rate",
            name = "Primary Education Completion Rate",
            unit = "% of cohort",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_secondary",
            indicatorId = "secondary_enrollment_net",
            name = "Net Secondary School Enrollment",
            unit = "% of secondary age",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_higher",
            indicatorId = "tertiary_enrollment",
            name = "Gross Tertiary Enrollment Ratio",
            unit = "% gross",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_spending",
            indicatorId = "education_expenditure",
            name = "Government Education Expenditure",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS / World Bank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_teachers",
            indicatorId = "pupil_teacher_ratio_prim",
            name = "Primary Pupil-Teacher Ratio",
            unit = "pupils per teacher",
            sortDirection = "ASC",
            sourceName = "UNESCO UIS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_gender_equality",
            indicatorId = "gender_parity_index_sec",
            name = "Secondary Gender Parity Index",
            unit = "ratio (F/M)",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_school_infra",
            indicatorId = "school_electricity_pct",
            name = "Schools with Electricity Access",
            unit = "% of primary schools",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_learning_outcomes",
            indicatorId = "pisa_reading_score",
            name = "PISA Standardized Reading Score",
            unit = "scale score",
            sortDirection = "DESC",
            sourceName = "OECD Programme for International Student Assessment (PISA 2022/2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_vocational",
            indicatorId = "vocational_share_pct",
            name = "Vocational Secondary Enrollment Share",
            unit = "% of secondary students",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_research_edu",
            indicatorId = "graduates_science_pct",
            name = "STEM Tertiary Graduate Share",
            unit = "% of graduates",
            sortDirection = "DESC",
            sourceName = "UNESCO UIS / OECD Education at a Glance"
        ),
        CategoryIndicatorEntity(
            categoryId = "education",
            subcategoryId = "edu_education_access",
            indicatorId = "out_of_school_rate",
            name = "Primary Out-of-School Children Rate",
            unit = "% of primary age",
            sortDirection = "ASC",
            sourceName = "UNESCO UIS / UNICEF 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_internet_access",
            indicatorId = "internet_users_pct",
            name = "Internet Penetration Rate",
            unit = "% of population",
            sortDirection = "DESC",
            sourceName = "ITU World Telecommunication Indicators 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_mobile_connectivity",
            indicatorId = "mobile_subscriptions",
            name = "Mobile Cellular Subscriptions",
            unit = "per 100 people",
            sortDirection = "DESC",
            sourceName = "ITU World Telecommunication Indicators 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_broadband",
            indicatorId = "fixed_broadband_per_100",
            name = "Fixed Broadband Subscriptions",
            unit = "per 100 people",
            sortDirection = "DESC",
            sourceName = "ITU 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_5g_networks",
            indicatorId = "cellular_5g_coverage",
            name = "5G Population Coverage",
            unit = "% of population",
            sortDirection = "DESC",
            sourceName = "GSMA Intelligence / ITU 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_ai",
            indicatorId = "ai_readiness_index",
            name = "Government AI Readiness Index",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "Oxford Insights AI Readiness Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_cybersecurity",
            indicatorId = "global_cybersecurity_idx",
            name = "Global Cybersecurity Index (GCI)",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "ITU Global Cybersecurity Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_digital_govt",
            indicatorId = "e_government_index",
            name = "UN E-Government Development Index",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "United Nations E-Government Survey 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_innovation",
            indicatorId = "tech_innovation_index",
            name = "Global Innovation Index (GII)",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "WIPO Global Innovation Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_patents_ip",
            indicatorId = "patent_applications",
            name = "Total Patent Applications",
            unit = "filings/year",
            sortDirection = "DESC",
            sourceName = "WIPO IP Statistics Data Center 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_rd",
            indicatorId = "rnd_expenditure_gdp",
            name = "R&D Expenditure (% of GDP)",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "UNESCO Institute for Statistics / OECD 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_robotics_automation",
            indicatorId = "robot_density",
            name = "Industrial Robot Density",
            unit = "units / 10k workers",
            sortDirection = "DESC",
            sourceName = "International Federation of Robotics (IFR 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "technology",
            subcategoryId = "tech_exports",
            indicatorId = "high_tech_exports_pct",
            name = "High-Technology Exports Share",
            unit = "% of mfg exports",
            sortDirection = "DESC",
            sourceName = "World Bank / UN Comtrade 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_defence_budget",
            indicatorId = "defense_budget_usd",
            name = "Annual Defense Budget",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "SIPRI Military Expenditure Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_personnel",
            indicatorId = "military_personnel_active",
            name = "Active Duty Military Personnel",
            unit = "personnel",
            sortDirection = "DESC",
            sourceName = "IISS Military Balance 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_army",
            indicatorId = "battle_tanks_count",
            name = "Main Battle Tanks Inventory",
            unit = "tanks",
            sortDirection = "DESC",
            sourceName = "IISS Military Balance 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_air_force",
            indicatorId = "combat_aircraft_count",
            name = "Military Combat Aircraft",
            unit = "aircraft",
            sortDirection = "DESC",
            sourceName = "FlightGlobal World Air Forces / IISS 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_navy",
            indicatorId = "naval_fleet_strength",
            name = "Total Naval Fleet Assets",
            unit = "vessels",
            sortDirection = "DESC",
            sourceName = "Global Firepower / IISS Military Balance"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_nuclear_weapons",
            indicatorId = "nuclear_warhead_estimate",
            name = "Estimated Nuclear Warhead Stockpile",
            unit = "warheads",
            sortDirection = "DESC",
            sourceName = "SIPRI Yearbook 2024 / FAS"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_arms_exports",
            indicatorId = "arms_exports_tiv",
            name = "Major Conventional Arms Exports",
            unit = "Million SIPRI TIV",
            sortDirection = "DESC",
            sourceName = "SIPRI Arms Transfers Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_arms_imports",
            indicatorId = "arms_imports_tiv",
            name = "Major Conventional Arms Imports",
            unit = "Million SIPRI TIV",
            sortDirection = "DESC",
            sourceName = "SIPRI Arms Transfers Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_defence_industry",
            indicatorId = "military_expenditure_gdp",
            name = "Military Expenditure (% of GDP)",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "SIPRI Military Expenditure Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_alliances",
            indicatorId = "defense_pact_memberships",
            name = "Formal Mutual Defense Alliances",
            unit = "alliances count",
            sortDirection = "DESC",
            sourceName = "ATOP Alliance Treaty Obligations / NATO"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_peace_conflict",
            indicatorId = "conflict_fatalities",
            name = "Annual Conflict Battle Deaths",
            unit = "fatalities",
            sortDirection = "ASC",
            sourceName = "Uppsala Conflict Data Program (UCDP 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "military",
            subcategoryId = "mil_rankings",
            indicatorId = "military_strength_score",
            name = "Global Military Strength Index",
            unit = "PowerIndex (lower is stronger)",
            sortDirection = "ASC",
            sourceName = "Global Firepower Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_human_development",
            indicatorId = "hdi_score",
            name = "Human Development Index (HDI)",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "UNDP Human Development Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_happiness",
            indicatorId = "happiness_score",
            name = "World Happiness Score",
            unit = "score (0-10)",
            sortDirection = "DESC",
            sourceName = "World Happiness Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_peace",
            indicatorId = "global_peace_index",
            name = "Global Peace Index (GPI)",
            unit = "score (1-5, lower is more peaceful)",
            sortDirection = "ASC",
            sourceName = "Institute for Economics & Peace (IEP 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_corruption",
            indicatorId = "cpi_score",
            name = "Corruption Perceptions Index (CPI)",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "Transparency International 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_innovation",
            indicatorId = "innovation_index",
            name = "Global Innovation Index",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "WIPO / Portulans Institute 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_democracy",
            indicatorId = "democracy_index",
            name = "EIU Democracy Index",
            unit = "score (0-10)",
            sortDirection = "DESC",
            sourceName = "Economist Intelligence Unit (EIU 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_press_freedom",
            indicatorId = "press_freedom_score",
            name = "World Press Freedom Index",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "Reporters Without Borders (RSF 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_gender_equality",
            indicatorId = "gender_gap_index",
            name = "Global Gender Gap Index",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "World Economic Forum (WEF 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_economic_freedom",
            indicatorId = "economic_freedom_index",
            name = "Index of Economic Freedom",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "The Heritage Foundation 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_passport_strength",
            indicatorId = "passport_rank",
            name = "Passport Mobility Score",
            unit = "visa-free destinations",
            sortDirection = "DESC",
            sourceName = "Henley & Partners Passport Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_quality_of_life",
            indicatorId = "quality_of_life_index",
            name = "Quality of Life Index",
            unit = "score (0-200)",
            sortDirection = "DESC",
            sourceName = "Numbeo Quality of Life Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_rule_of_law",
            indicatorId = "rule_of_law_index",
            name = "WJP Rule of Law Index",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "World Justice Project (WJP 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_environmental_performance",
            indicatorId = "epi_score",
            name = "Environmental Performance Index (EPI)",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "Yale Center for Environmental Law & Policy 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "idx_competitiveness",
            indicatorId = "global_competitiveness_idx",
            name = "World Competitiveness Ranking",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "IMD World Competitiveness Center 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_countries_territories",
            indicatorId = "land_area",
            name = "Total Sovereign Land Area",
            unit = "km²",
            sortDirection = "DESC",
            sourceName = "UN Statistics Division / CIA Factbook"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "geo_capitals",
            indicatorId = "capital_population",
            name = "Capital City Population",
            unit = "residents",
            sortDirection = "DESC",
            sourceName = "UN DESA Urban Prospects 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "geo_land_area",
            indicatorId = "land_area_sqmi",
            name = "Total Land Area (Sq Miles)",
            unit = "sq miles",
            sortDirection = "DESC",
            sourceName = "UN Statistics Division"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "geo_water_area",
            indicatorId = "water_area_pct",
            name = "Inland Water Area Share",
            unit = "% surface area",
            sortDirection = "DESC",
            sourceName = "FAO / CIA World Factbook"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "geo_coastlines",
            indicatorId = "coastline_length",
            name = "Coastline Length",
            unit = "km",
            sortDirection = "DESC",
            sourceName = "World Vector Shoreline / CIA Factbook"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_borders",
            indicatorId = "land_border_length",
            name = "Total Land Boundary Length",
            unit = "km",
            sortDirection = "DESC",
            sourceName = "International Boundary Research Unit / CIA"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_mountains",
            indicatorId = "highest_elevation_m",
            name = "Highest Elevation Point",
            unit = "meters",
            sortDirection = "DESC",
            sourceName = "USGS / National Geodetic Surveys"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_rivers",
            indicatorId = "longest_river_km",
            name = "Longest National River Length",
            unit = "km",
            sortDirection = "DESC",
            sourceName = "HydroSHEDS / UN Environment"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_lakes",
            indicatorId = "largest_lake_area",
            name = "Largest Inland Lake Surface Area",
            unit = "km²",
            sortDirection = "DESC",
            sourceName = "Global Lakes and Wetlands Database (GLWD)"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_islands",
            indicatorId = "island_count",
            name = "Recognized Island Count",
            unit = "islands count",
            sortDirection = "DESC",
            sourceName = "National Hydrographic Services / UN Environment"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_deserts",
            indicatorId = "arid_land_pct",
            name = "Arid and Hyper-Arid Land Share",
            unit = "% total land",
            sortDirection = "DESC",
            sourceName = "UNCCD / FAO World Soil Resources"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "geo_forest_geography",
            indicatorId = "forest_area_total_km2",
            name = "Total Forested Land Area",
            unit = "km²",
            sortDirection = "DESC",
            sourceName = "FAO Global Forest Resources Assessment 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "geography",
            subcategoryId = "geo_oceans_seas",
            indicatorId = "exclusive_economic_zone",
            name = "Exclusive Economic Zone (EEZ) Area",
            unit = "km²",
            sortDirection = "DESC",
            sourceName = "Flanders Marine Institute / UNCLOS"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "geo_geographic_extremes",
            indicatorId = "mean_elevation_m",
            name = "Mean Terrain Elevation",
            unit = "meters",
            sortDirection = "DESC",
            sourceName = "NOAA NCEI ETOPO Global Relief Model"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_international_arrivals",
            indicatorId = "tourist_arrivals",
            name = "International Tourist Arrivals",
            unit = "Million tourists",
            sortDirection = "DESC",
            sourceName = "UN Tourism (UNWTO World Tourism Barometer 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_tourism_receipts",
            indicatorId = "tourism_receipts",
            name = "International Tourism Receipts",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "UN Tourism / World Bank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_outbound_tourism",
            indicatorId = "outbound_tourism_spend",
            name = "Outbound International Tourism Spending",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "UN Tourism (UNWTO 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_popular_destinations",
            indicatorId = "tourist_intensity",
            name = "Tourism Intensity Ratio",
            unit = "arrivals / resident",
            sortDirection = "DESC",
            sourceName = "UN Tourism / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "tourism",
            subcategoryId = "tour_hotels_accommodation",
            indicatorId = "hotel_rooms_count",
            name = "Commercial Hotel Bed-Places",
            unit = "thousand rooms",
            sortDirection = "DESC",
            sourceName = "UN Tourism / STR Global"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_airlines_airports",
            indicatorId = "air_passengers_carried",
            name = "Air Transport Passengers Carried",
            unit = "Million passengers",
            sortDirection = "DESC",
            sourceName = "ICAO / World Bank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_heritage_sites",
            indicatorId = "unesco_world_heritage",
            name = "UNESCO World Heritage Properties",
            unit = "sites count",
            sortDirection = "DESC",
            sourceName = "UNESCO World Heritage Centre 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_nature_tourism",
            indicatorId = "ecotourism_sites_count",
            name = "Designated Biosphere & Ecotourism Reserves",
            unit = "reserves count",
            sortDirection = "DESC",
            sourceName = "UNESCO MAB Programme / UNEP"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_cultural_tourism",
            indicatorId = "museum_visits_annual",
            name = "Annual Museum & Heritage Attendances",
            unit = "Million visits",
            sortDirection = "DESC",
            sourceName = "UNESCO / International Council of Museums (ICOM)"
        ),
        CategoryIndicatorEntity(
            categoryId = "tourism",
            subcategoryId = "tour_tourism_economy",
            indicatorId = "tourism_gdp_share_pct",
            name = "Travel & Tourism GDP Contribution",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "World Travel & Tourism Council (WTTC 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_travel_competitiveness",
            indicatorId = "travel_tourism_dev_idx",
            name = "Travel & Tourism Development Index",
            unit = "score (1-7)",
            sortDirection = "DESC",
            sourceName = "World Economic Forum (WEF TTDI 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "tour_visa_travel",
            indicatorId = "visa_free_access_destinations",
            name = "Visa-Free Destinations Accessible",
            unit = "destinations",
            sortDirection = "DESC",
            sourceName = "Henley & Partners / IATA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_production",
            indicatorId = "total_energy_production_twh",
            name = "Total Primary Energy Production",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "IEA World Energy Outlook 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_consumption",
            indicatorId = "energy_consumption_pc",
            name = "Electric Power Consumption Per Capita",
            unit = "kWh / capita",
            sortDirection = "DESC",
            sourceName = "IEA World Energy Balances 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "energy_electricity_gen",
            indicatorId = "electricity_generation",
            name = "Gross Electricity Generation",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "Ember / IEA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_renewable",
            indicatorId = "renewable_energy_share",
            name = "Renewable Energy Share in Power",
            unit = "% of electricity",
            sortDirection = "DESC",
            sourceName = "Ember Global Electricity Review 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_solar",
            indicatorId = "solar_generation_twh",
            name = "Solar Power Generation",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "Ember Global Electricity Review 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_wind",
            indicatorId = "wind_generation_twh",
            name = "Wind Energy Generation",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "Ember / Global Wind Energy Council 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "energy_hydro",
            indicatorId = "hydro_generation_twh",
            name = "Hydroelectric Generation",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "IEA / International Hydropower Association 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_nuclear",
            indicatorId = "nuclear_generation_twh",
            name = "Nuclear Power Generation",
            unit = "TWh",
            sortDirection = "DESC",
            sourceName = "IAEA Power Reactor Information System (PRIS 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_coal",
            indicatorId = "coal_share_electricity",
            name = "Coal Share in Electricity",
            unit = "% of power",
            sortDirection = "ASC",
            sourceName = "Ember Global Electricity Review 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_oil",
            indicatorId = "oil_production_bpd",
            name = "Crude Oil Production",
            unit = "thousand barrels/day",
            sortDirection = "DESC",
            sourceName = "IEA / OPEC Monthly Oil Market 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "energy",
            subcategoryId = "energy_natural_gas",
            indicatorId = "gas_production_bcm",
            name = "Natural Gas Production",
            unit = "Billion m³ / year",
            sortDirection = "DESC",
            sourceName = "IEA / Cedigaz 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "energy_access",
            indicatorId = "electricity_access_pct",
            name = "Electricity Access Rate",
            unit = "% of population",
            sortDirection = "DESC",
            sourceName = "World Bank Tracking SDG 7 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "energy_efficiency",
            indicatorId = "energy_intensity_level",
            name = "Energy Intensity of Economy",
            unit = "MJ / $2017 PPP GDP",
            sortDirection = "ASC",
            sourceName = "IEA / World Bank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "energy_grid",
            indicatorId = "clean_power_share",
            name = "Low-Carbon Clean Power Share",
            unit = "% of total power",
            sortDirection = "DESC",
            sourceName = "Ember Global Electricity Review 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "energy_transition",
            indicatorId = "energy_transition_index",
            name = "Energy Transition Index (ETI)",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "World Economic Forum (WEF ETI 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_crop_production",
            indicatorId = "crop_production_index",
            name = "Crop Production Index",
            unit = "index (2014-16=100)",
            sortDirection = "DESC",
            sourceName = "FAO FAOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_cereals",
            indicatorId = "cereal_yield",
            name = "Cereal Yield",
            unit = "kg / hectare",
            sortDirection = "DESC",
            sourceName = "FAO / World Bank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_livestock",
            indicatorId = "livestock_production_idx",
            name = "Livestock Production Index",
            unit = "index (2014-16=100)",
            sortDirection = "DESC",
            sourceName = "FAO FAOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_fisheries",
            indicatorId = "fisheries_production_tons",
            name = "Total Fisheries & Aquaculture Output",
            unit = "thousand tonnes",
            sortDirection = "DESC",
            sourceName = "FAO SOFIA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_agricultural_land",
            indicatorId = "agricultural_land_pct",
            name = "Agricultural Land Share",
            unit = "% of land area",
            sortDirection = "DESC",
            sourceName = "FAO FAOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_irrigation",
            indicatorId = "irrigated_land_pct",
            name = "Agricultural Land Equipped for Irrigation",
            unit = "% of agricultural area",
            sortDirection = "DESC",
            sourceName = "FAO AQUASTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_organic",
            indicatorId = "organic_share_pct",
            name = "Certified Organic Farmland Share",
            unit = "% of agricultural land",
            sortDirection = "DESC",
            sourceName = "FiBL / IFOAM Organics International 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_food_security",
            indicatorId = "prevalence_undernourish",
            name = "Undernourishment Prevalence",
            unit = "% of population",
            sortDirection = "ASC",
            sourceName = "FAO / WFP / IFAD SOFI 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "agriculture",
            subcategoryId = "agri_food_prices",
            indicatorId = "food_price_inflation",
            name = "Food Consumer Price Inflation",
            unit = "% annual",
            sortDirection = "ASC",
            sourceName = "FAO Food Price Index / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_fertilizers",
            indicatorId = "fertilizer_consumption",
            name = "Fertilizer Consumption Rate",
            unit = "kg / ha arable land",
            sortDirection = "DESC",
            sourceName = "FAO FAOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_pesticides",
            indicatorId = "pesticide_use_per_ha",
            name = "Pesticide Application Rate",
            unit = "kg / hectare",
            sortDirection = "ASC",
            sourceName = "FAO FAOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_machinery",
            indicatorId = "tractors_per_100sqkm",
            name = "Agricultural Mechanization Density",
            unit = "tractors / 100 km² arable",
            sortDirection = "DESC",
            sourceName = "FAO FAOSTAT"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_trade",
            indicatorId = "agri_exports_usd",
            name = "Agricultural Product Exports",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "WTO / FAOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "agri_food_waste",
            indicatorId = "food_waste_per_capita",
            name = "Household Food Waste Per Capita",
            unit = "kg / person / year",
            sortDirection = "ASC",
            sourceName = "UNEP Food Waste Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_govt_systems",
            indicatorId = "democracy_score",
            name = "Electoral Democracy Rating",
            unit = "score (0-10)",
            sortDirection = "DESC",
            sourceName = "EIU Democracy Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_heads_state",
            indicatorId = "political_stability_idx",
            name = "Political Stability & Absence of Violence",
            unit = "score (-2.5 to 2.5)",
            sortDirection = "DESC",
            sourceName = "World Bank Worldwide Governance Indicators (WGI 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "politics",
            subcategoryId = "pol_parliaments",
            indicatorId = "women_in_parliament",
            name = "Women in National Parliament",
            unit = "% of seats",
            sortDirection = "DESC",
            sourceName = "Inter-Parliamentary Union (IPU Parline 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "politics",
            subcategoryId = "pol_elections",
            indicatorId = "voter_turnout",
            name = "Voter Turnout Rate",
            unit = "% registered voters",
            sortDirection = "DESC",
            sourceName = "International IDEA / IPU"
        ),
        CategoryIndicatorEntity(
            categoryId = "politics",
            subcategoryId = "pol_political_parties",
            indicatorId = "party_institutionalization",
            name = "Party Institutionalization Index",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "V-Dem Institute 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_constitutions",
            indicatorId = "constitutional_age_years",
            name = "Current Constitution Lifespan",
            unit = "years in effect",
            sortDirection = "DESC",
            sourceName = "Comparative Constitutions Project (CCP)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_democracy_indices",
            indicatorId = "pol_democracy_score",
            name = "Democracy Index Score",
            unit = "score (0-10)",
            sortDirection = "DESC",
            sourceName = "Economist Intelligence Unit (EIU 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "politics",
            subcategoryId = "pol_governance",
            indicatorId = "govt_effectiveness_idx",
            name = "Government Effectiveness Index",
            unit = "score (-2.5 to 2.5)",
            sortDirection = "DESC",
            sourceName = "World Bank WGI 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "politics",
            subcategoryId = "pol_corruption",
            indicatorId = "pol_corruption_index",
            name = "Corruption Perceptions Index",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "Transparency International 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_human_rights",
            indicatorId = "human_rights_score",
            name = "Physical Integrity Rights Score",
            unit = "score (0-1)",
            sortDirection = "DESC",
            sourceName = "Human Rights Protection Scores / V-Dem"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_civil_liberties",
            indicatorId = "civil_liberties_score",
            name = "Civil Liberties Index",
            unit = "score (0-60)",
            sortDirection = "DESC",
            sourceName = "Freedom House (Freedom in the World 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_intl_organizations",
            indicatorId = "un_treaties_ratified",
            name = "Multilateral UN Treaties Ratified",
            unit = "treaties count",
            sortDirection = "DESC",
            sourceName = "United Nations Treaty Collection (UNTC 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_diplomacy",
            indicatorId = "diplomatic_missions_abroad",
            name = "Global Diplomatic Network Size",
            unit = "missions count",
            sortDirection = "DESC",
            sourceName = "Lowy Institute Global Diplomacy Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "pol_conflicts_peace",
            indicatorId = "pol_peace_index",
            name = "Global Peace Index Score",
            unit = "score (1-5)",
            sortDirection = "ASC",
            sourceName = "Institute for Economics & Peace (IEP 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_roads",
            indicatorId = "road_density_km",
            name = "Road Network Density",
            unit = "km / 100 km² land",
            sortDirection = "DESC",
            sourceName = "International Road Federation (IRF) / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_railways",
            indicatorId = "rail_network_km",
            name = "Operating Railway Network Length",
            unit = "km",
            sortDirection = "DESC",
            sourceName = "International Union of Railways (UIC 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_airports",
            indicatorId = "airports_count",
            name = "Airports with Paved Runways",
            unit = "airports count",
            sortDirection = "DESC",
            sourceName = "ICAO / CIA World Factbook 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "infra_ports",
            indicatorId = "port_traffic_teu",
            name = "Container Port Throughput",
            unit = "Million TEU",
            sortDirection = "DESC",
            sourceName = "World Bank / AAPA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_bridges_tunnels",
            indicatorId = "longest_bridge_meters",
            name = "Longest Bridge Span",
            unit = "meters",
            sortDirection = "DESC",
            sourceName = "International Bridge Engineering Registry"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "infra_dams",
            indicatorId = "large_dams_count",
            name = "Registered Large Dams",
            unit = "dams count",
            sortDirection = "DESC",
            sourceName = "International Commission on Large Dams (ICOLD)"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "infra_electricity_grid",
            indicatorId = "power_grid_reliability",
            name = "Electrification Rate",
            unit = "% population",
            sortDirection = "DESC",
            sourceName = "World Bank SE4ALL 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "infra_telecom_infra",
            indicatorId = "mobile_cell_towers",
            name = "Mobile Base Station Density",
            unit = "towers / 10k people",
            sortDirection = "DESC",
            sourceName = "ITU / GSMA Intelligence 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_water_infra",
            indicatorId = "piped_water_coverage",
            name = "Piped Water Infrastructure Access",
            unit = "% population",
            sortDirection = "DESC",
            sourceName = "WHO / UNICEF JMP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_internet_infra",
            indicatorId = "fixed_broadband_infra",
            name = "Fixed Broadband Infrastructure",
            unit = "subscriptions/100 people",
            sortDirection = "DESC",
            sourceName = "ITU 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_logistics",
            indicatorId = "logistics_performance_idx",
            name = "Logistics Performance Index (LPI)",
            unit = "score (1-5)",
            sortDirection = "DESC",
            sourceName = "World Bank Logistics Performance Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_urban_infra",
            indicatorId = "urban_infrastructure_index",
            name = "Urban Agglomeration Index",
            unit = "% of total",
            sortDirection = "DESC",
            sourceName = "UN-Habitat World Cities Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_construction",
            indicatorId = "construction_gdp_share",
            name = "Construction Sector GDP Contribution",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "World Bank / ILO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "infrastructure",
            subcategoryId = "infra_housing",
            indicatorId = "housing_overcrowding_pct",
            name = "Housing Overcrowding Rate",
            unit = "% households",
            sortDirection = "ASC",
            sourceName = "OECD Affordable Housing Database / UN-Habitat"
        ),
        CategoryIndicatorEntity(
            categoryId = "global_indices",
            subcategoryId = "infra_transport_infra",
            indicatorId = "transport_infrastructure_inv",
            name = "Transport Infrastructure Investment",
            unit = "% of GDP",
            sortDirection = "DESC",
            sourceName = "OECD International Transport Forum (ITF 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_temperature",
            indicatorId = "avg_temperature",
            name = "Mean Annual Surface Temperature",
            unit = "°C",
            sortDirection = "DESC",
            sourceName = "Berkeley Earth / NOAA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_global_warming",
            indicatorId = "temperature_anomaly",
            name = "Surface Temperature Anomaly",
            unit = "°C anomaly",
            sortDirection = "ASC",
            sourceName = "Berkeley Earth / Copernicus Climate 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_rainfall",
            indicatorId = "annual_precipitation",
            name = "Average Annual Precipitation",
            unit = "mm / year",
            sortDirection = "DESC",
            sourceName = "World Bank Climate Knowledge Portal / GPCC"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_snowfall",
            indicatorId = "snow_cover_extent_pct",
            name = "Seasonal Snow Cover Extent",
            unit = "% land area",
            sortDirection = "DESC",
            sourceName = "Rutgers Global Snow Lab / NOAA"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_drought",
            indicatorId = "drought_severity_index",
            name = "Drought Severity Index",
            unit = "score (0-5)",
            sortDirection = "ASC",
            sourceName = "Global Drought Observatory (GDO / JRC 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_floods",
            indicatorId = "flood_risk_population_pct",
            name = "Population in High Flood Risk Zones",
            unit = "% population",
            sortDirection = "ASC",
            sourceName = "World Bank Global Flood Risk Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_cyclones",
            indicatorId = "tropical_cyclones_frequency",
            name = "Tropical Cyclone Hazard Index",
            unit = "events/decade",
            sortDirection = "ASC",
            sourceName = "NOAA IBTrACS / WMO 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_extreme_weather",
            indicatorId = "extreme_weather_events",
            name = "Extreme Weather Disasters Recorded",
            unit = "events / year",
            sortDirection = "ASC",
            sourceName = "EM-DAT International Disaster Database (CRED 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_sea_level",
            indicatorId = "sea_level_rise_mm_yr",
            name = "Relative Coastal Sea Level Rise Rate",
            unit = "mm / year",
            sortDirection = "ASC",
            sourceName = "NASA Sea Level Change Team / PSMSL 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_glaciers",
            indicatorId = "glacier_mass_balance_mwe",
            name = "Glacier Mass Balance Trend",
            unit = "m water equiv / yr",
            sortDirection = "DESC",
            sourceName = "World Glacier Monitoring Service (WGMS 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_polar_ice",
            indicatorId = "sea_ice_extent_sqkm",
            name = "Territorial Arctic/Antarctic Ice Cover",
            unit = "thousand km²",
            sortDirection = "DESC",
            sourceName = "National Snow & Ice Data Center (NSIDC 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_greenhouse_gases",
            indicatorId = "total_ghg_emissions_mt",
            name = "Total Annual GHG Emissions",
            unit = "Million tonnes CO₂e",
            sortDirection = "ASC",
            sourceName = "UNFCCC / Climate Watch 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_climate_risk",
            indicatorId = "climate_vulnerability_idx",
            name = "ND-GAIN Climate Vulnerability Score",
            unit = "score (0-1, lower is better)",
            sortDirection = "ASC",
            sourceName = "Notre Dame Global Adaptation Initiative (ND-GAIN 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "climate",
            subcategoryId = "clim_climate_projections",
            indicatorId = "projected_temp_rise_2050",
            name = "Projected 2050 Temperature Increase",
            unit = "°C rise",
            sortDirection = "ASC",
            sourceName = "IPCC Sixth Assessment Report (SSP2-4.5) / World Bank"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_labour_force",
            indicatorId = "labor_force_total",
            name = "Total Labor Force",
            unit = "Million workers",
            sortDirection = "DESC",
            sourceName = "ILO ILOSTAT Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_employment_rate",
            indicatorId = "employment_to_pop_ratio",
            name = "Employment-to-Population Ratio",
            unit = "% (age 15+)",
            sortDirection = "DESC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_unemployment",
            indicatorId = "unemployment_rate",
            name = "Total Unemployment Rate",
            unit = "% total labor",
            sortDirection = "ASC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_youth_employment",
            indicatorId = "youth_unemployment_rate",
            name = "Youth Unemployment Rate",
            unit = "% (ages 15-24)",
            sortDirection = "ASC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_wages_salaries",
            indicatorId = "monthly_minimum_wage_usd",
            name = "Statutory Monthly Minimum Wage",
            unit = "USD / month",
            sortDirection = "DESC",
            sourceName = "ILO Global Wage Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_working_hours",
            indicatorId = "weekly_hours_worked",
            name = "Average Weekly Working Hours",
            unit = "hours / week",
            sortDirection = "ASC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_labour_participation",
            indicatorId = "labor_participation",
            name = "Labor Force Participation Rate",
            unit = "% (age 15+)",
            sortDirection = "DESC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_gender_gap",
            indicatorId = "gender_gap_participation",
            name = "Labor Participation Gender Gap",
            unit = "% points (M-F)",
            sortDirection = "ASC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_employment_by_sector",
            indicatorId = "services_employment_pct",
            name = "Services Sector Employment Share",
            unit = "% total employment",
            sortDirection = "DESC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_informal_employment",
            indicatorId = "informal_employment_pct",
            name = "Informal Employment Rate",
            unit = "% of non-agri",
            sortDirection = "ASC",
            sourceName = "ILO Women and Men in the Informal Economy 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_migrant_workers",
            indicatorId = "migrant_workers_share",
            name = "Migrant Workers in Labor Force",
            unit = "% of labor force",
            sortDirection = "DESC",
            sourceName = "ILO Global Estimates on International Migrant Workers"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_productivity",
            indicatorId = "gdp_per_person_employed",
            name = "Labor Productivity (GDP / Worker)",
            unit = "USD (constant PPP)",
            sortDirection = "DESC",
            sourceName = "ILOSTAT / World Bank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_occupational_safety",
            indicatorId = "fatal_occupational_injuries",
            name = "Fatal Work Injury Rate",
            unit = "per 100k workers",
            sortDirection = "ASC",
            sourceName = "ILO ILOSTAT 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_social_protection",
            indicatorId = "social_protection_cov",
            name = "Social Protection Effective Coverage",
            unit = "% population",
            sortDirection = "DESC",
            sourceName = "ILO World Social Protection Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "employment",
            subcategoryId = "emp_child_labour",
            indicatorId = "child_labor_pct",
            name = "Child Labor Prevalence",
            unit = "% (ages 5-17)",
            sortDirection = "ASC",
            sourceName = "ILO / UNICEF Global Estimates 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_research_spending",
            indicatorId = "rnd_expenditure_total_usd",
            name = "Gross R&D Expenditure (GERD)",
            unit = "Billion USD PPP",
            sortDirection = "DESC",
            sourceName = "UNESCO Institute for Statistics 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_researchers",
            indicatorId = "researchers_per_million",
            name = "R&D Researchers Density",
            unit = "researchers / 1M people",
            sortDirection = "DESC",
            sourceName = "UNESCO Science Report 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_scientific_publications",
            indicatorId = "scientific_publications",
            name = "Scientific Journal Articles Published",
            unit = "articles / year",
            sortDirection = "DESC",
            sourceName = "NSF / Scopus Elsevier 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_citations",
            indicatorId = "citations_per_paper",
            name = "Mean Scientific Citations Per Paper",
            unit = "citations avg",
            sortDirection = "DESC",
            sourceName = "Scimago Journal & Country Rank 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_scientific_patents",
            indicatorId = "triadic_patents_count",
            name = "Triadic Patent Families",
            unit = "patent families",
            sortDirection = "DESC",
            sourceName = "OECD Patent Statistics / WIPO"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_space_exploration",
            indicatorId = "space_budget_usd",
            name = "Civilian Space Agency Budget",
            unit = "Million USD",
            sortDirection = "DESC",
            sourceName = "Euroconsult / NASA / ESA 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_satellites",
            indicatorId = "operational_satellites",
            name = "Operational Satellites in Orbit",
            unit = "satellites in orbit",
            sortDirection = "DESC",
            sourceName = "Union of Concerned Scientists (UCS) Satellite Database"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_astronomy",
            indicatorId = "major_telescopes_count",
            name = "Major Astronomical Observatories",
            unit = "observatories",
            sortDirection = "DESC",
            sourceName = "International Astronomical Union (IAU)"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_biotechnology",
            indicatorId = "biotech_patents_share",
            name = "Biotechnology Patents Share",
            unit = "% total patents",
            sortDirection = "DESC",
            sourceName = "WIPO / OECD Biotechnology Statistics"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_medical_research",
            indicatorId = "clinical_trials_count",
            name = "Registered Clinical Trials",
            unit = "registered trials",
            sortDirection = "DESC",
            sourceName = "WHO International Clinical Trials Registry (ICTRP 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_physics_chemistry",
            indicatorId = "high_energy_physics_pubs",
            name = "Physical Sciences Research Output",
            unit = "publications / yr",
            sortDirection = "DESC",
            sourceName = "Nature Index / INSPIRE-HEP 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_engineering",
            indicatorId = "engineering_graduates_pct",
            name = "Engineering Graduate Share",
            unit = "% tertiary grads",
            sortDirection = "DESC",
            sourceName = "UNESCO Institute for Statistics 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_nobel_prizes",
            indicatorId = "nobel_laureates_total",
            name = "Nobel Prize Laureates Total",
            unit = "laureates all-time",
            sortDirection = "DESC",
            sourceName = "The Nobel Foundation Official Records"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_research_infra",
            indicatorId = "supercomputers_top500",
            name = "TOP500 Supercomputers Hosted",
            unit = "systems on TOP500",
            sortDirection = "DESC",
            sourceName = "TOP500 Supercomputing List (June/Nov 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "science",
            subcategoryId = "sci_international_collaboration",
            indicatorId = "intl_coauthored_papers_pct",
            name = "International Co-Authorship Rate",
            unit = "% total papers",
            sortDirection = "DESC",
            sourceName = "Scopus / Science & Engineering Indicators 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_olympic_games",
            indicatorId = "olympic_medals_total",
            name = "All-Time Olympic Medals Total",
            unit = "medals (Summer+Winter)",
            sortDirection = "DESC",
            sourceName = "International Olympic Committee (IOC Official)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_paralympic_games",
            indicatorId = "paralympic_medals_total",
            name = "All-Time Paralympic Medals Total",
            unit = "medals all-time",
            sortDirection = "DESC",
            sourceName = "International Paralympic Committee (IPC Official)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_football",
            indicatorId = "fifa_ranking",
            name = "FIFA Men's World Ranking",
            unit = "rank position",
            sortDirection = "ASC",
            sourceName = "FIFA Official World Ranking (Oct 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_cricket",
            indicatorId = "icc_test_ranking",
            name = "ICC Men's Cricket World Ranking",
            unit = "rank position",
            sortDirection = "ASC",
            sourceName = "International Cricket Council (ICC 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_basketball",
            indicatorId = "fiba_world_ranking",
            name = "FIBA Men's Basketball Ranking",
            unit = "rank position",
            sortDirection = "ASC",
            sourceName = "FIBA Official World Ranking 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_tennis",
            indicatorId = "top100_tennis_players",
            name = "Top 100 Professional Tennis Players",
            unit = "players in top 100",
            sortDirection = "DESC",
            sourceName = "ATP / WTA Official Rankings 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_badminton",
            indicatorId = "bwf_top50_players",
            name = "Top 50 Badminton World Players",
            unit = "players count",
            sortDirection = "DESC",
            sourceName = "Badminton World Federation (BWF 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_hockey",
            indicatorId = "fih_world_ranking",
            name = "FIH Field Hockey World Ranking",
            unit = "rank position",
            sortDirection = "ASC",
            sourceName = "International Hockey Federation (FIH 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_athletics",
            indicatorId = "world_athletics_records",
            name = "World Athletics Records Held",
            unit = "active records",
            sortDirection = "DESC",
            sourceName = "World Athletics Official Records 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_swimming",
            indicatorId = "fina_world_championship_medals",
            name = "World Aquatics Championship Medals",
            unit = "medals all-time",
            sortDirection = "DESC",
            sourceName = "World Aquatics (FINA 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_other_sports",
            indicatorId = "sport_diversity_index",
            name = "Olympic Sports Diversity Index",
            unit = "sports with medalists",
            sortDirection = "DESC",
            sourceName = "IOC / Association of Summer Olympic IFs"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_world_records",
            indicatorId = "guinness_records_held",
            name = "Guinness World Records Recognized",
            unit = "records count",
            sortDirection = "DESC",
            sourceName = "Guinness World Records Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_sports_participation",
            indicatorId = "adult_physical_activity_pct",
            name = "Adult Physical Activity Compliance",
            unit = "% of adults",
            sortDirection = "DESC",
            sourceName = "WHO Physical Activity Guidelines 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_stadiums",
            indicatorId = "major_stadiums_count",
            name = "Major Stadiums (>30k Capacity)",
            unit = "stadiums count",
            sortDirection = "DESC",
            sourceName = "World Stadiums Database / FIFA Venue Registries"
        ),
        CategoryIndicatorEntity(
            categoryId = "sports",
            subcategoryId = "sports_historical_champions",
            indicatorId = "world_cup_titles_total",
            name = "Senior World Cup Championship Titles",
            unit = "titles (Football, Cricket, Rugby)",
            sortDirection = "DESC",
            sourceName = "FIFA / ICC / World Rugby Official Records"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_largest_cities",
            indicatorId = "largest_metro_pop",
            name = "Largest Metro Population",
            unit = "Million residents",
            sortDirection = "DESC",
            sourceName = "UN-Habitat / Demographia World Urban Areas 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_population_growth",
            indicatorId = "urban_pop_growth_rate",
            name = "Annual Urban Population Growth Rate",
            unit = "% annual",
            sortDirection = "DESC",
            sourceName = "UN DESA World Urbanization Prospects 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_population_density",
            indicatorId = "largest_city_density",
            name = "Largest Urban Area Density",
            unit = "people / km²",
            sortDirection = "DESC",
            sourceName = "Demographia World Urban Areas 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_economic_cities",
            indicatorId = "metro_gdp_usd",
            name = "Largest City Metropolitan GDP",
            unit = "Billion USD",
            sortDirection = "DESC",
            sourceName = "Brookings Global Metro Monitor / Oxford Economics 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_cost_of_living",
            indicatorId = "cost_of_living_index",
            name = "Primate City Cost of Living Index",
            unit = "index (NYC = 100)",
            sortDirection = "DESC",
            sourceName = "Mercer Cost of Living / Numbeo 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_quality_of_life",
            indicatorId = "city_quality_of_life_idx",
            name = "Urban Quality of Living Score",
            unit = "score (0-200)",
            sortDirection = "DESC",
            sourceName = "Mercer Quality of Living / EIU Global Liveability 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_smart_cities",
            indicatorId = "smart_city_index",
            name = "IMD Smart City Index Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "IMD Smart City Observatory / SUTD 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_cleanest_cities",
            indicatorId = "city_pm25_annual",
            name = "Capital City PM2.5 Exposure",
            unit = "µg / m³",
            sortDirection = "ASC",
            sourceName = "WHO Urban Air Quality Database 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_green_cities",
            indicatorId = "green_space_per_capita",
            name = "Urban Green Space Per Resident",
            unit = "m² / person",
            sortDirection = "DESC",
            sourceName = "UN-Habitat / European Environment Agency"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_city_transport",
            indicatorId = "public_transit_commute_pct",
            name = "Public Transit Commuter Share",
            unit = "% of commutes",
            sortDirection = "DESC",
            sourceName = "UITP International Public Transport / Moovit 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_housing",
            indicatorId = "housing_price_to_income",
            name = "Urban House Price-to-Income Ratio",
            unit = "years of income",
            sortDirection = "ASC",
            sourceName = "Demographia Housing Affordability / OECD 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_safety",
            indicatorId = "safest_city_index",
            name = "Urban Safety & Security Index",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "EIU Safe Cities Index / Numbeo Crime Index 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_tourism",
            indicatorId = "city_international_visitors",
            name = "Top City International Tourist Arrivals",
            unit = "Million visitors / yr",
            sortDirection = "DESC",
            sourceName = "Mastercard Global Destination Cities / Euromonitor 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_skyscrapers",
            indicatorId = "skyscrapers_150m_count",
            name = "Skyscrapers Over 150m Built",
            unit = "buildings count",
            sortDirection = "DESC",
            sourceName = "Council on Tall Buildings and Urban Habitat (CTBUH 2024)"
        ),
        CategoryIndicatorEntity(
            categoryId = "city_rankings",
            subcategoryId = "city_urbanisation",
            indicatorId = "city_urban_pop_share",
            name = "National Urbanization Level",
            unit = "% of total population",
            sortDirection = "DESC",
            sourceName = "UN DESA World Urbanization Prospects 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_01_no_poverty",
            indicatorId = "sdg_01_score",
            name = "SDG 1: No Poverty Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge University Press 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_02_zero_hunger",
            indicatorId = "sdg_02_score",
            name = "SDG 2: Zero Hunger Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_03_good_health",
            indicatorId = "sdg_03_score",
            name = "SDG 3: Good Health & Well-being",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_04_quality_education",
            indicatorId = "sdg_04_score",
            name = "SDG 4: Quality Education Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_05_gender_equality",
            indicatorId = "sdg_05_score",
            name = "SDG 5: Gender Equality Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_06_clean_water",
            indicatorId = "sdg_06_score",
            name = "SDG 6: Clean Water & Sanitation",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_07_clean_energy",
            indicatorId = "sdg_07_score",
            name = "SDG 7: Affordable & Clean Energy",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_08_decent_work",
            indicatorId = "sdg_08_score",
            name = "SDG 8: Decent Work & Economic Growth",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_09_industry_infra",
            indicatorId = "sdg_09_score",
            name = "SDG 9: Industry, Innovation & Infra",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_10_reduced_inequalities",
            indicatorId = "sdg_10_score",
            name = "SDG 10: Reduced Inequalities Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_11_sustainable_cities",
            indicatorId = "sdg_11_score",
            name = "SDG 11: Sustainable Cities Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_12_responsible_consumption",
            indicatorId = "sdg_12_score",
            name = "SDG 12: Responsible Consumption",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_13_climate_action",
            indicatorId = "sdg_13_score",
            name = "SDG 13: Climate Action Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_14_life_below_water",
            indicatorId = "sdg_14_score",
            name = "SDG 14: Life Below Water Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_15_life_on_land",
            indicatorId = "sdg_15_score",
            name = "SDG 15: Life on Land Score",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_16_peace_justice",
            indicatorId = "sdg_16_score",
            name = "SDG 16: Peace, Justice & Institutions",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
        CategoryIndicatorEntity(
            categoryId = "un_sdg_goals",
            subcategoryId = "sdg_17_partnerships",
            indicatorId = "sdg_17_score",
            name = "SDG 17: Partnerships for the Goals",
            unit = "score (0-100)",
            sortDirection = "DESC",
            sourceName = "UN SDSN / Cambridge 2024"
        ),
    )

    fun getIndicatorsForCategory(categoryId: String): List<CategoryIndicatorEntity> {
        return list.filter { it.categoryId.equals(categoryId, ignoreCase = true) }
    }

    fun getIndicatorsForSubcategory(subcategoryId: String): List<CategoryIndicatorEntity> {
        val direct = list.filter { it.subcategoryId.equals(subcategoryId, ignoreCase = true) }
        if (direct.isNotEmpty()) return direct
        val catId = DefaultSubcategories.getSubcategory(subcategoryId)?.categoryId
        return if (catId != null) getIndicatorsForCategory(catId) else emptyList()
    }
}
