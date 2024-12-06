package com.alexce.frankichallenge.core.network

import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object HttpClientProvider {
    val json by lazy {
        Json {
            encodeDefaults = false
            ignoreUnknownKeys = true
            isLenient = true
            allowSpecialFloatingPointValues = true
            coerceInputValues = true
            prettyPrint = true
            explicitNulls = false
        }
    }

    fun create(apiKey: String): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log headers and body
        }

        val apiKeyInterceptor = ApiKeyInterceptor(apiKey)

        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS) // Optional timeout settings
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }
}