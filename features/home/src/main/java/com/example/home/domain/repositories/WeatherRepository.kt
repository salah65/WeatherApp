package com.example.home.domain.repositories

import com.example.home.domain.models.Weather

interface WeatherRepository {
    suspend fun fetchCurrentWeather(q: String): Result<Weather>
    suspend fun getCurrentWeather(): Weather?
    suspend fun cacheCurrentWeather(weather: Weather)
}