package com.example.firstproject

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etu = findViewById<EditText>(R.id.editText)

        val etu2 = findViewById<EditText>(R.id.editText2)

        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data = result.data
                    val id = data?.getStringExtra("id") ?: ""
                    val password = data?.getStringExtra("password") ?: ""
                    etu.setText(id)
                    etu2.setText(password)
                }
            }


        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener { doAction(it) }

        val btn2 = findViewById<Button>(R.id.button2)
        btn2.setOnClickListener { doActions(it) }


    }


    fun doAction(v: View) {
        val editTextUsername = findViewById<EditText>(R.id.editText)
        val editTextPassword = findViewById<EditText>(R.id.editText2)

        val username = editTextUsername.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "아이디와 비밀번호를 모두 입력하세요!", Toast.LENGTH_SHORT).show()
        } else {

            Toast.makeText(
                getApplicationContext(), "자기 소개 페이지로 갈게요!",
                Toast.LENGTH_SHORT
            ).show();
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("user_id", username)
            startActivity(intent)

        }
    }

    fun doActions(v: View) {
        Toast.makeText(
            getApplicationContext(), "회원가입 하러 가요!",
            Toast.LENGTH_SHORT
        ).show();
        val intent = Intent(this, SignUpActivity::class.java)
        resultLauncher.launch(intent)

    }
}



