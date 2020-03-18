package com.example.networkmodule.kodein

import com.example.networkmodule.retrofit.RetrofitWeatherFactory
import com.example.networkmodule.retrofit.WeatherMars
import com.example.networkmodule.retrofit.WeatherMarsFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KodeinNetworkModule  {
    val kodein = Kodein.Module("network") {
        bind<WeatherMarsFactory>() with provider {RetrofitWeatherFactory()}
        bind<WeatherMars>() with singleton { instance<WeatherMarsFactory>().createWeatherMars() }
    }

}