package com.example.worldpopulation.domain.model

enum class DataType {
    HISTORICAL,
    ESTIMATE,
    PROJECTION,
    CALCULATED,
    CALIBRATED_ESTIMATE,
    ESTIMATE_AND_PROJECTION;

    companion object {
        fun fromString(value: String?): DataType {
            if (value.isNullOrBlank()) return ESTIMATE
            return try {
                valueOf(value.uppercase().trim())
            } catch (e: Exception) {
                when {
                    value.contains("CALIBRAT", ignoreCase = true) -> CALIBRATED_ESTIMATE
                    value.contains("PROJECT", ignoreCase = true) -> PROJECTION
                    value.contains("HISTORIC", ignoreCase = true) -> HISTORICAL
                    value.contains("CALCULAT", ignoreCase = true) -> CALCULATED
                    else -> ESTIMATE
                }
            }
        }
    }
}
