package com.example.basicsyntax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var now = 10
        when (now) {
            8 -> {
                Log.d("when", "혀재 시간은 8시 입니다.")
            }

            9 -> {
                Log.d("when", "현재 시간은 9시 입니다.")
            }

            else -> {
                Log.d("when", "현재 시간은 9시가 아닙니다.")
                }
             }
        }
    }