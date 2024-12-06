package com.alexce.frankichallenge.home.data.di

import com.alexce.frankichallenge.home.data.remote.HomeRemoteDataSource
import com.alexce.frankichallenge.home.data.remote.HomeRemoteDataSourceImpl
import com.alexce.frankichallenge.home.data.repository.WeatherRepositoryImpl
import com.alexce.frankichallenge.home.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeDataModule {
    @Binds
    abstract fun bindHomeRemoteDataSource(
        homeRemoteDataSource: HomeRemoteDataSourceImpl
    ): HomeRemoteDataSource

    @Binds
    abstract fun bindWeatherRepository(
        weatherRepository: WeatherRepositoryImpl
    ): WeatherRepository
}