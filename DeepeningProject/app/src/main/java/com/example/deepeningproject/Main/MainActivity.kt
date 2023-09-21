package com.example.deepeningproject.Main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.deepeningproject.Box.MyBoxFragment
import com.example.deepeningproject.R
import com.example.deepeningproject.Search.SearchFragment
import com.example.deepeningproject.SearchItem
import com.example.deepeningproject.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var likeItem: ArrayList<SearchItem> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navi_home -> {
                    displayFragment(SearchFragment())
                }

                R.id.navi_inbox -> {
                    displayFragment(MyBoxFragment())
                }
            }
            true
        }
        binding.navigationView.selectedItemId = R.id.navi_home // 첫 화면

    }
    private fun displayFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.mainFrame.id, fragment)
            .commit()
    }

     fun addLikeItem(item: SearchItem) {
        if(!likeItem.contains(item)) {
            likeItem.add(item)
        }
    }

    fun removeLikeItem(item: SearchItem) {
        likeItem.remove(item)
    }
}
