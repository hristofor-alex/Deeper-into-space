package com.example.data.weatherRepository.utils

import com.example.domain.entity.*
import com.example.networkmodule.retrofit.dto.*
import java.text.SimpleDateFormat
import java.util.*

fun NetTemperature.toEntity() = Temperature(
        average,
        samplesOverTheSol,
        min,
        max
)

fun NetPressure.toEntity() = Pressure(
        average,
        samplesOverTheSol,
        min,
        max
)

fun NetWindSpeed.toEntity() = WindSpeed(
        average,
        samplesOverTheSol,
        min,
        max
)

fun NetWind.toEntity() = Wind(
        compassPoint,
        samplesNumber
)

fun NetWindDirections.toEntity() = WindDirections(
        listOf(
                direction0?.toEntity(),
                direction1?.toEntity(),
                direction2?.toEntity(),
                direction3?.toEntity(),
                direction4?.toEntity(),
                direction5?.toEntity(),
                direction6?.toEntity(),
                direction7?.toEntity(),
                direction8?.toEntity(),
                direction9?.toEntity(),
                direction10?.toEntity(),
                direction11?.toEntity(),
                direction12?.toEntity(),
                direction13?.toEntity(),
                direction14?.toEntity(),
                direction15?.toEntity()
        )
)
