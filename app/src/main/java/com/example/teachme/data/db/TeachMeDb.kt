package com.example.teachme.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.teachme.data.models.LessonPM
import com.example.teachme.data.models.StudentPM


@Database(
    entities = [StudentPM::class, LessonPM::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class TeachMeDb : RoomDatabase() {

    abstract fun getRunDao(): StudentDAO
}