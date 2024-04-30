package com.example.give_me_deals.Database.LogIn

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "LoginTable")
data class LogIn (
    @PrimaryKey (autoGenerate = true)
    val emailorphone : String,
    val password:String
)
