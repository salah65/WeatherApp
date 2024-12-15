package com.example.home.presentation.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.home.R
import com.example.home.domain.models.Weather

@Composable
fun CityWeather(weather: Weather, modifier: Modifier = Modifier) {
    val isLandscape =
        androidx.compose.ui.platform.LocalConfiguration.current.orientation == Configuration.ORIENTATION_LANDSCAPE

    if (isLandscape) {
        Row(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            WeatherIcon(url = weather.conditionIconUrl)
            Spacer(modifier = Modifier.width(16.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = weather.cityName,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow),
                        contentDescription = "Location Icon",
                        modifier = Modifier.size(24.dp),
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${weather.tempC}°C",
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            WeatherDetailsCard(weather = weather)
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            WeatherIcon(url = weather.conditionIconUrl)
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = weather.cityName,
                    maxLines = 1,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow),
                    contentDescription = "Location Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "${weather.tempC}°c",
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            WeatherDetailsCard(weather = weather)
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 700, heightDp = 400)
fun CityWeatherLandscapePreview() {
    CityWeather(
        weather = Weather(
            cityName = "Annex",
            tempC = 4,
            feelsLikeC = 6,
            conditionIconUrl = "",
            humidity = 9547,
            uv = 2267
        )
    )
}

@Composable
@Preview(showBackground = true, widthDp = 400, heightDp = 700)
fun CityWeatherPortraitPreview() {
    CityWeather(
        weather = Weather(
            cityName = "Annex",
            tempC = 4,
            feelsLikeC = 6,
            conditionIconUrl = "",
            humidity = 9547,
            uv = 2267
        )
    )
}