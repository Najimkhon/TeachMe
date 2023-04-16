package com.example.teachme.ui.fragments

import android.content.Intent
import android.net.Uri
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
    private var telegramUsername = "https://t.me/"
    private var phoneNumber = "tel:+"


    override fun prepareUI() {
        viewModel.getStudentById(args.studentId).observe(viewLifecycleOwner){
            binding.apply {
                toolbar.tvTitle.text = "Student Info"
                tvName.text = it.fullName
                tvEmail.text = it.email
                tvTelegram.text = it.telegram
                tvPhone.text = it.phone
                tvAddress.text = it.address
                telegramUsername += it.telegram
                phoneNumber += it.phone
            }
        }
    }

    override fun setListeners() {
        binding.btnMessage.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(telegramUsername))
            startActivity(intent)
        }

        binding.btnCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber))
            startActivity(intent)
        }
    }

}