package com.example.deepeningproject.Search

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.deepeningproject.Main.MainActivity

import com.example.deepeningproject.SearchItem
import com.example.deepeningproject.databinding.ItemBinding
import java.text.ParseException
import java.text.SimpleDateFormat


class SearchFragmentAdapter(private val mContext: Context) : RecyclerView.Adapter<SearchFragmentAdapter.ItemViewHolder>() {
    var items = ArrayList<SearchItem>()

    fun clearItem() {
        items.clear()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = items[position]

        Glide.with(mContext)
            .load(currentItem.url)
            .into(holder.item_img)

        holder.item_like.visibility = if (currentItem.islike) View.VISIBLE else View.INVISIBLE
        holder.item_title.text = currentItem.title
        holder.item_time.text = getDateFromTimestampWithFormat(
            currentItem.dateTime,
            "yyyy-mm-dd'T'HH:mm:ss.SSS+09:00",
            "yyyy-MM-dd HH:mm:ss"

        )

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(binding: ItemBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        var item_img: ImageView = binding.itemImg
        var item_like: ImageView = binding.itemImgIslike
        var item_title: TextView = binding.itemTitle
        var item_time: TextView = binding.itemTime
        var item_constlayout: ConstraintLayout = binding.itemConstlayout

        init {
            item_like.visibility = View.GONE
            item_img.setOnClickListener(this)
            item_constlayout.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION } ?: return
            val item = items[position]
            item.islike = !item.islike

            if (item.islike) {
                (mContext as MainActivity) .addLikeItem(item)
            } else {
                (mContext as MainActivity). removeLikeItem(item)
            }
           notifyItemChanged(position)
       }
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



