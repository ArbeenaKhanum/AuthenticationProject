package com.practical.arbeenakhanum.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.practical.arbeenakhanum.database.LoginData
import com.practical.arbeenakhanum.database.UserDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(private val context: Context) : ViewModel() {

    /* Method to insert the data into room database*/

    fun insertDataToDatabase(
        firstName: String,
        lastName: String,
        mobileNumber: String,
        email: String,
        gender: String,
        password: String
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            val user =
                LoginData(
                    firstName = firstName, lastName = lastName, mobileNumber
                    = mobileNumber, email = email, gender = gender, password = password
                )
            UserDatabase.getInstance(context).userDao.insertUser(user)
        }
    }
}