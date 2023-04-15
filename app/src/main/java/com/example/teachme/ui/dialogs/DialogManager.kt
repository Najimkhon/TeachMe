package com.example.teachme.ui.dialogs

import androidx.fragment.app.FragmentManager
import com.example.teachme.data.models.StudentPM
import javax.inject.Inject


class DialogManager @Inject constructor(private val fragmentManager: FragmentManager) {

    fun showStudentsListDialog(listener: OnDialogClickListener) {
        val dialog = StudentListDialog(listener)
        dialog.show(fragmentManager, "StudentListDialog")
    }
}


interface OnDialogClickListener {
    fun onSaveClicked(selectedStudents: List<StudentPM>)
}

