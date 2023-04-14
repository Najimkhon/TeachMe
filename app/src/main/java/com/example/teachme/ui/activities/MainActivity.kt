package com.example.teachme.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.teachme.R
import com.example.teachme.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        setContentView(view)

        navController.addOnDestinationChangedListener{_, destination, _->
            when(destination.id){
                R.id.homeFragment, R.id.lessonsFragment, R.id.studentsFragment, R.id.profileFragment ->
                    binding.bottomNavigationView.visibility = View.VISIBLE
                else-> binding.bottomNavigationView.visibility = View.GONE
            }

        }

    }
}