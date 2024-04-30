package com.example.give_me_deals

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.give_me_deals.Database.SignUp.SignUp
import com.example.give_me_deals.Firebase.UserSignUp
import com.example.give_me_deals.databinding.ActivitySignUpBinding
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.firebase.firestore.FirebaseFirestore
import java.util.concurrent.TimeUnit


class sign_up : AppCompatActivity() {
    // Create a Instance
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var mFirestore: FirebaseFirestore
    lateinit var storedVerificationId: String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var binding: ActivitySignUpBinding

    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth = FirebaseAuth.getInstance()
        mFirestore = FirebaseFirestore.getInstance()

        binding.btnSignup.setOnClickListener {
            val fName = binding.etFirstName.text.toString()
            val lName = binding.etLastName.text.toString()
            val Email = binding.etEmailId.text.toString()
            val Mobile = binding.etMobileNo.text.toString()
            val password = binding.etPassword.text.toString()

            val userData = UserSignUp()
            userData.fname = fName
            userData.lName = lName
            userData.Email = Email
            userData.Mobile = Mobile
            userData.Password = password

            if (fName.isBlank() || lName.isBlank() || Email.isBlank() || Mobile.isBlank() || password.isBlank()) {
                Toast.makeText(
                    this,
                    "fname,lname,Email,Mobile,password can't be blank ",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }
            firebaseAuth.createUserWithEmailAndPassword(Email, Mobile)
                .addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        mFirestore.collection("user_info").document("user_list")
                            .set(userData)
                            .addOnSuccessListener {
                                sentOtp()
                            }
                            .addOnFailureListener {
                                Toast.makeText(
                                    this,
                                    "Sign UnsucessFull",
                                    Toast.LENGTH_SHORT
                                )
                            }
                    } else {
                        Toast.makeText(this, "Sign SuccessFull.", Toast.LENGTH_SHORT).show()
                    }

                }
        }



        binding.BackNavigation.setOnClickListener {
            finish()

        }
        binding.tvTitle3.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            return@setOnClickListener
        }
    }


    private fun sendVerificationCode(number: String) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
            number,        // Phone number to verify
            60,                 // Timeout duration
            TimeUnit.SECONDS,   // Unit of timeout
            this,               // Activity (for callback binding)
            object : OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) {
//                    startActivity(Intent(applicationContext, MainActivity::class.java))
//                    finish()
                    Log.d("GFG", "onVerificationCompleted Success")
                }
                override fun onVerificationFailed(e: FirebaseException) {
                    Log.d("GFG", "onVerificationFailed  $e")
                }
                override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                    super.onCodeSent(p0, p1)
                    Log.d("GFG", "onCodeSent: $p0")
                    storedVerificationId = p0
                    resendToken = p1

                    // Start a new activity using intent
                    // also send the storedVerificationId using intent
                    // we will use this id to send the otp back to firebase
                    val intent = Intent(applicationContext, otp::class.java)
                    intent.putExtra("storedVerificationId", storedVerificationId)
                    startActivity(intent)
                    finish()
                }
            })
    }

    fun sentOtp() {
        var MobileNo = binding.etMobileNo.text.trim().toString()

        // get the phone number from edit text and append the country cde with it
        if (MobileNo.isNotEmpty()) {
            MobileNo = "+91$MobileNo"
            sendVerificationCode(MobileNo)
        } else {
            Toast.makeText(this, "Enter mobile number", Toast.LENGTH_SHORT).show()
        }
    }

}
