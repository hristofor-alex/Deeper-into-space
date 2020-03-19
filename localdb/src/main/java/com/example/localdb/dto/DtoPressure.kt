package com.example.localdb.dto

import androidx.room.ColumnInfo

data class DtoPressure (
    @ColumnInfo(name="pressureAverage")
    val average : Double,
    @ColumnInfo(name="pressureSamplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="pressureMin")
    val min : Double,
    @ColumnInfo(name="pressureMax")
    val max : Double
)