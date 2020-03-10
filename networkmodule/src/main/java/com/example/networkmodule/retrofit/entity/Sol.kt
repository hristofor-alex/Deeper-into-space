package com.example.networkmodule.retrofit.model

import com.example.networkmodule.retrofit.entity.Pressure
import com.example.networkmodule.retrofit.entity.Temperature
import com.example.networkmodule.retrofit.entity.WindDirections
import com.example.networkmodule.retrofit.entity.WindSpeed
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sol(
    var sol : String = "",
    @Json(name = "AT")
    val temperature: Temperature,
    @Json(name = "HWS")
    val windSpeed: WindSpeed,
    @Json(name = "PRE")
    val pressure: Pressure,
    @Json(name = "WD")
    val windDirections: WindDirections,
    @Json(name = "Season")
    val season: String,
    @Json(name = "First_UTC")
    val firstUtc: String,
    @Json(name = "Last_UTC")
    val lastUtc: String
)