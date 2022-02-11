package com.example.quizcode

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    //    global variables
    private var index = 0
    private var score = 0
    private var pressedTime = 0L

    private lateinit var questionList: MutableList<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

//        questions array list
        questionList = mutableListOf()

//        adding questions to list
        questionList.add(Question(
            "Kotlin is developed by?",
            listOf("Google", "JetBrains", "Microsoft", "Adobe"),
            "JetBrains"))

        questionList.add(Question(
            "Which of following is used to handle null exceptions in Kotlin?",
            listOf("Range", "Sealed Class", "Elvis Operator", "Lambda function"),
            "Elvis Operator"))

        questionList.add(Question(
            "Which file extension is used to save Kotlin files.",
            listOf(".java", ".kot", ".kt or .kts", ".android"),
            ".kt or .kts"))

        questionList.add(Question(
            "All classes in Kotlin classes are by default?",
            listOf("public", "final", "sealed", "abstract"),
            "final"))

        questionList.add(Question(
            "What is correct way to create an arraylist in Kotlin?",
            listOf("val map = hashMapOf(1 to \"one\", 2 to \"two\", 3 to \"three\")",
                "enum class Color {RED, GREEN, BLUE}",
                " val list = arrayListOf(1, 2, 3)",
                "val set = hashSetOf(1, 2, 3)"),
            " val list = arrayListOf(1, 2, 3)"))

        questionList.add(Question(
            "What is an immutable variable?",
            listOf("A variable that cannot change, read-only",
                "A variable that can be changed",
                "A variable used for string interpolation",
                "None of these"),
            "A variable that cannot change, read-only"))

        questionList.add(Question(
            "Which of the followings constructors are available in Kotlin?",
            listOf("Primary constructor",
                "Secondary constructor",
                "Both 1 & 2",
                "None of the above"),
            "Both 1 & 2"))

        questionList.add(Question(
            "Which of the following extension methods are used in Kotlin?",
            listOf("Read texts () & Headlines ()",
                "Buffer reader ()",
                "Read each line ()",
                "All of the above"),
            "All of the above"))

        questionList.add(Question(
            "There are two types of constructors in Kotlin which are",
            listOf(" Primary & Secondary constructor",
                "Default & No-arg constructor",
                "Parameterized & constant Constructor",
                "None of the above"),
            " Primary & Secondary constructor"))

        questionList.add(Question(
            "Which of the following is not the basic data types in Kotlin?",
            listOf("Numbers", "Strings", "Arrays", "Lists"),
            "Lists"))


//        loading first question
        loadQuestion()


//        adding onclicklisteners and checking if click button is correct option or not
        btnOption1.setOnClickListener {
            if (btnOption1.text == questionList[index].correctAnswer) {
                score += 10
                nextQuestion()

            } else {
                nextQuestion()

            }
        }

//        adding onclicklisteners and checking if click button is correct option or not
        btnOption2.setOnClickListener {
            if (btnOption2.text == questionList[index].correctAnswer) {
                score += 10
                nextQuestion()
            } else {
                nextQuestion()
            }
        }
        //        adding onclicklisteners and checking if click button is correct option or not
        btnOption3.setOnClickListener {
            if (btnOption3.text == questionList[index].correctAnswer) {
                score += 10
                nextQuestion()

            } else {
                nextQuestion()

            }
        }

//        adding onclicklisteners and checking if click button is correct option or not
        btnOption4.setOnClickListener {
            if (btnOption4.text == questionList[index].correctAnswer) {
                score += 10
                nextQuestion()

            } else {
                nextQuestion()

            }
        }


    }

    //checking if user accidently clicks the back button if yes showing a toast and on rapidly click exit the game
    override fun onBackPressed() {
        if (pressedTime + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
            finish()
        } else {
            Toast.makeText(baseContext,
                "Press back again to quit the game",
                Toast.LENGTH_SHORT).show()
        }
        pressedTime = System.currentTimeMillis()
    }

    //    inscreament the index and call the load Question and checks whether you are and the last question or not if yes then send score to GameOverAcitivity
    private fun nextQuestion() {
        if (index < questionList.size - 1) {
            index++
            loadQuestion()
        } else {
            Intent(this, GameOverActivity::class.java).apply {
                putExtra("Score", score)
                startActivity(this)
            }
        }

    }

//    update the views by the current question data
    private fun loadQuestion() {
        val noOfQuestions = "${index+1}/${questionList.size}"
        tvNoOfQuestions.text = noOfQuestions
        tvQuestion.text = questionList[index].question
        btnOption1.text = questionList[index].options[0]
        btnOption2.text = questionList[index].options[1]
        btnOption3.text = questionList[index].options[2]
        btnOption4.text = questionList[index].options[3]
    }

}