package com.example.medico.AcceuilApp

import android.app.PendingIntent.getActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.medico.EspaceAssistant.AssistantHome
import com.example.medico.EspacePatient.PatientHome
import com.example.medico.R
import com.example.medico.Retrofit.MedicoAPI
import com.example.medico.Retrofit.Retrofit
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var email :String
lateinit var password : String

class LoginActivity : AppCompatActivity() {
    lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin=findViewById(R.id.login)
        email= findViewById<EditText>(R.id.email).toString()
        password= findViewById<EditText>(R.id.password).toString()

    }

    public fun Login(view: View){
        val paramObject1 = JSONObject()
        paramObject1.put("username",email.trim())//1)par rapport eli 3andi fl user2)part rapport eli 3andi fl txt fl application
        paramObject1.put("password", password.trim())
        val jsonParser = JsonParser()
        var gsonObject1 = jsonParser.parse(paramObject1.toString()) as JsonObject
        val retro = Retrofit().getRetroClinetInstance().create(MedicoAPI::class.java)
        retro.login(gsonObject1).enqueue(object : Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                if(response.code()==200) {
                    val user = response.body()?.get("username").toString()
                    val username=user.substring(1,user.length-1)
                    Log.e("Erooooorr",username)
                    Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@LoginActivity, PatientHome::class.java)
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("Error", t.message.toString())
                Toast.makeText(this@LoginActivity, "User not found", Toast.LENGTH_SHORT).show()
            }
        })
    }

    public fun showForgotPassword(view: View){}

    public fun showRegister(view: View){
        val intent = Intent(this@LoginActivity, RegistrationActivity::class.java)
        startActivity(intent)
    }


}