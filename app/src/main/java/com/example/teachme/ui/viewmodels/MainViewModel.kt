package com.example.teachme.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teachme.data.models.LessonPM
import com.example.teachme.data.models.StudentPM
import com.example.teachme.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    val students = mainRepository.getAllStudents()
    val lessons = mainRepository.getAllLessons()

    fun insertStudent(studentPM: StudentPM) = viewModelScope.launch {
        mainRepository.insertStudent(studentPM)
    }

    fun deleteStudent(studentPM: StudentPM) = viewModelScope.launch {
        mainRepository.deleteStudent(studentPM)
    }

    fun insertLesson(lessonPM: LessonPM) = viewModelScope.launch {
        mainRepository.insertLesson(lessonPM)
    }

    fun deleteLesson(lessonPM: LessonPM) = viewModelScope.launch {
        mainRepository.deleteLesson(lessonPM)
    }

    fun getLessonsByDate(date: Long, selectedDays: String): LiveData<List<LessonPM>> = mainRepository.getLessonsByDate(date, selectedDays)
}