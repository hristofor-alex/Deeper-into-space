package com.example.networkmodule.retrofit

import com.example.networkmodule.BuildConfig
import com.example.networkmodule.retrofit.entity.SolKeys
import com.example.networkmodule.retrofit.model.Sol
import com.example.networkmodule.retrofit.net.GetWeather
import com.example.networkmodule.retrofit.net.WeatherClientInstance
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import okhttp3.OkHttpClient
import retrofit2.Callback

class RetrofitWeather : WeatherMars {
    private val apiKey = BuildConfig.NASA_API_KEY
    private val feedType = "json"
    private val version = "1.0"

    override suspend fun getWeather(): Flow<Sol> {
    //TODO: add okHTTP Builder with timeout
        val weatherService = WeatherClientInstance.retrofit.create(GetWeather::class.java)
        val jsonWeather = weatherService.getWeather(apiKey, feedType, version)
        val solList = parseJsonToSol(jsonWeather)
        return flow {
            for (i in solList)
                emit(i)
        }
    }

    fun parseJsonToSol(responseString: String): ArrayList<Sol> {
        val moshi = Moshi.Builder().build()

        val solsKeyAdapter = moshi.adapter(SolKeys::class.java)
        val solsKey = solsKeyAdapter.fromJson(responseString)

        val mapAdapterType = Types.newParameterizedType(
            MutableMap::class.java,
            String::class.java,
            Any::class.java
        )

        val mapAdapter = moshi.adapter<Map<String, Any>>(mapAdapterType)
        val solObjects = mapAdapter.fromJson(responseString)

        val solAdapter = moshi.adapter(Sol::class.java)

        val solList = ArrayList<Sol>()
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