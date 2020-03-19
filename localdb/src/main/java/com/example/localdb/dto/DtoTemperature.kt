package com.example.localdb.dto

import androidx.room.ColumnInfo

data class DtoTemperature (
    @ColumnInfo(name="temperatureAverage")
    val average : Double,
    @ColumnInfo(name="temperatureSamplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="temperatureMin")
    val min : Double,
    @ColumnInfo(name="temperatureMax")
    val max : Double
)