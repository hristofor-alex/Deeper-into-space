package com.example.localdb.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.localdb.dto.DtoSol
import kotlinx.coroutines.flow.Flow
import java.util.*


@Dao
interface WeatherDao {
    @Query ("SELECT * FROM DtoSol WHERE firstUtc >= :date")
    fun getSols(date : Date): Flow<List<DtoSol>>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertSol(vararg sol: DtoSol)
}