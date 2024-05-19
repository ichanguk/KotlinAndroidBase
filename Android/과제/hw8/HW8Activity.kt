package com.example.androidpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.databinding.ActivityHw8Binding

class HW8Activity : AppCompatActivity() {
    lateinit var binding: ActivityHw8Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHw8Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val chatList = mutableListOf<String>()
        for (i in 0 until 30) {
            when (i % 6) {
                0 -> chatList.add("안녕하세요")
                1 -> chatList.add("네 안녕하세요")
                2 -> chatList.add("반갑습니다")
                3 -> chatList.add("네 반가워요")
                4 -> chatList.add("안녕히 주무세요")
                5 -> chatList.add("네 안녕히 주무세요")
            }
        }

        binding.recyclerView.adapter = RecyclerViewAdapter(chatList, LayoutInflater.from(this))
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


    }

    class RecyclerViewAdapter(
        var chatList: MutableList<String>,
        var inflater: LayoutInflater
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        companion object {
            const val VIEW_TYPE_A = 0
            const val VIEW_TYPE_B = 1
        }

        inner class AViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val chatText: TextView

            init {
                chatText = itemView.findViewById(R.id.a_text)
            }
        }

        inner class BViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val chatText: TextView

            init {
                chatText = itemView.findViewById(R.id.b_text)
            }
        }

        override fun getItemViewType(position: Int): Int {
            return when(position % 2) {
                0 -> VIEW_TYPE_A
                1 -> VIEW_TYPE_B
                else -> throw IllegalArgumentException("Invalid type of data at position $position")
            }
        }

        override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): RecyclerView.ViewHolder {
            return when (viewType) {
                VIEW_TYPE_A -> {
                    val view = inflater.inflate(R.layout.hw8_item, parent, false)
                    AViewHolder(view)
                }

                VIEW_TYPE_B -> {
                    val view = inflater.inflate(R.layout.hw8_item2, parent, false)
                    BViewHolder(view)
                }

                else -> throw IllegalArgumentException("Invalid view type")
            }
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            when (holder) {
                is AViewHolder -> holder.chatText.text = chatList[position]
                is BViewHolder -> holder.chatText.text = chatList[position]
            }
        }

        override fun getItemCount(): Int {
            return chatList.size
        }


    }
}