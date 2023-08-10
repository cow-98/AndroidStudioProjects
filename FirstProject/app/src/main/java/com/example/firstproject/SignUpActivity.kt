package com.example.firstproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup)


        val btn3 = findViewById<Button>(R.id.button3)
        btn3.setOnClickListener{membership(it)}
    }


    fun membership(v: View) {
        val editTextName = findViewById<EditText>(R.id.editText3)
        val editTextUsername = findViewById<EditText>(R.id.editText4)
        val editTextPassword = findViewById<EditText>(R.id.editText5)

        val name = editTextName.text.toString().trim()
        val username = editTextUsername.text.toString().trim()
        val password = editTextPassword.text.toString().trim()

        if (name.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "입력되지 않은 정보가 있어요!", Toast.LENGTH_SHORT).show()
        } else {

            val intentSignUp = Intent()
            intentSignUp.putExtra("id", username)
            intentSignUp.putExtra("password", password)
            setResult(Activity.RESULT_OK, intentSignUp)

            Toast.makeText(
                getApplicationContext(), "회원가입 성공!",
                Toast.LENGTH_SHORT
            ).show();
            finish()
        }
    }
}


