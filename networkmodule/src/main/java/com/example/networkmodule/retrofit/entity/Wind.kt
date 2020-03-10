package com.example.networkmodule.retrofit.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind(
    //TODO: delete
//    @Json(name = "compass_degrees")
//    val compassDegrees: Double,
    @Json(name = "compass_point")
    val compassPoint: String,
//    @Json(name = "compass_right")
//    val compassRight: Double,
//    @Json(name = "compass_up")
//    val compassUp: Double,
    @Json(name = "ct")
    val samplesNumber: Int
)