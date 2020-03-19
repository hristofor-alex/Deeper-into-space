package com.example.networkmodule.retrofit.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetWindDirections(
        @Json(name = "0")
    val direction0: NetWind?,
        @Json(name = "1")
    val direction1: NetWind?,
        @Json(name = "2")
    val direction2: NetWind?,
        @Json(name = "3")
    val direction3: NetWind?,
        @Json(name = "4")
    val direction4: NetWind?,
        @Json(name = "5")
    val direction5: NetWind?,
        @Json(name = "6")
    val direction6: NetWind?,
        @Json(name = "7")
    val direction7: NetWind?,
        @Json(name = "8")
    val direction8: NetWind?,
        @Json(name = "9")
    val direction9: NetWind?,
        @Json(name = "10")
    val direction10: NetWind?,
        @Json(name = "11")
    val direction11: NetWind?,
        @Json(name = "12")
    val direction12: NetWind?,
        @Json(name = "13")
    val direction13: NetWind?,
        @Json(name = "14")
    val direction14: NetWind?,
        @Json(name = "15")
    val direction15: NetWind?,
        @Json(name = "most_common")
    val mostCommon: NetWind?
)