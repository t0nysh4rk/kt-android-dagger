package com.example.android.dagger.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.android.dagger.MyApplication
import com.example.android.dagger.R
import com.example.android.dagger.login.LoginActivity
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity

class SplashActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userManager = (application as MyApplication).appComponent.userManager()
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            startActivity(Intent(this, MainActivity::class.java))

        }

        finish()

    }
}