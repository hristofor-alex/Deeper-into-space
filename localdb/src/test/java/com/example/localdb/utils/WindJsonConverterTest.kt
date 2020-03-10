package com.example.localdb.utils

import com.example.localdb.entity.Wind
import org.junit.Test

import org.junit.Assert.*

class WindJsonConverterTest {

    @Test
    fun windsToJson() {
        val windN = Wind("n", 23)
        val windW = Wind("w", 13)
        val windE = Wind("e", 33)
        val windS = Wind("s", 43)

        val obj = WindJsonConverter()
        val list = listOf<Wind>(windN, windW, windE, windS)
        val s = obj.windsToJson(list)
        val list2 = obj.jsonToWinds(s)
        assertEquals(windN.compassPoint, list2[0].compassPoint)
        assertEquals(windW.compassPoint, list2[1].compassPoint)
        assertEquals(windE.compassPoint, list2[2].compassPoint)
        assertEquals(windS.compassPoint, list2[3].compassPoint)

        assertEquals(windN.power, list2[0].power)
        assertEquals(windW.power, list2[1].power)
        assertEquals(windE.power, list2[2].power)
        assertEquals(windS.power, list2[3].power)
    }
}