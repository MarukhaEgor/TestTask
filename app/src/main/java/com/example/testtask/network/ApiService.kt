package com.example.testtask.network

import com.example.testtask.data.model.GifsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/v1/gifs/search")
    suspend fun getGifs(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String,
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("rating") rating: String,
        @Query("lang") lang: String
    ): GifsModel
}