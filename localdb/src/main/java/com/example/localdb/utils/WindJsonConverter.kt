package com.example.localdb.utils

import androidx.room.TypeConverter
import com.example.localdb.dto.DtoWind
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class WindJsonConverter {
    val moshi = Moshi.Builder().build()
    @TypeConverter
    fun windsToJson(wind : List<DtoWind>) : String {
        val type = Types.newParameterizedType(
            List::class.java,
            DtoWind::class.java)
        val windAdapter = moshi.adapter<List<DtoWind>>(type)
        return windAdapter.toJson(wind)
    }

    @TypeConverter
    fun jsonToWinds(data : String) : List<DtoWind> {
        val type = Types.newParameterizedType(
            List::class.java,
            DtoWind::class.java)
        val windAdapter = moshi.adapter<List<DtoWind>>(type)
        return windAdapter.fromJson(data)?:ArrayList()
    }

}

