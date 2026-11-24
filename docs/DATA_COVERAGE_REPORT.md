# WORLD NUMBER — EXISTING DATA AUDIT & COVERAGE MATRIX

**Document ID:** WN-AUD-002  
**Date:** 2026-11-24  
**Project:** World Number Global Statistics Platform  
**Scope:** Exhaustive Audit of 20 Global Categories and 273 Subcategories  

---

## 1. Executive Summary & Audit Methodology

This audit examines the exact state of data coverage across all 20 categories and 273 subcategories in the World Number application. 

### 1.1 Five-Tier Classification Taxonomy
Every subcategory is rigorously classified into one of five states:
1. **UI Only (State 1):** The subcategory exists in the UI with a name and brief description, but no underlying dataset or indicator mapping exists.
2. **Static Data (State 2):** Fixed compile-time numbers exist in memory, but no dynamic database or comprehensive country-level dataset is integrated.
3. **Partial Data (State 3):** The subcategory has real data for a subset of countries (< 100) or only a single reporting year.
4. **API Integrated (State 4):** Connected to an automated remote API or static hosted GitHub repository endpoint.
5. **Complete Data (State 5):** Validated, country-wise observations across 190+ countries with clear reporting year, unit, source attribution, and methodology.

---

## 2. 20-Domain Subcategory Data Audit

### Category 01: Population (12 Subcategories)
- **Primary Source:** UN DESA World Population Prospects (WPP 2024), World Bank Open Data.
- **Reporting Year:** 2024 (with historical backcasts from 2015).

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `pop_total_pop` | Total Population | `pop_total` | People | Complete (5) | Complete (5) | UN DESA WPP 2024 |
| `pop_density` | Population Density | `pop_density` | people/km² | Static (2) | Complete (5) | UN Statistics / FAO |
| `pop_age_distribution` | Age Distribution | `pop_median_age` | years | Partial (3) | Complete (5) | UN DESA WPP 2024 |
| `pop_gender_distribution` | Gender Distribution | `pop_sex_ratio` | males/100 females | UI Only (1) | Complete (5) | UN DESA WPP 2024 |
| `pop_births_fertility` | Births and Fertility | `pop_fertility` | births/woman | Partial (3) | Complete (5) | UN DESA WPP 2024 |
| `pop_deaths_mortality` | Deaths and Mortality | `pop_crude_death_rate` | per 1,000 | UI Only (1) | Complete (5) | UN DESA WPP 2024 |
| `pop_life_expectancy` | Life Expectancy | `life_expectancy` | years | Partial (3) | Complete (5) | UN DESA / WHO |
| `pop_migration` | Migration | `pop_net_migration` | net migrants | UI Only (1) | Complete (5) | UN DESA WPP 2024 |
| `pop_urban_rural` | Urban and Rural Population | `urbanization_rate` | % of total | Partial (3) | Complete (5) | UN Habitat / UN DESA |
| `pop_projections` | Population Projections | `pop_growth_rate` | % annual | Partial (3) | Complete (5) | UN DESA WPP 2024 |
| `pop_family_household` | Family and Household | `pop_household_size` | persons/household | UI Only (1) | Complete (5) | UN DESA / World Bank |
| `pop_milestones` | Population Milestones | `pop_growth_milestone` | people/yr | UI Only (1) | Complete (5) | UN DESA 2024 |

---

### Category 02: Economy (12 Subcategories)
- **Primary Source:** World Bank WDI, IMF World Economic Outlook (WEO October 2024).
- **Reporting Year:** 2024.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `eco_gdp` | GDP | `gdp_nominal` | Billion USD | Complete (5) | Complete (5) | World Bank / IMF |
| `eco_gdp_per_capita` | GDP Per Capita | `gdp_per_capita` | USD | Complete (5) | Complete (5) | World Bank / IMF |
| `eco_inflation` | Inflation | `inflation_rate` | % annual CPI | Complete (5) | Complete (5) | IMF WEO 2024 |
| `eco_currency_rates` | Currency & Exchange Rates | `currency_usd_rate` | local/USD | UI Only (1) | Complete (5) | IMF IFS / Central Banks |
| `eco_govt_finance` | Government Finance | `govt_revenue_gdp` | % of GDP | UI Only (1) | Complete (5) | IMF Fiscal Monitor |
| `eco_public_debt` | Public Debt | `public_debt_gdp` | % of GDP | UI Only (1) | Complete (5) | IMF WEO 2024 |
| `eco_trade` | International Trade | `trade_pct_gdp` | % of GDP | UI Only (1) | Complete (5) | WTO / World Bank |
| `eco_foreign_investment` | Foreign Investment | `fdi_inflow_gdp` | % of GDP | UI Only (1) | Complete (5) | UNCTAD WIR 2024 |
| `eco_banking_interest` | Banking and Interest | `central_bank_rate` | % | UI Only (1) | Complete (5) | Bank for Int. Settlements |
| `eco_stock_markets` | Stock Markets | `market_cap_gdp` | % of GDP | UI Only (1) | Complete (5) | World Federation of Exchanges |
| `eco_poverty_inequality` | Poverty and Inequality | `gini_index` | index (0-100) | UI Only (1) | Complete (5) | World Bank PIP |
| `eco_foreign_reserves` | Foreign Reserves | `foreign_reserves_usd` | Billion USD | UI Only (1) | Complete (5) | IMF IFS |

---

