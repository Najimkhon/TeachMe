package com.example.teachme.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent


@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    companion object{
        @Provides
        fun appComponentActivity(activity: Activity): AppCompatActivity = activity as AppCompatActivity

        @Provides
        fun fragmentManager(activity: AppCompatActivity) = activity.supportFragmentManager
    }

}