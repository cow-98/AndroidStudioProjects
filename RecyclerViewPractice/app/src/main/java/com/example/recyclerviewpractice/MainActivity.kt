package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        val Myadapter = MyAdapter // 데이터리스트를 실제 데이터로 교체
        binding.recyclerView.adapter = Myadapter

        val decoration = StickyHeaderItemDecoration(adapter)
        binding.recyclerView.addItemDecoration(decoration)

        val dataList = mutableListOf(
            DogItems.MyTitle("1"),
            DogItems.MyItem(R.drawable.sample_3, "Duke", "1"),
            DogItems.MyItem(R.drawable.sample_6, "Luna", "1"),
            DogItems.MyItem(R.drawable.sample_8, "Merry", "1"),
            DogItems.MyItem(R.drawable.sample_13, "mung", "1"),
            DogItems.MyTitle("2"),
            DogItems.MyItem(R.drawable.sample_1, "Charlie", "2"),
            DogItems.MyItem(R.drawable.sample_4, "Max", "2"),
            DogItems.MyItem(R.drawable.sample_7, "Bob", "2"),
            DogItems.MyItem(R.drawable.sample_11, "Sara", "2"),
            DogItems.MyItem(R.drawable.sample_10, "ganga", "2"),
            DogItems.MyTitle("3"),
            DogItems.MyItem(R.drawable.sample_5, "Happy", "3"),
            DogItems.MyItem(R.drawable.sample_0, "Bella", "3"),
            DogItems.MyTitle("4"),
            DogItems.MyItem(R.drawable.sample_2, "Daisy", "4"),
            DogItems.MyItem(R.drawable.sample_9, "Jisoo", "4"),
            DogItems.MyItem(R.drawable.sample_12, "Ddong", "4")
        )

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = (dataList[position] as DogItems.MyItem).aName
                Toast.makeText(this@MainActivity, " $name 선택!", Toast.LENGTH_SHORT).show()
            }

        }

    }

}