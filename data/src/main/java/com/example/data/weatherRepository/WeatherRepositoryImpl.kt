package com.example.data.weatherRepository

import android.content.Context
import com.example.data.weatherRepository.mappers.DtoToEntityMapper
import com.example.data.weatherRepository.mappers.EntityToDtoMapper
import com.example.data.weatherRepository.mappers.NetToEntityMapper
import com.example.domain.entity.Sol
import com.example.domain.repositories.WeatherRepository
import com.example.localdb.DbWeather
import com.example.localdb.dto.DtoSol
import com.example.networkmodule.retrofit.WeatherMars
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
    private val mapperDtoToEntity = DtoToEntityMapper()
    private val mapperNetToEntity = NetToEntityMapper()
    private val mapperEntityToDto = EntityToDtoMapper()


    init {
        weatherDatabase.init(context)
    }

    override fun getWeather(date: Date): Flow<List<Sol>> {
        return weatherDatabase.getSols(date).map { it.map { mapperDtoToEntity.map(it) } }
    }

    override suspend fun remoteRequestWeather(): List<Sol> {
        return weatherRetrofit.getWeather().map { mapperNetToEntity.map(it) }
    }

    override suspend fun save(vararg sol: Sol) {
        weatherDatabase.insertSol(*sol.map { mapperEntityToDto.map(it)}.toTypedArray())
    }

}