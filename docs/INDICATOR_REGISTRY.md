# World Number — Official Canonical Indicator Registry

This document records the official specification and metadata registry for all **273 canonical indicators** powering the World Number application.
Every indicator maps directly to an official subcategory under the 20 primary global statistical categories.

## Architecture & Integration Standards
- **Standardized Schema:** `CategoryIndicatorEntity(indicatorId, categoryId, subcategoryId, name, unit, sortDirection, sourceName)`
- **Country Coverage:** 198 sovereign nations and territories
- **Multi-Year Availability:** Baseline observation 2024, with 5-point historical trends (2015, 2018, 2020, 2022, 2024)
- **Authoritative Attributions:** Sourced exclusively from officially verified multilateral agencies (UN DESA, World Bank, IMF, WHO, UNESCO, ITU, WIPO, SIPRI, etc.)

---

## Complete Indicator Catalogue (273 Indicators)

| # | Category | Subcategory | Indicator Name | Indicator ID | Unit | Sort | Authoritative Source |
|:---:|:---|:---|:---|:---|:---:|:---:|:---|
| 1 | `undefined` | Total Population | **Total Population** | `pop_total` | People | DESC | UN DESA WPP 2024 |
| 2 | `undefined` | Population Density | **Population Density** | `pop_density` | people/km² | DESC | UN Statistics / FAO |
| 3 | `undefined` | Age Distribution | **Median Age** | `pop_median_age` | years | DESC | UN DESA WPP 2024 |
| 4 | `undefined` | Gender Distribution | **Sex Ratio (Male per 100 Female)** | `pop_sex_ratio` | males/100 females | DESC | UN DESA WPP 2024 |
| 5 | `undefined` | Births and Fertility | **Fertility Rate (TFR)** | `pop_fertility` | births/woman | DESC | UN DESA WPP 2024 |
| 6 | `undefined` | Deaths and Mortality | **Crude Death Rate** | `pop_crude_death_rate` | per 1,000 people | ASC | UN DESA WPP 2024 |
| 7 | `undefined` | Life Expectancy | **Life Expectancy at Birth** | `life_expectancy` | years | DESC | UN DESA / WHO |
| 8 | `undefined` | Migration | **Net Migration Rate** | `pop_net_migration` | net migrants/1k | DESC | UN DESA WPP 2024 |
| 9 | `undefined` | Urban and Rural Population | **Urban Population Share** | `urbanization_rate` | % of total | DESC | UN Habitat / UN DESA |
| 10 | `undefined` | Population Projections | **Annual Population Growth Rate** | `pop_growth_rate` | % annual | DESC | UN DESA WPP 2024 |
| 11 | `undefined` | Family and Household | **Average Household Size** | `pop_household_size` | persons/household | DESC | UN DESA / World Bank |
| 12 | `undefined` | Population Milestones | **Annual Net Population Addition** | `pop_annual_net_change` | people/year | DESC | UN DESA 2024 |
| 13 | `undefined` | GDP | **Nominal Gross Domestic Product** | `gdp_nominal` | Billion USD | DESC | World Bank / IMF WEO 2024 |
| 14 | `undefined` | GDP Per Capita | **GDP Per Capita** | `gdp_per_capita` | USD | DESC | World Bank / IMF WEO 2024 |
| 15 | `undefined` | Inflation | **Consumer Price Inflation** | `inflation_rate` | % annual | ASC | IMF WEO 2024 |
| 16 | `undefined` | Currency and Exchange Rates | **Exchange Rate to USD** | `currency_usd_rate` | local currency/USD | ASC | IMF IFS / Central Banks |
| 17 | `undefined` | Government Finance | **Government Revenue Share** | `govt_revenue_gdp` | % of GDP | DESC | IMF Fiscal Monitor 2024 |
| 18 | `undefined` | Public Debt | **General Government Gross Debt** | `public_debt_gdp` | % of GDP | ASC | IMF WEO 2024 |
| 19 | `undefined` | International Trade | **Trade Openness Ratio** | `trade_pct_gdp` | % of GDP | DESC | World Bank / WTO 2024 |
| 20 | `undefined` | Foreign Investment | **FDI Net Inflows** | `fdi_inflow_gdp` | % of GDP | DESC | UNCTAD WIR 2024 |
| 21 | `undefined` | Banking and Interest Rates | **Central Bank Policy Interest Rate** | `central_bank_rate` | % | ASC | Bank for Int. Settlements / Central Banks |
| 22 | `undefined` | Stock Markets | **Stock Market Capitalization** | `market_cap_gdp` | % of GDP | DESC | World Federation of Exchanges |
| 23 | `undefined` | Poverty and Inequality | **Income Gini Coefficient** | `gini_index` | index (0-100) | ASC | World Bank Poverty & Inequality Platform |
| 24 | `undefined` | Foreign Reserves | **Total Foreign Reserves (incl. Gold)** | `foreign_reserves_usd` | Billion USD | DESC | IMF International Financial Statistics |
| 25 | `undefined` | Air Pollution | **PM2.5 Air Pollution Exposure** | `pm25_concentration` | µg/m³ | ASC | WHO Ambient Air Quality 2024 |
| 26 | `undefined` | Water Resources | **Renewable Internal Freshwater** | `renewable_water_pc` | m³/capita | DESC | FAO AQUASTAT 2024 |
| 27 | `undefined` | Water Quality | **Safely Managed Drinking Water** | `drinking_water_access` | % population | DESC | WHO / UNICEF JMP 2024 |
| 28 | `undefined` | Forests | **Forest Area Coverage** | `forest_area_pct` | % of land | DESC | FAO Global Forest Resources (FRA 2024) |
| 29 | `undefined` | Biodiversity | **Red List Biodiversity Index** | `red_list_index` | score (0-1) | DESC | IUCN Species Survival Commission |
| 30 | `undefined` | Wildlife | **Key Biodiversity Areas Protected** | `protected_species_pct` | % of sites | DESC | UNEP-WCMC / BirdLife International |
| 31 | `undefined` | Land and Soil | **Degraded Land Share** | `soil_degradation_pct` | % of total land | ASC | UNCCD / FAO 2024 |
| 32 | `undefined` | Waste Management | **Municipal Waste Recycling Rate** | `waste_recycled_pct` | % of waste | DESC | World Bank What a Waste / UNEP |
| 33 | `undefined` | Marine Environment | **Marine Protected Areas Coverage** | `marine_protected_pct` | % of territorial waters | DESC | UNEP-WCMC World Database on Protected Areas |
| 34 | `undefined` | Natural Resources | **Natural Resource Depletion Rate** | `natural_resource_depletion` | % of GNI | ASC | World Bank WDI 2024 |
| 35 | `undefined` | Protected Areas | **Terrestrial Protected Land Area** | `protected_land_pct` | % of land area | DESC | UNEP-WCMC WDPA 2024 |
| 36 | `undefined` | Ecological Footprint | **Carbon Emissions Per Capita** | `co2_per_capita` | tonnes CO₂/person | ASC | Global Carbon Project / CDIAC 2024 |
| 37 | `undefined` | Life Expectancy | **Healthy Life Expectancy (HALE)** | `healthy_life_expectancy` | years | DESC | WHO Global Health Observatory 2024 |
| 38 | `undefined` | Infant and Child Health | **Under-5 Child Mortality Rate** | `mortality_under5` | per 1,000 live births | ASC | UN Inter-agency Group for Child Mortality Estimation (UN IGME) |
| 39 | `undefined` | Maternal Health | **Maternal Mortality Ratio** | `maternal_mortality_ratio` | per 100k live births | ASC | WHO / UNICEF / UNFPA / World Bank |
| 40 | `undefined` | Diseases | **Premature NCD Mortality Probability** | `ncd_mortality_rate` | % (ages 30-70) | ASC | WHO Global Health Observatory 2024 |
| 41 | `undefined` | Causes of Death | **Cardiovascular Death Rate** | `cvd_death_rate` | per 100,000 people | ASC | WHO GHO / IHME Global Burden of Disease |
| 42 | `undefined` | Healthcare Infrastructure | **Hospital Bed Density** | `hospital_beds_per_1k` | beds per 1,000 people | DESC | WHO GHO / OECD Health Statistics |
| 43 | `undefined` | Medical Workforce | **Physician Density** | `physicians_per_1k` | doctors per 1,000 people | DESC | WHO Global Health Workforce Statistics |
| 44 | `undefined` | Health Expenditure | **Current Health Expenditure** | `health_expenditure_gdp` | % of GDP | DESC | WHO Global Health Expenditure Database |
| 45 | `undefined` | Vaccination | **DPT3 Vaccine Coverage Rate** | `dpt3_immunization_pct` | % of 1-year-olds | DESC | WHO / UNICEF Immunization Coverage 2024 |
| 46 | `undefined` | Nutrition | **Prevalence of Undernourishment** | `undernourishment_pct` | % of population | ASC | FAO SOFI Report 2024 |
| 47 | `undefined` | Mental Health | **Age-Standardized Suicide Rate** | `suicide_rate` | per 100,000 people | ASC | WHO Global Health Observatory 2024 |
| 48 | `undefined` | Sanitation and Hygiene | **Safely Managed Sanitation Services** | `sanitation_access_pct` | % population | DESC | WHO / UNICEF JMP 2024 |
| 49 | `undefined` | Literacy | **Adult Literacy Rate** | `literacy_rate` | % (age 15+) | DESC | UNESCO Institute for Statistics (UIS 2024) |
| 50 | `undefined` | Primary Education | **Primary Education Completion Rate** | `primary_completion_rate` | % of cohort | DESC | UNESCO UIS / World Bank |
| 51 | `undefined` | Secondary Education | **Net Secondary School Enrollment** | `secondary_enrollment_net` | % of secondary age | DESC | UNESCO UIS 2024 |
| 52 | `undefined` | Higher Education | **Gross Tertiary Enrollment Ratio** | `tertiary_enrollment` | % gross | DESC | UNESCO UIS 2024 |
| 53 | `undefined` | Education Spending | **Government Education Expenditure** | `education_expenditure` | % of GDP | DESC | UNESCO UIS / World Bank 2024 |
| 54 | `undefined` | Teachers | **Primary Pupil-Teacher Ratio** | `pupil_teacher_ratio_prim` | pupils per teacher | ASC | UNESCO UIS 2024 |
| 55 | `undefined` | Gender Equality | **Secondary Gender Parity Index** | `gender_parity_index_sec` | ratio (F/M) | DESC | UNESCO UIS 2024 |
| 56 | `undefined` | School Infrastructure | **Schools with Electricity Access** | `school_electricity_pct` | % of primary schools | DESC | UNESCO UIS 2024 |
| 57 | `undefined` | Learning Outcomes | **PISA Standardized Reading Score** | `pisa_reading_score` | scale score | DESC | OECD Programme for International Student Assessment (PISA 2022/2024) |
| 58 | `undefined` | Vocational Education | **Vocational Secondary Enrollment Share** | `vocational_share_pct` | % of secondary students | DESC | UNESCO UIS 2024 |
| 59 | `undefined` | Research Education | **STEM Tertiary Graduate Share** | `graduates_science_pct` | % of graduates | DESC | UNESCO UIS / OECD Education at a Glance |
| 60 | `undefined` | Education Access | **Primary Out-of-School Children Rate** | `out_of_school_rate` | % of primary age | ASC | UNESCO UIS / UNICEF 2024 |
| 61 | `undefined` | Internet Access | **Internet Penetration Rate** | `internet_users_pct` | % of population | DESC | ITU World Telecommunication Indicators 2024 |
| 62 | `undefined` | Mobile Connectivity | **Mobile Cellular Subscriptions** | `mobile_subscriptions` | per 100 people | DESC | ITU World Telecommunication Indicators 2024 |
| 63 | `undefined` | Broadband | **Fixed Broadband Subscriptions** | `fixed_broadband_per_100` | per 100 people | DESC | ITU 2024 |
| 64 | `undefined` | 5G and Networks | **5G Population Coverage** | `cellular_5g_coverage` | % of population | DESC | GSMA Intelligence / ITU 2024 |
| 65 | `undefined` | Artificial Intelligence | **Government AI Readiness Index** | `ai_readiness_index` | score (0-100) | DESC | Oxford Insights AI Readiness Report 2024 |
| 66 | `undefined` | Cybersecurity | **Global Cybersecurity Index (GCI)** | `global_cybersecurity_idx` | score (0-100) | DESC | ITU Global Cybersecurity Index 2024 |
| 67 | `undefined` | Digital Government | **UN E-Government Development Index** | `e_government_index` | score (0-1) | DESC | United Nations E-Government Survey 2024 |
| 68 | `undefined` | Innovation | **Global Innovation Index (GII)** | `tech_innovation_index` | score (0-100) | DESC | WIPO Global Innovation Index 2024 |
| 69 | `undefined` | Patents and Intellectual Property | **Total Patent Applications** | `patent_applications` | filings/year | DESC | WIPO IP Statistics Data Center 2024 |
| 70 | `undefined` | Research and Development | **R&D Expenditure (% of GDP)** | `rnd_expenditure_gdp` | % of GDP | DESC | UNESCO Institute for Statistics / OECD 2024 |
| 71 | `undefined` | Robotics and Automation | **Industrial Robot Density** | `robot_density` | units / 10k workers | DESC | International Federation of Robotics (IFR 2024) |
| 72 | `undefined` | Technology Exports | **High-Technology Exports Share** | `high_tech_exports_pct` | % of mfg exports | DESC | World Bank / UN Comtrade 2024 |
| 73 | `undefined` | Defence Budget | **Annual Defense Budget** | `defense_budget_usd` | Billion USD | DESC | SIPRI Military Expenditure Database 2024 |
| 74 | `undefined` | Military Personnel | **Active Duty Military Personnel** | `military_personnel_active` | personnel | DESC | IISS Military Balance 2024 |
| 75 | `undefined` | Army | **Main Battle Tanks Inventory** | `battle_tanks_count` | tanks | DESC | IISS Military Balance 2024 |
| 76 | `undefined` | Air Force | **Military Combat Aircraft** | `combat_aircraft_count` | aircraft | DESC | FlightGlobal World Air Forces / IISS 2024 |
| 77 | `undefined` | Navy | **Total Naval Fleet Assets** | `naval_fleet_strength` | vessels | DESC | Global Firepower / IISS Military Balance |
| 78 | `undefined` | Nuclear Weapons | **Estimated Nuclear Warhead Stockpile** | `nuclear_warhead_estimate` | warheads | DESC | SIPRI Yearbook 2024 / FAS |
| 79 | `undefined` | Arms Exports | **Major Conventional Arms Exports** | `arms_exports_tiv` | Million SIPRI TIV | DESC | SIPRI Arms Transfers Database 2024 |
| 80 | `undefined` | Arms Imports | **Major Conventional Arms Imports** | `arms_imports_tiv` | Million SIPRI TIV | DESC | SIPRI Arms Transfers Database 2024 |
| 81 | `undefined` | Defence Industry | **Military Expenditure (% of GDP)** | `military_expenditure_gdp` | % of GDP | DESC | SIPRI Military Expenditure Database 2024 |
| 82 | `undefined` | Military Alliances | **Formal Mutual Defense Alliances** | `defense_pact_memberships` | alliances count | DESC | ATOP Alliance Treaty Obligations / NATO |
| 83 | `undefined` | Peace and Conflict | **Annual Conflict Battle Deaths** | `conflict_fatalities` | fatalities | ASC | Uppsala Conflict Data Program (UCDP 2024) |
| 84 | `undefined` | Military Rankings | **Global Military Strength Index** | `military_strength_score` | PowerIndex (lower is stronger) | ASC | Global Firepower Index 2024 |
| 85 | `undefined` | Human Development | **Human Development Index (HDI)** | `hdi_score` | score (0-1) | DESC | UNDP Human Development Report 2024 |
| 86 | `undefined` | Happiness | **World Happiness Score** | `happiness_score` | score (0-10) | DESC | World Happiness Report 2024 |
| 87 | `undefined` | Peace | **Global Peace Index (GPI)** | `global_peace_index` | score (1-5, lower is more peaceful) | ASC | Institute for Economics & Peace (IEP 2024) |
| 88 | `undefined` | Corruption | **Corruption Perceptions Index (CPI)** | `cpi_score` | score (0-100) | DESC | Transparency International 2024 |
| 89 | `undefined` | Innovation | **Global Innovation Index** | `innovation_index` | score (0-100) | DESC | WIPO / Portulans Institute 2024 |
| 90 | `undefined` | Democracy | **EIU Democracy Index** | `democracy_index` | score (0-10) | DESC | Economist Intelligence Unit (EIU 2024) |
| 91 | `undefined` | Press Freedom | **World Press Freedom Index** | `press_freedom_score` | score (0-100) | DESC | Reporters Without Borders (RSF 2024) |
| 92 | `undefined` | Gender Equality | **Global Gender Gap Index** | `gender_gap_index` | score (0-1) | DESC | World Economic Forum (WEF 2024) |
| 93 | `undefined` | Economic Freedom | **Index of Economic Freedom** | `economic_freedom_index` | score (0-100) | DESC | The Heritage Foundation 2024 |
| 94 | `undefined` | Passport Strength | **Passport Mobility Score** | `passport_rank` | visa-free destinations | DESC | Henley & Partners Passport Index 2024 |
| 95 | `undefined` | Quality of Life | **Quality of Life Index** | `quality_of_life_index` | score (0-200) | DESC | Numbeo Quality of Life Index 2024 |
| 96 | `undefined` | Rule of Law | **WJP Rule of Law Index** | `rule_of_law_index` | score (0-1) | DESC | World Justice Project (WJP 2024) |
| 97 | `undefined` | Environmental Performance | **Environmental Performance Index (EPI)** | `epi_score` | score (0-100) | DESC | Yale Center for Environmental Law & Policy 2024 |
| 98 | `undefined` | Competitiveness | **World Competitiveness Ranking** | `global_competitiveness_idx` | score (0-100) | DESC | IMD World Competitiveness Center 2024 |
| 99 | `undefined` | Countries and Territories | **Total Sovereign Land Area** | `land_area` | km² | DESC | UN Statistics Division / CIA Factbook |
| 100 | `undefined` | geo_capitals | **Capital City Population** | `capital_population` | residents | DESC | UN DESA Urban Prospects 2024 |
| 101 | `undefined` | geo_land_area | **Total Land Area (Sq Miles)** | `land_area_sqmi` | sq miles | DESC | UN Statistics Division |
| 102 | `undefined` | geo_water_area | **Inland Water Area Share** | `water_area_pct` | % surface area | DESC | FAO / CIA World Factbook |
| 103 | `undefined` | geo_coastlines | **Coastline Length** | `coastline_length` | km | DESC | World Vector Shoreline / CIA Factbook |
| 104 | `undefined` | Borders | **Total Land Boundary Length** | `land_border_length` | km | DESC | International Boundary Research Unit / CIA |
| 105 | `undefined` | Mountains | **Highest Elevation Point** | `highest_elevation_m` | meters | DESC | USGS / National Geodetic Surveys |
| 106 | `undefined` | Rivers | **Longest National River Length** | `longest_river_km` | km | DESC | HydroSHEDS / UN Environment |
| 107 | `undefined` | Lakes | **Largest Inland Lake Surface Area** | `largest_lake_area` | km² | DESC | Global Lakes and Wetlands Database (GLWD) |
| 108 | `undefined` | Islands | **Recognized Island Count** | `island_count` | islands count | DESC | National Hydrographic Services / UN Environment |
| 109 | `undefined` | Deserts | **Arid and Hyper-Arid Land Share** | `arid_land_pct` | % total land | DESC | UNCCD / FAO World Soil Resources |
| 110 | `undefined` | geo_forest_geography | **Total Forested Land Area** | `forest_area_total_km2` | km² | DESC | FAO Global Forest Resources Assessment 2024 |
| 111 | `undefined` | Oceans and Seas | **Exclusive Economic Zone (EEZ) Area** | `exclusive_economic_zone` | km² | DESC | Flanders Marine Institute / UNCLOS |
| 112 | `undefined` | geo_geographic_extremes | **Mean Terrain Elevation** | `mean_elevation_m` | meters | DESC | NOAA NCEI ETOPO Global Relief Model |
| 113 | `undefined` | tour_international_arrivals | **International Tourist Arrivals** | `tourist_arrivals` | Million tourists | DESC | UN Tourism (UNWTO World Tourism Barometer 2024) |
| 114 | `undefined` | tour_tourism_receipts | **International Tourism Receipts** | `tourism_receipts` | Billion USD | DESC | UN Tourism / World Bank 2024 |
| 115 | `undefined` | tour_outbound_tourism | **Outbound International Tourism Spending** | `outbound_tourism_spend` | Billion USD | DESC | UN Tourism (UNWTO 2024) |
| 116 | `undefined` | tour_popular_destinations | **Tourism Intensity Ratio** | `tourist_intensity` | arrivals / resident | DESC | UN Tourism / World Bank |
| 117 | `undefined` | Hotels and Accommodation | **Commercial Hotel Bed-Places** | `hotel_rooms_count` | thousand rooms | DESC | UN Tourism / STR Global |
| 118 | `undefined` | tour_airlines_airports | **Air Transport Passengers Carried** | `air_passengers_carried` | Million passengers | DESC | ICAO / World Bank 2024 |
| 119 | `undefined` | tour_heritage_sites | **UNESCO World Heritage Properties** | `unesco_world_heritage` | sites count | DESC | UNESCO World Heritage Centre 2024 |
| 120 | `undefined` | tour_nature_tourism | **Designated Biosphere & Ecotourism Reserves** | `ecotourism_sites_count` | reserves count | DESC | UNESCO MAB Programme / UNEP |
| 121 | `undefined` | tour_cultural_tourism | **Annual Museum & Heritage Attendances** | `museum_visits_annual` | Million visits | DESC | UNESCO / International Council of Museums (ICOM) |
| 122 | `undefined` | Tourism Economy | **Travel & Tourism GDP Contribution** | `tourism_gdp_share_pct` | % of GDP | DESC | World Travel & Tourism Council (WTTC 2024) |
| 123 | `undefined` | tour_travel_competitiveness | **Travel & Tourism Development Index** | `travel_tourism_dev_idx` | score (1-7) | DESC | World Economic Forum (WEF TTDI 2024) |
| 124 | `undefined` | tour_visa_travel | **Visa-Free Destinations Accessible** | `visa_free_access_destinations` | destinations | DESC | Henley & Partners / IATA 2024 |
| 125 | `undefined` | Energy Production | **Total Primary Energy Production** | `total_energy_production_twh` | TWh | DESC | IEA World Energy Outlook 2024 |
| 126 | `undefined` | Energy Consumption | **Electric Power Consumption Per Capita** | `energy_consumption_pc` | kWh / capita | DESC | IEA World Energy Balances 2024 |
| 127 | `undefined` | energy_electricity_gen | **Gross Electricity Generation** | `electricity_generation` | TWh | DESC | Ember / IEA 2024 |
| 128 | `undefined` | Renewable Energy | **Renewable Energy Share in Power** | `renewable_energy_share` | % of electricity | DESC | Ember Global Electricity Review 2024 |
| 129 | `undefined` | Solar Energy | **Solar Power Generation** | `solar_generation_twh` | TWh | DESC | Ember Global Electricity Review 2024 |
| 130 | `undefined` | Wind Energy | **Wind Energy Generation** | `wind_generation_twh` | TWh | DESC | Ember / Global Wind Energy Council 2024 |
| 131 | `undefined` | energy_hydro | **Hydroelectric Generation** | `hydro_generation_twh` | TWh | DESC | IEA / International Hydropower Association 2024 |
| 132 | `undefined` | Nuclear Energy | **Nuclear Power Generation** | `nuclear_generation_twh` | TWh | DESC | IAEA Power Reactor Information System (PRIS 2024) |
| 133 | `undefined` | Coal | **Coal Share in Electricity** | `coal_share_electricity` | % of power | ASC | Ember Global Electricity Review 2024 |
| 134 | `undefined` | Oil | **Crude Oil Production** | `oil_production_bpd` | thousand barrels/day | DESC | IEA / OPEC Monthly Oil Market 2024 |
| 135 | `undefined` | Natural Gas | **Natural Gas Production** | `gas_production_bcm` | Billion m³ / year | DESC | IEA / Cedigaz 2024 |
| 136 | `undefined` | energy_access | **Electricity Access Rate** | `electricity_access_pct` | % of population | DESC | World Bank Tracking SDG 7 2024 |
| 137 | `undefined` | energy_efficiency | **Energy Intensity of Economy** | `energy_intensity_level` | MJ / $2017 PPP GDP | ASC | IEA / World Bank 2024 |
| 138 | `undefined` | energy_grid | **Low-Carbon Clean Power Share** | `clean_power_share` | % of total power | DESC | Ember Global Electricity Review 2024 |
| 139 | `undefined` | energy_transition | **Energy Transition Index (ETI)** | `energy_transition_index` | score (0-100) | DESC | World Economic Forum (WEF ETI 2024) |
| 140 | `undefined` | Crop Production | **Crop Production Index** | `crop_production_index` | index (2014-16=100) | DESC | FAO FAOSTAT 2024 |
| 141 | `undefined` | agri_cereals | **Cereal Yield** | `cereal_yield` | kg / hectare | DESC | FAO / World Bank 2024 |
| 142 | `undefined` | Livestock | **Livestock Production Index** | `livestock_production_idx` | index (2014-16=100) | DESC | FAO FAOSTAT 2024 |
| 143 | `undefined` | Fisheries | **Total Fisheries & Aquaculture Output** | `fisheries_production_tons` | thousand tonnes | DESC | FAO SOFIA 2024 |
| 144 | `undefined` | Agricultural Land | **Agricultural Land Share** | `agricultural_land_pct` | % of land area | DESC | FAO FAOSTAT 2024 |
| 145 | `undefined` | Irrigation | **Agricultural Land Equipped for Irrigation** | `irrigated_land_pct` | % of agricultural area | DESC | FAO AQUASTAT 2024 |
| 146 | `undefined` | agri_organic | **Certified Organic Farmland Share** | `organic_share_pct` | % of agricultural land | DESC | FiBL / IFOAM Organics International 2024 |
| 147 | `undefined` | Food Security | **Undernourishment Prevalence** | `prevalence_undernourish` | % of population | ASC | FAO / WFP / IFAD SOFI 2024 |
| 148 | `undefined` | Food Prices | **Food Consumer Price Inflation** | `food_price_inflation` | % annual | ASC | FAO Food Price Index / World Bank |
| 149 | `undefined` | agri_fertilizers | **Fertilizer Consumption Rate** | `fertilizer_consumption` | kg / ha arable land | DESC | FAO FAOSTAT 2024 |
| 150 | `undefined` | agri_pesticides | **Pesticide Application Rate** | `pesticide_use_per_ha` | kg / hectare | ASC | FAO FAOSTAT 2024 |
| 151 | `undefined` | agri_machinery | **Agricultural Mechanization Density** | `tractors_per_100sqkm` | tractors / 100 km² arable | DESC | FAO FAOSTAT |
| 152 | `undefined` | agri_trade | **Agricultural Product Exports** | `agri_exports_usd` | Billion USD | DESC | WTO / FAOSTAT 2024 |
| 153 | `undefined` | agri_food_waste | **Household Food Waste Per Capita** | `food_waste_per_capita` | kg / person / year | ASC | UNEP Food Waste Index 2024 |
| 154 | `undefined` | pol_govt_systems | **Electoral Democracy Rating** | `democracy_score` | score (0-10) | DESC | EIU Democracy Index 2024 |
| 155 | `undefined` | pol_heads_state | **Political Stability & Absence of Violence** | `political_stability_idx` | score (-2.5 to 2.5) | DESC | World Bank Worldwide Governance Indicators (WGI 2024) |
| 156 | `undefined` | Parliaments | **Women in National Parliament** | `women_in_parliament` | % of seats | DESC | Inter-Parliamentary Union (IPU Parline 2024) |
| 157 | `undefined` | Elections | **Voter Turnout Rate** | `voter_turnout` | % registered voters | DESC | International IDEA / IPU |
| 158 | `undefined` | Political Parties | **Party Institutionalization Index** | `party_institutionalization` | score (0-1) | DESC | V-Dem Institute 2024 |
| 159 | `undefined` | pol_constitutions | **Current Constitution Lifespan** | `constitutional_age_years` | years in effect | DESC | Comparative Constitutions Project (CCP) |
| 160 | `undefined` | pol_democracy_indices | **Democracy Index Score** | `pol_democracy_score` | score (0-10) | DESC | Economist Intelligence Unit (EIU 2024) |
| 161 | `undefined` | Governance | **Government Effectiveness Index** | `govt_effectiveness_idx` | score (-2.5 to 2.5) | DESC | World Bank WGI 2024 |
| 162 | `undefined` | Corruption | **Corruption Perceptions Index** | `pol_corruption_index` | score (0-100) | DESC | Transparency International 2024 |
| 163 | `undefined` | pol_human_rights | **Physical Integrity Rights Score** | `human_rights_score` | score (0-1) | DESC | Human Rights Protection Scores / V-Dem |
| 164 | `undefined` | pol_civil_liberties | **Civil Liberties Index** | `civil_liberties_score` | score (0-60) | DESC | Freedom House (Freedom in the World 2024) |
| 165 | `undefined` | pol_intl_organizations | **Multilateral UN Treaties Ratified** | `un_treaties_ratified` | treaties count | DESC | United Nations Treaty Collection (UNTC 2024) |
| 166 | `undefined` | pol_diplomacy | **Global Diplomatic Network Size** | `diplomatic_missions_abroad` | missions count | DESC | Lowy Institute Global Diplomacy Index 2024 |
| 167 | `undefined` | pol_conflicts_peace | **Global Peace Index Score** | `pol_peace_index` | score (1-5) | ASC | Institute for Economics & Peace (IEP 2024) |
| 168 | `undefined` | Roads | **Road Network Density** | `road_density_km` | km / 100 km² land | DESC | International Road Federation (IRF) / World Bank |
| 169 | `undefined` | Railways | **Operating Railway Network Length** | `rail_network_km` | km | DESC | International Union of Railways (UIC 2024) |
| 170 | `undefined` | Airports | **Airports with Paved Runways** | `airports_count` | airports count | DESC | ICAO / CIA World Factbook 2024 |
| 171 | `undefined` | infra_ports | **Container Port Throughput** | `port_traffic_teu` | Million TEU | DESC | World Bank / AAPA 2024 |
| 172 | `undefined` | Bridges and Tunnels | **Longest Bridge Span** | `longest_bridge_meters` | meters | DESC | International Bridge Engineering Registry |
| 173 | `undefined` | infra_dams | **Registered Large Dams** | `large_dams_count` | dams count | DESC | International Commission on Large Dams (ICOLD) |
| 174 | `undefined` | infra_electricity_grid | **Electrification Rate** | `power_grid_reliability` | % population | DESC | World Bank SE4ALL 2024 |
| 175 | `undefined` | infra_telecom_infra | **Mobile Base Station Density** | `mobile_cell_towers` | towers / 10k people | DESC | ITU / GSMA Intelligence 2024 |
| 176 | `undefined` | Water Infrastructure | **Piped Water Infrastructure Access** | `piped_water_coverage` | % population | DESC | WHO / UNICEF JMP 2024 |
| 177 | `undefined` | Internet Infrastructure | **Fixed Broadband Infrastructure** | `fixed_broadband_infra` | subscriptions/100 people | DESC | ITU 2024 |
| 178 | `undefined` | Logistics | **Logistics Performance Index (LPI)** | `logistics_performance_idx` | score (1-5) | DESC | World Bank Logistics Performance Index 2024 |
| 179 | `undefined` | Urban Infrastructure | **Urban Agglomeration Index** | `urban_infrastructure_index` | % of total | DESC | UN-Habitat World Cities Report 2024 |
| 180 | `undefined` | Construction | **Construction Sector GDP Contribution** | `construction_gdp_share` | % of GDP | DESC | World Bank / ILO 2024 |
| 181 | `undefined` | Housing | **Housing Overcrowding Rate** | `housing_overcrowding_pct` | % households | ASC | OECD Affordable Housing Database / UN-Habitat |
| 182 | `undefined` | infra_transport_infra | **Transport Infrastructure Investment** | `transport_infrastructure_inv` | % of GDP | DESC | OECD International Transport Forum (ITF 2024) |
| 183 | `undefined` | Temperature | **Mean Annual Surface Temperature** | `avg_temperature` | °C | DESC | Berkeley Earth / NOAA 2024 |
| 184 | `undefined` | Global Warming | **Surface Temperature Anomaly** | `temperature_anomaly` | °C anomaly | ASC | Berkeley Earth / Copernicus Climate 2024 |
| 185 | `undefined` | Rainfall | **Average Annual Precipitation** | `annual_precipitation` | mm / year | DESC | World Bank Climate Knowledge Portal / GPCC |
| 186 | `undefined` | Snowfall | **Seasonal Snow Cover Extent** | `snow_cover_extent_pct` | % land area | DESC | Rutgers Global Snow Lab / NOAA |
| 187 | `undefined` | Drought | **Drought Severity Index** | `drought_severity_index` | score (0-5) | ASC | Global Drought Observatory (GDO / JRC 2024) |
| 188 | `undefined` | Floods | **Population in High Flood Risk Zones** | `flood_risk_population_pct` | % population | ASC | World Bank Global Flood Risk Database 2024 |
| 189 | `undefined` | Cyclones | **Tropical Cyclone Hazard Index** | `tropical_cyclones_frequency` | events/decade | ASC | NOAA IBTrACS / WMO 2024 |
| 190 | `undefined` | Extreme Weather | **Extreme Weather Disasters Recorded** | `extreme_weather_events` | events / year | ASC | EM-DAT International Disaster Database (CRED 2024) |
| 191 | `undefined` | Sea Level | **Relative Coastal Sea Level Rise Rate** | `sea_level_rise_mm_yr` | mm / year | ASC | NASA Sea Level Change Team / PSMSL 2024 |
| 192 | `undefined` | Glaciers | **Glacier Mass Balance Trend** | `glacier_mass_balance_mwe` | m water equiv / yr | DESC | World Glacier Monitoring Service (WGMS 2024) |
| 193 | `undefined` | Polar Ice | **Territorial Arctic/Antarctic Ice Cover** | `sea_ice_extent_sqkm` | thousand km² | DESC | National Snow & Ice Data Center (NSIDC 2024) |
| 194 | `undefined` | Greenhouse Gases | **Total Annual GHG Emissions** | `total_ghg_emissions_mt` | Million tonnes CO₂e | ASC | UNFCCC / Climate Watch 2024 |
| 195 | `undefined` | Climate Risk | **ND-GAIN Climate Vulnerability Score** | `climate_vulnerability_idx` | score (0-1, lower is better) | ASC | Notre Dame Global Adaptation Initiative (ND-GAIN 2024) |
| 196 | `undefined` | Climate Projections | **Projected 2050 Temperature Increase** | `projected_temp_rise_2050` | °C rise | ASC | IPCC Sixth Assessment Report (SSP2-4.5) / World Bank |
| 197 | `undefined` | Labour Force | **Total Labor Force** | `labor_force_total` | Million workers | DESC | ILO ILOSTAT Database 2024 |
| 198 | `undefined` | Employment Rate | **Employment-to-Population Ratio** | `employment_to_pop_ratio` | % (age 15+) | DESC | ILO ILOSTAT 2024 |
| 199 | `undefined` | Unemployment | **Total Unemployment Rate** | `unemployment_rate` | % total labor | ASC | ILO ILOSTAT 2024 |
| 200 | `undefined` | Youth Employment | **Youth Unemployment Rate** | `youth_unemployment_rate` | % (ages 15-24) | ASC | ILO ILOSTAT 2024 |
| 201 | `undefined` | Wages and Salaries | **Statutory Monthly Minimum Wage** | `monthly_minimum_wage_usd` | USD / month | DESC | ILO Global Wage Report 2024 |
| 202 | `undefined` | Working Hours | **Average Weekly Working Hours** | `weekly_hours_worked` | hours / week | ASC | ILO ILOSTAT 2024 |
| 203 | `undefined` | Labour Participation | **Labor Force Participation Rate** | `labor_participation` | % (age 15+) | DESC | ILO ILOSTAT 2024 |
| 204 | `undefined` | Gender Gap | **Labor Participation Gender Gap** | `gender_gap_participation` | % points (M-F) | ASC | ILO ILOSTAT 2024 |
| 205 | `undefined` | Employment by Sector | **Services Sector Employment Share** | `services_employment_pct` | % total employment | DESC | ILO ILOSTAT 2024 |
| 206 | `undefined` | Informal Employment | **Informal Employment Rate** | `informal_employment_pct` | % of non-agri | ASC | ILO Women and Men in the Informal Economy 2024 |
| 207 | `undefined` | Migrant Workers | **Migrant Workers in Labor Force** | `migrant_workers_share` | % of labor force | DESC | ILO Global Estimates on International Migrant Workers |
| 208 | `undefined` | Productivity | **Labor Productivity (GDP / Worker)** | `gdp_per_person_employed` | USD (constant PPP) | DESC | ILOSTAT / World Bank 2024 |
| 209 | `undefined` | Occupational Safety | **Fatal Work Injury Rate** | `fatal_occupational_injuries` | per 100k workers | ASC | ILO ILOSTAT 2024 |
| 210 | `undefined` | Social Protection | **Social Protection Effective Coverage** | `social_protection_cov` | % population | DESC | ILO World Social Protection Report 2024 |
| 211 | `undefined` | Child Labour | **Child Labor Prevalence** | `child_labor_pct` | % (ages 5-17) | ASC | ILO / UNICEF Global Estimates 2024 |
| 212 | `undefined` | Research Spending | **Gross R&D Expenditure (GERD)** | `rnd_expenditure_total_usd` | Billion USD PPP | DESC | UNESCO Institute for Statistics 2024 |
| 213 | `undefined` | Researchers | **R&D Researchers Density** | `researchers_per_million` | researchers / 1M people | DESC | UNESCO Science Report 2024 |
| 214 | `undefined` | Scientific Publications | **Scientific Journal Articles Published** | `scientific_publications` | articles / year | DESC | NSF / Scopus Elsevier 2024 |
| 215 | `undefined` | Citations | **Mean Scientific Citations Per Paper** | `citations_per_paper` | citations avg | DESC | Scimago Journal & Country Rank 2024 |
| 216 | `undefined` | Scientific Patents | **Triadic Patent Families** | `triadic_patents_count` | patent families | DESC | OECD Patent Statistics / WIPO |
| 217 | `undefined` | Space Exploration | **Civilian Space Agency Budget** | `space_budget_usd` | Million USD | DESC | Euroconsult / NASA / ESA 2024 |
| 218 | `undefined` | Satellites | **Operational Satellites in Orbit** | `operational_satellites` | satellites in orbit | DESC | Union of Concerned Scientists (UCS) Satellite Database |
| 219 | `undefined` | Astronomy | **Major Astronomical Observatories** | `major_telescopes_count` | observatories | DESC | International Astronomical Union (IAU) |
| 220 | `undefined` | Biotechnology | **Biotechnology Patents Share** | `biotech_patents_share` | % total patents | DESC | WIPO / OECD Biotechnology Statistics |
| 221 | `undefined` | Medical Research | **Registered Clinical Trials** | `clinical_trials_count` | registered trials | DESC | WHO International Clinical Trials Registry (ICTRP 2024) |
| 222 | `undefined` | Physics and Chemistry | **Physical Sciences Research Output** | `high_energy_physics_pubs` | publications / yr | DESC | Nature Index / INSPIRE-HEP 2024 |
| 223 | `undefined` | Engineering | **Engineering Graduate Share** | `engineering_graduates_pct` | % tertiary grads | DESC | UNESCO Institute for Statistics 2024 |
| 224 | `undefined` | Nobel Prizes | **Nobel Prize Laureates Total** | `nobel_laureates_total` | laureates all-time | DESC | The Nobel Foundation Official Records |
| 225 | `undefined` | Research Infrastructure | **TOP500 Supercomputers Hosted** | `supercomputers_top500` | systems on TOP500 | DESC | TOP500 Supercomputing List (June/Nov 2024) |
| 226 | `undefined` | International Collaboration | **International Co-Authorship Rate** | `intl_coauthored_papers_pct` | % total papers | DESC | Scopus / Science & Engineering Indicators 2024 |
| 227 | `undefined` | Olympic Games | **All-Time Olympic Medals Total** | `olympic_medals_total` | medals (Summer+Winter) | DESC | International Olympic Committee (IOC Official) |
| 228 | `undefined` | Paralympic Games | **All-Time Paralympic Medals Total** | `paralympic_medals_total` | medals all-time | DESC | International Paralympic Committee (IPC Official) |
| 229 | `undefined` | Football | **FIFA Men's World Ranking** | `fifa_ranking` | rank position | ASC | FIFA Official World Ranking (Oct 2024) |
| 230 | `undefined` | Cricket | **ICC Men's Cricket World Ranking** | `icc_test_ranking` | rank position | ASC | International Cricket Council (ICC 2024) |
| 231 | `undefined` | Basketball | **FIBA Men's Basketball Ranking** | `fiba_world_ranking` | rank position | ASC | FIBA Official World Ranking 2024 |
| 232 | `undefined` | Tennis | **Top 100 Professional Tennis Players** | `top100_tennis_players` | players in top 100 | DESC | ATP / WTA Official Rankings 2024 |
| 233 | `undefined` | Badminton | **Top 50 Badminton World Players** | `bwf_top50_players` | players count | DESC | Badminton World Federation (BWF 2024) |
| 234 | `undefined` | Hockey | **FIH Field Hockey World Ranking** | `fih_world_ranking` | rank position | ASC | International Hockey Federation (FIH 2024) |
| 235 | `undefined` | Athletics | **World Athletics Records Held** | `world_athletics_records` | active records | DESC | World Athletics Official Records 2024 |
| 236 | `undefined` | Swimming | **World Aquatics Championship Medals** | `fina_world_championship_medals` | medals all-time | DESC | World Aquatics (FINA 2024) |
| 237 | `undefined` | Other Sports | **Olympic Sports Diversity Index** | `sport_diversity_index` | sports with medalists | DESC | IOC / Association of Summer Olympic IFs |
| 238 | `undefined` | World Records | **Guinness World Records Recognized** | `guinness_records_held` | records count | DESC | Guinness World Records Database 2024 |
| 239 | `undefined` | Sports Participation | **Adult Physical Activity Compliance** | `adult_physical_activity_pct` | % of adults | DESC | WHO Physical Activity Guidelines 2024 |
| 240 | `undefined` | Stadiums | **Major Stadiums (>30k Capacity)** | `major_stadiums_count` | stadiums count | DESC | World Stadiums Database / FIFA Venue Registries |
| 241 | `undefined` | Historical Champions | **Senior World Cup Championship Titles** | `world_cup_titles_total` | titles (Football, Cricket, Rugby) | DESC | FIFA / ICC / World Rugby Official Records |
| 242 | `undefined` | Largest Cities | **Largest Metro Population** | `largest_metro_pop` | Million residents | DESC | UN-Habitat / Demographia World Urban Areas 2024 |
| 243 | `undefined` | City Population Growth | **Annual Urban Population Growth Rate** | `urban_pop_growth_rate` | % annual | DESC | UN DESA World Urbanization Prospects 2024 |
| 244 | `undefined` | Population Density | **Largest Urban Area Density** | `largest_city_density` | people / km² | DESC | Demographia World Urban Areas 2024 |
| 245 | `undefined` | Economic Cities | **Largest City Metropolitan GDP** | `metro_gdp_usd` | Billion USD | DESC | Brookings Global Metro Monitor / Oxford Economics 2024 |
| 246 | `undefined` | Cost of Living | **Primate City Cost of Living Index** | `cost_of_living_index` | index (NYC = 100) | DESC | Mercer Cost of Living / Numbeo 2024 |
| 247 | `undefined` | Quality of Life | **Urban Quality of Living Score** | `city_quality_of_life_idx` | score (0-200) | DESC | Mercer Quality of Living / EIU Global Liveability 2024 |
| 248 | `undefined` | Smart Cities | **IMD Smart City Index Score** | `smart_city_index` | score (0-100) | DESC | IMD Smart City Observatory / SUTD 2024 |
| 249 | `undefined` | Cleanest Cities | **Capital City PM2.5 Exposure** | `city_pm25_annual` | µg / m³ | ASC | WHO Urban Air Quality Database 2024 |
| 250 | `undefined` | Green Cities | **Urban Green Space Per Resident** | `green_space_per_capita` | m² / person | DESC | UN-Habitat / European Environment Agency |
| 251 | `undefined` | City Transport | **Public Transit Commuter Share** | `public_transit_commute_pct` | % of commutes | DESC | UITP International Public Transport / Moovit 2024 |
| 252 | `undefined` | Housing | **Urban House Price-to-Income Ratio** | `housing_price_to_income` | years of income | ASC | Demographia Housing Affordability / OECD 2024 |
| 253 | `undefined` | Safety | **Urban Safety & Security Index** | `safest_city_index` | score (0-100) | DESC | EIU Safe Cities Index / Numbeo Crime Index 2024 |
| 254 | `undefined` | Tourism | **Top City International Tourist Arrivals** | `city_international_visitors` | Million visitors / yr | DESC | Mastercard Global Destination Cities / Euromonitor 2024 |
| 255 | `undefined` | Skyscrapers | **Skyscrapers Over 150m Built** | `skyscrapers_150m_count` | buildings count | DESC | Council on Tall Buildings and Urban Habitat (CTBUH 2024) |
| 256 | `undefined` | Urbanisation | **National Urbanization Level** | `city_urban_pop_share` | % of total population | DESC | UN DESA World Urbanization Prospects 2024 |
| 257 | `undefined` | SDG 1: No Poverty | **SDG 1: No Poverty Score** | `sdg_01_score` | score (0-100) | DESC | UN SDSN / Cambridge University Press 2024 |
| 258 | `undefined` | SDG 2: Zero Hunger | **SDG 2: Zero Hunger Score** | `sdg_02_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 259 | `undefined` | SDG 3: Good Health and Well-being | **SDG 3: Good Health & Well-being** | `sdg_03_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 260 | `undefined` | SDG 4: Quality Education | **SDG 4: Quality Education Score** | `sdg_04_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 261 | `undefined` | SDG 5: Gender Equality | **SDG 5: Gender Equality Score** | `sdg_05_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 262 | `undefined` | SDG 6: Clean Water and Sanitation | **SDG 6: Clean Water & Sanitation** | `sdg_06_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 263 | `undefined` | SDG 7: Affordable and Clean Energy | **SDG 7: Affordable & Clean Energy** | `sdg_07_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 264 | `undefined` | SDG 8: Decent Work and Economic Growth | **SDG 8: Decent Work & Economic Growth** | `sdg_08_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 265 | `undefined` | SDG 9: Industry, Innovation and Infrastructure | **SDG 9: Industry, Innovation & Infra** | `sdg_09_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 266 | `undefined` | SDG 10: Reduced Inequalities | **SDG 10: Reduced Inequalities Score** | `sdg_10_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 267 | `undefined` | SDG 11: Sustainable Cities and Communities | **SDG 11: Sustainable Cities Score** | `sdg_11_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 268 | `undefined` | SDG 12: Responsible Consumption and Production | **SDG 12: Responsible Consumption** | `sdg_12_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 269 | `undefined` | SDG 13: Climate Action | **SDG 13: Climate Action Score** | `sdg_13_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 270 | `undefined` | SDG 14: Life Below Water | **SDG 14: Life Below Water Score** | `sdg_14_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 271 | `undefined` | SDG 15: Life on Land | **SDG 15: Life on Land Score** | `sdg_15_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 272 | `undefined` | SDG 16: Peace, Justice and Strong Institutions | **SDG 16: Peace, Justice & Institutions** | `sdg_16_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |
| 273 | `undefined` | SDG 17: Partnerships for the Goals | **SDG 17: Partnerships for the Goals** | `sdg_17_score` | score (0-100) | DESC | UN SDSN / Cambridge 2024 |

---

## Detailed Definitions and Methodologies

### 1. Total Population (`pop_total`)
- **Subcategory:** Total Population (`pop_total_pop`)
- **Category:** `undefined`
- **Unit:** `People` (Sort: `DESC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** De facto total population in a country, territory or jurisdiction at mid-year.
- **Measurement Methodology:** UN World Population Prospects cohort-component demographic estimation and census reconciliation.

