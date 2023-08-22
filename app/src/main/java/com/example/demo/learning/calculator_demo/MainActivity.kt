package com.example.demo.learning.calculator_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.persistableBundleOf

class MainActivity : AppCompatActivity() {

    private lateinit var Num1:EditText
    private lateinit var Num2:EditText
    private lateinit var Add: Button
    private lateinit var Sub:Button
    private lateinit var Multi:Button
    private lateinit var Div:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       Num1 = findViewById(R.id.Num1)
        Num2 = findViewById(R.id.Num2)
        Add = findViewById(R.id.Add)
        Sub = findViewById(R.id.Sub)
        Multi = findViewById(R.id.Multi)
        Div = findViewById(R.id.Div)

        Add.setOnClickListener{performOperation('+')}
        Sub.setOnClickListener{performOperation('-')}
        Multi.setOnClickListener{performOperation('*')}
        Div.setOnClickListener{performOperation('/')}
    }

    private fun performOperation(operator : Char){
        val num1 = Num1.text.toString().toDoubleOrNull()
        val num2 = Num2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null){
            showToast("Please Enter the Valid Number")
            return
        }
        val result = when (operator){
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> 0.0
        }
        showToast("Result: $result")

    }

    private fun showToast(message : String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}