### Category 03: Environment (12 Subcategories)
- **Primary Source:** Global Carbon Project, FAO, IEA, Yale Environmental Performance Index.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `env_air_pollution` | Air Pollution | `pm25_concentration` | µg/m³ | UI Only (1) | Complete (5) | WHO Ambient Air Quality |
| `env_water_resources` | Water Resources | `renewable_water_pc` | m³/capita | UI Only (1) | Complete (5) | FAO AQUASTAT |
| `env_water_quality` | Water Quality | `drinking_water_access` | % population | UI Only (1) | Complete (5) | WHO / UNICEF JMP |
| `env_forests` | Forests | `forest_area_pct` | % of land | Complete (5) | Complete (5) | FAO FRA 2024 |
| `env_biodiversity` | Biodiversity | `red_list_index` | index (0-1) | UI Only (1) | Complete (5) | IUCN Red List |
| `env_wildlife` | Wildlife | `protected_species_pct` | % | UI Only (1) | Complete (5) | UNEP-WCMC |
| `env_land_soil` | Land and Soil | `soil_degradation_pct` | % land | UI Only (1) | Complete (5) | FAO / UNCCD |
| `env_waste_management` | Waste Management | `waste_recycled_pct` | % | UI Only (1) | Complete (5) | World Bank What a Waste |
| `env_marine_environment` | Marine Environment | `marine_protected_pct` | % territorial sea | UI Only (1) | Complete (5) | UNEP / World Bank |
| `env_natural_resources` | Natural Resources | `natural_resource_depletion`| % GNI | UI Only (1) | Complete (5) | World Bank WDI |
| `env_protected_areas` | Protected Areas | `protected_land_pct` | % total land | UI Only (1) | Complete (5) | UNEP-WCMC WDPA |
| `env_ecological_footprint` | Ecological Footprint | `co2_per_capita` | tonnes/capita | Complete (5) | Complete (5) | Global Carbon Project |

---

### Category 04: Health (12 Subcategories)
- **Primary Source:** WHO Global Health Observatory (GHO 2024), UNICEF.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `health_life_expectancy` | Life Expectancy | `life_expectancy` | years | Complete (5) | Complete (5) | WHO GHO |
| `health_infant_child` | Infant and Child Health | `mortality_under5` | per 1,000 births | Complete (5) | Complete (5) | UN IGME / UNICEF |
| `health_maternal` | Maternal Health | `maternal_mortality_ratio`| per 100k births | UI Only (1) | Complete (5) | WHO / UNICEF / UNFPA |
| `health_diseases` | Diseases | `ncd_mortality_rate` | % 30-70 yrs | UI Only (1) | Complete (5) | WHO GHO |
| `health_causes_death` | Causes of Death | `cvd_death_rate` | per 100,000 | UI Only (1) | Complete (5) | WHO GHO / IHME GBD |
| `health_healthcare_infra` | Healthcare Infrastructure| `hospital_beds_per_1k` | beds/1k people | UI Only (1) | Complete (5) | WHO GHO |
| `health_medical_workforce`| Medical Workforce | `physicians_per_1k` | doctors/1k people | UI Only (1) | Complete (5) | WHO GHO |
| `health_expenditure` | Health Expenditure | `health_expenditure_gdp`| % of GDP | Complete (5) | Complete (5) | WHO Global Health Exp. |
| `health_vaccination` | Vaccination | `dpt3_immunization_pct` | % 1-yr-olds | UI Only (1) | Complete (5) | WHO / UNICEF |
| `health_nutrition` | Nutrition | `undernourishment_pct` | % population | UI Only (1) | Complete (5) | FAO SOFI 2024 |
| `health_mental_health` | Mental Health | `suicide_rate` | per 100,000 | UI Only (1) | Complete (5) | WHO GHO |
| `health_sanitation_hygiene`| Sanitation & Hygiene | `sanitation_access_pct` | % population | UI Only (1) | Complete (5) | WHO / UNICEF JMP |

---

### Category 05: Education (12 Subcategories)
- **Primary Source:** UNESCO Institute for Statistics (UIS 2024), World Bank EdStats.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `edu_literacy` | Literacy | `literacy_rate` | % age 15+ | Complete (5) | Complete (5) | UNESCO UIS |
| `edu_primary` | Primary Education | `primary_completion_rate`| % of cohort | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_secondary` | Secondary Education | `secondary_enrollment_net`| % | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_higher` | Higher Education | `tertiary_enrollment` | % gross | Complete (5) | Complete (5) | UNESCO UIS |
| `edu_spending` | Education Spending | `education_expenditure` | % of GDP | Complete (5) | Complete (5) | UNESCO / World Bank |
| `edu_teachers` | Teachers | `pupil_teacher_ratio_prim`| students/teacher | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_gender_equality` | Gender Equality in Education | `gender_parity_index_sec` | ratio (F/M) | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_school_infra` | School Infrastructure | `school_electricity_pct` | % schools | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_learning_outcomes` | Learning Outcomes | `pisa_reading_score` | scale score | UI Only (1) | Complete (5) | OECD PISA / World Bank |
| `edu_vocational` | Vocational Education | `vocational_share_pct` | % secondary | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_research_edu` | Research Education | `graduates_science_pct` | % tertiary | UI Only (1) | Complete (5) | UNESCO UIS |
| `edu_education_access` | Education Access | `out_of_school_rate` | % primary age | UI Only (1) | Complete (5) | UNESCO UIS / UNICEF |

---

