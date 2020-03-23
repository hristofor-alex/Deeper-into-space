package com.example.localdb

/**
 * Weather database factory
 */
interface DbWeatherFactory {
    /**
     * create weather database
     */
    fun createDbWeather(): DbWeather
}