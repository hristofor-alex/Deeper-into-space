package com.example.data.weatherRepository.mappers


import com.example.data.weatherRepository.utils.toDate
import com.example.data.weatherRepository.utils.toDto
import com.example.localdb.dto.DtoSol
import com.example.networkmodule.retrofit.model.NetSol

class DtoNetToLocalMapper : Mapper<NetSol, DtoSol> {
    override  fun map(from: NetSol): DtoSol {
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