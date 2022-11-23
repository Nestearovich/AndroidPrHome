package com.example.androidprhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rbtn = findViewById<RadioButton>(R.id.rbtn1)
        val rbtn2 = findViewById<RadioButton>(R.id.rbtn2)

        rbtn.setOnClickListener {
            if (rbtn.isChecked) {
                rbtn2.isChecked = false
            }
        }
        rbtn2.setOnClickListener {
            if (rbtn2.isChecked) {
                rbtn.isChecked = false
            }
        }
    }
}
