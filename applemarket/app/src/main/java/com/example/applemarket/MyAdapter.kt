package com.example.applemarket

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityMainBinding
import com.example.applemarket.databinding.ItemBinding
import java.text.NumberFormat
import java.util.Locale

class MyAdapter(val item: MutableList<Mydata>) : RecyclerView.Adapter<MyAdapter.Holder>(){

        interface ItemClick {
            fun onClick(view: View, position: Int)
        }
        var itemClick : ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.Holder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.Holder, position: Int) {

        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
        val currentItem = item[position]
        holder.img.setImageResource(currentItem.img)
        holder.productname.text = currentItem.productName
        holder.address.text = currentItem.address
        val formatPrice = NumberFormat.getNumberInstance(Locale.getDefault()).format(currentItem.price)
        val priceText = "${formatPrice}원"
        holder.price.text = priceText
        holder.likenum.text = currentItem.likeNum.toString()
        holder.chatnum.text = currentItem.chatNum.toString()

    }

    override fun getItemCount(): Int {
            return item.size
    }


    inner class Holder(private val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
       val img = binding.imgSampleItem
        val productname = binding.tvMain
        val address = binding.tvMainTown
        val price = binding.tvMainPrice
        val likenum = binding.tvMainLikeNum
        val chatnum = binding.tvMainChatNum

    }

}

