package com.example.home.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun WeatherIcon(
    url: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = "https:$url",
        contentDescription = "Weather Icon",
        modifier = modifier.size(180.dp),
        contentScale = ContentScale.Crop
    )
}


@Composable
@Preview(showBackground = true)
fun WeatherIconPreview(modifier: Modifier = Modifier) {
    WeatherIcon(url = "")
}

