package com.alexce.frankichallenge.core.network.di

import com.alexce.frankichallenge.core.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object KeyModule {
    @ApiKey
    @Provides
    fun provideApiKey(): String = BuildConfig.API_KEY

    @ServerUrl
    @Provides
    fun provideServerUrl(): String = BuildConfig.BASE_URL
}