package com.example.core.data.local.di

import android.content.Context
import com.example.core.data.local.SharedPreferencesManager
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {


    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun provideSharedPreferenceManager(
        @ApplicationContext context: Context, gson: Gson
    ): SharedPreferencesManager {
        return SharedPreferencesManager(context = context, gson = gson)
    }
}