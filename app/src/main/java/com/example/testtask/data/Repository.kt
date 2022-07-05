package com.example.testtask.data

import com.example.testtask.data.model.GifsModel
import com.example.testtask.network.Network
import com.example.testtask.utils.Constants
import org.koin.core.component.KoinComponent

class Repository: KoinComponent {
    private val apiService = Network.getApiServices()
    suspend fun getGif(): GifsModel = apiService.getGifs(Network.apikey, "cat", Constants.ITEMS_REQUEST_COUNT,0,"g","ru")
}