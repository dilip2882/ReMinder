package com.dilip.reminderapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dilip.reminderapp.domian.model.Reminder

@Database(entities = [Reminder::class], version = 1)
abstract class ReminderDatabase : RoomDatabase() {

    companion object {
        fun getInstance(context: Context) = Room.databaseBuilder(
            context,
            ReminderDatabase::class.java,
            "reminder"
        ).build()
    }

    abstract fun getReminderDao(): ReminderDao
}