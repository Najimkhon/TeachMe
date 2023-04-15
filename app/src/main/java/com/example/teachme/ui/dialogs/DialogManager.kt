package com.example.teachme.ui.dialogs

import androidx.fragment.app.FragmentManager
import javax.inject.Inject


class DialogManager @Inject constructor(private val fragmentManager: FragmentManager) {

    fun showStudentsListDialog(listener: OnDialogClickListener) {
        val dialog = StudentListDialog(listener)
        dialog.show(fragmentManager, "MuscleGroupDialog")
    }
}


interface OnDialogClickListener {
    fun onSaveClicked(input: String)
}

