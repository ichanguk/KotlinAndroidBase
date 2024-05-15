package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityApplicationBinding

class ApplicationActivity : AppCompatActivity() {
    lateinit var binding:ActivityApplicationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.changeActivity.setOnClickListener {
            startActivity(Intent(this@ApplicationActivity, ApplicationActivity2::class.java))
        }

        // application context의 메소드 사용법
        binding.testMethod.setOnClickListener {
            (applicationContext as MasterApplication).methodFromApplication()
            val userId = (applicationContext as MasterApplication).userId
            Log.d("testt", userId.toString())
        }

    }
}