package com.alexce.frankichallenge.core.network.di

import com.alexce.frankichallenge.core.network.ApiClient
import com.alexce.frankichallenge.core.network.FrankiiApi
import com.alexce.frankichallenge.core.network.HttpClientProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideOkHttpClient(
        @ApiKey apiKey: String
    ): OkHttpClient = HttpClientProvider.create(apiKey = apiKey)

    @Provides
    fun provideJson(): Json = HttpClientProvider.json

    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        json: Json,
        @ServerUrl serverUrl: String
    ): Retrofit =
        ApiClient.getInstance(
            httpClient = okHttpClient,
            url = serverUrl,
            json = json
        )

    @Provides
    fun provideFrankiiApi(retrofit: Retrofit): FrankiiApi {
        return retrofit.create(FrankiiApi::class.java)
    }
}