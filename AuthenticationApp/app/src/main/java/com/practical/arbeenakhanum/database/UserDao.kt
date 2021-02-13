package com.practical.arbeenakhanum.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    /**
     * Insert operation to insert the data
     */

    @Insert
    suspend fun insertUser(loginData: LoginData)

    /**
     * Query operation to fetch the stored data
     */

    @Query("Select * FROM LoginData Where mobileNumber = :mobileNumber and password =:password")
    fun getUserDetails(mobileNumber: String, password : String): LiveData<LoginData>

}