package com.example.worldpopulation.util

import org.junit.Assert.assertEquals
import org.junit.Test

class NumberFormatterTest {

    @Test
    fun format_international_formatsCorrectly() {
        assertEquals("1,479,785,117", NumberFormatter.format(1479785117L, NumberFormatType.INTERNATIONAL))
        assertEquals("8,203,000,000", NumberFormatter.format(8203000000L, NumberFormatType.INTERNATIONAL))
        assertEquals("1,000", NumberFormatter.format(1000L, NumberFormatType.INTERNATIONAL))
        assertEquals("0", NumberFormatter.format(0L, NumberFormatType.INTERNATIONAL))
    }

    @Test
    fun formatIndian_formatsWithLakhsAndCrores() {
        // Standard Indian grouping: last 3 digits, then pairs of 2
        assertEquals("1,47,97,85,117", NumberFormatter.formatIndian(1479785117L))
        assertEquals("1,00,000", NumberFormatter.formatIndian(100000L))       // 1 Lakh
        assertEquals("10,00,000", NumberFormatter.formatIndian(1000000L))     // 10 Lakhs
        assertEquals("1,00,00,000", NumberFormatter.formatIndian(10000000L))  // 1 Crore
        assertEquals("500", NumberFormatter.formatIndian(500L))
        assertEquals("1,000", NumberFormatter.formatIndian(1000L))
        assertEquals("50,000", NumberFormatter.formatIndian(50000L))
    }

    @Test
    fun formatCompact_formatsWithSuffixes() {
        assertEquals("1.45B", NumberFormatter.formatCompact(1_450_000_000L))
        assertEquals("345.43M", NumberFormatter.formatCompact(345_426_571L))
        assertEquals("84.55M", NumberFormatter.formatCompact(84_552_242L))
        assertEquals("26.71M", NumberFormatter.formatCompact(26_713_205L))
        assertEquals("500.0K", NumberFormatter.formatCompact(500_000L))
        assertEquals("800", NumberFormatter.formatCompact(800L))
    }

    @Test
    fun formatPercentage_formatsDecimalsProperly() {
        assertEquals("51.25%", NumberFormatter.formatPercentage(51.25))
        assertEquals("48.8%", NumberFormatter.formatPercentage(48.75, 1))
    }
}
