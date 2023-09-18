package com.example.recyclerviewpractice

sealed class DogItems {
    data class MyItem(val aIcon:Int, val aName:String, val aAge:String) : DogItems()
    data class MyTitle(val age: String) : DogItems()
}