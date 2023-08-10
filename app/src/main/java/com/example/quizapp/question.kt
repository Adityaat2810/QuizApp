package com.example.quizapp

data class question(
    val id:Int,
    val questions:String,
    val image:Int,
    val OptionOne:String,
    val OptionTwo:String,
    val OptionThree:String,
    val OptionFour:String,
    val correctAnswer:Int
)
