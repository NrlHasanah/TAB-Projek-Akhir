package com.example.bismillah.auth.presentation.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bismillah.R
import com.example.bismillah.auth.presentation.viewModel.AuthView
import com.example.bismillah.ui.theme.Poppins
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.bismillah.auth.data.SignUpData
import com.example.bismillah.auth.presentation.viewModel.AuthState


@Composable
fun SignupScreen(navController: NavController, authViewModel: AuthView){
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    var name by remember{
        mutableStateOf("")
    }
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("signin")
            is AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Create Your Account",
                fontFamily = Poppins,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(36.dp))

            TextField(
                value = name,
                onValueChange = { name = it
                },
                placeholder = {
                    Text(
                        text = "Name",
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFF1C9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = email,
                onValueChange = { email = it
                },
                placeholder = {
                    Text(
                        text = "Email",
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFF1C9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { password = it
                },
                placeholder = {
                    Text(
                        text = "Password",
                        fontFamily = Poppins,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color(0xFFFFF1C9),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    val signUpData = SignUpData(name = name, email = email, password = password)
                    authViewModel.signUp(signUpData)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFFFD54F),
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(5.dp, Color(0xFFFFD54F))
            ) {
                Text(
                    text = "Create Account",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

//            Image(
//                painter = painterResource(id = R.drawable.google),
//                contentDescription = "Google Logo",
//                modifier = Modifier
//                    .size(35.dp)
//                    .clickable(onClick = { /* Handle Google Sign Up */ })
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))

            // Sign In Option
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Already have an account?", color = Color.Black, fontSize = 12.sp, fontFamily = Poppins)
                TextButton(
                    onClick = { navController.navigate("signin") },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = "Sign In", color = Color.Blue, fontSize = 12.sp, fontFamily = Poppins)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.chatbot),
                contentDescription = "Robot Logo",
                modifier = Modifier
                    .size(220.dp)
                    .padding(bottom = 16.dp))
        }

        Image(
            painter = painterResource(id = R.drawable.tulisan),
            contentDescription = "Tulisan Logo",
            modifier = Modifier
                .size(72.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp)
        )
    }
}

//@Preview
//@Composable
//fun SignUpPreview() {
//    SignupScreen()
//}
