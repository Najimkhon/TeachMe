package com.example.teachme.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.teachme.data.models.StudentPM


@Database(
    entities = [StudentPM::class],
    version = 1
)

abstract class TeachMeDb : RoomDatabase() {

    abstract fun getRunDao(): StudentDAO
}