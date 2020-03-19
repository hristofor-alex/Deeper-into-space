package com.example.networkmodule.retrofit.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetWind(
    //TODO: delete
    @Json(name = "compass_point")
    val compassPoint: String,
    @Json(name = "ct")
    val samplesNumber: Int
)