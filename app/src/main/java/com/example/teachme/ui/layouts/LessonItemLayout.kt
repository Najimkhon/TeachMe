package com.example.teachme.ui.layouts

import android.content.Context
import android.view.LayoutInflater
import android.widget.RelativeLayout
import com.example.teachme.data.models.LessonPM
import com.example.teachme.databinding.LessonItemBinding
import java.text.SimpleDateFormat
import java.util.*

class LessonItemLayout(context: Context, private val listener: OnClickListener) :
    RelativeLayout(context) {

    private val binding = LessonItemBinding.inflate(LayoutInflater.from(context), this, true)
    private val timeFormatter = SimpleDateFormat("HH:mm", Locale.US)

    fun fillContent(lessonPM: LessonPM) {

        val startTime = timeFormatter.format(lessonPM.startTime)
        val endTime = timeFormatter.format(lessonPM.endTime)
        val studentCount = lessonPM.students.size

        binding.apply {
            tvTime.text = "$startTime-$endTime"
            lessonTitle.text = lessonPM.title
            tvRate.text = lessonPM.rate.name
            tvStudentsCount.text = "$studentCount Students"
        }
        binding.itemLayout.setOnClickListener{
            listener.onItemClicked(lessonPM)
        }

    }

    interface OnClickListener{
        fun onItemClicked(lesson: LessonPM)
    }
}