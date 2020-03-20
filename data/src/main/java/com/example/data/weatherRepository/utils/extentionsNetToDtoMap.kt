package com.example.data.weatherRepository.utils

import com.example.localdb.dto.*
import com.example.networkmodule.retrofit.dto.*
import java.text.SimpleDateFormat
import java.util.*

fun NetTemperature.toDto() = DtoTemperature(
    average,
    samplesOverTheSol,
    min,
    max
)

fun NetPressure.toDto() = DtoPressure(
    average,
    samplesOverTheSol,
    min,
    max
)

fun NetWindSpeed.toDto() = DtoWindSpeed(
    average,
    samplesOverTheSol,
    min,
    max
)

fun NetWind.toDto() = DtoWind(
    compassPoint,
    samplesNumber
)

fun NetWindDirections.toDto() = DtoWindDirections(
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


