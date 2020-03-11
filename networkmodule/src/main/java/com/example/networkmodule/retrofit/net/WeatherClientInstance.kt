package com.example.networkmodule.retrofit.net

import android.util.TimeUtils
import okhttp3.EventListener
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object WeatherClientInstance {
    private const val baseUrl = "https://api.nasa.gov"

    val retrofit: Retrofit by lazy {
       Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }
}