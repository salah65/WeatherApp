package com.example.home.domain.models

data class Weather(
    val cityName: String,
    val tempC: Int,
    val feelsLikeC: Int,
    val conditionIconUrl: String,
    val humidity: Int,
    val uv: Int
)
