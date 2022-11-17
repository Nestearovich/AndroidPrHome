package com.example.androidprhome

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.system.Os.close
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.security.Key

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Activity 2"

        val firstTextView = findViewById<TextView>(R.id.text1)
        val data = intent.getStringExtra(KEY_1) ?: getString(R.string.no_data)
        firstTextView.text = data
        val secondTextView = findViewById<TextView>(R.id.text2)
        val data2 = intent.getStringExtra(KEY_2) ?: getString(R.string.no_data)
        secondTextView.text = data2
        val data3: String = intent.getStringExtra(KEY_3) ?: getString(R.string.HW2)
        supportActionBar?.title = data3

    }


    companion object {
        private const val KEY_1 = "1"
        private const val KEY_2 = "2"
        private const val KEY_3 = "3"

        fun startActivity2(context: Context, firstView: String, SecondView: String) {
            val intent = Intent(context, MainActivity2::class.java)
            intent.putExtra(KEY_1, firstView)
            intent.putExtra(KEY_2, SecondView)
            context.startActivity(intent)

        }
        fun refactorMainActivityToolBar(context: Context,string: String){
            val intent = Intent(context,MainActivity2::class.java)
            intent.putExtra(KEY_3,string)
            context.startActivity(intent)
    }
}

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> onBackPressed()
            R.id.close ->finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }
    }
