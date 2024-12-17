package com.example.bismillah.features.Konsultasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.others.BottomBar
import com.example.bismillah.ui.theme.Poppins
import com.example.bismillah.R
import com.example.bismillah.features.Konsultasi.Spesialis.Anak.AnakCard
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.GiziCard
import com.example.bismillah.others.Screen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun konsultasiScreen(navController: NavHostController){
    val auth = FirebaseAuth.getInstance()
    var userName by remember { mutableStateOf("") }
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(auth.currentUser) {
        val user = auth.currentUser
        user?.let {
            userName = it.displayName ?: it.email ?: "Nama Tidak Tersedia"
            isLoading = false
        } ?: run {
            userName = "Pengguna tidak terdaftar"
            isLoading = false
        }
    }

    Scaffold(bottomBar = {
        BottomBar(navController = navController)
    }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color(0xFFF7F7F7))
                .padding(innerPadding)
                .padding(top = 48.dp, start = 16.dp, end = 16.dp)
        ) {
            Text(text = "Welcome,", fontSize = 14.sp, fontFamily = Poppins, fontWeight = FontWeight.Bold, color = Color(0xFF0D3B66))
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = "Mama $userName", fontSize = 20.sp, fontFamily = Poppins, fontWeight = FontWeight.Bold, color = Color(0xFF0D3B66))

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Temukan dokter spesialis", fontFamily = Poppins, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0D3B66))

            Spacer(modifier = Modifier.height(20.dp))

            SpecialitySection(
                onCategoryClick = { category ->
                    when (category) {
                        "spesialisAnak" -> navController.navigate(Screen.SpesialisAnak.route)
                        "spesialisGizi" -> navController.navigate(Screen.SpesialisGizi.route)
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = "Dokter populer", fontFamily = Poppins, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0D3B66))

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                //PopularDoctors()
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.gizi1,
                    name = "dr. Vika Pramesti, Sp.GK, MPH, RD",
                    hospital = "RSUP dr. Wahidin Sudirohusodo",
                    route = Screen.Vika.route,
                )
                GiziCard(
                    navController = navController,
                    imageRes = R.drawable.gizi2,
                    name = "dr. Mariana Komogi, Sp.GK., M.Clin.Med",
                    hospital = "RS Siloam Makassar",
                    route = Screen.Mariana.route,
                )
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.anak2,
                    name = "Prof. dr. Paul Martinus, Sp.A(K), DTM&H, MCTM(TP)",
                    hospital = "RSUP dr. Wahidin Sudirohusodo",
                    route = Screen.Paul.route,
                )
                Spacer(modifier = Modifier.height(24.dp))
            }

            }
        Spacer(modifier = Modifier.height(32.dp))
    }
}



@Composable
fun SpecialitySection(onCategoryClick: (String) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        SpecialityCard(
            name = "Spesialis anak",
            iconId = R.drawable.spesialisanak,
            onClick = { onCategoryClick("spesialisAnak") }
        )
        Spacer(modifier = Modifier.width(16.dp))
        SpecialityCard(
            name = "Spesialis gizi",
            iconId = R.drawable.spesialisgizi,
            onClick = { onCategoryClick("spesialisGizi") }
        )
    }
}

@Composable
fun SpecialityCard(name: String, iconId: Int, onClick: () -> Unit) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .width(170.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = name,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = name,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = Color(0xFF0D3B66),
            )
        }
    }
}

//@Composable
//fun PopularDoctors() {
//    Column {
//        DoctorCard(
//            name = "dr. Stella Ananda, Sp.A, IBCLC, CIMI",
//            specialization = "Dokter spesialis anak",
//            hospital = "RSUP Dr. Tadjuddin Chalid",
//            imageId = R.drawable.anak1
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        DoctorCard(
//            name = "dr. Mariana Komogi, Sp.GK., M.Clin.Med",
//            specialization = "Dokter spesialis gizi klinik",
//            hospital = "Rumah Sakit Siloam Makassar",
//            imageId = R.drawable.gizi1
//        )
//        Spacer(modifier = Modifier.height(16.dp))
//        DoctorCard(
//            name = "Prof. dr. Paul Martinus, Sp.A(K), DTM&H, MCTM(TP)",
//            specialization = "Dokter spesialis anak",
//            hospital = "Rumah Sakit Umum Pusat dr. Wahidin Sudirohusodo",
//            imageId = R.drawable.anak2
//        )
//    }
//}
//
//@Composable
//fun DoctorCard(name: String, specialization: String, hospital: String, imageId: Int) {
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        shape = RoundedCornerShape(8.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
//    ) {
//        Row(modifier = Modifier.padding(16.dp)) {
//            Image(
//                painter = painterResource(id = imageId),
//                contentDescription = "Dokter Image",
//                modifier = Modifier
//                    .size(64.dp)
//                    .clip(RoundedCornerShape(8.dp))
//            )
//            Spacer(modifier = Modifier.width(16.dp))
//            Column() {
//                Text(text = name, fontWeight = FontWeight.Bold, fontFamily = Poppins, fontSize = 14.sp, color = Color(0xFF0D3B66))
//                Spacer(modifier = Modifier.height(2.dp))
//                Text(text = specialization, fontFamily = Poppins, color = Color.DarkGray, fontSize = 10.sp)
//                Text(text = hospital, fontFamily = Poppins, color = Color.Gray, fontSize = 10.sp)
//            }
//        }
//    }
//}

@Composable
@Preview
fun konsultasiScreenPreview(){
    konsultasiScreen(navController = rememberNavController())
}
