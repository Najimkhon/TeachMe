package com.example.teachme.ui.layouts

import android.content.Context
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.teachme.data.models.StudentPM
import com.example.teachme.databinding.SelectedStudentItemBinding
import com.example.teachme.databinding.StudentItemBinding

class SelectedStudentItemLayout(context: Context) :
    RelativeLayout(context) {

        private val binding = SelectedStudentItemBinding.inflate(LayoutInflater.from(context), this, true)

    fun fillContent(studentPM: StudentPM){
        binding.tvName.text = studentPM.fullName
    }
}