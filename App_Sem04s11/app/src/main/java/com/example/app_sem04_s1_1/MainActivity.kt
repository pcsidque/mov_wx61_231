package com.example.app_sem04_s1_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

//creo una constante
const val EXTRA_MESS = "com.example.app_sem04_s1_1"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View){
        val editText = findViewById<EditText>(R.id.etName)
        val message = editText.text.toString()

        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESS, message)
        }
        startActivity(intent)
        }
}