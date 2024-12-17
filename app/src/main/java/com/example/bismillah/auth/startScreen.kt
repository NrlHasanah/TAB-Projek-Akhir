package com.example.bismillah.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.bismillah.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bismillah.ui.theme.Poppins
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import com.example.bismillah.others.Screen
import kotlinx.coroutines.delay

@Composable
fun StartScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(top = 72.dp, start = 20.dp, end = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Siap mencegah stunting?",
            fontSize = 16.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D3B66),
            modifier = Modifier.padding(start = 16.dp,)

        )

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Let's Go!!",
            fontSize = 32.sp,
            fontFamily = Poppins,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D3B66),
            modifier = Modifier.padding(bottom = 8.dp)

        )

        Spacer(modifier = Modifier.height(36.dp))
        Image(
            painter = painterResource(id = R.drawable.robot),
            contentDescription = "Descriptive content for the image",
            modifier = Modifier
                .size(280.dp)
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(80.dp))
        Button(
            onClick = {
                navController.navigate(Screen.SignIn.route)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFFFC107)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(44.dp)
                .shadow(1.dp, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "Mulai Sekarang",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
@Preview
fun StartScreenPreview(){
    StartScreen(navController = rememberNavController())
}
