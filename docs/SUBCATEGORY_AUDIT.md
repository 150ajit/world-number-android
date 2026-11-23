# World Number - Subcategory Audit & Classification Report
**Date:** November 23, 2026  
**Document Version:** 1.0.0  
**Target:** 20 Global Categories / 274 Subcategories  

---

## 1. Audit Framework & Action Taxonomy

Every subcategory in the target architecture has been evaluated against the existing codebase and assigned one of the 7 mandatory actions:
1. **RETAIN:** Already correct and functional in the indicators/categories structure.
2. **IMPROVE:** Concept exists in indicators or datasets; needs elevation to a formal subcategory with dedicated views.
3. **RENAME:** Concept exists but required normalization to standard international terminology.
4. **MERGE:** Overlapping or duplicate items unified into one canonical subcategory.
5. **MOVE:** Concept was improperly categorized and re-aligned with its authoritative international agency.
6. **REPLACE:** Superseded by official UN/World Bank statistical definitions.
7. **ADD:** Missing domain required to complete the comprehensive 274-subcategory catalog.

---

## 2. Complete 20-Category Subcategory Audit Inventory

### Category 1: Population (`population`) — Target: 12 Subcategories
| # | Subcategory Name | Subcategory ID | Status in App | Action | Core Indicator / Dataset |
|---|---|---|---|---|---|
| 1 | Total Population | `pop_total_pop` | Exists in Indicators (`pop_total`) | **IMPROVE** | UN WPP 2024 Population |
| 2 | Population Density | `pop_density` | Calculated in App | **IMPROVE** | People per km² |
| 3 | Age Distribution | `pop_age_distribution` | Exists in Pyramid data | **IMPROVE** | Age Brackets (0-14, 15-64, 65+) |
| 4 | Gender Distribution | `pop_gender_distribution` | Exists in AgeGender entities | **IMPROVE** | Male vs Female Ratio |
| 5 | Births and Fertility | `pop_fertility` | Exists in Indicators (`pop_fertility`) | **IMPROVE** | Total Fertility Rate (TFR) |
| 6 | Deaths and Mortality | `pop_mortality` | Exists in Datasets | **IMPROVE** | Crude Death Rate / 1k |
| 7 | Life Expectancy | `pop_life_expectancy` | Shared with Health | **RETAIN** | UN WPP Life Expectancy at Birth |
| 8 | Migration | `pop_migration` | Mentioned in Methodology | **ADD** | Net Migration Rate |
| 9 | Urban and Rural Population | `pop_urban_rural` | City indicators exist | **ADD** | Urbanization % |
| 10 | Population Projections | `pop_projections` | Exists in Baseline engine | **IMPROVE** | 2050 / 2100 Projections |
| 11 | Family and Household | `pop_family_household` | New Domain | **ADD** | Mean Household Size |
| 12 | Population Milestones | `pop_milestones` | Exists in Stories | **IMPROVE** | Global Population Thresholds |

### Category 2: Economy (`economy`) — Target: 12 Subcategories
| # | Subcategory Name | Subcategory ID | Status in App | Action | Core Indicator / Dataset |
|---|---|---|---|---|---|
| 1 | GDP | `eco_gdp_nominal` | Exists (`gdp_nominal`) | **IMPROVE** | Nominal GDP (Billion USD) |
| 2 | GDP Per Capita | `eco_gdp_per_capita` | Exists (`gdp_per_capita`) | **IMPROVE** | GDP Per Capita (USD) |
| 3 | Inflation | `eco_inflation` | Exists (`inflation_rate`) | **IMPROVE** | Consumer Price Index % |
| 4 | Currency and Exchange Rates | `eco_currency` | Mentioned in notes | **ADD** | Exchange Rate to USD |
| 5 | Government Finance | `eco_govt_finance` | Exists in fiscal data | **ADD** | Fiscal Revenue & Balance |
| 6 | Public Debt | `eco_public_debt` | In Economy Dataset | **ADD** | Debt-to-GDP Ratio % |
| 7 | International Trade | `eco_trade` | In Trade dataset | **ADD** | Exports & Imports Volume |
| 8 | Foreign Investment | `eco_fdi` | In World Bank Dataset | **ADD** | FDI Inflows (Million USD) |
| 9 | Banking and Interest Rates | `eco_interest_rates` | Central Bank stats | **ADD** | Central Bank Policy Rate |
| 10 | Stock Markets | `eco_stock_markets` | Market cap stats | **ADD** | Market Capitalization |
| 11 | Poverty and Inequality | `eco_poverty_inequality` | Gini in Global Indices | **MERGE** | Gini Index & Below $2.15/day |
| 12 | Foreign Reserves | `eco_foreign_reserves` | IMF dataset | **ADD** | Foreign Forex Reserves (USD) |

