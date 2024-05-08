package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.Hw5Binding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: Hw5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Hw5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var num = ""
        var solveFlag = false
        binding.inputText.text = num

        binding.btnOne.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "1"
            binding.inputText.text = num
        }

        binding.btnTwo.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "2"
            binding.inputText.text = num
        }

        binding.btnThree.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "3"
            binding.inputText.text = num
        }

        binding.btnFour.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "4"
            binding.inputText.text = num
        }

        binding.btnFive.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "5"
            binding.inputText.text = num
        }

        binding.btnSix.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "6"
            binding.inputText.text = num
        }

        binding.btnSeven.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "7"
            binding.inputText.text = num
        }

        binding.btnEight.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "8"
            binding.inputText.text = num
        }

        binding.btnNine.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "9"
            binding.inputText.text = num
        }

        binding.btnZero.setOnClickListener {
            if (solveFlag) {
                solveFlag = false
                num = ""
            }
            num += "0"
            binding.inputText.text = num
        }

        var num1 = 0L
        binding.btnClear.setOnClickListener {
            num = ""
            num1 = 0
            binding.inputText.text = num
        }

        binding.btnPlus.setOnClickListener {
            if (num != "") {
                num1 = num.toLong()
                num = ""
                binding.inputText.text = ""
            }
        }

        binding.btnSolve.setOnClickListener {
            num = (num1 + num.toLong()).toString()
            num1 = 0
            binding.inputText.text = num
            solveFlag = true
        }

    }

}