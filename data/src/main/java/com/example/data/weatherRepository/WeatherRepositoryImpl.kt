package com.example.data.weatherRepository

import android.content.Context
import com.example.localdb.DbWeather
import com.example.localdb.dto.DtoSol
import com.example.networkmodule.retrofit.WeatherMars
import com.example.networkmodule.retrofit.model.NetSol
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

@FlowPreview
@ExperimentalCoroutinesApi
class WeatherRepositoryImpl(context: Context,
                            private val weatherDatabase: DbWeather,
                            private val weatherRetrofit: WeatherMars)
    : WeatherRepository {
    private val scope = CoroutineScope(Dispatchers.IO)
    private val mapper = com.example.data.weatherRepository.mappers.DtoToEntityMapper()


    init {
        weatherDatabase.init(context)
    }

    companion object {
        const val DAY_IN_MS = 1000 * 60 * 60 * 24;
    }


    override fun getWeatherFromLastTenDays(): Flow<List<com.example.domain.entity.Sol>> {
        val tenDaysBeforeToday = Date(System.currentTimeMillis() - (10 * DAY_IN_MS))
        return weatherDatabase.getSols(tenDaysBeforeToday).map { it.map { mapper.map(it) } }
    }

    override suspend fun remoteRequestWeather(): List<NetSol> {
        return weatherRetrofit.getWeather()
    }

    override suspend fun save(vararg sol: DtoSol) {
        weatherDatabase.insertSol(*sol)
    }

}