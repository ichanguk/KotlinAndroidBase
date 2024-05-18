package com.example.androidpractice

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.androidpractice.databinding.ActivityRecyclerViewBinding
import com.example.androidpractice.AddViewActivity.Car

class RecyclerViewActivity : AppCompatActivity() {
    lateinit var binding:ActivityRecyclerViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val carList = mutableListOf<Car>()
        for (i in 0..100) {
            carList.add(Car("${i}번째 자동차", "${i}번째 엔진"))
        }
        // 어댑터, 레이아웃 매니저 장착
        binding.recyclerView.adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this), this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // 100번째부터 0번째로 출력
        // binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)

        // 가로로 출력
        // binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // 3열 그리드로 출력
        // binding.recyclerView.layoutManager = GridLayoutManager(this, 3)


    }

    class RecyclerViewAdapter(
        // outer class
        var carList:MutableList<Car>,
        var inflater: LayoutInflater,
        var context: Context
    ): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            //inner class
            val carImage: ImageView
            val nthCar: TextView
            val nthEngine: TextView
            init {
                carImage = itemView.findViewById(R.id.carImage)
                nthCar = itemView.findViewById(R.id.nthCar)
                nthEngine = itemView.findViewById(R.id.nthEngine)

                itemView.setOnClickListener {
                    val position: Int = adapterPosition
                    val car = carList.get(position)
                    Log.d("testt", car.nthCar)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.car_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return carList.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.carImage.setImageDrawable(context.resources.getDrawable(R.drawable.lion, null))
            holder.nthCar.text = carList.get(position).nthCar
            holder.nthEngine.text = carList.get(position).nthEngine
        }
    }
}