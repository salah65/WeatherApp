package com.example.home.data.dto

import com.example.home.domain.models.Weather

data class WeatherResponse(
    val location: Location,
    val current: CurrentWeather
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    val lat: Double,
    val lon: Double,
    val tz_id: String,
    val localtime: String
)

data class CurrentWeather(
    val last_updated: String,
    val temp_c: Double,
    val temp_f: Double,
    val condition: WeatherCondition,
    val wind_mph: Double,
    val wind_kph: Double,
    val wind_degree: Int,
    val wind_dir: String,
    val pressure_mb: Double,
    val pressure_in: Double,
    val precip_mm: Double,
    val precip_in: Double,
    val humidity: Int,
    val cloud: Int,
    val feelslike_c: Double,
    val feelslike_f: Double,
    val vis_km: Double,
    val vis_miles: Double,
    val uv: Double,
    val gust_mph: Double,
    val gust_kph: Double,
    val air_quality: AirQuality
)

data class WeatherCondition(
    val text: String,
    val icon: String,
    val code: Int
)

data class AirQuality(
    val co: Double,
    val no2: Double,
    val o3: Double,
    val so2: Double,
    val pm2_5: Double,
    val pm10: Double,
    val us_epa_index: Int,
    val gb_defra_index: Int
)

fun WeatherResponse.toDomain(): Weather {
    return Weather(
        cityName = this.location.name,
        tempC = this.current.temp_c.toInt(),
        feelsLikeC = this.current.feelslike_c.toInt(),
        conditionIconUrl = this.current.condition.icon,
        humidity = this.current.humidity,
        uv = this.current.uv.toInt()

    )
}