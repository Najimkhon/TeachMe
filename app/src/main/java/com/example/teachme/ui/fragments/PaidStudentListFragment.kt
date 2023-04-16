package com.example.teachme.ui.fragments

import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentPaidStudentListBinding
import com.example.teachme.ui.adapters.StudentAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import com.example.teachme.ui.viewmodels.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

@AndroidEntryPoint
class PaidStudentListFragment :
    BaseFragment<FragmentPaidStudentListBinding>(FragmentPaidStudentListBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val studentAdapter: StudentAdapter by lazy { StudentAdapter(requireContext()) }

    override fun prepareUI() {

    }

    override fun assignObjects() {
        binding.rvStudents.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
    }

    override fun setObservers() {
        viewModel.students.observe(viewLifecycleOwner) {
            studentAdapter.setData(it)
        }
        sharedViewModel.searchResults.observe(viewLifecycleOwner) {
            if (it != null) {
                studentAdapter.setData(it)
            }
        }
    }


}