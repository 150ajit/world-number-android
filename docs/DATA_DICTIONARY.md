# World Number - Central Data Dictionary
**Document Version:** 1.0.0  
**Domains Covered:** 20 Global Categories  

---

## 1. Domain & Entity Schema Definitions

### Categories Table (`categories`)
| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | TEXT | PRIMARY KEY | Unique lowercase slug (e.g. `population`, `economy`) |
| `name` | TEXT | NOT NULL | Human-readable title (e.g. "Population", "Economy") |
| `orderIndex` | INTEGER | NOT NULL | Display sort order (1 to 20) |
| `iconKey` | TEXT | NOT NULL | Material icon mapping key |
| `headlineStatistic` | TEXT | NOT NULL | Featured live statistic banner |
| `summary` | TEXT | NOT NULL | High-level summary of covered indicators |
| `sourceOrganization` | TEXT | NOT NULL | Primary authoritative source attribution |

### Subcategories Table (`subcategories`)
| Column | Type | Constraints | Description |
|---|---|---|---|
| `id` | TEXT | PRIMARY KEY | Subcategory code (e.g. `pop_density`, `eco_gdp_nominal`) |
| `categoryId` | TEXT | INDEX, NOT NULL | Owning category ID |
| `name` | TEXT | NOT NULL | Standard subcategory title |
| `description` | TEXT | NOT NULL | Domain definition and scope |
| `orderIndex` | INTEGER | NOT NULL | Display sort order within category |
| `iconKey` | TEXT | NULLABLE | Thematic subcategory icon key |

### Category Indicators Table (`category_indicators`)
| Column | Type | Constraints | Description |
|---|---|---|---|
| `indicatorId` | TEXT | PRIMARY KEY | Canonical indicator ID (e.g. `gdp_nominal`) |
| `categoryId` | TEXT | INDEX, NOT NULL | Parent category ID |
| `subcategoryId` | TEXT | NULLABLE | Parent subcategory ID |
| `name` | TEXT | NOT NULL | Metric title (e.g. "Nominal GDP") |
| `unit` | TEXT | NOT NULL | Measurement unit (e.g. "Billion USD", "%", "Years") |
| `sortDirection` | TEXT | NOT NULL | "ASC" or "DESC" for ranking |
| `sourceName` | TEXT | NOT NULL | Publishing institution attribution |

### Country Indicator Values Table (`country_indicator_values`)
| Column | Type | Constraints | Description |
|---|---|---|---|
| `isoCode` | TEXT | PK (Part 1) | ISO 3166-1 alpha-3 code |
| `indicatorId` | TEXT | PK (Part 2) | Foreign key to indicator |
| `categoryId` | TEXT | INDEX, NOT NULL | Foreign key to category |
| `year` | INTEGER | NOT NULL | Reference observation year (e.g. 2024) |
| `value` | REAL | NOT NULL | Numeric observation |
| `formattedValue` | TEXT | NULLABLE | Pre-formatted string with suffix (e.g. "1.45B") |
| `globalRank` | INTEGER | NULLABLE | World ranking position |
| `status` | TEXT | DEFAULT 'OBSERVED'| OBSERVED, ESTIMATE, PROJECTION |
