package com.alexce.frankichallenge.home.presentation.components

import androidx.annotation.DrawableRes

data class WeatherItem(
    @DrawableRes val icon: Int,
    val value: String,
    val title: String
)
