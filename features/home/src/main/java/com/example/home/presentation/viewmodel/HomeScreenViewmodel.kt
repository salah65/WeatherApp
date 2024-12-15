package com.example.home.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.models.Weather
import com.example.home.domain.usecases.SearchWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewmodel @Inject constructor(
    private val fetchWeatherUseCase: SearchWeatherUseCase
) : ViewModel() {
    private val _weatherData = MutableStateFlow<Weather?>(null)
    val weatherData: StateFlow<Weather?> get() = _weatherData

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


    fun clearError() {
        _error.update { "" }
    }
}