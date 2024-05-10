package com.example.androidpractice

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doBeforeTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.androidpractice.databinding.ActivityHw6Binding
import java.net.URL

class HW6Activity : AppCompatActivity() {
    lateinit var binding: ActivityHw6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHw6Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val urlPrefix = "https://"
        var finalUrl = ""
        binding.urlInputText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun afterTextChanged(p0: Editable?) {
                if (p0?.contains("https://") == false) {
                    finalUrl = urlPrefix + p0
                } else {
                    finalUrl = p0.toString()
                }
            }

        })

//        람다 사용방법
//        binding.urlInputText.doBeforeTextChanged { text, start, count, after ->  }
//        binding.urlInputText.doOnTextChanged { text, start, before, count ->  }
//        binding.urlInputText.doAfterTextChanged {
//
//        }


        binding.openBtn.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(finalUrl))
            startActivity(intent)
        }


        binding.webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            setSupportMultipleWindows(true)
        }

        binding.webView.webViewClient = WebViewClient()
        try {
            binding.webView.loadUrl(
                intent.data!!.toString()
            )
        } catch (exception:Exception) {
            Toast.makeText(this, "can't load URL", Toast.LENGTH_SHORT).show()
        }
    }
}