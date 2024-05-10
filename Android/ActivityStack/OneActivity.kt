package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityOneBinding

class OneActivity : AppCompatActivity() {
    lateinit var binding:ActivityOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.one.setOnClickListener {
            startActivity(Intent(this@OneActivity, OneActivity::class.java))
        }

        binding.two.setOnClickListener {
            val intent = Intent(this@OneActivity, TwoActivity::class.java)
            //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }

        binding.three.setOnClickListener {
            startActivity(Intent(this@OneActivity, ThreeActivity::class.java))
        }
    }
}