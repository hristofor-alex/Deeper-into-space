package com.example.data.weatherRepository

import com.example.localdb.dto.DtoSol
import com.example.networkmodule.retrofit.model.NetSol
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

    fun getWeatherFromLastTenDays(): Flow<List<com.example.domain.entity.Sol>>
    suspend fun remoteRequestWeather(): List<NetSol>
    suspend fun save(vararg sol: DtoSol)
}