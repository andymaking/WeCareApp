package io.king.wecareapp.data.network

import io.king.wecareapp.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("caregiver/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ) : LoginResponse
}