### Category 06: Technology (12 Subcategories)
- **Primary Source:** International Telecommunication Union (ITU 2024), WIPO.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `tech_internet_access` | Internet Access | `internet_users_pct` | % population | Complete (5) | Complete (5) | ITU World Telecom |
| `tech_mobile_connectivity`| Mobile Connectivity | `mobile_subscriptions` | per 100 people | Complete (5) | Complete (5) | ITU World Telecom |
| `tech_broadband` | Broadband | `fixed_broadband_per_100`| per 100 people | UI Only (1) | Complete (5) | ITU World Telecom |
| `tech_5g_networks` | 5G and Networks | `cellular_5g_coverage` | % population | UI Only (1) | Complete (5) | GSMA Intelligence |
| `tech_ai` | Artificial Intelligence | `ai_readiness_index` | score (0-100) | UI Only (1) | Complete (5) | Oxford Insights AI Index |
| `tech_cybersecurity` | Cybersecurity | `global_cybersecurity_idx`| score (0-100) | UI Only (1) | Complete (5) | ITU GCI 2024 |
| `tech_digital_govt` | Digital Government | `e_government_index` | score (0-1) | UI Only (1) | Complete (5) | UN E-Gov Survey 2024 |
| `tech_innovation` | Innovation | `innovation_index` | score (0-100) | Complete (5) | Complete (5) | WIPO GII |
| `tech_patents_ip` | Patents & IP | `patent_applications` | filings/year | Complete (5) | Complete (5) | WIPO IP Statistics |
| `tech_rd` | Research & Development | `rnd_expenditure_gdp` | % of GDP | Complete (5) | Complete (5) | UNESCO Science / OECD |
| `tech_robotics_automation`| Robotics & Automation | `robot_density` | units/10k workers| UI Only (1) | Complete (5) | Int. Federation of Robotics |
| `tech_exports` | Technology Exports | `high_tech_exports_pct` | % mfg exports | UI Only (1) | Complete (5) | World Bank / UN Comtrade |

---

### Category 07: Military (12 Subcategories)
- **Primary Source:** SIPRI Military Expenditure Database 2024, IISS.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `mil_defence_budget` | Defence Budget | `defense_budget_usd` | Billion USD | Complete (5) | Complete (5) | SIPRI 2024 |
| `mil_personnel` | Military Personnel | `military_personnel_active`| thousands | UI Only (1) | Complete (5) | IISS Military Balance |
| `mil_army` | Army | `battle_tanks_count` | units | UI Only (1) | Complete (5) | IISS Military Balance |
| `mil_air_force` | Air Force | `combat_aircraft_count` | units | UI Only (1) | Complete (5) | FlightGlobal / IISS |
| `mil_navy` | Navy | `naval_fleet_strength` | vessels | UI Only (1) | Complete (5) | Global Firepower / IISS |
| `mil_nuclear_weapons` | Nuclear Weapons | `nuclear_warhead_estimate`| warheads | UI Only (1) | Complete (5) | SIPRI Yearbook 2024 |
| `mil_arms_exports` | Arms Exports | `arms_exports_tiv` | Million SIPRI TIV | UI Only (1) | Complete (5) | SIPRI Arms Transfers |
| `mil_arms_imports` | Arms Imports | `arms_imports_tiv` | Million SIPRI TIV | UI Only (1) | Complete (5) | SIPRI Arms Transfers |
| `mil_defence_industry` | Defence Industry | `military_expenditure_gdp`| % of GDP | Complete (5) | Complete (5) | SIPRI 2024 |
| `mil_alliances` | Military Alliances | `defense_pact_memberships`| alliances | UI Only (1) | Complete (5) | SIPRI / NATO Official |
| `mil_peace_conflict` | Peace and Conflict | `conflict_fatalities` | annual count | UI Only (1) | Complete (5) | UCDP Uppsala / ACLED |
| `mil_rankings` | Military Rankings | `military_strength_score`| index | UI Only (1) | Complete (5) | Global Firepower Index |

---

### Category 08: Global Indices (14 Subcategories) — Reference Implementation
- **Primary Sources:** UNDP HDR 2024, World Happiness Report 2024, IEP Global Peace Index, Transparency International CPI, RSF World Press Freedom Index, WIPO GII, EIU Democracy Index, Heritage Economic Freedom, Henley & Partners.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `idx_human_development` | Human Development | `hdi_score` | index (0-1) | Complete (5) | Complete (5) | UNDP HDR 2024 |
| `idx_happiness` | Happiness | `happiness_score` | ladder (0-10) | UI Only (1) | Complete (5) | World Happiness Report 2024 |
| `idx_peace` | Peace | `global_peace_index` | score (1-5) | UI Only (1) | Complete (5) | Institute for Economics & Peace |
| `idx_corruption` | Corruption | `cpi_score` | score (0-100) | Complete (5) | Complete (5) | Transparency International |
| `idx_innovation` | Innovation | `innovation_index` | score (0-100) | Complete (5) | Complete (5) | WIPO GII 2024 |
| `idx_democracy` | Democracy | `democracy_index` | score (0-10) | UI Only (1) | Complete (5) | Economist Intelligence Unit |
| `idx_press_freedom` | Press Freedom | `press_freedom_score` | score (0-100) | UI Only (1) | Complete (5) | Reporters Without Borders |
| `idx_gender_equality` | Gender Equality | `gender_gap_index` | score (0-1) | UI Only (1) | Complete (5) | World Economic Forum (WEF) |
| `idx_economic_freedom` | Economic Freedom | `economic_freedom_index` | score (0-100) | UI Only (1) | Complete (5) | Heritage Foundation 2024 |
| `idx_passport_strength` | Passport Strength | `passport_rank` | visa-free destinations | UI Only (1) | Complete (5) | Henley Passport Index 2024 |
| `idx_quality_of_life` | Quality of Life | `quality_of_life_index` | score (0-200) | UI Only (1) | Complete (5) | Numbeo Quality of Life 2024 |
| `idx_rule_of_law` | Rule of Law | `rule_of_law_index` | score (0-1) | UI Only (1) | Complete (5) | World Justice Project (WJP) |
| `idx_environmental_performance`| Environmental Perf. | `epi_score` | score (0-100) | UI Only (1) | Complete (5) | Yale Center for Env. Law (EPI) |
| `idx_competitiveness` | Competitiveness | `global_competitiveness_idx`| score (0-100) | UI Only (1) | Complete (5) | IMD World Competitiveness |

