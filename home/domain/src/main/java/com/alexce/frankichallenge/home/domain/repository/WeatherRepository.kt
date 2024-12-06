package com.alexce.frankichallenge.home.domain.repository

import com.alexce.frankichallenge.home.domain.entity.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherByCity(city: String, units: String = "metric"): WeatherInfo
}