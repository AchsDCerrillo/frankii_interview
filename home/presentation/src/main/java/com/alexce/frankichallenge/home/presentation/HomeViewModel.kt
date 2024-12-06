package com.alexce.frankichallenge.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexce.frankichallenge.home.domain.usecase.GetWeatherByCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getWeatherUseCase: GetWeatherByCityUseCase
) : ViewModel() {
    private val _state = MutableStateFlow<HomeState>(HomeState.Success())
    val state = _state.asStateFlow()

    fun fetchWeatherByCity(city: String) {
        _state.value = HomeState.Loading
        getWeatherUseCase(city = city)
            .onEach { result ->
                if(result.isSuccess) {
                    _state.value = HomeState.Success(result.getOrNull())
                } else {
                    _state.value = HomeState.Error(result.exceptionOrNull() ?: Exception("Unknown error"))
                }
            }.launchIn(viewModelScope)
    }

}