### Category 3: Environment (`environment`) — Target: 12 Subcategories
| # | Subcategory Name | Subcategory ID | Status in App | Action | Core Indicator / Dataset |
|---|---|---|---|---|---|
| 1 | Air Pollution | `env_air_pollution` | Exists (`co2_per_capita`) | **IMPROVE** | PM2.5 Air Pollution |
| 2 | Water Resources | `env_water_resources` | FAO AquaStat | **ADD** | Renewable Freshwater Resources |
| 3 | Water Quality | `env_water_quality` | WHO WASH | **ADD** | Safely Managed Drinking Water |
| 4 | Forests | `env_forests` | Exists (`forest_area_pct`) | **IMPROVE** | Forest Area % of Land |
| 5 | Biodiversity | `env_biodiversity` | IUCN Red List | **ADD** | Threatened Species Count |
| 6 | Wildlife | `env_wildlife` | WWF Living Planet | **ADD** | Wildlife Habitat Index |
| 7 | Land and Soil | `env_land_soil` | FAOSTAT Land | **ADD** | Soil Degradation & Land Use |
| 8 | Waste Management | `env_waste` | World Bank What a Waste | **ADD** | Municipal Solid Waste per Capita |
| 9 | Marine Environment | `env_marine` | Ocean Health Index | **ADD** | Marine Protected Areas % |
| 10 | Natural Resources | `env_natural_resources` | World Bank Wealth of Nations | **ADD** | Natural Resources Depletion % |
| 11 | Protected Areas | `env_protected_areas` | UNEP-WCMC | **ADD** | Terrestrial Protected Areas % |
| 12 | Ecological Footprint | `env_ecological_footprint` | Global Footprint Network | **ADD** | Global Hectares per Person |

### Category 4: Health (`health`) — Target: 12 Subcategories
| # | Subcategory Name | Subcategory ID | Status in App | Action | Core Indicator / Dataset |
|---|---|---|---|---|---|
| 1 | Life Expectancy | `health_life_expectancy` | Exists (`life_expectancy`) | **IMPROVE** | Healthy Life Expectancy (HALE) |
| 2 | Infant and Child Health | `health_infant_child` | Exists (`mortality_under5`) | **IMPROVE** | Under-5 Mortality Rate / 1k |
| 3 | Maternal Health | `health_maternal` | WHO GHO | **ADD** | Maternal Mortality Ratio / 100k |
| 4 | Diseases | `health_diseases` | WHO GHO | **ADD** | Non-communicable Disease Burden |
| 5 | Causes of Death | `health_causes_death` | IHME GBD | **ADD** | Leading Mortality Causes |
| 6 | Healthcare Infrastructure | `health_infrastructure` | WHO GHO | **ADD** | Hospital Beds per 1,000 |
| 7 | Medical Workforce | `health_workforce` | WHO GHO | **ADD** | Physicians per 1,000 |
| 8 | Health Expenditure | `health_expenditure` | Exists (`health_expenditure_gdp`) | **IMPROVE** | Current Health Spend % of GDP |
| 9 | Vaccination | `health_vaccination` | WHO/UNICEF | **ADD** | DTP3 & Measles Coverage % |
| 10 | Nutrition | `health_nutrition` | UNICEF/WHO | **ADD** | Child Stunting & Obesity % |
| 11 | Mental Health | `health_mental_health` | WHO Mental Health Atlas | **ADD** | Suicide Rate / 100k |
| 12 | Sanitation and Hygiene | `health_sanitation` | WHO/UNICEF JMP | **ADD** | Basic Sanitation Access % |

### Category 5: Education (`education`) — Target: 12 Subcategories
| # | Subcategory Name | Subcategory ID | Status in App | Action | Core Indicator / Dataset |
|---|---|---|---|---|---|
| 1 | Literacy | `edu_literacy` | Exists (`literacy_rate`) | **IMPROVE** | Adult & Youth Literacy % |
| 2 | Primary Education | `edu_primary` | UNESCO UIS | **ADD** | Primary Net Enrollment % |
| 3 | Secondary Education | `edu_secondary` | UNESCO UIS | **ADD** | Secondary Gross Enrollment % |
| 4 | Higher Education | `edu_higher` | Exists (`tertiary_enrollment`) | **IMPROVE** | Tertiary Gross Enrollment % |
| 5 | Education Spending | `edu_spending` | Exists (`education_expenditure`) | **IMPROVE** | Govt Education Spend % of GDP |
| 6 | Teachers | `edu_teachers` | UNESCO UIS | **ADD** | Pupil-Teacher Ratio |
| 7 | Gender Equality | `edu_gender_equality` | UNESCO UIS | **ADD** | Gender Parity Index |
| 8 | School Infrastructure | `edu_infrastructure` | UNESCO UIS | **ADD** | Schools with Electricity/Internet |
| 9 | Learning Outcomes | `edu_outcomes` | OECD PISA / World Bank | **ADD** | Harmonized Learning Outcomes |
| 10 | Vocational Education | `edu_vocational` | UNESCO-UNEVOC | **ADD** | TVET Enrollment Share % |
| 11 | Research Education | `edu_research` | UNESCO Science | **ADD** | PhD Graduates per Million |
| 12 | Education Access | `edu_access` | UNESCO UIS | **ADD** | Out-of-School Children Rate |

