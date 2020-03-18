package com.example.networkmodule.retrofit.net

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

object WeatherClientInstance {
    private val baseUrl = "https://api.nasa.gov"

    val retrofit: Retrofit by lazy {
       Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
}