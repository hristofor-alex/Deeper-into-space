package com.example.data.weatherRepository.mappers

import com.example.data.weatherRepository.utils.toEntity
import com.example.domain.entity.Sol
import com.example.localdb.dto.DtoSol

class DtoToEntityMapper : Mapper<DtoSol, Sol> {
    override fun map(from: DtoSol): Sol {
        return Sol(
                sol = from.sol,
                temperature = from.temperature.toEntity(),
                windSpeed = from.windSpeed.toEntity(),
                pressure = from.pressure.toEntity(),
                windDirections = from.windDirections.toEntity(),
                season = from.season,
                firstUtc = from.firstUtc,
                lastUtc = from.lastUtc
        )
    }
}