package com.example.worldpopulation.di

import com.example.worldpopulation.data.remote.un.UnPopulationApiService
import com.example.worldpopulation.data.remote.worldbank.WorldBankApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideUnApiService(okHttpClient: OkHttpClient, gson: Gson): UnPopulationApiService {
        return Retrofit.Builder()
            .baseUrl("https://population.un.org/dataportalapi/api/v1/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(UnPopulationApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideWorldBankApiService(okHttpClient: OkHttpClient, gson: Gson): WorldBankApiService {
        return Retrofit.Builder()
            .baseUrl("https://api.worldbank.org/v2/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(WorldBankApiService::class.java)
    }
}
