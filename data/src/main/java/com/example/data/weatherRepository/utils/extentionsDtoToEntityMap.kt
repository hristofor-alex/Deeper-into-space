package com.example.data.weatherRepository.utils

import com.example.domain.entity.*
import com.example.localdb.dto.*

fun DtoTemperature.toEntity() = Temperature(
        average,
        samplesOverTheSol,
        min,
        max
)

fun DtoPressure.toEntity() = Pressure(
        average,
        samplesOverTheSol,
        min,
        max
)

fun DtoWindSpeed.toEntity() = WindSpeed(
        average,
        samplesOverTheSol,
        min,
        max
)

fun DtoWind.toEntity() = Wind(
        compassPoint,
        power
)

fun DtoWindDirections.toEntity() = WindDirections(
          winds.map {
              it?.toEntity()
          }
)