package com.example.home.domain.usecases

import com.example.home.domain.models.Weather
import com.example.home.domain.repositories.WeatherRepository
import javax.inject.Inject

class SearchWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(q: String): Result<Weather> {
        return weatherRepository.fetchCurrentWeather(q)
    }
}