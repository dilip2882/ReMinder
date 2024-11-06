package com.dilip.reminder.domian.use_cases

import com.dilip.reminder.domian.repository.ReminderRepository
import javax.inject.Inject

class GelAllReminderUseCase @Inject constructor(private val reminderRepository: ReminderRepository) {

    operator fun invoke() = reminderRepository.getAllReminders()

}