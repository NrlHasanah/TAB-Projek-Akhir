package com.example.bismillah.Widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.example.bismillah.R
import com.example.bismillah.features.Kalkulator.NutritionStatusCalculatorActivity


class NutritionWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // Perbarui setiap instance widget
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    companion object {
        fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
            val views = RemoteViews(context.packageName, R.layout.nutrition_widget)

            // Intent untuk membuka Activity Kalkulator Gizi
            val intent = Intent(context, NutritionStatusCalculatorActivity::class.java) // Mengarahkan ke Activity Kalkulator Gizi
            val pendingIntent = PendingIntent.getActivity(context, appWidgetId, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

            // Hubungkan tombol ke PendingIntent
            views.setOnClickPendingIntent(R.id.button_open_calculator, pendingIntent)

            // Perbarui widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}