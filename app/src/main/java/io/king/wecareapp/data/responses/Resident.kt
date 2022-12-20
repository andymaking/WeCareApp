package io.king.wecareapp.data.responses

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Resident(
    val __v: Int,
    val _id: String,
    val address: String,
    val age: Int,
    val caregiverId: String,
    val caregiverName: String,
    val createdAt: String,
    val dateCreated: String,
    val dateModified: String,
    val gender: String,
    val media: String,
    val name: String,
    val phone: String,
    val role: String,
    val updatedAt: String,
    val zipCode: String
): Parcelable