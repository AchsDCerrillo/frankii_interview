package com.alexce.frankichallenge.core.network

import com.alexce.frankichallenge.core.network.models.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FrankiiApi {
    @GET("data/2.5/weather")
    suspend fun getWeatherByCity(
        @Query("q") city: String,
        @Query("units") units: String = "metric" // Default to metric units
    ): WeatherResponse
}