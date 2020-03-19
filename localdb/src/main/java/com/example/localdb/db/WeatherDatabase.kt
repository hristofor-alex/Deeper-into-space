package com.example.localdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.localdb.db.dao.WeatherDao
import com.example.localdb.dto.DtoSol
import com.example.localdb.utils.DateConverter
import com.example.localdb.utils.WindJsonConverter

@Database(entities = arrayOf(
    DtoSol::class),
    version = 1)
@TypeConverters(WindJsonConverter::class, DateConverter::class)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}