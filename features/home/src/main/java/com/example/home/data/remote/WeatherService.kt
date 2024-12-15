package com.example.home.data.remote

import com.example.home.data.dto.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("current.json")
    suspend fun getCurrentWeather(
        @Query("q") query: String
    ): Response<WeatherResponse>
}