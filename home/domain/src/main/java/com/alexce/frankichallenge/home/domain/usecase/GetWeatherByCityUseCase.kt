package com.alexce.frankichallenge.home.domain.usecase

import com.alexce.frankichallenge.home.domain.entity.WeatherInfo
import com.alexce.frankichallenge.home.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.Result

class GetWeatherByCityUseCase @Inject constructor(
    private val repository: WeatherRepository
) {
    operator fun invoke(city: String, units: String = "metric") = flow<Result<WeatherInfo>> {
        val result = repository.getWeatherByCity(city = city, units = units)
        emit(Result.success(result))
    }.catch {
        print(it)
        emit(Result.failure(it))
    }
}