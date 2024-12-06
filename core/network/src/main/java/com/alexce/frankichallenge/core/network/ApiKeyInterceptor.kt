package com.alexce.frankichallenge.core.network

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url

        // Append the API key to the query parameters
        val urlWithApiKey = originalUrl.newBuilder()
            .addQueryParameter("appid", apiKey)
            .build()

        // Build the new request with the updated URL
        val requestWithApiKey = originalRequest.newBuilder()
            .url(urlWithApiKey)
            .build()

        return chain.proceed(requestWithApiKey)
    }
}