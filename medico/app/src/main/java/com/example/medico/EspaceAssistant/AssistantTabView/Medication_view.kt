package com.example.med11.AcceuilAssistant.AssistantTabView

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.medico.Medication
import com.example.medico.MedsAdapter
import com.example.medico.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Medication_view.newInstance] factory method to
 * create an instance of this fragment.
 */
class Medication_view : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //initialisation des variables
    lateinit var recylcerMedication: RecyclerView
    lateinit var recylcerMedicationAdapter: MedsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // val view=inflater.inflate(R.layout.fragment_medication_view, container, false)
        // Inflate the layout for this fragment

        //declaration des elements
       // recylcerMedication =view.findViewById(R.id.assistant_view_recyclerView_meds)

        var MedsList : MutableList<Medication> = ArrayList()

        MedsList.add(Medication(medPic = R.drawable.pills_bottle_1, medName = "Medicine 1", medDesc = "Blood pressure",medFreq = "1 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.tablet_1, medName = "Medicine 2", medDesc = "Blood pressure",medFreq = "3 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.pills_bottle_1, medName = "Medicine 3", medDesc = "Blood pressure",medFreq = "1 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.tablet_1, medName = "Medicine 4", medDesc = "Blood pressure",medFreq = "3 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.pills_bottle_1, medName = "Medicine 5", medDesc = "Blood pressure",medFreq = "1 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.tablet_1, medName = "Medicine 6", medDesc = "Blood pressure",medFreq = "3 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.pills_bottle_1, medName = "Medicine 7", medDesc = "Blood pressure",medFreq = "1 pill/day" ))
        MedsList.add(Medication(medPic = R.drawable.tablet_1, medName = "Medicine 8", medDesc = "Blood pressure",medFreq = "3 pill/day" ))

        recylcerMedicationAdapter = MedsAdapter(MedsList)

        recylcerMedication.adapter = recylcerMedicationAdapter

        recylcerMedication.layoutManager = LinearLayoutManager(container?.context, LinearLayoutManager.VERTICAL ,false)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Medication_view.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Medication_view().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}