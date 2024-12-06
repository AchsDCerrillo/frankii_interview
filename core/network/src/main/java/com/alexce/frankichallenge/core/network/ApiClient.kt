package com.alexce.frankichallenge.core.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object ApiClient {
    @OptIn(ExperimentalSerializationApi::class)
    fun getInstance(
        httpClient: OkHttpClient,
        url: String,
        json: Json
    ): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(httpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
}