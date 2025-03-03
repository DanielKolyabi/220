package ru.relabs.storekeeper.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body loginData: LoginData): Response<UserData>


}