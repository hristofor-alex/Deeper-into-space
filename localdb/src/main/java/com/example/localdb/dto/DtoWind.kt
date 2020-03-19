package com.example.localdb.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DtoWind (
    @Json(name = "compassPoint")
    val compassPoint: String,
    @Json(name = "power")
    val power: Int
)