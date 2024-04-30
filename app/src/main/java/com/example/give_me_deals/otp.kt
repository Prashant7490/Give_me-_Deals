package com.example.give_me_deals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.give_me_deals.databinding.ActivityOtpBinding
import com.example.give_me_deals.databinding.FragmentBusinessBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class otp : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityOtpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()
        val storedVerificationId= intent.getStringExtra("storedVerificationId")

        binding.txt1.addTextChangedListener(GenericTextWatcher(binding.txt1, binding.txt2))
        binding.txt2.addTextChangedListener(GenericTextWatcher(binding.txt2, binding.txt3))
        binding.txt3.addTextChangedListener(GenericTextWatcher(binding.txt3, binding.txt4))
        binding.txt4.addTextChangedListener(GenericTextWatcher(binding.txt4, binding.txt5))
        binding.txt5.addTextChangedListener(GenericTextWatcher(binding.txt5, binding.txt6))
        binding.txt6.addTextChangedListener(GenericTextWatcher(binding.txt6, null ))


        binding.txt1.setOnKeyListener(GenericKeyEvent(binding.txt1, null))
        binding.txt2.setOnKeyListener(GenericKeyEvent(binding.txt2, binding.txt1))
        binding.txt3.setOnKeyListener(GenericKeyEvent(binding.txt3, binding.txt2))
        binding.txt4.setOnKeyListener(GenericKeyEvent(binding.txt4,binding.txt3))
        binding.txt5.setOnKeyListener(GenericKeyEvent(binding.txt5,binding.txt4))
        binding.txt6.setOnKeyListener(GenericKeyEvent(binding.txt6,binding.txt5))

        val button = findViewById<Button>(R.id.BtnVerify)
        button.setOnClickListener {
            var otp1 =binding.txt1.text
            var otp2 =binding.txt2.text
            var otp3 =binding.txt3.text
            var otp4 =binding.txt4.text
            var otp5 =binding.txt5.text
            var otp6 =binding.txt6.text

            val otp = StringBuilder("")
            otp.append(otp1)
            otp.append(otp2)
            otp.append(otp3)
            otp.append(otp4)
            otp.append(otp5)
            otp.append(otp6)

            if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp.toString()
                )
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this,"Enter OTP", Toast.LENGTH_SHORT).show()
            }
            }
        }
    class GenericKeyEvent internal constructor(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener{
        override fun onKey(p0: View?, keyCode: Int, event: KeyEvent?): Boolean {
            if(event!!.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.id != R.id.txt1 && currentView.text.isEmpty()) {
                //If current is empty then previous EditText's number will also be deleted
                previousView!!.text = null
                previousView.requestFocus()
                return true
            }
            return false
        }
    }
    class GenericTextWatcher internal constructor(private val currentView: View, private val nextView: View?) :
        TextWatcher {
        override fun afterTextChanged(editable: Editable) {
            val text = editable.toString()
            when (currentView.id) {
                R.id.txt1 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.txt2 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.txt3 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.txt4 -> if (text.length == 1) nextView!!.requestFocus()
                R.id.txt5 -> if (text.length == 1) nextView!!.requestFocus()
//                R.id.txt6 -> if (text.length == 1) nextView!!.requestFocus()

                //You can use EditText4 same as above to hide the keyboard
            }
        }
        override fun beforeTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int,
        ) {
        }
        override fun onTextChanged(
            arg0: CharSequence,
            arg1: Int,
            arg2: Int,
            arg3: Int
        ) {
        }

    }

fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
    auth.signInWithCredential(credential)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val intent = Intent(this , HomeActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Sign in failed, display a message and update the UI
                if (task.exception is FirebaseAuthInvalidCredentialsException) {
                    // The verification code entered was invalid
                    Toast.makeText(this,"Invalid OTP", Toast.LENGTH_SHORT).show()
                }
            }
        }
}

}