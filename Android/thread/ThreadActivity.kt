package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityThreadBinding

class ThreadActivity : AppCompatActivity() {
    lateinit var binding:ActivityThreadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val currentThread = Thread.currentThread()
        Log.d("testt", "" + currentThread)

//        Thread {
//            for (a in 1..1000) {
//                Log.d("testt", "" + a)
//            }
//        }.start()
//
//        Thread {
//            for (a in 1..1000) {
//                Log.d("testt", "" + a)
//            }
//        }.start()
        // 각각 독립적으로 돌아감 그래서 log에 숫자가 섞일 수 있음

        Thread {
            val currentThread = Thread.currentThread()
            Log.d("testt", "A" + currentThread)
            // binding.test.text = "changed"
            // UI 관련 작업을 메인 스레드가 아닌 스레드에서 하려고 하면 해당 작업 메인 스레드의 큐로 들어간다
            // -> 에러가 발생하지 않을 수도 있다.
            runOnUiThread {
                binding.test.text = "changed"
            } // UI를 thread에서 변경하려면 이렇게 쓰는 게 안전하다.
        }.start()
    }
}