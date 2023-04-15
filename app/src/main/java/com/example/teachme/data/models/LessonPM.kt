package com.example.teachme.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "lesson_table")
@Parcelize
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
) : Parcelable