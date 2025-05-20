package com.maverick.viewmodelplayground.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maverick.viewmodelplayground.state.UserState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    init {
        println("ViewModel Created")
    }

    private val _userState = MutableStateFlow(UserState())
    val userState: StateFlow<UserState> = _userState

    fun updateName(name: String) {
        _userState.value = _userState.value.copy(name = name)
    }

    fun updateAge(age: String) {
        _userState.value = _userState.value.copy(age = age)
    }

    fun updateEmail(email: String) {
        _userState.value = _userState.value.copy(email = email)
    }

    fun submitUserData() {
        viewModelScope.launch {
            Log.d("UserViewModel", "User submitted: ${_userState.value}")
        }
    }

    override fun onCleared() {
        super.onCleared()
        println("ViewModel Cleared - Activity destroyed")
        Log.d("UserViewModel", "ViewModel is being destroyed.")
    }
}