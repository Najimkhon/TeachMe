package com.example.teachme.ui.fragments

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.base.BaseFragment
import com.example.teachme.data.models.LessonPM
import com.example.teachme.databinding.FragmentLessonListBinding
import com.example.teachme.ui.adapters.LessonAdapter
import com.example.teachme.ui.layouts.LessonItemLayout
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class LessonListFragment :
    BaseFragment<FragmentLessonListBinding>(FragmentLessonListBinding::inflate), LessonItemLayout.OnClickListener {
    private val viewModel: MainViewModel by viewModels()
    private val args by navArgs<AddLessonFragmentArgs>()
    private val lessonAdapter: LessonAdapter by lazy { LessonAdapter(requireContext(), this) }
    private val formatter = SimpleDateFormat("MMMM dd, EEEE", Locale.US)

    override fun assignObjects() {
        binding.rvLessons.apply {
            adapter = lessonAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
    }

    override fun setListeners() {
        binding.fabAddLesson.setOnClickListener{
            val action = LessonListFragmentDirections.actionLessonListFragmentToAddLessonFragment(args.currentDate)
            findNavController().navigate(action)
        }
    }

    override fun prepareUI() {
        binding.apply {
            toolbar.tvTitle.text = "Lessons"
            tvCurrentDate.text = formatter.format(args.currentDate)
        }
    }

    override fun setObservers() {
        viewModel.getLessonsByDate(args.currentDate, getDayOfweek(args.currentDate)).observe(viewLifecycleOwner){
            lessonAdapter.setData(it)
        }
    }

    private fun getDayOfweek(timeInMillis: Long): String {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = timeInMillis
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)
        var result = ""
        when (dayOfWeek){
            Calendar.MONDAY ->  result ="1"
            Calendar.TUESDAY ->  result ="2"
            Calendar.WEDNESDAY ->  result ="3"
            Calendar.THURSDAY ->  result ="4"
            Calendar.FRIDAY ->  result ="5"
            Calendar.SATURDAY ->  result ="6"
            Calendar.SUNDAY -> result = "7"
        }
        return "%$result%"
    }

    override fun onItemClicked(lesson: LessonPM) {
        val action = LessonListFragmentDirections.actionLessonListFragmentToLessonInfoFragment(lesson.id)
        findNavController().navigate(action)
    }
}