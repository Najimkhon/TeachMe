package com.example.teachme.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teachme.data.models.LessonPM
import com.example.teachme.data.models.StudentPM

@Dao
interface LessonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLesson(lessonPM: LessonPM)

    @Delete
    suspend fun deleteLesson(lessonPM: LessonPM)

    @Query("SELECT * FROM lesson_table ORDER BY id DESC")
    fun getAllLessons(): LiveData<List<LessonPM>>



    @Query("SELECT * FROM lesson_table WHERE (startDate > :date AND selectedDays LIKE :selectedDays AND autogenerateLessons = 1) OR (startDate = :date AND selectedDays LIKE :selectedDays)")
    fun getTodaysLessons(date: Long, selectedDays: String): LiveData<List<LessonPM>>
}