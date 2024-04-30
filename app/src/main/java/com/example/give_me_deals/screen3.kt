package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class screen3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen3)
        val button = findViewById<Button>(R.id.btn)
        button.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
            finish()
        }
    }
}