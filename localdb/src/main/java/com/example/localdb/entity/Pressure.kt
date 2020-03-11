package com.example.localdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class Pressure (
    @ColumnInfo(name="pressureAverage")
    val average : Double,
    @ColumnInfo(name="pressureSamplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="pressureMin")
    val min : Double,
    @ColumnInfo(name="pressureMax")
    val max : Double
)