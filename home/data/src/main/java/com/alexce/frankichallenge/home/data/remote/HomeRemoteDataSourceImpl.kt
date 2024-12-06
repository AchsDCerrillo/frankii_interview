package com.alexce.frankichallenge.home.data.remote

import com.alexce.frankichallenge.core.network.FrankiiApi
import com.alexce.frankichallenge.core.network.models.WeatherResponse
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    val api: FrankiiApi
) : HomeRemoteDataSource {
    override suspend fun getWeatherByCity(
        city: String,
        units: String
    ): WeatherResponse = api.getWeatherByCity(city = city, units = units)
}