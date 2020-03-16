package com.example.localdb

import com.example.localdb.roomImpl.RoomWeatherFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class DbKodein {
    val kodein = Kodein.Module {
        bind<DbWeatherFactory>() with provider { RoomWeatherFactory() }
        bind<DbWeather>() with singleton { instance<DbWeatherFactory>().createDbWeather() }
    }
}