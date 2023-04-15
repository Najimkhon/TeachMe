package com.example.teachme.ui.layouts

import android.content.Context
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.fragment.app.viewModels
import com.example.teachme.data.models.StudentPM
import com.example.teachme.databinding.StudentDialogItemBinding
import com.example.teachme.ui.viewmodels.MainViewModel

class StudentDialogItemLayout(context: Context) :
    RelativeLayout(context) {

    private val binding = StudentDialogItemBinding.inflate(LayoutInflater.from(context), this, true)

    fun fillContent(studentPM: StudentPM) {
        binding.tvName.text = studentPM.fullName
        binding.cbAdded.isChecked = studentPM.isChecked
        binding.cbAdded.setOnCheckedChangeListener { view, isChecked ->
            studentPM.isChecked = isChecked
        }
    }
}
