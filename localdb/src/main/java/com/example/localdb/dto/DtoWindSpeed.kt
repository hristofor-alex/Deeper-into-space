package com.example.localdb.dto

import androidx.room.ColumnInfo

data class DtoWindSpeed (
    @ColumnInfo(name="windSpeedAverage")
    val average : Double,
    @ColumnInfo(name="windSpeedSamplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="windSpeedMin")
    val min : Double,
    @ColumnInfo(name="windSpeedMax")
    val max : Double
)