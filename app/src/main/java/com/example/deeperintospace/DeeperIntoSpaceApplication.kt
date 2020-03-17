package com.example.deeperintospace

import android.app.Application
import com.example.deeperintospace.weatherRepository.WeatherRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

class DeeperIntoSpaceApplication : Application() {
    @ExperimentalCoroutinesApi
    @FlowPreview
    override fun onCreate() {
        super.onCreate()
        WeatherRepository.initialize(this)
    }
}