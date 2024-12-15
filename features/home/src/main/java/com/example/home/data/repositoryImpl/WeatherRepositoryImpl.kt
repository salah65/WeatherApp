package com.example.home.data.repositoryImpl

import com.example.core.data.remote.Resource
import com.example.core.data.remote.safeApiCall
import com.example.home.data.dto.toDomain
import com.example.home.domain.models.Weather
import com.example.home.domain.remote.WeatherService
import com.example.home.domain.repositories.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService
) : WeatherRepository {
    override suspend fun fetchCurrentWeather(q: String): Result<Weather> {
        val response = safeApiCall { weatherService.getCurrentWeather(q) }
        return when (response) {
            is Resource.Error -> Result.failure(Throwable(message = response.message))
            is Resource.Success -> Result.success(response.data!!.toDomain())
        }

    }

    override suspend fun getCurrentWeather(): Weather? {
        TODO("Not yet implemented")
    }

    override suspend fun cacheCurrentWeather(weather: Weather) {
        TODO("Not yet implemented")
    }


}