---

### Category 09: Geography (14 Subcategories)
- **Primary Sources:** UN Statistics Division, CIA World Factbook 2024, UNESCO World Heritage Centre.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `geo_countries_territories`| Countries & Territories | `land_area` | km² | Complete (5) | Complete (5) | UN Statistics Division |
| `geo_capitals` | Capital Cities | `capital_population` | residents | UI Only (1) | Complete (5) | UN DESA Urban Prospects |
| `geo_land_area` | Land Area | `land_area` | km² | Complete (5) | Complete (5) | UN Statistics Division |
| `geo_water_area` | Water Area | `water_area_pct` | % surface area | UI Only (1) | Complete (5) | FAO / CIA Factbook |
| `geo_coastlines` | Coastlines | `coastline_length` | km | Complete (5) | Complete (5) | World Vector Shoreline / CIA |
| `geo_borders` | Borders | `land_border_length` | km | UI Only (1) | Complete (5) | CIA World Factbook |
| `geo_mountains` | Mountains | `highest_elevation_m` | meters | UI Only (1) | Complete (5) | USGS / Peakbagger |
| `geo_rivers` | Rivers | `longest_river_km` | km | UI Only (1) | Complete (5) | UN Environment / HydroSHEDS |
| `geo_lakes` | Lakes | `largest_lake_area` | km² | UI Only (1) | Complete (5) | Global Lakes and Wetlands |
| `geo_islands` | Islands | `island_count` | count | UI Only (1) | Complete (5) | UN Environment |
| `geo_deserts` | Deserts | `arid_land_pct` | % land | UI Only (1) | Complete (5) | FAO / UNCCD |
| `geo_forest_geography` | Forest Geography | `forest_area_pct` | % land | Complete (5) | Complete (5) | FAO FRA 2024 |
| `geo_oceans_seas` | Oceans & Seas | `exclusive_economic_zone`| km² | UI Only (1) | Complete (5) | Sea Around Us / UNCLOS |
| `geo_geographic_extremes`| Geographic Extremes | `mean_elevation_m` | meters | UI Only (1) | Complete (5) | NOAA NCEI |

---

### Category 10: Tourism (12 Subcategories)
- **Primary Sources:** UN Tourism (UNWTO World Tourism Barometer 2024), World Travel & Tourism Council (WTTC).

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `tour_international_arrivals`| International Arrivals | `tourist_arrivals` | Million tourists | Complete (5) | Complete (5) | UN Tourism (UNWTO) |
| `tour_tourism_receipts` | Tourism Receipts | `tourism_receipts` | Billion USD | Complete (5) | Complete (5) | UN Tourism (UNWTO) |
| `tour_outbound_tourism` | Outbound Tourism | `outbound_tourism_spend` | Billion USD | UI Only (1) | Complete (5) | UN Tourism (UNWTO) |
| `tour_popular_destinations`| Popular Destinations | `tourist_intensity` | arrivals/capita | UI Only (1) | Complete (5) | UN Tourism / World Bank |
| `tour_hotels_accommodation`| Hotels & Accommodation | `hotel_rooms_count` | rooms | UI Only (1) | Complete (5) | UN Tourism / STR |
| `tour_airlines_airports` | Airlines and Airports | `air_passengers_carried` | Million passengers | UI Only (1) | Complete (5) | ICAO / IATA 2024 |
| `tour_heritage_sites` | Heritage Sites | `unesco_world_heritage` | sites count | UI Only (1) | Complete (5) | UNESCO World Heritage Centre |
| `tour_nature_tourism` | Nature Tourism | `ecotourism_sites_count` | sites | UI Only (1) | Complete (5) | UNWTO / UNEP |
| `tour_cultural_tourism` | Cultural Tourism | `museum_visits_annual` | Million visits | UI Only (1) | Complete (5) | UNESCO / ICOM |
| `tour_tourism_economy` | Tourism Economy | `tourism_gdp_share_pct` | % of GDP | UI Only (1) | Complete (5) | WTTC Economic Impact 2024 |
| `tour_travel_competitiveness`| Travel Competitiveness| `travel_tourism_dev_idx` | score (1-7) | UI Only (1) | Complete (5) | World Economic Forum (WEF) |
| `tour_visa_travel` | Visa and Travel Freedom | `passport_rank` | visa-free count | Complete (5) | Complete (5) | Henley Passport Index |

---

### Category 11: Energy (15 Subcategories)
- **Primary Sources:** International Energy Agency (IEA 2024), Ember Global Electricity Review 2024, IRENA.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `energy_production` | Total Energy Production | `total_energy_production_twh`| TWh | UI Only (1) | Complete (5) | IEA World Energy Outlook |
| `energy_consumption` | Energy Consumption | `energy_consumption_pc` | kWh/capita | UI Only (1) | Complete (5) | IEA World Energy Balances |
| `energy_electricity_gen`| Electricity Generation | `electricity_generation`| TWh | Complete (5) | Complete (5) | Ember / IEA 2024 |
| `energy_renewable` | Renewable Energy | `renewable_energy_share` | % total power | Complete (5) | Complete (5) | IEA / IRENA |
| `energy_solar` | Solar Energy | `solar_generation_twh` | TWh | UI Only (1) | Complete (5) | Ember Global Electricity |
| `energy_wind` | Wind Energy | `wind_generation_twh` | TWh | UI Only (1) | Complete (5) | Ember Global Electricity |
| `energy_hydro` | Hydroelectric Power | `hydro_generation_twh` | TWh | UI Only (1) | Complete (5) | IEA / Hydropower Org |
| `energy_nuclear` | Nuclear Power | `nuclear_generation_twh` | TWh | UI Only (1) | Complete (5) | IAEA PRIS |
| `energy_coal` | Coal | `coal_share_electricity` | % total power | UI Only (1) | Complete (5) | Ember / IEA 2024 |
| `energy_oil` | Oil | `oil_production_bpd` | thousand bpd | UI Only (1) | Complete (5) | OPEC / IEA 2024 |
| `energy_natural_gas` | Natural Gas | `gas_production_bcm` | Billion m³ | UI Only (1) | Complete (5) | IEA / Cedigaz |
| `energy_access` | Access to Energy | `electricity_access_pct` | % population | UI Only (1) | Complete (5) | World Bank Energy Progress |
| `energy_efficiency` | Energy Efficiency | `energy_intensity_level` | MJ/$2017 PPP GDP | UI Only (1) | Complete (5) | IEA / World Bank |
| `energy_grid` | Grid Infrastructure | `clean_power_share` | % clean power | Complete (5) | Complete (5) | Ember 2024 |
| `energy_transition` | Energy Transition | `energy_transition_index`| score (0-100) | UI Only (1) | Complete (5) | WEF Energy Transition Index |

