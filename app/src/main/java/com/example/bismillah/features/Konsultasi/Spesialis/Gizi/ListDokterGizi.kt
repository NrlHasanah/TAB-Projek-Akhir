package com.example.bismillah.features.Konsultasi.Spesialis.Gizi

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bismillah.R
import com.example.bismillah.features.Konsultasi.DetailDokterScreen

@Composable
fun JonathanPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.g3,
        name = "dr. Jonathan Aditya Patel, Sp.GK, RD, IBCLC",
        description = " Dr. Jonathan adalah spesialis gizi yang berpengalaman dalam konsultasi gizi untuk anak-anak dan keluarga..",
        hospital = "RS Premier Surabaya",
        practiceTime = "Senin - jumat 13:00-20:00",
        waNumber = "081212341234"
    )
}

@Composable
fun MarianaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.g2,
        name = "dr. Mariana Komogi, Sp.GK., M.Clin.Med",
        description = "Dr. Mariana adalah spesialis gizi dengan pengalaman dalam pengelolaan nutrisi untuk anak-anak dan dewasa.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Senin - Jumat 10:00-14:00",
        waNumber = "081298765432"
    )
}

@Composable
fun MichellePage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.g4,
        name = "dr. Michelle Kartika Thompson, Sp.GK, MSc",
        description = "Dr. Michelle adalah spesialis gizi yang berfokus pada peningkatan kualitas gizi untuk kesehatan optimal.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun OliviaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.g5,
        name = "dr. Olivia Rahma Spencer, Sp.GK, RD, MSc",
        description = "Dr. Olivia adalah spesialis gizi yang mengkhususkan diri dalam gizi anak-anak dan pengelolaan diet sehat.",
        hospital = "RS Mitra Keluarga Jakarta",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun VikaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.g1,
        name = "dr. Vika Pramesti, Sp.GK, MPH, RD",
        description = "dr. Vika adalah dokter spesialis gizi klinik yang memiliki keahlian dalam menangani obesitas dan malnutrisi.",
        hospital = "RSUP dr. Wahidin Sudirohusodo",
        practiceTime = "Senin - Jumat 15:00-16:40",
        waNumber = "081234567890"
    )
}