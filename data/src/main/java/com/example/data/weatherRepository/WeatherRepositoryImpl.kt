package com.example.data.weatherRepository

import android.content.Context
import com.example.localdb.DbWeather
import com.example.localdb.entity.DtoSol
import com.example.networkmodule.retrofit.WeatherMars
import com.example.networkmodule.retrofit.model.Sol
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import java.util.*

@FlowPreview
@ExperimentalCoroutinesApi
class WeatherRepositoryImpl (context: Context,
                             private val weatherDatabase: DbWeather,
                             private val weatherRetrofit: WeatherMars)
    : WeatherRepository
{
    private val scope = CoroutineScope(Dispatchers.IO)


    init {
        weatherDatabase.init(context)
    }

    companion object {
        const val DAY_IN_MS = 1000 * 60 * 60 * 24;
//        private var INSTANCE: WeatherRepository? = null
//
//        fun initialize(context: Context) {
//            if (INSTANCE == null) {
//                INSTANCE = WeatherRepository(context)
//            }
//        }
//
//        fun getInstance() = INSTANCE ?: throw IllegalStateException("Not init")
    }


    override fun getWeatherFromLastTenDays(): Flow<List<DtoSol>> {
        val tenDaysBeforeToday = Date(System.currentTimeMillis() - (10 * DAY_IN_MS))
        return weatherDatabase.getSols(tenDaysBeforeToday)
    }

    override suspend fun remoteRequestWeather(): List<Sol> {
        return weatherRetrofit.getWeather()
    }

    override suspend fun save(vararg sol: DtoSol) {
        weatherDatabase.insertSol(*sol)
    }

}