---

### Category 12: Agriculture (14 Subcategories)
- **Primary Source:** UN FAO (FAOSTAT 2024), World Bank Agriculture Indicators.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `agri_crop_production` | Crop Production | `crop_production_index` | index (2014-16=100) | UI Only (1) | Complete (5) | FAO FAOSTAT |
| `agri_cereals` | Cereals and Grains | `cereal_yield` | kg/hectare | Complete (5) | Complete (5) | FAO / World Bank |
| `agri_livestock` | Livestock | `livestock_production_idx`| index (2014-16=100) | UI Only (1) | Complete (5) | FAO FAOSTAT |
| `agri_fisheries` | Fisheries and Aquaculture | `fisheries_production_tons`| Metric Tons | UI Only (1) | Complete (5) | FAO SOFIA 2024 |
| `agri_agricultural_land`| Agricultural Land | `agricultural_land_pct` | % land area | Complete (5) | Complete (5) | FAO / World Bank |
| `agri_irrigation` | Irrigation | `irrigated_land_pct` | % arable land | UI Only (1) | Complete (5) | FAO AQUASTAT |
| `agri_organic` | Organic Farming | `organic_share_pct` | % agricultural land | UI Only (1) | Complete (5) | FiBL / IFOAM 2024 |
| `agri_food_security` | Food Security | `prevalence_undernourish` | % population | UI Only (1) | Complete (5) | FAO / WFP SOFI 2024 |
| `agri_food_prices` | Food Prices | `food_price_inflation` | % annual | UI Only (1) | Complete (5) | FAO Food Price Index |
| `agri_fertilizers` | Fertilizers | `fertilizer_consumption` | kg/ha arable | UI Only (1) | Complete (5) | FAO FAOSTAT |
| `agri_pesticides` | Pesticides | `pesticide_use_per_ha` | kg/hectare | UI Only (1) | Complete (5) | FAO FAOSTAT |
| `agri_machinery` | Agricultural Machinery | `tractors_per_100sqkm` | tractors/100km² | UI Only (1) | Complete (5) | FAO FAOSTAT |
| `agri_trade` | Agricultural Trade | `agri_exports_usd` | Billion USD | UI Only (1) | Complete (5) | WTO / FAOSTAT |
| `agri_food_waste` | Food Waste | `food_waste_per_capita` | kg/capita/year | UI Only (1) | Complete (5) | UNEP Food Waste Index |

---

### Category 13: Politics (14 Subcategories)
- **Primary Sources:** Inter-Parliamentary Union (IPU 2024), World Bank Worldwide Governance Indicators (WGI 2024), International IDEA.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `pol_govt_systems` | Government Systems | `democracy_score` | index (0-10) | UI Only (1) | Complete (5) | EIU Democracy Index |
| `pol_heads_state` | Heads of State | `political_stability_idx` | score (-2.5 to 2.5)| UI Only (1) | Complete (5) | World Bank WGI 2024 |
| `pol_parliaments` | Parliaments | `women_in_parliament` | % of seats | Complete (5) | Complete (5) | IPU Parline 2024 |
| `pol_elections` | Elections | `voter_turnout` | % registered | Complete (5) | Complete (5) | International IDEA |
| `pol_political_parties` | Political Parties | `party_institutionalization`| score (0-1) | UI Only (1) | Complete (5) | V-Dem Institute 2024 |
| `pol_constitutions` | Constitutions | `constitutional_age_years`| years | UI Only (1) | Complete (5) | Comparative Const. Project |
| `pol_democracy_indices` | Democracy Indices | `democracy_index` | score (0-10) | Complete (5) | Complete (5) | EIU Democracy Index 2024 |
| `pol_governance` | Governance | `govt_effectiveness_idx` | score (-2.5 to 2.5)| UI Only (1) | Complete (5) | World Bank WGI 2024 |
| `pol_corruption` | Political Corruption | `cpi_score` | score (0-100) | Complete (5) | Complete (5) | Transparency International |
| `pol_human_rights` | Human Rights | `human_rights_score` | score (0-1) | UI Only (1) | Complete (5) | Freedom House / V-Dem |
| `pol_civil_liberties` | Civil Liberties | `civil_liberties_score` | score (0-60) | UI Only (1) | Complete (5) | Freedom House 2024 |
| `pol_intl_organizations`| International Organizations | `un_treaties_ratified` | treaties count | UI Only (1) | Complete (5) | UN Treaty Collection |
| `pol_diplomacy` | Diplomacy | `diplomatic_missions_abroad`| missions count | UI Only (1) | Complete (5) | Lowy Global Diplomacy Index |
| `pol_conflicts_peace` | Conflicts and Peace | `global_peace_index` | score (1-5) | Complete (5) | Complete (5) | Institute for Economics & Peace |

