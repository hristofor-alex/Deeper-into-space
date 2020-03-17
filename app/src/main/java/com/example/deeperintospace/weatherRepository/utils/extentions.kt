package com.example.deeperintospace.weatherRepository.utils

import com.example.localdb.entity.Temperature
import com.example.networkmodule.retrofit.entity.Pressure
import com.example.networkmodule.retrofit.entity.Wind
import com.example.networkmodule.retrofit.entity.WindDirections
import com.example.networkmodule.retrofit.entity.WindSpeed
import java.lang.String.format
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.Level.parse
import java.util.Date as Date

fun com.example.networkmodule.retrofit.entity.Temperature.toDto() = Temperature(
    average,
    samplesOverTheSol,
    min,
    max
)

fun Pressure.toDto() = com.example.localdb.entity.Pressure(
    average,
    samplesOverTheSol,
    min,
    max
)

fun WindSpeed.toDto() = com.example.localdb.entity.WindSpeed(
    average,
    samplesOverTheSol,
    min,
    max
)

fun Wind.toDto() = com.example.localdb.entity.Wind(
    compassPoint,
    samplesNumber
)

fun WindDirections.toDto() = com.example.localdb.entity.WindDirections(
    listOf(
        direction0?.toDto(),
        direction1?.toDto(),
        direction2?.toDto(),
        direction3?.toDto(),
        direction4?.toDto(),
        direction5?.toDto(),
        direction6?.toDto(),
        direction7?.toDto(),
        direction8?.toDto(),
        direction9?.toDto(),
        direction10?.toDto(),
        direction11?.toDto(),
        direction12?.toDto(),
        direction13?.toDto(),
        direction14?.toDto(),
        direction15?.toDto()
    )
)

fun String.toDate() : Date {
    return SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(this)
}
