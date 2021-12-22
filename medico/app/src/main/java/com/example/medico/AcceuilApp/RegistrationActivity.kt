package com.example.medico.AcceuilApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.medico.EspaceAssistant.AssistantHome
import com.example.medico.EspacePatient.PatientHome
import com.example.medico.R

class RegistrationActivity : AppCompatActivity() {

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
        if (visible_int == 0){
            val intent = Intent(this@RegistrationActivity, AssistantHome::class.java)
            startActivity(intent)
        }
        else{
            val intent = Intent(this@RegistrationActivity, PatientHome::class.java)
            startActivity(intent)
        }

    }
}