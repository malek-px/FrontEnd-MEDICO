package com.example.med11.AcceuilPatient


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.medico.R
import com.example.medico.MainActivity.Companion.Guser
import com.example.medico.Retrofit.MedicoAPI
import com.example.medico.models.user
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.HashMap

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Fragment_profil_patient.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_profil_patient : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var patientname: TextView
    private lateinit var patientage: TextView
    private lateinit var patientAssistantName: String
    private lateinit var patientAssistantNamefield: TextView
    private lateinit var assistantNum: TextView
    private lateinit var patientAddress: TextView
    private lateinit var patientEmNum: TextView
    private lateinit var patientBloodType: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        patientAssistantName = ""
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
        val view = inflater.inflate(R.layout.fragment_profil_patient, container, false)

        val apiInterface = MedicoAPI.create()
        //map usage for the body
        val map: HashMap<String, String> = HashMap()
        map["assistantPhone"] = Guser.assistantPhone
        Log.e("name assistant",map.toString())
        apiInterface.assistantName(map).enqueue(object : Callback<user> {

            override fun onResponse(call: Call<user>, response: Response<user>) {
                val userAssistant = response.body()
                if (userAssistant != null) {
                    Log.e("userAssistant", userAssistant.name)
                    patientAssistantName=userAssistant.name
                    patientAssistantNamefield = view.findViewById(R.id.textView6)
                    patientAssistantNamefield.setText(patientAssistantName)
                }
                Log.e("asssitant name",userAssistant.toString())
            }
            override fun onFailure(call: Call<user>, t: Throwable) {
                Log.e("asssitant name","failed to get assistant name")
            }
        })

        patientname = view.findViewById(R.id.PNAME)
        patientname.setText(Guser.name)
        patientage = view.findViewById(R.id.textView4)
        patientage.setText(Guser.age)

        patientAddress = view.findViewById(R.id.ADDRESS)
        patientAddress.setText(Guser.address)
        patientEmNum = view.findViewById(R.id.textView12)
        patientEmNum.setText(Guser.emergencyNum)
        patientBloodType = view.findViewById(R.id.textView14)
        patientBloodType.setText(Guser.bloodType)

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Fragment_profil_patient.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_profil_patient().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}