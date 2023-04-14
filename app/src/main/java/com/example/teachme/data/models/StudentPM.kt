package com.example.teachme.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class StudentPM(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var fullName: String,
    var telegram: String,
    var address: String,
    var phone: String,
    var payment: Int
)
