package com.example.androidprhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<TextInputLayout>(R.id.name)
        val password = findViewById<TextInputLayout>(R.id.password)

        val editName = findViewById<TextInputEditText>(R.id.et_text)
        val editPassword = findViewById<TextInputEditText>(R.id.et_text2)

        val btn = findViewById<Button>(R.id.btnAccept)

        val dialog = AlertDialog.Builder(this)
            .setTitle(getString(R.string.info))
            .setCancelable(false)
            .setPositiveButton(getString(R.string.btn_pos)) { dialog, _ ->
                Toast.makeText(this, getString(R.string.pos_message), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton(getString(R.string.btn_negative)) { dialog, _ ->
                dialog.cancel()
            }
        btn.setOnClickListener {
            if (editName.text.toString().isEmpty()) {
                name.setErrorIconDrawable(R.drawable.icon)
                editName.error = getString(R.string.errorName)
            } else if (editPassword.text.toString().isEmpty()) {
                editPassword.error = getString(R.string.errorPassword)
            } else
                dialog.setMessage("Name: " + editName.text.toString()
                        + "\nPassword: " + editPassword.text.toString()).show()
        }
    }
    }

