package com.practical.arbeenakhanum.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.practical.arbeenakhanum.R


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val runnable = Runnable {
            val startIntent = Intent(this, SignUpActivity::class.java)
            startActivity(startIntent)
            finish()
        }

        val handler = Handler()
        handler.postDelayed(runnable, 3000)
    }
}