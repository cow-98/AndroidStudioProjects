package com.example.deepeningproject.Search

import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.deepeningproject.Data.ImageData
import com.example.deepeningproject.Data.retrofit_client.apiService
import com.example.deepeningproject.databinding.FragmentSearchBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query


class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val Auth_header = "kakaoAK d0916c684eb2f8c140d4b791c5bc6da9"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
       binding.mainBtnSearch.setOnClickListener {
           val query = binding.mainEtSearch.text.toString()
           searchImage(query)
       }

        return binding.root



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {


    }
    private fun searchImage (query: String){
        apiService.image_search(Auth_header, query, sort = "recency", page = 1, size = 80)?.enqueue(object: Callback<ImageData?> {
            override fun onResponse(call: Call<ImageData?>, response: Response<ImageData?>) {
                response.body()?.meta?.let { meta ->
                    if (meta.totalCount > 0){
                        response.body()!!.documents.forEach{ document ->
                            val title = document.displaySitename
                            val datetime = document.datetime
                            val url = document.thumbnailUrl


                            //리스트에 저장 후 어댑터에 보내서 뿌린다)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<ImageData?>, t: Throwable) {

            }

        })
    }

    val dataList = ArrayList<ImageData>()
}