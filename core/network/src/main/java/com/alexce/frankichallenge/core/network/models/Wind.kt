package com.alexce.frankichallenge.core.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Wind(
    @SerialName("deg")
    val deg: Double,
    @SerialName("gust")
    val gust: Double?,
    @SerialName("speed")
    val speed: Double
)