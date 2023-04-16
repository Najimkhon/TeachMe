package com.example.teachme.ui.layouts

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.RelativeLayout
import com.example.teachme.data.models.StudentPM
import com.example.teachme.databinding.StudentItemBinding

class StudentItemLayout(context: Context) : RelativeLayout(context) {

    private val binding = StudentItemBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
    }

    fun fillContent(studentPM: StudentPM) {
        binding.tvName.text = studentPM.fullName
    }
}