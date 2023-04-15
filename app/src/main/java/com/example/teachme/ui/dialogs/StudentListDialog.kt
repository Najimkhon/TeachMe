package com.example.teachme.ui.dialogs

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.R
import com.example.teachme.data.models.StudentPM
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
    private lateinit var recyclerView: RecyclerView

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
            val selectedStudents = mutableListOf<StudentPM>()
            recyclerView.post {
                for (i in 0 until recyclerView.childCount) {
                    val itemView = recyclerView.getChildAt(i)
                    val checkBox = itemView.findViewById<CheckBox>(R.id.cbAdded)
                    if (checkBox.isChecked) {
                        val student = studentAdapter.getItem(i)
                        selectedStudents.add(student)
                    }
                }
                println("Selected students count: ${selectedStudents.size}")
                listener.onSaveClicked(selectedStudents)
                dialog?.cancel()
            }
        }
        binding.btnCancel.setOnClickListener {
            dialog?.cancel()
        }
        dialog?.show()

        return binding.root

    }

    private fun prepareRecyclerView() {
        recyclerView = binding.rvStudents
        recyclerView.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
           // itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
        viewModel.students.observe(viewLifecycleOwner) {
            val newlist = mutableListOf<StudentPM>()
            studentAdapter.setData(it)
        }
    }
}