package com.practical.arbeenakhanum.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(loginData: LoginData)

    @Query("Select password FROM LoginData Where mobileNumber = :mobileNumber")
    fun getUserPassword(mobileNumber: Int?): String?

    @Query("Select * FROM LoginData Where mobileNumber = :mobileNumber")
    fun getUserDetails(mobileNumber: Int?): LiveData<LoginData?>

}