package com.example.presentation.utils

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.data.weatherRepository.WeatherRepository
import com.example.data.weatherRepository.kodein.KodeinRepositoryModule
import com.example.data.weatherRepository.mappers.SolMapper
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance


class UpdateWeatherWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params), KodeinAware  {
    override val kodein: Kodein = Kodein {
        import(KodeinRepositoryModule(context).kodein)
    }
    val repository by instance<WeatherRepository>()

    override suspend fun doWork(): Result {
        val sols = repository.remoteRequestWeather()

        Log.i("intoDo", "before for ${sols.size}")
        if (sols.isNotEmpty()) {
            sols.forEach {
                Log.i("intoDo", "in for ${it.sol}")
                repository.save(SolMapper().map(it))
            }


        }
//
        return Result.success()
    }
}