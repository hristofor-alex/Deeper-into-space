package com.example.localdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class WindSpeed (
    @ColumnInfo(name="windSpeedAverage")
    val average : Double,
    @ColumnInfo(name="windSpeedSamplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="windSpeedMin")
    val min : Double,
    @ColumnInfo(name="windSpeedMax")
    val max : Double
)