package com.example.domain.entity

data class Temperature(
    val average: Double,
    val samplesOverTheSol: Long,
    val min: Double,
    val max: Double
)