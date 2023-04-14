package com.example.app_sem04_s1_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadQuestions()
        setupViews()
    }

    private fun loadQuestions() {
        questions = ArrayList()
        var question = Question("¿Es Lima capital de Perú?", true)
        questions.add(question)

        questions.add(Question("¿Es Lima capital de Chile?", false))
        questions.add(Question("¿Es Tumbes capital de Chile?", false))
        questions.add(Question("¿Es Buenos As capital de Argentina?", true))
        questions.add(Question("¿Es Bogota capital de Colombia?", true))
        questions.add(Question("¿Es Mexico capital de Chile?", false))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)
        val btNext = findViewById<Button>(R.id.btNext)

        tvQuestion.text = questions[position].sentence

        btYes.setOnClickListener {
            if (questions[position].answer == true){
                Toast.makeText(this, "Rpta correcta", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Rpta incorrecta", Toast.LENGTH_LONG).show()
            }
        }

        btNo.setOnClickListener {
            if (!questions[position].answer == true){
                Toast.makeText(this, "Rpta correcta", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "Rpta incorrecta", Toast.LENGTH_LONG).show()
            }
        }

        btNext.setOnClickListener {
            position++
            tvQuestion.text = questions[position].sentence
        }
    }
}