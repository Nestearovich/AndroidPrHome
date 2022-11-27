package com.example.androidprhome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment

class MainDisplayFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_display, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        parentFragmentManager.beginTransaction()


        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Information")
            .setMessage("User is logged in")
            .setPositiveButton("Ok"){dialog, _ ->
                Toast.makeText(requireContext()," your account", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){dialog, _ ->
                Toast.makeText(requireContext()," ", Toast.LENGTH_SHORT).show()
            }
        dialog.show()
    }
}