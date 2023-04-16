package com.example.teachme.ui.layouts

import android.content.Context
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.teachme.data.models.LessonPM
import com.example.teachme.data.models.StudentPM
import com.example.teachme.databinding.LessonItemBinding
import com.example.teachme.databinding.StudentItemBinding

class LessonItemLayout(context: Context) :
    RelativeLayout(context) {

        private val binding = LessonItemBinding.inflate(LayoutInflater.from(context), this, true)

    fun fillContent(lessonPM: LessonPM){
        binding.lessonTitle.text = lessonPM.title
    }
}