package com.example.data.weatherRepository

import com.example.localdb.entity.DtoSol
import com.example.networkmodule.retrofit.model.Sol
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getWeatherFromLastTenDays(): Flow<List<DtoSol>>
    suspend fun remoteRequestWeather(): List<Sol>
    suspend fun save(sol: DtoSol)
}