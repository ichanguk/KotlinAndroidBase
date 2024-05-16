package com.example.androidpractice

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityHw7Binding

class HW7Activity : AppCompatActivity() {
    lateinit var binding: ActivityHw7Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHw7Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val phoneBook = mutableListOf<phoneInfo>()
        for (i in 0..20) {
            if (i < 10) {
                phoneBook.add(phoneInfo("${i}번째 사람", "010-1111-111$i"))
            } else {
                phoneBook.add(phoneInfo("${i}번째 사람", "010-1111-11$i"))
            }
        }

        val container = binding.container
        val inflater = LayoutInflater.from(this@HW7Activity)

        phoneBook.forEach {
            val phoneInfoItemView = inflater.inflate(R.layout.phone_info_item, null)
            val personImage = phoneInfoItemView.findViewById<ImageView>(R.id.person_image)
            val nthPerson = phoneInfoItemView.findViewById<TextView>(R.id.nth_person)
            val nthPhoneNum = phoneInfoItemView.findViewById<TextView>(R.id.nth_phone_num)
            personImage.setImageDrawable(resources.getDrawable(R.drawable.lion, this.theme))
            nthPerson.text = it.nthPerson
            nthPhoneNum.text = it.nthPhoneNum

            container.addView(phoneInfoItemView)

            phoneInfoItemView.setOnClickListener {
                val intent = Intent(this@HW7Activity, HW7DetailActivity::class.java)
                intent.putExtra("personName", nthPerson.text)
                intent.putExtra("personNum", nthPhoneNum.text)

                startActivity(intent)
            }


        }

    }

    class phoneInfo(val nthPerson:String, val nthPhoneNum:String)
}