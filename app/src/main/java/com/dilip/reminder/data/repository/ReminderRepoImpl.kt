package com.dilip.reminder.data.repository

import com.dilip.reminder.data.local.ReminderDao
import com.dilip.reminder.domian.model.Reminder
import com.dilip.reminder.domian.repository.ReminderRepository
import kotlinx.coroutines.flow.Flow

class ReminderRepoImpl(private val reminderDao: ReminderDao): ReminderRepository {
    override suspend fun insert(reminder: Reminder) {
        reminderDao.insert(reminder)
    }

    override suspend fun update(reminder: Reminder) {
        reminderDao.update(reminder)
    }

    override suspend fun delete(reminder: Reminder) {
        reminderDao.delete(reminder)
    }

    override fun getAllReminders(): Flow<List<Reminder>> = reminderDao.getALlReminder()

}