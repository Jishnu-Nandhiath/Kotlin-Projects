package com.mobiledaemon.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.WindowCompat

class MainActivity : AppCompatActivity() {

    var userInputTextView : TextView = findViewById(R.id.userInput)

    var userInputText : String? =

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



}
