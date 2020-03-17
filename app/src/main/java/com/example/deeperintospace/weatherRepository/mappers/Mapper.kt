package com.example.deeperintospace.weatherRepository.mappers

interface Mapper<F, T> {
     fun map(from: F): T
}