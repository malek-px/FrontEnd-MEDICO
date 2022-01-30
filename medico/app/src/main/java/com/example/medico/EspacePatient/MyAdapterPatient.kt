package com.example.medico.EspacePatient

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.med11.AcceuilPatient.Fragment_profil_patient

class MyAdapterPatient (fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return Fragment_acceuil_patient()

            2->return Fragment_profil_patient()
            else->return Fragment_acceuil_patient()
        }
    }
}