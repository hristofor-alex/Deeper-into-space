package com.example.localdb.roomImpl

import com.example.localdb.DbWeather
import com.example.localdb.DbWeatherFactory
import com.example.localdb.RoomWeather

class RoomWeatherFactory: DbWeatherFactory {
    override fun createDbWeather(): DbWeather {
        return RoomWeather()
    }
}