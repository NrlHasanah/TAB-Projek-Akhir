package com.example.bismillah

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.notification.NotificationScheduler
import com.example.bismillah.others.Screen
import com.example.bismillah.ui.theme.BismillahTheme
import androidx.compose.runtime.LaunchedEffect
import com.example.bismillah.auth.presentation.viewModel.AuthView
import com.example.bismillah.others.NavGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Membuat Notification Channel (untuk Android 8.0 ke atas)
        createNotificationChannel()

        // Menjadwalkan notifikasi saat aplikasi dijalankan
        NotificationScheduler.scheduleAllMealNotifications(this)

        setContent {
            BismillahTheme {
                val navController = rememberNavController()
                val authViewModel: AuthView = viewModel()

                // Mengecek data intent jika berasal dari notifikasi
                val navigateTo = intent.getStringExtra("navigate_to")
                Log.d("MainActivity", "navigate_to: $navigateTo")

                // Menavigasi ke KontenScreen jika navigate_to == "konten"
                LaunchedEffect(navigateTo) {
                    if (navigateTo == "konten") {
                        navController.navigate(Screen.Konten.route)
                    }
                }

                Surface {
                    NavGraph(navController = navController, authViewModel = authViewModel)
                }
            }
        }
    }

    // Membuat Notification Channel
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Meal Notifications"
            val descriptionText = "Channel untuk notifikasi resep makanan"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("meal_notification_channel", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}