package io.king.wecareapp.data.repository

import io.king.wecareapp.data.UserPreferences
import io.king.wecareapp.data.network.AuthApi
import io.king.wecareapp.data.responses.User

class AuthRepository(
    private val api: AuthApi,
    private val preferences: UserPreferences,
)  : BaseRepository(){

    suspend fun login(
        email: String,
        password: String
    ) = safeApiCall {
        api.login(email, password)
    }

    suspend fun signUp(
        email: String,
        password: String,
        media: String,
        lastName: String,
        firstName: String,
        userName: String
    ) = safeApiCall {
        api.signUp(email, password, firstName,lastName, userName, media)
    }

    suspend fun saveAuthToken(token: String){
        preferences.saveAccessTokens(token)
    }

}