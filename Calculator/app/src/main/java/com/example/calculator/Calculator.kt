package com.example.calculator

class Calculator {
    fun addOperation(operation: AddOperation, num1:Int, num2: Int): Double{
        return operation.operate(num1, num2)
    }

}