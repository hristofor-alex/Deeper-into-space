package com.example.networkmodule.retrofit.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SolKeys(
    @Json(name = "sol_keys")
    val sol_keys: List<String?>
)