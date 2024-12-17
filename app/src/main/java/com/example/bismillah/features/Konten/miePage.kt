package com.example.bismillah.features.Konten

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins


@Composable
fun MiePage(navController: NavHostController){
    Scaffold(
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.detail), // Ensure this resource exists
                contentDescription = "Background Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 28.dp)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Top
                    ) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }

                        Image(
                            painter = painterResource(id = R.drawable.detailc), // Ensure this resource exists
                            contentDescription = "Food Image",
                            modifier = Modifier
                                .height(220.dp)
                                .width(230.dp)
                                .padding(start = 24.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Mie Pagi Ceria",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Mie Pagi Ceria adalah hidangan MPASI yang lezat dan bergizi, cocok untuk memulai hari si kecil dengan penuh semangat.",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    InfoC(label = "8 bulan")
                    Spacer(modifier = Modifier.width(6.dp))
                    InfoC(label = "250 kkal")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .background(Color(0x20FFF0E3))
                        .shadow(1.dp, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    // Ingredients Section
                    Text(
                        text = "Bahan",
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        color = Color(0xFF0D3B66),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "50 gram sayuran (seperti wortel dan brokoli, potong kecil-kecil)\n1 butir telur (atau 50 gram tahu, jika vegetarian)\n1 sendok makan minyak sayur (seperti minyak zaitun)\n1/2 sendok teh kecap ikan (opsional)",
                        fontFamily = Poppins,
                        color = Color(0xFF0D3B66),
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Langkah-langkah",
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D3B66),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "1. Didihkan air, masukkan mie, dan masak hingga matang. Tiriskan.\n2. Kukus sayuran hingga lunak, sekitar 5-7 menit.\n3. Kocok telur, masak di wajan dengan sedikit minyak hingga matang, lalu potong kecil-kecil.\n4. Dalam mangkuk, campurkan mie, sayuran, dan potongan telur. Tambahkan kecap ikan jika ingin.\n5. Hidangkan mie dalam mangkuk, siap dinikmati!",
                        fontFamily = Poppins,
                        color = Color(0xFF0D3B66),
                        fontSize = 12.sp
                    )
                }
            }
        }
    }
}

@Composable
fun InfoC(label: String) {
    Surface(
        modifier = Modifier
            .padding(4.dp)
            .shadow(4.dp, RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFFFF9E1))
                .padding(4.dp)
                .height(20.dp)
                .width(80.dp)
        ) {
            Text(
                text = label,
                fontSize = 14.sp,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D3B66),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview
fun MiePagePreview(){
    MiePage(navController = rememberNavController())
}