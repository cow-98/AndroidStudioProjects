package com.example.deepeningproject.Data




import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

import retrofit2.Call

interface INetworkService {
    @GET("v2/search/image")
    fun image_search(
        @Header("Authorization") apiKey: String?,
        @Query("query") query: String?,
        @Query("sort") sort: String?,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): Call<ImageData?>
}