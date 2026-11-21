/**
 * Population Live Calculation Engine
 * Faithful port of the Kotlin domain engine (LivePopulationEngine & PopulationEstimator)
 */

class PopulationEngine {
  constructor() {
    this.SECONDS_PER_YEAR = 31556952.0; // 365.2425 * 86400
    this.MILLIS_PER_YEAR = this.SECONDS_PER_YEAR * 1000.0;
    this.MILLIS_PER_DAY = 86400000.0;

    // Simulation state
    this.isPaused = false;
    this.speedMultiplier = 1; // 1x, 10x, 60x, 3600x
    this.virtualTimeOffset = 0; // ms offset from real time
    this.lastRealTimestamp = Date.now();
    this.currentSimulatedTime = Date.now();

    // Mode: 'live' or 'year'
    this.mode = 'live';
    this.selectedYear = 2026;

    // Listeners for state change
    this.subscribers = new Set();
    this.startTicker();
  }

  startTicker() {
    if (this.tickerInterval) clearInterval(this.tickerInterval);
    this.tickerInterval = setInterval(() => {
      const now = Date.now();
      const deltaReal = now - this.lastRealTimestamp;
      this.lastRealTimestamp = now;

      if (!this.isPaused && this.mode === 'live') {
        this.currentSimulatedTime += deltaReal * this.speedMultiplier;
      }
      this.notifySubscribers();
    }, 100); // 100ms high-fidelity tick
  }

  subscribe(callback) {
    this.subscribers.add(callback);
    return () => this.subscribers.delete(callback);
  }

  notifySubscribers() {
    const state = this.getCurrentState();
    this.subscribers.forEach(cb => {
      try { cb(state); } catch (e) { console.error(e); }
    });
  }

  setSpeed(multiplier) {
    this.speedMultiplier = multiplier;
    this.lastRealTimestamp = Date.now();
    this.notifySubscribers();
  }

  setPaused(paused) {
    this.isPaused = paused;
    this.lastRealTimestamp = Date.now();
    this.notifySubscribers();
  }

  setMode(mode, year = 2026) {
    this.mode = mode;
    this.selectedYear = year;
    this.notifySubscribers();
  }

  setYear(year) {
    this.selectedYear = Math.max(1950, Math.min(2100, Math.round(year)));
    this.notifySubscribers();
  }

  resetToRealtime() {
    this.mode = 'live';
    this.isPaused = false;
    this.speedMultiplier = 1;
    this.currentSimulatedTime = Date.now();
    this.lastRealTimestamp = Date.now();
    this.notifySubscribers();
  }

  /**
   * Linear estimation math from UN baseline
   */
  estimate(baselinePopulation, baselineTimestampMillis, annualChange, currentTimestampMillis) {
    if (baselinePopulation <= 0) return 0;
    if (annualChange === 0) return Math.round(baselinePopulation);

    const elapsedMillis = currentTimestampMillis - baselineTimestampMillis;
    const elapsedYears = elapsedMillis / this.MILLIS_PER_YEAR;
    const delta = elapsedYears * annualChange;
    const result = Math.round(baselinePopulation + delta);
    return Math.max(0, result);
  }

  /**
   * Estimates today's counts since 00:00 UTC of simulated time
   */
  estimateCountToday(annualRateOrCount, currentTimestampMillis) {
    const millisIntoDay = currentTimestampMillis % this.MILLIS_PER_DAY;
    const fractionOfDay = millisIntoDay / this.MILLIS_PER_DAY;
    const dailyCount = annualRateOrCount / 365.2425;
    return Math.round(dailyCount * fractionOfDay);
  }

  /**
   * Interpolate historical / projected timeline
   */
  interpolateTimeline(year, country = 'world') {
    const years = TIMELINE_DATA.years;
    const values = TIMELINE_DATA[country] || TIMELINE_DATA.world;

    if (year <= years[0]) return values[0];
    if (year >= years[years.length - 1]) return values[values.length - 1];

    for (let i = 0; i < years.length - 1; i++) {
      if (year >= years[i] && year <= years[i + 1]) {
        const span = years[i + 1] - years[i];
        const fraction = (year - years[i]) / span;
        return Math.round(values[i] + fraction * (values[i + 1] - values[i]));
      }
    }
    return values[values.length - 1];
  }

  getCurrentState() {
    const simTime = this.currentSimulatedTime;

    if (this.mode === 'year') {
      const year = this.selectedYear;
      const worldPop = this.interpolateTimeline(year, 'world');
      return {
        mode: 'year',
        year: year,
        timestamp: simTime,
        worldPopulation: worldPop,
        birthsToday: Math.round((133000000 / 365.2425) * 0.75),
        deathsToday: Math.round((61500000 / 365.2425) * 0.75),
        growthToday: Math.round((71500000 / 365.2425) * 0.75),
        speed: this.speedMultiplier,
        isPaused: this.isPaused
      };
    }

    // Live mode
    const worldPop = this.estimate(
      WORLD_BASELINE.population,
      WORLD_BASELINE.baselineTimestamp,
      WORLD_BASELINE.annualGrowth,
      simTime
    );

    const birthsToday = this.estimateCountToday(WORLD_BASELINE.annualBirths, simTime);
    const deathsToday = this.estimateCountToday(WORLD_BASELINE.annualDeaths, simTime);
    const growthToday = this.estimateCountToday(WORLD_BASELINE.annualGrowth, simTime);

    // Calculate country populations in real time
    const countryPops = {};
    COUNTRIES_DATA.forEach(c => {
      countryPops[c.iso] = this.estimate(
        c.population,
        c.baselineTimestamp,
        c.annualChange,
        simTime
      );
    });

    return {
      mode: 'live',
      year: new Date(simTime).getUTCFullYear(),
      timestamp: simTime,
      worldPopulation: worldPop,
      birthsToday,
      deathsToday,
      growthToday,
      countryPops,
      speed: this.speedMultiplier,
      isPaused: this.isPaused
    };
  }

  /**
   * High-accuracy formatting helper
   */
  static formatNumber(num, formatType = 'INTERNATIONAL') {
    if (num === null || num === undefined || isNaN(num)) return '0';
    const n = Math.round(num);

    if (formatType === 'COMPACT') {
      if (Math.abs(n) >= 1e9) {
        return (n / 1e9).toFixed(2) + 'B';
      }
      if (Math.abs(n) >= 1e6) {
        return (n / 1e6).toFixed(2) + 'M';
      }
      if (Math.abs(n) >= 1e3) {
        return (n / 1e3).toFixed(1) + 'K';
      }
      return n.toString();
    }

    if (formatType === 'INDIAN') {
      return PopulationEngine.formatIndian(n);
    }

    // Standard International comma separation
    return n.toLocaleString('en-US');
  }

  static formatIndian(num) {
    const isNegative = num < 0;
    let s = Math.abs(num).toString();
    if (s.length <= 3) {
      return (isNegative ? '-' : '') + s;
    }

    const last3 = s.substring(s.length - 3);
    let remaining = s.substring(0, s.length - 3);
    const pairs = [];

    while (remaining.length > 2) {
      pairs.unshift(remaining.substring(remaining.length - 2));
      remaining = remaining.substring(0, remaining.length - 2);
    }
    if (remaining.length > 0) {
      pairs.unshift(remaining);
    }

    return (isNegative ? '-' : '') + pairs.join(',') + ',' + last3;
  }
}

// Export global instance
window.populationEngine = new PopulationEngine();
