package com.example.localdb.dto

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "DtoSol")
data class DtoSol (
        @PrimaryKey()
    val sol: String,
        @Embedded
    val temperature: DtoTemperature,
        @Embedded
    val windSpeed: DtoWindSpeed,
        @Embedded
    val pressure: DtoPressure,
        @Embedded
    val windDirections: DtoWindDirections,
        @ColumnInfo(name = "season")
    val season: String,
        @ColumnInfo(name = "firstUtc")
    val firstUtc: Date,
        @ColumnInfo(name = "lastUtc")
    val lastUtc: Date
)