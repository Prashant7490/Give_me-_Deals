package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlin.concurrent.thread

class screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        Handler().postDelayed(
            {val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
                finish()},3000

        )

    }



}