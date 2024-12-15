package com.example.home.domain.di

import com.example.home.domain.repositories.WeatherRepository
import com.example.home.domain.usecases.CacheWeatherUseCase
import com.example.home.domain.usecases.GetWeatherUseCase
import com.example.home.domain.usecases.SearchWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @ViewModelScoped
    @Provides
    fun provideSearchWeatherUseCase(weatherRepository: WeatherRepository): SearchWeatherUseCase {
        return SearchWeatherUseCase(weatherRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideCacheWeatherUseCase(weatherRepository: WeatherRepository): CacheWeatherUseCase {
        return CacheWeatherUseCase(weatherRepository)
    }

    @ViewModelScoped
    @Provides
    fun provideGetWeatherUseCase(weatherRepository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(weatherRepository)
    }

}