package com.example.worldpopulation.data.remote.un

import com.example.worldpopulation.data.remote.un.dto.UnApiResponse
import com.example.worldpopulation.data.remote.un.dto.UnDataRecord
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UnPopulationApiService {

    @GET("data/indicators/{indicatorId}/locations/{locationId}/start/{startYear}/end/{endYear}")
    suspend fun getIndicatorData(
        @Path("indicatorId") indicatorId: Int,
        @Path("locationId") locationId: Int,
        @Path("startYear") startYear: Int,
        @Path("endYear") endYear: Int,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 100
    ): Response<UnApiResponse<UnDataRecord>>

    @GET("data/indicators/{indicatorId}/locations/{locationId}")
    suspend fun getIndicatorLatest(
        @Path("indicatorId") indicatorId: Int,
        @Path("locationId") locationId: Int,
        @Query("page") page: Int = 1,
        @Query("pageSize") pageSize: Int = 50
    ): Response<UnApiResponse<UnDataRecord>>
}
