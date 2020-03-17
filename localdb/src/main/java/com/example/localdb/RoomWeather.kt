package com.example.localdb

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.localdb.entity.DtoSol
import com.example.localdb.exeptions.DatabaseInitException
import kotlinx.coroutines.flow.Flow
import java.util.*


class RoomWeather : DbWeather  {

    var db: WeatherDatabase? = null

    override fun init(context: Context) {
        db = Room.databaseBuilder(context, WeatherDatabase::class.java, "weather_database").build()
    }

    override fun getSols(date: Date): Flow<List<DtoSol>> {
        db?.let {
            return it.weatherDao().getSols(date)
        }
        throw DatabaseInitException("init db")
    }

    override fun insertSol(sol: DtoSol) {
        Log.i("inse", "before insert")
        db?.weatherDao()?.insertSol(sol)
        Log.i("inse", "after insert")
    }
}