# World Number - Subcategory & Indicator Canonical Mapping Registry
**Date:** November 23, 2026  
**Document Version:** 1.0.0  

---

## 1. Central Canonical Registry & Deduplication Strategy

To prevent independent indicator duplication across related domains, World Number enforces a canonical indicator registry. When the underlying scientific methodology and data units are identical, one canonical indicator ID is assigned. The subcategory metadata references this shared definition.

### Cross-Domain Canonical Indicator Mappings

| Indicator Concept | Canonical ID | Primary Category / Subcategory | Secondary Category / Subcategory | Authoritative Source | Unit |
|---|---|---|---|---|---|
| **Life Expectancy at Birth** | `health_life_expectancy` | `health` / `health_life_expectancy` | `population` / `pop_life_expectancy` | UN DESA WPP / WHO GHO | Years |
| **Renewable Energy Share** | `energy_renewable_share` | `energy` / `energy_renewable` | `un_sdg_goals` / `sdg_clean_energy` | IEA / Ember / UN SDSN | % of total electricity |
| **CO₂ Emissions per Capita** | `env_co2_per_capita` | `environment` / `env_air_pollution` | `climate` / `climate_ghg` | Global Carbon Project / EDGAR | Metric Tonnes / Capita |
| **R&D Expenditure (% GDP)** | `sci_rnd_expenditure_gdp`| `science` / `sci_research_spending` | `technology` / `tech_rd` | UNESCO UIS / WIPO GII | % of GDP |
| **Total Population** | `pop_total` | `population` / `pop_total_pop` | `geography` / `geo_countries` | UN DESA WPP 2024 | Persons |
| **Forest Coverage %** | `env_forest_area_pct` | `environment` / `env_forests` | `un_sdg_goals` / `sdg_life_on_land` | FAO Global Forest Assessment | % of Land Area |
| **Human Development Index** | `hdi_score` | `global_indices` / `idx_human_dev` | `education` / `edu_outcomes` | UNDP HDR 2024 | Index (0 - 1.0) |
| **Unemployment Rate** | `emp_unemployment_rate` | `employment` / `emp_unemployment` | `economy` / `eco_poverty_inequality`| ILO ILOSTAT | % of Labor Force |

---

## 2. Subcategory Identifier Convention

All subcategory IDs follow the strict convention: `<cat_abbr>_<subcategory_slug>`:

| Category ID | Prefix | Example Subcategory ID | Name |
|---|---|---|---|
| `population` | `pop_` | `pop_total_pop` | Total Population |
| `economy` | `eco_` | `eco_gdp_nominal` | GDP (Nominal) |
| `environment` | `env_` | `env_air_pollution` | Air Pollution |
| `health` | `health_` | `health_infant_child` | Infant and Child Health |
| `education` | `edu_` | `edu_literacy` | Literacy |
| `technology` | `tech_` | `tech_internet_access`| Internet Access |
| `military` | `mil_` | `mil_defence_budget` | Defence Budget |
| `global_indices` | `idx_` | `idx_human_dev` | Human Development |
| `geography` | `geo_` | `geo_countries` | Countries and Territories |
| `tourism` | `tour_` | `tour_arrivals` | Tourist Arrivals |
| `energy` | `energy_` | `energy_renewable` | Renewable Energy |
| `agriculture` | `agri_` | `agri_crop_production` | Crop Production |
| `politics` | `pol_` | `pol_systems` | Political Systems |
| `infrastructure` | `infra_` | `infra_roads` | Roads & Highway Networks |
| `climate` | `clim_` | `clim_temperature` | Temperature & Anomaly |
| `employment` | `emp_` | `emp_labour_force` | Labour Force |
| `science` | `sci_` | `sci_research_spending`| Research Spending |
| `sports` | `sports_` | `sports_olympics` | Olympic Games |
| `city_rankings` | `city_` | `city_largest` | Largest Cities |
| `un_sdg_goals` | `sdg_` | `sdg_01_no_poverty` | SDG 1: No Poverty |

---

## 3. Database Migration & Entity Linkage

In the Room Database:
1. `categories.id` is the primary key of the domain.
2. `subcategories.id` is the primary key of the subcategory, with foreign reference `categoryId`.
3. `category_indicators.subcategoryId` links every indicator to its owning subcategory.
4. `country_indicator_values.indicatorId` links observations to the canonical indicator.

This establishes complete referential integrity across the entire World Number statistical graph.
