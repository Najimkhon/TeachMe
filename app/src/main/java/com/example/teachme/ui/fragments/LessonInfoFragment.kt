package com.example.teachme.ui.fragments

import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentLessonInfoBinding
import com.example.teachme.ui.adapters.StudentAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class LessonInfoFragment :
    BaseFragment<FragmentLessonInfoBinding>(FragmentLessonInfoBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    private val studentAdapter: StudentAdapter by lazy { StudentAdapter(requireContext()) }
    private val args by navArgs<LessonInfoFragmentArgs>()
    private val formatter = SimpleDateFormat("MMMM dd, EEEE", Locale.US)
    private val timeFormatter = SimpleDateFormat("HH:mm", Locale.US)

    override fun prepareUI() {

        viewModel.getLessonById(args.currentLessonId).observe(viewLifecycleOwner){
            binding.apply {
                tvCurrentDate.text = formatter.format(it.startDate)
                tvStartTime.text = timeFormatter.format(it.startTime)
                tvFinishTime.text = timeFormatter.format(it.endTime)
                etSubject.text = it.title
                cbGenerate.isChecked = it.autogenerateLessons
                setSelectedDays(it.selectedDays)
                studentAdapter.setData(it.students)
            }
        }
    }

    override fun assignObjects() {
        binding.rvSlectedStudents.apply {
            adapter = studentAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = SlideInUpAnimator().apply { addDuration = 300 }
        }
    }

    private fun setSelectedDays(selectedDays: String){
        if (selectedDays.isNotEmpty()){
            selectedDays.forEach {
                when(it){
                    '1' ->{
                        binding.tvMon.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvMon.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                    '2' ->{
                        binding.tvTue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvTue.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                    '3' ->{
                        binding.tvWed.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvWed.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                    '4' ->{
                        binding.tvThu.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvThu.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                    '5' ->{
                        binding.tvFri.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvFri.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                    '6' ->{
                        binding.tvSat.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvSat.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                    '7' ->{
                        binding.tvSun.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_grey))
                        binding.tvSun.setBackgroundResource(R.drawable.weekday_selected_bg )
                    }
                }
            }
        }
    }

}