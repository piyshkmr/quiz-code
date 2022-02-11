package com.example.quizcode

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

//    getting the score from intent
        val score = intent.getIntExtra("Score", 0)

        setMessage(score)

        val scoreOutOf100 = "$score/100"

//        setting the score to text view
        tvScore.text = scoreOutOf100

        giveStars(score)

//        adding on click listener to play again
        btnPlayAgain.setOnClickListener {
            Intent(this, GameActivity::class.java).apply {
                startActivity(this)
            }
        }

    }


//takes the score and set a message in text View according to user score
    private fun setMessage(score: Int) {
        var message = ""

        when {
            score < 20 -> {
                message = "Oopps! You Have to Learn More About Programming"
            }
            score in 20..50 -> {
                message = "Nice Try But Need Some Improvement!"
            }
            score in 51..70 -> {
                message = "Very Nice My Friend Keep Learning!"
            }
            score in 71..90 -> {
                message = "Awesome! You are Intelligent My Friend"
            }
            score > 90 -> {
                message = "Supperb!🎈 Excellent! My Friend You Are A Genuies"
            }
        }

        tvMessage.text = message
    }

//    according to user score adding starts image views to linearlayout
    private fun giveStars(score: Int) {
        val noOfStars = (score / 10) / 2
        for (i in 1..noOfStars) {
            Stars.addView(LayoutInflater.from(this).inflate(R.layout.star, Stars, false))
        }
    }

}