package com.example.teachme.repositories

import androidx.lifecycle.LiveData
import com.example.teachme.data.db.LessonDAO
import com.example.teachme.data.db.StudentDAO
import com.example.teachme.data.models.LessonPM
import com.example.teachme.data.models.StudentPM
import javax.inject.Inject

class MainRepository @Inject constructor(
    val studentDAO: StudentDAO,
    val lessonDAO: LessonDAO
) {

    suspend fun insertStudent(studentPM: StudentPM) = studentDAO.insertStudent(studentPM)

    suspend fun deleteStudent(studentPM: StudentPM) = studentDAO.deleteStudent(studentPM)

    fun getAllStudents() = studentDAO.getAllStudents()

    fun searchThroughDatabase(query: String):LiveData<List<StudentPM>> = studentDAO.searchThroughDatabase(query)

    fun getLessonsByDate(date: Long, selectedDays: String): LiveData<List<LessonPM>> = lessonDAO.getLessonsByDate(date, selectedDays)

    suspend fun insertLesson(lessonPM: LessonPM) = lessonDAO.insertLesson(lessonPM)

    suspend fun deleteLesson(lessonPM: LessonPM) = lessonDAO.deleteLesson(lessonPM)

    suspend fun updateLesson(lessonPM: LessonPM) = lessonDAO.updateLesson(lessonPM)

    fun getLessonById(id: Int):LiveData<LessonPM> = lessonDAO.getLessonById(id)

    fun getAllLessons() = lessonDAO.getAllLessons()

}