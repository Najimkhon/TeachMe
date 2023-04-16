package com.example.teachme.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.teachme.data.models.StudentPM
import com.example.teachme.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {

    private val _searchResults = MutableLiveData<List<StudentPM>>()
    val searchResults: LiveData<List<StudentPM>> = _searchResults

    fun setSearchResults(results: List<StudentPM>) {
        _searchResults.postValue(results)
    }

    fun searchThroughDatabase(query: String): LiveData<List<StudentPM>> {
        val result = mainRepository.searchThroughDatabase(query)
        return result
    }
}