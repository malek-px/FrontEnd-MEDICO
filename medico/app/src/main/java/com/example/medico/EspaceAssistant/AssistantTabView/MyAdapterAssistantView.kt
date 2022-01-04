package com.example.med11.AcceuilAssistant.AssistantTabView

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter


class MyAdapterAssistantView(fragmentManager: FragmentManager, lifecycle: Lifecycle):
    FragmentStateAdapter(fragmentManager,lifecycle) {
    override fun getItemCount(): Int {
        return 2    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return Health_view()
            1->return Medication_view()
            else->return Health_view()
        }    }
}