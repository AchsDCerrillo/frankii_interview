package com.alexce.frankichallenge.home.domain.entity

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)