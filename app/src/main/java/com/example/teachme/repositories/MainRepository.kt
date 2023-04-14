package com.example.teachme.repositories

import androidx.lifecycle.LiveData
import com.example.teachme.data.db.StudentDAO
import com.example.teachme.data.models.StudentPM
import javax.inject.Inject

class MainRepository @Inject constructor(
    val studentDAO: StudentDAO
) {

    suspend fun insertStudent(studentPM: StudentPM) = studentDAO.insertStudent(studentPM)

    suspend fun deleteStudent(studentPM: StudentPM) = studentDAO.deleteStudent(studentPM)

    fun getAllStudents() = studentDAO.getAllStudents()

}