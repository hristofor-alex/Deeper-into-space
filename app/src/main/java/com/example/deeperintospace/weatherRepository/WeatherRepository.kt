package com.example.deeperintospace.weatherRepository

import android.content.Context
import androidx.work.*
import com.example.deeperintospace.weatherRepository.utils.SyncWorker
import com.example.localdb.DbWeather
import com.example.localdb.RoomWeather
import com.example.localdb.entity.DtoSol
import com.example.networkmodule.retrofit.RetrofitWeather
import com.example.networkmodule.retrofit.model.Sol
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

import java.util.*
import java.util.concurrent.TimeUnit

@FlowPreview
@ExperimentalCoroutinesApi
class WeatherRepository private constructor(val context: Context) {
    private val weatherDatabase: DbWeather = RoomWeather()
    private val weatherRetrofit: RetrofitWeather = RetrofitWeather()
    private val scope = CoroutineScope(Dispatchers.IO)


    init {
        weatherDatabase.init(context)

        val scopeForWorker = CoroutineScope(Dispatchers.IO)
        scopeForWorker.launch {
            val constraints = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val workRequest =
                PeriodicWorkRequest.Builder(SyncWorker::class.java, 16, TimeUnit.MINUTES)
                    .setConstraints(constraints)
                    .build()
            WorkManager
                .getInstance(context)
                .enqueue(workRequest)
        }
    }

    companion object {
        const val DAY_IN_MS = 1000 * 60 * 60 * 24;
        private var INSTANCE: WeatherRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = WeatherRepository(context)
            }
        }

        fun getInstance() = INSTANCE ?: throw IllegalStateException("Not init")
    }


    fun getWeatherFromLastTenDays(): Flow<List<DtoSol>> {
        val tenDaysBeforeToday = Date(System.currentTimeMillis() - (10 * DAY_IN_MS))
        return weatherDatabase.getSols(tenDaysBeforeToday)
    }

    suspend fun requestRetrofit(): List<Sol> {
        return weatherRetrofit.getWeather()
    }

    suspend fun insertSol(sol : DtoSol) {
        weatherDatabase.insertSol(sol)
    }

}