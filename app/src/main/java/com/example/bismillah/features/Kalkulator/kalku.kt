package com.example.bismillah.features.Kalkulator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.bismillah.R
import com.example.bismillah.ui.theme.Poppins
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun nutritionStatusCalculator(navController: NavHostController) {
    var gender by remember { mutableStateOf("") }
    var isDropdownExpanded by remember { mutableStateOf(false) }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5EEDC)),
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = "Back",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(26.dp))
                    Text(
                        text = "Index Massa Tubuh",
                        fontSize = 18.sp,
                        fontFamily = Poppins,
                        color = Color(0xFF0D3B66),
                        fontWeight = FontWeight.Bold,
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))

                Column(
                    modifier = Modifier
                        .width(400.dp)
                        .height(170.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
                Image(
                    painter = painterResource(id = R.drawable.imtrobot),
                    contentDescription = "Robot",
                    modifier = Modifier
                        .height(160.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.Center
                )
                Spacer(modifier = Modifier.height(18.dp))}

                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .weight(1f)
                        .fillMaxHeight()
                ){
                    CardInputField(label = "Jenis Kelamin") {
                        Box {
                            TextField(
                                value = gender,
                                onValueChange = {},
                                readOnly = true,
                                trailingIcon = {
                                    IconButton(onClick = { isDropdownExpanded = true }) {
                                        Icon(Icons.Filled.ArrowDropDown, contentDescription = null)
                                    }
                                },
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = Color.White
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(46.dp),
                            )
                            DropdownMenu(
                                expanded = isDropdownExpanded,
                                onDismissRequest = { isDropdownExpanded = false }
                            ) {
                                listOf("Perempuan", "Laki-laki").forEach { option ->
                                    DropdownMenuItem(onClick = {
                                        gender = option
                                        isDropdownExpanded = false
                                    }) {
                                        Text(text = option)
                                    }
                                }
                            }
                        }
                    }

                    CardInputField(label = "Umur (bulan)") {
                        TextField(
                            value = age,
                            onValueChange = { age = it },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp),
                        )
                    }

                    CardInputField(label = "Berat Badan (kg)") {
                        TextField(
                            value = weight,
                            onValueChange = { weight = it },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp),
                        )
                    }

                    CardInputField(label = "Tinggi Badan (cm)") {
                        TextField(
                            value = height,
                            onValueChange = { height = it },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp),
                        )
                    }

                    Button(
                        onClick = {
                            result = calculateNutritionStatus(gender, age, weight, height)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107)),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                    ) {
                        Text("Konsultasi sekarang", color = Color.White, fontWeight = FontWeight.Bold)
                    }

                    if (result.isNotEmpty()) {
                        Card(
                            backgroundColor = Color.White,
                            shape = RoundedCornerShape(8.dp),
                            elevation = 4.dp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Kategori Status Gizi",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp,
                                    color = Color(0xFF0D3B66),
                                    modifier = Modifier.padding(bottom = 8.dp)
                                )
                                Text(
                                    text = result,
                                    fontSize = 14.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CardInputField(label: String, content: @Composable () -> Unit) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = label,
                fontSize = 14.sp,
                color = Color(0xFF0D3B66),
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            content()
        }
    }
}

fun calculateNutritionStatus(gender: String, age: String, weight: String, height: String): String {
    val weightKg = weight.toDoubleOrNull() ?: return "Input berat badan tidak valid"
    val heightCm = height.toDoubleOrNull() ?: return "Input tinggi badan tidak valid"
    val bmi = weightKg / ((heightCm / 100) * (heightCm / 100))

    return when (gender) {
        "Laki-laki" -> {
            when {
                bmi < 12 -> "Gizi buruk"
                bmi in 12.1..13.0 -> "Gizi kurang"
                bmi in 13.1..16.5 -> "Gizi baik"
                bmi in 16.6..18.1 -> "Beresiko gizi lebih"
                bmi in 18.2..20.6 -> "Gizi lebih"
                bmi > 20.6 -> "Obesitas"
                else -> "Status gizi tidak diketahui"
            }
        }
        "Perempuan" -> {
            when {
                bmi < 11.5 -> "Gizi buruk"
                bmi in 11.6..12.6 -> "Gizi kurang"
                bmi in 12.7..16.7 -> "Gizi baik"
                bmi in 16.8..18.4 -> "Beresiko gizi lebih"
                bmi in 18.5..21.0 -> "Gizi lebih"
                bmi > 21.0 -> "Obesitas"
                else -> "Status gizi tidak diketahui"
            }
        }
        else -> "Jenis kelamin tidak valid"
    }
}

@Preview()
@Composable
fun PreviewNutritionStatusCalculator() {
    nutritionStatusCalculator(navController = rememberNavController())
}
