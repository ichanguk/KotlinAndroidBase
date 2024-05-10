package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityTwoBinding

class TwoActivity : AppCompatActivity() {
    lateinit var binding: ActivityTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.one.setOnClickListener {
            startActivity(Intent(this@TwoActivity, OneActivity::class.java))
        }

        binding.two.setOnClickListener {
            startActivity(Intent(this@TwoActivity, TwoActivity::class.java))
        }

        binding.three.setOnClickListener {
            startActivity(Intent(this@TwoActivity, ThreeActivity::class.java))
        }
    }
}