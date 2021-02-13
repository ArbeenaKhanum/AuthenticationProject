package com.practical.arbeenakhanum.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LoginData")
data class LoginData(
    @PrimaryKey(autoGenerate = true)
    var loginId: Int = 0,

    @ColumnInfo(name = "firstName")
    var firstName: String,

    @ColumnInfo(name = "lastName")
    var lastName: String,

    @ColumnInfo(name = "mobileNumber")
    var mobileNumber: Int,

    @ColumnInfo(name = "email")
    var email: String,

    @ColumnInfo(name = "gender")
    var gender: String,

    @ColumnInfo(name = "password")
    val password: String
)