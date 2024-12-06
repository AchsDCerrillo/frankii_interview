package com.alexce.frankichallenge.core.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class WeatherResponse(
    @SerialName("base")
    val base: String,
    @SerialName("clouds")
    val clouds: Clouds,
    @SerialName("cod")
    val cod: Double,
    @SerialName("coord")
    val coord: Coord,
    @SerialName("dt")
    val dt: Double,
    @SerialName("id")
    val id: Long,
    @SerialName("main")
    val main: Main,
    @SerialName("name")
    val name: String,
    @SerialName("sys")
    val sys: Sys,
    @SerialName("timezone")
    val timezone: Long,
    @SerialName("visibility")
    val visibility: Long,
    @SerialName("weather")
    val weather: List<Weather>,
    @SerialName("wind")
    val wind: Wind
)