package com.alexce.frankichallenge.home.presentation.components.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.alexce.frankichallenge.home.presentation.R
import com.alexce.frankichallenge.home.presentation.components.WeatherItem

@Composable
fun HomeContainer(
    isLoading: Boolean,
    isError: Boolean,
    isEmpty: Boolean,
    query: String,
    title: String,
    weatherDescription: String,
    items: List<WeatherItem>,
    onSearchChanged: (String) -> Unit,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.keyLine2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.keyLine1))
    ) {
        SearchInputView(
            query = query,
            onSearchChanged = onSearchChanged
        )
        when {
            isLoading -> {
                HomeLoadingView()
            }
            isError -> {
                HomeErrorView(
                    onRetry = onRetry
                )
            }
            isEmpty -> {
                HomeEmptyView()
            }
            else -> {
                WeatherInfoView(
                    title = title,
                    description = weatherDescription,
                    weatherItems = items
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun WeatherInfoView(
    title: String,
    description: String,
    weatherItems: List<WeatherItem>,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.keyLine2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.keyLine1))
    ) {
        WeatherTitle(
            title = title,
            description = description,
            icon = R.drawable.ic_weather
        )
        LazyRow {
            items(items = weatherItems) { item ->
                WeatherItemView(
                    icon = item.icon,
                    value = item.value,
                    title = item.title
                )
            }
        }
    }
}