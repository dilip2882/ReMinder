package com.dilip.reminderapp.domian.use_cases

import com.dilip.reminderapp.domian.model.Reminder
import com.dilip.reminderapp.domian.repository.ReminderRepository
import javax.inject.Inject

class UpdateUseCase @Inject constructor(private val reminderRepository: ReminderRepository) {

    suspend operator fun invoke(reminder: Reminder) = reminderRepository.update(reminder)

}