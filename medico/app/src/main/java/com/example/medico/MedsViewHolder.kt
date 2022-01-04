package com.example.medico

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MedsViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
    val medPic : ImageView
    val medName : TextView
    val medFreq : TextView =itemView.findViewById<TextView>(R.id.med_frequency_acceuil_patient)
    val medDesc : TextView = itemView.findViewById<TextView>(R.id.med_desc_acceuil_patient)

    init {
        medPic = itemView.findViewById<ImageView>(R.id.med_pic_acceuil_patient)
        medName = itemView.findViewById<TextView>(R.id.med_name_acceuil_patient)
    }
}