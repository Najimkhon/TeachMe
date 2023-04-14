package com.example.teachme.ui.fragments

import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentTutorSignUpBinding

class TutorSignUpFragment : BaseFragment<FragmentTutorSignUpBinding>(FragmentTutorSignUpBinding::inflate) {

    override fun setListeners() {
        binding.btnSignUp.setOnClickListener{
            findNavController().navigate(R.id.action_tutorSignInFragment_to_homeFragment)
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
}