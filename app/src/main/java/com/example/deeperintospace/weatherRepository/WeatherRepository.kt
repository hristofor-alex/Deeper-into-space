package com.example.deeperintospace.weatherRepository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.localdb.DbWeather
import com.example.localdb.RoomWeather
import com.example.localdb.entity.Sol
import com.example.networkmodule.retrofit.RetrofitWeather
import org.intellij.lang.annotations.Flow

class WeatherRepository private constructor(context: Context){
    private val weatherDatabase: DbWeather = RoomWeather()
    private val weatherRetrofit = RetrofitWeather()

    init {
        weatherDatabase.init(context)
    }

    companion object {
        private var INSTANCE : WeatherRepository? = null

        fun initialize (context: Context) {
            if(INSTANCE == null) {
                INSTANCE = WeatherRepository(context)
            }
        }

        fun getInstance() = INSTANCE ?: throw IllegalStateException("Not init")
    }

    fun getWeather() : Flow<List<Sol>> {

        val sol = weatherDatabase.theBiggestSol()
        sol.
        if (sol == null)
            weatherRetrofit.getWeather()




      //  return weatherRetrofit.getWeather()
    }

}