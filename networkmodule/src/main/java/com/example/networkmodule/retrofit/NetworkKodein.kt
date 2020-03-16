package com.example.networkmodule.retrofit

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class NetworkKodein {
    val kodein = Kodein.Module {
        bind<WeatherMarsFactory>() with provider { RetrofitWeatherFactory() }
        bind<WeatherMars>() with singleton { instance<WeatherMarsFactory>().createWeatherMars() }
    }
}