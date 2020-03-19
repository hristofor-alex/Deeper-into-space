package com.example.networkmodule.retrofit.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetTemperature(
    @Json(name = "av")
    val average: Double,
    @Json(name = "ct")
    val samplesOverTheSol: Long,
    @Json(name = "mn")
    val min: Double,
    @Json(name = "mx")
    val max: Double
)