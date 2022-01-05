package com.example.medico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.medico.models.user

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var Guser: user
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}