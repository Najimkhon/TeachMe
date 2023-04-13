package com.example.teachme.ui.fragments


import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentLessonsCalendarBinding


class LessonsCalendarFragment : BaseFragment<FragmentLessonsCalendarBinding>(FragmentLessonsCalendarBinding::inflate) {
    override fun setListeners() {
        binding.calendarView.setOnDateChangeListener { view, year, month, day ->
            val date = day.toString() + "-" + (month + 1)
            Toast.makeText(requireContext(), date, Toast.LENGTH_SHORT).show()
            val action = LessonsFragmentDirections.actionLessonsFragmentToAddLessonFragment()
            findNavController().navigate(action)
        }
    }
}