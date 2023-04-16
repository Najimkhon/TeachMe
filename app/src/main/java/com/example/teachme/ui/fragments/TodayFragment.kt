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
    private val studentAdapter: LessonAdapter by lazy { LessonAdapter(requireContext()) }

    override fun setListeners() {
        binding.fabAddLesson.setOnClickListener{
            val action = LessonsFragmentDirections.actionLessonsFragmentToAddLessonFragment(calendar.timeInMillis)
            findNavController().navigate(action)
        }

    }
    override fun assignObjects() {
        binding.rvLessons.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
    }

    override fun setObservers() {
        viewModel.lessons.observe(viewLifecycleOwner) {
            studentAdapter.setData(it)
        }
    }

}