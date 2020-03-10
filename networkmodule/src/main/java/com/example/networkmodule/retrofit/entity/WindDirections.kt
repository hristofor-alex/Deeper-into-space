package com.example.networkmodule.retrofit.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindDirections(
    @Json(name = "0")
    val direction0: Wind?,
    @Json(name = "1")
    val direction1: Wind?,
    @Json(name = "2")
    val direction2: Wind?,
    @Json(name = "3")
    val direction3: Wind?,
    @Json(name = "4")
    val direction4: Wind?,
    @Json(name = "5")
    val direction5: Wind?,
    @Json(name = "6")
    val direction6: Wind?,
    @Json(name = "7")
    val direction7: Wind?,
    @Json(name = "8")
    val direction8: Wind?,
    @Json(name = "9")
    val direction9: Wind?,
    @Json(name = "10")
    val direction10: Wind?,
    @Json(name = "11")
    val direction11: Wind?,
    @Json(name = "12")
    val direction12: Wind?,
    @Json(name = "13")
    val direction13: Wind?,
    @Json(name = "14")
    val direction14: Wind?,
    @Json(name = "15")
    val direction15: Wind?,
    @Json(name = "most_common")
    val mostCommon: Wind?
)