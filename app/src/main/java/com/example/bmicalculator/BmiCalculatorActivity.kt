package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bmi_calculator.*
import org.w3c.dom.Text

class BmiCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)
    }

    fun calculate(view: View) {
        //get input
        var userHeight = height.text.toString().toInt()
        var userWeight = weight.text.toString().toInt()
        var userGoal = weightGoal.text.toString().toInt()
        var userAge = age.text.toString().toInt()


        //validation
        if (userHeight == 0) {
            Toast.makeText(this, "Please enter a valid height", Toast.LENGTH_SHORT).show()
            return
        }
        if (userWeight == 0) {
            Toast.makeText(this, "Please enter a valid weight", Toast.LENGTH_SHORT).show()
            return
        }
        if (userGoal == 0) {
            Toast.makeText(this, "Please enter a valid weight goal", Toast.LENGTH_SHORT).show()
            return
        }
        if (userAge == 0) {
            Toast.makeText(this, "Please enter a valid age", Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(height.text.toString())) {
            Toast.makeText(this, "Please enter your height", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(weight.text.toString())) {
            Toast.makeText(this, "Please enter your weight", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(weightGoal.text.toString())) {
            Toast.makeText(this, "Please enter your weight goal", Toast.LENGTH_SHORT).show()
            return
        }
        if (TextUtils.isEmpty(age.text.toString())) {
            Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show()
            return
        }


        startActivity(Intent(this, ResultsActivity::class.java))

    }
}