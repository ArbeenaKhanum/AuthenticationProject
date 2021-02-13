package com.practical.arbeenakhanum.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.practical.arbeenakhanum.R
import com.practical.arbeenakhanum.viewmodel.UserViewModel
import com.practical.arbeenakhanum.viewmodelfactory.UserViewModelFactory
import kotlinx.android.synthetic.main.activity_sign_up.*

/**
 * This class handles SignUp
 */

class SignUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initListeners()
        userViewModel = UserViewModelFactory(this).create(UserViewModel::class.java)
    }

    private fun initListeners() {
        signUpBtn.setOnClickListener(this)
    }

    /* Method to store data into room database on click of sign up button */

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.signUpBtn -> {
                if (isDataValid()) {
                    userViewModel.insertDataToDatabase(
                        firstName = etvFirstName.text.toString(),
                        lastName = etvLastName.text.toString(),
                        mobileNumber = etvMobileNumber.text.toString(),
                        email = etvEmail.text.toString(),
                        gender = etvGender.text.toString(),
                        password = etvPassword.text.toString()
                    )

                    val intent = Intent(this@SignUpActivity, LoginActivity::class.java)
                    intent.putExtra(etvMobileNumber.text.toString(), "userMobileNumber")
                    intent.putExtra(etvPassword.text.toString(), "userPassword")
                    startActivity(intent)
                }
            }
        }
    }

    /* Method for validation of edit text fields */

    private fun isDataValid(): Boolean {
        if (etvFirstName.text.toString().isEmpty()) {
            etvFirstName.error = "First Name Field is empty"
            return false
        }

        if (etvLastName.text.toString().isEmpty()) {
            etvLastName.error = "Last name Field is empty"
            return false
        }

        if (etvMobileNumber.text.toString().isEmpty()) {
            etvLastName.error = "Mobile Number Field is empty"
            return false
        }

        if (etvEmail.text.toString().isEmpty()) {
            etvEmail.error = "Email cannot be empty"
            return false
        } else if (!isEmailValid(etvEmail.text.toString())) {
            etvEmail.error = getString(R.string.invalid_email)
            return false
        }

        if (etvPassword.text.toString().isEmpty()) {
            etvPassword.error = "Password cannot be empty"
            return false
        } else if (!isPasswordValid(etvPassword.text.toString())) {
            etvPassword.error = getString(R.string.invalid_password)
            return false
        }

        if (etvGender.text.toString().isEmpty()) {
            etvGender.error = "Gender cannot be empty"
            return false
        }
        return true
    }

    private fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 6
    }
}