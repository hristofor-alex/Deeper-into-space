package com.example.deeperintospace.weatherRepository.mappers

import com.example.deeperintospace.weatherRepository.utils.toDate
import com.example.deeperintospace.weatherRepository.utils.toDto
import com.example.localdb.entity.DtoSol
import com.example.networkmodule.retrofit.model.Sol

class SolMapper : Mapper<Sol, DtoSol> {
    override  fun map(from: Sol): DtoSol {
        return DtoSol(
            sol = from.sol,
            temperature = from.temperature.toDto(),
            windSpeed = from.windSpeed.toDto(),
            pressure = from.pressure.toDto(),
            windDirections = from.windDirections.toDto(),
            season = from.season,
            firstUtc = from.firstUtc.toDate(),
            lastUtc = from.lastUtc.toDate()
        )
    }
}