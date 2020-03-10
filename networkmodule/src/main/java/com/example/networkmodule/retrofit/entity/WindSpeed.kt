package com.example.networkmodule.retrofit.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindSpeed(
    @Json(name = "av")
    val average: Double,
    @Json(name = "ct")
    val samplesOverTheSol: Long,
    @Json(name = "mn")
    val min: Double,
    @Json(name = "mx")
    val max: Double
)