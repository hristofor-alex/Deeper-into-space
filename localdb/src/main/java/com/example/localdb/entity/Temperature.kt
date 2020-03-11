package com.example.localdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Temperature (
    @ColumnInfo(name="temperatureAverage")
    val average : Double,
    @ColumnInfo(name="temperatureSamplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="temperatureMin")
    val min : Double,
    @ColumnInfo(name="temperatureMax")
    val max : Double
)