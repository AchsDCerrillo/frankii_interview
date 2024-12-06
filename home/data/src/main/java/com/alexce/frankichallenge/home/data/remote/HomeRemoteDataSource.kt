package com.alexce.frankichallenge.home.data.remote

import com.alexce.frankichallenge.core.network.models.WeatherResponse

interface HomeRemoteDataSource {
    suspend fun getWeatherByCity(city: String, units: String = "metric"): WeatherResponse
}