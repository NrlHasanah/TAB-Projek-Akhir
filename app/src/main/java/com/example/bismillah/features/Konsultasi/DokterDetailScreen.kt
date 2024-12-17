package com.example.bismillah.features.Konsultasi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext

@Composable
fun DetailDokterScreen(
    imageRes: Int,
    name: String,
    description: String,
    hospital: String,
    practiceTime: String,
    waNumber: String
) {
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(modifier = Modifier.fillMaxSize().padding()) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .shadow(2.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
            Column(modifier = Modifier.fillMaxSize().padding(start = 20.dp, end = 20.dp)) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color(0xFF0D3B66)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = hospital,
                    fontSize = 14.sp,
                    color = Color(0xFF0D3B66)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Tentang",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF0D3B66)
                )
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = Color(0xFF0D3B66)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Waktu Praktik",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color(0xFF0D3B66)
                )
                Text(
                    text = practiceTime,
                    fontSize = 14.sp,
                    color = Color(0xFF0D3B66)
                )
                Spacer(modifier = Modifier.height(36.dp))
                Button(
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://wa.me/$waNumber")
                        )
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFC107))
                ) {
                    Text(
                        text = "Hubungi via WhatsApp",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,

                    )
                }
            }
        }
    }
}
