package com.example.give_me_deals.Database.SignUp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "SignUp")
data class SignUp(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val firstName: String,
    val lastName: String,
    val emailId: String,
    val mobileNo: String,
    val enterPassword:String,

    )
