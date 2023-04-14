package com.example.teachme.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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

    fun insertStudent(studentPM: StudentPM) = viewModelScope.launch {
        mainRepository.insertStudent(studentPM)
    }

    fun deleteStudent(studentPM: StudentPM) = viewModelScope.launch {
        mainRepository.deleteStudent(studentPM)
    }
}