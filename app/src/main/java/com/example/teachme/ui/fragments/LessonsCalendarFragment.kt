package com.example.teachme.ui.fragments



import androidx.navigation.fragment.findNavController
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentLessonsCalendarBinding
import java.util.*


class LessonsCalendarFragment : BaseFragment<FragmentLessonsCalendarBinding>(FragmentLessonsCalendarBinding::inflate) {

    private var calendar = Calendar.getInstance()

    override fun setListeners() {
        binding.calendarView.setOnDateChangeListener { view, year, month, day ->
            calendar.set(year, month, day)
            val timeInMillis = calendar.timeInMillis
            val action = LessonsFragmentDirections.actionLessonsFragmentToAddLessonFragment(timeInMillis)
            findNavController().navigate(action)
        }
    }
}