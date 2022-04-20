package jishnu.tutorials.kotlinbasicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myText = findViewById<TextView>(R.id.HelloUser)
        var timesClicked = 0

        val clickMyButton = findViewById<Button>(R.id.MyButton)
        clickMyButton.setOnClickListener {
            timesClicked += 1
            myText.text = "$timesClicked"
        }
        Toast.makeText(this, "Hey Jishnu ! You're great",Toast.LENGTH_LONG).show()



    }


}