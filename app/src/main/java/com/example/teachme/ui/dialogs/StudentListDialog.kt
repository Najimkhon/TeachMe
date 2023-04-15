package com.example.teachme.ui.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.databinding.StudentListDialogBinding
import com.example.teachme.ui.adapters.StudentAdapter
import com.example.teachme.ui.adapters.StudentDialogAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentListDialog(private val listener: OnDialogClickListener) : DialogFragment() {

    private val viewModel: MainViewModel by viewModels()
    private val studentAdapter: StudentDialogAdapter by lazy { StudentDialogAdapter(requireContext()) }
    private var _binding: StudentListDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding =
            StudentListDialogBinding.inflate(layoutInflater, null, false)
        prepareRecyclerView()

        dialog?.setCanceledOnTouchOutside(true)
        dialog?.setCancelable(true)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        binding.btnSelect.setOnClickListener {
            listener.onSaveClicked("")
            dialog?.cancel()
        }
        binding.btnCancel.setOnClickListener {
            dialog?.cancel()
        }
        dialog?.show()

        return binding.root

    }

    private fun prepareRecyclerView() {
        binding.rvStudents.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
           // itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
        viewModel.students.observe(viewLifecycleOwner) {
            studentAdapter.setData(it)
        }
    }
}