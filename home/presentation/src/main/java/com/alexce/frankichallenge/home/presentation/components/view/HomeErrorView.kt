package com.alexce.frankichallenge.home.presentation.components.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.alexce.frankichallenge.home.presentation.R

@Composable
fun HomeErrorView(
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_weather_error),
            contentDescription = stringResource(R.string.error),
            modifier = Modifier.weight(1f)
        )
        Button(
            onClick = onRetry
        ) {
            Text(text = stringResource(R.string.retry))
        }
    }
}