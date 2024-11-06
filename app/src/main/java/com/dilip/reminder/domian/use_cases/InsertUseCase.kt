package com.dilip.reminder.domian.use_cases

import com.dilip.reminder.domian.model.Reminder
import com.dilip.reminder.domian.repository.ReminderRepository
import javax.inject.Inject

class InsertUseCase @Inject constructor(private val reminderRepository: ReminderRepository) {

    suspend operator fun invoke(reminder: Reminder) = reminderRepository.insert(reminder)

}