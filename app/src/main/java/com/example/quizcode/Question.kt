package com.example.quizcode

data class Question(
    val question: String,
    val options: List<String>,
    val correctAnswer: String,
)
