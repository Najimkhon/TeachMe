package com.example.teachme.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.teachme.data.models.StudentPM

@Dao
interface StudentDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(studentPM: StudentPM)

    @Delete
    suspend fun deleteStudent(studentPM: StudentPM)

    @Query("SELECT * FROM student_table ORDER BY id DESC")
    fun getAllStudents(): LiveData<List<StudentPM>>

    @Query("SELECT * FROM student_table WHERE fullName LIKE :query")
    fun searchThroughDatabase(query: String): LiveData<List<StudentPM>>
}