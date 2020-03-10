package com.example.localdb.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Wind (
    @Json(name = "compassPoint")
    val compassPoint: String,
    @Json(name = "power")
    val power: Int
)