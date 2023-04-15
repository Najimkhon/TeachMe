package com.example.teachme.ui.fragments

import android.app.TimePickerDialog
import android.widget.TimePicker
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentAddLessonBinding
import com.example.teachme.ui.dialogs.DialogManager
import com.example.teachme.ui.dialogs.OnDialogClickListener
import dagger.hilt.android.AndroidEntryPoint
import nl.bryanderidder.themedtogglebuttongroup.ThemedButton
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class AddLessonFragment : BaseFragment<FragmentAddLessonBinding>(FragmentAddLessonBinding::inflate) {

    private val args by navArgs<AddLessonFragmentArgs>()
    private val formatter = SimpleDateFormat("MMMM dd, EEEE", Locale.US)
    private val timeFormatter = SimpleDateFormat("HH:mm", Locale.US)
    private var calendar = Calendar.getInstance()
    private var startTimeInMillis = 0L
    private var finishTimeInMillis = 0L
    
    @Inject
    lateinit var dialogManager: DialogManager

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
        
        binding.btnAttachStudent.setOnClickListener{
            dialogManager.showStudentsListDialog(object : OnDialogClickListener {
                override fun onSaveClicked(input: String) {
                    Toast.makeText(requireContext(), "input", Toast.LENGTH_SHORT).show()
                }
            })
        }

        binding.btnAddLesson.setOnClickListener{
            val selectedDays = getSelectedDays()
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

    private fun getSelectedDays():String{
        var selectedDays =""
        val selectedButtons = binding.toggleButton.selectedButtons
        for (selectedButton in selectedButtons) {
            when(selectedButton){
                binding.btnMon->{
                    selectedDays += "1"
                }
                binding.btnTue->{
                    selectedDays += "2"
                }
                binding.btnWed->{
                    selectedDays += "3"
                }
                binding.btnThu->{
                    selectedDays += "4"
                }
                binding.btnFri->{
                    selectedDays += "5"
                }
                binding.btnSun->{
                    selectedDays += "6"
                }
                binding.btnSat->{
                    selectedDays += "7"
                }
            }
        }
        return selectedDays
    }
}