package com.example.teachme.ui.fragments

import androidx.navigation.fragment.findNavController
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentIntroBinding

class IntroFragment : BaseFragment<FragmentIntroBinding>(FragmentIntroBinding::inflate) {

    override fun onStart() {
        super.onStart()
        requireActivity().window.navigationBarColor = resources.getColor(R.color.black)
    }



    override fun setListeners() {
        binding.btnLogin.setOnClickListener{
            findNavController().navigate(R.id.action_introFragment_to_tutorLogInFragment)
        }
        binding.btnSignup.setOnClickListener{
            findNavController().navigate(R.id.action_introFragment_to_tutorSignInFragment)
        }
    }
}