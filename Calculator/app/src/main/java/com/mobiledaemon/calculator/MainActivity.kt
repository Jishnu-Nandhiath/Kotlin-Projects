package com.mobiledaemon.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {

     var userInputTextView : TextView? = null
     var isDecimalPoint = false
    var isLastDigit = false;
    var isOperatorAdded = false;
    var operatorString : String? = null
    var currentOperationPos : Int = 0
    var currentOperation : MutableList<String> = mutableListOf("","")
    private var output : Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {



        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userInputTextView = findViewById(R.id.userInput)

        val numberOne : Button = findViewById(R.id.numberOne)
        val numberTwo : Button = findViewById(R.id.numberTwo)
        val numberThree : Button = findViewById(R.id.numberThree)
        val numberFour : Button = findViewById(R.id.numberFour)
        val numberFive : Button = findViewById(R.id.numberFive)
        val numberSix : Button = findViewById(R.id.numberSix)
        val numberSeven : Button = findViewById(R.id.numberSeven)
        val numberEight : Button = findViewById(R.id.numberEight)
        val numberNine : Button = findViewById(R.id.numberNine)
        val operatorAddition : Button = findViewById(R.id.operatorAddition)
        val operatorSubtraction : Button = findViewById(R.id.operatorSubtraction)
        val operatorMultiplication : Button = findViewById(R.id.operatorMultiplication)
        val operatorDivision : Button = findViewById(R.id.operatorDivision)
        val operatorEquality : Button = findViewById(R.id.operatorEquality)
        val decimalPoint : Button = findViewById(R.id.decimalPoint)
        val clearButton : Button = findViewById(R.id.clear_text)
        val backspace : Button = findViewById(R.id.backspace)
        val numberZero : Button = findViewById(R.id.numberZero)
        val doubleZero : Button= findViewById(R.id.doubleZeros)

        operatorEquality.setOnClickListener {
            onEqual()
        }

        operatorSubtraction.setOnClickListener {
            onOperator(operatorSubtraction.text as String)
        }

        operatorMultiplication.setOnClickListener {
            onOperator(operatorMultiplication.text as String)
        }

        operatorDivision.setOnClickListener {
            onOperator(operatorDivision.text as String)
        }

        operatorAddition.setOnClickListener {
            onOperator(operatorAddition.text as String)
        }

        decimalPoint.setOnClickListener{
            addDecimalPoint()
        }

        clearButton.setOnClickListener{
            clearInput()
        }

        numberOne.setOnClickListener{
            onNumberButtonClick(numberOne.text as String)
        }
        numberTwo.setOnClickListener{
            onNumberButtonClick(numberTwo.text as String)
        }

        numberThree.setOnClickListener{
            onNumberButtonClick(numberThree.text as String)
        }


        numberFour.setOnClickListener{
            onNumberButtonClick(numberFour.text as String)
        }

        numberFive.setOnClickListener{
            onNumberButtonClick(numberFive.text as String)
        }

        numberSix.setOnClickListener{
            onNumberButtonClick(numberSix.text as String)
        }

        numberSeven.setOnClickListener{
            onNumberButtonClick(numberSeven.text as String)
        }

        numberEight.setOnClickListener{
            onNumberButtonClick(numberEight.text as String)
        }

        numberNine.setOnClickListener{
            onNumberButtonClick(numberNine.text as String)
        }

        numberZero.setOnClickListener{onNumberButtonClick(numberZero.text as String)}
        doubleZero.setOnClickListener{onNumberButtonClick(doubleZero.text as String)}
    }

    fun onNumberButtonClick(buttonText : String){
        currentOperation[currentOperationPos]+=buttonText
        userInputTextView?.append(buttonText)
        isLastDigit = true
    }

    fun clearInput(){
        currentOperationPos = 0
        currentOperation.clear()
        currentOperation = mutableListOf("","")
        userInputTextView?.text = null
        isOperatorAdded = false
        isLastDigit = false
        isDecimalPoint = false
    }

    fun addDecimalPoint(){
        if(!isDecimalPoint && isLastDigit){
            currentOperation[currentOperationPos] += "."
            userInputTextView?.append(".")
            isDecimalPoint = true
            isLastDigit = false
        }
    }

    fun onOperator(operator : String){
        if(isLastDigit && !isOperatorAdded){
            currentOperationPos = 1
            isDecimalPoint = false
            isLastDigit = false
            operatorString = operator
            userInputTextView?.textAlignment = View.TEXT_ALIGNMENT_TEXT_START
            userInputTextView?.append("\n$operator")
            isOperatorAdded = true
            userInputTextView?.textAlignment = View.TEXT_ALIGNMENT_VIEW_END
        }
    }

    fun onEqual(){

        if(isOperatorAdded && isLastDigit){
            currentOperationPos = 1
            isOperatorAdded = false
            isLastDigit = true
            isDecimalPoint = false
            when(operatorString){
                "+" -> {
                    var operands : List<String>? = userInputTextView?.text?.split("\n+")

//                    print(currentOperation)
//                    print(operands)

                    output = currentOperation[0].toDouble() + currentOperation[1].toDouble()

                    currentOperation[0] = output.toString()
                    currentOperation[1] = ""

                    userInputTextView?.append("\n$output")


                }

            }
        }
    }


}