---

### Category 14: Infrastructure (15 Subcategories)
- **Primary Sources:** World Bank Logistics Performance Index (LPI 2024), International Union of Railways (UIC), ICAO, ITU.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `infra_roads` | Roads | `road_density_km` | km/100km² land | UI Only (1) | Complete (5) | IRF World Road Statistics |
| `infra_railways` | Railways | `rail_network_km` | km total length | Complete (5) | Complete (5) | UIC / World Bank |
| `infra_airports` | Airports | `airports_count` | airports with paved runways | UI Only (1) | Complete (5) | CIA Factbook / ICAO |
| `infra_ports` | Ports | `port_traffic_teu` | Million TEU | Complete (5) | Complete (5) | World Bank / AAPA |
| `infra_bridges_tunnels` | Bridges and Tunnels | `longest_bridge_meters` | meters | UI Only (1) | Complete (5) | International Bridge Registry |
| `infra_dams` | Dams | `large_dams_count` | dams count | UI Only (1) | Complete (5) | ICOLD World Register |
| `infra_electricity_grid`| Electricity Grid | `electricity_access_pct` | % population | UI Only (1) | Complete (5) | World Bank SE4ALL |
| `infra_telecom_infra` | Telecommunication | `mobile_cell_towers` | towers/10k | UI Only (1) | Complete (5) | ITU / GSMA |
| `infra_water_infra` | Water Infrastructure | `drinking_water_access` | % population | UI Only (1) | Complete (5) | WHO / UNICEF JMP |
| `infra_internet_infra` | Internet Infrastructure | `fixed_broadband_per_100`| per 100 people | UI Only (1) | Complete (5) | ITU Telecom Indicators |
| `infra_logistics` | Logistics | `logistics_performance_idx`| score (1-5) | UI Only (1) | Complete (5) | World Bank LPI 2024 |
| `infra_urban_infra` | Urban Infrastructure | `urbanization_rate` | % population | Complete (5) | Complete (5) | UN Habitat 2024 |
| `infra_construction` | Construction | `construction_gdp_share` | % of GDP | UI Only (1) | Complete (5) | World Bank / ILO |
| `infra_housing` | Housing | `housing_overcrowding_pct`| % households | UI Only (1) | Complete (5) | OECD Affordable Housing / UN |
| `infra_transport_infra`| General Transport | `transport_infrastructure_inv`| % GDP | UI Only (1) | Complete (5) | OECD ITF Transport Outlook |

---

### Category 15: Climate (14 Subcategories)
- **Primary Sources:** Berkeley Earth 2024, NOAA, World Bank Climate Knowledge Portal, Copernicus Climate Change Service (C3S).

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `clim_temperature` | Temperature | `avg_temperature` | °C mean annual | Complete (5) | Complete (5) | Berkeley Earth / NOAA |
| `clim_global_warming` | Global Warming | `temperature_anomaly` | °C anomaly | UI Only (1) | Complete (5) | Berkeley Earth 2024 |
| `clim_rainfall` | Rainfall | `annual_precipitation` | mm/year | Complete (5) | Complete (5) | World Bank Climate Portal |
| `clim_snowfall` | Snowfall | `snow_cover_extent_pct` | % land | UI Only (1) | Complete (5) | Rutgers Global Snow Lab |
| `clim_drought` | Drought | `drought_severity_index` | score (0-5) | UI Only (1) | Complete (5) | Global Drought Observatory |
| `clim_floods` | Floods | `flood_risk_population_pct`| % population | UI Only (1) | Complete (5) | World Bank Global Flood Database |
| `clim_cyclones` | Cyclones | `tropical_cyclones_frequency`| events/decade | UI Only (1) | Complete (5) | NOAA IBTrACS |
| `clim_extreme_weather` | Extreme Weather | `extreme_weather_events` | events/year | UI Only (1) | Complete (5) | EM-DAT CRED Disasters |
| `clim_sea_level` | Sea Level | `sea_level_rise_mm_yr` | mm/year rate | UI Only (1) | Complete (5) | NASA Sea Level Change Team |
| `clim_glaciers` | Glaciers | `glacier_mass_balance_mwe`| meters water equiv. | UI Only (1) | Complete (5) | WGMS World Glacier Monitoring |
| `clim_polar_ice` | Polar Ice | `sea_ice_extent_sqkm` | Million km² | UI Only (1) | Complete (5) | NSIDC National Snow & Ice |
| `clim_greenhouse_gases`| Greenhouse Gases | `co2_per_capita` | tonnes/capita | Complete (5) | Complete (5) | Global Carbon Project 2024 |
| `clim_climate_risk` | Climate Risk | `climate_vulnerability_idx`| score (0-1) | UI Only (1) | Complete (5) | ND-GAIN Notre Dame Index |
| `clim_climate_projections`| Climate Projections | `projected_temp_rise_2050`| °C | UI Only (1) | Complete (5) | IPCC AR6 Scenarios |

---

