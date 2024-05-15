package com.example.androidpractice

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.loader.content.AsyncTaskLoader
import com.example.androidpractice.databinding.ActivityAsyncBinding

class AsyncActivity : AppCompatActivity() {
    lateinit var binding: ActivityAsyncBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAsyncBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backgroundAsyncTask = BackgroundAsyncTask(
            binding.progressBar,
            binding.progressBarText
        )

        binding.start.setOnClickListener {
            backgroundAsyncTask.execute()
        }

        binding.stop.setOnClickListener {
            backgroundAsyncTask.cancel(true)
        }

        // progressbar 작업이 진행중이더라도 이 작업도 진행 가능
        binding.shoot.setOnClickListener {
            Log.d("testt", "SHOOT!!!")
        }
    }


}

class BackgroundAsyncTask(
    val progressBar: ProgressBar,
    val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    // Params, Progress, Result
    // Params -> doInBackground에서 사용할 타입
    // Progress -> onProgressUpdate에서 사용할 타입
    // result -> onPostExecute에서 사용할 타입

    var percent: Int = 0
    // 코루틴 -> 멀티 태스킹, 동기 / 비동기 처리
    override fun doInBackground(vararg p0: Int?): Int {
        while (isCancelled() == false) {
            percent++
            if (percent > 100) {
                break
            } else {
                publishProgress(percent)
            }
            Thread.sleep(100)
        }
        return percent
    }

    override fun onPreExecute() {
        percent = 0
        progressBar.setProgress(percent)
    }

    override fun onPostExecute(result: Int?) {
        progressText.text = "작업이 완료되었습니다"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.setProgress(values[0] ?: 0)
        progressText.text = "퍼센트 : " + values[0]
    }

    override fun onCancelled() {
        progressBar.setProgress(0)
        progressText.text = "작업이 취소되었습니다"
    }
}