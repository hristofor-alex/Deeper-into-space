package com.example.localdb.utils

import androidx.room.TypeConverter
import com.example.localdb.entity.Wind
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class WindJsonConverter {
    val moshi = Moshi.Builder().build()
    @TypeConverter
    fun windsToJson(wind : List<Wind>) : String {
        val type = Types.newParameterizedType(
            List::class.java,
            Wind::class.java)
        val windAdapter = moshi.adapter<List<Wind>>(type)
        return windAdapter.toJson(wind)
    }

    @TypeConverter
    fun jsonToWinds(data : String) : List<Wind> {
        val type = Types.newParameterizedType(
            List::class.java,
            Wind::class.java)
        val windAdapter = moshi.adapter<List<Wind>>(type)
        return windAdapter.fromJson(data)?:ArrayList()
    }

}

