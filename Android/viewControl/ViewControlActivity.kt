package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ViewControlActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_control)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 뷰를 코틀린 파일(Activity)로 가져 오는 방법
        val textViewOne: TextView = findViewById(R.id.textViewOne)
        val btnOne: Button = findViewById(R.id.btnOne)

        Log.d("testt", textViewOne.text.toString())



        // Listener 사용 방법, 풀 버전
//        val clickListener = object : View.OnClickListener {
//            override fun onClick(p0: View?) {
//                Log.d("testt", "버튼 클릭!!!")
//            }
//        }
//
//        btnOne.setOnClickListener(clickListener)

        // 축약 버전 1(익명함수)
        btnOne.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d("testt", "버튼 클릭!!!!")
            }
        })

        // 람다 버전
        btnOne.setOnClickListener {
            // 버튼이 클릭 됐을 때 동작할 코드
            Log.d("testt", "버튼 클릭!!")
        }
    }
}