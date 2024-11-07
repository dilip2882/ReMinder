package com.dilip.reminderapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class ReminderApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel =
                NotificationChannel(CHANNEL, NAME, NotificationManager.IMPORTANCE_DEFAULT)

            val notificationManager =
                this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}

const val CHANNEL = "channel"
const val NAME = "name"