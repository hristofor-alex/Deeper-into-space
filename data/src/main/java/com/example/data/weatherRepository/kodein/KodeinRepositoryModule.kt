package com.example.data.weatherRepository.kodein

import android.content.Context
import com.example.data.weatherRepository.WeatherRepository
import com.example.data.weatherRepository.WeatherRepositoryFactory
import com.example.data.weatherRepository.WeatherRepositoryFactoryImpl
import com.example.localdb.DbWeather
import com.example.localdb.kodein.KodeinLocaldbModule
import com.example.networkmodule.kodein.KodeinNetworkModule
import com.example.networkmodule.retrofit.WeatherMars
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KodeinRepositoryModule(val context: Context) {
    val kodein = Kodein.Module("repository") {
        import(KodeinNetworkModule().kodein)
        import(KodeinLocaldbModule().kodein)
        bind<WeatherRepositoryFactory>() with provider { WeatherRepositoryFactoryImpl() }
        bind<WeatherRepository>() with singleton {
            instance<WeatherRepositoryFactory>().createWeatherRepository(
                this@KodeinRepositoryModule.context,
                instance<DbWeather>(),
                instance<WeatherMars>()
            )
        }
    }
}