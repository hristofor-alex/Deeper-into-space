package com.example.presentation.app

import android.app.Application
import android.util.Log
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.*
import com.example.data.weatherRepository.kodein.KodeinRepositoryModule
import com.example.presentation.utils.UpdateWeatherWorker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import java.util.concurrent.TimeUnit

class DeeperIntoSpaceApplication : Application(), KodeinAware {

    override val kodein: Kodein by Kodein.lazy {
        import(KodeinRepositoryModule(applicationContext).kodein)
    }

    override fun onCreate() {
        super.onCreate()
        startWeatherWorker()
    }

    private fun startWeatherWorker() {
        val scopeForWorker = CoroutineScope(Dispatchers.IO)
        scopeForWorker.launch {
            val constr = Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build()

            val workRequest =
                PeriodicWorkRequest.Builder(UpdateWeatherWorker::class.java, 7, TimeUnit.HOURS)
                    .setConstraints(constr)
                    .build()
            WorkManager
                .getInstance(applicationContext)
                .enqueue(workRequest)
        }
    }
}