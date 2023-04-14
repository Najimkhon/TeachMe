package com.example.teachme.ui.fragments

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentPaidStudentListBinding
import com.example.teachme.ui.adapters.StudentAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaidStudentListFragment :
    BaseFragment<FragmentPaidStudentListBinding>(FragmentPaidStudentListBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    private val studentAdapter: StudentAdapter by lazy { StudentAdapter(requireContext()) }

    override fun prepareUI() {
        viewModel.students.observe(viewLifecycleOwner) {
            it.forEach {
                println("Students name: ${it.fullName}")
            }
        }
    }

    override fun assignObjects() {
        val rv = binding.rvStudents
        rv.adapter = studentAdapter
        rv.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        viewModel.students.observe(viewLifecycleOwner) {
            studentAdapter.setData(it)
        }
    }

    override fun setObservers() {

    }

}