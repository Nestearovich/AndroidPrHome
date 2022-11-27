package com.example.androidprhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.FragmentTransaction

class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val editText = view.findViewById<EditText>(R.id.editText)
        val editText2 = view.findViewById<EditText>(R.id.editText2)

        btnLogin.setOnClickListener {
            if (editText.text.toString().isEmpty()) {
                editText.error = "login can't be empty"
            } else if (editText2.text.toString().isEmpty()) {
                editText2.error = "password can't be empty"
            } else {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, MainDisplayFragment())
                    .commit()
            }
        }
    }
}