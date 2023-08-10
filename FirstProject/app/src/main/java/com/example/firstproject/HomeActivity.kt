package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
         val userId = intent.getStringExtra("user_id")
        val textViewUserId = findViewById<TextView>(R.id.textView6)
        textViewUserId.text = "ID: $userId"

        val btn4 = findViewById<Button>(R.id.button4)
        btn4.setOnClickListener{home(it)}
    }

    fun home(v:View) {
        Toast.makeText(
            getApplicationContext(), "로그인 화면으로 돌아갈게요!",
            Toast.LENGTH_SHORT
        ).show();

        finish()
    }
}