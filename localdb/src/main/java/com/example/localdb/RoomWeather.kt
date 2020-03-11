package com.example.localdb

import android.content.Context
import androidx.room.Room
import com.example.localdb.entity.Sol
import com.example.localdb.exeptions.DatabaseInitException
import kotlinx.coroutines.flow.Flow
import java.util.*


class RoomWeather : DbWeather  {

    var db: WeatherDatabase? = null

    override fun init(context: Context) {
        db = Room.databaseBuilder(context, WeatherDatabase::class.java, "weather_db").build()
    }

    override fun getSols(date: Date): Flow<List<Sol>> {
        db?.let {
            return it.weatherDao().getSols(date)
        }
        throw DatabaseInitException("init db")
    }

    override suspend fun insertSol(sol: Sol) {
        db?.weatherDao()?.insertSol(sol)
    }
}