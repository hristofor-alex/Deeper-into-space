package com.example.domain.usecase

import com.example.domain.entity.Sol
import com.example.domain.repositories.WeatherRepository
import com.example.domain.utils.DAY_IN_MS
import kotlinx.coroutines.flow.Flow
import java.util.*

class GetWeatherForLastTenDays constructor(private val repository : WeatherRepository) {
    fun get(): Flow<List<Sol>> {
        val tenDaysBeforeToday = Date(System.currentTimeMillis() - (10 * DAY_IN_MS))
        return repository.getWeather(tenDaysBeforeToday)
    }
}