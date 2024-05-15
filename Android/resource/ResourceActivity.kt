package com.example.androidpractice

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityResourceBinding

class ResourceActivity : AppCompatActivity() {
    lateinit var binding: ActivityResourceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResourceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.text.setOnClickListener {
            (it as TextView).text = resources.getText(R.string.app_name)
            // 방법 1
            // it.background = resources.getDrawable(R.drawable.arrows, this.theme)

            // 방법 2
            // it.background = ContextCompat.getDrawable(this, R.drawable.arrows)

            // 방법 3
            it.background = ResourcesCompat.getDrawable(resources, R.drawable.arrows, null)
        }

        binding.image.setOnClickListener {
            (it as ImageView).setImageResource(R.drawable.logo_fb2)
        }
    }
}