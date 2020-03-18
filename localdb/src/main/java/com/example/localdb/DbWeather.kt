package com.example.localdb

import android.content.Context
import com.example.localdb.entity.DtoSol
import kotlinx.coroutines.flow.Flow
import java.util.*

interface DbWeather {
    fun init(context:Context)
    fun getSols(date : Date): Flow<List<DtoSol>>
    suspend fun insertSol(sol: DtoSol)
}