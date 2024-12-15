package com.example.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.ui.theme.LightGrayBackground
import com.example.home.domain.models.Weather

@Composable
fun WeatherDetailsCard(weather: Weather, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(110.dp)
            .background(color = LightGrayBackground, shape = RoundedCornerShape(16.dp)),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically

    ) {
        WeatherDetailsItem(title = "humidity", value = "${weather.humidity}%")
        WeatherDetailsItem(title = "uv", value = "${weather.uv}")
        WeatherDetailsItem(title = "feelsLike", value = "${weather.feelsLikeC}°")
    }
}

@Composable
fun WeatherDetailsItem(
    modifier: Modifier = Modifier, title: String, value: String
) {
    Column(
        modifier
            .padding(8.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = title, color = Color.Gray)
        Text(text = value, color = Color.DarkGray)
    }
}

@Composable
@Preview(showBackground = true)
fun WeatherDetailsCardPreview() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        WeatherDetailsCard(
            weather = Weather(
                cityName = "Ambler",
                tempC = 32,
                feelsLikeC = 38,
                conditionIconUrl = "http://www.bing.com/search?q=prompta",
                humidity = 20,
                uv = 14
            ), modifier = Modifier.padding(innerPadding)
        )
    }

}