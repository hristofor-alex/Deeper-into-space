package com.example.deeperintospace

import android.app.Application
import com.example.deeperintospace.weatherRepository.WeatherRepository

class DeeperIntoSpaceApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        WeatherRepository.initialize(this)
    }
}