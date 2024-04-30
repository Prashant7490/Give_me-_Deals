package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.give_me_deals.databinding.ActivityScreen3Binding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btn)
        button.setOnClickListener {
            val intent = Intent(this, screen3::class.java)
            startActivity(intent)
            finish()
        }


        }
    }
