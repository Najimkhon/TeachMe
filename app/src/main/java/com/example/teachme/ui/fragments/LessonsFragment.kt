package com.example.teachme.ui.fragments

import android.content.res.Resources
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentLessonsBinding
import com.example.teachme.ui.adapters.LessonsPagerAdapter
import com.example.teachme.ui.adapters.StudentsPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class LessonsFragment : BaseFragment<FragmentLessonsBinding>(FragmentLessonsBinding::inflate) {

    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Schedule"
        binding.vpLessons.apply {
            adapter = LessonsPagerAdapter(requireActivity())
        }
        TabLayoutMediator(binding.tabLayout, binding.vpLessons){ tab, index ->
            tab.text = when(index){
                0->{"Calendar"}
                1->{"List"}
                else->{throw Resources.NotFoundException("Position Not Found")}
            }
        }.attach()
    }

}