package com.example.deeperintospace

import android.app.Application
import android.content.Context
import com.example.deeperintospace.weatherRepository.WeatherRepository
import com.example.localdb.DbKodein
import com.example.networkmodule.retrofit.NetworkKodein
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class DeeperIntoSpaceApplication : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(DbKodein().kodein)
        import(NetworkKodein().kodein)

        bind<Context>() with singleton { this@DeeperIntoSpaceApplication }
        bind<WeatherRepository>() with singleton { WeatherRepository(instance(), instance(), instance()) }
    }
}