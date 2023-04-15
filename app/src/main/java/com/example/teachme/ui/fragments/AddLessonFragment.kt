package com.example.teachme.ui.fragments

import android.app.TimePickerDialog
import android.widget.TimePicker
import androidx.navigation.fragment.navArgs
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentAddLessonBinding
import java.text.SimpleDateFormat
import java.util.*


class AddLessonFragment : BaseFragment<FragmentAddLessonBinding>(FragmentAddLessonBinding::inflate) {

    private val args by navArgs<AddLessonFragmentArgs>()
    private val formatter = SimpleDateFormat("MMMM dd, EEEE", Locale.US)
    private val timeFormatter = SimpleDateFormat("HH:mm", Locale.US)
    private var calendar = Calendar.getInstance()
    private var startTimeInMillis = 0L
    private var finishTimeInMillis = 0L

    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Add Lesson"
        binding.tvCurrentDate.text = formatter.format(args.currentDate)
        binding.apply {
            tvStartTime.text = timeFormatter.format(calendar.timeInMillis)
            val hourLater = Calendar.getInstance()
            hourLater.add(Calendar.HOUR, 1)
            tvFinishTime.text = timeFormatter.format(hourLater.timeInMillis)
        }
    }

    override fun setListeners() {
        binding.tvStartTime.setOnClickListener{
            showTimePicker{ hour, minute ->
                calendar.apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }
                binding.tvStartTime.text = timeFormatter.format(calendar.timeInMillis)
                startTimeInMillis = calendar.timeInMillis
            }
        }
        binding.tvFinishTime.setOnClickListener{
            showTimePicker{ hour, minute ->
                calendar.apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }
                binding.tvFinishTime.text = timeFormatter.format(calendar.timeInMillis)
                finishTimeInMillis = calendar.timeInMillis
            }
        }
    }

    override fun assignObjects() {

    }

    private fun showTimePicker(action: (Int, Int)-> Unit){
        TimePickerDialog(
            requireContext(),
            { _, hour, minute -> action.invoke(hour, minute)},
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()
    }
}