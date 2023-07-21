package com.example.calculator
fun main() {
    val calc = Calculator()
    println("1 더하기 2 결과는 : ${calc.addOperation(AddOperation(), 1, 2)} 입니다")

    var num1 = 1
    var num2 = 2

    var operator = '+'

    if (operator == '+') {
        // 덧셈일 때
    } else if (operator == '-') {
        // 뺄셈일 때
    } else if (operator == '*') {
        // 곱셈일 때
    } else if (operator == '/') {
        // 나눗셈일 때
    } else if(operator == '%'){
        // 나머지 연산일 때
    } else {
        // 잘못된 연산자 일 때
    }
}
