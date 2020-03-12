package com.example.localdb

import android.content.Context
import com.example.localdb.entity.Sol
import kotlinx.coroutines.flow.Flow
import java.util.*

interface DbWeather {
    fun init(context:Context)
    fun getSols(date : Date): Flow<List<Sol>>
    suspend fun insertSol(sol: Sol)
}