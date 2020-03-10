package com.example.localdb.entity

import androidx.room.*
import com.example.localdb.utils.WindJsonConverter

data class WindDirections (
        val winds: List<Wind?>
)