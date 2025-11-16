package com.example.cruisemastersmad.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cruisemastersmad.ui.database.AppDatabase
import com.example.cruisemastersmad.ui.models.User
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = AppDatabase.getDatabase(application).userDao()

    fun login(email: String, password: String, onResult: (User?) -> Unit) {
        viewModelScope.launch {
            val user = userDao.getUserByEmailAndPassword(email, password)
            onResult(user)
        }
    }

    fun signup(user: User, onResult: (Long) -> Unit) {
        viewModelScope.launch {
            val id = userDao.insertUser(user)
            onResult(id)
        }
    }

    fun checkEmailExists(email: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val user = userDao.getUserByEmail(email)
            onResult(user != null)
        }
    }
}
