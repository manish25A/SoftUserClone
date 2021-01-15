package com.manish.softuserclone.Fragments

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.manish.softuserclone.Model.StudentModel
import com.manish.softuserclone.R
import com.manish.softuserclone.UserDataObject.StudentDataObject

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddStudentFragment :Fragment(){
    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var radioMale: RadioButton
    private lateinit var radioFemale: RadioButton
    private lateinit var radioOther: RadioButton
    private lateinit var etImageurl: EditText
    private lateinit var btnAddstdnt: Button
    var usergender=""
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etFullName= view.findViewById(R.id.etFullName)
        etAge = view.findViewById(R.id.etAge)
        etAddress = view.findViewById(R.id.etAddress)
        radioGroup = view.findViewById(R.id.radioGroup)
        radioMale = view.findViewById(R.id.radioMale)
        radioFemale = view.findViewById(R.id.radioFemale)
        radioOther = view.findViewById(R.id.radioOther)
        etImageurl = view.findViewById(R.id.etImageurl)
        btnAddstdnt = view.findViewById(R.id.btnAddstdnt)

        btnAddstdnt.setOnClickListener {

            if(radioGroup.checkedRadioButtonId!=-1){
                if (radioMale.isChecked) {
                    usergender = "Male"
                } else if (radioFemale.isChecked) {
                    usergender = "Female"
                } else if (radioOther.isChecked) {
                    usergender = "other"
                }
            }
            else{
                Toast.makeText(context, "No radio button checked", Toast.LENGTH_SHORT).show()
            }
            StudentDataObject.studentList.add(
                StudentModel(
                    etFullName.text.toString(),
                    etAge.text.toString(),
                    usergender,
                    etAddress.text.toString(),
                    etImageurl.text.toString()

                )
            )
            etFullName.setText("")
            etAge.setText("")
            etAddress.setText("")
            etImageurl.setText("")
            radioMale.isChecked=false
            radioFemale.isChecked=false
            radioOther.isChecked=false

        }
    }
    companion object {
        fun newInstance(param1: String, param2: String) =
            AddStudentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_fragment_add, container, false)


        return view
    }

}



