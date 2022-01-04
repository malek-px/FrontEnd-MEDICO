package com.example.medico.Retrofit

import com.example.medico.models.user
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.HashMap

interface MedicoAPI {

    @POST("/api/login")
    fun login(@Body map : HashMap<String, String>): Call<user>

    @POST("/api/register")
    fun SignUp(@Body user: user): Call<user>


    companion object {

        var BASE_URL = "http://10.0.2.2:3000/"

        fun create() : MedicoAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(MedicoAPI::class.java)
        }
    }
}