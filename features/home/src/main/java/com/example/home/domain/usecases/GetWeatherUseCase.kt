package com.example.home.domain.usecases

import com.example.home.domain.models.Weather
import com.example.home.domain.repositories.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {
    suspend operator fun invoke(): Weather? {
        return weatherRepository.getCurrentWeather()
    }
}