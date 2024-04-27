package com.dogukan.kotlinlearning

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dogukan.kotlinlearning.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.AddButton.setOnClickListener(){
            Calculator(view,1)
        }
        binding.SubsButton.setOnClickListener(){
            Calculator(view,2)
        }
        binding.MultButton.setOnClickListener(){
            Calculator(view,3)
        }
        binding.DivButton.setOnClickListener(){
            Calculator(view,4)
        }

    }

    fun Calculator (view: View, operation: Int ){
        val firstNumStr = binding.firstNumber.text.toString()
        val secNumStr = binding.SecondNumber.text.toString()


        if(firstNumStr.isEmpty() || secNumStr.isEmpty()){
            binding.ResultView.text = "Numbers cannot be empty!"
        } else {
            try {
                val firstNum = firstNumStr.toDouble()
                val secNum = secNumStr.toDouble()
                when(operation){
                    1->
                        binding.ResultView.text = "Result: ${firstNum + secNum}"
                    2->
                        binding.ResultView.text = "Result: ${firstNum - secNum}"
                    3->
                        binding.ResultView.text = "Result: ${firstNum * secNum}"
                    4->
                        binding.ResultView.text = "Result: ${firstNum / secNum}"
                }

            } catch (e: NumberFormatException) {
                binding.ResultView.text = "Invalid input! Please enter valid numbers."
            }
        }
    }

}