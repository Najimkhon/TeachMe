package com.example.teachme.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.example.teachme.repositories.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val mainRepository: MainRepository
): ViewModel() {
}