package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 기본 다이얼로그
        binding.btn.setOnClickListener {
            var builder = AlertDialog.Builder(this)
            builder.setTitle("기본 다이얼로그 타이틀")
            builder.setMessage("기본 다이얼로그 메세지")
            builder.setIcon(R.mipmap.ic_launcher)

            // 버튼 클릭시에 무슨 작업을 할 것인가!
            val listener = object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    when (p1) {
                        DialogInterface.BUTTON_POSITIVE ->
                            binding.tvTitle.text = "BUTTON_POSITIVE"
                        DialogInterface.BUTTON_NEUTRAL ->
                            binding.tvTitle.text = "BUTTON_NEUTRAL"
                        DialogInterface.BUTTON_NEGATIVE ->
                            binding.tvTitle.text = "BUTTON_NEGATIVE"
                    }
                }
            }

            builder.setPositiveButton("Positive", listener)
            builder.setNegativeButton("Negative", listener)
            builder.setNeutralButton("Neutral", listener)

            builder.show()
        }

    }
}