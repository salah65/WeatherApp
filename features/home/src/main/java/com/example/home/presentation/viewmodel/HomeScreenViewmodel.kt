package com.example.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.models.Weather
import com.example.home.domain.usecases.CacheWeatherUseCase
import com.example.home.domain.usecases.GetWeatherUseCase
import com.example.home.domain.usecases.SearchWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewmodel @Inject constructor(
    private val fetchWeatherUseCase: SearchWeatherUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
    private val cacheWeatherUseCase: CacheWeatherUseCase,
) : ViewModel() {
    private val _weatherData = MutableStateFlow<Weather?>(null)
    val weatherData: StateFlow<Weather?> get() = _weatherData

    private val _cachedWeather = MutableStateFlow<Weather?>(null)
    val cachedWeather: StateFlow<Weather?>
        get() = _cachedWeather
            .onStart { getCachedWeather() }
            .stateIn(
                viewModelScope,
                initialValue = null,
                started = SharingStarted.Eagerly
            )

    private val _error = MutableStateFlow("")
    val error: StateFlow<String> get() = _error

    fun fetchWeather(location: String) {
        viewModelScope.launch {
            try {
                fetchWeatherUseCase(location).onSuccess { weather ->
                    _weatherData.update { weather }
                }.onFailure { throwable ->
                    _error.update { throwable.message ?: "" }
                }

            } catch (exception: Exception) {
                _weatherData.value = null
            }
        }
    }

    private fun getCachedWeather() {
        viewModelScope.launch {
            getWeatherUseCase()?.let {
                _cachedWeather.value = it
            }
        }
    }

    fun cacheCurrentWeather(selectedWeather: Weather) {
        viewModelScope.launch {
            cacheWeatherUseCase(selectedWeather)
        }
    }

    fun clearError() {
        _error.update { "" }
    }
}