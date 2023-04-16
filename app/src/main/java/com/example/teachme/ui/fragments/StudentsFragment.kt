package com.example.teachme.ui.fragments

import android.content.res.Resources
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.PagerAdapter
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentStudentsBinding
import com.example.teachme.ui.adapters.StudentsPagerAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import com.example.teachme.ui.viewmodels.SharedViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentsFragment : BaseFragment<FragmentStudentsBinding>(FragmentStudentsBinding::inflate) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun prepareUI() {
        binding.vpStudents.apply {
            adapter = StudentsPagerAdapter(requireActivity())
        }
        TabLayoutMediator(binding.tabLayout, binding.vpStudents) { tab, index ->
            tab.text = when (index) {
                0 -> {
                    "Paid Students"
                }
                1 -> {
                    "Debtors"
                }
                else -> {
                    throw Resources.NotFoundException("Position Not Found")
                }
            }
        }.attach()
    }

    override fun setListeners() {
        binding.fabAddStudent.setOnClickListener {
            findNavController().navigate(R.id.action_studentsFragment_to_addStudentFragment)
        }

        binding.etSearchField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val query = binding.etSearchField.text.toString()
                searchDatabase(query)
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
    }

    private fun searchDatabase(query: String?) {
        val searchQuery = "%$query%"

        sharedViewModel.searchThroughDatabase(searchQuery).observe(this) { list ->
            list?.let {
                if (!it.isNullOrEmpty()) {
                    binding.toolbar.tvTitle.text = it[0].fullName
                    sharedViewModel.setSearchResults(it)
                }
            }
        }
    }
}