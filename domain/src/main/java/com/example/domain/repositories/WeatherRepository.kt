package com.example.domain.repositories

import com.example.domain.entity.Sol
import kotlinx.coroutines.flow.Flow
import java.util.*

interface WeatherRepository {
    fun getWeather(date : Date): Flow<List<Sol>>
    suspend fun remoteRequestWeather(): List<Sol>
    suspend fun save(vararg sol: Sol)
}