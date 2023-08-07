package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    fun doAction(v:View){
        val editTextUsername = findViewById<EditText>(R.id.editText)
        val editTextPassword = findViewById<EditText>(R.id.editText2)

        val username = editTextUsername.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "아이디와 비밀번호를 모두 입력하세요!",Toast.LENGTH_SHORT).show()
        } else{

        Toast.makeText(getApplicationContext(), "자기 소개 페이지로 갈게요!",
        Toast.LENGTH_SHORT).show();
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
    }
    }
    fun doActions(v:View){
        Toast.makeText(getApplicationContext(), "회원가입 하러 가요!",
            Toast.LENGTH_SHORT).show();
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)

    }


}



