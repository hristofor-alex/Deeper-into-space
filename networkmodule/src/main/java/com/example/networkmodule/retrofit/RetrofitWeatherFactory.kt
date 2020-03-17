package com.example.networkmodule.retrofit

class RetrofitWeatherFactory: WeatherMarsFactory {
    override fun createWeatherMars(): WeatherMars {
        return RetrofitWeather()
    }
}