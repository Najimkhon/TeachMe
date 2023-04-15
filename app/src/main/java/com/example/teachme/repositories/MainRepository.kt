package com.example.teachme.repositories

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

    suspend fun insertLesson(lessonPM: LessonPM) = lessonDAO.insertLesson(lessonPM)

    suspend fun deleteLesson(lessonPM: LessonPM) = lessonDAO.deleteLesson(lessonPM)

    fun getAllLessons() = lessonDAO.getAllLessons()

}