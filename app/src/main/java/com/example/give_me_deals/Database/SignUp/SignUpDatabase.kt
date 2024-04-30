package com.example.give_me_deals.Database.SignUp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [SignUp::class], version = 1)
abstract class SignUpDatabase : RoomDatabase(){

    abstract fun signupDao(): SignUpDao
}