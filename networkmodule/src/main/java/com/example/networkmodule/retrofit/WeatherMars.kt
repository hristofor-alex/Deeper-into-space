package com.example.networkmodule.retrofit

import com.example.networkmodule.retrofit.model.Sol

interface WeatherMars {
    suspend fun getWeather() : List<Sol>
}