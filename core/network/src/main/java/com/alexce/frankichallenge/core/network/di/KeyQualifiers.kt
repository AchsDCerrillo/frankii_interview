package com.alexce.frankichallenge.core.network.di

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApiKey

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ServerUrl
