package com.practical.arbeenakhanum.viewmodelfactory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practical.arbeenakhanum.viewmodel.UserViewModel

class UserViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                return UserViewModel(context) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}