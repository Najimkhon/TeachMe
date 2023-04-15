package com.example.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_table")
data class LessonPM(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var title: String,
    var startDate: Long,
    var selectedDays: String,
    var startTime: Long,
    var endTime: Long,
    var rate: Rate,
    var note: String,
    var students: List<StudentPM>,
    var autogenerateLessons: Boolean
)