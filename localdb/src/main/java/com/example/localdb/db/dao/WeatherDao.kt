package com.example.localdb.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.localdb.entity.Sol
import kotlinx.coroutines.flow.Flow
import java.util.*


@Dao
interface WeatherDao {
    //TODO: check for between
    @Query ("SELECT * FROM Sol WHERE firstUtc >= :date")
    fun getSols(date : Date): Flow<List<Sol>>

    @Insert
    fun insertSol(sol: Sol)

   // @Query ("SELECT * FROM Sol WHERE sol=(SELECT MAX(sol) FROM Sol) LIMIT 1")
    // fun latestSol(): Sol
}