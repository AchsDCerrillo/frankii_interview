package com.alexce.frankichallenge.home.domain.entity

data class WeatherInfo(
    val base: String,
    val clouds: Clouds,
    val cod: Double,
    val coord: Coord,
    val dt: Double,
    val id: Long,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Long,
    val visibility: Long,
    val weather: List<Weather>,
    val wind: Wind
)