package com.example.domain.usecase

import org.intellij.lang.annotations.Flow

interface GetWeatherForLastTenDays {

    fun getWeather() : Flow<List<Sol>>
}