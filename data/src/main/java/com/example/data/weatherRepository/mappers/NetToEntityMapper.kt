package com.example.data.weatherRepository.mappers

import com.example.data.weatherRepository.utils.toDate
import com.example.data.weatherRepository.utils.toEntity
import com.example.domain.entity.Sol
import com.example.networkmodule.retrofit.model.NetSol

class NetToEntityMapper : Mapper<NetSol, Sol>{
    override fun map(from: NetSol): Sol {
        return Sol(
                sol = from.sol,
                temperature = from.temperature.toEntity(),
                windSpeed = from.windSpeed.toEntity(),
                pressure = from.pressure.toEntity(),
                windDirections = from.windDirections.toEntity(),
                season = from.season,
                firstUtc = from.firstUtc.toDate(),
                lastUtc = from.lastUtc.toDate()
        )
    }
}