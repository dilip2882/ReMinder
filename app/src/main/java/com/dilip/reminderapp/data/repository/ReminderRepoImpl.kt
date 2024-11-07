package com.dilip.reminderapp.data.repository

import com.dilip.reminderapp.data.local.ReminderDao
import com.dilip.reminderapp.domian.model.Reminder
import com.dilip.reminderapp.domian.repository.ReminderRepository
import kotlinx.coroutines.flow.Flow

class ReminderRepoImpl(private val reminderDao: ReminderDao) : ReminderRepository {
    override suspend fun insert(reminder: Reminder) {
        reminderDao.insert(reminder)
    }

    override suspend fun update(reminder: Reminder) {
        reminderDao.update(reminder)
    }

    override suspend fun delete(reminder: Reminder) {
        reminderDao.delete(reminder)

    }

    override fun getAllReminders(): Flow<List<Reminder>> = reminderDao.getAllReminder()
}