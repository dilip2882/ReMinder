package com.dilip.reminder.domian.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var title: String? = null,
    var priority: Int = Priority.NONE,
    var dueDate: Long = 0L,
    var hideUntil: Long = 0L,
    var creationDate: Long = 0L,
    var modificationDate: Long = 0L,
    var completionDate: Long = 0L,
    var deletionDate: Long = 0L,
    var notes: String? = null,
    var estimatedSeconds: Int = 0,
    var elapsedSeconds: Int = 0,
    var timerStart: Long = 0L,
    var ringFlags: Int = 0,
    var reminderLast: Long = 0L,
    var recurrence: String? = null,
    var isCollapsed: Boolean = false,
    var parent: Long = 0L,
    var order: Long? = null,
    var readOnly: Boolean = false,
)

annotation class Priority {
    companion object {
        const val HIGH = 0
        const val MEDIUM = 1
        const val LOW = 2
        const val NONE = 3
    }
}