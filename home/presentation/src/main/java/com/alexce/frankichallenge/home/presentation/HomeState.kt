package com.alexce.frankichallenge.home.presentation

import com.alexce.frankichallenge.home.domain.entity.WeatherInfo

sealed interface HomeState {
    data object Loading : HomeState
    data class Success(val weather: WeatherInfo? = null) : HomeState
    data class Error(val throwable: Throwable) : HomeState
}