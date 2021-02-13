package com.practical.arbeenakhanum.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.practical.arbeenakhanum.database.LoginData
import com.practical.arbeenakhanum.database.UserDatabase

class LoginViewModel(private val context: Context) : ViewModel() {
    /* Method to fetch the stored data from room database*/

    fun fetchDataFromDatabase(mobileNumber: String, password: String): LiveData<LoginData> {
        return UserDatabase.getInstance(context).userDao.getUserDetails(mobileNumber, password)
    }
}