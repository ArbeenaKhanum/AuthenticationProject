package com.practical.arbeenakhanum.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(loginData: LoginData)

    @Query("Select * FROM LoginData Where mobileNumber = :mobileNumber and password =:password")
    fun getUserDetails(mobileNumber: String, password : String): LiveData<LoginData>

}