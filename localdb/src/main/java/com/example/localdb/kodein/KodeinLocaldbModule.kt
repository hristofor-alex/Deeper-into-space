package com.example.localdb.kodein

import android.system.Os.bind
import com.example.localdb.DbWeather
import com.example.localdb.DbWeatherFactory
import com.example.localdb.roomImpl.RoomWeatherFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class KodeinLocaldbModule() {
    val kodein = Kodein.Module("localdb"){
        bind<DbWeatherFactory>() with provider {RoomWeatherFactory()}
        bind<DbWeather>() with singleton { instance<DbWeatherFactory>().createDbWeather() }
    }
}