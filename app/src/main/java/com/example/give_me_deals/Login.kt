package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.give_me_deals.databinding.ActivityLoginBinding
class Login : AppCompatActivity(){
    lateinit var loginBinding: ActivityLoginBinding

    lateinit var Email: EditText
    lateinit var MobileNumber:EditText
    lateinit var Password:EditText
    lateinit var Login:Button
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        val view = loginBinding.root
        setContentView(view)
        loginBinding.tvTitle3.setOnClickListener {
            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)
        }

        loginBinding.btn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}