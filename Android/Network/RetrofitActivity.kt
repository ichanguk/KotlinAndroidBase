package com.example.androidpractice

import android.os.Bundle
import android.util.Log
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
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_retrofit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 서버 -> 읽을 수 없는 데이터 -> JSON -> Gson
        // GSON -> 읽을 수 없는 데이터를 코틀린 객체로 바꿔준다.
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitService = retrofit.create(RetrofitService::class.java)
        retrofitService.getStudentList().enqueue(object : Callback<ArrayList<StudentFromServer>> {
            override fun onResponse(
                call: Call<ArrayList<StudentFromServer>>,
                response: Response<ArrayList<StudentFromServer>>
            ) {
                if (response.isSuccessful) {
                    val studentList = response.body()
                    studentList!!.forEach {
                        Log.d("testt", "" + it.intro)
                    }
                    findViewById<RecyclerView>(R.id.student_recyclerview).apply {
                        this.adapter = StudentListRecyclerViewAdapter(
                            studentList!!,
                            LayoutInflater.from(this@RetrofitActivity)
                        )
                        this.layoutManager = LinearLayoutManager(this@RetrofitActivity)
                    }
                }

            }

            override fun onFailure(p0: Call<ArrayList<StudentFromServer>>, p1: Throwable) {
            }

        })

        findViewById<TextView>(R.id.create_student).setOnClickListener {
            val student = HashMap<String, Any>()
            student.put("name", "코카콜라")
            student.put("age", 999)
            student.put("intro", "펩시")
            retrofitService.createStudent(student).enqueue(object :Callback<StudentFromServer> {
                override fun onResponse(
                    call: Call<StudentFromServer>,
                    response: Response<StudentFromServer>
                ) {
                    if (response.isSuccessful) {
                        val student = response.body()
                        Log.d("testt", "등록한 학생: " + student!!.name)
                    }
                }

                override fun onFailure(p0: Call<StudentFromServer>, p1: Throwable) {
                    Log.d("testt", "요청 실패")
                }

            })
        }

        findViewById<TextView>(R.id.easy_create_student).setOnClickListener {
            val student = StudentFromServer(name = "서울", age = 200, intro = "welcome to Seoul")
            retrofitService.easyCreateStudent(student).enqueue(object: Callback<StudentFromServer> {
                override fun onResponse(
                    call: Call<StudentFromServer>,
                    response: Response<StudentFromServer>
                ) {
                    if (response.isSuccessful) {
                        val student = response.body()
                        Log.d("testt", "등록한 학생: " + student!!.name)
                    }
                }

                override fun onFailure(p0: Call<StudentFromServer>, p1: Throwable) {
                    Log.d("testt", "요청 실패")
                }
            })
        }

    }

    class StudentListRecyclerViewAdapter(
        var studentList: ArrayList<StudentFromServer>,
        var inflater: LayoutInflater
    ):RecyclerView.Adapter<StudentListRecyclerViewAdapter.ViewHolder>() {
        inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
            val studentName: TextView
            val studentAge: TextView
            val studentIntro: TextView

            init {
                studentName = itemView.findViewById(R.id.student_name)
                studentAge = itemView.findViewById(R.id.student_age)
                studentIntro = itemView.findViewById(R.id.student_intro)
            }

        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = inflater.inflate(R.layout.student_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.studentName.text = studentList.get(position).name
            holder.studentAge.text = studentList.get(position).age.toString()
            holder.studentIntro.text = studentList.get(position).intro
        }

        override fun getItemCount(): Int {
            return studentList.size
        }

    }
}