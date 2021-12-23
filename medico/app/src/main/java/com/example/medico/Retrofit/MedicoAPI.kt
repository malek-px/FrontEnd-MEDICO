package com.example.medico.Retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MedicoAPI {
    @POST("/login")
    fun login(@Body body: JsonObject): Call<JsonObject>

    @POST("/register")
    fun SignUp(@Body body: JsonObject): Call<JsonObject>

}