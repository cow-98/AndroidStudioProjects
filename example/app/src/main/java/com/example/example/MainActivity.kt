package com.example.example

//fun main() {
//for(i in 5 downTo 1){
//    for(k in 2 ..i ){
//        print(" ")
//    }
//    for(j in 5 downTo i ){
//        print("*")
//    }
//    println("")
//}
//}

//---------------------------------------------------

fun main() {
    val a = readLine()!!.toInt()
    if(a %2 == 0 && a %3 == 0){
        println("2,3의 배수")
    }else if(a %2 == 0){
        println("2의 배수")
    }else if(a %3 == 0){
        println("3의 배수 아님")
     } else{
         println("아무 배수 아님")
    }

}