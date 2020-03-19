package com.example.networkmodule.retrofit.model

import com.example.networkmodule.retrofit.dto.NetPressure
import com.example.networkmodule.retrofit.dto.NetTemperature
import com.example.networkmodule.retrofit.dto.NetWindDirections
import com.example.networkmodule.retrofit.dto.NetWindSpeed
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetSol(
        var sol : String = "",
        @Json(name = "AT")
    val temperature: NetTemperature,
        @Json(name = "HWS")
    val windSpeed: NetWindSpeed,
        @Json(name = "PRE")
    val pressure: NetPressure,
        @Json(name = "WD")
    val windDirections: NetWindDirections,
        @Json(name = "Season")
    val season: String,
        @Json(name = "First_UTC")
    val firstUtc: String,
        @Json(name = "Last_UTC")
    val lastUtc: String
)