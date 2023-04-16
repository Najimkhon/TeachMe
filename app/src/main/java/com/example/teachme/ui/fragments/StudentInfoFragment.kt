package com.example.teachme.ui.fragments

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentStudentInfoBinding
import com.example.teachme.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentInfoFragment : BaseFragment<FragmentStudentInfoBinding>(FragmentStudentInfoBinding::inflate) {
    private val viewModel: MainViewModel by viewModels()
    private val args by navArgs<StudentInfoFragmentArgs>()


    override fun prepareUI() {
        viewModel.getStudentById(args.studentId).observe(viewLifecycleOwner){
            binding.apply {
                toolbar.tvTitle.text = "Student Info"
                tvName.text = it.fullName
                tvEmail.text = it.email
                tvTelegram.text = it.telegram
                tvPhone.text = it.phone
                tvAddress.text = it.address
            }
        }
    }

}