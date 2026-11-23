# World Number - Project Master Plan
**Project:** World Number Autonomous Platform  
**Target:** 20 Global Categories, 274 Subcategories, Authoritative Datasets, Offline-First UI  
**Execution Mode:** End-to-End Delivery  
**Date:** November 23, 2026  

---

## 1. Master Milestone Roadmap

| Milestone | Scope & Deliverables | Owner | Status |
|---|---|---|---|
| **M1: System Audit** | Inspect existing architecture, Room schemas, asset files, and create audit docs | Chief Software Architect | **COMPLETE** |
| **M2: Information Architecture** | Define 274-subcategory catalog, canonical registry, and mapping rules | Chief Data Officer | **COMPLETE** |
| **M3: Database & Data Models** | Create `SubcategoryEntity`, `SubcategoryDao`, bump DB version to 9, update Room | Navigation & DB Engineer | **IN PROGRESS** |
| **M4: Pre-Compiled Offline Catalogs** | Implement `DefaultSubcategories.kt` and `assets/data/subcategories.json` | Data Pipeline Engineer | **PENDING** |
| **M5: UI & Navigation Expansion** | Build `SubcategoryDetailScreen`, `IndicatorDetailScreen`, update `CategoryDetailScreen` | UI Component Engineer | **PENDING** |
| **M6: Visualizations & Comparisons** | Integrate dynamic ranking bars, comparison chips, and indicator cards | Visualization Engineer | **PENDING** |
| **M7: Testing & Verification** | Execute full unit test suite and verify offline performance | Chief Quality Officer | **PENDING** |
| **M8: Signed Binary Delivery** | Assemble release APK & AAB, verify signatures, commit and push | Release Engineer | **PENDING** |

---

## 2. Risk Mitigation & Technical Commitments

1. **JVM Method Bytecode Limits**:
   Static datasets must never be compiled into giant single Kotlin methods (>65KB). All pre-compiled baseline records are split into concise chunks or read from asset JSON streams.
2. **Offline-First Guarantee**:
   All 20 categories, 274 subcategories, and 198 countries must render instantaneously on a clean device with zero internet connectivity.
3. **Database Migration Safety**:
   Database version bumped to 9 with destructive fallback enabled so development installs cleanly rebuild the schema while preserving fresh asset seeding.
4. **Referential Integrity**:
   Every subcategory references a valid `categoryId`, and every indicator links to its parent subcategory and category.
