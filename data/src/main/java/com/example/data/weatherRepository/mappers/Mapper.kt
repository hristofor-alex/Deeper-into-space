package com.example.data.weatherRepository.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}