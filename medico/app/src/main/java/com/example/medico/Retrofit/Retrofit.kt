package com.example.medico.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {

    var BASE_URL = "https://10.0.2.2:3000/api/" // Localhost will be changed to 10.0.2.2 in Emulator

    fun getRetroClinetInstance() : Retrofit {

        val gson = GsonBuilder().setLenient().create()
        //return Retrofit builder
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    }
}