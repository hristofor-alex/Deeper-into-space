package com.example.networkmodule.retrofit.net

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GetWeather {

    @GET("/insight_weather/")
    fun getWeather(
        @Query("api_key") apiKey: String,
        @Query("feedtype") feedtype: String,
        @Query("ver") ver: String
    ): Call<String>
}