package com.example.medico.AcceuilApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.medico.EspacePatient.PatientHome
import com.example.medico.R
import com.example.medico.Retrofit.MedicoAPI
import com.example.medico.models.user
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

lateinit var email :EditText
lateinit var password : EditText

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email= findViewById<EditText>(R.id.email)
        password= findViewById<EditText>(R.id.password)
    }

    public fun Login(view: View){

        //creation of retrofit object
        val apiInterface = MedicoAPI.create()
        //map usage for the body
        val map: HashMap<String, String> = HashMap()
        map["username"] = email.toString()
        map["password"] = password.toString()

        //consol log
        Log.e("user",map.toString())
        //Post login api usage
        apiInterface.login(map).enqueue(object : Callback<user> {
            override fun onResponse(
                call: Call<user>, response:
                Response<user>
            ) {
                Log.e("login Successful", map.toString())
                val user = response.body()
                Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@LoginActivity, PatientHome::class.java)
                startActivity(intent)

            }

            override fun onFailure(call: Call<user>, t: Throwable) {
                Log.e("Error", t.message.toString())
                Toast.makeText(this@LoginActivity, "User not found", Toast.LENGTH_SHORT).show()            }


        })
    }

    public fun showForgotPassword(view: View){}

    public fun showRegister(view: View){
        val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
        startActivity(intent)
    }


}