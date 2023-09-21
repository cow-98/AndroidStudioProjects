package com.example.deepeningproject.Search

import android.content.Context
import android.os.Bundle
import android.util.Log

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.deepeningproject.Data.ImageData
import com.example.deepeningproject.Data.retrofit_client.apiService
import com.example.deepeningproject.SearchItem
import com.example.deepeningproject.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val Auth_header = "KakaoAK d0916c684eb2f8c140d4b791c5bc6da9"
    private var resItems: ArrayList<SearchItem> = ArrayList()
    private lateinit var adapter: SearchFragmentAdapter
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val recyclerView: RecyclerView = binding.RecyclerViewSearch
        adapter = SearchFragmentAdapter(requireContext())
        recyclerView.adapter = adapter

        binding.mainBtnSearch.setOnClickListener {

            val query = binding.mainEtSearch.text.toString()
            searchImage(query)
            Log.d("data", "${resItems}")


        }

        setupView()
        setUpListner()



        return binding.root

    }

    private fun setupView() {
        val gridManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        binding.RecyclerViewSearch.layoutManager = gridManager

        adapter = SearchFragmentAdapter(mContext)
        binding.RecyclerViewSearch.adapter = adapter
        binding.RecyclerViewSearch.itemAnimator = null
    }

    private fun setUpListner() {
        binding.mainBtnSearch.setOnClickListener {
            val query = binding.mainEtSearch.text.toString()
            if (query.isNotEmpty()) {
                saveLastSearch(requireContext(), query)
                adapter.clearItem()
                searchImage(query)
            } else {
                Toast.makeText(mContext, "검색어를 입력해 주세요", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun saveLastSearch(context: Context, query: String) {
        val pref = context.getSharedPreferences("pref", 0)
        val edit = pref.edit()
        edit.putString("title", binding.mainEtSearch.text.toString())
        edit.apply()
    }

    private fun getLastSearch(context: Context): String? {
        val pref = context.getSharedPreferences("pref", 0)
        binding.mainEtSearch.setText(pref.getString("name", ""))
        return String()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {


    }

    private fun searchImage(query: String) {
        apiService.image_search(Auth_header, query, sort = "recency", page = 1, size = 80)
            ?.enqueue(object : Callback<ImageData?> {
                override fun onResponse(call: Call<ImageData?>, response: Response<ImageData?>) {
//                    if (response.isSuccessful) {
                        response.body()?.meta?.let { meta ->
                            if (meta.totalCount > 0) {
                                response.body()!!.documents.forEach { document ->
                                    val title = document.displaySitename
                                    val datetime = document.datetime
                                    val url = document.thumbnailUrl
                                    resItems.add(SearchItem(title, datetime, url))

                                }
                            }

                        }

                    adapter.items = resItems
                    adapter.notifyDataSetChanged()
                    Log.d("get", "${response.body()}")
                }


                override fun onFailure(call: Call<ImageData?>, t: Throwable) {

                }

            })
    }

}





