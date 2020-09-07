package com.example.l4s_anzan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //0~999までの数字
        val randomNumber1 = Random.nextInt(1000)
        val randomNumber2 = Random.nextInt(1000)

        number1Text.text = randomNumber1.toString()
        number2Text.text = randomNumber2.toString()

        val randomOperator = Random.nextInt(2)

        var operatorText = ""

        var correctAnswer = 0

        if (randomOperator == 0){
            operatorText = "+"

            signText.text = operatorText

            correctAnswer = randomNumber1 + randomNumber2
        }
        else{
            operatorText = "-"

            signText.text = operatorText

            correctAnswer = randomNumber1 - randomNumber2
        }

        checkButton.setOnClickListener {
            val yourAnsewr = inputText.text.toString()

            if (yourAnsewr.isNotEmpty()){
                val answerPage = Intent(this,AnswerActivity::class.java)

                val questionText = randomNumber1.toString() + operatorText + randomNumber2.toString() + "="
                answerPage.putExtra("Question",questionText)
                answerPage.putExtra("Answer",yourAnsewr)
                answerPage.putExtra("Correct",correctAnswer.toString())

                startActivity(answerPage)

                finish()

            }
        }
    }
}
