package io.king.wecareapp.data.repository

import io.king.wecareapp.data.network.UserApi

class UserRepository(
    private val api: UserApi
)  : BaseRepository(){

    suspend fun getAssignedResidents(
        id: String,
    ) = safeApiCall {
        api.getAssignedResidents(id)
    }


}