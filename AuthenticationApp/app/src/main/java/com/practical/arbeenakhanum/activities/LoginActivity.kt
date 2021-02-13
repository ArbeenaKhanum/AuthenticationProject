package com.practical.arbeenakhanum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.practical.arbeenakhanum.R
import com.practical.arbeenakhanum.viewmodel.LoginViewModel
import com.practical.arbeenakhanum.viewmodel.UserViewModel
import com.practical.arbeenakhanum.viewmodelfactory.LoginViewModelFactory
import com.practical.arbeenakhanum.viewmodelfactory.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*

/**
 * This class handles login
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = LoginViewModelFactory(this).create(LoginViewModel::class.java)
        loginBtn.setOnClickListener {
            userLoginValidation()
        }
    }

    private fun userLoginValidation() {
        loginViewModel.fetchDataFromDatabase(
            etvLoginMobileNumber.text.toString(), etvLoginPassword.text.toString()
        ).observe(this, Observer {
            if (it != null) {
                val intent = Intent(this@LoginActivity, HomeScreenActivity::class.java)
                intent.putExtra("userMobileNumber", it.mobileNumber)
                intent.putExtra("userPassword", it.password)
                intent.putExtra("userEmail", it.email)
                intent.putExtra("userFirstName", it.firstName)
                intent.putExtra("userLastName", it.lastName)
                intent.putExtra("userGender", it.gender)

                startActivity(intent)
            } else {
                Toast.makeText(this@LoginActivity, "User not found", Toast.LENGTH_SHORT).show()
            }
        })
    }
}