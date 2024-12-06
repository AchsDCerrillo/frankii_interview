package com.alexce.frankichallenge.home.presentation.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.stringResource
import com.alexce.frankichallenge.home.domain.entity.WeatherInfo
import java.time.Instant
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import com.alexce.frankichallenge.home.presentation.R
import com.alexce.frankichallenge.home.presentation.components.WeatherItem

@Composable
@ReadOnlyComposable
fun WeatherInfo.title() = stringResource(R.string.title_weather, name, sys.country)

fun WeatherInfo.titleWeather(): String {
    return weather.joinToString { "${it.main} - ${it.description}" }
}

@Composable
@ReadOnlyComposable
fun WeatherInfo.temperatureDescription(): String =
    stringResource(R.string.temperature_description, main.temp, main.feelsLike)

@Composable
@ReadOnlyComposable
fun WeatherInfo.minMaxTemperature(): String =
    stringResource(R.string.min_max_temperature, main.tempMin, main.tempMax)

@Composable
@ReadOnlyComposable
fun WeatherInfo.pressure(): String =
    stringResource(R.string.pressure_description, main.pressure)

@Composable
@ReadOnlyComposable
fun WeatherInfo.humidity(): String =
    stringResource(R.string.humidity_description, main.humidity)

@Composable
@ReadOnlyComposable
fun WeatherInfo.seaLevel(): String =
    stringResource(R.string.sea_level_description, main.seaLevel)

@Composable
@ReadOnlyComposable
fun WeatherInfo.groundLevel(): String =
    stringResource(R.string.ground_level_description, main.grndLevel)

@Composable
@ReadOnlyComposable
fun WeatherInfo.wind(): String =
    stringResource(R.string.wind_speed_description, wind.speed)

@Composable
@ReadOnlyComposable
fun WeatherInfo.sunsetSunrise(): String =
    stringResource(R.string.sunset_sunrise_description, sunrise(), sunset())

fun WeatherInfo.sunrise(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneOffset.ofTotalSeconds(
        timezone.toInt()
    ))
    val sunrise = formatter.format(Instant.ofEpochSecond(sys.sunrise))
    return sunrise
}

fun WeatherInfo.sunset(): String {
    val formatter = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(ZoneOffset.ofTotalSeconds(
        timezone.toInt()
    ))
    val sunset = formatter.format(Instant.ofEpochSecond(sys.sunset))
    return sunset
}

@Composable
@ReadOnlyComposable
fun WeatherInfo.items(): List<WeatherItem> {
    return listOf(
        WeatherItem(
            icon = R.drawable.ic_temperature,
            value = temperatureDescription(),
            title = stringResource(R.string.temperature)
        ),
        WeatherItem(
            icon = R.drawable.ic_min_max_temperature,
            value = minMaxTemperature(),
            title = stringResource(R.string.min_max_temperature_name)
        ),
        WeatherItem(
            icon = R.drawable.ic_pressure,
            value = pressure(),
            title = stringResource(R.string.pressure)
        ),
        WeatherItem(
            icon = R.drawable.ic_humidity,
            value = humidity(),
            title = stringResource(R.string.humidity)
        ),
        WeatherItem(
            icon = R.drawable.ic_sea_level,
            value = seaLevel(),
            title = stringResource(R.string.sea_level)
        ),
        WeatherItem(
            icon = R.drawable.ic_ground_level,
            value = groundLevel(),
            title = stringResource(R.string.ground_level)
        ),
        WeatherItem(
            icon = R.drawable.ic_wind_speed,
            value = wind(),
            title = stringResource(R.string.wind_speed)
        ),
        WeatherItem(
            icon = R.drawable.ic_sunset,
            value = sunsetSunrise(),
            title = stringResource(R.string.sunset_sunrise)
        )
    )
}