package com.example.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.ui.theme.LightGrayBackground
import com.example.home.domain.models.Weather

@Composable
fun SearchResultItem(
    weather: Weather,
    modifier: Modifier = Modifier,
    onItemClick: (weather: Weather) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clickable {
                onItemClick(weather)
            }
            .height(180.dp)
            .background(color = LightGrayBackground, shape = RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .padding(18.dp)
                .background(color = Color.Transparent),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = weather.cityName,
                color = Color.Black,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "${weather.tempC}°",
                color = Color.Black,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,

                )
        }
        Spacer(modifier = Modifier.weight(1f))
        WeatherIcon(modifier = modifier.size(150.dp), url = weather.conditionIconUrl)
    }
}

@Composable
@Preview(showBackground = true)
fun SearchResultItemPreview(modifier: Modifier = Modifier) {
    SearchResultItem(
        weather = Weather(
            cityName = "Duma Hills",
            tempC = 12,
            feelsLikeC = 14,
            conditionIconUrl = "",
            humidity = 8733,
            uv = 3054
        )
    )
}