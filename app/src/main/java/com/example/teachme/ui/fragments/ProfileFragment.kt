package com.example.teachme.ui.fragments

import androidx.navigation.fragment.findNavController
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override fun prepareUI() {
        binding.toolbar.tvTitle.text = "Profile"
    }

    override fun setListeners() {
        binding.btnLogOut.setOnClickListener{
            val action = ProfileFragmentDirections.actionProfileFragmentToIntroFragment()
            findNavController().navigate(action)
        }
    }
}