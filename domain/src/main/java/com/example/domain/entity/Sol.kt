package com.example.domain.entity

import java.util.*

data class Sol(
    val sol: String,
    val temperature: Temperature,
    val windSpeed: WindSpeed,
    val pressure: Pressure,
    val windDirections: WindDirections,
    val season: String,
    val firstUtc: Date,
    val lastUtc: Date
)