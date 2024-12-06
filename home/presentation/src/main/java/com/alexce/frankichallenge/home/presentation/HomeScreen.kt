package com.alexce.frankichallenge.home.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import com.alexce.frankichallenge.home.presentation.components.view.HomeContainer
import com.alexce.frankichallenge.home.presentation.components.view.HomeTopBar
import com.alexce.frankichallenge.home.presentation.ext.items
import com.alexce.frankichallenge.home.presentation.ext.title
import com.alexce.frankichallenge.home.presentation.ext.titleWeather
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter

@OptIn(FlowPreview::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val weather = (state as? HomeState.Success)?.weather
    var query by rememberSaveable { mutableStateOf("") }
    LaunchedEffect(query) {
        snapshotFlow { query }
            .filter { it.isNotEmpty() }
            .debounce(500)
            .distinctUntilChanged()
            .collectLatest { viewModel.fetchWeatherByCity(city = it) }

    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HomeTopBar()
        }
    ) { innerPadding ->
        HomeContainer(
            modifier = Modifier.padding(innerPadding),
            isLoading = state is HomeState.Loading,
            isError = state is HomeState.Error,
            isEmpty = state is HomeState.Success && weather == null,
            query = query,
            title = weather?.title().orEmpty(),
            weatherDescription = weather?.titleWeather().orEmpty(),
            items = weather?.items().orEmpty(),
            onSearchChanged = { query = it },
            onRetry = { viewModel.fetchWeatherByCity(city = query) }
        )
    }
}