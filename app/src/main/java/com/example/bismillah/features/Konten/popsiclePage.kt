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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins

@Composable
fun PopSiclePage(navController: NavHostController){
    Scaffold(
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.detail),
                contentDescription = "Background Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(Color(0x20FFF0E3))
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 20.dp)
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
                            painter = painterResource(id = R.drawable.b),
                            contentDescription = "Food Image",
                            modifier = Modifier
                                .height(220.dp)
                                .width(230.dp)
                                .padding(start = 12.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.Center
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Popsicle Mangga",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66),
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Popsicle mangga dengan yogurt adalah camilan sehat untuk bayi, ideal saat tumbuh gigi. Kombinasi mangga dan yogurt memberikan sensasi dingin yang menenangkan gusi, kaya vitamin A, C, dan probiotik untuk kesehatan pencernaan.",
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
                    InfoB(label = ">6 bulan")
                    Spacer(modifier = Modifier.width(6.dp))
                    InfoB(label = "60 kkal")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Column(modifier = Modifier.verticalScroll(rememberScrollState())
                    .background(Color(0x20FFF0E3))
                    .shadow(1.dp, RoundedCornerShape(8.dp))
                    .padding(8.dp)
                ) {
                    Text(
                        text = "Bahan",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins,
                        color = Color(0xFF0D3B66),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "1 buah mangga matang\n100 ml yogurt plain\n50 ml air matang",
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
                        text = "1. Kupas mangga, potong daging buahnya menjadi dadu kecil.\n2. Masukkan potongan mangga ke dalam blender. tambahkan sedikit air matang. Blender hingga halus.\n3. Tambahkan yogurt plain ke dalam blender. Campur hingga semua bahan tercampur rata.\n4. Tuang campuran mangga dan yogurt ke dalam cetakan popsicle. Isi cetakan hingga hampir penuh, tetapi pastikan ada sedikit ruang untuk menghindari meluap saat beku.\n5. Masukkan cetakan ke dalam freezer dan biarkan membeku selama sekitar 4-6 jam atau hingga popsicle mengeras.",
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
fun InfoB(label: String) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shadowElevation = 4.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color(0xFFFFF9E1), shape = RoundedCornerShape(8.dp))
                .padding(4.dp)
                .height(20.dp)
                .width(80.dp)
        ) {
            Text(
                text = label,
                fontFamily = Poppins,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D3B66),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp)
            )
        }
    }
}


@Composable
@Preview
fun PopsiclePagePreview(){
    PopSiclePage(navController = rememberNavController())
}
