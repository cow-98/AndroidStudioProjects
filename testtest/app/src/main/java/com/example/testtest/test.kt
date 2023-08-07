package com.example.testtest
fun main() {
    var num1 = 20
    var num2 = 30.2

    var num3 = num2.toInt()
    var num4 = num1.toDouble()

    var strNum5 = "10"
    var strNum6 = "10.21"

    var num5 = Integer.parseInt(strNum5)
    var num6 = strNum6.toDouble()

    println("num3: $num3")
    println("num4: $num4")
    println("num5: $num5")
    println("num6: $num6")
}