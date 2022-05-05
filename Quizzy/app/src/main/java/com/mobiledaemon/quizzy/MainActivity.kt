package com.mobiledaemon.quizzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import kotlin.math.abs

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton : Button
    private lateinit var falseButton : Button
    private lateinit var nextButton : ImageButton
    private lateinit var prevButton : ImageButton

    private lateinit var questionText : TextView

    private var score : Int = 0

    private val questionBank : List<Question> = listOf(
        Question(R.string.questionContinent,true),
        Question(R.string.questionCountry,false),
        Question(R.string.questionDefaultPreview,true),
        Question(R.string.questionOcean,false),
        Question(R.string.questionMountain,true),
        Question(R.string.questionDesert,true)
    )

    private var currentIndex : Int = 0
    private var k : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)


        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        nextButton = findViewById(R.id.nextButton)
        prevButton = findViewById(R.id.prevButton)
        questionText = findViewById(R.id.question)



        trueButton.setOnClickListener {
            checkAnswer(true)
            disableAnswerButton()
        }

        falseButton.setOnClickListener {
         checkAnswer(false)
            disableAnswerButton()
        }

        nextButton.setOnClickListener {
            currentIndex += 1
            if(currentIndex == questionBank.size){
                currentIndex = 0
                val percentageScore : Double = (score.toDouble() / questionBank.size) * 100
                Toast.makeText(this,"Congrats! your Percentage is : $percentageScore",Toast.LENGTH_LONG).show()
            }
            updateQuestion()
            enableAnswerButton()
        }

        prevButton.setOnClickListener {
            k -= 1
            currentIndex = abs(k) % questionBank.size
            updateQuestion()
            enableAnswerButton()
        }

        updateQuestion()

    }

//    override fun onStart() {
//        super.onStart()
//        Log.d(TAG,"onStart() Called")
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Log.d(TAG,"onResume() called")
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Log.d(TAG,"onPause() Called")
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Log.d(TAG,"onStop() Called")
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Log.d(TAG,"onDestroy() Called")
//    }

    private fun updateQuestion(){
        val questionTextResId = questionBank[currentIndex].textId
        questionText.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer : Boolean){
        val correctAnswer : Boolean= questionBank[currentIndex].answer

        val messageResId : Int

        if(userAnswer == correctAnswer){
           messageResId = R.string.correctToast
            score += 1
        }else{
            messageResId = R.string.incorrectToast
        }

        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).apply{
            setGravity(Gravity.TOP,0,200); show()
        }
    }

    private fun disableAnswerButton(){
        trueButton.setEnabled(false)
        falseButton.setEnabled(false)
    }

    private fun enableAnswerButton(){
        trueButton.setEnabled(true)
        falseButton.setEnabled(true)
    }

}