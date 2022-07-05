package com.example.testtask.network

import com.example.testtask.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    const val apikey = "kc1mimHlRloGaPdp2V85c8fzoDYCdNFV"
    fun getApiServices(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}