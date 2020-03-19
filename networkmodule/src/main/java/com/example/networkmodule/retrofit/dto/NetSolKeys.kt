package com.example.networkmodule.retrofit.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetSolKeys(
    @Json(name = "sol_keys")
    val sol_keys: List<String?>
)