package com.example.deepeningproject.Box

import android.content.ClipData.Item
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.deepeningproject.Main.MainActivity
import com.example.deepeningproject.R
import com.example.deepeningproject.Search.SearchFragmentAdapter
import com.example.deepeningproject.SearchItem
import com.example.deepeningproject.databinding.FragmentMyBoxBinding



class MyBoxFragment : Fragment() {
    private var _binding: FragmentMyBoxBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: MyBoxAdapter
    private lateinit var mContext: Context

    private var likeItem: List<SearchItem> = listOf()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyBoxBinding. inflate(inflater, container, false)
       val MainActivity = activity as MainActivity
        likeItem = MainActivity.likeItem


        adapter = MyBoxAdapter(mContext).apply {
            items = likeItem.toMutableList()
        }

        val binding = FragmentMyBoxBinding.inflate(inflater, container, false).apply {
            RecyclerViewInbox.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            RecyclerViewInbox.adapter = adapter
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

    }
}