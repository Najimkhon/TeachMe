package com.example.teachme.ui.fragments

import android.view.WindowManager
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentTutorSignUpBinding

class TutorSignUpFragment : BaseFragment<FragmentTutorSignUpBinding>(FragmentTutorSignUpBinding::inflate) {
    override fun onStart() {
        super.onStart()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
    }
}