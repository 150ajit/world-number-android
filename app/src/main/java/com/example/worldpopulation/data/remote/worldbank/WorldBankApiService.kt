package com.example.worldpopulation.data.remote.worldbank

import com.google.gson.JsonArray
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WorldBankApiService {

    @GET("country/{country}/indicator/{indicator}")
    suspend fun getCountryIndicator(
        @Path("country") country: String,
        @Path("indicator") indicator: String,
        @Query("date") dateRange: String = "1960:2025",
        @Query("format") format: String = "json",
        @Query("per_page") perPage: Int = 100
    ): Response<JsonArray>

    @GET("country/all/indicator/{indicator}")
    suspend fun getAllCountriesIndicator(
        @Path("indicator") indicator: String,
        @Query("date") date: String = "2023",
        @Query("format") format: String = "json",
        @Query("per_page") perPage: Int = 300
    ): Response<JsonArray>
}
