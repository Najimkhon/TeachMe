package com.example.teachme.ui.fragments


import androidx.navigation.fragment.findNavController
import com.example.teachme.R
import com.example.teachme.base.BaseFragment
import com.example.teachme.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun setListeners() {
        binding.cvExpense.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_introFragment)
        }
        binding.cvIncome.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_tutorSignInFragment)
        }
    }
}