package com.example.deepeningproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.deepeningproject.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.navigationView.setOnItemSelectedListener {
            changeFragment(it.itemId)
            true
        }
        changeFragment(R.id.navi_home)

    }

    private fun changeFragment(menuItemId: Int) {
        val targetFragment = getFragment(menuItemId)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frame, targetFragment)
            .commitAllowingStateLoss()
    }

    private fun getFragment(menuItemId: Int): Fragment {
        val fragment: Fragment
        when (menuItemId) {
            R.id.navi_home -> {
                val title = "home"
                val param2Value = "some_value"
                fragment = SearchFragment.newInstance(title, param2Value)
            }

            R.id.navi_inbox -> {
                fragment = MyBoxFragment()
            }

            else -> throw IllegalArgumentException("not found item id")
        }

        return fragment
    }

    companion object {
        fun newInstance(title: String, param2: String): SearchFragment {
            val args = Bundle()
            args.putString("title", title)
            args.putString("param2", param2)
            val fragment = SearchFragment()
            fragment.arguments = args
            return fragment
        }
    }
}

