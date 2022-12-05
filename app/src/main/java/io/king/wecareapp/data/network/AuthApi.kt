package io.king.wecareapp.data.network

import io.king.wecareapp.data.responses.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AuthApi {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ) : LoginResponse

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun signUp(
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("firstName") firstName: String,
        @Field("lastName") lastName: String,
        @Field("userName") userName: String,
        @Field("media") media: String,
    ) : LoginResponse
}