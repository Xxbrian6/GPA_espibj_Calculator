package com.example.gpa_espibj_calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import android.widget.LinearLayout
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var gpaTextView :TextView
    private lateinit var numForGrade1 : EditText
    private lateinit var numForGrade2 : EditText
    private lateinit var numForGrade3 : EditText
    private lateinit var numForGrade4 : EditText
    private lateinit var numForGrade5 : EditText
    private lateinit var layoutValue : LinearLayout
    private var isAllFieldsChecked = false
    private lateinit var calcButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gpaTextView = findViewById(R.id.gpa_text_view)
        numForGrade1 = findViewById(R.id.num_for_grade1)
        numForGrade2 = findViewById(R.id.num_for_grade2)
        numForGrade3 = findViewById(R.id.num_for_grade3)
        numForGrade4 = findViewById(R.id.num_for_grade4)
        numForGrade5 = findViewById(R.id.num_for_grade5)
        layoutValue = findViewById(R.id.activity_main)
        calcButton = findViewById(R.id.calc_button)

    }

    fun calculateClick(view: View) {
        //get the text typed into EditText1 ,2 ,3 ,4 ,5
        val numGrade1Str = numForGrade1.text.toString()
        val numGrade2Str = numForGrade2.text.toString()
        val numGrade3Str = numForGrade3.text.toString()
        val numGrade4Str = numForGrade4.text.toString()
        val numGrade5Str = numForGrade5.text.toString()

        //check if the all the datd if inserted
        isAllFieldsChecked = CheckAllFields()
        if(isAllFieldsChecked) {
            //
            //convert the text into an integer
            val grade1 = numGrade1Str.toInt()
            val grade2 = numGrade2Str.toInt()
            val grade3 = numGrade3Str.toInt()
            val grade4 = numGrade4Str.toInt()
            val grade5 = numGrade5Str.toInt()

            //get the gpa calculation
            val calc = GpaCalculator(grade1, grade2, grade3, grade4, grade5)
            val totalGpa = calc.totalGPA

            // Place gpa calculated  into the string resource and display
            val totalText = getString(R.string.total_gpa_num, totalGpa)
            gpaTextView.text = totalText

            // display color backGround when gpa is calculated
            if (totalGpa <= 60) {
                layoutValue.setBackgroundColor(Color.RED)
            } else if (totalGpa < 80) {
                layoutValue.setBackgroundColor(Color.YELLOW)
            } else if (totalGpa <= 100) {
                layoutValue.setBackgroundColor(Color.GREEN)
            }

            calcButton.setText("Clear")
        }
    }

    private fun CheckAllFields(): Boolean {
        if (numForGrade1!!.length() == 0) {
            numForGrade1!!.error = "This field is required"
            return false
        }
        if (numForGrade2!!.length() == 0) {
            numForGrade2!!.error = "This field is required"
            return false
        }
        if (numForGrade3!!.length() == 0) {
            numForGrade3!!.error = "Email is required"
            return false
        }
        if (numForGrade4!!.length() == 0) {
            numForGrade4!!.error = "Password is required"
            return false
        }
        if (numForGrade5!!.length() == 0) {
            numForGrade5!!.error = "Password must be minimum 8 characters"
            return false
        }
        // after all validation return true.
        return true
    }

}