### Categories 6-20 Subcategory Summary
All 20 domains follow this exact standardized structure:
* **Technology (12)**: Internet Access, Mobile Connectivity, Broadband, 5G and Networks, Artificial Intelligence, Cybersecurity, Digital Government, Innovation, Patents and IP, R&D, Robotics and Automation, Technology Exports.
* **Military (12)**: Defence Budget, Military Personnel, Army, Air Force, Navy, Nuclear Weapons, Arms Exports, Arms Imports, Defence Industry, Military Alliances, Peace and Conflict, Military Rankings.
* **Global Indices (14)**: Human Development, Happiness, Peace, Corruption, Innovation, Democracy, Press Freedom, Gender Equality, Economic Freedom, Passport Strength, Quality of Life, Rule of Law, Environmental Performance, Competitiveness.
* **Geography (14)**: Countries and Territories, Continents and Regions, Country Area, Mountains, Rivers, Lakes, Oceans and Seas, Deserts, Islands, Borders, Coordinates, Time Zones, Natural Wonders, Earth Structure.
* **Tourism (12)**: Tourist Arrivals, Tourism Revenue, Tourism Economy, Most Visited Countries, Popular Cities, UNESCO Heritage Sites, Natural Destinations, Travel Costs, Visa Access, Airports, Hotels and Accommodation, Cruise Tourism.
* **Energy (15)**: Energy Production, Energy Consumption, Electricity Generation, Renewable Energy, Solar Energy, Wind Energy, Hydropower, Nuclear Energy, Coal, Oil, Natural Gas, Electricity Access, Electricity Prices, Energy Trade, Energy Efficiency.
* **Agriculture (14)**: Crop Production, Food Production, Livestock, Fisheries, Agricultural Land, Irrigation, Food Security, Food Prices, Agricultural Exports, Fertilisers, Farm Productivity, Organic Farming, Food Loss and Waste, Agricultural Employment.
* **Politics (14)**: Political Systems, Government Structure, Heads of State, Heads of Government, Parliaments, Elections, Political Parties, Women in Government, Governance, Corruption, Public Services, International Memberships, Treaties and Agreements, Administrative Divisions.
* **Infrastructure (15)**: Roads, Highways, Railways, High-Speed Rail, Airports, Seaports, Public Transport, Bridges and Tunnels, Electricity Infrastructure, Water Infrastructure, Internet Infrastructure, Logistics, Urban Infrastructure, Construction, Housing.
* **Climate (14)**: Temperature, Global Warming, Rainfall, Snowfall, Drought, Floods, Cyclones, Extreme Weather, Sea Level, Glaciers, Polar Ice, Greenhouse Gases, Climate Risk, Climate Projections.
* **Employment (15)**: Labour Force, Employment Rate, Unemployment, Youth Employment, Wages and Salaries, Working Hours, Labour Participation, Gender Gap, Employment by Sector, Informal Employment, Migrant Workers, Productivity, Occupational Safety, Social Protection, Child Labour.
* **Science (15)**: Research Spending, Researchers, Scientific Publications, Citations, Scientific Patents, Space Exploration, Satellites, Astronomy, Biotechnology, Medical Research, Physics and Chemistry, Engineering, Nobel Prizes, Research Infrastructure, International Collaboration.
* **Sports (15)**: Olympic Games, Paralympic Games, Football, Cricket, Basketball, Tennis, Badminton, Hockey, Athletics, Swimming, Other Sports, World Records, Sports Participation, Stadiums, Historical Champions.
* **City Rankings (15)**: Largest Cities, City Population Growth, Population Density, Economic Cities, Cost of Living, Quality of Life, Smart Cities, Cleanest Cities, Green Cities, City Transport, Housing, Safety, Tourism, Skyscrapers, Urbanisation.
* **UN SDG Goals (17)**: The 17 official United Nations Sustainable Development Goals (SDG 1 through SDG 17).

Total Subcategories Catalogued: **274 subcategories**.
