package com.example.teachme.ui.fragments


import androidx.navigation.fragment.findNavController
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentLessonsListBinding

class LessonsListFragment : BaseFragment<FragmentLessonsListBinding>(FragmentLessonsListBinding::inflate) {

    override fun setListeners() {
        binding.fabAddLesson.setOnClickListener{
            findNavController().navigate(R.id.action_lessonsFragment_to_addLessonFragment)
        }
    }

}