package com.example.teachme.ui.fragments

import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentIntroBinding

class IntroFragment : BaseFragment<FragmentIntroBinding>(FragmentIntroBinding::inflate) {

    override fun onStart() {
        super.onStart()
        requireActivity().window.navigationBarColor = resources.getColor(R.color.black)
    }

    override fun onStop() {
        super.onStop()
        requireActivity().window.navigationBarColor = resources.getColor(R.color.darker_white)
    }


}