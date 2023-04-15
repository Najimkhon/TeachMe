package com.example.teachme.ui.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.teachme.databinding.StudentListDialogBinding

class StudentListDialog(private val listener: OnDialogClickListener) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dialogBinding =
            StudentListDialogBinding.inflate(layoutInflater, null, false)


        dialog?.setCanceledOnTouchOutside(true)
        dialog?.setCancelable(true)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBinding.btnSelect.setOnClickListener {
            listener.onSaveClicked("")
            dialog?.cancel()
        }
        dialogBinding.btnCancel.setOnClickListener {
            dialog?.cancel()
        }
        dialog?.show()

        return dialogBinding.root

    }
}