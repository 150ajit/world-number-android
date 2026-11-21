/**
 * World Population Web Application Main Controller
 * Orchestrates live odometer tickers, interactive maps, Chart.js graphs, tables, and modal
 */

document.addEventListener('DOMContentLoaded', () => {
  // Application State
  const state = {
    numberFormat: 'INTERNATIONAL', // 'INTERNATIONAL' | 'INDIAN' | 'COMPACT'
    activeTab: 'tab-table',
    searchQuery: '',
    selectedRegion: 'ALL',
    sortField: 'rank',
    sortAsc: true,
    selectedCountryModal: null,
    compareCountryA: 'IND',
    compareCountryB: 'CHN',
    timelineMetric: 'population', // 'population' | 'growth'
    pyramidCountry: 'IND',
    currentYear: 2026,
    isTimeMachine: false
  };

  // Chart instances
  let timelineChartInstance = null;
  let pyramidChartInstance = null;
  let compareChartInstance = null;
  let modalChartInstance = null;

  // Cache DOM Elements
  const worldTickerContainer = document.getElementById('world-ticker-container');
  const valBirthsToday = document.getElementById('val-births-today');
  const valDeathsToday = document.getElementById('val-deaths-today');
  const valGrowthToday = document.getElementById('val-growth-today');
  const utcClockText = document.getElementById('utc-clock-text');
  const countriesTableBody = document.getElementById('countries-table-body');
  const countrySearchInput = document.getElementById('country-search-input');
  const regionFilterButtons = document.getElementById('region-filter-buttons');
  const mainViewTabs = document.getElementById('main-view-tabs');
  const yearSlider = document.getElementById('year-slider');
  const timeMachineYearVal = document.getElementById('time-machine-year-val');
  const btnResetNow = document.getElementById('btn-reset-now');
  const countryModal = document.getElementById('country-modal');
  const modalCloseBtn = document.getElementById('modal-close-btn');

  /* ========================================================================
     1. ROLLING ODOMETER TICKER COMPONENT
     ======================================================================== */
  let currentFormattedString = '';

  function updateOdometer(formattedStr) {
    if (formattedStr === currentFormattedString) return;

    // If format or length changed drastically, rebuild slots
    const needsFullRebuild = 
      worldTickerContainer.children.length !== formattedStr.length ||
      [...formattedStr].some((ch, i) => {
        const slot = worldTickerContainer.children[i];
        if (!slot) return true;
        const isSep = slot.classList.contains('separator-slot');
        return isSep !== !/\d/.test(ch);
      });

    if (needsFullRebuild) {
      worldTickerContainer.innerHTML = '';
      for (let i = 0; i < formattedStr.length; i++) {
        const ch = formattedStr[i];
        if (/\d/.test(ch)) {
          const slot = document.createElement('div');
          slot.className = 'digit-slot';
          slot.dataset.index = i;

          const roller = document.createElement('div');
          roller.className = 'digit-roller';
          for (let d = 0; d <= 9; d++) {
            const digitChar = document.createElement('div');
            digitChar.className = 'digit-char';
            digitChar.textContent = d;
            roller.appendChild(digitChar);
          }
          slot.appendChild(roller);
          worldTickerContainer.appendChild(slot);
        } else {
          const sep = document.createElement('span');
          sep.className = 'separator-slot';
          sep.textContent = ch;
          worldTickerContainer.appendChild(sep);
        }
      }
    }

    // Translate each roller to the correct digit
    for (let i = 0; i < formattedStr.length; i++) {
      const ch = formattedStr[i];
      if (/\d/.test(ch)) {
        const slot = worldTickerContainer.children[i];
        if (slot) {
          const roller = slot.querySelector('.digit-roller');
          if (roller) {
            const digit = parseInt(ch, 10);
            roller.style.transform = `translateY(-${digit * (100 / 10)}%)`;
          }
        }
      }
    }

    currentFormattedString = formattedStr;
  }

  /* ========================================================================
     2. REAL-TIME TICKER SUBSCRIBER & DOM UPDATES
     ======================================================================== */
  function onEngineTick(engineState) {
    // 1. Format and update main world counter
    const formattedWorld = PopulationEngine.formatNumber(
      engineState.worldPopulation,
      state.numberFormat
    );
    updateOdometer(formattedWorld);

    // 2. Format today's figures
    if (valBirthsToday) {
      valBirthsToday.textContent = `+${PopulationEngine.formatNumber(engineState.birthsToday, state.numberFormat)}`;
    }
    if (valDeathsToday) {
      valDeathsToday.textContent = `-${PopulationEngine.formatNumber(engineState.deathsToday, state.numberFormat)}`;
    }
    if (valGrowthToday) {
      valGrowthToday.textContent = `+${PopulationEngine.formatNumber(engineState.growthToday, state.numberFormat)}`;
    }

    // 3. UTC Live Clock
    const d = new Date(engineState.timestamp);
    const utcHours = String(d.getUTCHours()).padStart(2, '0');
    const utcMins = String(d.getUTCMinutes()).padStart(2, '0');
    const utcSecs = String(d.getUTCSeconds()).padStart(2, '0');
    if (utcClockText) {
      utcClockText.textContent = `${utcHours}:${utcMins}:${utcSecs} UTC`;
    }

    // 4. Update country table populations in real time
    if (state.activeTab === 'tab-table' && engineState.countryPops) {
      updateTableLivePopulations(engineState.countryPops);
    }

    // 5. Update open modal counter if visible
    if (state.selectedCountryModal && engineState.countryPops) {
      const livePop = engineState.countryPops[state.selectedCountryModal.iso];
      if (livePop) {
        const modalPopElem = document.getElementById('modal-country-pop');
        if (modalPopElem) {
          modalPopElem.textContent = PopulationEngine.formatNumber(livePop, state.numberFormat);
        }
      }
    }

    // 6. Update compare view live values if active
    if (state.activeTab === 'tab-compare' && engineState.countryPops) {
      updateCompareLiveValues(engineState.countryPops);
    }
  }

  // Subscribe to engine
  window.populationEngine.subscribe(onEngineTick);

  /* ========================================================================
     3. TABLE VIEW (TOP COUNTRIES RANKING)
     ======================================================================== */
  function getFilteredAndSortedCountries() {
    return COUNTRIES_DATA.filter(c => {
      // Region filter
      if (state.selectedRegion !== 'ALL' && c.continent !== state.selectedRegion) {
        return false;
      }
      // Search query
      if (state.searchQuery.trim()) {
        const q = state.searchQuery.toLowerCase();
        return (
          c.name.toLowerCase().includes(q) ||
          c.nativeName.toLowerCase().includes(q) ||
          c.subregion.toLowerCase().includes(q) ||
          c.iso.toLowerCase().includes(q)
        );
      }
      return true;
    }).sort((a, b) => {
      let valA = a[state.sortField];
      let valB = b[state.sortField];

      if (state.sortField === 'population') {
        const engineState = window.populationEngine.getCurrentState();
        valA = (engineState.countryPops && engineState.countryPops[a.iso]) || a.population;
        valB = (engineState.countryPops && engineState.countryPops[b.iso]) || b.population;
      }

      if (typeof valA === 'string') {
        return state.sortAsc ? valA.localeCompare(valB) : valB.localeCompare(valA);
      }
      return state.sortAsc ? (valA - valB) : (valB - valA);
    });
  }

  function renderCountriesTable() {
    const list = getFilteredAndSortedCountries();
    const engineState = window.populationEngine.getCurrentState();

    countriesTableBody.innerHTML = list.map(c => {
      const livePop = (engineState.countryPops && engineState.countryPops[c.iso]) || c.population;
      const formattedPop = PopulationEngine.formatNumber(livePop, state.numberFormat);
      const isPositive = c.growthRate >= 0;
      const growthSign = isPositive ? '+' : '';
      const growthClass = isPositive ? 'positive' : 'negative';

      return `
        <tr data-iso="${c.iso}" class="country-row" title="Click to view ${c.name} demographics">
          <td style="font-weight:700; color:var(--text-muted);">${c.rank}</td>
          <td>
            <div class="country-cell">
              <span class="country-flag">${c.flag}</span>
              <div>
                <div class="country-name">${c.name}</div>
                <div class="country-subregion">${c.subregion}</div>
              </div>
            </div>
          </td>
          <td class="pop-mono" data-country-pop="${c.iso}">${formattedPop}</td>
          <td>
            <span class="growth-badge ${growthClass}">
              ${growthSign}${c.growthRate.toFixed(2)}%
            </span>
          </td>
          <td>
            <div class="share-bar-cell">
              <div class="share-bar">
                <div class="share-fill" style="width: ${Math.min(100, (c.worldShare / 18) * 100)}%;"></div>
              </div>
              <span style="font-size:0.8rem; font-weight:600;">${c.worldShare.toFixed(1)}%</span>
            </div>
          </td>
          <td style="font-family:var(--font-mono);">${c.density.toFixed(1)}</td>
          <td style="font-weight:700; color:${c.fertilityRate < 2.1 ? '#F43F5E' : '#10B981'};">
            ${c.fertilityRate.toFixed(2)}
          </td>
          <td>${c.medianAge.toFixed(1)} yrs</td>
          <td>
            <button class="control-btn view-detail-btn" data-iso="${c.iso}" style="background:var(--bg-surface); padding:4px 10px; font-size:0.75rem;">
              View Details
            </button>
          </td>
        </tr>
      `;
    }).join('');

    // Attach click listeners to rows & buttons
    countriesTableBody.querySelectorAll('.country-row').forEach(row => {
      row.addEventListener('click', (e) => {
        const iso = row.dataset.iso;
        const country = COUNTRIES_DATA.find(x => x.iso === iso);
        if (country) openCountryModal(country);
      });
    });
  }

  function updateTableLivePopulations(countryPops) {
    for (const [iso, pop] of Object.entries(countryPops)) {
      const cell = countriesTableBody.querySelector(`[data-country-pop="${iso}"]`);
      if (cell) {
        cell.textContent = PopulationEngine.formatNumber(pop, state.numberFormat);
      }
    }
  }

  // Search input handler
  if (countrySearchInput) {
    countrySearchInput.addEventListener('input', (e) => {
      state.searchQuery = e.target.value;
      renderCountriesTable();
    });
  }

  // Region filter handler
  if (regionFilterButtons) {
    regionFilterButtons.querySelectorAll('.filter-btn').forEach(btn => {
      btn.addEventListener('click', () => {
        regionFilterButtons.querySelectorAll('.filter-btn').forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
        state.selectedRegion = btn.dataset.region;
        renderCountriesTable();
      });
    });
  }

  // Table header sort handlers
  document.querySelectorAll('#countries-table th[data-sort]').forEach(th => {
    th.addEventListener('click', () => {
      const field = th.dataset.sort;
      if (state.sortField === field) {
        state.sortAsc = !state.sortAsc;
      } else {
        state.sortField = field;
        state.sortAsc = field === 'rank' || field === 'name';
      }

      document.querySelectorAll('#countries-table th').forEach(h => {
        h.classList.remove('sorted-asc', 'sorted-desc');
      });
      th.classList.add(state.sortAsc ? 'sorted-asc' : 'sorted-desc');

      renderCountriesTable();
    });
  });

  /* ========================================================================
     4. INTERACTIVE CHOROPLETH WORLD MAP
     ======================================================================== */
  function initWorldMap() {
    const svg = document.getElementById('world-svg-map');
    const tooltip = document.getElementById('map-tooltip-box');
    const ttName = document.getElementById('tooltip-country-name');
    const ttPop = document.getElementById('tooltip-pop');
    const ttDetails = document.getElementById('tooltip-details');

    if (!svg) return;

    // Stylized world map representation with major nations coordinates & visual polygons
    const countryMapPaths = [
      // North America
      { iso: "CAN", name: "Canada", path: "M 150 70 L 320 60 L 310 130 L 160 135 Z", color: "#0369A1" },
      { iso: "USA", name: "United States", path: "M 155 138 L 310 133 L 300 200 L 170 195 Z", color: "#0284C7" },
      { iso: "MEX", name: "Mexico", path: "M 175 198 L 240 202 L 230 250 L 185 240 Z", color: "#06B6D4" },
      // South America
      { iso: "BRA", name: "Brazil", path: "M 310 260 L 410 270 L 390 380 L 320 370 Z", color: "#0891B2" },
      // Europe
      { iso: "GBR", name: "United Kingdom", path: "M 465 125 L 485 120 L 480 150 L 460 145 Z", color: "#06B6D4" },
      { iso: "FRA", name: "France", path: "M 470 155 L 505 150 L 500 185 L 468 185 Z", color: "#0EA5E9" },
      { iso: "DEU", name: "Germany", path: "M 508 140 L 538 140 L 535 175 L 506 175 Z", color: "#0EA5E9" },
      { iso: "ITA", name: "Italy", path: "M 515 185 L 535 182 L 545 220 L 525 225 Z", color: "#0284C7" },
      { iso: "RUS", name: "Russia", path: "M 545 90 L 880 70 L 860 150 L 550 140 Z", color: "#0284C7" },
      // Africa
      { iso: "EGY", name: "Egypt", path: "M 545 205 L 595 205 L 590 250 L 545 245 Z", color: "#06B6D4" },
      { iso: "NGA", name: "Nigeria", path: "M 480 255 L 525 255 L 520 295 L 480 295 Z", color: "#10B981" },
      { iso: "COD", name: "DR Congo", path: "M 530 290 L 575 290 L 570 340 L 525 335 Z", color: "#059669" },
      { iso: "ETH", name: "Ethiopia", path: "M 585 260 L 625 260 L 620 300 L 580 295 Z", color: "#10B981" },
      { iso: "ZAF", name: "South Africa", path: "M 525 375 L 575 375 L 565 425 L 520 420 Z", color: "#0D9488" },
      // Asia
      { iso: "TUR", name: "Turkey", path: "M 550 178 L 600 175 L 595 200 L 550 200 Z", color: "#0EA5E9" },
      { iso: "IRN", name: "Iran", path: "M 610 185 L 660 185 L 655 230 L 610 225 Z", color: "#06B6D4" },
      { iso: "PAK", name: "Pakistan", path: "M 665 195 L 705 195 L 700 245 L 660 240 Z", color: "#10B981" },
      { iso: "IND", name: "India", path: "M 680 220 L 755 210 L 740 310 L 685 295 Z", color: "#10B981" },
      { iso: "BGD", name: "Bangladesh", path: "M 745 235 L 768 235 L 765 265 L 745 265 Z", color: "#059669" },
      { iso: "CHN", name: "China", path: "M 715 155 L 850 145 L 830 240 L 710 230 Z", color: "#10B981" },
      { iso: "JPN", name: "Japan", path: "M 865 170 L 890 165 L 885 220 L 860 215 Z", color: "#06B6D4" },
      { iso: "KOR", name: "South Korea", path: "M 835 180 L 855 180 L 852 205 L 833 205 Z", color: "#0284C7" },
      { iso: "VNM", name: "Vietnam", path: "M 768 245 L 795 245 L 790 300 L 775 300 Z", color: "#06B6D4" },
      { iso: "PHL", name: "Philippines", path: "M 820 255 L 845 255 L 840 305 L 815 300 Z", color: "#06B6D4" },
      { iso: "IDN", name: "Indonesia", path: "M 770 315 L 880 320 L 870 350 L 765 345 Z", color: "#0D9488" },
      // Oceania
      { iso: "AUS", name: "Australia", path: "M 790 365 L 910 365 L 895 450 L 780 440 Z", color: "#0284C7" }
    ];

    // Background ocean grid
    let svgContent = `
      <rect width="1000" height="500" fill="#080E1C" rx="16"/>
      <path d="M 0 100 L 1000 100 M 0 250 L 1000 250 M 0 400 L 1000 400" stroke="rgba(255,255,255,0.03)" stroke-width="1"/>
      <path d="M 250 0 L 250 500 M 500 0 L 500 500 M 750 0 L 750 500" stroke="rgba(255,255,255,0.03)" stroke-width="1"/>
    `;

    // Render path elements
    countryMapPaths.forEach(item => {
      svgContent += `
        <path d="${item.path}" class="country-path" data-iso="${item.iso}" fill="${item.color}">
          <title>${item.name}</title>
        </path>
      `;
    });

    svg.innerHTML = svgContent;

    // Attach hover & click listeners to map paths
    svg.querySelectorAll('.country-path').forEach(elem => {
      const iso = elem.dataset.iso;
      const country = COUNTRIES_DATA.find(x => x.iso === iso);

      elem.addEventListener('mouseenter', (e) => {
        if (!country) return;
        const engineState = window.populationEngine.getCurrentState();
        const livePop = (engineState.countryPops && engineState.countryPops[iso]) || country.population;

        ttName.textContent = `${country.flag} ${country.name}`;
        ttPop.textContent = PopulationEngine.formatNumber(livePop, state.numberFormat);
        ttDetails.textContent = `Rank #${country.rank} • ${country.worldShare}% World Share • Growth: ${country.growthRate > 0 ? '+' : ''}${country.growthRate}%`;

        tooltip.style.display = 'block';
        updateTooltipPos(e);
      });

      elem.addEventListener('mousemove', (e) => {
        updateTooltipPos(e);
      });

      elem.addEventListener('mouseleave', () => {
        tooltip.style.display = 'none';
      });

      elem.addEventListener('click', () => {
        if (country) openCountryModal(country);
      });
    });

    function updateTooltipPos(e) {
      const containerRect = svg.parentElement.getBoundingClientRect();
      const x = e.clientX - containerRect.left;
      const y = e.clientY - containerRect.top;
      tooltip.style.left = `${x}px`;
      tooltip.style.top = `${y}px`;
    }
  }

  /* ========================================================================
     5. CHART.JS VISUALIZATIONS (TIMELINE, PYRAMID, COMPARISON)
     ======================================================================== */
  function initTimelineChart() {
    const canvas = document.getElementById('timeline-chart-canvas');
    if (!canvas) return;
    renderMilestones();
    if (typeof Chart === 'undefined') return;

    const ctx = canvas.getContext('2d');
    if (timelineChartInstance) timelineChartInstance.destroy();

    const isGrowth = state.timelineMetric === 'growth';
    const datasetData = isGrowth ? TIMELINE_DATA.worldGrowthRate : TIMELINE_DATA.world;

    timelineChartInstance = new Chart(ctx, {
      type: 'line',
      data: {
        labels: TIMELINE_DATA.years.map(y => y.toString()),
        datasets: [
          {
            label: isGrowth ? 'Annual Growth Rate (%)' : 'World Population',
            data: datasetData,
            borderColor: isGrowth ? '#10B981' : '#06B6D4',
            backgroundColor: isGrowth ? 'rgba(16, 185, 129, 0.1)' : 'rgba(6, 182, 212, 0.12)',
            fill: true,
            tension: 0.35,
            borderWidth: 3,
            pointBackgroundColor: '#FFFFFF',
            pointBorderColor: isGrowth ? '#10B981' : '#06B6D4',
            pointRadius: 4,
            pointHoverRadius: 7
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: { display: false },
          tooltip: {
            backgroundColor: '#0F172A',
            titleColor: '#F8FAFC',
            bodyColor: '#38BDF8',
            borderColor: 'rgba(56, 189, 248, 0.3)',
            borderWidth: 1,
            padding: 12,
            callbacks: {
              label: (ctx) => {
                if (isGrowth) return `Annual Growth Rate: ${ctx.raw}%`;
                return `Population: ${PopulationEngine.formatNumber(ctx.raw, state.numberFormat)}`;
              }
            }
          }
        },
        scales: {
          x: {
            grid: { color: 'rgba(255, 255, 255, 0.05)' },
            ticks: { color: '#94A3B8', font: { family: 'Outfit', size: 11 } }
          },
          y: {
            grid: { color: 'rgba(255, 255, 255, 0.05)' },
            ticks: {
              color: '#94A3B8',
              font: { family: 'JetBrains Mono', size: 11 },
              callback: (val) => {
                if (isGrowth) return `${val}%`;
                return `${(val / 1e9).toFixed(1)}B`;
              }
            }
          }
        }
      }
    });

    // Render milestone cards
  }

  function renderMilestones() {
    const container = document.getElementById('milestones-container');
    if (!container) return;

    container.innerHTML = GLOBAL_MILESTONES.map(m => `
      <div class="milestone-item">
        <div class="milestone-year">${m.year}</div>
        <div class="milestone-pop">${m.population} • <span style="color:var(--cyan-accent); font-weight:600;">${m.label}</span></div>
        <div class="milestone-desc">${m.note}</div>
      </div>
    `).join('');
  }

  // Population Pyramid Chart
  function initPyramidChart() {
    const canvas = document.getElementById('pyramid-chart-canvas');
    if (!canvas) return;
    renderPyramidIndicators();
    if (typeof Chart === 'undefined') return;

    const ctx = canvas.getContext('2d');
    if (pyramidChartInstance) pyramidChartInstance.destroy();

    const pyramidData = PYRAMIDS[state.pyramidCountry] || PYRAMIDS.IND;
    // Males on left (represented as negative values for dual horizontal bar), Females on right
    const maleValues = pyramidData.male.map(v => -v);
    const femaleValues = pyramidData.female;

    pyramidChartInstance = new Chart(ctx, {
      type: 'bar',
      data: {
        labels: AGE_BRACKETS,
        datasets: [
          {
            label: 'Male',
            data: maleValues,
            backgroundColor: '#06B6D4',
            borderRadius: 4
          },
          {
            label: 'Female',
            data: femaleValues,
            backgroundColor: '#F43F5E',
            borderRadius: 4
          }
        ]
      },
      options: {
        indexAxis: 'y',
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: {
            position: 'top',
            labels: { color: '#F8FAFC', font: { family: 'Outfit', weight: 'bold' } }
          },
          tooltip: {
            backgroundColor: '#0F172A',
            borderColor: 'rgba(6, 182, 212, 0.4)',
            borderWidth: 1,
            callbacks: {
              label: (ctx) => {
                const rawVal = Math.abs(ctx.raw);
                return `${ctx.dataset.label}: ${rawVal} ${pyramidData.unit}`;
              }
            }
          }
        },
        scales: {
          x: {
            stacked: false,
            grid: { color: 'rgba(255, 255, 255, 0.05)' },
            ticks: {
              color: '#94A3B8',
              font: { family: 'JetBrains Mono', size: 10 },
              callback: (val) => `${Math.abs(val)}M`
            }
          },
          y: {
            grid: { display: false },
            ticks: { color: '#94A3B8', font: { family: 'Outfit', size: 10 } }
          }
        }
      }
    });

    renderPyramidIndicators();
  }

  function renderPyramidIndicators() {
    const grid = document.getElementById('pyramid-indicators-grid');
    if (!grid) return;

    const country = COUNTRIES_DATA.find(c => c.iso === state.pyramidCountry) || {
      fertilityRate: 2.25,
      medianAge: 30.5,
      lifeExpectancy: 73.4,
      urbanPct: 57.5
    };

    grid.innerHTML = `
      <div class="estimate-card" style="padding:1rem;">
        <span class="estimate-title" style="font-size:0.75rem;">Total Fertility Rate</span>
        <div class="estimate-value" style="font-size:1.4rem; color:${country.fertilityRate < 2.1 ? '#F43F5E' : '#10B981'};">
          ${country.fertilityRate.toFixed(2)} births/woman
        </div>
        <span class="estimate-rate">${country.fertilityRate < 2.1 ? 'Below Replacement (2.1)' : 'Above Replacement'}</span>
      </div>

      <div class="estimate-card" style="padding:1rem;">
        <span class="estimate-title" style="font-size:0.75rem;">Median Population Age</span>
        <div class="estimate-value" style="font-size:1.4rem; color:var(--cyan-accent);">
          ${country.medianAge.toFixed(1)} years
        </div>
        <span class="estimate-rate">Global average: 30.5 yrs</span>
      </div>

      <div class="estimate-card" style="padding:1rem;">
        <span class="estimate-title" style="font-size:0.75rem;">Life Expectancy at Birth</span>
        <div class="estimate-value" style="font-size:1.4rem; color:var(--emerald-accent);">
          ${country.lifeExpectancy.toFixed(1)} years
        </div>
        <span class="estimate-rate">UN WPP 2024 projection</span>
      </div>

      <div class="estimate-card" style="padding:1rem;">
        <span class="estimate-title" style="font-size:0.75rem;">Urban Population Share</span>
        <div class="estimate-value" style="font-size:1.4rem; color:#A78BFA;">
          ${country.urbanPct ? country.urbanPct.toFixed(1) : 57.5}%
        </div>
        <span class="estimate-rate">World Bank Development Indicators</span>
      </div>
    `;
  }

  // Country Comparison Charts & Logic
  function initCompareView() {
    const selA = document.getElementById('compare-select-a');
    const selB = document.getElementById('compare-select-b');
    if (!selA || !selB) return;

    selA.innerHTML = COUNTRIES_DATA.map(c => `<option value="${c.iso}" ${c.iso === state.compareCountryA ? 'selected' : ''}>${c.flag} ${c.name}</option>`).join('');
    selB.innerHTML = COUNTRIES_DATA.map(c => `<option value="${c.iso}" ${c.iso === state.compareCountryB ? 'selected' : ''}>${c.flag} ${c.name}</option>`).join('');

    selA.addEventListener('change', (e) => {
      state.compareCountryA = e.target.value;
      updateCompareDetails();
      updateCompareChart();
    });

    selB.addEventListener('change', (e) => {
      state.compareCountryB = e.target.value;
      updateCompareDetails();
      updateCompareChart();
    });

    updateCompareDetails();
    updateCompareChart();
  }

  function updateCompareDetails() {
    const cA = COUNTRIES_DATA.find(c => c.iso === state.compareCountryA) || COUNTRIES_DATA[0];
    const cB = COUNTRIES_DATA.find(c => c.iso === state.compareCountryB) || COUNTRIES_DATA[1];

    const detA = document.getElementById('compare-details-a');
    const detB = document.getElementById('compare-details-b');

    if (detA) detA.innerHTML = buildCompareCardStats(cA, 'compare-val-a');
    if (detB) detB.innerHTML = buildCompareCardStats(cB, 'compare-val-b');
  }

  function buildCompareCardStats(country, popId) {
    const engineState = window.populationEngine.getCurrentState();
    const livePop = (engineState.countryPops && engineState.countryPops[country.iso]) || country.population;

    return `
      <div style="font-family:var(--font-mono); font-size:1.8rem; font-weight:800; color:var(--cyan-accent); margin-bottom:1rem;" id="${popId}">
        ${PopulationEngine.formatNumber(livePop, state.numberFormat)}
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">Global Rank</span>
        <span class="compare-val">#${country.rank}</span>
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">Annual Growth</span>
        <span class="compare-val" style="color:${country.growthRate >= 0 ? 'var(--emerald-accent)' : 'var(--rose-accent)'};">
          ${country.growthRate > 0 ? '+' : ''}${country.growthRate.toFixed(2)}%
        </span>
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">World Share</span>
        <span class="compare-val">${country.worldShare.toFixed(2)}%</span>
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">Density</span>
        <span class="compare-val">${country.density.toFixed(1)} / km²</span>
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">Fertility (TFR)</span>
        <span class="compare-val">${country.fertilityRate.toFixed(2)}</span>
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">Life Expectancy</span>
        <span class="compare-val">${country.lifeExpectancy.toFixed(1)} yrs</span>
      </div>
      <div class="compare-stat-row">
        <span class="compare-label">Median Age</span>
        <span class="compare-val">${country.medianAge.toFixed(1)} yrs</span>
      </div>
    `;
  }

  function updateCompareLiveValues(countryPops) {
    const popA = countryPops[state.compareCountryA];
    const popB = countryPops[state.compareCountryB];
    const elemA = document.getElementById('compare-val-a');
    const elemB = document.getElementById('compare-val-b');

    if (elemA && popA) elemA.textContent = PopulationEngine.formatNumber(popA, state.numberFormat);
    if (elemB && popB) elemB.textContent = PopulationEngine.formatNumber(popB, state.numberFormat);
  }

  function updateCompareChart() {
    const canvas = document.getElementById('compare-chart-canvas');
    if (!canvas || typeof Chart === 'undefined') return;

    const ctx = canvas.getContext('2d');
    if (compareChartInstance) compareChartInstance.destroy();

    const cA = COUNTRIES_DATA.find(c => c.iso === state.compareCountryA);
    const cB = COUNTRIES_DATA.find(c => c.iso === state.compareCountryB);

    const dataA = TIMELINE_DATA[state.compareCountryA.toLowerCase()] || 
                  TIMELINE_DATA.world.map(v => Math.round(v * (cA ? cA.worldShare / 100 : 0.1)));
    const dataB = TIMELINE_DATA[state.compareCountryB.toLowerCase()] || 
                  TIMELINE_DATA.world.map(v => Math.round(v * (cB ? cB.worldShare / 100 : 0.1)));

    compareChartInstance = new Chart(ctx, {
      type: 'line',
      data: {
        labels: TIMELINE_DATA.years.map(y => y.toString()),
        datasets: [
          {
            label: cA ? cA.name : 'Country 1',
            data: dataA,
            borderColor: '#06B6D4',
            backgroundColor: 'rgba(6, 182, 212, 0.1)',
            tension: 0.3,
            borderWidth: 3,
            pointRadius: 3
          },
          {
            label: cB ? cB.name : 'Country 2',
            data: dataB,
            borderColor: '#F59E0B',
            backgroundColor: 'rgba(245, 158, 11, 0.1)',
            tension: 0.3,
            borderWidth: 3,
            pointRadius: 3
          }
        ]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: { labels: { color: '#F8FAFC', font: { family: 'Outfit' } } },
          tooltip: {
            backgroundColor: '#0F172A',
            callbacks: {
              label: (ctx) => `${ctx.dataset.label}: ${PopulationEngine.formatNumber(ctx.raw, state.numberFormat)}`
            }
          }
        },
        scales: {
          x: { ticks: { color: '#94A3B8' }, grid: { color: 'rgba(255,255,255,0.05)' } },
          y: {
            ticks: {
              color: '#94A3B8',
              callback: (v) => v >= 1e9 ? `${(v/1e9).toFixed(2)}B` : `${(v/1e6).toFixed(0)}M`
            },
            grid: { color: 'rgba(255,255,255,0.05)' }
          }
        }
      }
    });
  }

  /* ========================================================================
     6. COUNTRY DETAILS MODAL
     ======================================================================== */
  function openCountryModal(country) {
    state.selectedCountryModal = country;

    document.getElementById('modal-country-flag').textContent = country.flag;
    document.getElementById('modal-country-name').textContent = country.name;
    document.getElementById('modal-country-native').textContent = 
      `${country.nativeName} • ${country.subregion} • Capital: ${country.capital}`;

    const engineState = window.populationEngine.getCurrentState();
    const livePop = (engineState.countryPops && engineState.countryPops[country.iso]) || country.population;
    document.getElementById('modal-country-pop').textContent = 
      PopulationEngine.formatNumber(livePop, state.numberFormat);

    const growthSign = country.growthRate > 0 ? '+' : '';
    document.getElementById('modal-country-growth').textContent = 
      `${growthSign}${PopulationEngine.formatNumber(country.annualChange, state.numberFormat)} / year (${growthSign}${country.growthRate.toFixed(2)}%)`;

    // Populate Metrics Grid
    const metricsGrid = document.getElementById('modal-metrics-container');
    metricsGrid.innerHTML = `
      <div class="modal-metric-card">
        <div class="modal-metric-label">Global Rank</div>
        <div class="modal-metric-val">#${country.rank}</div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Share of Humanity</div>
        <div class="modal-metric-val">${country.worldShare.toFixed(2)}%</div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Population Density</div>
        <div class="modal-metric-val">${country.density.toFixed(1)} / km²</div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Total Land Area</div>
        <div class="modal-metric-val">${country.landAreaKm2.toLocaleString()} km²</div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Total Fertility Rate</div>
        <div class="modal-metric-val" style="color:${country.fertilityRate < 2.1 ? 'var(--rose-accent)' : 'var(--emerald-accent)'};">
          ${country.fertilityRate.toFixed(2)}
        </div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Median Age</div>
        <div class="modal-metric-val">${country.medianAge.toFixed(1)} yrs</div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Life Expectancy</div>
        <div class="modal-metric-val">${country.lifeExpectancy.toFixed(1)} yrs</div>
      </div>
      <div class="modal-metric-card">
        <div class="modal-metric-label">Urbanization</div>
        <div class="modal-metric-val">${country.urbanPct ? country.urbanPct.toFixed(1) : '—'}%</div>
      </div>
    `;

    // Render Mini Historical Chart in Modal
    renderModalChart(country);

    countryModal.classList.add('active');
  }

  function renderModalChart(country) {
    const canvas = document.getElementById('modal-chart-canvas');
    if (!canvas || typeof Chart === 'undefined') return;

    const ctx = canvas.getContext('2d');
    if (modalChartInstance) modalChartInstance.destroy();

    const dataPoints = TIMELINE_DATA[country.iso.toLowerCase()] || 
                       TIMELINE_DATA.world.map(v => Math.round(v * (country.worldShare / 100)));

    modalChartInstance = new Chart(ctx, {
      type: 'line',
      data: {
        labels: TIMELINE_DATA.years.map(y => y.toString()),
        datasets: [{
          label: country.name,
          data: dataPoints,
          borderColor: '#06B6D4',
          backgroundColor: 'rgba(6, 182, 212, 0.15)',
          fill: true,
          tension: 0.35,
          borderWidth: 2,
          pointRadius: 3
        }]
      },
      options: {
        responsive: true,
        maintainAspectRatio: false,
        plugins: {
          legend: { display: false },
          tooltip: {
            backgroundColor: '#0F172A',
            callbacks: {
              label: (ctx) => `Population: ${PopulationEngine.formatNumber(ctx.raw, state.numberFormat)}`
            }
          }
        },
        scales: {
          x: { ticks: { color: '#94A3B8', font: { size: 10 } }, grid: { color: 'rgba(255,255,255,0.05)' } },
          y: {
            ticks: {
              color: '#94A3B8',
              font: { size: 10 },
              callback: (v) => v >= 1e9 ? `${(v/1e9).toFixed(1)}B` : `${(v/1e6).toFixed(0)}M`
            },
            grid: { color: 'rgba(255,255,255,0.05)' }
          }
        }
      }
    });
  }

  function closeCountryModal() {
    countryModal.classList.remove('active');
    state.selectedCountryModal = null;
  }

  if (modalCloseBtn) modalCloseBtn.addEventListener('click', closeCountryModal);
  if (countryModal) {
    countryModal.addEventListener('click', (e) => {
      if (e.target === countryModal) closeCountryModal();
    });
  }
  document.addEventListener('keydown', (e) => {
    if (e.key === 'Escape') closeCountryModal();
  });

  /* ========================================================================
     7. NAVIGATION TAB SWITCHER
     ======================================================================== */
  if (mainViewTabs) {
    mainViewTabs.querySelectorAll('.tab-btn').forEach(btn => {
      btn.addEventListener('click', () => {
        const targetTabId = btn.dataset.tab;
        if (state.activeTab === targetTabId) return;

        mainViewTabs.querySelectorAll('.tab-btn').forEach(b => {
          b.classList.remove('active');
          b.setAttribute('aria-selected', 'false');
        });
        btn.classList.add('active');
        btn.setAttribute('aria-selected', 'true');

        document.querySelectorAll('.tab-content').forEach(tc => tc.classList.remove('active'));
        const activeContent = document.getElementById(targetTabId);
        if (activeContent) activeContent.classList.add('active');

        state.activeTab = targetTabId;

        // Trigger chart resizes/initializations upon becoming visible
        if (targetTabId === 'tab-chart') initTimelineChart();
        if (targetTabId === 'tab-pyramid') initPyramidChart();
        if (targetTabId === 'tab-compare') initCompareView();
      });
    });
  }

  /* ========================================================================
     8. CONTROLS: NUMBER FORMAT & SIMULATION SPEED
     ======================================================================== */
  // Format controls
  document.querySelectorAll('#format-controls .control-btn').forEach(btn => {
    btn.addEventListener('click', () => {
      document.querySelectorAll('#format-controls .control-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');
      state.numberFormat = btn.dataset.format;
      
      // Re-render components with new format
      window.populationEngine.notifySubscribers();
      renderCountriesTable();
      if (state.selectedCountryModal) openCountryModal(state.selectedCountryModal);
      if (state.activeTab === 'tab-compare') updateCompareDetails();
    });
  });

  // Speed controls
  document.querySelectorAll('#speed-controls .control-btn').forEach(btn => {
    btn.addEventListener('click', () => {
      document.querySelectorAll('#speed-controls .control-btn').forEach(b => b.classList.remove('active'));
      btn.classList.add('active');

      const speed = btn.dataset.speed;
      if (speed === 'pause') {
        window.populationEngine.setPaused(true);
      } else {
        window.populationEngine.setPaused(false);
        window.populationEngine.setSpeed(parseFloat(speed));
      }
    });
  });

  // Year slider time machine
  if (yearSlider) {
    yearSlider.addEventListener('input', (e) => {
      const year = parseInt(e.target.value, 10);
      timeMachineYearVal.textContent = year;
      state.isTimeMachine = true;
      window.populationEngine.setMode('year', year);
    });
  }

  // Reset to now
  if (btnResetNow) {
    btnResetNow.addEventListener('click', () => {
      state.isTimeMachine = false;
      yearSlider.value = 2026;
      timeMachineYearVal.textContent = '2026';
      window.populationEngine.resetToRealtime();
    });
  }

  // Timeline toggle buttons (Population vs Growth Rate)
  const chartTogglePop = document.getElementById('chart-toggle-pop');
  const chartToggleGrowth = document.getElementById('chart-toggle-growth');

  if (chartTogglePop && chartToggleGrowth) {
    chartTogglePop.addEventListener('click', () => {
      chartTogglePop.classList.add('active');
      chartToggleGrowth.classList.remove('active');
      state.timelineMetric = 'population';
      initTimelineChart();
    });

    chartToggleGrowth.addEventListener('click', () => {
      chartToggleGrowth.classList.add('active');
      chartTogglePop.classList.remove('active');
      state.timelineMetric = 'growth';
      initTimelineChart();
    });
  }

  // Pyramid country select
  const pyramidSelect = document.getElementById('pyramid-country-select');
  if (pyramidSelect) {
    pyramidSelect.addEventListener('change', (e) => {
      state.pyramidCountry = e.target.value;
      initPyramidChart();
    });
  }

  /* ========================================================================
     9. INITIALIZE APPLICATION
     ======================================================================== */
  renderCountriesTable();
  initWorldMap();
  initTimelineChart();
  initPyramidChart();
  initCompareView();

  // First tick update
  onEngineTick(window.populationEngine.getCurrentState());
});
