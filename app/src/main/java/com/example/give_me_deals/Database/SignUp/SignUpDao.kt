package com.example.give_me_deals.Database.SignUp

import androidx.room.Dao
import androidx.room.Insert


@Dao
interface SignUpDao {
    @Insert
    fun insertSignupData(signUp: SignUp
    )

}