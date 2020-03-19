package com.example.networkmodule.retrofit

import com.example.networkmodule.retrofit.model.NetSol

interface WeatherMars {
    suspend fun getWeather() : List<NetSol>
}