package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityFragmentBinding
    lateinit var fragmentFirst: FragmentFirst
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFragmentBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Transaction
        // - 작업의 단위 -> 시작과 끝이 있다
        // A, B, C, D


        val fragmentManager = supportFragmentManager
        fragmentFirst = FragmentFirst()
        binding.attach.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            // fragment에 데이터를 전달하는 방법
            val bundle = Bundle()
            bundle.putString("key", "hello")
            fragmentFirst.arguments = bundle
            transaction.replace(R.id.fragment_two, fragmentFirst, "fragment_first_tag") // root layout을 fragment 뷰로 바꿈
            transaction.commit()
        }
        binding.detach.setOnClickListener {
            val transaction = fragmentManager.beginTransaction()
            transaction.remove(fragmentFirst)
            transaction.commit()
        }

        binding.accessFragment.setOnClickListener {
            // XML에 있는 fragment를 찾는 방법
//          val fragmentFirst = supportFragmentManager.findFragmentById(R.id.fragment_first) as FragmentFirst
//          fragmentFirst.printTestLog()
//
            // XML에 없는 fragment를 찾는 방법(fragment를 붙여주고 눌러야됨)
            val fragmentFirst = supportFragmentManager.findFragmentByTag("fragment_first_tag") as FragmentFirst
            fragmentFirst.printTestLog()

        }

        // commit
        // 1. commit
        // 2. commitAllowingStateLoss
        // 3. commitNow
        // 4. commitNowAllowingStateLoss
    }

    fun printTestLog() {
        Log.d("testt", "print test log")
    }
}