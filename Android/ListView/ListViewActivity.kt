package com.example.androidpractice

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.androidpractice.databinding.ActivityListViewBinding
import com.example.androidpractice.AddViewActivity.Car

class ListViewActivity : AppCompatActivity() {
    lateinit var binding:ActivityListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 데이터 준비
        val carList = mutableListOf<Car>()
        for (i in 0..100) {
            carList.add(Car("${i}번째 자동차", "${i}번째 엔진"))
        }
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this), this)
        binding.listView.adapter = adapter

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val car: Car = adapter.carList.get(position)
            val nthCar = car.nthCar
            val nthEngine = car.nthEngine

            Toast.makeText(
                this,
                nthCar + " " + nthEngine,
                Toast.LENGTH_LONG
            ).show()
        }
        // 데이터 갱신 방법
        binding.addCar.setOnClickListener {
            adapter.carList.add(
                Car("안녕 나는 차", "안녕 나는 엔진")
            )
            adapter.notifyDataSetChanged()
        }



    }
    class ListViewAdapter(
        val carList:MutableList<Car>,
        val layoutInflater: LayoutInflater,
        val context: Context
    ) : BaseAdapter() {
        override fun getCount(): Int {
            // 전체 데이터의 크기(갯수) 리턴
            return carList.size
        }

        override fun getItem(position: Int): Any {
            // 전체 데이터 중에서 해당번째(position)의 데이터를 리턴
            return carList.get(position)
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val view: View
            val holder: ViewHolder
            if (convertView == null) {
                // 재활용 불가능
                view = layoutInflater.inflate(R.layout.car_item, null)
                holder = ViewHolder()
                holder.carImage = view.findViewById(R.id.carImage)
                holder.nthCar = view.findViewById(R.id.nthCar)
                holder.nthEngine = view.findViewById(R.id.nthEngine)

                view.tag = holder
            } else {
                // 재활용 가능
                holder = convertView.tag as ViewHolder
                view = convertView
            }

            val car = carList.get(position)
            holder.carImage?.setImageDrawable(context.resources.getDrawable(R.drawable.lion, context.theme))
            holder.nthCar?.text = car.nthCar
            holder.nthEngine?.text = car.nthEngine
//            // 해당 번째 뷰를 리턴
//            val view = layoutInflater.inflate(R.layout.car_item, null)
//            val carImage = view.findViewById<ImageView>(R.id.carImage)
//            val nthCar = view.findViewById<TextView>(R.id.nthCar)
//            val nthEngine = view.findViewById<TextView>(R.id.nthEngine)
//
//            val car = carList.get(position)
//            carImage.setImageDrawable(context.resources.getDrawable(R.drawable.lion, context.theme))
//            nthCar.text = car.nthCar
//            nthEngine.text = car.nthEngine

            return view
        }


    }
    class ViewHolder {
        var carImage: ImageView? = null
        var nthCar: TextView? = null
        var nthEngine: TextView? = null
    }

}