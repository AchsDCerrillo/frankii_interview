package com.alexce.frankichallenge.home.data.mapper

import com.alexce.frankichallenge.core.network.models.Clouds
import com.alexce.frankichallenge.core.network.models.Main
import com.alexce.frankichallenge.core.network.models.Sys
import com.alexce.frankichallenge.core.network.models.Weather
import com.alexce.frankichallenge.core.network.models.WeatherResponse
import com.alexce.frankichallenge.core.network.models.Wind
import com.alexce.frankichallenge.core.network.models.Coord
import com.alexce.frankichallenge.home.domain.entity.WeatherInfo
import com.alexce.frankichallenge.home.domain.entity.Clouds as DomainClouds
import com.alexce.frankichallenge.home.domain.entity.Coord as DomainCoord
import com.alexce.frankichallenge.home.domain.entity.Main as DomainMain
import com.alexce.frankichallenge.home.domain.entity.Sys as DomainSys
import com.alexce.frankichallenge.home.domain.entity.Weather as DomainWeather
import com.alexce.frankichallenge.home.domain.entity.Wind as DomainWind


fun WeatherResponse.toWeatherInfo(): WeatherInfo {
    return WeatherInfo(
        base = this.base,
        clouds = this.clouds.toClouds(),
        cod = this.cod,
        coord = this.coord.toCoord(),
        dt = this.dt,
        id = this.id,
        main = this.main.toMain(),
        name = this.name,
        sys = this.sys.toSys(),
        timezone = this.timezone,
        visibility = this.visibility,
        weather = this.weather.map { it.toWeather() },
        wind = this.wind.toWind()
    )
}

fun Clouds.toClouds(): DomainClouds {
    return DomainClouds(
        all = this.all
    )
}

fun Coord.toCoord(): DomainCoord {
    return DomainCoord(
        lat = this.lat,
        lon = this.lon
    )
}

fun Main.toMain(): DomainMain {
    return DomainMain(
        feelsLike = this.feelsLike,
        grndLevel = this.grndLevel,
        humidity = this.humidity,
        pressure = this.pressure,
        seaLevel = this.seaLevel,
        temp = this.temp,
        tempMax = this.tempMax,
        tempMin = this.tempMin
    )
}

fun Sys.toSys(): DomainSys {
    return DomainSys(
        country = this.country,
        id = this.id,
        sunrise = this.sunrise,
        sunset = this.sunset,
        type = this.type
    )
}

fun Weather.toWeather(): DomainWeather {
    return DomainWeather(
        description = this.description,
        icon = this.icon,
        id = this.id,
        main = this.main
    )
}

fun Wind.toWind(): DomainWind {
    return DomainWind(
        deg = this.deg,
        gust = this.gust ?: 0.0,
        speed = this.speed
    )
}
