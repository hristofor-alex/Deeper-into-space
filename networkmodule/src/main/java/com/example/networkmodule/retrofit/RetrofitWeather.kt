package com.example.networkmodule.retrofit

import android.util.Log
import com.example.networkmodule.BuildConfig
import com.example.networkmodule.retrofit.entity.SolKeys
import com.example.networkmodule.retrofit.model.Sol
import com.example.networkmodule.retrofit.net.GetWeather
import com.example.networkmodule.retrofit.net.WeatherClientInstance
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitWeather : WeatherMars {
    private val apiKey = BuildConfig.NASA_API_KEY
    private val feedType = "json"
    private val version = "1.0"

    private val flowScope = CoroutineScope(Dispatchers.IO)

    @ExperimentalCoroutinesApi
    override fun getWeather(): Flow<List<Sol>> {
    //TODO: add okHTTP Builder with timeout
        val weatherService = WeatherClientInstance.retrofit.create(GetWeather::class.java)
        val weatherCall = weatherService.getWeather(apiKey, feedType, version)

        return callbackFlow {
            weatherCall.enqueue(object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {

                }

                override fun onResponse(call: Call<String>, response: Response<String>) {
                    val solList = parseJsonToSol(response.body()?:"")
                    offer(solList)
                }
            })

            awaitClose {
                weatherCall.cancel()
            }
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