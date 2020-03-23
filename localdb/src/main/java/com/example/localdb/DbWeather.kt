package com.example.localdb

import android.content.Context
import com.example.localdb.dto.DtoSol
import kotlinx.coroutines.flow.Flow
import java.util.*

/**
 * Describes weather data base interface
 */
interface DbWeather {
    /**
     * data base initialization
     */
    fun init(context:Context)

    /**
     * request sols information from the [date]
     */
    fun getSols(date : Date): Flow<List<DtoSol>>

    /**
     * save or update information about sol
     */
    suspend fun insertSol(vararg sol: DtoSol)
}