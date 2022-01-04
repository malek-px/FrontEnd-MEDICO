package com.example.medico.AcceuilApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.medico.EspaceAssistant.AssistantHome
import com.example.medico.EspacePatient.PatientHome
import com.example.medico.R
import com.example.medico.Retrofit.MedicoAPI
import com.example.medico.models.user
import com.google.android.material.textfield.TextInputLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistrationActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var visible: Switch

    lateinit var assistant_phone : EditText
    lateinit var assistant_phone_txt : TextView
    lateinit var emergency_num : EditText
    lateinit var emergency_num_txt : TextView
    lateinit var blood_type : Spinner
    lateinit var blood_type_txt : TextView

    var visible_int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        visible = findViewById<View>(R.id.switch1) as Switch
        assistant_phone=findViewById(R.id.assistant_phone)
        assistant_phone_txt=findViewById(R.id.assistant_phone_txt)
        emergency_num=findViewById(R.id.emergency_num)
        emergency_num_txt=findViewById(R.id.emergency_num_txt)
        blood_type=findViewById(R.id.blood_type_spinner)
        blood_type_txt=findViewById(R.id.blood_type_txt)

        //spinner configuration
        // Create an ArrayAdapter using the string array and a default spinner layout
       ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            blood_type.adapter = adapter
        }


        //switch visible
        visible!!.setOnCheckedChangeListener { buttonView, isChecked ->
            visible_int = if (isChecked) {
                blood_type.setVisibility(View.VISIBLE)
                blood_type_txt.setVisibility(View.VISIBLE)
                assistant_phone.setVisibility(View.VISIBLE)
                assistant_phone_txt.setVisibility(View.VISIBLE)
                emergency_num.setVisibility(View.VISIBLE)
                emergency_num_txt.setVisibility(View.VISIBLE)
                1
            } else {
                blood_type.setVisibility(View.INVISIBLE)
                blood_type_txt.setVisibility(View.INVISIBLE)
                assistant_phone.setVisibility(View.INVISIBLE)
                assistant_phone_txt.setVisibility(View.INVISIBLE)
                emergency_num.setVisibility(View.INVISIBLE)
                emergency_num_txt.setVisibility(View.INVISIBLE)
                0
            }
        }


    }
    public fun Register(view: View){

        val confirmpassword :String =findViewById<EditText>(R.id.confirm_password).toString()
        //creation of retrofit object
        val apiInterface = MedicoAPI.create()

        val bloodTypeSpinner: Spinner = findViewById(R.id.blood_type_spinner)

        //input reading
        val name =findViewById<EditText>(R.id.username).text.toString()
        val email =findViewById<EditText>(R.id.email).text.toString()
        val password =findViewById<EditText>(R.id.password).text.toString()
        val address =findViewById<EditText>(R.id.adresse).text.toString()
        val phone =findViewById<EditText>(R.id.phone).text.toString()
        val assistantPhone =findViewById<EditText>(R.id.assistant_phone).text.toString()
        val emergencyNum =findViewById<EditText>(R.id.emergency_num).text.toString()
        val bloodType=bloodTypeSpinner.getItemAtPosition(bloodTypeSpinner.selectedItemPosition).toString()

        var valide :Boolean = ConfirmPassValidate()
        Log.e("debut",valide.toString())

        if(valide){
Log.e("debut","confirmed")
        //user infos holder

        if (visible_int == 0){
            var userInfos = user(isAssistant = true,assistantName = "",name =name,email = email,password = password,address = address,phone = phone,assistantPhone = "",emergencyNum = "",bloodType = "")

            apiInterface.SignUp(userInfos).enqueue(object : Callback<user> {
                override fun onResponse(
                    call: Call<user>, response:
                    Response<user>
                ) {
                    Log.e("Assistant addded", userInfos.toString())

                    val intent = Intent(this@RegistrationActivity, AssistantHome::class.java)
                    startActivity(intent)

                }

                override fun onFailure(call: Call<user>, t: Throwable) {
                    Log.e("Error", t.message.toString())
                    Toast.makeText(this@RegistrationActivity, "User could not be added", Toast.LENGTH_SHORT).show()            }
            })

        }
        else{

            var userInfos = user(isAssistant = false,assistantName = "",name =name,email = email,password = password,address = address,phone = phone,assistantPhone = assistantPhone,emergencyNum = emergencyNum,bloodType =bloodType)

            apiInterface.SignUp(userInfos).enqueue(object : Callback<user> {
                override fun onResponse(
                    call: Call<user>, response:
                    Response<user>
                ) {
                    Log.e("Patient addded", userInfos.toString())

                    val intent = Intent(this@RegistrationActivity, PatientHome::class.java)
                    startActivity(intent)

                }

                override fun onFailure(call: Call<user>, t: Throwable) {
                    Log.e("Error", t.message.toString())
                    Toast.makeText(this@RegistrationActivity, "User could not be added", Toast.LENGTH_SHORT).show()            }


            })

        }
            Log.e("fin","confirmed")
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    private fun ConfirmPassValidate(): Boolean {
        val confirmPasswordContainer = findViewById<TextInputLayout>(R.id.confirmPasswordContainer)
        val confirmPasswordText = findViewById<EditText>(R.id.confirm_password).text.toString()
        val passwordText = findViewById<EditText>(R.id.password).text.toString()
        if (confirmPasswordText.isEmpty()) {
            confirmPasswordContainer.helperText = "Required"
            return false
        }
        else if (confirmPasswordText != passwordText) {
            confirmPasswordContainer.helperText = "Passwords does not match"
            return false
        }
        return true
    }
}
