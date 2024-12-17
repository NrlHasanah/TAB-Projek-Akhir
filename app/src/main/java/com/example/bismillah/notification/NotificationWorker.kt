package com.example.bismillah.notification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.bismillah.MainActivity
import com.example.bismillah.R
import com.example.bismillah.others.Screen

class NotificationWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {
        val context = applicationContext

        // Intent untuk membuka MainActivity dan menavigasi ke KontenScreen
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("navigate_to", "konten")  // Menambahkan parameter untuk navigasi
        }
        val pendingIntent = PendingIntent.getActivity(
            context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Buat notifikasi
        val notification = NotificationCompat.Builder(context, "meal_notification_channel")
            .setSmallIcon(R.drawable.detaila)
            .setContentTitle("Waktunya Makan!")
            .setContentText("Lihat resep makanan bergizi untuk si kecil.")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)  // Intent untuk membuka MainActivity saat notifikasi di klik
            .setAutoCancel(true)
            .build()

        // Menampilkan notifikasi
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify((System.currentTimeMillis() / 1000).toInt(), notification)

        return Result.success()
    }
}