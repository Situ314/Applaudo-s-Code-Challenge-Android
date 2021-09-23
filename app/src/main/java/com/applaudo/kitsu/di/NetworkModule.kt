package com.applaudo.kitsu.di

import com.applaudo.kitsu.data.network.CategoryApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl("https://kitsu.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

    @Singleton
    @Provides
    fun provideCategoryApiCliente(retrofit: Retrofit):CategoryApiClient{
        return retrofit.create(CategoryApiClient::class.java)
    }
}