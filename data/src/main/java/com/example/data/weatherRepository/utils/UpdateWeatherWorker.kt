package com.example.data.weatherRepository.utils

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.data.weatherRepository.WeatherRepository
import com.example.data.weatherRepository.mappers.SolMapper


class UpdateWeatherWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    val repository = WeatherRepository.getInstance()

    override suspend fun doWork(): Result {
        val sols = repository.requestRetrofit()

        Log.i("intoDo", "before for ${sols.size}")
        if (sols.isNotEmpty()) {
            sols.forEach {
                Log.i("intoDo", "in for ${it.sol}")
                repository.insertSol(SolMapper().map(it))
            }


        }
//
        return Result.success()
    }
}