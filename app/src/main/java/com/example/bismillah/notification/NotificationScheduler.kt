package com.example.bismillah.notification

import android.content.Context
import androidx.work.*
import java.util.Calendar
import java.util.concurrent.TimeUnit

object NotificationScheduler {

    fun scheduleMealNotification(context: Context, hour: Int, minute: Int) {
        val now = Calendar.getInstance()
        val targetTime = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)

            // Jika waktu sudah lewat hari ini, jadwalkan untuk besok
            if (before(now)) {
                add(Calendar.DAY_OF_YEAR, 1)
            }
        }

        // Hitung delay hingga waktu target
        val delay = targetTime.timeInMillis - now.timeInMillis

        // Konfigurasi WorkRequest untuk NotificationWorker
        val workRequest = OneTimeWorkRequestBuilder<NotificationWorker>()
            .setInitialDelay(delay, TimeUnit.MILLISECONDS)
            .build()

        // Tambahkan ke WorkManager
        WorkManager.getInstance(context).enqueue(workRequest)
    }

    fun scheduleAllMealNotifications(context: Context) {
        scheduleMealNotification(context, 7, 0)  // Jam 07:00 pagi
        scheduleMealNotification(context, 13, 0) // Jam 13:00 siang
        scheduleMealNotification(context, 19, 0) // Jam 18:30 malam
    }
}