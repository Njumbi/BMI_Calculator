package com.example.bmicalculator

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_results.*


class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        //get user data from preferences
        val pref = applicationContext.getSharedPreferences("MyPref", 0) // 0 :- for private mode
        val editor: SharedPreferences.Editor = pref.edit()
        val userBmi = pref.getInt("computed_Bmi", 0).toString(); // getting Integer
        val userWeight = pref.getInt("user_weight", 0).toString()
        val userGoal = pref.getInt("goal_weight", 0).toString()

        // set text to user data
        bmi.text = userBmi
        cGoal.text = userWeight
        wGoal.text = userGoal

        val uBmi = pref.getInt("computed_Bmi", 0)

        if (uBmi <= 0) {
            status.text = " "
        } else if (uBmi < 18) {
            status.text = " You are underweight"
        } else if (uBmi >= 18.5 && uBmi <= 24.9) {
            status.text = " You are healthy"
        } else if (uBmi >= 28 && uBmi <= 29.9) {
            status.text = "You are overweight"
        } else {
            status.text = "You are obese"
        }

        editor.remove("computed_Bmi")
        editor.remove("user_weight")
        editor.remove("goal_weight")
        editor.commit()

    }

    fun backCalculator(view: View) {
        startActivity(Intent(this, BmiCalculatorActivity::class.java))
    }

    fun diaryRfresh(view: View) {
        startActivity(Intent(this, ResultsActivity::class.java))
    }
}