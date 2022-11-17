package com.example.androidprhome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.androidprhome.MainActivity2.Companion.refactorMainActivityToolBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Activity"
    }
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        val inflater = menuInflater
        inflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.goActivity2 ->MainActivity2.startActivity2(
                this,
                getString(R.string.str_1),
                getString(R.string.str_2)
            )
            R.id.sendText -> refactorMainActivityToolBar(
                this,
                getString(R.string.second_item)
            )
            R.id.goBack ->onBackPressed()
            R.id.close -> finishAffinity()

        }
        return super.onOptionsItemSelected(item)
    }
}