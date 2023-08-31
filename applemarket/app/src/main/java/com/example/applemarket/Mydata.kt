package com.example.applemarket

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mydata(
    val img: Int,
    val productName: String,
    val introduce: String,
    val name: String,
    val price: Int,
    val address: String,
    val likeNum: Int,
    val chatNum: Int,
    // 데이터 자료형
)  : Parcelable
