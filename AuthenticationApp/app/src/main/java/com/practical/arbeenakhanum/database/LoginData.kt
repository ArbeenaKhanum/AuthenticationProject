package com.practical.arbeenakhanum.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginData")
data class LoginData(
    @PrimaryKey(autoGenerate = true)
    var loginId: Int = 0,

    @ColumnInfo(name = "firstName")
    val firstName: String,

    @ColumnInfo(name = "lastName")
    val lastName: String,

    @ColumnInfo(name = "mobileNumber")
    val mobileNumber: Int,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "gender")
    val gender: String,

    @ColumnInfo(name = "password")
    val password: String
)