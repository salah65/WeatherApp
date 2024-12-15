package com.example.home.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.home.presentation.components.CityWeather
import com.example.home.presentation.components.NoCitySelected
import com.example.home.presentation.components.SearchLocationBar
import com.example.home.presentation.components.SearchResultItem
import com.example.home.presentation.viewmodel.HomeScreenViewmodel


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, viewmodel: HomeScreenViewmodel = hiltViewModel()
) {
    val weather by viewmodel.weatherData.collectAsState()
    val cachedWeather by viewmodel.cachedWeather.collectAsState()
    val error by viewmodel.error.collectAsState()
    val context = LocalContext.current
    var query by remember { mutableStateOf("") }
    LaunchedEffect(error) {
        if (error.isNotEmpty()) {
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
            viewmodel.clearError()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchLocationBar(query = query, onQueryChange = { query = it }) {
            viewmodel.fetchWeather(query)
        }
        Box(modifier = modifier.weight(1f)) {
            weather?.let { weather ->
                SearchResultItem(weather = weather) { item ->
                    Toast.makeText(context, "Selected Location saved", Toast.LENGTH_SHORT).show()
                    viewmodel.cacheCurrentWeather(item)
                }
            } ?: cachedWeather?.let { CityWeather(weather = it) } ?: NoCitySelected()
        }

    }
}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}