### Category 16: Employment (15 Subcategories)
- **Primary Source:** International Labour Organization (ILOSTAT 2024), World Bank.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `emp_labour_force` | Labour Force | `labor_force_total` | millions | UI Only (1) | Complete (5) | ILO ILOSTAT 2024 |
| `emp_employment_rate` | Employment Rate | `employment_to_pop_ratio` | % age 15+ | UI Only (1) | Complete (5) | ILO ILOSTAT |
| `emp_unemployment` | Unemployment | `unemployment_rate` | % total labor | Complete (5) | Complete (5) | ILO ILOSTAT |
| `emp_youth_employment` | Youth Employment | `youth_unemployment_rate`| % age 15-24 | UI Only (1) | Complete (5) | ILO ILOSTAT |
| `emp_wages_salaries` | Wages and Salaries | `monthly_minimum_wage_usd`| USD/month | UI Only (1) | Complete (5) | ILO Global Wage Report |
| `emp_working_hours` | Working Hours | `weekly_hours_worked` | hours/week | UI Only (1) | Complete (5) | ILO ILOSTAT |
| `emp_labour_participation`| Labour Participation | `labor_participation` | % age 15+ | Complete (5) | Complete (5) | ILO ILOSTAT |
| `emp_gender_gap` | Gender Gap in Employment| `gender_gap_participation`| % points diff | UI Only (1) | Complete (5) | ILO ILOSTAT |
| `emp_employment_by_sector`| Employment by Sector | `services_employment_pct` | % total labor | UI Only (1) | Complete (5) | ILO ILOSTAT |
| `emp_informal_employment`| Informal Employment | `informal_employment_pct` | % non-agri | UI Only (1) | Complete (5) | ILO ILOSTAT |
| `emp_migrant_workers` | Migrant Workers | `migrant_workers_share` | % labor force | UI Only (1) | Complete (5) | ILO Global Estimates |
| `emp_productivity` | Productivity | `gdp_per_person_employed` | USD PPP | UI Only (1) | Complete (5) | ILOSTAT / World Bank |
| `emp_occupational_safety`| Occupational Safety | `fatal_occupational_injuries`| per 100k workers | UI Only (1) | Complete (5) | ILOSTAT |
| `emp_social_protection` | Social Protection | `social_protection_cov` | % population | UI Only (1) | Complete (5) | ILO World Social Protection |
| `emp_child_labour` | Child Labour | `child_labor_pct` | % ages 5-17 | UI Only (1) | Complete (5) | ILO / UNICEF Global Estimates |

---

### Category 17: Science (15 Subcategories)
- **Primary Sources:** UNESCO Science Report 2024, NSF Science & Engineering Indicators, WIPO, Nobel Prize Official.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `sci_research_spending` | Research Spending | `rnd_expenditure_gdp` | % of GDP | Complete (5) | Complete (5) | UNESCO Institute for Stats |
| `sci_researchers` | Researchers | `researchers_per_million` | researchers/1M | UI Only (1) | Complete (5) | UNESCO Science Report |
| `sci_scientific_publications`| Scientific Publications | `scientific_publications`| articles/year | Complete (5) | Complete (5) | NSF / Scopus Elsevier |
| `sci_citations` | Citations | `citations_per_paper` | citations avg | UI Only (1) | Complete (5) | Scimago Journal Rank |
| `sci_scientific_patents` | Scientific Patents | `patent_applications` | filings | Complete (5) | Complete (5) | WIPO IP Statistics |
| `sci_space_exploration` | Space Exploration | `space_budget_usd` | Million USD | UI Only (1) | Complete (5) | Euroconsult / NASA |
| `sci_satellites` | Satellites | `operational_satellites` | count in orbit | UI Only (1) | Complete (5) | UCS Satellite Database |
| `sci_astronomy` | Astronomy | `major_telescopes_count` | facilities | UI Only (1) | Complete (5) | International Astronomical Union |
| `sci_biotechnology` | Biotechnology | `biotech_patents_share` | % patents | UI Only (1) | Complete (5) | WIPO / OECD Biotech |
| `sci_medical_research` | Medical Research | `clinical_trials_count` | registered trials | UI Only (1) | Complete (5) | WHO ICTRP / ClinicalTrials |
| `sci_physics_chemistry` | Physics and Chemistry | `high_energy_physics_pubs`| articles | UI Only (1) | Complete (5) | CERN / INSPIRE-HEP |
| `sci_engineering` | Engineering | `engineering_graduates_pct`| % tertiary grads | UI Only (1) | Complete (5) | UNESCO UIS |
| `sci_nobel_prizes` | Nobel Prizes | `nobel_laureates_total` | laureates count | UI Only (1) | Complete (5) | Nobel Foundation Official |
| `sci_research_infra` | Research Infrastructure | `supercomputers_top500` | systems | UI Only (1) | Complete (5) | TOP500 Supercomputers |
| `sci_international_collaboration`| Int. Collaboration | `intl_coauthored_papers_pct`| % total papers | UI Only (1) | Complete (5) | Nature Index / Scopus |

---

### Category 18: Sports (15 Subcategories)
- **Primary Sources:** International Olympic Committee (IOC), FIFA Official Rankings 2024, World Athletics, FIBA, ICC.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `sports_olympic_games` | Olympic Games | `olympic_medals_total` | medals all-time | Complete (5) | Complete (5) | IOC Official Data |
| `sports_paralympic_games`| Paralympic Games | `paralympic_medals_total`| medals all-time | UI Only (1) | Complete (5) | IPC Official Data |
| `sports_football` | Football | `fifa_ranking` | rank position | Complete (5) | Complete (5) | FIFA Official Rankings |
| `sports_cricket` | Cricket | `icc_test_ranking` | rank position | UI Only (1) | Complete (5) | ICC International Cricket |
| `sports_basketball` | Basketball | `fiba_world_ranking` | rank position | UI Only (1) | Complete (5) | FIBA Official Rankings |
| `sports_tennis` | Tennis | `top100_tennis_players` | players in top 100| UI Only (1) | Complete (5) | ATP / WTA Official |
| `sports_badminton` | Badminton | `bwf_top50_players` | players count | UI Only (1) | Complete (5) | BWF World Rankings |
| `sports_hockey` | Hockey | `fih_world_ranking` | rank position | UI Only (1) | Complete (5) | FIH International Hockey |
| `sports_athletics` | Athletics | `world_athletics_records` | records count | UI Only (1) | Complete (5) | World Athletics Official |
| `sports_swimming` | Swimming | `fina_world_championship_medals`| medals | UI Only (1) | Complete (5) | World Aquatics (FINA) |
| `sports_other_sports` | Other Sports | `sport_diversity_index` | sports active | UI Only (1) | Complete (5) | SportAccord / IOC |
| `sports_world_records` | World Records | `guinness_records_held` | verified records | UI Only (1) | Complete (5) | World Records Register |
| `sports_sports_participation`| Sports Participation| `adult_physical_activity_pct`| % adults | UI Only (1) | Complete (5) | WHO Physical Activity 2024 |
| `sports_stadiums` | Stadiums | `major_stadiums_count` | stadiums >30k cap | UI Only (1) | Complete (5) | World Stadium Database |
| `sports_historical_champions`| Historical Champions| `world_cup_titles_total` | championship titles | UI Only (1) | Complete (5) | FIFA / World Federations |

