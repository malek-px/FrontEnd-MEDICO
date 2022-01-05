package com.example.medico

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MedsAdapter (val MedicationList: MutableList<Medication>): RecyclerView.Adapter<MedsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_meds_patient, parent, false)

        return MedsViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedsViewHolder, position: Int) {
        val name = MedicationList[position].medName
        val desc = MedicationList[position].medDesc
        val freq = MedicationList[position].medFreq

        holder.medPic.setImageResource(MedicationList[position].medPic)
        holder.medName.text = name
        holder.medDesc.text = desc
        holder.medFreq.text = freq

    }

    override fun getItemCount()= MedicationList.size

}
