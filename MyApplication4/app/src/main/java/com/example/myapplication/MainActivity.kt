package com.example.myapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.text.TextUtils.replace
import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var initTime = 0L
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            binding.chronometer.base = SystemClock.elapsedRealtime() +pauseTime
            binding.chronometer.start()
            binding.btnStart.isEnabled = false
            binding.btnReset.isEnabled = true
            binding.btnStop.isEnabled = true
        }

        binding.btnStop.setOnClickListener {
            pauseTime = binding.chronometer.base -SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.btnStart.isEnabled = true
            binding.btnReset.isEnabled = true
            binding.btnStop.isEnabled = false
        }

        binding.btnReset.setOnClickListener {
            pauseTime = 0L
            binding.chronometer.base = SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.btnStart.isEnabled = true
            binding.btnReset.isEnabled = false
            binding.btnStop.isEnabled = true
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode === KeyEvent.KEYCODE_BACK){
            if (System.currentTimeMillis() - initTime > 3000) {
                Toast.makeText(this,"한번 더",Toast.LENGTH_SHORT).show()
                initTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}