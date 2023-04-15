package com.example.teachme.di

import android.content.Context
import androidx.room.Room
import com.example.teachme.data.db.TeachMeDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideTeachMeDb(
        @ApplicationContext app: Context
    )= Room.databaseBuilder(
        app,
        TeachMeDb::class.java,
        "teacme_db"
    ).build()

    @Singleton
    @Provides
    fun provideStudentDao(db: TeachMeDb) = db.getStudentDao()

    @Singleton
    @Provides
    fun provideLessonDao(db: TeachMeDb) = db.getLessonDao()
}