package com.example.medico.Retrofit

import com.example.medico.models.user
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.HashMap

interface MedicoAPI {

    @POST("/api/login")
    fun login(@Body map : HashMap<String, String>): Call<user>

    @POST("/api/register")
    fun SignUp(@Body user: user): Call<user>

    @POST("/api/users/findAssistant")
    fun assistantName(@Body map : HashMap<String, String>):Call<user>

    companion object {

        var BASE_URL = "https://medico-for-health.herokuapp.com/"

        fun create() : MedicoAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(MedicoAPI::class.java)
        }
    }
}