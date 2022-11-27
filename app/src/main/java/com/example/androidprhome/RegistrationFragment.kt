package com.example.androidprhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val registrationAccount = view.findViewById<Button>(R.id.btn_reg)
        val editText = view.findViewById<EditText>(R.id.editText)
        val editText2 = view.findViewById<EditText>(R.id.editText2)
        val editText3 = view.findViewById<EditText>(R.id.editText3)
        val eMail = view.findViewById<EditText>(R.id.email)



        registrationAccount.setOnClickListener {
            if (editText.text.toString().isEmpty()){
                editText.error = "login can't be empty"
            }else if(editText2.text.toString().isEmpty()){
                editText2.error = "password can't be empty"
            }else if (editText3.text.toString().isEmpty()){
                editText3.error = "password entered is incorrect"
            }else if (eMail.text.toString().isEmpty()){
                eMail.error = " email can't be empty"
            }
            parentFragmentManager.beginTransaction()
                .replace(R.id.container,LoginFragment())
                .addToBackStack("back")
                .commit()
        }

    }

}
