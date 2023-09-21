package com.example.deepeningproject.Box

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deepeningproject.Search.SearchFragmentAdapter
import com.example.deepeningproject.SearchItem
import com.example.deepeningproject.databinding.FragmentSearchBinding
import com.example.deepeningproject.databinding.ItemBinding
import java.text.ParseException
import java.text.SimpleDateFormat

class MyBoxAdapter(var mContext: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items = mutableListOf<SearchItem>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)

    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Glide.with(mContext)
            .load(items[position].url)
            .into((holder as ItemViewHolder).item_img)

        holder.item_title.text = items[position].title
        holder.item_like.visibility = View.GONE
        holder.item_time.text =
            getDateFromTimestampWithFormat(
                items[position].dateTime,
                "yyyy-MM-dd'T'HH:mm:ss.SSS+09:00",
                "yyyy-MM-dd HH:mm:ss"
            )

    }


    override fun getItemCount(): Int {
        return items.size

    }


    inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var item_img: ImageView = binding.itemImg
        var item_like: ImageView = binding.itemImgIslike
        var item_title: TextView = binding.itemTitle
        var item_time: TextView = binding.itemTime
        var item_constlayout: ConstraintLayout = binding.itemConstlayout



    }


    fun getDateFromTimestampWithFormat (
        timestamp: String?,
        fromFormatformat: String?,
        toFormatformat: String?
    ): String {
        var date: java.util.Date? = null
        var res = ""
        try{
            if(timestamp != null) {
                val format = SimpleDateFormat(fromFormatformat)
                date = format.parse(timestamp)
            }
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val df = SimpleDateFormat(toFormatformat)
        if (date != null) {
            res = df.format(date)
        }
        return res
    }


}