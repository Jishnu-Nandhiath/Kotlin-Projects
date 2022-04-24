package jishnu.tutorials.minutesage

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private var selectedDateText : TextView? = null
    private var timeInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker : Button = findViewById(R.id.buttonDatePicker)

        selectedDateText = findViewById(R.id.selectedDateText)

        timeInMinutes = findViewById(R.id.timeInMinutes)

        btnDatePicker.setOnClickListener {
           clickDatePicker()
        }
    }


    fun clickDatePicker(){

        val myCalendar = Calendar.getInstance()
        val year =  myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)


        val dpd = DatePickerDialog(this,
            {view,selectedYear,selectedMonth, selectedDayOfMonth ->
                Toast.makeText(
                    this,
                    "Selected Date is : $selectedDayOfMonth.${selectedMonth+1}.$selectedYear", Toast.LENGTH_LONG
                ).show()

            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

                selectedDateText?.text = selectedDate

                val selectedDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate = selectedDateFormat.parse(selectedDate)

                val selectedDateinMiutes = theDate.time / 60000

                val currentDate = selectedDateFormat.parse(selectedDateFormat.format(System.currentTimeMillis()))

                val currentDateInMinutes = currentDate.time / 60000

                val differenceInMinutes = currentDateInMinutes - selectedDateinMiutes

                timeInMinutes?.text = differenceInMinutes.toString()

            },
            year,month,day
            )

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()


    }
}