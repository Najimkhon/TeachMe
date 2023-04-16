package com.example.teachme.ui.fragments

import android.app.TimePickerDialog
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.base.BaseFragment
import com.example.teachme.data.models.LessonPM
import com.example.teachme.data.models.Rate
import com.example.teachme.data.models.StudentPM
import com.example.teachme.databinding.FragmentAddLessonBinding
import com.example.teachme.ui.adapters.SelectedStudentAdapter
import com.example.teachme.ui.dialogs.DialogManager
import com.example.teachme.ui.dialogs.OnDialogClickListener
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class AddLessonFragment :
    BaseFragment<FragmentAddLessonBinding>(FragmentAddLessonBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()
    private val args by navArgs<AddLessonFragmentArgs>()
    private val studentAdapter: SelectedStudentAdapter by lazy { SelectedStudentAdapter(requireContext()) }
    private val formatter = SimpleDateFormat("MMMM dd, EEEE", Locale.US)
    private val timeFormatter = SimpleDateFormat("HH:mm", Locale.US)
    private var calendar = Calendar.getInstance()
    private var startTimeInMillis = 0L
    private var finishTimeInMillis = 0L
    private var autoGenerate = false
    private lateinit var students: List<StudentPM>

    @Inject
    lateinit var dialogManager: DialogManager

    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Add Lesson"
        binding.tvCurrentDate.text = formatter.format(args.currentDate)
        binding.apply {
            val hourLater = Calendar.getInstance()
            hourLater.add(Calendar.HOUR, 1)
            startTimeInMillis = calendar.timeInMillis
            finishTimeInMillis = hourLater.timeInMillis
            tvFinishTime.text = timeFormatter.format(finishTimeInMillis)
            tvStartTime.text = timeFormatter.format(startTimeInMillis)
        }

    }

    override fun setListeners() {
        binding.tvStartTime.setOnClickListener {
            showTimePicker { hour, minute ->
                calendar.apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }
                binding.tvStartTime.text = timeFormatter.format(calendar.timeInMillis)
                startTimeInMillis = calendar.timeInMillis
            }
        }
        binding.tvFinishTime.setOnClickListener {
            showTimePicker { hour, minute ->
                calendar.apply {
                    set(Calendar.HOUR_OF_DAY, hour)
                    set(Calendar.MINUTE, minute)
                }
                binding.tvFinishTime.text = timeFormatter.format(calendar.timeInMillis)
                finishTimeInMillis = calendar.timeInMillis
            }
        }

        binding.btnAttachStudent.setOnClickListener {
            dialogManager.showStudentsListDialog(object : OnDialogClickListener {
                override fun onSaveClicked(selectedStudents: List<StudentPM>) {
                    students = selectedStudents
                    studentAdapter.setData(students)
                }
            })
        }

        binding.btnAddLesson.setOnClickListener {
            val selectedDays = getSelectedDays()
            val subject = binding.etSubject.text.toString()
            this.autoGenerate = binding.cbGenerate.isChecked
            if (selectedDays.isNotEmpty() && subject.isNotEmpty() && ::students.isInitialized) {
                val newLesson = LessonPM(
                    0,
                    subject,
                    args.currentDate,
                    selectedDays,
                    startTimeInMillis,
                    finishTimeInMillis,
                    Rate.Unrated,
                    "",
                    students,
                    autoGenerate
                )
                viewModel.insertLesson(newLesson)
                Toast.makeText(requireContext(), "Lesson: $subject is added", Toast.LENGTH_SHORT)
                findNavController().popBackStack()
            } else {
                Toast.makeText(requireContext(), "Fields must not be empty", Toast.LENGTH_SHORT)
                    .show()
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

    override fun onStart() {
        super.onStart()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }

    private fun showTimePicker(action: (Int, Int) -> Unit) {
        TimePickerDialog(
            requireContext(),
            { _, hour, minute -> action.invoke(hour, minute) },
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()
    }

    private fun getSelectedDays(): String {
        var selectedDays = ""
        val selectedButtons = binding.toggleButton.selectedButtons
        for (selectedButton in selectedButtons) {
            when (selectedButton) {
                binding.btnMon -> {
                    selectedDays += "1"
                }
                binding.btnTue -> {
                    selectedDays += "2"
                }
                binding.btnWed -> {
                    selectedDays += "3"
                }
                binding.btnThu -> {
                    selectedDays += "4"
                }
                binding.btnFri -> {
                    selectedDays += "5"
                }
                binding.btnSat -> {
                    selectedDays += "6"
                }
                binding.btnSun -> {
                    selectedDays += "7"
                }
            }
        }
        return selectedDays
    }
}