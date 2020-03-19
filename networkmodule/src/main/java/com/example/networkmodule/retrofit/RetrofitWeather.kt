package com.example.networkmodule.retrofit

import com.example.networkmodule.BuildConfig
import com.example.networkmodule.retrofit.dto.NetSolKeys
import com.example.networkmodule.retrofit.model.NetSol
import com.example.networkmodule.retrofit.net.GetWeather
import com.example.networkmodule.retrofit.net.WeatherClientInstance
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.ExperimentalCoroutinesApi

class RetrofitWeather : WeatherMars {
    private val apiKey = BuildConfig.NASA_API_KEY
    private val feedType = "json"
    private val version = "1.0"

    @ExperimentalCoroutinesApi
    override suspend fun getWeather(): List<NetSol> {

        val weatherService = WeatherClientInstance.retrofit.create(GetWeather::class.java)
        val weatherJsonString = weatherService.getWeather(apiKey, feedType, version)

        val solList = parseJsonToSol(weatherJsonString)
        return solList
    }


    private fun parseJsonToSol(responseString: String): ArrayList<NetSol> {
        val moshi = Moshi.Builder().build()

        val solsKeyAdapter = moshi.adapter(NetSolKeys::class.java)
        val solsKey = solsKeyAdapter.fromJson(responseString)

        val mapAdapterType = Types.newParameterizedType(
            MutableMap::class.java,
            String::class.java,
            Any::class.java
        )

        val mapAdapter = moshi.adapter<Map<String, Any>>(mapAdapterType)
        val solObjects = mapAdapter.fromJson(responseString)

        val solAdapter = moshi.adapter(NetSol::class.java)

        val solList = ArrayList<NetSol>()
        for (solName in solsKey?.sol_keys ?: ArrayList()) {
            val solJson = solObjects?.get(solName)

            solJson?.let {
                val sol = solAdapter.fromJsonValue(it)?.apply {
                    sol = solName ?: ""
                }
                sol?.let {
                    solList.add(it)
                }
            }
        }
        return solList
    }
}