package com.example.bismillah.features.Konsultasi.Spesialis.Anak

import androidx.compose.foundation.Image
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.features.Konsultasi.Spesialis.Gizi.GiziCard
import com.example.bismillah.others.Screen
import com.example.bismillah.ui.theme.Poppins

@Composable
fun spesialisAnakPage(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF8F8F8)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp, start = 16.dp, end = 16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        modifier = Modifier.size(32.dp),
                        tint = Color.Black
                    )
                }
                Spacer(modifier = Modifier.width(2.dp))
                Text(
                    text = "Daftar Dokter Spesialis Anak",
                    fontSize = 18.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66),
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(vertical = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Column(modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .fillMaxHeight()
            ) {
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.anak1,
                    name = "dr. Stella Ananda, Sp.A, IBCLC, CIMI",
                    hospital = "RSUP Dr. Tadjuddin Chalid",
                    route = Screen.Stella.route,
                )
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.anak2,
                    name = "Prof. dr. Paul Martinus, Sp.A(K), DTM&H, MCTM(TP)",
                    hospital = "Rumah Sakit Umum Pusat dr. Wahidin Sudirohusodo",
                    route = Screen.Paul.route,
                )
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.anak3,
                    name = "dr. Maya Salsabila, Sp.A, M.Sc, CIMI",
                    hospital = "Rumah Sakit Universitas Hasanuddin",
                    route = Screen.Maya.route,
                )
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.anak4,
                    name = "dr. Dicky Kurniawan, Sp.A, FAAP, CIMI",
                    hospital = "Rumah Sakit Umum Pusat dr. Wahidin Sudirohusodo",
                    route = Screen.Dicky.route,
                )
                AnakCard(
                    navController = navController,
                    imageRes = R.drawable.anak5,
                    name = "dr. Sylvia Kusuma, Sp.A, MPH, IBCLC",
                    hospital = "Rumah Sakit Siloam Makassar",
                    route = Screen.Sylvia.route,
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun AnakCard(navController: NavController, imageRes: Int, name: String, hospital: String,  route: String ) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { navController.navigate(route) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = name, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color(0xFF0D3B66))
                Text(text = hospital, fontSize = 12.sp, color = Color.Gray)
            }
        }
    }
}

@Preview
@Composable
fun spesialisAnakPreview(){
    spesialisAnakPage(navController = rememberNavController())
}