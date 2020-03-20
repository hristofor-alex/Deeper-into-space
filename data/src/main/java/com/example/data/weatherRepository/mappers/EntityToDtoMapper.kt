package com.example.data.weatherRepository.mappers

import com.example.data.weatherRepository.utils.toDto
import com.example.domain.entity.Sol
import com.example.localdb.dto.DtoSol

class EntityToDtoMapper : Mapper<Sol, DtoSol> {
    override fun map(from: Sol): DtoSol {
        return DtoSol (
        sol = from.sol,
        temperature = from.temperature.toDto(),
        windSpeed = from.windSpeed.toDto(),
        pressure = from.pressure.toDto(),
        windDirections = from.windDirections.toDto(),
        season = from.season,
        firstUtc = from.firstUtc,
        lastUtc = from.lastUtc
        )
    }
}