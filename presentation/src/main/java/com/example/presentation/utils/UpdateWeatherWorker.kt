package com.example.presentation.utils

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.domain.repositories.WeatherRepository
import com.example.data.weatherRepository.mappers.DtoNetToLocalMapper
import com.example.localdb.dto.DtoSol
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class UpdateWeatherWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params), KodeinAware  {
    override val kodein by kodein(context)

    private val repository: com.example.domain.repositories.WeatherRepository by instance()

    override suspend fun doWork(): Result {
        val sols = repository.remoteRequestWeather()

        Log.i("intoDo", "before for ${sols.size}")
        if (sols.isNotEmpty()) {
            val dto = ArrayList<DtoSol>()
            sols.forEach {
                dto.add(DtoNetToLocalMapper().map(it))
            }
            repository.save(*dto.toTypedArray())
            return Result.success()
        }
        return Result.retry()
    }
}