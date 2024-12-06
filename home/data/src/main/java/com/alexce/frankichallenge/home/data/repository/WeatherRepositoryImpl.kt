package com.alexce.frankichallenge.home.data.repository

import com.alexce.frankichallenge.core.di.IoDispatcher
import com.alexce.frankichallenge.home.data.mapper.toWeatherInfo
import com.alexce.frankichallenge.home.data.remote.HomeRemoteDataSource
import com.alexce.frankichallenge.home.domain.entity.WeatherInfo
import com.alexce.frankichallenge.home.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : WeatherRepository {
    override suspend fun getWeatherByCity(
        city: String,
        units: String
    ): WeatherInfo = withContext(dispatcher) {
        val weatherResponse = remoteDataSource.getWeatherByCity(city = city, units = units)
        return@withContext weatherResponse.toWeatherInfo()
    }
}