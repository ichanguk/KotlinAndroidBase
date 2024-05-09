package com.example.androidpractice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityIntentTwoBinding

class IntentTwoActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntentTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntentTwoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // IntentTwo 액티비티를 호출한 액티비티의 intent
        val intent = intent
        val data: String? = intent.extras?.getString("extra-data")

        if (data != null) {
            Log.e("dataa", data)
        }

        binding.finish.apply {
            this.setOnClickListener {
                val intent = Intent(this@IntentTwoActivity, IntentOneActivity::class.java)
                intent.putExtra("result", "success")
                setResult(RESULT_OK, intent)
                finish()
            }
        }

        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
        )
        binding.imageView.setImageURI(uri)

    }
}