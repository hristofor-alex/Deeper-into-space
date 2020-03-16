package com.example.deeperintospace.weatherRepository

import android.content.Context
import com.example.localdb.DbWeather
import com.example.networkmodule.retrofit.WeatherMars

class WeatherRepository(
    private val context: Context,
    private val weatherDatabase: DbWeather,
    private val weatherRetrofit: WeatherMars
) {

    init {
        weatherDatabase.init(context)
        weatherRetrofit.getWeather()
    }
}