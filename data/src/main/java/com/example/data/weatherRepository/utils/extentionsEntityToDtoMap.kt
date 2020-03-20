package com.example.data.weatherRepository.utils

import com.example.domain.entity.*
import com.example.localdb.dto.*

fun Temperature.toDto() = DtoTemperature(
        average,
        samplesOverTheSol,
        min,
        max
)

fun Pressure.toDto() = DtoPressure(
        average,
        samplesOverTheSol,
        min,
        max
)

fun WindSpeed.toDto() = DtoWindSpeed(
        average,
        samplesOverTheSol,
        min,
        max
)

fun Wind.toDto() = DtoWind(
        compassPoint,
        power
)

fun WindDirections.toDto() = DtoWindDirections(
        winds.map {
            it?.toDto()
        }
)