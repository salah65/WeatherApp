package com.example.core.data.remote.di

import com.example.core.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrlQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApiKeyQualifier

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    @BaseUrlQualifier
    fun provideBaseUrl(): String {
        return BuildConfig.Base_Url
    }

    @Provides
    @Singleton
    @ApiKeyQualifier
    fun provideApiKey(): String {
        return BuildConfig.API_KEY
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApiKeyQualifier apiKey: String): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val originalRequest = chain.request()
                val url: HttpUrl = originalRequest.url.newBuilder()
                    .addQueryParameter("key", apiKey)
                    .build()
                val request = originalRequest.newBuilder().url(url).build()
                chain.proceed(request)
            }
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, @BaseUrlQualifier baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}