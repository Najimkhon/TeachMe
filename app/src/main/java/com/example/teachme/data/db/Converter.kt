package com.example.teachme.data.db

import androidx.room.TypeConverter
import com.example.teachme.data.models.Rate

class Converter {

    @TypeConverter
    fun fromRate(rate: Rate): String {
        return rate.name
    }

    @TypeConverter
    fun toRate(rate: String): Rate {
        return Rate.valueOf(rate)
    }
}