package com.example.applemarket

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.applemarket.databinding.DetailBinding
import java.text.NumberFormat
import java.util.Locale

class detail : AppCompatActivity() {
    private lateinit var binding: DetailBinding
    private val dataList: Mydata? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra("data", Mydata::class.java)
        } else {
            intent.getParcelableExtra<Mydata>("data")
        }
    }
    private val dataPosition: Int by lazy { intent.getIntExtra("index", 0) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataList?.img?.let { binding.imgDetailMain.setImageResource(it) }
        binding.tvDetailTitle.text = dataList?.productName
        binding.tvDetailSubtitle.text = dataList?.introduce
        val formatPrice = NumberFormat.getNumberInstance(Locale.getDefault()).format(dataList?.price)
        val priceText = "${formatPrice}원"
        binding.detailPrice.text = priceText
        binding.tvDetailName.text = dataList?.name
        binding.detailAddress.text = dataList?.address
        binding.detailBackBtn.setOnClickListener {
            backToMain()
        }
    }

    private fun backToMain() {
        val intent = Intent()
        setResult(RESULT_OK, intent)
        if (!isFinishing) {
            finish()
        }


    }

    override fun onBackPressed() {
        super.onBackPressed()
        backToMain()
    }
}