package com.example.deepeningproject.Data


import android.provider.SyncStateContract.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofit_client {

   private val BASE_URL = "https://dapi.kakao.com"
    val apiService: INetworkService
        get() = instance.create(INetworkService::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
}

