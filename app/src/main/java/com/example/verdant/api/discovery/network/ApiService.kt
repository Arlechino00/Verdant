package com.example.verdant.api.discovery.network

import com.example.verdant.api.discovery.model.Plant
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("species-list?key=sk-dUCm662d4577cb75e5274")
    fun getAllPlants(): Call<Plant>
}