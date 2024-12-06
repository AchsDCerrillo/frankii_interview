package com.alexce.frankichallenge.core.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import androidx.annotation.Keep

@Keep
@Serializable
data class Sys(
    @SerialName("country")
    val country: String,
    @SerialName("id")
    val id: Long,
    @SerialName("sunrise")
    val sunrise: Long,
    @SerialName("sunset")
    val sunset: Long,
    @SerialName("type")
    val type: Long
)