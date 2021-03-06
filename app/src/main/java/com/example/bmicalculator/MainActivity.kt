package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            startActivity(Intent(this, BmiCalculatorActivity::class.java))
        }, 1000)

    }

    fun skip(view: View) {
        startActivity(Intent(this, BmiCalculatorActivity::class.java))
    }
}