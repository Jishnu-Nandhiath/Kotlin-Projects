package com.mobiledaemon.quizzy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton : Button
    private lateinit var falseButton : Button

    private lateinit var toast : Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)


        toast.setGravity(10,10,10)

        trueButton.setOnClickListener {
            view : View ->
            Toast.makeText(this,R.string.correctToast,Toast.LENGTH_SHORT).show()

        }

        falseButton.setOnClickListener {
            view : View ->
            Toast.makeText(this,R.string.incorrectToast,Toast.LENGTH_SHORT).show()
        }
    }
}