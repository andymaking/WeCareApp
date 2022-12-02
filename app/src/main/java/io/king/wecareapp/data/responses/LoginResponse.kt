package io.king.wecareapp.data.responses

import androidx.room.Entity
import androidx.room.PrimaryKey


data class LoginResponse(
    val `data`: Data,
    val message: String,
    val success: Boolean
)

data class Data(
    val token: String,
    val user: User
)

@Entity
data class User(
    val __v: Int,
    @PrimaryKey(autoGenerate = false)
    val _id: String,
    val address: String,
    val createdAt: String,
    val dateCreated: String,
    val dateModified: String,
    val email: String,
    val gender: String,
    val licenseNo: String,
    val name: String,
    val password: String,
    val phone: String,
    val role: String,
    val updatedAt: String
)