package com.example.teachme.ui.fragments

import androidx.navigation.fragment.navArgs
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentAddLessonBinding
import java.text.SimpleDateFormat
import java.util.*


class AddLessonFragment : BaseFragment<FragmentAddLessonBinding>(FragmentAddLessonBinding::inflate) {

    private val args by navArgs<AddLessonFragmentArgs>()
    private val formatter = SimpleDateFormat("MMMM dd, EEEE", Locale.US)

    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Add Lesson"
        binding.tvCurrentDate.text = formatter.format(args.currentDate)
    }
}