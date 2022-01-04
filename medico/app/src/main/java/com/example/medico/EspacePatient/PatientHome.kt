package com.example.medico.EspacePatient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.med11.AcceuilAssistant.AssistantTabView.MyAdapterAssistantView
import com.example.medico.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class PatientHome : AppCompatActivity() {
    //tabs
    var tabTitle = arrayOf("Acceuil","Health","Profil")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_patient_home)

        var pager=findViewById<ViewPager2>(R.id.viewpager2_patient)
        var tl =findViewById<TabLayout>(R.id.tabLayout_patient)
        pager.adapter= MyAdapterPatient(supportFragmentManager,lifecycle)

        TabLayoutMediator(tl,pager){
                tab,position->
            tab.text=tabTitle[position]
        }.attach()
    }
}