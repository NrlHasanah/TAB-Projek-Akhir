package com.example.bismillah.auth.data

data class SignInData(
    val email: String,
    val password: String
)

data class SignUpData(
    val name: String,
    val email: String,
    val password: String
)

data class ResetPasswordData(
    val email: String
)