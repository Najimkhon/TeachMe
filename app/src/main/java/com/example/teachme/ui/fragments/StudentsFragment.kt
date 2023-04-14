package com.example.teachme.ui.fragments

import android.content.res.Resources
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.PagerAdapter
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentStudentsBinding
import com.example.teachme.ui.adapters.StudentsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class StudentsFragment : BaseFragment<FragmentStudentsBinding>(FragmentStudentsBinding::inflate) {
    override fun prepareUI() {
       binding.vpStudents.apply {
           adapter = StudentsPagerAdapter(requireActivity())
       }
        TabLayoutMediator(binding.tabLayout, binding.vpStudents){ tab, index ->
            tab.text = when(index){
                0->{"Paid Students"}
                1->{"Debtors"}
                else->{throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()
    }

    override fun setListeners() {
        binding.toolbar.tvTitle.setOnClickListener{
            findNavController().navigate(R.id.action_studentsFragment_to_addStudentFragment)
        }
    }

}