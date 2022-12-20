package io.king.wecareapp.data.network

import io.king.wecareapp.data.responses.AllAssignedResidentsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi{

    @GET("caregiver/residents?id={id}")
    suspend fun getAssignedResidents(
        @Path("id") id: String,
    ): AllAssignedResidentsResponse
}