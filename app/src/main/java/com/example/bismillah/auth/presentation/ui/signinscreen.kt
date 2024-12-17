package com.example.bismillah.auth.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.bismillah.ui.theme.Poppins
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.clickable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.example.bismillah.ui.theme.Poppins
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.bismillah.auth.data.SignInData
import com.example.bismillah.auth.data.SignUpData
import com.example.bismillah.auth.presentation.viewModel.AuthState
import com.example.bismillah.auth.presentation.viewModel.AuthView


@Composable
fun SigninScreen(navController: NavController, authViewModel: AuthView) {

    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgloginv2),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        // Sign In Content
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 0.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(240.dp))

            // Avatar atau gambar robot di bagian atas
//            Image(    painter = painterResource(id = R.drawable.robotsi),
////                contentDescription = "Logo",
////                modifier = Modifier.size(180.dp) // Ukuran gambar robot
////            )
//

            Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Login to Your Account",
                        fontFamily = Poppins,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        placeholder = {
                            Text(text = "Email", fontFamily = Poppins, fontSize = 12.sp)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFFFF1C9),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                        },
                        placeholder = {
                            Text(text = "Password", fontFamily = Poppins, fontSize = 12.sp)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFFFFF1C9),
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done
                        )
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(
                        onClick = {
                            val signInData = SignInData(email, password)
                            authViewModel.login(signInData)
                        },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFFFFD54F),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(text = "Sign In", fontFamily = Poppins, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }

                    Spacer(modifier = Modifier.height(32.dp))

//                    // Google Sign In Button
//                    Image(
//                        painter = painterResource(id = R.drawable.google),
//                        contentDescription = "Google Logo",
//                        modifier = Modifier
//                            .size(35.dp)
//                            .clickable(onClick = { /* Handle Google Sign In */ })
//                    )
//
//                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Don’t have an account?", color = Color.Black, fontSize = 14.sp, fontFamily = Poppins)
                        TextButton(
                            onClick = { navController.navigate("signup") },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(text = "Sign Up", color = Color.Blue, fontSize = 12.sp, fontFamily = Poppins)
                        }
                    }

                }
        }
        Image(
            painter = painterResource(id = R.drawable.tulisan),
            contentDescription = "TulisanLogo",
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.BottomCenter)
        )
    }
}

//@Preview
//@Composable
//fun SignInPreview() {
//    SigninScreen(navController = rememberNavController())
//}
