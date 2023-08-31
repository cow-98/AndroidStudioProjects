package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class floatingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating)

        val btn2 = findViewById<Button>(R.id.btn)
        btn2.setOnClickListener { doActions(it) }


    }

    fun doActions(v:View){
        val intent2 = Intent(this,MainActivity::class.java)
        finish()
    }

}