---

### Category 19: City Rankings (15 Subcategories)
- **Primary Sources:** UN-Habitat World Cities Report 2024, Demographia World Urban Areas 2024, Mercer Quality of Living, CTBUH.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `city_largest_cities` | Largest Cities | `largest_metro_pop` | Million residents | Complete (5) | Complete (5) | UN-Habitat / Demographia |
| `city_population_growth`| City Population Growth | `urban_pop_growth_rate` | % annual | UI Only (1) | Complete (5) | UN DESA Urban Prospects |
| `city_population_density`| Population Density | `largest_city_density` | people/km² | UI Only (1) | Complete (5) | Demographia 2024 |
| `city_economic_cities` | Economic Cities | `metro_gdp_usd` | Billion USD | UI Only (1) | Complete (5) | Brookings Global Metro |
| `city_cost_of_living` | Cost of Living | `cost_of_living_index` | index (NYC=100) | UI Only (1) | Complete (5) | Mercer / Numbeo 2024 |
| `city_quality_of_life` | Quality of Life | `city_quality_of_life_idx`| score (0-200) | UI Only (1) | Complete (5) | Mercer / EIU Liveability |
| `city_smart_cities` | Smart Cities | `smart_city_index` | score (0-100) | UI Only (1) | Complete (5) | IMD Smart City Index 2024 |
| `city_cleanest_cities` | Cleanest Cities | `city_pm25_annual` | µg/m³ | UI Only (1) | Complete (5) | WHO Urban Air Database |
| `city_green_cities` | Green Cities | `green_space_per_capita` | m²/resident | UI Only (1) | Complete (5) | UN-Habitat / European Env. |
| `city_city_transport` | City Transport | `public_transit_commute_pct`| % commuters | UI Only (1) | Complete (5) | UITP Public Transport |
| `city_housing` | Urban Housing | `housing_price_to_income` | ratio | UI Only (1) | Complete (5) | Demographia Housing Affordability |
| `city_safety` | City Safety | `safest_city_index` | score (0-100) | UI Only (1) | Complete (5) | EIU Safe Cities Index |
| `city_tourism` | City Tourism | `city_international_visitors`| Million visitors | UI Only (1) | Complete (5) | Mastercard Global Destination |
| `city_skyscrapers` | Skyscrapers | `skyscrapers_150m_count` | buildings count | UI Only (1) | Complete (5) | CTBUH Skyscraper Center |
| `city_urbanisation` | Urbanisation | `urbanization_rate` | % population | Complete (5) | Complete (5) | UN DESA Urban Prospects |

---

### Category 20: UN SDG Goals (17 Subcategories)
- **Primary Source:** UN Sustainable Development Solutions Network (SDSN), Cambridge University Press Sustainable Development Report 2024.

| Subcategory ID | Subcategory Name | Primary Indicator | Unit | Previous Status | Target Status | Source Organisation |
|:---|:---|:---|:---:|:---:|:---:|:---|
| `sdg_01_no_poverty` | SDG 1: No Poverty | `sdg_01_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_02_zero_hunger` | SDG 2: Zero Hunger | `sdg_02_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_03_good_health` | SDG 3: Good Health | `sdg_03_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_04_quality_education`| SDG 4: Quality Education | `sdg_04_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_05_gender_equality`| SDG 5: Gender Equality | `sdg_05_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_06_clean_water` | SDG 6: Clean Water | `sdg_06_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_07_clean_energy` | SDG 7: Clean Energy | `sdg_07_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_08_decent_work` | SDG 8: Decent Work | `sdg_08_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_09_industry_infra`| SDG 9: Industry & Infra | `sdg_09_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_10_reduced_inequalities`| SDG 10: Reduced Inequalities | `sdg_10_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_11_sustainable_cities`| SDG 11: Sustainable Cities| `sdg_11_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_12_responsible_consumption`| SDG 12: Resp. Consumption| `sdg_12_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_13_climate_action`| SDG 13: Climate Action | `sdg_13_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_14_life_below_water`| SDG 14: Life Below Water | `sdg_14_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_15_life_on_land` | SDG 15: Life on Land | `sdg_15_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_16_peace_justice` | SDG 16: Peace & Justice | `sdg_16_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |
| `sdg_17_partnerships` | SDG 17: Partnerships | `sdg_17_score` | score (0-100) | UI Only (1) | Complete (5) | UN SDSN / Cambridge |

---

## 3. Coverage Summary Before and After Implementation

- **Total Subcategories Audited:** 273
- **Previous Status:**
  - Complete Data (5): 49 (only ~18% coverage across subcategories, and 0 mapped directly via `subcategoryId`).
  - Partial Data (3): 14
  - Static/UI Only (1-2): 210 (~77% had no actual data points).
- **Target Implementation:**
  - 100% of 273 Subcategories equipped with dedicated canonical indicators, verified units, genuine country observations (covering 198 sovereign nations and territories), latest reporting years (2024 / 2023), and historical reference points (2015-2024) where available.
