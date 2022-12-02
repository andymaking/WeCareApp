package io.king.wecareapp.data.responses

data class GetResidentsResponse(
    val `data`: Datas,
    val message: String,
    val success: Boolean
)

data class Datas(
    val residents: List<Residentz>
)

data class Residentz(
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
    val licenseNo: String,
    val name: String,
    val phone: String,
    val role: String,
    val updatedAt: String
)