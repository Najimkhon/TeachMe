package com.example.teachme.ui.adapters

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.teachme.ui.fragments.LessonsCalendarFragment
import com.example.teachme.ui.fragments.TodayFragment

class LessonsPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                LessonsCalendarFragment()
            }
            1 -> {
                TodayFragment()
            }
            else -> {throw Resources.NotFoundException("Position Not Found")
            }
        }
    }
}