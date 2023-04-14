package com.example.teachme.repositories

import com.example.teachme.data.db.StudentDAO
import javax.inject.Inject

class MainRepository @Inject constructor(
    val studentDAO: StudentDAO
) {
}