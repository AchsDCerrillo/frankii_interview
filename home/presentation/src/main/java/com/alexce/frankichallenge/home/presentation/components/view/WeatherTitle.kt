package com.alexce.frankichallenge.home.presentation.components.view

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import com.alexce.frankichallenge.home.presentation.R

@Composable
fun WeatherTitle(
    title: String,
    description: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.keyLine2)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.keyLine2))
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.keyLine2))
        )
        Image(
            imageVector = ImageVector.vectorResource(id = icon),
            contentDescription = title,
            modifier = modifier
                .size(dimensionResource(id = R.dimen.keyLine4))
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.keyLine2))
        )
    }
}