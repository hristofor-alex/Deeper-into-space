package com.example.networkmodule.retrofit

import androidx.lifecycle.LiveData
import com.example.networkmodule.retrofit.model.Sol
import kotlinx.coroutines.flow.Flow

interface WeatherMars {
    fun getWeather() : Flow<List<Sol>>
}