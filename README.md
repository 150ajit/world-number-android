# Live World Population 🌍

A real-time global demographics intelligence suite featuring an Android native application and an interactive Web dashboard. Powered by data from the **United Nations World Population Prospects (UN WPP)** and **World Bank Development Indicators**.

---

## 📱 Project Structure

```text
Live Worl Population/
├── app/                      # Android Native Application (Kotlin + Jetpack Compose)
│   ├── src/main/java/        # Clean Architecture (Data, Domain, Presentation, DI)
│   ├── src/main/res/         # Material 3 Themes, Drawables, Strings
│   └── build.gradle.kts      # Android Build Config (SDK 35, Jetpack Compose, Hilt)
├── World population web/     # Interactive Web Application & Analytics Dashboard
│   ├── index.html            # Dashboard UI Layout & SVG Choropleth Map
│   ├── styles.css            # Responsive Dark Glassmorphism Design
│   ├── app.js                # Core App Logic & State Management
│   ├── engine.js             # High-Precision Population Calculation Engine
│   ├── data.js               # Demographic Dataset (1950–2100 Projections)
│   └── package.json          # Web Tooling & Scripts
├── build.gradle.kts          # Root Gradle Build Configuration
├── settings.gradle.kts       # Gradle Project Settings
└── README.md
```

---

## ✨ Features

### 🤖 Android Native App
- **Real-Time Rolling Odometer**: High-precision continuous estimation model ticking live births, deaths, and net population growth.
- **Modern Jetpack Compose & Material 3**: Dynamic theming, smooth animations, and edge-to-edge design.
- **Clean Architecture & MVVM**: Layered data, domain, and presentation with Dagger Hilt dependency injection.
- **Offline-First & Caching**: Room local database sync with UN WPP API endpoints.
- **Historical & Future Projections**: Interactive charts tracking population trends from 1950 to 2100.
- **Demographic Breakdown**: 5-year age cohort pyramids, median age, fertility rates, and life expectancy.

### 🌐 Web Dashboard (`World population web`)
- **Real-Time Live Counter**: Smooth odometer animation supporting International (`8,318,643,704`), Indian (`8,31,86,43,704`), and Compact (`8.32B`) notation.
- **Today's Live Estimates**: Live counters for births, deaths, and net growth since 00:00 UTC.
- **Interactive SVG Choropleth Map**: Dynamic density gradients, tooltips, and country profile modals.
- **Country Rankings & Search**: Instant search and filtering across 26+ major countries and all continental regions.
- **Side-by-Side Comparison**: Synchronized demographic comparison between any two nations.
- **Time Machine Slider (1950–2100)**: Scrub across past and future UN projections or play back simulated timelines.

---

## 🛠️ Tech Stack

### Android
- **Language**: Kotlin 2.0+ (JVM 21)
- **UI Toolkit**: Jetpack Compose & Material 3
- **Architecture**: MVVM, Clean Architecture, Kotlin Coroutines & StateFlow
- **DI**: Dagger Hilt
- **Persistence**: Room Database
- **Networking**: Retrofit, OkHttp, Moshi / Serialization
- **Min SDK**: 24 (Android 7.0) | **Target SDK**: 35 (Android 15)

### Web
- **Frontend**: Vanilla HTML5, CSS3 (Glassmorphism, CSS Custom Properties), JavaScript (ES2022+)
- **Visualizations**: Chart.js, Interactive SVG Map
- **Data Source**: UN WPP 2024 Revision & World Bank Open Data

---

## 🚀 Getting Started

### Android App
1. Open the project in Android Studio (Ladybug or later).
2. Sync the project with Gradle files.
3. Run on an Android Emulator or physical device running Android 7.0 (API 24) or higher.

### Web Dashboard
1. Open `World population web/index.html` directly in any modern web browser, or serve locally:
   ```bash
   cd "World population web"
   npx serve .
   ```
2. Open `http://localhost:3000` to interact with the live dashboard.

---

## 📄 License
This project is open-source and available under standard development licenses. Data courtesy of UN Population Division and World Bank.
