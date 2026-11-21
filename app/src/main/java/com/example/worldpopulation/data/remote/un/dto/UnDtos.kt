package com.example.worldpopulation.data.remote.un.dto

import com.google.gson.annotations.SerializedName

data class UnApiResponse<T>(
    @SerializedName("data")
    val data: List<T>?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("total")
    val total: Int?
)

data class UnDataRecord(
    @SerializedName("indicatorId")
    val indicatorId: Int?,
    @SerializedName("indicator")
    val indicator: String?,
    @SerializedName("locationId")
    val locationId: Int?,
    @SerializedName("location")
    val location: String?,
    @SerializedName("iso3")
    val iso3: String?,
    @SerializedName("iso2")
    val iso2: String?,
    @SerializedName("timeLabel")
    val timeLabel: String?,
    @SerializedName("timeMid")
    val timeMid: Double?,
    @SerializedName("ageStart")
    val ageStart: Int?,
    @SerializedName("ageEnd")
    val ageEnd: Int?,
    @SerializedName("ageMid")
    val ageMid: Double?,
    @SerializedName("sex")
    val sex: String?,
    @SerializedName("value")
    val value: Double?,
    @SerializedName("variant")
    val variant: String?,
    @SerializedName("category")
    val category: String?
)
