# World Population Live — Web Application 🌍

A real-time, interactive, and comprehensive World Population Dashboard built with modern Vanilla HTML5, Vanilla CSS3, and JavaScript, powered by the **United Nations World Population Prospects (UN WPP) 2024 Revision** and **World Bank Development Indicators**.

---

## ✨ Features

- **⚡ Real-Time Live Rolling Ticker (Odometer)**:
  - High-precision continuous estimation model (71.5M annual net growth, ~2.25 net births/second).
  - Smooth rolling digit animation that stays on a single line with zero horizontal jitter or overlap.
  - Supports **International (`8,318,643,704`)**, **Indian Lakhs/Crores (`8,31,86,43,704`)**, and **Compact (`8.32B`)** formats.
- **📊 Daily Live Estimates (Since 00:00 UTC)**:
  - Real-time ticker for **Births Today** (+4.21/sec).
  - Real-time ticker for **Deaths Today** (-1.96/sec).
  - Real-time ticker for **Net Population Growth Today** (+2.25/sec).
  - Countdown and status callout toward humanity's 9 Billion milestone (~2037) and 10.3 Billion peak (~2084).
- **📋 Top Countries Table**:
  - Live ticking population count for all 26 top countries.
  - Search filter (country name, ISO, capital, native name).
  - Region filters: Asia, Africa, Europe, Americas, Oceania.
  - Sortable by Rank, Country Name, Live Population, Annual Growth Rate %, World Share %, Density, Fertility, and Median Age.
  - Click any row to open the in-depth Country Details Modal.
- **🗺️ Interactive Choropleth World Map**:
  - Interactive SVG World Map with dynamic population density gradients.
  - Hover tooltips showing live population, global rank, and share of humanity.
  - Click any country on the map to jump directly into its demographic profile.
- **📈 Historical & Projected Timeline (1950 – 2100)**:
  - Interactive Chart.js charts showcasing historical data (1950–2024) and UN medium variant projections up to 2100.
  - Toggle between Total Population and Annual Growth Rate % trajectory.
  - Humanity's Milestones cards (1 Billion in 1804 through 10.3 Billion peak in 2084).
- **🔺 5-Year Age Cohort Population Pyramid**:
  - Interactive bidirectional horizontal bar chart for 21 age brackets (0-4 to 100+).
  - Comparison by gender: Male (Cyan) vs Female (Rose).
  - Switch between World, India, China, USA, Japan, and Nigeria.
  - Displays key indicators: Total Fertility Rate (TFR), Median Age, Life Expectancy at Birth, and Urbanization Share.
- **⚖️ Side-by-Side Country Comparison**:
  - Compare two countries simultaneously with live synchronized counters.
  - Compare Rank, Density, Annual Growth, World Share %, Fertility, Median Age, and Life Expectancy.
  - Comparative historical & projected trajectory chart.
- **⏳ Year Time Machine Slider**:
  - Drag the slider between 1950 and 2100 to simulate past and future global populations.
  - One-click "Live Now" reset button.
- **🎮 Simulation Speed Controls**:
  - Real-time 1x, 10x speed, 60x speed, and Pause.

---

## 🚀 How to Run

### Option 1: Direct in Browser
Simply double-click [`index.html`](file:///c:/Users/Admin/.gemini/antigravity/scratch/Live%20Worl%20Population/World%20population%20web/index.html) to open the application in any modern web browser (Google Chrome, Microsoft Edge, Firefox, Safari).

### Option 2: Local HTTP Server (Node.js)
In this directory, run:
```bash
npx -y serve . -l 3000
```
Then open `http://localhost:3000` in your web browser.

### Option 3: Python Built-in Server
```bash
python -m http.server 3000
```
Then open `http://localhost:3000` in your browser.

---

## 📁 Project Structure

```
World population web/
├── index.html       # Semantic HTML5 layout, controls, hero card, tabs & modal
├── styles.css       # Vanilla CSS3 design system, dark mode, glassmorphism, animations
├── data.js          # Authoritative UN WPP 2024 dataset, countries, timelines, pyramids
├── engine.js        # High-precision live calculation engine & number formatting
├── app.js           # UI controller, rolling odometer, SVG map, charts, filters
├── package.json     # Node script configuration
└── README.md        # Documentation
```
