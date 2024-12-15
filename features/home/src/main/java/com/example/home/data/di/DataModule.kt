package com.example.home.data.di

import com.example.home.data.repositoryImpl.WeatherRepositoryImpl
import com.example.home.domain.remote.WeatherService
import com.example.home.domain.repositories.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideWeatherRepository(
        service: WeatherService
    ): WeatherRepository =
        WeatherRepositoryImpl(service)

}