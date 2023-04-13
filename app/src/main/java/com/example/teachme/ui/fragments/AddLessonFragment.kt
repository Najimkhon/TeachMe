package com.example.teachme.ui.fragments

import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentAddLessonBinding


class AddLessonFragment : BaseFragment<FragmentAddLessonBinding>(FragmentAddLessonBinding::inflate) {
    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Add Lesson"
    }
}