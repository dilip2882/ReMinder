package com.dilip.reminderapp.data.di

import android.content.Context
import com.dilip.reminderapp.data.local.ReminderDao
import com.dilip.reminderapp.data.local.ReminderDatabase
import com.dilip.reminderapp.data.repository.ReminderRepoImpl
import com.dilip.reminderapp.domian.repository.ReminderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ReminderDatabase{
        return ReminderDatabase.getInstance(context)
    }

    @Provides
    fun provideDao(reminderDatabase: ReminderDatabase): ReminderDao{
        return reminderDatabase.getReminderDao()
    }

    @Provides
    fun provideReminderRepo(reminderDao: ReminderDao): ReminderRepository{
        return ReminderRepoImpl(reminderDao)
    }
}