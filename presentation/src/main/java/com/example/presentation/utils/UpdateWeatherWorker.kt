package com.example.presentation.utils

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.data.weatherRepository.WeatherRepository
import com.example.data.weatherRepository.kodein.KodeinRepositoryModule
import com.example.data.weatherRepository.mappers.SolMapper
import com.example.localdb.entity.DtoSol
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class UpdateWeatherWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params), KodeinAware  {
    override val kodein by kodein(context)

    private val repository: WeatherRepository by instance()

    override suspend fun doWork(): Result {
        val sols = repository.remoteRequestWeather()

        Log.i("intoDo", "before for ${sols.size}")
        if (sols.isNotEmpty()) {
            val dto = ArrayList<DtoSol>()
            sols.forEach {
                dto.add(SolMapper().map(it))
            }
            repository.save(*dto.toTypedArray())
            return Result.success()
        }
        return Result.retry()
    }
}