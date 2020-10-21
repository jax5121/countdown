package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnNumbersRound : Button = findViewById(R.id.btnNumbersRound)
        val btnLettersRound : Button = findViewById(R.id.btnLettersRound)
        val btnConundrumRound : Button = findViewById(R.id.btnConundrumRound)

        btnLettersRound.setOnClickListener {
            val intent = Intent(this, LettersRound :: class.java)
            startActivity(intent)
        }

        btnNumbersRound.setOnClickListener {
            val intent = Intent(this, NumbersRound :: class.java)
            startActivity(intent)
        }

        btnConundrumRound.setOnClickListener {
            val intent = Intent(this, ConundrumRound :: class.java)
            startActivity(intent)
        }
    }


}