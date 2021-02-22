package com.example.bmicalculator

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bmi_calculator.*
import kotlin.math.pow
import kotlin.math.round


class BmiCalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_calculator)
    }

    fun calculate(view: View) {
        //validation input is not null

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

        //get input from user
        var userHeight = height.text.toString().toInt()
        var userWeight = weight.text.toString().toInt()
        var userGoal = weightGoal.text.toString().toInt()
        var userAge = age.text.toString().toInt()

        //validation number inputs are not zero

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


        //calculation of bmi

        val numerator = userWeight
        val denominator = (userHeight * 0.01).pow(2.0)
        var computedBmi = numerator / denominator
        computedBmi = round(computedBmi * 10.0) / 10.0
        val cBmi = computedBmi.toInt()
        println(cBmi)

        // store input to shared preferences

        val pref = applicationContext.getSharedPreferences("MyPref", 0) // 0 :- for private mode
        val editor: SharedPreferences.Editor = pref.edit()
        //editor.putBoolean("key_name", true);
        // editor.putString("key_name", "string value");
        //editor.putFloat("key_name", "float value");
        // editor.putLong("key_name", "long value");
        editor.putInt("computed_Bmi", cBmi);
        editor.putInt("user_weight", userWeight)
        editor.putInt("goal_weight", userGoal)
        editor.commit();


        //start activity to next activity
        startActivity(Intent(this, ResultsActivity::class.java))

    }

    fun refresh(view: View) {
        startActivity(Intent(this, BmiCalculatorActivity::class.java))
    }

    fun weightDiary(view: View) {
        startActivity(Intent(this, ResultsActivity::class.java))
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

}





