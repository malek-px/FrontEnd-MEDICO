package com.example.medico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.medico.AcceuilApp.LoginActivity

lateinit var logout : Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        logout = findViewById(R.id.buttonlast)

        logout.setOnClickListener {
            val intent = Intent(this@MainActivity2, LoginActivity::class.java)
            startActivity(intent)}
        }

    }
