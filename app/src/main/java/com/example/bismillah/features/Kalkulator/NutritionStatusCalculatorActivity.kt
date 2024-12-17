package com.example.bismillah.features.Kalkulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.ui.theme.BismillahTheme

class NutritionStatusCalculatorActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BismillahTheme {
                nutritionStatusCalculator(navController = rememberNavController())
            }
        }
    }
}