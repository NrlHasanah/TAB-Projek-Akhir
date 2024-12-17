package com.example.bismillah.features.Konsultasi.Spesialis.Anak

import com.example.bismillah.features.Konsultasi.DetailDokterScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.bismillah.R

@Composable
fun StellaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.a1,
        name = "dr. Stella Ananda, Sp.A, IBCLC, CIMI",
        description = " Dr. Stella adalah dokter spesialis anak dengan keahlian dalam kesehatan dan perkembangan anak.",
        hospital = "RSUP Dr. Tadjuddin Chalid",
        practiceTime = "Senin - jumat 13:00-20:00",
        waNumber = "081212341234"
    )
}

@Composable
fun PaulPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.a2,
        name = "Prof. dr. Paul Martinus, Sp.A(K), DTM&H, MCTM(TP)",
        description = "Dr. Paul adalah dokter spesialis anak yang mengkhususkan diri dalam perawatan anak dan pemantauan pertumbuhan.",
        hospital = "Rumah Sakit Umum Pusat dr. Wahidin Sudirohusodo",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun MayaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.a3,
        name = "dr. Maya Salsabila, Sp.A, M.Sc, CIMI",
        description = "Dr. Maya adalah dokter spesialis anak yang fokus pada kesehatan dan gizi anak usia dini.",
        hospital = "Rumah Sakit Universitas Hasanuddin",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}

@Composable
fun DickyPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.a4,
        name = "dr. Dicky Kurniawan, Sp.A, FAAP, CIMI",
        description = "Dr.Dicky adalah dokter spesialis anak dengan pengalaman dalam kesehatan, perkembangan, dan perawatan preventif anak.",
        hospital = "Rumah Sakit Umum Pusat dr. Wahidin Sudirohusodo",
        practiceTime = "Senin - jumat 13:00-20:00",
        waNumber = "081212341234"
    )
}

@Composable
fun SylviaPage(navController: NavController) {
    DetailDokterScreen(
        imageRes = R.drawable.a5,
        name = "dr. Sylvia Kusuma, Sp.A, MPH, IBCLC",
        description = "Dr. Sylvia adalah dokter spesialis anak yang mengkhususkan diri dalam penyakit anak dan manajemen kesehatan.",
        hospital = "RS Siloam Makassar",
        practiceTime = "Selasa - Sabtu 09:00-13:00",
        waNumber = "081212341234"
    )
}
