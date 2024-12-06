package com.alexce.frankichallenge.core.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Main(
    @SerialName("feels_like")
    val feelsLike: Double,
    @SerialName("grnd_level")
    val grndLevel: Double,
    @SerialName("humidity")
    val humidity: Double,
    @SerialName("pressure")
    val pressure: Double,
    @SerialName("sea_level")
    val seaLevel: Double,
    @SerialName("temp")
    val temp: Double,
    @SerialName("temp_max")
    val tempMax: Double,
    @SerialName("temp_min")
    val tempMin: Double
)