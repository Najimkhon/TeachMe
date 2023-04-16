package com.example.teachme.ui.fragments


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentTodayBinding
import com.example.teachme.ui.adapters.LessonAdapter
import com.example.teachme.ui.adapters.StudentAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import java.util.*

@AndroidEntryPoint
class TodayFragment : BaseFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate) {

    private var calendar = Calendar.getInstance()
    private val viewModel: MainViewModel by viewModels()
    private val lessonAdapter: LessonAdapter by lazy { LessonAdapter(requireContext()) }

    override fun setListeners() {
        binding.fabAddLesson.setOnClickListener{
            val action = LessonsFragmentDirections.actionLessonsFragmentToAddLessonFragment(calendar.timeInMillis)
            findNavController().navigate(action)
        }

    }
    override fun assignObjects() {
        binding.rvLessons.apply {
            adapter = lessonAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
    }

    override fun setObservers() {
        viewModel.lessons.observe(viewLifecycleOwner) {
            it.forEach{
                var startdate = it.startDate

                println("Current Lesson: " + it.autogenerateLessons + " selected days: " + it.selectedDays + "DAY OF THE WEEK" + getDayOfweek(startdate))
                println("Today is: ${getDayOfweek(calendar.timeInMillis)}")
            }

        }
        viewModel.getLessonsByDate(calendar.timeInMillis, getDayOfweek(calendar.timeInMillis)).observe(viewLifecycleOwner){
            lessonAdapter.setData(it)
            it.forEach{
                var startdate = it.startDate

                println("Current Lesson: " + it.autogenerateLessons + " selected days: " + it.selectedDays + "DAY OF THE WEEK" + getDayOfweek(startdate))
            }
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

}