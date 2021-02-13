package com.practical.arbeenakhanum.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.practical.arbeenakhanum.R
import com.practical.arbeenakhanum.viewmodel.UserViewModel
import com.practical.arbeenakhanum.viewmodelfactory.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_home_screen.*

/**
 * This class displays the data stored in room database on the screen
 */

class HomeScreenActivity : AppCompatActivity() {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        userViewModel = UserViewModelFactory(this).create(UserViewModel::class.java)
        fetchDataBase()
    }

    private fun fetchDataBase() {

        val userFirstName = intent.getStringExtra("userFirstName")
        val userLastName = intent.getStringExtra("userLastName")
        val userMobileNumber = intent.getStringExtra("userMobileNumber")
        val userEmail = intent.getStringExtra("userEmail")
        val userGender = intent.getStringExtra("userGender")

        tvFirstName.text = userFirstName
        tvLastName.text = userLastName
        tvMobileNumber.text = userMobileNumber
        tvEmail.text = userEmail
        tvGender.text = userGender
    }
}