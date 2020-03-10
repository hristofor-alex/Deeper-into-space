package com.example.localdb.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class WindSpeed (
    @ColumnInfo(name="average")
    val average : Double,
    @ColumnInfo(name="samplesOverTheSol")
    val samplesOverTheSol : Long,
    @ColumnInfo(name="min")
    val min : Double,
    @ColumnInfo(name="max")
    val max : Double
)