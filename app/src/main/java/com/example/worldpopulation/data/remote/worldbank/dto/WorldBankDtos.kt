package com.example.worldpopulation.data.remote.worldbank.dto

import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName

data class WorldBankHeader(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("total")
    val total: Int?
)

data class WorldBankIdValue(
    @SerializedName("id")
    val id: String?,
    @SerializedName("value")
    val value: String?
)

data class WorldBankDataRecord(
    @SerializedName("indicator")
    val indicator: WorldBankIdValue?,
    @SerializedName("country")
    val country: WorldBankIdValue?,
    @SerializedName("countryiso3code")
    val countryIso3Code: String?,
    @SerializedName("date")
    val date: String?,
    @SerializedName("value")
    val value: Double?,
    @SerializedName("unit")
    val unit: String?,
    @SerializedName("obs_status")
    val obsStatus: String?,
    @SerializedName("decimal")
    val decimal: Int?
)
