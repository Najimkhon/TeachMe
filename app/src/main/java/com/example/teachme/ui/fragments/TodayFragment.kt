package com.example.teachme.ui.fragments


import androidx.navigation.fragment.findNavController
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentTodayBinding
import java.util.*

class TodayFragment : BaseFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate) {

    private var calendar = Calendar.getInstance()

    override fun setListeners() {
        binding.fabAddLesson.setOnClickListener{
            val action = LessonsFragmentDirections.actionLessonsFragmentToAddLessonFragment(calendar.timeInMillis)
            findNavController().navigate(action)
        }
    }

}