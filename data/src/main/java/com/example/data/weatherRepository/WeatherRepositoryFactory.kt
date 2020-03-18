package com.example.data.weatherRepository

import android.content.Context
import com.example.localdb.DbWeather
import com.example.networkmodule.retrofit.WeatherMars

interface WeatherRepositoryFactory {
    fun createWeatherRepository(
        context: Context,
        weatherDatabase: DbWeather,
        weatherRetrofit: WeatherMars
    ): WeatherRepository
}