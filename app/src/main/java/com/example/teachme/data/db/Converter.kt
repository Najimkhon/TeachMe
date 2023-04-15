package com.example.teachme.data.db

import androidx.room.TypeConverter
import com.example.teachme.data.models.Rate
import com.example.teachme.data.models.StudentPM
import com.google.gson.Gson

class Converter {

    @TypeConverter
    fun fromRate(rate: Rate): String {
        return rate.name
    }

    @TypeConverter
    fun toRate(rate: String): Rate {
        return Rate.valueOf(rate)
    }

    @TypeConverter
    fun listToJson(studentList: List<StudentPM>): String {
        return Gson().toJson(studentList)
    }

    @TypeConverter
    fun jsonToList(jsonString: String): List<StudentPM> {
        return Gson().fromJson(jsonString, Array<StudentPM>::class.java).toMutableList()
    }
}