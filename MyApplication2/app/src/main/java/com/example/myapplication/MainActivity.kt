package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var fab: FloatingActionButton
    private lateinit var fabSub1: FloatingActionButton
    private lateinit var fabSub2: FloatingActionButton

    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fab = findViewById(R.id.fab)
        fabSub1 = findViewById(R.id.fab_sub1)
        fabSub2 = findViewById(R.id.fab_sub2)

        fab.setOnClickListener {
            toggleSubButtons()
        }

        fabSub1.setOnClickListener {
            // 서브 버튼 1 클릭 시 동작을 여기에 추가
        }

        fabSub2.setOnClickListener {
            // 서브 버튼 2 클릭 시 동작을 여기에 추가
        }
    }

    private fun toggleSubButtons() {
        isExpanded = !isExpanded
        if (isExpanded) {
            fabSub1.visibility = View.VISIBLE
            fabSub2.visibility = View.VISIBLE
        } else {
            fabSub1.visibility = View.GONE
            fabSub2.visibility = View.GONE
        }
    }
}