package com.example.home.domain.usecases

import com.example.home.domain.models.Weather
import com.example.home.domain.repositories.WeatherRepository
import javax.inject.Inject

class CacheWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(weather: Weather) {
        return weatherRepository.cacheCurrentWeather(weather)
    }
}