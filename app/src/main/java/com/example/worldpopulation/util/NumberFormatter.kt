package com.example.worldpopulation.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import kotlin.math.abs

enum class NumberFormatType {
    INTERNATIONAL,
    INDIAN
}

object NumberFormatter {

    private val internationalFormat = DecimalFormat("#,###", DecimalFormatSymbols(Locale.US))

    fun format(number: Long, formatType: NumberFormatType = NumberFormatType.INTERNATIONAL): String {
        return when (formatType) {
            NumberFormatType.INTERNATIONAL -> internationalFormat.format(number)
            NumberFormatType.INDIAN -> formatIndian(number)
        }
    }

    fun formatCompact(number: Long): String {
        val absVal = abs(number)
        val sign = if (number < 0) "-" else ""
        return when {
            absVal >= 1_000_000_000_000L -> String.format(Locale.US, "%s%.2fT", sign, absVal / 1_000_000_000_000.0)
            absVal >= 1_000_000_000L -> String.format(Locale.US, "%s%.2fB", sign, absVal / 1_000_000_000.0)
            absVal >= 1_000_000L -> String.format(Locale.US, "%s%.2fM", sign, absVal / 1_000_000.0)
            absVal >= 1_000L -> String.format(Locale.US, "%s%.1fK", sign, absVal / 1_000.0)
            else -> "$number"
        }
    }

    fun formatPercentage(value: Double, decimals: Int = 2): String {
        return String.format(Locale.US, "%.${decimals}f%%", value)
    }

    fun formatIndicatorWithUnit(formattedValue: String?, rawValue: Double, unit: String): String {
        val valStr = formattedValue ?: if (rawValue % 1.0 == 0.0) {
            String.format(Locale.US, "%,.0f", rawValue)
        } else {
            String.format(Locale.US, "%.2f", rawValue)
        }
        val trimmedUnit = unit.trim()
        return when {
            trimmedUnit.isEmpty() -> valStr
            trimmedUnit == "%" -> "$valStr%"
            trimmedUnit.startsWith("% ") -> "$valStr% ${trimmedUnit.removePrefix("% ")}"
            else -> "$valStr $trimmedUnit"
        }
    }

    fun computeCompetitionRanks(
        items: List<com.example.worldpopulation.data.local.entity.CountryIndicatorValueEntity>
    ): List<Int> {
        if (items.isEmpty()) return emptyList()
        val ranks = ArrayList<Int>(items.size)
        var currentRank = 1
        for (i in items.indices) {
            if (i > 0) {
                val prevKey = items[i - 1].formattedValue ?: items[i - 1].value.toString()
                val currKey = items[i].formattedValue ?: items[i].value.toString()
                if (currKey != prevKey && items[i].value != items[i - 1].value) {
                    currentRank = i + 1
                }
            }
            ranks.add(currentRank)
        }
        return ranks
    }

    /**
     * Formats according to Indian grouping:
     * Last 3 digits, followed by groups of 2 digits:
     * e.g. 1479785117 -> 1,47,97,85,117
     */
    fun formatIndian(number: Long): String {
        if (number == 0L) return "0"
        val isNegative = number < 0
        val str = abs(number).toString()
        val len = str.length

        if (len <= 3) {
            return if (isNegative) "-$str" else str
        }

        val lastThree = str.substring(len - 3)
        val remaining = str.substring(0, len - 3)

        val sb = StringBuilder()
        for (i in remaining.indices) {
            sb.append(remaining[i])
            val distFromEnd = remaining.length - 1 - i
            if (distFromEnd > 0 && distFromEnd % 2 == 0) {
                sb.append(',')
            }
        }
        sb.append(',')
        sb.append(lastThree)

        return if (isNegative) "-$sb" else sb.toString()
    }
}
