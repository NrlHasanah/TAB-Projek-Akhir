package com.example.bismillah.user

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.ViewModel

data class UserData(
    val name: String = "",
    val email: String = "",
    val password: String = ""
)

class UserViewModel : ViewModel() {
    private val _userData = MutableStateFlow(UserData())
    val userData: StateFlow<UserData> = _userData

    fun updateUserData(name: String, email: String, password: String) {
        _userData.value = UserData(name, email, password)
    }

    fun clearUserData() {
        _userData.value = UserData()
    }
}
