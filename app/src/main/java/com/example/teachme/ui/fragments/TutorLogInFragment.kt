package com.example.teachme.ui.fragments

import android.view.WindowManager
import androidx.navigation.fragment.findNavController
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentTutorLogInBinding

class TutorLogInFragment : BaseFragment<FragmentTutorLogInBinding>(FragmentTutorLogInBinding::inflate) {
    override fun setListeners() {
        binding.btnLogIn.setOnClickListener{
            findNavController().navigate(R.id.action_tutorLogInFragment_to_homeFragment)
        }

        binding.btnRegister.setOnClickListener{
            findNavController().navigate(R.id.action_tutorLogInFragment_to_tutorSignInFragment)
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