### 2. Population Density (`pop_density`)
- **Subcategory:** Population Density (`pop_density`)
- **Category:** `undefined`
- **Unit:** `people/km²` (Sort: `DESC`)
- **Authoritative Source:** UN Statistics / FAO
- **Official Definition:** Mid-year population divided by total land area in square kilometers.
- **Measurement Methodology:** Ratio of total resident population to national sovereign land area excluding inland water bodies.

### 3. Median Age (`pop_median_age`)
- **Subcategory:** Age Distribution (`pop_age_distribution`)
- **Category:** `undefined`
- **Unit:** `years` (Sort: `DESC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** The age that divides the population into two numerically equal halves.
- **Measurement Methodology:** Calculated from interpolated single-year demographic age distributions.

### 4. Sex Ratio (Male per 100 Female) (`pop_sex_ratio`)
- **Subcategory:** Gender Distribution (`pop_gender_distribution`)
- **Category:** `undefined`
- **Unit:** `males/100 females` (Sort: `DESC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** Number of males per 100 females in the total de facto population.
- **Measurement Methodology:** National civil registration records and census sex composition tables.

### 5. Fertility Rate (TFR) (`pop_fertility`)
- **Subcategory:** Births and Fertility (`pop_births_fertility`)
- **Category:** `undefined`
- **Unit:** `births/woman` (Sort: `DESC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** Average number of live children that would be born to a woman during her reproductive lifetime.
- **Measurement Methodology:** Total Fertility Rate based on cumulative age-specific birth rates.

### 6. Crude Death Rate (`pop_crude_death_rate`)
- **Subcategory:** Deaths and Mortality (`pop_deaths_mortality`)
- **Category:** `undefined`
- **Unit:** `per 1,000 people` (Sort: `ASC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** Annual number of deaths per 1,000 mid-year population.
- **Measurement Methodology:** Vital statistics registration adjusted for demographic completeness.

### 7. Life Expectancy at Birth (`life_expectancy`)
- **Subcategory:** Life Expectancy (`pop_life_expectancy`)
- **Category:** `undefined`
- **Unit:** `years` (Sort: `DESC`)
- **Authoritative Source:** UN DESA / WHO
- **Official Definition:** Average projected number of years a newborn infant would live under prevailing mortality patterns.
- **Measurement Methodology:** Standard life table survival probabilities applied to age-specific mortality rates.

### 8. Net Migration Rate (`pop_net_migration`)
- **Subcategory:** Migration (`pop_migration`)
- **Category:** `undefined`
- **Unit:** `net migrants/1k` (Sort: `DESC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** Annual net total of international immigrants minus emigrants per 1,000 people.
- **Measurement Methodology:** Derived as demographic residual between natural increase and intercensal growth.

### 9. Urban Population Share (`urbanization_rate`)
- **Subcategory:** Urban and Rural Population (`pop_urban_rural`)
- **Category:** `undefined`
- **Unit:** `% of total` (Sort: `DESC`)
- **Authoritative Source:** UN Habitat / UN DESA
- **Official Definition:** Proportion of national population residing in areas designated as urban.
- **Measurement Methodology:** Aggregated national municipal boundaries and satellite settlement density modeling.

### 10. Annual Population Growth Rate (`pop_growth_rate`)
- **Subcategory:** Population Projections (`pop_projections`)
- **Category:** `undefined`
- **Unit:** `% annual` (Sort: `DESC`)
- **Authoritative Source:** UN DESA WPP 2024
- **Official Definition:** Exponential rate of annual population change over the reporting period.
- **Measurement Methodology:** Annualized log difference between consecutive mid-year population estimates.

### 11. Average Household Size (`pop_household_size`)
- **Subcategory:** Family and Household (`pop_family_household`)
- **Category:** `undefined`
- **Unit:** `persons/household` (Sort: `DESC`)
- **Authoritative Source:** UN DESA / World Bank
- **Official Definition:** Average number of co-resident family and domestic members sharing living quarters.
- **Measurement Methodology:** Census household enumerations and Demographic and Health Surveys (DHS).

### 12. Annual Net Population Addition (`pop_annual_net_change`)
- **Subcategory:** Population Milestones (`pop_milestones`)
- **Category:** `undefined`
- **Unit:** `people/year` (Sort: `DESC`)
- **Authoritative Source:** UN DESA 2024
- **Official Definition:** Net annual numerical increase or decrease in sovereign population count.
- **Measurement Methodology:** Absolute demographic addition: births minus deaths plus net cross-border migration.

### 13. Nominal Gross Domestic Product (`gdp_nominal`)
- **Subcategory:** GDP (`eco_gdp`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** World Bank / IMF WEO 2024
- **Official Definition:** Total market value of all final goods and services produced within a country converted at market exchange rates.
- **Measurement Methodology:** System of National Accounts (SNA 2008) converted via annual official exchange rates.

### 14. GDP Per Capita (`gdp_per_capita`)
- **Subcategory:** GDP Per Capita (`eco_gdp_per_capita`)
- **Category:** `undefined`
- **Unit:** `USD` (Sort: `DESC`)
- **Authoritative Source:** World Bank / IMF WEO 2024
- **Official Definition:** Gross domestic product divided by mid-year total population.
- **Measurement Methodology:** Nominal GDP in current US dollars divided by UN DESA population estimate.

### 15. Consumer Price Inflation (`inflation_rate`)
- **Subcategory:** Inflation (`eco_inflation`)
- **Category:** `undefined`
- **Unit:** `% annual` (Sort: `ASC`)
- **Authoritative Source:** IMF WEO 2024
- **Official Definition:** Annual percentage change in the cost to the average consumer of acquiring a basket of goods and services.
- **Measurement Methodology:** Laspeyres consumer price index (CPI) series over 12 calendar months.

### 16. Exchange Rate to USD (`currency_usd_rate`)
- **Subcategory:** Currency and Exchange Rates (`eco_currency_rates`)
- **Category:** `undefined`
- **Unit:** `local currency/USD` (Sort: `ASC`)
- **Authoritative Source:** IMF IFS / Central Banks
- **Official Definition:** National currency units per one United States Dollar.
- **Measurement Methodology:** Annual period average market exchange rate reported by national monetary authorities.

### 17. Government Revenue Share (`govt_revenue_gdp`)
- **Subcategory:** Government Finance (`eco_govt_finance`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** IMF Fiscal Monitor 2024
- **Official Definition:** Total central and general government revenues including taxes and transfers as a percentage of GDP.
- **Measurement Methodology:** Government Finance Statistics Manual (GFSM 2014) accounting framework.

### 18. General Government Gross Debt (`public_debt_gdp`)
- **Subcategory:** Public Debt (`eco_public_debt`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `ASC`)
- **Authoritative Source:** IMF WEO 2024
- **Official Definition:** Total outstanding gross liabilities of general government as a share of nominal GDP.
- **Measurement Methodology:** Includes domestic and external debt securities, loans, currency and deposits at nominal face value.

### 19. Trade Openness Ratio (`trade_pct_gdp`)
- **Subcategory:** International Trade (`eco_trade`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** World Bank / WTO 2024
- **Official Definition:** Sum of exports and imports of goods and services measured as a share of GDP.
- **Measurement Methodology:** Balance of Payments (BPM6) customs declarations and national accounts expenditure data.

### 20. FDI Net Inflows (`fdi_inflow_gdp`)
- **Subcategory:** Foreign Investment (`eco_foreign_investment`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** UNCTAD WIR 2024
- **Official Definition:** Foreign direct investment net inflows to the reporting economy as a percentage of GDP.
- **Measurement Methodology:** Direct investment equity flows, reinvested earnings, and intra-company loans exceeding 10% voting equity.

### 21. Central Bank Policy Interest Rate (`central_bank_rate`)
- **Subcategory:** Banking and Interest Rates (`eco_banking_interest`)
- **Category:** `undefined`
- **Unit:** `%` (Sort: `ASC`)
- **Authoritative Source:** Bank for Int. Settlements / Central Banks
- **Official Definition:** Benchmark short-term policy interest rate set by the sovereign central monetary authority.
- **Measurement Methodology:** Stated headline refinancing, overnight repo, or key discount facility rate.

### 22. Stock Market Capitalization (`market_cap_gdp`)
- **Subcategory:** Stock Markets (`eco_stock_markets`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** World Federation of Exchanges
- **Official Definition:** Total share price value of all domestic publicly listed companies divided by GDP.
- **Measurement Methodology:** Aggregate end-of-year market capitalization of domestic equities on national exchanges.

### 23. Income Gini Coefficient (`gini_index`)
- **Subcategory:** Poverty and Inequality (`eco_poverty_inequality`)
- **Category:** `undefined`
- **Unit:** `index (0-100)` (Sort: `ASC`)
- **Authoritative Source:** World Bank Poverty & Inequality Platform
- **Official Definition:** Measure of the deviation of the distribution of income among individuals or households from a perfectly equal distribution.
- **Measurement Methodology:** Lorenz curve integration where 0 represents absolute equality and 100 represents absolute inequality.

### 24. Total Foreign Reserves (incl. Gold) (`foreign_reserves_usd`)
- **Subcategory:** Foreign Reserves (`eco_foreign_reserves`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** IMF International Financial Statistics
- **Official Definition:** External assets readily available to and controlled by monetary authorities for direct financing of payments imbalances.
- **Measurement Methodology:** Monetary gold, special drawing rights (SDRs), reserve position in IMF, and foreign exchange currency reserves.

### 25. PM2.5 Air Pollution Exposure (`pm25_concentration`)
- **Subcategory:** Air Pollution (`env_air_pollution`)
- **Category:** `undefined`
- **Unit:** `µg/m³` (Sort: `ASC`)
- **Authoritative Source:** WHO Ambient Air Quality 2024
- **Official Definition:** Population-weighted annual mean concentration of fine particulate matter with a diameter under 2.5 micrometers.
- **Measurement Methodology:** Aerosol optical depth satellite monitoring combined with chemical transport modeling and ground stations.

### 26. Renewable Internal Freshwater (`renewable_water_pc`)
- **Subcategory:** Water Resources (`env_water_resources`)
- **Category:** `undefined`
- **Unit:** `m³/capita` (Sort: `DESC`)
- **Authoritative Source:** FAO AQUASTAT 2024
- **Official Definition:** Total internal renewable freshwater resources including river flows and groundwater from rainfall per resident.
- **Measurement Methodology:** Hydrological water balance accounting internal surface runoff and groundwater recharge.

### 27. Safely Managed Drinking Water (`drinking_water_access`)
- **Subcategory:** Water Quality (`env_water_quality`)
- **Category:** `undefined`
- **Unit:** `% population` (Sort: `DESC`)
- **Authoritative Source:** WHO / UNICEF JMP 2024
- **Official Definition:** Proportion of population using drinking water from an improved source located on premises, available when needed, and free of contamination.
- **Measurement Methodology:** Household surveys and sanitary water utility compliance monitoring.

### 28. Forest Area Coverage (`forest_area_pct`)
- **Subcategory:** Forests (`env_forests`)
- **Category:** `undefined`
- **Unit:** `% of land` (Sort: `DESC`)
- **Authoritative Source:** FAO Global Forest Resources (FRA 2024)
- **Official Definition:** Land spanning more than 0.5 hectares with trees higher than 5 meters and a canopy cover of more than 10 percent.
- **Measurement Methodology:** National forest inventories calibrated with Landsat/Sentinel satellite multispectral canopy tracking.

### 29. Red List Biodiversity Index (`red_list_index`)
- **Subcategory:** Biodiversity (`env_biodiversity`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** IUCN Species Survival Commission
- **Official Definition:** Index evaluating aggregate extinction risk trends across national mammal, bird, amphibian, and coral species.
- **Measurement Methodology:** Weighted tracking of species threat categories (Extinct to Least Concern) where 1 indicates zero extinction risk.

### 30. Key Biodiversity Areas Protected (`protected_species_pct`)
- **Subcategory:** Wildlife (`env_wildlife`)
- **Category:** `undefined`
- **Unit:** `% of sites` (Sort: `DESC`)
- **Authoritative Source:** UNEP-WCMC / BirdLife International
- **Official Definition:** Mean percentage of Key Biodiversity Areas that are covered by formal protected area designation.
- **Measurement Methodology:** Geospatial intersection of official national park polygons and confirmed global KBA coordinates.

### 31. Degraded Land Share (`soil_degradation_pct`)
- **Subcategory:** Land and Soil (`env_land_soil`)
- **Category:** `undefined`
- **Unit:** `% of total land` (Sort: `ASC`)
- **Authoritative Source:** UNCCD / FAO 2024
- **Official Definition:** Proportion of land that is degraded over total land area under SDG indicator 15.3.1.
- **Measurement Methodology:** Composite evaluation of land productivity dynamics, land cover change, and soil organic carbon stocks.

### 32. Municipal Waste Recycling Rate (`waste_recycled_pct`)
- **Subcategory:** Waste Management (`env_waste_management`)
- **Category:** `undefined`
- **Unit:** `% of waste` (Sort: `DESC`)
- **Authoritative Source:** World Bank What a Waste / UNEP
- **Official Definition:** Percentage of total generated municipal solid waste that is collected and processed through material recycling or composting.
- **Measurement Methodology:** Municipal waste stream characterization and authorized recycling facility weight manifests.

### 33. Marine Protected Areas Coverage (`marine_protected_pct`)
- **Subcategory:** Marine Environment (`env_marine_environment`)
- **Category:** `undefined`
- **Unit:** `% of territorial waters` (Sort: `DESC`)
- **Authoritative Source:** UNEP-WCMC World Database on Protected Areas
- **Official Definition:** Share of territorial seas and exclusive economic zones designated as protected marine reserves.
- **Measurement Methodology:** Maritime boundaries GIS vector analysis against gazetted marine conservation legal perimeters.

### 34. Natural Resource Depletion Rate (`natural_resource_depletion`)
- **Subcategory:** Natural Resources (`env_natural_resources`)
- **Category:** `undefined`
- **Unit:** `% of GNI` (Sort: `ASC`)
- **Authoritative Source:** World Bank WDI 2024
- **Official Definition:** Sum of net forest depletion, energy depletion (coal, oil, gas), and mineral depletion as a share of Gross National Income.
- **Measurement Methodology:** Resource rent calculation: physical extraction volumes multiplied by world market prices minus production costs.

### 35. Terrestrial Protected Land Area (`protected_land_pct`)
- **Subcategory:** Protected Areas (`env_protected_areas`)
- **Category:** `undefined`
- **Unit:** `% of land area` (Sort: `DESC`)
- **Authoritative Source:** UNEP-WCMC WDPA 2024
- **Official Definition:** Proportion of total national terrestrial land area formally protected under IUCN Categories I-VI.
- **Measurement Methodology:** Cartographic verification of gazetted national parks, wilderness sanctuaries, and nature reserves.

### 36. Carbon Emissions Per Capita (`co2_per_capita`)
- **Subcategory:** Ecological Footprint (`env_ecological_footprint`)
- **Category:** `undefined`
- **Unit:** `tonnes CO₂/person` (Sort: `ASC`)
- **Authoritative Source:** Global Carbon Project / CDIAC 2024
- **Official Definition:** Total territorial greenhouse carbon dioxide emissions from fossil fuel burning and industrial cement production divided by population.
- **Measurement Methodology:** Energy consumption fuel accounting multiplied by IPCC oxidation and emissions conversion factors.

### 37. Healthy Life Expectancy (HALE) (`healthy_life_expectancy`)
- **Subcategory:** Life Expectancy (`health_life_expectancy`)
- **Category:** `undefined`
- **Unit:** `years` (Sort: `DESC`)
- **Authoritative Source:** WHO Global Health Observatory 2024
- **Official Definition:** Average number of years that a person can expect to live in full health, taking into account years lived in less than full health due to disease or injury.
- **Measurement Methodology:** Sullivan life table method weighting age-specific mortality by Global Burden of Disease disability prevalence.

### 38. Under-5 Child Mortality Rate (`mortality_under5`)
- **Subcategory:** Infant and Child Health (`health_infant_child`)
- **Category:** `undefined`
- **Unit:** `per 1,000 live births` (Sort: `ASC`)
- **Authoritative Source:** UN Inter-agency Group for Child Mortality Estimation (UN IGME)
- **Official Definition:** Probability of a child dying between birth and exactly 5 years of age expressed per 1,000 live births.
- **Measurement Methodology:** Bayesian B-spline bias-adjusted regression model of civil registration, vital statistics and demographic surveys.

### 39. Maternal Mortality Ratio (`maternal_mortality_ratio`)
- **Subcategory:** Maternal Health (`health_maternal`)
- **Category:** `undefined`
- **Unit:** `per 100k live births` (Sort: `ASC`)
- **Authoritative Source:** WHO / UNICEF / UNFPA / World Bank
- **Official Definition:** Annual number of female deaths from any cause related to or aggravated by pregnancy or its management per 100,000 live births.
- **Measurement Methodology:** Multilevel regression model of pregnancy-related mortality adjusted for misclassification and underreporting.

### 40. Premature NCD Mortality Probability (`ncd_mortality_rate`)
- **Subcategory:** Diseases (`health_diseases`)
- **Category:** `undefined`
- **Unit:** `% (ages 30-70)` (Sort: `ASC`)
- **Authoritative Source:** WHO Global Health Observatory 2024
- **Official Definition:** Probability of dying between the exact ages of 30 and 70 from cardiovascular disease, cancer, diabetes, or chronic respiratory disease.
- **Measurement Methodology:** Standardized cause-of-death vital registration modeling adjusted for demographic age structures.

### 41. Cardiovascular Death Rate (`cvd_death_rate`)
- **Subcategory:** Causes of Death (`health_causes_death`)
- **Category:** `undefined`
- **Unit:** `per 100,000 people` (Sort: `ASC`)
- **Authoritative Source:** WHO GHO / IHME Global Burden of Disease
- **Official Definition:** Age-standardized annual mortality rate from ischemic heart disease and cerebrovascular stroke.
- **Measurement Methodology:** Direct age-standardization against the WHO World Standard Population.

### 42. Hospital Bed Density (`hospital_beds_per_1k`)
- **Subcategory:** Healthcare Infrastructure (`health_healthcare_infra`)
- **Category:** `undefined`
- **Unit:** `beds per 1,000 people` (Sort: `DESC`)
- **Authoritative Source:** WHO GHO / OECD Health Statistics
- **Official Definition:** Total inpatient hospital beds available in public, private, general, and specialized medical institutions.
- **Measurement Methodology:** Ministry of Health licensing registries and national hospital census audits.

### 43. Physician Density (`physicians_per_1k`)
- **Subcategory:** Medical Workforce (`health_medical_workforce`)
- **Category:** `undefined`
- **Unit:** `doctors per 1,000 people` (Sort: `DESC`)
- **Authoritative Source:** WHO Global Health Workforce Statistics
- **Official Definition:** Number of fully registered medical doctors actively practicing medicine in the national health system per 1,000 residents.
- **Measurement Methodology:** National professional licensing boards and national human resources for health observatories.

### 44. Current Health Expenditure (`health_expenditure_gdp`)
- **Subcategory:** Health Expenditure (`health_expenditure`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** WHO Global Health Expenditure Database
- **Official Definition:** Total level of current healthcare expenditure expressed as a percentage of gross domestic product.
- **Measurement Methodology:** System of Health Accounts (SHA 2011) covering public spending, private insurance, and household out-of-pocket payments.

### 45. DPT3 Vaccine Coverage Rate (`dpt3_immunization_pct`)
- **Subcategory:** Vaccination (`health_vaccination`)
- **Category:** `undefined`
- **Unit:** `% of 1-year-olds` (Sort: `DESC`)
- **Authoritative Source:** WHO / UNICEF Immunization Coverage 2024
- **Official Definition:** Percentage of children aged 12-23 months who have received three doses of the diphtheria, pertussis, and tetanus vaccine.
- **Measurement Methodology:** WHO/UNICEF Estimates of National Immunization Coverage (WUENIC) based on administrative provider records and surveys.

### 46. Prevalence of Undernourishment (`undernourishment_pct`)
- **Subcategory:** Nutrition (`health_nutrition`)
- **Category:** `undefined`
- **Unit:** `% of population` (Sort: `ASC`)
- **Authoritative Source:** FAO SOFI Report 2024
- **Official Definition:** Estimate of the proportion of the population whose habitual food consumption is insufficient to provide dietary energy requirements.
- **Measurement Methodology:** Parametric log-normal distribution modeling of dietary energy consumption, coefficient of variation, and minimum energy requirements.

### 47. Age-Standardized Suicide Rate (`suicide_rate`)
- **Subcategory:** Mental Health (`health_mental_health`)
- **Category:** `undefined`
- **Unit:** `per 100,000 people` (Sort: `ASC`)
- **Authoritative Source:** WHO Global Health Observatory 2024
- **Official Definition:** Annual suicide mortality rate per 100,000 population, age-standardized to the WHO World Standard Population.
- **Measurement Methodology:** Civil registration and vital statistics (CRVS) mortality data with ill-defined death redistribution.

### 48. Safely Managed Sanitation Services (`sanitation_access_pct`)
- **Subcategory:** Sanitation and Hygiene (`health_sanitation_hygiene`)
- **Category:** `undefined`
- **Unit:** `% population` (Sort: `DESC`)
- **Authoritative Source:** WHO / UNICEF JMP 2024
- **Official Definition:** Proportion of population using improved sanitation facilities that are not shared and where excreta are safely disposed of in situ or treated.
- **Measurement Methodology:** Household survey regression and wastewater utility effluent treatment compliance.

### 49. Adult Literacy Rate (`literacy_rate`)
- **Subcategory:** Literacy (`edu_literacy`)
- **Category:** `undefined`
- **Unit:** `% (age 15+)` (Sort: `DESC`)
- **Authoritative Source:** UNESCO Institute for Statistics (UIS 2024)
- **Official Definition:** Percentage of the population aged 15 years and over who can both read and write with understanding a short simple statement.
- **Measurement Methodology:** National population censuses, labor force surveys, and UNESCO Global Age-specific Literacy Projections (GALP).

### 50. Primary Education Completion Rate (`primary_completion_rate`)
- **Subcategory:** Primary Education (`edu_primary`)
- **Category:** `undefined`
- **Unit:** `% of cohort` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS / World Bank
- **Official Definition:** Gross intake ratio to the last grade of primary education expressed as a percentage of the population at the entrance age for the last grade.
- **Measurement Methodology:** Total number of new entrants in the last grade of primary divided by target population cohort.

### 51. Net Secondary School Enrollment (`secondary_enrollment_net`)
- **Subcategory:** Secondary Education (`edu_secondary`)
- **Category:** `undefined`
- **Unit:** `% of secondary age` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS 2024
- **Official Definition:** Total enrollment of the official secondary school-age population divided by total population in that age group.
- **Measurement Methodology:** Annual school census reports matched with UN DESA single-year population projections.

### 52. Gross Tertiary Enrollment Ratio (`tertiary_enrollment`)
- **Subcategory:** Higher Education (`edu_higher`)
- **Category:** `undefined`
- **Unit:** `% gross` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS 2024
- **Official Definition:** Total enrollment in tertiary education (ISCED levels 5-8) regardless of age expressed as a percentage of the 5-year age cohort following high school.
- **Measurement Methodology:** Higher education registry student counts divided by official post-secondary population cohort.

### 53. Government Education Expenditure (`education_expenditure`)
- **Subcategory:** Education Spending (`edu_spending`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS / World Bank 2024
- **Official Definition:** General government expenditure on education (current and capital) expressed as a percentage of GDP.
- **Measurement Methodology:** National budget execution reports classified by functional educational expenditures.

### 54. Primary Pupil-Teacher Ratio (`pupil_teacher_ratio_prim`)
- **Subcategory:** Teachers (`edu_teachers`)
- **Category:** `undefined`
- **Unit:** `pupils per teacher` (Sort: `ASC`)
- **Authoritative Source:** UNESCO UIS 2024
- **Official Definition:** Average number of primary school pupils per teacher in educational institutions.
- **Measurement Methodology:** Headcount of enrolled primary school pupils divided by full-time equivalent primary instructional staff.

### 55. Secondary Gender Parity Index (`gender_parity_index_sec`)
- **Subcategory:** Gender Equality (`edu_gender_equality`)
- **Category:** `undefined`
- **Unit:** `ratio (F/M)` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS 2024
- **Official Definition:** Ratio of the female gross enrollment ratio to the male gross enrollment ratio in secondary education.
- **Measurement Methodology:** Quotient of female secondary GER divided by male secondary GER where 1.0 indicates perfect gender balance.

### 56. Schools with Electricity Access (`school_electricity_pct`)
- **Subcategory:** School Infrastructure (`edu_school_infra`)
- **Category:** `undefined`
- **Unit:** `% of primary schools` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS 2024
- **Official Definition:** Percentage of primary educational facilities with regular access to an electrical power source for pedagogical use.
- **Measurement Methodology:** School census infrastructure audit verified by national educational management information systems (EMIS).

### 57. PISA Standardized Reading Score (`pisa_reading_score`)
- **Subcategory:** Learning Outcomes (`edu_learning_outcomes`)
- **Category:** `undefined`
- **Unit:** `scale score` (Sort: `DESC`)
- **Authoritative Source:** OECD Programme for International Student Assessment (PISA 2022/2024)
- **Official Definition:** Standardized reading literacy assessment score achieved by 15-year-old secondary students.
- **Measurement Methodology:** Item Response Theory (IRT) calibrated to an OECD mean score of 500 points with standard deviation of 100.

### 58. Vocational Secondary Enrollment Share (`vocational_share_pct`)
- **Subcategory:** Vocational Education (`edu_vocational`)
- **Category:** `undefined`
- **Unit:** `% of secondary students` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS 2024
- **Official Definition:** Percentage of all students enrolled in upper secondary education who are enrolled in technical or vocational tracks.
- **Measurement Methodology:** Enrolled students in technical-vocational tracks divided by total upper-secondary enrollment.

### 59. STEM Tertiary Graduate Share (`graduates_science_pct`)
- **Subcategory:** Research Education (`edu_research_edu`)
- **Category:** `undefined`
- **Unit:** `% of graduates` (Sort: `DESC`)
- **Authoritative Source:** UNESCO UIS / OECD Education at a Glance
- **Official Definition:** Percentage of all tertiary education graduates who earned degrees in Science, Technology, Engineering, or Mathematics (STEM).
- **Measurement Methodology:** ISCED Fields of Education classifications (Natural sciences, mathematics, statistics, ICT, and engineering).

### 60. Primary Out-of-School Children Rate (`out_of_school_rate`)
- **Subcategory:** Education Access (`edu_education_access`)
- **Category:** `undefined`
- **Unit:** `% of primary age` (Sort: `ASC`)
- **Authoritative Source:** UNESCO UIS / UNICEF 2024
- **Official Definition:** Proportion of children of official primary school age who are not enrolled in pre-primary, primary, or secondary school.
- **Measurement Methodology:** Difference between target population cohort and verified institutional administrative school enrollments.

### 61. Internet Penetration Rate (`internet_users_pct`)
- **Subcategory:** Internet Access (`tech_internet_access`)
- **Category:** `undefined`
- **Unit:** `% of population` (Sort: `DESC`)
- **Authoritative Source:** ITU World Telecommunication Indicators 2024
- **Official Definition:** Percentage of individuals who used the internet from any location via any device within the last 3 months.
- **Measurement Methodology:** National household surveys on ICT access and usage compiled by the International Telecommunication Union.

### 62. Mobile Cellular Subscriptions (`mobile_subscriptions`)
- **Subcategory:** Mobile Connectivity (`tech_mobile_connectivity`)
- **Category:** `undefined`
- **Unit:** `per 100 people` (Sort: `DESC`)
- **Authoritative Source:** ITU World Telecommunication Indicators 2024
- **Official Definition:** Number of active mobile cellular phone subscriptions with access to the public switched network.
- **Measurement Methodology:** Regulatory filings from telecommunication operators divided by mid-year population multiplied by 100.

### 63. Fixed Broadband Subscriptions (`fixed_broadband_per_100`)
- **Subcategory:** Broadband (`tech_broadband`)
- **Category:** `undefined`
- **Unit:** `per 100 people` (Sort: `DESC`)
- **Authoritative Source:** ITU 2024
- **Official Definition:** Subscriptions to high-speed public internet connections at downstream speeds of at least 256 kbit/s (DSL, cable, FTTH).
- **Measurement Methodology:** Telecommunications regulatory authority data collection covering commercial, residential, and corporate accounts.

### 64. 5G Population Coverage (`cellular_5g_coverage`)
- **Subcategory:** 5G and Networks (`tech_5g_networks`)
- **Category:** `undefined`
- **Unit:** `% of population` (Sort: `DESC`)
- **Authoritative Source:** GSMA Intelligence / ITU 2024
- **Official Definition:** Percentage of the sovereign population living within outdoor radio propagation coverage of a commercial 5G cellular network.
- **Measurement Methodology:** Carrier radio frequency coverage maps intersected with high-resolution satellite population density grids.

### 65. Government AI Readiness Index (`ai_readiness_index`)
- **Subcategory:** Artificial Intelligence (`tech_ai`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** Oxford Insights AI Readiness Report 2024
- **Official Definition:** Composite index evaluating national government capability to implement Artificial Intelligence across public services.
- **Measurement Methodology:** Multi-pillar assessment covering government vision, technology sector capacity, data infrastructure, and digital ethics.

### 66. Global Cybersecurity Index (GCI) (`global_cybersecurity_idx`)
- **Subcategory:** Cybersecurity (`tech_cybersecurity`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** ITU Global Cybersecurity Index 2024
- **Official Definition:** Composite index measuring country commitment to cybersecurity across legal, technical, organizational, capacity, and cooperation pillars.
- **Measurement Methodology:** 5-pillar survey verified against national CERT capabilities, cybercrime statutes, and incident response frameworks.

### 67. UN E-Government Development Index (`e_government_index`)
- **Subcategory:** Digital Government (`tech_digital_govt`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** United Nations E-Government Survey 2024
- **Official Definition:** Composite index benchmarking national readiness and capacity of public institutions to use ICT for delivering public services.
- **Measurement Methodology:** Weighted average of Online Service Index (OSI), Telecommunication Infrastructure Index (TII), and Human Capital Index (HCI).

### 68. Global Innovation Index (GII) (`tech_innovation_index`)
- **Subcategory:** Innovation (`tech_innovation`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** WIPO Global Innovation Index 2024
- **Official Definition:** World standard metric measuring national innovation performance, ecosystem inputs, and technological knowledge outputs.
- **Measurement Methodology:** 80 indicators spanning institutions, human capital, infrastructure, market sophistication, business sophistication, knowledge, and creative outputs.

### 69. Total Patent Applications (`patent_applications`)
- **Subcategory:** Patents and Intellectual Property (`tech_patents_ip`)
- **Category:** `undefined`
- **Unit:** `filings/year` (Sort: `DESC`)
- **Authoritative Source:** WIPO IP Statistics Data Center 2024
- **Official Definition:** Worldwide patent applications filed by national residents and non-residents directly or through the Patent Cooperation Treaty (PCT).
- **Measurement Methodology:** National intellectual property registry annual filing manifests audited by the World Intellectual Property Organization.

### 70. R&D Expenditure (% of GDP) (`rnd_expenditure_gdp`)
- **Subcategory:** Research and Development (`tech_rd`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** UNESCO Institute for Statistics / OECD 2024
- **Official Definition:** Gross domestic expenditure on scientific research and experimental development (GERD) expressed as a share of GDP.
- **Measurement Methodology:** Frascati Manual (OECD 2015) standardized surveys covering business enterprise, government, higher education, and private non-profit R&D.

### 71. Industrial Robot Density (`robot_density`)
- **Subcategory:** Robotics and Automation (`tech_robotics_automation`)
- **Category:** `undefined`
- **Unit:** `units / 10k workers` (Sort: `DESC`)
- **Authoritative Source:** International Federation of Robotics (IFR 2024)
- **Official Definition:** Number of operational multi-axis industrial robots per 10,000 employees in the manufacturing industry.
- **Measurement Methodology:** Annual industrial robot shipment invoices and national manufacturing employment censuses.

### 72. High-Technology Exports Share (`high_tech_exports_pct`)
- **Subcategory:** Technology Exports (`tech_exports`)
- **Category:** `undefined`
- **Unit:** `% of mfg exports` (Sort: `DESC`)
- **Authoritative Source:** World Bank / UN Comtrade 2024
- **Official Definition:** Products with high R&D intensity (aerospace, computers, pharmaceuticals, scientific instruments, electrical machinery) as a share of manufactured exports.
- **Measurement Methodology:** SITC Rev. 4 commodity classifications matched to OECD R&D intensity thresholds.

### 73. Annual Defense Budget (`defense_budget_usd`)
- **Subcategory:** Defence Budget (`mil_defence_budget`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** SIPRI Military Expenditure Database 2024
- **Official Definition:** Total government spending on military forces, defense ministries, intelligence operations, arms procurement, and military personnel.
- **Measurement Methodology:** NATO and UN standard military expenditure definitions converted to current US dollars at official market exchange rates.

### 74. Active Duty Military Personnel (`military_personnel_active`)
- **Subcategory:** Military Personnel (`mil_personnel`)
- **Category:** `undefined`
- **Unit:** `personnel` (Sort: `DESC`)
- **Authoritative Source:** IISS Military Balance 2024
- **Official Definition:** Total uniformed military personnel on active full-time service in armed forces branches.
- **Measurement Methodology:** Verified annual order-of-battle counts from defense ministries and parliamentary committee reports.

### 75. Main Battle Tanks Inventory (`battle_tanks_count`)
- **Subcategory:** Army (`mil_army`)
- **Category:** `undefined`
- **Unit:** `tanks` (Sort: `DESC`)
- **Authoritative Source:** IISS Military Balance 2024
- **Official Definition:** Number of operational and active-reserve tracked main battle tanks (MBTs) deployed in national ground army formations.
- **Measurement Methodology:** Standardized counting of armored combat vehicles mounting high-caliber direct fire main guns.

### 76. Military Combat Aircraft (`combat_aircraft_count`)
- **Subcategory:** Air Force (`mil_air_force`)
- **Category:** `undefined`
- **Unit:** `aircraft` (Sort: `DESC`)
- **Authoritative Source:** FlightGlobal World Air Forces / IISS 2024
- **Official Definition:** Total air force and naval inventory of active operational fighter, strike, and dedicated ground attack aircraft.
- **Measurement Methodology:** Annual defense fleet inventory audits excluding unarmed training and secondary liaison transports.

### 77. Total Naval Fleet Assets (`naval_fleet_strength`)
- **Subcategory:** Navy (`mil_navy`)
- **Category:** `undefined`
- **Unit:** `vessels` (Sort: `DESC`)
- **Authoritative Source:** Global Firepower / IISS Military Balance
- **Official Definition:** Aggregate count of all naval combatants including aircraft carriers, destroyers, frigates, corvettes, submarines, and patrol craft.
- **Measurement Methodology:** Commissioned surface warships and active submarines documented on official naval registers.

### 78. Estimated Nuclear Warhead Stockpile (`nuclear_warhead_estimate`)
- **Subcategory:** Nuclear Weapons (`mil_nuclear_weapons`)
- **Category:** `undefined`
- **Unit:** `warheads` (Sort: `DESC`)
- **Authoritative Source:** SIPRI Yearbook 2024 / FAS
- **Official Definition:** Total estimated sovereign inventory of deployed and stockpiled military nuclear warheads.
- **Measurement Methodology:** Federation of American Scientists (FAS) and SIPRI intelligence cross-checks of nuclear fissile materials and delivery platforms.

### 79. Major Conventional Arms Exports (`arms_exports_tiv`)
- **Subcategory:** Arms Exports (`mil_arms_exports`)
- **Category:** `undefined`
- **Unit:** `Million SIPRI TIV` (Sort: `DESC`)
- **Authoritative Source:** SIPRI Arms Transfers Database 2024
- **Official Definition:** Volume of international deliveries of major conventional weapons exported, measured in SIPRI Trend Indicator Values (TIV).
- **Measurement Methodology:** TIV system measuring the volume of military resources transferred rather than financial transaction contracts.

### 80. Major Conventional Arms Imports (`arms_imports_tiv`)
- **Subcategory:** Arms Imports (`mil_arms_imports`)
- **Category:** `undefined`
- **Unit:** `Million SIPRI TIV` (Sort: `DESC`)
- **Authoritative Source:** SIPRI Arms Transfers Database 2024
- **Official Definition:** Volume of major conventional arms and weapons platforms delivered to the importing country.
- **Measurement Methodology:** SIPRI Trend Indicator Values (TIV) calculated from observed delivery manifests and transfer agreements.

### 81. Military Expenditure (% of GDP) (`military_expenditure_gdp`)
- **Subcategory:** Defence Industry (`mil_defence_industry`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** SIPRI Military Expenditure Database 2024
- **Official Definition:** Total annual military expenditure expressed as a percentage of gross domestic product.
- **Measurement Methodology:** Military spending divided by nominal GDP under the System of National Accounts.

### 82. Formal Mutual Defense Alliances (`defense_pact_memberships`)
- **Subcategory:** Military Alliances (`mil_alliances`)
- **Category:** `undefined`
- **Unit:** `alliances count` (Sort: `DESC`)
- **Authoritative Source:** ATOP Alliance Treaty Obligations / NATO
- **Official Definition:** Number of active ratified multilateral and bilateral mutual defense assistance pacts.
- **Measurement Methodology:** Formal treaties deposited with the United Nations containing explicit mutual defense casus foederis clauses.

### 83. Annual Conflict Battle Deaths (`conflict_fatalities`)
- **Subcategory:** Peace and Conflict (`mil_peace_conflict`)
- **Category:** `undefined`
- **Unit:** `fatalities` (Sort: `ASC`)
- **Authoritative Source:** Uppsala Conflict Data Program (UCDP 2024)
- **Official Definition:** Total direct combat fatalities recorded from state-based armed conflicts, non-state conflicts, and one-sided violence.
- **Measurement Methodology:** Event-based conflict tracking cross-verified by independent humanitarian, academic, and journalistic observers.

### 84. Global Military Strength Index (`military_strength_score`)
- **Subcategory:** Military Rankings (`mil_rankings`)
- **Category:** `undefined`
- **Unit:** `PowerIndex (lower is stronger)` (Sort: `ASC`)
- **Authoritative Source:** Global Firepower Index 2024
- **Official Definition:** Comprehensive score utilizing over 60 individual military, financial, logistical, and geographical factors.
- **Measurement Methodology:** Formula weighting conventional weapons diversity, available manpower, logistical freedom, and defense budget.

### 85. Human Development Index (HDI) (`hdi_score`)
- **Subcategory:** Human Development (`idx_human_development`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** UNDP Human Development Report 2024
- **Official Definition:** Summary measure of average achievement in key dimensions of human development: a long and healthy life, being knowledgeable, and have a decent standard of living.
- **Measurement Methodology:** Geometric mean of normalized indices for life expectancy, expected/mean years of schooling, and GNI per capita (PPP).

### 86. World Happiness Score (`happiness_score`)
- **Subcategory:** Happiness (`idx_happiness`)
- **Category:** `undefined`
- **Unit:** `score (0-10)` (Sort: `DESC`)
- **Authoritative Source:** World Happiness Report 2024
- **Official Definition:** National average life evaluation score based on the Cantril Ladder survey question where 10 is the best possible life.
- **Measurement Methodology:** Nationally representative Gallup World Poll samples with 3-year rolling averages.

### 87. Global Peace Index (GPI) (`global_peace_index`)
- **Subcategory:** Peace (`idx_peace`)
- **Category:** `undefined`
- **Unit:** `score (1-5, lower is more peaceful)` (Sort: `ASC`)
- **Authoritative Source:** Institute for Economics & Peace (IEP 2024)
- **Official Definition:** The world's leading measure of global peacefulness evaluating societal safety, ongoing domestic/international conflict, and militarisation.
- **Measurement Methodology:** 23 qualitative and quantitative indicators weighted by an international panel of peace experts.

### 88. Corruption Perceptions Index (CPI) (`cpi_score`)
- **Subcategory:** Corruption (`idx_corruption`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** Transparency International 2024
- **Official Definition:** The most widely used global corruption ranking assessing perceived public sector corruption by experts and business executives.
- **Measurement Methodology:** Standardization of 13 independent data sources from 12 independent institutions onto a 0 (highly corrupt) to 100 (very clean) scale.

### 89. Global Innovation Index (`innovation_index`)
- **Subcategory:** Innovation (`idx_innovation`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** WIPO / Portulans Institute 2024
- **Official Definition:** Annual ranking of the innovation capabilities and results of world economies.
- **Measurement Methodology:** Average of Innovation Input Sub-Index (5 pillars) and Innovation Output Sub-Index (2 pillars).

### 90. EIU Democracy Index (`democracy_index`)
- **Subcategory:** Democracy (`idx_democracy`)
- **Category:** `undefined`
- **Unit:** `score (0-10)` (Sort: `DESC`)
- **Authoritative Source:** Economist Intelligence Unit (EIU 2024)
- **Official Definition:** Snapshot of the state of democracy across electoral processes, civil liberties, functioning of government, political participation, and political culture.
- **Measurement Methodology:** 60 indicators grouped across five categories classifying regimes: Full Democracy, Flawed Democracy, Hybrid Regime, Authoritarian.

### 91. World Press Freedom Index (`press_freedom_score`)
- **Subcategory:** Press Freedom (`idx_press_freedom`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** Reporters Without Borders (RSF 2024)
- **Official Definition:** Evaluation of the state of journalism and freedom of the press in 180 countries and territories.
- **Measurement Methodology:** Structural quantitative survey of abuses against journalists combined with expert qualitative questionnaire across 5 contexts: political, legal, economic, sociocultural, and security.

### 92. Global Gender Gap Index (`gender_gap_index`)
- **Subcategory:** Gender Equality (`idx_gender_equality`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** World Economic Forum (WEF 2024)
- **Official Definition:** Benchmarking index measuring gender parity across four key dimensions: Economic Participation, Educational Attainment, Health and Survival, and Political Empowerment.
- **Measurement Methodology:** Ratio-based metric where 1.0 indicates complete parity between women and men without penalizing female advantage.

### 93. Index of Economic Freedom (`economic_freedom_index`)
- **Subcategory:** Economic Freedom (`idx_economic_freedom`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** The Heritage Foundation 2024
- **Official Definition:** Annual guide measuring the principles of economic freedom: rule of law, government size, regulatory efficiency, and open markets.
- **Measurement Methodology:** 12 quantitative and qualitative factors graded on a 0 to 100 scale.

### 94. Passport Mobility Score (`passport_rank`)
- **Subcategory:** Passport Strength (`idx_passport_strength`)
- **Category:** `undefined`
- **Unit:** `visa-free destinations` (Sort: `DESC`)
- **Authoritative Source:** Henley & Partners Passport Index 2024
- **Official Definition:** Total number of global destinations their holders can access without obtaining a prior visa.
- **Measurement Methodology:** Official data from the International Air Transport Association (IATA) verified through ongoing research.

### 95. Quality of Life Index (`quality_of_life_index`)
- **Subcategory:** Quality of Life (`idx_quality_of_life`)
- **Category:** `undefined`
- **Unit:** `score (0-200)` (Sort: `DESC`)
- **Authoritative Source:** Numbeo Quality of Life Index 2024
- **Official Definition:** Empirical estimation of overall quality of life based on purchasing power, safety, healthcare, climate, cost of living, and pollution.
- **Measurement Methodology:** Formula weighting purchasing power (+), safety (+), health care (+), climate (+), traffic commute (-), pollution (-), and house price to income (-).

### 96. WJP Rule of Law Index (`rule_of_law_index`)
- **Subcategory:** Rule of Law (`idx_rule_of_law`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** World Justice Project (WJP 2024)
- **Official Definition:** Leading source for original, independent data on the rule of law across 8 primary factors: constraints on government powers, absence of corruption, open government, fundamental rights, order and security, regulatory enforcement, civil justice, and criminal justice.
- **Measurement Methodology:** Household surveys and legal expert questionnaires standardized on a 0 to 1 scale.

### 97. Environmental Performance Index (EPI) (`epi_score`)
- **Subcategory:** Environmental Performance (`idx_environmental_performance`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** Yale Center for Environmental Law & Policy 2024
- **Official Definition:** Global metric ranking countries on climate change performance, environmental health, and ecosystem vitality.
- **Measurement Methodology:** 40 performance indicators across 11 issue categories gauging national progress toward established environmental policy targets.

### 98. World Competitiveness Ranking (`global_competitiveness_idx`)
- **Subcategory:** Competitiveness (`idx_competitiveness`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** IMD World Competitiveness Center 2024
- **Official Definition:** Benchmark analyzing economies based on how they manage their competencies to achieve long-term value creation.
- **Measurement Methodology:** Assessment of 336 competitiveness criteria grouped into four factors: Economic Performance, Government Efficiency, Business Efficiency, and Infrastructure.

### 99. Total Sovereign Land Area (`land_area`)
- **Subcategory:** Countries and Territories (`geo_countries_territories`)
- **Category:** `undefined`
- **Unit:** `km²` (Sort: `DESC`)
- **Authoritative Source:** UN Statistics Division / CIA Factbook
- **Official Definition:** Total aggregate land area enclosed within internationally recognized sovereign boundaries.
- **Measurement Methodology:** Geodetic cadastral surveys excluding permanent inland lakes and major rivers.

### 100. Capital City Population (`capital_population`)
- **Subcategory:** geo_capitals (`geo_capitals`)
- **Category:** `undefined`
- **Unit:** `residents` (Sort: `DESC`)
- **Authoritative Source:** UN DESA Urban Prospects 2024
- **Official Definition:** Total resident population residing in the designated national capital city metropolitan jurisdiction.
- **Measurement Methodology:** Official municipal census counts and UN DESA metropolitan agglomeration boundaries.

### 101. Total Land Area (Sq Miles) (`land_area_sqmi`)
- **Subcategory:** geo_land_area (`geo_land_area`)
- **Category:** `undefined`
- **Unit:** `sq miles` (Sort: `DESC`)
- **Authoritative Source:** UN Statistics Division
- **Official Definition:** National sovereign land surface area expressed in square miles.
- **Measurement Methodology:** Direct geometric conversion (1 km² = 0.386102 sq miles) of verified sovereign land area.

### 102. Inland Water Area Share (`water_area_pct`)
- **Subcategory:** geo_water_area (`geo_water_area`)
- **Category:** `undefined`
- **Unit:** `% surface area` (Sort: `DESC`)
- **Authoritative Source:** FAO / CIA World Factbook
- **Official Definition:** Percentage of total sovereign territory occupied by inland water bodies (lakes, reservoirs, rivers).
- **Measurement Methodology:** Hydrographic boundary surveys divided by total surface area.

### 103. Coastline Length (`coastline_length`)
- **Subcategory:** geo_coastlines (`geo_coastlines`)
- **Category:** `undefined`
- **Unit:** `km` (Sort: `DESC`)
- **Authoritative Source:** World Vector Shoreline / CIA Factbook
- **Official Definition:** Total perimeter length of oceanic and open-sea continental and island coastlines.
- **Measurement Methodology:** High-resolution digital fractal boundary measurement at 1:250,000 scale.

### 104. Total Land Boundary Length (`land_border_length`)
- **Subcategory:** Borders (`geo_borders`)
- **Category:** `undefined`
- **Unit:** `km` (Sort: `DESC`)
- **Authoritative Source:** International Boundary Research Unit / CIA
- **Official Definition:** Total contiguous length of shared sovereign terrestrial borders with neighboring states.
- **Measurement Methodology:** Bilateral boundary demarcation treaties deposited with the United Nations.

### 105. Highest Elevation Point (`highest_elevation_m`)
- **Subcategory:** Mountains (`geo_mountains`)
- **Category:** `undefined`
- **Unit:** `meters` (Sort: `DESC`)
- **Authoritative Source:** USGS / National Geodetic Surveys
- **Official Definition:** Maximum vertical elevation above mean sea level found within national territory.
- **Measurement Methodology:** Satellite radar topography (SRTM) and high-precision trigonometric benchmarks.

### 106. Longest National River Length (`longest_river_km`)
- **Subcategory:** Rivers (`geo_rivers`)
- **Category:** `undefined`
- **Unit:** `km` (Sort: `DESC`)
- **Authoritative Source:** HydroSHEDS / UN Environment
- **Official Definition:** Total course length of the longest river traversing or originating in the country.
- **Measurement Methodology:** Digital hydrological flow-routing analysis of global river network datasets.

### 107. Largest Inland Lake Surface Area (`largest_lake_area`)
- **Subcategory:** Lakes (`geo_lakes`)
- **Category:** `undefined`
- **Unit:** `km²` (Sort: `DESC`)
- **Authoritative Source:** Global Lakes and Wetlands Database (GLWD)
- **Official Definition:** Surface area of the largest permanent natural freshwater or saline lake within national borders.
- **Measurement Methodology:** Satellite multispectral surface water extent mapping.

### 108. Recognized Island Count (`island_count`)
- **Subcategory:** Islands (`geo_islands`)
- **Category:** `undefined`
- **Unit:** `islands count` (Sort: `DESC`)
- **Authoritative Source:** National Hydrographic Services / UN Environment
- **Official Definition:** Total number of permanently exposed subaerial marine islands and islets belonging to national territory.
- **Measurement Methodology:** Hydrographic survey registries at high-water datum.

### 109. Arid and Hyper-Arid Land Share (`arid_land_pct`)
- **Subcategory:** Deserts (`geo_deserts`)
- **Category:** `undefined`
- **Unit:** `% total land` (Sort: `DESC`)
- **Authoritative Source:** UNCCD / FAO World Soil Resources
- **Official Definition:** Proportion of national territory classified as arid, semi-arid, or hyper-arid drylands.
- **Measurement Methodology:** UNEP Aridity Index ratio of mean annual precipitation to potential evapotranspiration (P/PET < 0.65).

### 110. Total Forested Land Area (`forest_area_total_km2`)
- **Subcategory:** geo_forest_geography (`geo_forest_geography`)
- **Category:** `undefined`
- **Unit:** `km²` (Sort: `DESC`)
- **Authoritative Source:** FAO Global Forest Resources Assessment 2024
- **Official Definition:** Total absolute land area covered by primary, naturally regenerating, or planted forest canopies.
- **Measurement Methodology:** FRA national reporting confirmed by Sentinel-2 remote sensing canopy classification.

### 111. Exclusive Economic Zone (EEZ) Area (`exclusive_economic_zone`)
- **Subcategory:** Oceans and Seas (`geo_oceans_seas`)
- **Category:** `undefined`
- **Unit:** `km²` (Sort: `DESC`)
- **Authoritative Source:** Flanders Marine Institute / UNCLOS
- **Official Definition:** Area of sovereign maritime waters extending up to 200 nautical miles from baseline under UNCLOS.
- **Measurement Methodology:** Standardized sovereign maritime boundary polygons calculated from territorial basepoints.

### 112. Mean Terrain Elevation (`mean_elevation_m`)
- **Subcategory:** geo_geographic_extremes (`geo_geographic_extremes`)
- **Category:** `undefined`
- **Unit:** `meters` (Sort: `DESC`)
- **Authoritative Source:** NOAA NCEI ETOPO Global Relief Model
- **Official Definition:** Average elevation of national terrestrial land surface above global mean sea level.
- **Measurement Methodology:** Area-weighted spatial average of digital surface elevation cells across sovereign polygon.

### 113. International Tourist Arrivals (`tourist_arrivals`)
- **Subcategory:** tour_international_arrivals (`tour_international_arrivals`)
- **Category:** `undefined`
- **Unit:** `Million tourists` (Sort: `DESC`)
- **Authoritative Source:** UN Tourism (UNWTO World Tourism Barometer 2024)
- **Official Definition:** Total number of overnight international non-resident visitor arrivals at national borders.
- **Measurement Methodology:** Border immigration passport control tallies and national accommodation guest registration audits.

### 114. International Tourism Receipts (`tourism_receipts`)
- **Subcategory:** tour_tourism_receipts (`tour_tourism_receipts`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** UN Tourism / World Bank 2024
- **Official Definition:** Expenditures by international inbound visitors on goods and services in the destination country, including transport.
- **Measurement Methodology:** Balance of Payments (IMF BPM6) travel credit accounts in current US dollars.

### 115. Outbound International Tourism Spending (`outbound_tourism_spend`)
- **Subcategory:** tour_outbound_tourism (`tour_outbound_tourism`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** UN Tourism (UNWTO 2024)
- **Official Definition:** Total expenditures incurred by resident travelers outside their country of origin on international trips.
- **Measurement Methodology:** Balance of Payments travel debit records collected through commercial banking transactions and surveys.

### 116. Tourism Intensity Ratio (`tourist_intensity`)
- **Subcategory:** tour_popular_destinations (`tour_popular_destinations`)
- **Category:** `undefined`
- **Unit:** `arrivals / resident` (Sort: `DESC`)
- **Authoritative Source:** UN Tourism / World Bank
- **Official Definition:** Ratio of international visitor arrivals relative to resident population.
- **Measurement Methodology:** Annual inbound overnight tourist arrivals divided by national mid-year population.

### 117. Commercial Hotel Bed-Places (`hotel_rooms_count`)
- **Subcategory:** Hotels and Accommodation (`tour_hotels_accommodation`)
- **Category:** `undefined`
- **Unit:** `thousand rooms` (Sort: `DESC`)
- **Authoritative Source:** UN Tourism / STR Global
- **Official Definition:** Total capacity of licensed tourist accommodation establishments in guest rooms.
- **Measurement Methodology:** National ministry of tourism registry audits and commercial hospitality inventory tracking.

### 118. Air Transport Passengers Carried (`air_passengers_carried`)
- **Subcategory:** tour_airlines_airports (`tour_airlines_airports`)
- **Category:** `undefined`
- **Unit:** `Million passengers` (Sort: `DESC`)
- **Authoritative Source:** ICAO / World Bank 2024
- **Official Definition:** Total commercial scheduled air passengers carried by air carriers registered in the country.
- **Measurement Methodology:** ICAO commercial airline monthly traffic reports summing domestic and international flight legs.

### 119. UNESCO World Heritage Properties (`unesco_world_heritage`)
- **Subcategory:** tour_heritage_sites (`tour_heritage_sites`)
- **Category:** `undefined`
- **Unit:** `sites count` (Sort: `DESC`)
- **Authoritative Source:** UNESCO World Heritage Centre 2024
- **Official Definition:** Number of cultural, natural, and mixed properties inscribed on the official UNESCO World Heritage List.
- **Measurement Methodology:** Official statutory committee inscriptions under the 1972 World Heritage Convention.

### 120. Designated Biosphere & Ecotourism Reserves (`ecotourism_sites_count`)
- **Subcategory:** tour_nature_tourism (`tour_nature_tourism`)
- **Category:** `undefined`
- **Unit:** `reserves count` (Sort: `DESC`)
- **Authoritative Source:** UNESCO MAB Programme / UNEP
- **Official Definition:** Number of UNESCO Man and the Biosphere reserves and national ecotourism sanctuaries.
- **Measurement Methodology:** Designated ecological conservation territories promoting sustainable tourism development.

### 121. Annual Museum & Heritage Attendances (`museum_visits_annual`)
- **Subcategory:** tour_cultural_tourism (`tour_cultural_tourism`)
- **Category:** `undefined`
- **Unit:** `Million visits` (Sort: `DESC`)
- **Authoritative Source:** UNESCO / International Council of Museums (ICOM)
- **Official Definition:** Total recorded annual attendances at public and national museums, archaeological parks, and art institutions.
- **Measurement Methodology:** Official ticketing audits compiled by national cultural ministries.

### 122. Travel & Tourism GDP Contribution (`tourism_gdp_share_pct`)
- **Subcategory:** Tourism Economy (`tour_tourism_economy`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** World Travel & Tourism Council (WTTC 2024)
- **Official Definition:** Total economic contribution of travel and tourism including direct, indirect, and induced impacts as a share of GDP.
- **Measurement Methodology:** Tourism Satellite Account (TSA) macroeconomic modeling standard.

### 123. Travel & Tourism Development Index (`travel_tourism_dev_idx`)
- **Subcategory:** tour_travel_competitiveness (`tour_travel_competitiveness`)
- **Category:** `undefined`
- **Unit:** `score (1-7)` (Sort: `DESC`)
- **Authoritative Source:** World Economic Forum (WEF TTDI 2024)
- **Official Definition:** Comprehensive benchmark evaluating factors enabling the sustainable development of the travel and tourism sector.
- **Measurement Methodology:** 112 indicators across 17 pillars covering business environment, safety, health, price competitiveness, infrastructure, and natural resources.

### 124. Visa-Free Destinations Accessible (`visa_free_access_destinations`)
- **Subcategory:** tour_visa_travel (`tour_visa_travel`)
- **Category:** `undefined`
- **Unit:** `destinations` (Sort: `DESC`)
- **Authoritative Source:** Henley & Partners / IATA 2024
- **Official Definition:** Number of global destination jurisdictions citizen passport holders can enter without obtaining a consular visa.
- **Measurement Methodology:** Global aviation database cross-verification of international immigration border requirements.

### 125. Total Primary Energy Production (`total_energy_production_twh`)
- **Subcategory:** Energy Production (`energy_production`)
- **Category:** `undefined`
- **Unit:** `TWh` (Sort: `DESC`)
- **Authoritative Source:** IEA World Energy Outlook 2024
- **Official Definition:** Gross extraction and generation of primary energy commodities within national territory in Terawatt-hours.
- **Measurement Methodology:** Physical energy accounting across solid fossil fuels, crude oil, natural gas, nuclear, and renewables.

### 126. Electric Power Consumption Per Capita (`energy_consumption_pc`)
- **Subcategory:** Energy Consumption (`energy_consumption`)
- **Category:** `undefined`
- **Unit:** `kWh / capita` (Sort: `DESC`)
- **Authoritative Source:** IEA World Energy Balances 2024
- **Official Definition:** Total electricity generated by power plants less transmission, distribution, and transformation losses, divided by population.
- **Measurement Methodology:** Net national grid consumption divided by mid-year population in kilowatt-hours.

### 127. Gross Electricity Generation (`electricity_generation`)
- **Subcategory:** energy_electricity_gen (`energy_electricity_gen`)
- **Category:** `undefined`
- **Unit:** `TWh` (Sort: `DESC`)
- **Authoritative Source:** Ember / IEA 2024
- **Official Definition:** Total electricity generated by all utility, commercial, and autoproducer power stations in Terawatt-hours.
- **Measurement Methodology:** Annual power plant generation statistics submitted to the International Energy Agency.

### 128. Renewable Energy Share in Power (`renewable_energy_share`)
- **Subcategory:** Renewable Energy (`energy_renewable`)
- **Category:** `undefined`
- **Unit:** `% of electricity` (Sort: `DESC`)
- **Authoritative Source:** Ember Global Electricity Review 2024
- **Official Definition:** Share of electricity generated from renewable sources (hydro, solar, wind, bioenergy, geothermal).
- **Measurement Methodology:** Renewable generation divided by total gross electricity generation multiplied by 100.

### 129. Solar Power Generation (`solar_generation_twh`)
- **Subcategory:** Solar Energy (`energy_solar`)
- **Category:** `undefined`
- **Unit:** `TWh` (Sort: `DESC`)
- **Authoritative Source:** Ember Global Electricity Review 2024
- **Official Definition:** Total electricity produced from utility-scale photovoltaic, rooftop solar, and concentrated solar power (CSP) facilities.
- **Measurement Methodology:** Net meter generation filings and national transmission system operator feeds.

### 130. Wind Energy Generation (`wind_generation_twh`)
- **Subcategory:** Wind Energy (`energy_wind`)
- **Category:** `undefined`
- **Unit:** `TWh` (Sort: `DESC`)
- **Authoritative Source:** Ember / Global Wind Energy Council 2024
- **Official Definition:** Total electricity generated by onshore and offshore wind turbines in Terawatt-hours.
- **Measurement Methodology:** Grid operator transmission data calibrated with installed capacity capacity-factor modeling.

### 131. Hydroelectric Generation (`hydro_generation_twh`)
- **Subcategory:** energy_hydro (`energy_hydro`)
- **Category:** `undefined`
- **Unit:** `TWh` (Sort: `DESC`)
- **Authoritative Source:** IEA / International Hydropower Association 2024
- **Official Definition:** Electricity generated from conventional hydroelectric dams, run-of-river installations, and pumped storage facilities.
- **Measurement Methodology:** Utility generation logs compiled under standard IEA energy statistics procedures.

### 132. Nuclear Power Generation (`nuclear_generation_twh`)
- **Subcategory:** Nuclear Energy (`energy_nuclear`)
- **Category:** `undefined`
- **Unit:** `TWh` (Sort: `DESC`)
- **Authoritative Source:** IAEA Power Reactor Information System (PRIS 2024)
- **Official Definition:** Total net electrical energy generated by commercial nuclear power reactor units.
- **Measurement Methodology:** IAEA official logged net electrical output reports from licensed operating civilian reactors.

### 133. Coal Share in Electricity (`coal_share_electricity`)
- **Subcategory:** Coal (`energy_coal`)
- **Category:** `undefined`
- **Unit:** `% of power` (Sort: `ASC`)
- **Authoritative Source:** Ember Global Electricity Review 2024
- **Official Definition:** Percentage of total domestic electricity generation produced from anthracite, bituminous, sub-bituminous, and lignite coal.
- **Measurement Methodology:** Thermal coal generation divided by gross national power generation.

### 134. Crude Oil Production (`oil_production_bpd`)
- **Subcategory:** Oil (`energy_oil`)
- **Category:** `undefined`
- **Unit:** `thousand barrels/day` (Sort: `DESC`)
- **Authoritative Source:** IEA / OPEC Monthly Oil Market 2024
- **Official Definition:** Average daily extraction of crude oil, lease condensate, and natural gas plant liquids.
- **Measurement Methodology:** Wellhead meter production reports verified by petroleum ministry customs export audits.

### 135. Natural Gas Production (`gas_production_bcm`)
- **Subcategory:** Natural Gas (`energy_natural_gas`)
- **Category:** `undefined`
- **Unit:** `Billion m³ / year` (Sort: `DESC`)
- **Authoritative Source:** IEA / Cedigaz 2024
- **Official Definition:** Gross volume of dry marketable natural gas produced from onshore and offshore reservoirs excluding flared gas.
- **Measurement Methodology:** Standard volumetric measurement at standard temperature (15°C) and pressure (101.325 kPa).

### 136. Electricity Access Rate (`electricity_access_pct`)
- **Subcategory:** energy_access (`energy_access`)
- **Category:** `undefined`
- **Unit:** `% of population` (Sort: `DESC`)
- **Authoritative Source:** World Bank Tracking SDG 7 2024
- **Official Definition:** Percentage of people with access to electricity from utility grids or quality decentralized solar systems.
- **Measurement Methodology:** Multilevel logistic regression combining national electrification household surveys and grid connection databases.

### 137. Energy Intensity of Economy (`energy_intensity_level`)
- **Subcategory:** energy_efficiency (`energy_efficiency`)
- **Category:** `undefined`
- **Unit:** `MJ / $2017 PPP GDP` (Sort: `ASC`)
- **Authoritative Source:** IEA / World Bank 2024
- **Official Definition:** Ratio of total primary energy supply (in megajoules) to gross domestic product in constant 2017 PPP dollars.
- **Measurement Methodology:** Energy consumed divided by economic output: lower values signify greater macroeconomic energy efficiency.

### 138. Low-Carbon Clean Power Share (`clean_power_share`)
- **Subcategory:** energy_grid (`energy_grid`)
- **Category:** `undefined`
- **Unit:** `% of total power` (Sort: `DESC`)
- **Authoritative Source:** Ember Global Electricity Review 2024
- **Official Definition:** Total percentage of domestic electricity produced from low-carbon sources (renewables plus civilian nuclear power).
- **Measurement Methodology:** Sum of hydro, solar, wind, nuclear, bioenergy, and geothermal generation divided by total generation.

### 139. Energy Transition Index (ETI) (`energy_transition_index`)
- **Subcategory:** energy_transition (`energy_transition`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** World Economic Forum (WEF ETI 2024)
- **Official Definition:** Composite index evaluating energy system performance across environmental sustainability, energy security, and transition readiness.
- **Measurement Methodology:** 46 indicators evaluating current system performance and the enabling environment for clean energy transformation.

### 140. Crop Production Index (`crop_production_index`)
- **Subcategory:** Crop Production (`agri_crop_production`)
- **Category:** `undefined`
- **Unit:** `index (2014-16=100)` (Sort: `DESC`)
- **Authoritative Source:** FAO FAOSTAT 2024
- **Official Definition:** Relative agricultural crop output index based on constant international commodity prices.
- **Measurement Methodology:** Laspeyres index weighting national physical crop tonnages by international producer prices.

### 141. Cereal Yield (`cereal_yield`)
- **Subcategory:** agri_cereals (`agri_cereals`)
- **Category:** `undefined`
- **Unit:** `kg / hectare` (Sort: `DESC`)
- **Authoritative Source:** FAO / World Bank 2024
- **Official Definition:** Harvested production of dry grain cereals (wheat, rice, maize, barley) per unit of harvested land area.
- **Measurement Methodology:** Reported national grain harvest weights divided by total harvested crop area in hectares.

### 142. Livestock Production Index (`livestock_production_idx`)
- **Subcategory:** Livestock (`agri_livestock`)
- **Category:** `undefined`
- **Unit:** `index (2014-16=100)` (Sort: `DESC`)
- **Authoritative Source:** FAO FAOSTAT 2024
- **Official Definition:** Relative volume of livestock products including meat, milk, eggs, and wool.
- **Measurement Methodology:** Physical production quantities weighted by international average livestock commodity farm-gate prices.

### 143. Total Fisheries & Aquaculture Output (`fisheries_production_tons`)
- **Subcategory:** Fisheries (`agri_fisheries`)
- **Category:** `undefined`
- **Unit:** `thousand tonnes` (Sort: `DESC`)
- **Authoritative Source:** FAO SOFIA 2024
- **Official Definition:** Total annual live-weight volume of marine and inland capture fisheries plus commercial aquaculture production.
- **Measurement Methodology:** National port landing declarations and commercial fish farm harvest logs.

### 144. Agricultural Land Share (`agricultural_land_pct`)
- **Subcategory:** Agricultural Land (`agri_agricultural_land`)
- **Category:** `undefined`
- **Unit:** `% of land area` (Sort: `DESC`)
- **Authoritative Source:** FAO FAOSTAT 2024
- **Official Definition:** Share of national land area that is arable, under permanent crops, or under permanent pastures.
- **Measurement Methodology:** Land use census surveys compiled under the World Programme for the Census of Agriculture.

### 145. Agricultural Land Equipped for Irrigation (`irrigated_land_pct`)
- **Subcategory:** Irrigation (`agri_irrigation`)
- **Category:** `undefined`
- **Unit:** `% of agricultural area` (Sort: `DESC`)
- **Authoritative Source:** FAO AQUASTAT 2024
- **Official Definition:** Area equipped with infrastructure to provide water to crops through surface, sprinkler, or localized drip irrigation.
- **Measurement Methodology:** Agricultural engineering census of operating pump, canal, and sprinkler networks.

### 146. Certified Organic Farmland Share (`organic_share_pct`)
- **Subcategory:** agri_organic (`agri_organic`)
- **Category:** `undefined`
- **Unit:** `% of agricultural land` (Sort: `DESC`)
- **Authoritative Source:** FiBL / IFOAM Organics International 2024
- **Official Definition:** Percentage of agricultural land managed under certified organic farming principles without synthetic agrochemicals.
- **Measurement Methodology:** Accredited certification body registries (IFOAM, USDA Organic, EU Organic).

### 147. Undernourishment Prevalence (`prevalence_undernourish`)
- **Subcategory:** Food Security (`agri_food_security`)
- **Category:** `undefined`
- **Unit:** `% of population` (Sort: `ASC`)
- **Authoritative Source:** FAO / WFP / IFAD SOFI 2024
- **Official Definition:** Percentage of national population facing chronic food deprivation and unable to meet minimum dietary energy requirements.
- **Measurement Methodology:** Probability of inadequate dietary intake estimated from national food balance sheets and consumption surveys.

### 148. Food Consumer Price Inflation (`food_price_inflation`)
- **Subcategory:** Food Prices (`agri_food_prices`)
- **Category:** `undefined`
- **Unit:** `% annual` (Sort: `ASC`)
- **Authoritative Source:** FAO Food Price Index / World Bank
- **Official Definition:** Annual percentage change in the consumer price index sub-basket specifically for food and non-alcoholic beverages.
- **Measurement Methodology:** Consumer retail food price sampling across urban and rural markets over 12 months.

### 149. Fertilizer Consumption Rate (`fertilizer_consumption`)
- **Subcategory:** agri_fertilizers (`agri_fertilizers`)
- **Category:** `undefined`
- **Unit:** `kg / ha arable land` (Sort: `DESC`)
- **Authoritative Source:** FAO FAOSTAT 2024
- **Official Definition:** Quantity of plant nutrients used per unit of arable land: nitrogen (N), phosphate (P2O5), and potash (K2O).
- **Measurement Methodology:** Domestic fertilizer production plus imports minus exports divided by arable land area.

### 150. Pesticide Application Rate (`pesticide_use_per_ha`)
- **Subcategory:** agri_pesticides (`agri_pesticides`)
- **Category:** `undefined`
- **Unit:** `kg / hectare` (Sort: `ASC`)
- **Authoritative Source:** FAO FAOSTAT 2024
- **Official Definition:** Total active ingredients of chemical plant protection products (insecticides, herbicides, fungicides) applied per hectare of cropland.
- **Measurement Methodology:** Commercial agricultural pesticide sales and import registries divided by cropland area.

### 151. Agricultural Mechanization Density (`tractors_per_100sqkm`)
- **Subcategory:** agri_machinery (`agri_machinery`)
- **Category:** `undefined`
- **Unit:** `tractors / 100 km² arable` (Sort: `DESC`)
- **Authoritative Source:** FAO FAOSTAT
- **Official Definition:** Number of agricultural wheel and crawler tractors utilized in farming per 100 square kilometers of arable land.
- **Measurement Methodology:** Agricultural machinery census audits and commercial equipment registration logs.

### 152. Agricultural Product Exports (`agri_exports_usd`)
- **Subcategory:** agri_trade (`agri_trade`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** WTO / FAOSTAT 2024
- **Official Definition:** Total value of exports of agricultural commodities and processed foodstuffs.
- **Measurement Methodology:** Standard International Trade Classification (SITC Section 0, 1, 22, 4) customs values in USD.

### 153. Household Food Waste Per Capita (`food_waste_per_capita`)
- **Subcategory:** agri_food_waste (`agri_food_waste`)
- **Category:** `undefined`
- **Unit:** `kg / person / year` (Sort: `ASC`)
- **Authoritative Source:** UNEP Food Waste Index 2024
- **Official Definition:** Average quantity of edible and associated inedible parts of food discarded at the household consumer level.
- **Measurement Methodology:** Direct waste compositional compositional audits and household diary tracking surveys.

### 154. Electoral Democracy Rating (`democracy_score`)
- **Subcategory:** pol_govt_systems (`pol_govt_systems`)
- **Category:** `undefined`
- **Unit:** `score (0-10)` (Sort: `DESC`)
- **Authoritative Source:** EIU Democracy Index 2024
- **Official Definition:** Metric gauging the institutional durability of the sovereign governance system and regular free, fair elections.
- **Measurement Methodology:** Multi-indicator assessment of electoral pluralism, checks and balances, and universal franchise.

### 155. Political Stability & Absence of Violence (`political_stability_idx`)
- **Subcategory:** pol_heads_state (`pol_heads_state`)
- **Category:** `undefined`
- **Unit:** `score (-2.5 to 2.5)` (Sort: `DESC`)
- **Authoritative Source:** World Bank Worldwide Governance Indicators (WGI 2024)
- **Official Definition:** Perceptions of the likelihood that the government will be destabilized or overthrown by unconstitutional or violent means.
- **Measurement Methodology:** Unobserved Components Model (UCM) aggregating cross-country surveys from expert rating agencies.

### 156. Women in National Parliament (`women_in_parliament`)
- **Subcategory:** Parliaments (`pol_parliaments`)
- **Category:** `undefined`
- **Unit:** `% of seats` (Sort: `DESC`)
- **Authoritative Source:** Inter-Parliamentary Union (IPU Parline 2024)
- **Official Definition:** Percentage of parliamentary seats in lower and single legislative chambers held by women.
- **Measurement Methodology:** Official parliamentary election gazettes compiled monthly by the Inter-Parliamentary Union.

### 157. Voter Turnout Rate (`voter_turnout`)
- **Subcategory:** Elections (`pol_elections`)
- **Category:** `undefined`
- **Unit:** `% registered voters` (Sort: `DESC`)
- **Authoritative Source:** International IDEA / IPU
- **Official Definition:** Total number of valid and invalid votes cast divided by the total number of registered voters in the latest national election.
- **Measurement Methodology:** Official election commission certified vote tallies.

### 158. Party Institutionalization Index (`party_institutionalization`)
- **Subcategory:** Political Parties (`pol_political_parties`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** V-Dem Institute 2024
- **Official Definition:** Level of organizational institutionalization, cohesion, and programmatic coherence of national political parties.
- **Measurement Methodology:** Varieties of Democracy (V-Dem) expert coding and Bayesian measurement modeling.

### 159. Current Constitution Lifespan (`constitutional_age_years`)
- **Subcategory:** pol_constitutions (`pol_constitutions`)
- **Category:** `undefined`
- **Unit:** `years in effect` (Sort: `DESC`)
- **Authoritative Source:** Comparative Constitutions Project (CCP)
- **Official Definition:** Number of continuous years the current national written constitution has remained legally in force.
- **Measurement Methodology:** Constitutional text analysis tracking formal promulgation dates and structural overhauls.

### 160. Democracy Index Score (`pol_democracy_score`)
- **Subcategory:** pol_democracy_indices (`pol_democracy_indices`)
- **Category:** `undefined`
- **Unit:** `score (0-10)` (Sort: `DESC`)
- **Authoritative Source:** Economist Intelligence Unit (EIU 2024)
- **Official Definition:** Overall democracy classification benchmarking pluralism, civil liberties, and government functioning.
- **Measurement Methodology:** 60 indicators assessing 5 categories with final regime classification.

### 161. Government Effectiveness Index (`govt_effectiveness_idx`)
- **Subcategory:** Governance (`pol_governance`)
- **Category:** `undefined`
- **Unit:** `score (-2.5 to 2.5)` (Sort: `DESC`)
- **Authoritative Source:** World Bank WGI 2024
- **Official Definition:** Perceptions of the quality of public services, the quality of civil service and its independence from political pressures.
- **Measurement Methodology:** Constructed from 31 individual data sources measuring public sector management capacity.

### 162. Corruption Perceptions Index (`pol_corruption_index`)
- **Subcategory:** Corruption (`pol_corruption`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** Transparency International 2024
- **Official Definition:** Perceived degree of public sector corruption as evaluated by experts and business leaders.
- **Measurement Methodology:** Statistical standardization of composite corruption assessments onto a 0-100 scale.

### 163. Physical Integrity Rights Score (`human_rights_score`)
- **Subcategory:** pol_human_rights (`pol_human_rights`)
- **Category:** `undefined`
- **Unit:** `score (0-1)` (Sort: `DESC`)
- **Authoritative Source:** Human Rights Protection Scores / V-Dem
- **Official Definition:** Degree to which individuals are free from government torture, extrajudicial execution, political imprisonment, and disappearance.
- **Measurement Methodology:** Bayesian latent trait model of human rights reports from the UN, Amnesty International, and US State Department.

### 164. Civil Liberties Index (`civil_liberties_score`)
- **Subcategory:** pol_civil_liberties (`pol_civil_liberties`)
- **Category:** `undefined`
- **Unit:** `score (0-60)` (Sort: `DESC`)
- **Authoritative Source:** Freedom House (Freedom in the World 2024)
- **Official Definition:** Assessment of freedom of expression and belief, associational and organizational rights, rule of law, and personal autonomy.
- **Measurement Methodology:** Expert ratings on a 15-question civil liberties checklist scored 0 to 4 points each.

### 165. Multilateral UN Treaties Ratified (`un_treaties_ratified`)
- **Subcategory:** pol_intl_organizations (`pol_intl_organizations`)
- **Category:** `undefined`
- **Unit:** `treaties count` (Sort: `DESC`)
- **Authoritative Source:** United Nations Treaty Collection (UNTC 2024)
- **Official Definition:** Total number of core multilateral treaties, conventions, and optional protocols deposited with the UN Secretary-General ratified.
- **Measurement Methodology:** Official UNTC legal registry of instruments of ratification, accession, and succession.

### 166. Global Diplomatic Network Size (`diplomatic_missions_abroad`)
- **Subcategory:** pol_diplomacy (`pol_diplomacy`)
- **Category:** `undefined`
- **Unit:** `missions count` (Sort: `DESC`)
- **Authoritative Source:** Lowy Institute Global Diplomacy Index 2024
- **Official Definition:** Total count of embassies, high commissions, permanent missions, consulates-general, and consulates maintained abroad.
- **Measurement Methodology:** Foreign ministry official directory verification of accredited overseas diplomatic missions.

### 167. Global Peace Index Score (`pol_peace_index`)
- **Subcategory:** pol_conflicts_peace (`pol_conflicts_peace`)
- **Category:** `undefined`
- **Unit:** `score (1-5)` (Sort: `ASC`)
- **Authoritative Source:** Institute for Economics & Peace (IEP 2024)
- **Official Definition:** Relative peacefulness score evaluating internal peace, external peace, and national security.
- **Measurement Methodology:** Composite index combining 23 indicators of internal security and international militarisation.

### 168. Road Network Density (`road_density_km`)
- **Subcategory:** Roads (`infra_roads`)
- **Category:** `undefined`
- **Unit:** `km / 100 km² land` (Sort: `DESC`)
- **Authoritative Source:** International Road Federation (IRF) / World Bank
- **Official Definition:** Total length of paved and unpaved motorable road networks per 100 square kilometers of sovereign land area.
- **Measurement Methodology:** National ministry of transport road asset registries divided by territorial land area.

### 169. Operating Railway Network Length (`rail_network_km`)
- **Subcategory:** Railways (`infra_railways`)
- **Category:** `undefined`
- **Unit:** `km` (Sort: `DESC`)
- **Authoritative Source:** International Union of Railways (UIC 2024)
- **Official Definition:** Total length of operating railway lines open for public freight and passenger transport.
- **Measurement Methodology:** UIC route kilometer audits excluding urban light rail and metro transit lines.

### 170. Airports with Paved Runways (`airports_count`)
- **Subcategory:** Airports (`infra_airports`)
- **Category:** `undefined`
- **Unit:** `airports count` (Sort: `DESC`)
- **Authoritative Source:** ICAO / CIA World Factbook 2024
- **Official Definition:** Total number of civil, commercial, and military airports equipped with permanent concrete or asphalt paved runways.
- **Measurement Methodology:** Aeronautical Information Publications (AIP) and international civil aviation registries.

### 171. Container Port Throughput (`port_traffic_teu`)
- **Subcategory:** infra_ports (`infra_ports`)
- **Category:** `undefined`
- **Unit:** `Million TEU` (Sort: `DESC`)
- **Authoritative Source:** World Bank / AAPA 2024
- **Official Definition:** Total maritime container traffic handled at national seaports expressed in Twenty-foot Equivalent Units (TEU).
- **Measurement Methodology:** Port authority manifests counting standard full and empty ISO intermodal freight containers.

### 172. Longest Bridge Span (`longest_bridge_meters`)
- **Subcategory:** Bridges and Tunnels (`infra_bridges_tunnels`)
- **Category:** `undefined`
- **Unit:** `meters` (Sort: `DESC`)
- **Authoritative Source:** International Bridge Engineering Registry
- **Official Definition:** Length of the longest structural bridge span or continuous viaduct in the national highway/railway system.
- **Measurement Methodology:** Structural engineering blueprints and national highway administration records.

### 173. Registered Large Dams (`large_dams_count`)
- **Subcategory:** infra_dams (`infra_dams`)
- **Category:** `undefined`
- **Unit:** `dams count` (Sort: `DESC`)
- **Authoritative Source:** International Commission on Large Dams (ICOLD)
- **Official Definition:** Total number of major dams with a height of 15 meters or greater from foundation to crest.
- **Measurement Methodology:** ICOLD World Register of Dams statutory water resource audits.

### 174. Electrification Rate (`power_grid_reliability`)
- **Subcategory:** infra_electricity_grid (`infra_electricity_grid`)
- **Category:** `undefined`
- **Unit:** `% population` (Sort: `DESC`)
- **Authoritative Source:** World Bank SE4ALL 2024
- **Official Definition:** Percentage of the national resident population with an active connection to an electrical power network.
- **Measurement Methodology:** Multilevel survey modeling and utility customer meter database verification.

### 175. Mobile Base Station Density (`mobile_cell_towers`)
- **Subcategory:** infra_telecom_infra (`infra_telecom_infra`)
- **Category:** `undefined`
- **Unit:** `towers / 10k people` (Sort: `DESC`)
- **Authoritative Source:** ITU / GSMA Intelligence 2024
- **Official Definition:** Number of commercial cellular transceiver base stations and small cells per 10,000 residents.
- **Measurement Methodology:** Regulatory filings from mobile network operators (MNOs) with spectrum licenses.

### 176. Piped Water Infrastructure Access (`piped_water_coverage`)
- **Subcategory:** Water Infrastructure (`infra_water_infra`)
- **Category:** `undefined`
- **Unit:** `% population` (Sort: `DESC`)
- **Authoritative Source:** WHO / UNICEF JMP 2024
- **Official Definition:** Percentage of the population with direct piped drinking water access inside dwelling, plot or yard.
- **Measurement Methodology:** Water utility household connection databases combined with national population censuses.

### 177. Fixed Broadband Infrastructure (`fixed_broadband_infra`)
- **Subcategory:** Internet Infrastructure (`infra_internet_infra`)
- **Category:** `undefined`
- **Unit:** `subscriptions/100 people` (Sort: `DESC`)
- **Authoritative Source:** ITU 2024
- **Official Definition:** Active physical fixed-line broadband internet connections (cable, optical fiber, DSL) per 100 people.
- **Measurement Methodology:** Operator subscriber reports certified by national telecommunication regulators.

### 178. Logistics Performance Index (LPI) (`logistics_performance_idx`)
- **Subcategory:** Logistics (`infra_logistics`)
- **Category:** `undefined`
- **Unit:** `score (1-5)` (Sort: `DESC`)
- **Authoritative Source:** World Bank Logistics Performance Index 2024
- **Official Definition:** Overall score assessing national trade logistics efficiency across customs, infrastructure, international shipments, competence, tracking, and timeliness.
- **Measurement Methodology:** Global survey of international freight forwarders and logistics professionals.

### 179. Urban Agglomeration Index (`urban_infrastructure_index`)
- **Subcategory:** Urban Infrastructure (`infra_urban_infra`)
- **Category:** `undefined`
- **Unit:** `% of total` (Sort: `DESC`)
- **Authoritative Source:** UN-Habitat World Cities Report 2024
- **Official Definition:** Level of physical urban built environment development and resident concentration in urban centers.
- **Measurement Methodology:** Degree of Urbanization (DEGURBA) methodology based on high-density 1 km² grid cells.

### 180. Construction Sector GDP Contribution (`construction_gdp_share`)
- **Subcategory:** Construction (`infra_construction`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** World Bank / ILO 2024
- **Official Definition:** Gross value added by the civil construction and building engineering sector as a percentage of GDP.
- **Measurement Methodology:** SNA 2008 national accounts industrial classification (ISIC Rev. 4 Section F).

### 181. Housing Overcrowding Rate (`housing_overcrowding_pct`)
- **Subcategory:** Housing (`infra_housing`)
- **Category:** `undefined`
- **Unit:** `% households` (Sort: `ASC`)
- **Authoritative Source:** OECD Affordable Housing Database / UN-Habitat
- **Official Definition:** Percentage of households living in overcrowded dwellings that do not have a minimum number of rooms relative to household size.
- **Measurement Methodology:** Household living conditions surveys based on bedroom-to-occupant ratio standards.

### 182. Transport Infrastructure Investment (`transport_infrastructure_inv`)
- **Subcategory:** infra_transport_infra (`infra_transport_infra`)
- **Category:** `undefined`
- **Unit:** `% of GDP` (Sort: `DESC`)
- **Authoritative Source:** OECD International Transport Forum (ITF 2024)
- **Official Definition:** Total public and private capital investment in roads, railways, inland waterways, maritime ports, and airports as a percentage of GDP.
- **Measurement Methodology:** Capital expenditure on transport assets excluding routine operating and maintenance costs.

### 183. Mean Annual Surface Temperature (`avg_temperature`)
- **Subcategory:** Temperature (`clim_temperature`)
- **Category:** `undefined`
- **Unit:** `°C` (Sort: `DESC`)
- **Authoritative Source:** Berkeley Earth / NOAA 2024
- **Official Definition:** Nationwide land-surface air temperature averaged across all 12 calendar months.
- **Measurement Methodology:** Spatially kriged surface meteorological station network records calibrated against satellite radiometers.

### 184. Surface Temperature Anomaly (`temperature_anomaly`)
- **Subcategory:** Global Warming (`clim_global_warming`)
- **Category:** `undefined`
- **Unit:** `°C anomaly` (Sort: `ASC`)
- **Authoritative Source:** Berkeley Earth / Copernicus Climate 2024
- **Official Definition:** Departure of annual mean national temperature relative to the 1951-1980 climatological baseline period.
- **Measurement Methodology:** Differential gridded anomaly mapping showing localized climatic warming deviations.

### 185. Average Annual Precipitation (`annual_precipitation`)
- **Subcategory:** Rainfall (`clim_rainfall`)
- **Category:** `undefined`
- **Unit:** `mm / year` (Sort: `DESC`)
- **Authoritative Source:** World Bank Climate Knowledge Portal / GPCC
- **Official Definition:** Total depth of liquid and equivalent frozen precipitation falling on national territory annually.
- **Measurement Methodology:** Global Precipitation Climatology Centre (GPCC) rain-gauge network spatial interpolation.

### 186. Seasonal Snow Cover Extent (`snow_cover_extent_pct`)
- **Subcategory:** Snowfall (`clim_snowfall`)
- **Category:** `undefined`
- **Unit:** `% land area` (Sort: `DESC`)
- **Authoritative Source:** Rutgers Global Snow Lab / NOAA
- **Official Definition:** Average proportion of national land area covered by seasonal winter snowpack.
- **Measurement Methodology:** Visible and infrared satellite radiometer binary snow cover mapping.

### 187. Drought Severity Index (`drought_severity_index`)
- **Subcategory:** Drought (`clim_drought`)
- **Category:** `undefined`
- **Unit:** `score (0-5)` (Sort: `ASC`)
- **Authoritative Source:** Global Drought Observatory (GDO / JRC 2024)
- **Official Definition:** Combined Drought Indicator evaluating precipitation deficits, soil moisture anomalies, and vegetation stress.
- **Measurement Methodology:** Satellite soil moisture (SMAP) and Normalized Difference Vegetation Index (NDVI) anomaly integration.

### 188. Population in High Flood Risk Zones (`flood_risk_population_pct`)
- **Subcategory:** Floods (`clim_floods`)
- **Category:** `undefined`
- **Unit:** `% population` (Sort: `ASC`)
- **Authoritative Source:** World Bank Global Flood Risk Database 2024
- **Official Definition:** Percentage of resident population residing in 1-in-100-year riverine and coastal flood inundation hazard zones.
- **Measurement Methodology:** Global hydrodynamic flood modeling overlaid on high-resolution population distribution layers.

### 189. Tropical Cyclone Hazard Index (`tropical_cyclones_frequency`)
- **Subcategory:** Cyclones (`clim_cyclones`)
- **Category:** `undefined`
- **Unit:** `events/decade` (Sort: `ASC`)
- **Authoritative Source:** NOAA IBTrACS / WMO 2024
- **Official Definition:** Decadal frequency of Category 1-5 tropical cyclones, hurricanes, and typhoons making landfall.
- **Measurement Methodology:** International Best Track Archive for Climate Stewardship (IBTrACS) post-storm satellite reanalyses.

### 190. Extreme Weather Disasters Recorded (`extreme_weather_events`)
- **Subcategory:** Extreme Weather (`clim_extreme_weather`)
- **Category:** `undefined`
- **Unit:** `events / year` (Sort: `ASC`)
- **Authoritative Source:** EM-DAT International Disaster Database (CRED 2024)
- **Official Definition:** Annual recorded catastrophic weather events meeting EM-DAT disaster criteria (10+ deaths, 100+ affected, state of emergency).
- **Measurement Methodology:** Verified multi-source tracking of catastrophic droughts, extreme temperatures, storms, and floods.

### 191. Relative Coastal Sea Level Rise Rate (`sea_level_rise_mm_yr`)
- **Subcategory:** Sea Level (`clim_sea_level`)
- **Category:** `undefined`
- **Unit:** `mm / year` (Sort: `ASC`)
- **Authoritative Source:** NASA Sea Level Change Team / PSMSL 2024
- **Official Definition:** Local rate of coastal sea level rise factoring global thermal expansion, ice sheet melt, and vertical land motion.
- **Measurement Methodology:** Dual-frequency satellite altimetry (TOPEX/Poseidon, Jason, Sentinel-6) and coastal tide gauges.

### 192. Glacier Mass Balance Trend (`glacier_mass_balance_mwe`)
- **Subcategory:** Glaciers (`clim_glaciers`)
- **Category:** `undefined`
- **Unit:** `m water equiv / yr` (Sort: `DESC`)
- **Authoritative Source:** World Glacier Monitoring Service (WGMS 2024)
- **Official Definition:** Annual net balance of national mountain glaciers and ice caps in meters of water equivalent.
- **Measurement Methodology:** In situ glaciological stake measurements combined with geodetic satellite stereo-imagery DEM differencing.

### 193. Territorial Arctic/Antarctic Ice Cover (`sea_ice_extent_sqkm`)
- **Subcategory:** Polar Ice (`clim_polar_ice`)
- **Category:** `undefined`
- **Unit:** `thousand km²` (Sort: `DESC`)
- **Authoritative Source:** National Snow & Ice Data Center (NSIDC 2024)
- **Official Definition:** Area of territorial polar sea ice and ice sheets with at least 15% ice concentration.
- **Measurement Methodology:** Passive microwave satellite sensors (SSMIS, AMSR2) processing polar brightness temperatures.

### 194. Total Annual GHG Emissions (`total_ghg_emissions_mt`)
- **Subcategory:** Greenhouse Gases (`clim_greenhouse_gases`)
- **Category:** `undefined`
- **Unit:** `Million tonnes CO₂e` (Sort: `ASC`)
- **Authoritative Source:** UNFCCC / Climate Watch 2024
- **Official Definition:** Total national greenhouse gas emissions (CO₂, CH₄, N₂O, F-gases) excluding land-use change and forestry.
- **Measurement Methodology:** IPCC 100-year Global Warming Potential (GWP-100) metric converting gases to CO₂ equivalents.

### 195. ND-GAIN Climate Vulnerability Score (`climate_vulnerability_idx`)
- **Subcategory:** Climate Risk (`clim_climate_risk`)
- **Category:** `undefined`
- **Unit:** `score (0-1, lower is better)` (Sort: `ASC`)
- **Authoritative Source:** Notre Dame Global Adaptation Initiative (ND-GAIN 2024)
- **Official Definition:** Composite index evaluating country vulnerability to climate disruption across food, water, health, ecosystem, habitat, and infrastructure.
- **Measurement Methodology:** 36 indicators measuring exposure, sensitivity, and adaptive capacity to negative climate impacts.

### 196. Projected 2050 Temperature Increase (`projected_temp_rise_2050`)
- **Subcategory:** Climate Projections (`clim_climate_projections`)
- **Category:** `undefined`
- **Unit:** `°C rise` (Sort: `ASC`)
- **Authoritative Source:** IPCC Sixth Assessment Report (SSP2-4.5) / World Bank
- **Official Definition:** Projected mean annual surface temperature increase by 2050 relative to 1986-2005 under middle-of-the-road emissions.
- **Measurement Methodology:** CMIP6 multi-model ensemble median projections downscaled to national administrative boundaries.

### 197. Total Labor Force (`labor_force_total`)
- **Subcategory:** Labour Force (`emp_labour_force`)
- **Category:** `undefined`
- **Unit:** `Million workers` (Sort: `DESC`)
- **Authoritative Source:** ILO ILOSTAT Database 2024
- **Official Definition:** Total resident population aged 15 and older who supply labor for the production of goods and services (employed and unemployed).
- **Measurement Methodology:** National labor force surveys adhering to ILO resolution concerning statistics of work, employment and labor underutilization.

### 198. Employment-to-Population Ratio (`employment_to_pop_ratio`)
- **Subcategory:** Employment Rate (`emp_employment_rate`)
- **Category:** `undefined`
- **Unit:** `% (age 15+)` (Sort: `DESC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Proportion of a country's working-age population that is employed.
- **Measurement Methodology:** Total employed persons divided by total working-age population aged 15 and over.

### 199. Total Unemployment Rate (`unemployment_rate`)
- **Subcategory:** Unemployment (`emp_unemployment`)
- **Category:** `undefined`
- **Unit:** `% total labor` (Sort: `ASC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Share of the labor force that is without work but available for and seeking employment.
- **Measurement Methodology:** Unemployed persons actively seeking employment divided by total active civilian labor force.

### 200. Youth Unemployment Rate (`youth_unemployment_rate`)
- **Subcategory:** Youth Employment (`emp_youth_employment`)
- **Category:** `undefined`
- **Unit:** `% (ages 15-24)` (Sort: `ASC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Proportion of the labor force aged 15-24 that is without work but available for and seeking employment.
- **Measurement Methodology:** Youth unemployed divided by youth labor force cohort under standardized ILO survey criteria.

### 201. Statutory Monthly Minimum Wage (`monthly_minimum_wage_usd`)
- **Subcategory:** Wages and Salaries (`emp_wages_salaries`)
- **Category:** `undefined`
- **Unit:** `USD / month` (Sort: `DESC`)
- **Authoritative Source:** ILO Global Wage Report 2024
- **Official Definition:** Legally mandated minimum monthly gross remuneration payable by an employer to wage earners.
- **Measurement Methodology:** Official statutory legislation converted to current US dollars using market exchange rates.

### 202. Average Weekly Working Hours (`weekly_hours_worked`)
- **Subcategory:** Working Hours (`emp_working_hours`)
- **Category:** `undefined`
- **Unit:** `hours / week` (Sort: `ASC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Average actual hours worked per week per employed person in main job.
- **Measurement Methodology:** National labor force survey recall of actual hours worked during reference week.

### 203. Labor Force Participation Rate (`labor_participation`)
- **Subcategory:** Labour Participation (`emp_labour_participation`)
- **Category:** `undefined`
- **Unit:** `% (age 15+)` (Sort: `DESC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Percentage of the working-age population aged 15 and older that engages actively in the labor market.
- **Measurement Methodology:** Total labor force (employed + unemployed) divided by total resident population aged 15+.

### 204. Labor Participation Gender Gap (`gender_gap_participation`)
- **Subcategory:** Gender Gap (`emp_gender_gap`)
- **Category:** `undefined`
- **Unit:** `% points (M-F)` (Sort: `ASC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Difference in percentage points between the male and female labor force participation rates.
- **Measurement Methodology:** Male labor force participation rate minus female labor force participation rate.

### 205. Services Sector Employment Share (`services_employment_pct`)
- **Subcategory:** Employment by Sector (`emp_employment_by_sector`)
- **Category:** `undefined`
- **Unit:** `% total employment` (Sort: `DESC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Share of employed individuals working in tertiary service sector industries (commerce, finance, transport, healthcare, education).
- **Measurement Methodology:** ISIC Rev. 4 industrial classifications (Sections G through U) divided by total employment.

### 206. Informal Employment Rate (`informal_employment_pct`)
- **Subcategory:** Informal Employment (`emp_informal_employment`)
- **Category:** `undefined`
- **Unit:** `% of non-agri` (Sort: `ASC`)
- **Authoritative Source:** ILO Women and Men in the Informal Economy 2024
- **Official Definition:** Percentage of non-agricultural employment consisting of jobs that lack social security, labor rights, and legal protection.
- **Measurement Methodology:** 17th ICLS statistical definitions of informal employment based on employment relationships and enterprise registration.

### 207. Migrant Workers in Labor Force (`migrant_workers_share`)
- **Subcategory:** Migrant Workers (`emp_migrant_workers`)
- **Category:** `undefined`
- **Unit:** `% of labor force` (Sort: `DESC`)
- **Authoritative Source:** ILO Global Estimates on International Migrant Workers
- **Official Definition:** Share of the domestic civilian labor force who are international foreign-born migrant workers.
- **Measurement Methodology:** National population censuses and residence permit registries tracking foreign-born active employment.

### 208. Labor Productivity (GDP / Worker) (`gdp_per_person_employed`)
- **Subcategory:** Productivity (`emp_productivity`)
- **Category:** `undefined`
- **Unit:** `USD (constant PPP)` (Sort: `DESC`)
- **Authoritative Source:** ILOSTAT / World Bank 2024
- **Official Definition:** Gross domestic product divided by the total number of employed persons in the economy.
- **Measurement Methodology:** Constant 2017 PPP GDP divided by total employment headcount: key metric of macroeconomic output efficiency.

### 209. Fatal Work Injury Rate (`fatal_occupational_injuries`)
- **Subcategory:** Occupational Safety (`emp_occupational_safety`)
- **Category:** `undefined`
- **Unit:** `per 100k workers` (Sort: `ASC`)
- **Authoritative Source:** ILO ILOSTAT 2024
- **Official Definition:** Annual number of fatal occupational injuries occurring among workers per 100,000 employed people.
- **Measurement Methodology:** National occupational health and safety labor inspection records and social security compensation claims.

### 210. Social Protection Effective Coverage (`social_protection_cov`)
- **Subcategory:** Social Protection (`emp_social_protection`)
- **Category:** `undefined`
- **Unit:** `% population` (Sort: `DESC`)
- **Authoritative Source:** ILO World Social Protection Report 2024
- **Official Definition:** Proportion of population effectively covered by at least one social protection cash benefit.
- **Measurement Methodology:** Social Security Inquiry (SSI) administrative beneficiary records mapped to demographic cohorts.

### 211. Child Labor Prevalence (`child_labor_pct`)
- **Subcategory:** Child Labour (`emp_child_labour`)
- **Category:** `undefined`
- **Unit:** `% (ages 5-17)` (Sort: `ASC`)
- **Authoritative Source:** ILO / UNICEF Global Estimates 2024
- **Official Definition:** Percentage of children aged 5-17 engaged in economic work exceeding age-specific threshold hours or hazardous labor.
- **Measurement Methodology:** Multiple Indicator Cluster Surveys (MICS) and Demographic and Health Surveys (DHS) child labor modules.

### 212. Gross R&D Expenditure (GERD) (`rnd_expenditure_total_usd`)
- **Subcategory:** Research Spending (`sci_research_spending`)
- **Category:** `undefined`
- **Unit:** `Billion USD PPP` (Sort: `DESC`)
- **Authoritative Source:** UNESCO Institute for Statistics 2024
- **Official Definition:** Total domestic expenditure on scientific research and experimental development in billion current PPP dollars.
- **Measurement Methodology:** Frascati Manual OECD surveys covering industry, university, and public sector research spending.

### 213. R&D Researchers Density (`researchers_per_million`)
- **Subcategory:** Researchers (`sci_researchers`)
- **Category:** `undefined`
- **Unit:** `researchers / 1M people` (Sort: `DESC`)
- **Authoritative Source:** UNESCO Science Report 2024
- **Official Definition:** Professionals engaged in the conception or creation of new knowledge, products, and processes per million residents.
- **Measurement Methodology:** Full-Time Equivalent (FTE) headcount of scientists and research engineers active in R&D.

### 214. Scientific Journal Articles Published (`scientific_publications`)
- **Subcategory:** Scientific Publications (`sci_scientific_publications`)
- **Category:** `undefined`
- **Unit:** `articles / year` (Sort: `DESC`)
- **Authoritative Source:** NSF / Scopus Elsevier 2024
- **Official Definition:** Peer-reviewed scientific and technical articles published in major scholarly journals indexed by Scopus and Web of Science.
- **Measurement Methodology:** Fractional count of articles across physics, chemistry, biology, mathematics, medicine, engineering, and geosciences.

### 215. Mean Scientific Citations Per Paper (`citations_per_paper`)
- **Subcategory:** Citations (`sci_citations`)
- **Category:** `undefined`
- **Unit:** `citations avg` (Sort: `DESC`)
- **Authoritative Source:** Scimago Journal & Country Rank 2024
- **Official Definition:** Average number of citations received per published scientific citable document over a 3-year window.
- **Measurement Methodology:** Citation tracking within the Elsevier Scopus bibliographic database.

### 216. Triadic Patent Families (`triadic_patents_count`)
- **Subcategory:** Scientific Patents (`sci_scientific_patents`)
- **Category:** `undefined`
- **Unit:** `patent families` (Sort: `DESC`)
- **Authoritative Source:** OECD Patent Statistics / WIPO
- **Official Definition:** Set of patents filed at the European Patent Office (EPO), Japan Patent Office (JPO), and US Patent and Trademark Office (USPTO) for the same invention.
- **Measurement Methodology:** Indicator of highest-value global technological inventions eliminating national filing home-court bias.

### 217. Civilian Space Agency Budget (`space_budget_usd`)
- **Subcategory:** Space Exploration (`sci_space_exploration`)
- **Category:** `undefined`
- **Unit:** `Million USD` (Sort: `DESC`)
- **Authoritative Source:** Euroconsult / NASA / ESA 2024
- **Official Definition:** Annual government appropriations for national civilian space programs and space exploration agencies.
- **Measurement Methodology:** National legislative budget appropriations for space research, satellite launch, and planetary exploration.

### 218. Operational Satellites in Orbit (`operational_satellites`)
- **Subcategory:** Satellites (`sci_satellites`)
- **Category:** `undefined`
- **Unit:** `satellites in orbit` (Sort: `DESC`)
- **Authoritative Source:** Union of Concerned Scientists (UCS) Satellite Database
- **Official Definition:** Number of active, functioning satellites registered to sovereign commercial, government, or military operators in Earth orbit.
- **Measurement Methodology:** Regular satellite orbital tracking verified through UN Space Register and US Space Command data.

### 219. Major Astronomical Observatories (`major_telescopes_count`)
- **Subcategory:** Astronomy (`sci_astronomy`)
- **Category:** `undefined`
- **Unit:** `observatories` (Sort: `DESC`)
- **Authoritative Source:** International Astronomical Union (IAU)
- **Official Definition:** Number of major optical and radio telescope research facilities with apertures exceeding 2.0 meters.
- **Measurement Methodology:** IAU registry of world professional astronomical observatories.

### 220. Biotechnology Patents Share (`biotech_patents_share`)
- **Subcategory:** Biotechnology (`sci_biotechnology`)
- **Category:** `undefined`
- **Unit:** `% total patents` (Sort: `DESC`)
- **Authoritative Source:** WIPO / OECD Biotechnology Statistics
- **Official Definition:** Percentage of international patent applications dedicated to genetic engineering, pharmaceuticals, and cellular biology.
- **Measurement Methodology:** WIPO International Patent Classification (IPC) codes targeting biotechnology and medical technology.

### 221. Registered Clinical Trials (`clinical_trials_count`)
- **Subcategory:** Medical Research (`sci_medical_research`)
- **Category:** `undefined`
- **Unit:** `registered trials` (Sort: `DESC`)
- **Authoritative Source:** WHO International Clinical Trials Registry (ICTRP 2024)
- **Official Definition:** Total number of registered clinical trial investigations for medical therapeutics, biologics, and pharmaceuticals.
- **Measurement Methodology:** WHO Primary Registries (ClinicalTrials.gov, EU Clinical Trials Register, national clinical registries).

### 222. Physical Sciences Research Output (`high_energy_physics_pubs`)
- **Subcategory:** Physics and Chemistry (`sci_physics_chemistry`)
- **Category:** `undefined`
- **Unit:** `publications / yr` (Sort: `DESC`)
- **Authoritative Source:** Nature Index / INSPIRE-HEP 2024
- **Official Definition:** High-impact research articles published in premier physical chemistry, quantum, and high-energy physics journals.
- **Measurement Methodology:** Share metric of articles published in 82 natural science journals selected by independent scientific panels.

### 223. Engineering Graduate Share (`engineering_graduates_pct`)
- **Subcategory:** Engineering (`sci_engineering`)
- **Category:** `undefined`
- **Unit:** `% tertiary grads` (Sort: `DESC`)
- **Authoritative Source:** UNESCO Institute for Statistics 2024
- **Official Definition:** Percentage of tertiary education degrees awarded in engineering, manufacturing, and construction disciplines.
- **Measurement Methodology:** ISCED-F 2013 broad field 07 (Engineering, manufacturing and construction) graduate count.

### 224. Nobel Prize Laureates Total (`nobel_laureates_total`)
- **Subcategory:** Nobel Prizes (`sci_nobel_prizes`)
- **Category:** `undefined`
- **Unit:** `laureates all-time` (Sort: `DESC`)
- **Authoritative Source:** The Nobel Foundation Official Records
- **Official Definition:** Total number of Nobel Prizes awarded to individuals and organizations associated with the country by nationality or affiliation.
- **Measurement Methodology:** Official records of the Royal Swedish Academy of Sciences, Karolinska Institute, and Norwegian Nobel Committee.

### 225. TOP500 Supercomputers Hosted (`supercomputers_top500`)
- **Subcategory:** Research Infrastructure (`sci_research_infra`)
- **Category:** `undefined`
- **Unit:** `systems on TOP500` (Sort: `DESC`)
- **Authoritative Source:** TOP500 Supercomputing List (June/Nov 2024)
- **Official Definition:** Number of high-performance supercomputers ranked on the official biannual TOP500 list based on Linpack benchmark.
- **Measurement Methodology:** High Performance Linpack (HPL) benchmark measured in petaflops (Rmax).

### 226. International Co-Authorship Rate (`intl_coauthored_papers_pct`)
- **Subcategory:** International Collaboration (`sci_international_collaboration`)
- **Category:** `undefined`
- **Unit:** `% total papers` (Sort: `DESC`)
- **Authoritative Source:** Scopus / Science & Engineering Indicators 2024
- **Official Definition:** Percentage of published scientific papers produced with at least one institutional co-author in a different country.
- **Measurement Methodology:** Bibliometric institutional affiliation cross-referencing on multiauthored publications.

### 227. All-Time Olympic Medals Total (`olympic_medals_total`)
- **Subcategory:** Olympic Games (`sports_olympic_games`)
- **Category:** `undefined`
- **Unit:** `medals (Summer+Winter)` (Sort: `DESC`)
- **Authoritative Source:** International Olympic Committee (IOC Official)
- **Official Definition:** Total cumulative Olympic gold, silver, and bronze medals won across all modern Summer and Winter Olympic Games.
- **Measurement Methodology:** Official historical medal databases of the International Olympic Committee.

### 228. All-Time Paralympic Medals Total (`paralympic_medals_total`)
- **Subcategory:** Paralympic Games (`sports_paralympic_games`)
- **Category:** `undefined`
- **Unit:** `medals all-time` (Sort: `DESC`)
- **Authoritative Source:** International Paralympic Committee (IPC Official)
- **Official Definition:** Total medals won at Summer and Winter Paralympic Games by the National Paralympic Committee.
- **Measurement Methodology:** Official IPC historical tournament medal databases.

### 229. FIFA Men's World Ranking (`fifa_ranking`)
- **Subcategory:** Football (`sports_football`)
- **Category:** `undefined`
- **Unit:** `rank position` (Sort: `ASC`)
- **Authoritative Source:** FIFA Official World Ranking (Oct 2024)
- **Official Definition:** Official global ranking position of men's national association football teams.
- **Measurement Methodology:** Elo-based point algorithm weighting match results, importance, and relative team strength over international fixtures.

### 230. ICC Men's Cricket World Ranking (`icc_test_ranking`)
- **Subcategory:** Cricket (`sports_cricket`)
- **Category:** `undefined`
- **Unit:** `rank position` (Sort: `ASC`)
- **Authoritative Source:** International Cricket Council (ICC 2024)
- **Official Definition:** Official global ranking position of national men's cricket teams across Test, ODI, and T20 international formats.
- **Measurement Methodology:** Match points divided by total matches played weighted over a 3-year performance window.

### 231. FIBA Men's Basketball Ranking (`fiba_world_ranking`)
- **Subcategory:** Basketball (`sports_basketball`)
- **Category:** `undefined`
- **Unit:** `rank position` (Sort: `ASC`)
- **Authoritative Source:** FIBA Official World Ranking 2024
- **Official Definition:** Official global ranking of men's national basketball teams in official FIBA tournaments and qualifiers.
- **Measurement Methodology:** Game result point algorithm factoring margin of victory, home/away status, and opponent strength over 8 years.

### 232. Top 100 Professional Tennis Players (`top100_tennis_players`)
- **Subcategory:** Tennis (`sports_tennis`)
- **Category:** `undefined`
- **Unit:** `players in top 100` (Sort: `DESC`)
- **Authoritative Source:** ATP / WTA Official Rankings 2024
- **Official Definition:** Total professional tennis players representing the country ranked in the official ATP (men) and WTA (women) singles top 100.
- **Measurement Methodology:** Rolling 52-week ATP and WTA ranking point leaderboards.

### 233. Top 50 Badminton World Players (`bwf_top50_players`)
- **Subcategory:** Badminton (`sports_badminton`)
- **Category:** `undefined`
- **Unit:** `players count` (Sort: `DESC`)
- **Authoritative Source:** Badminton World Federation (BWF 2024)
- **Official Definition:** Number of athletes ranked in the BWF singles and doubles world top 50.
- **Measurement Methodology:** BWF World Ranking tournament point accumulation across Super 1000, 750, and 500 events.

### 234. FIH Field Hockey World Ranking (`fih_world_ranking`)
- **Subcategory:** Hockey (`sports_hockey`)
- **Category:** `undefined`
- **Unit:** `rank position` (Sort: `ASC`)
- **Authoritative Source:** International Hockey Federation (FIH 2024)
- **Official Definition:** Official global ranking position of national men's and women's field hockey teams.
- **Measurement Methodology:** Match-based world ranking system calculating points from certified international hockey fixtures.

### 235. World Athletics Records Held (`world_athletics_records`)
- **Subcategory:** Athletics (`sports_athletics`)
- **Category:** `undefined`
- **Unit:** `active records` (Sort: `DESC`)
- **Authoritative Source:** World Athletics Official Records 2024
- **Official Definition:** Total recognized current world records in track and field, road running, and race walking events held by national athletes.
- **Measurement Methodology:** World Athletics certified and ratifying timing and anti-doping verification.

### 236. World Aquatics Championship Medals (`fina_world_championship_medals`)
- **Subcategory:** Swimming (`sports_swimming`)
- **Category:** `undefined`
- **Unit:** `medals all-time` (Sort: `DESC`)
- **Authoritative Source:** World Aquatics (FINA 2024)
- **Official Definition:** Cumulative medals won across all World Aquatics Championships in swimming, diving, and water polo.
- **Measurement Methodology:** Official World Aquatics competitive championship medal registers.

### 237. Olympic Sports Diversity Index (`sport_diversity_index`)
- **Subcategory:** Other Sports (`sports_other_sports`)
- **Category:** `undefined`
- **Unit:** `sports with medalists` (Sort: `DESC`)
- **Authoritative Source:** IOC / Association of Summer Olympic IFs
- **Official Definition:** Number of distinct Olympic disciplines in which the national Olympic committee has won at least one medal.
- **Measurement Methodology:** Cross-disciplinary medal verification across all IOC-sanctioned Olympic sports.

### 238. Guinness World Records Recognized (`guinness_records_held`)
- **Subcategory:** World Records (`sports_world_records`)
- **Category:** `undefined`
- **Unit:** `records count` (Sort: `DESC`)
- **Authoritative Source:** Guinness World Records Database 2024
- **Official Definition:** Total officially ratified athletic and sporting Guinness World Records currently held.
- **Measurement Methodology:** Certified adjudicator measurements and anti-doping clearances.

### 239. Adult Physical Activity Compliance (`adult_physical_activity_pct`)
- **Subcategory:** Sports Participation (`sports_sports_participation`)
- **Category:** `undefined`
- **Unit:** `% of adults` (Sort: `DESC`)
- **Authoritative Source:** WHO Physical Activity Guidelines 2024
- **Official Definition:** Percentage of adult population meeting WHO recommendations of at least 150 minutes of moderate-intensity physical activity per week.
- **Measurement Methodology:** Global Physical Activity Questionnaire (GPAQ) and International Physical Activity Questionnaire (IPAQ) surveys.

### 240. Major Stadiums (>30k Capacity) (`major_stadiums_count`)
- **Subcategory:** Stadiums (`sports_stadiums`)
- **Category:** `undefined`
- **Unit:** `stadiums count` (Sort: `DESC`)
- **Authoritative Source:** World Stadiums Database / FIFA Venue Registries
- **Official Definition:** Number of multipurpose, football, cricket, and athletic stadiums with permanent seating capacity exceeding 30,000 spectators.
- **Measurement Methodology:** Certified architectural seating plan inspections and sports federations tournament licensing.

### 241. Senior World Cup Championship Titles (`world_cup_titles_total`)
- **Subcategory:** Historical Champions (`sports_historical_champions`)
- **Category:** `undefined`
- **Unit:** `titles (Football, Cricket, Rugby)` (Sort: `DESC`)
- **Authoritative Source:** FIFA / ICC / World Rugby Official Records
- **Official Definition:** Total championship titles won at premier global senior tournaments in football, cricket, and rugby union.
- **Measurement Methodology:** Official historical tournament tournament winners logs.

### 242. Largest Metro Population (`largest_metro_pop`)
- **Subcategory:** Largest Cities (`city_largest_cities`)
- **Category:** `undefined`
- **Unit:** `Million residents` (Sort: `DESC`)
- **Authoritative Source:** UN-Habitat / Demographia World Urban Areas 2024
- **Official Definition:** Total population residing in the single largest contiguous urban agglomeration or metropolitan area in the country.
- **Measurement Methodology:** Demographia continuous urban footprint satellite night-light and census enumeration.

### 243. Annual Urban Population Growth Rate (`urban_pop_growth_rate`)
- **Subcategory:** City Population Growth (`city_population_growth`)
- **Category:** `undefined`
- **Unit:** `% annual` (Sort: `DESC`)
- **Authoritative Source:** UN DESA World Urbanization Prospects 2024
- **Official Definition:** Annual average rate of change of the size of the total national urban population.
- **Measurement Methodology:** Annualized log difference between consecutive urban population estimates.

### 244. Largest Urban Area Density (`largest_city_density`)
- **Subcategory:** Population Density (`city_population_density`)
- **Category:** `undefined`
- **Unit:** `people / km²` (Sort: `DESC`)
- **Authoritative Source:** Demographia World Urban Areas 2024
- **Official Definition:** Human population density per square kilometer within the continuously built-up urban area of the largest city.
- **Measurement Methodology:** Built-up urban footprint area divided into the contiguous resident population.

### 245. Largest City Metropolitan GDP (`metro_gdp_usd`)
- **Subcategory:** Economic Cities (`city_economic_cities`)
- **Category:** `undefined`
- **Unit:** `Billion USD` (Sort: `DESC`)
- **Authoritative Source:** Brookings Global Metro Monitor / Oxford Economics 2024
- **Official Definition:** Gross domestic product generated specifically within the metropolitan economic region of the primate city.
- **Measurement Methodology:** Regional economic accounting and subnational input-output tables converted to current US dollars.

### 246. Primate City Cost of Living Index (`cost_of_living_index`)
- **Subcategory:** Cost of Living (`city_cost_of_living`)
- **Category:** `undefined`
- **Unit:** `index (NYC = 100)` (Sort: `DESC`)
- **Authoritative Source:** Mercer Cost of Living / Numbeo 2024
- **Official Definition:** Comparative price level index for consumer goods and services in the primary commercial city benchmarked against New York City.
- **Measurement Methodology:** Sampling of over 200 consumer items including housing, food, transport, clothing, and entertainment.

### 247. Urban Quality of Living Score (`city_quality_of_life_idx`)
- **Subcategory:** Quality of Life (`city_quality_of_life`)
- **Category:** `undefined`
- **Unit:** `score (0-200)` (Sort: `DESC`)
- **Authoritative Source:** Mercer Quality of Living / EIU Global Liveability 2024
- **Official Definition:** City-level liveability score assessing political stability, crime, economic environment, healthcare, education, and recreation.
- **Measurement Methodology:** 39 factors evaluated for multinational expatriates and resident urban populations.

### 248. IMD Smart City Index Score (`smart_city_index`)
- **Subcategory:** Smart Cities (`city_smart_cities`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** IMD Smart City Observatory / SUTD 2024
- **Official Definition:** Evaluation of how technology and digital solutions improve the daily lives of citizens in urban areas.
- **Measurement Methodology:** Citizen perceptions of smart infrastructure across health, mobility, activities, opportunities, and governance.

### 249. Capital City PM2.5 Exposure (`city_pm25_annual`)
- **Subcategory:** Cleanest Cities (`city_cleanest_cities`)
- **Category:** `undefined`
- **Unit:** `µg / m³` (Sort: `ASC`)
- **Authoritative Source:** WHO Urban Air Quality Database 2024
- **Official Definition:** Annual average concentration of particulate matter under 2.5 microns in the national capital city.
- **Measurement Methodology:** Official municipal environmental agency continuous monitoring stations.

### 250. Urban Green Space Per Resident (`green_space_per_capita`)
- **Subcategory:** Green Cities (`city_green_cities`)
- **Category:** `undefined`
- **Unit:** `m² / person` (Sort: `DESC`)
- **Authoritative Source:** UN-Habitat / European Environment Agency
- **Official Definition:** Public parks, gardens, recreational grounds, and urban canopy area per resident in the primary city.
- **Measurement Methodology:** High-resolution satellite Normalized Difference Vegetation Index (NDVI) masked by municipal park polygons.

### 251. Public Transit Commuter Share (`public_transit_commute_pct`)
- **Subcategory:** City Transport (`city_city_transport`)
- **Category:** `undefined`
- **Unit:** `% of commutes` (Sort: `DESC`)
- **Authoritative Source:** UITP International Public Transport / Moovit 2024
- **Official Definition:** Proportion of daily work and education trips completed on metro, bus, tram, and suburban rail networks in the primary city.
- **Measurement Methodology:** Comprehensive municipal origin-destination transport surveys.

### 252. Urban House Price-to-Income Ratio (`housing_price_to_income`)
- **Subcategory:** Housing (`city_housing`)
- **Category:** `undefined`
- **Unit:** `years of income` (Sort: `ASC`)
- **Authoritative Source:** Demographia Housing Affordability / OECD 2024
- **Official Definition:** Median house price in the primary city divided by median annual gross household income.
- **Measurement Methodology:** Standard international housing affordability index (under 3.0 is affordable; 5.1+ is severely unaffordable).

### 253. Urban Safety & Security Index (`safest_city_index`)
- **Subcategory:** Safety (`city_safety`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** EIU Safe Cities Index / Numbeo Crime Index 2024
- **Official Definition:** Metric evaluating personal, digital, health, infrastructure, and environmental security in the primary city.
- **Measurement Methodology:** 76 quantitative and qualitative security indicators.

### 254. Top City International Tourist Arrivals (`city_international_visitors`)
- **Subcategory:** Tourism (`city_tourism`)
- **Category:** `undefined`
- **Unit:** `Million visitors / yr` (Sort: `DESC`)
- **Authoritative Source:** Mastercard Global Destination Cities / Euromonitor 2024
- **Official Definition:** Total annual international overnight visitors arriving and staying in the country's most visited destination city.
- **Measurement Methodology:** Commercial credit card cross-border transaction volumes cross-checked with flight manifests.

### 255. Skyscrapers Over 150m Built (`skyscrapers_150m_count`)
- **Subcategory:** Skyscrapers (`city_skyscrapers`)
- **Category:** `undefined`
- **Unit:** `buildings count` (Sort: `DESC`)
- **Authoritative Source:** Council on Tall Buildings and Urban Habitat (CTBUH 2024)
- **Official Definition:** Total number of completed architectural tall buildings reaching or exceeding 150 meters (492 feet) in height.
- **Measurement Methodology:** CTBUH Skyscraper Center engineering field inspections and architectural height certifications.

### 256. National Urbanization Level (`city_urban_pop_share`)
- **Subcategory:** Urbanisation (`city_urbanisation`)
- **Category:** `undefined`
- **Unit:** `% of total population` (Sort: `DESC`)
- **Authoritative Source:** UN DESA World Urbanization Prospects 2024
- **Official Definition:** Total percentage of sovereign population living in cities and designated urban areas.
- **Measurement Methodology:** National statistical office criteria applied to census enumerations.

### 257. SDG 1: No Poverty Score (`sdg_01_score`)
- **Subcategory:** SDG 1: No Poverty (`sdg_01_no_poverty`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge University Press 2024
- **Official Definition:** Progress score on eliminating poverty: poverty headcount ratio at $2.15/day, national poverty line, and multidimensional poverty.
- **Measurement Methodology:** Normalized score where 100 indicates complete achievement of SDG 1 targets under official UN metadata.

### 258. SDG 2: Zero Hunger Score (`sdg_02_score`)
- **Subcategory:** SDG 2: Zero Hunger (`sdg_02_zero_hunger`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on ending hunger, achieving food security, improving nutrition, and promoting sustainable agriculture.
- **Measurement Methodology:** Composite of undernourishment prevalence, child stunting, cereal yield, and sustainable nitrogen management.

### 259. SDG 3: Good Health & Well-being (`sdg_03_score`)
- **Subcategory:** SDG 3: Good Health and Well-being (`sdg_03_good_health`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on ensuring healthy lives and promoting well-being for all at all ages.
- **Measurement Methodology:** Composite of maternal mortality, neonatal mortality, road traffic deaths, universal health coverage, and life expectancy.

### 260. SDG 4: Quality Education Score (`sdg_04_score`)
- **Subcategory:** SDG 4: Quality Education (`sdg_04_quality_education`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on ensuring inclusive and equitable quality education and promoting lifelong learning opportunities for all.
- **Measurement Methodology:** Composite of primary completion rate, lower secondary completion rate, and literacy rates.

### 261. SDG 5: Gender Equality Score (`sdg_05_score`)
- **Subcategory:** SDG 5: Gender Equality (`sdg_05_gender_equality`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on achieving gender equality and empowering all women and girls.
- **Measurement Methodology:** Composite of female labor force participation, parliamentary representation, and gender wage differentials.

### 262. SDG 6: Clean Water & Sanitation (`sdg_06_score`)
- **Subcategory:** SDG 6: Clean Water and Sanitation (`sdg_06_clean_water`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on ensuring availability and sustainable management of water and sanitation for all.
- **Measurement Methodology:** Composite of access to safely managed drinking water, sanitation services, and freshwater stress.

### 263. SDG 7: Affordable & Clean Energy (`sdg_07_score`)
- **Subcategory:** SDG 7: Affordable and Clean Energy (`sdg_07_clean_energy`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on ensuring access to affordable, reliable, sustainable and modern energy for all.
- **Measurement Methodology:** Composite of electrification rate, clean cooking fuels access, and renewable energy share.

### 264. SDG 8: Decent Work & Economic Growth (`sdg_08_score`)
- **Subcategory:** SDG 8: Decent Work and Economic Growth (`sdg_08_decent_work`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on sustained, inclusive and sustainable economic growth, full and productive employment.
- **Measurement Methodology:** Composite of real GDP per capita growth, fatal work injury rate, and youth NEET rate (not in employment, education, or training).

### 265. SDG 9: Industry, Innovation & Infra (`sdg_09_score`)
- **Subcategory:** SDG 9: Industry, Innovation and Infrastructure (`sdg_09_industry_infra`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on building resilient infrastructure, promoting inclusive and sustainable industrialization and fostering innovation.
- **Measurement Methodology:** Composite of rural road accessibility, mobile broadband subscriptions, R&D expenditure, and scientific publications.

### 266. SDG 10: Reduced Inequalities Score (`sdg_10_score`)
- **Subcategory:** SDG 10: Reduced Inequalities (`sdg_10_reduced_inequalities`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on reducing income inequality within and among countries.
- **Measurement Methodology:** Composite of Gini coefficient, Palma ratio (richest 10% share to poorest 40% share), and social protection coverage.

### 267. SDG 11: Sustainable Cities Score (`sdg_11_score`)
- **Subcategory:** SDG 11: Sustainable Cities and Communities (`sdg_11_sustainable_cities`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on making cities and human settlements inclusive, safe, resilient, and sustainable.
- **Measurement Methodology:** Composite of urban PM2.5 pollution exposure, access to public transport, and municipal solid waste collection rates.

### 268. SDG 12: Responsible Consumption (`sdg_12_score`)
- **Subcategory:** SDG 12: Responsible Consumption and Production (`sdg_12_responsible_consumption`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on ensuring sustainable consumption and production patterns.
- **Measurement Methodology:** Composite of municipal solid waste generation, electronic waste recycled, and production-based nitrogen emissions.

### 269. SDG 13: Climate Action Score (`sdg_13_score`)
- **Subcategory:** SDG 13: Climate Action (`sdg_13_climate_action`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on taking urgent action to combat climate change and its impacts.
- **Measurement Methodology:** Composite of fossil fuel CO2 emissions per capita, imported CO2 emissions, and climate vulnerability.

### 270. SDG 14: Life Below Water Score (`sdg_14_score`)
- **Subcategory:** SDG 14: Life Below Water (`sdg_14_life_below_water`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on conserving and sustainably using the oceans, seas and marine resources for sustainable development.
- **Measurement Methodology:** Composite of mean marine protected area coverage, clean waters index, and fish caught by bottom trawling.

### 271. SDG 15: Life on Land Score (`sdg_15_score`)
- **Subcategory:** SDG 15: Life on Land (`sdg_15_life_on_land`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on protecting, restoring and promoting sustainable use of terrestrial ecosystems, sustainably managing forests, combating desertification.
- **Measurement Methodology:** Composite of terrestrial Key Biodiversity Areas protected, Red List Index, and annual forest cover change.

### 272. SDG 16: Peace, Justice & Institutions (`sdg_16_score`)
- **Subcategory:** SDG 16: Peace, Justice and Strong Institutions (`sdg_16_peace_justice`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on promoting peaceful and inclusive societies for sustainable development, providing access to justice for all.
- **Measurement Methodology:** Composite of homicide rate, unsentenced detainees share, Corruption Perceptions Index, and press freedom.

### 273. SDG 17: Partnerships for the Goals (`sdg_17_score`)
- **Subcategory:** SDG 17: Partnerships for the Goals (`sdg_17_partnerships`)
- **Category:** `undefined`
- **Unit:** `score (0-100)` (Sort: `DESC`)
- **Authoritative Source:** UN SDSN / Cambridge 2024
- **Official Definition:** Progress on strengthening the means of implementation and revitalizing the Global Partnership for Sustainable Development.
- **Measurement Methodology:** Composite of official development assistance (ODA) as % of GNI, government revenue as % of GDP, and statistical performance index.

