package com.example.bismillah.features.Profil

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.bismillah.R
import com.example.bismillah.auth.presentation.viewModel.AuthView
import com.example.bismillah.others.BottomBar
import com.example.bismillah.ui.theme.Poppins
import com.google.firebase.storage.FirebaseStorage

@Composable
fun profileScreen(navController: NavHostController, authViewModel: AuthView) {
    val auth = FirebaseAuth.getInstance()
    val user = auth.currentUser
    val firestore = FirebaseFirestore.getInstance()
    val storage = FirebaseStorage.getInstance()

    var username by remember { mutableStateOf(user?.displayName ?: "") }
    var email by remember { mutableStateOf(user?.email ?: "") }
    var birthDate by remember { mutableStateOf("") }
    var fatherName by remember { mutableStateOf("") }
    var motherName by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var profileImageUrl by remember { mutableStateOf(user?.photoUrl?.toString() ?: "") }

    LaunchedEffect(user) {
        user?.let {
            firestore.collection("users").document(it.uid).get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        birthDate = document.getString("birthDate") ?: ""
                        fatherName = document.getString("fatherName") ?: ""
                        motherName = document.getString("motherName") ?: ""
                        age = document.getString("age") ?: ""
                        profileImageUrl = document.getString("profileImageUrl") ?: ""
                    }
                }
                .addOnFailureListener {

                }
        }
    }

    val pickImageLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            val storageRef = storage.reference.child("profileImages/${user?.uid}.jpg")
            storageRef.putFile(uri)
                .addOnSuccessListener {
                    storageRef.downloadUrl.addOnSuccessListener { downloadUrl ->
                        profileImageUrl = downloadUrl.toString()
                        firestore.collection("users").document(user!!.uid).update("profileImageUrl", profileImageUrl)
                            .addOnSuccessListener {
                                Log.d("Firestore", "URL gambar berhasil disimpan")
                            }
                            .addOnFailureListener { e ->
                                Log.e("Firestore", "Gagal menyimpan URL gambar: $e")
                            }
                    }
                }
                .addOnFailureListener { e ->
                    Log.e("Storage", "Gagal mengunggah gambar: $e")
                }
        }
    }

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }
    ){  innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 70.dp, start = 16.dp, end = 20.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = username,
                fontSize = 20.sp,
                color = Color(0xFF0D3B66),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            ProfileInputField(
                label = "Usia",
                value = age,
                onValueChange = { age = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            ProfileInputField(
                label = "Tanggal lahir",
                value = birthDate,
                onValueChange = { birthDate = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            ProfileInputField(
                label = "Ayah",
                value = fatherName,
                onValueChange = { fatherName = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            ProfileInputField(
                label = "Ibu",
                value = motherName,
                onValueChange = { motherName = it }
            )

            // Save Button
            Button(
                onClick = {
                    user?.let {
                        val userData = hashMapOf(
                            "birthDate" to birthDate,
                            "fatherName" to fatherName,
                            "motherName" to motherName,
                            "age" to age,
                            "profileImageUrl" to profileImageUrl
                        )
                        firestore.collection("users").document(it.uid).set(userData)
                            .addOnSuccessListener {
                                // Handle successful save
                            }
                            .addOnFailureListener {
                                // Handle errors
                            }
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF0D3B66)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text("Save", color = Color.White, fontWeight = FontWeight.Bold)
            }

            // Log Out Button
            Button(
                onClick = {
                    authViewModel.signOut(navController)
                    //auth.signOut()
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC107)),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            ) {
                Text("Log Out", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ProfileInputField(label: String, value: String, onValueChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(text = label, fontWeight = FontWeight.Bold, color = Color(0xFF0D3B66), fontFamily = Poppins)
        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(top = 8.dp),
            placeholder = { Text("Enter $label") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color(0xFF4CAF50),
                unfocusedIndicatorColor = Color.Gray
            )
        )
    }
}

