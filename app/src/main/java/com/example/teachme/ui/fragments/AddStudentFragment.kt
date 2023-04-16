package com.example.teachme.ui.fragments

import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.teachme.base.BaseFragment
import com.example.teachme.data.models.StudentPM
import com.example.teachme.databinding.FragmentAddStudentBinding
import com.example.teachme.ui.adapters.SelectedStudentAdapter
import com.example.teachme.ui.adapters.StudentAdapter
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator

@AndroidEntryPoint
class AddStudentFragment :
    BaseFragment<FragmentAddStudentBinding>(FragmentAddStudentBinding::inflate) {

    private val viewModel: MainViewModel by viewModels()

    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Add Student"
    }

    override fun setListeners() {
        binding.btnAddStudent.setOnClickListener {
            addNewStudent()
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

    private fun addNewStudent() {
        val name = binding.etName.text.toString()
        val email = binding.etEmail.text.toString()
        val telegram = binding.etTelegram.text.toString()
        val phone = binding.etPhone.text.toString()
        val address = binding.etAddress.text.toString()
        val payment = binding.etPayment.text.toString()
        if (name.isNotEmpty() && email.isNotEmpty() && telegram.isNotEmpty() && phone.isNotEmpty() && address.isNotEmpty() && payment.isNotEmpty()) {
            val student = StudentPM(
                0,
                name,
                email,
                telegram,
                address,
                phone,
                payment.toLong()
            )
            viewModel.insertStudent(student)
            Toast.makeText(requireContext(), "$name is added to Students list!", Toast.LENGTH_SHORT)
                .show()
            findNavController().popBackStack()
        } else {
            Toast.makeText(requireContext(), "Please, fill in the fields", Toast.LENGTH_SHORT)
                .show()
        }
    }
}