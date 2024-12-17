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
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
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
import com.example.bismillah.others.BottomBar
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins

@Composable
fun sushiPage(navController: NavHostController){
    Scaffold(
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.detail),
                contentDescription = "Background Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                // Food Image
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
                            navController.popBackStack() // Navigate back to the previous screen
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = "Back",
                                tint = Color.Black
                            )
                        }

                        Image(
                            painter = painterResource(id = R.drawable.detaila),
                            contentDescription = "Food Image",
                            modifier = Modifier
                                .height(190.dp)
                                .width(230.dp)
                                .padding(start = 22.dp)
                                .clip(RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Fit,
                            alignment = Alignment.Center
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sushi Rolls dan Buah",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66),
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Sushi ini adalah pilihan makanan sehat dan lezat untuk MPASI bayi! Dengan cita rasa yang menyenangkan, sushi ini menjadi cara seru untuk memperkenalkan berbagai tekstur dan rasa kepada si kecil.",
                    fontSize = 12.sp,
                    fontFamily = Poppins,
                    color = Color(0xFF0D3B66),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    DetailA(label = "12 bulan")
                    Spacer(modifier = Modifier.width(6.dp))
                    DetailA(label = "250 kkal")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .shadow(1.dp, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                        .background(Color(0x20FFF0E3)),
                ) {
                    // Ingredients
                    Text(
                        text = "Bahan",
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D3B66),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "1 cangkir beras\n1/4 cangkir air matang\n1/2 sendok teh kecap ikan\n1 sendok makan unsalted cheese\n100 gram ikan salmon matang\n1/4 buah mentimun\n2 butir telur puyuh (bisa diganti telur ayam)\nunsalted butter\nBuah apapun yang ada di kulkas",
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        color = Color(0xFF0D3B66)
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                   Text(
                        text = "Langkah-langkah",
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        color = Color(0xFF0D3B66),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "1. Cuci beras dan masak dengan 1 ¼ cangkir air hingga matang, diamkan 10 menit. Tambahkan kecap ikan dan aduk.\n2. Dadar telur dengan sedikit butter, lalu potong tipis.\n3. Potong kecil ikan salmon matang dan iris tipis mentimun.\n4. Ratakan nasi di atas plastik wrap, tambahkan telur, salmon, mentimun, dan unsalted cheese di tengah.\n5. Gulung nasi dengan plastik wrap, simpan sebentar agar mudah dipotong.\n6. Lepaskan plastik wrap, potong sushi rolls, dan sajikan dengan buah.",
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
fun DetailA(label: String) {
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
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
@Preview
fun SushiDetailPreview(){
    sushiPage(navController = rememberNavController())
}