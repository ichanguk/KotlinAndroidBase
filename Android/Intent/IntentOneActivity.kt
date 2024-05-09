package com.example.androidpractice

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidpractice.databinding.ActivityIntentOneBinding

class IntentOneActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntentOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityIntentOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 암시적 인텐트
        // - 전화, SMS, Google play store, website, google map, 사진첩 등등
        // - URI (Uniform Resource Identifier)
        //      - id라고 생각하면 됨 -> 고유하다
        //      - 자원을 나타내는 주소
        val implicitIntent: TextView = findViewById(R.id.implicitIntent)
        implicitIntent.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "010-1111-1111"))
            startActivity(intent)
        }

        // 명시적 인텐트 + ComponentName -> 액티비티 전환
        binding.intentOne.setOnClickListener {
            val intent: Intent = Intent()
            val componentName: ComponentName = ComponentName(
                "com.example.androidpractice",
                "com.example.androidpractice.IntentTwoActivity"
            )
            intent.component = componentName
            startActivity(intent)
        }


        // Context
        // A액티비티 -> B액티비티
        binding.intentTwo.apply {
            // 그냥 this만 쓰면 이 텍스트뷰가 this가 됨
            this.setOnClickListener {
                startActivity(Intent(this@IntentOneActivity, IntentTwoActivity::class.java))
            }
        }

        // 명시적 인텐트 + data 전달
        binding.intentData.apply {
            this.setOnClickListener {
                val intent = Intent(this@IntentOneActivity, IntentTwoActivity::class.java)
                intent.putExtra("extra-data", "data-one")
                startActivity(intent)
            }
        }

        // 명시적 인텐트 + 결과 받기
        // requestCode
        // - 구분을 하기 위해서
        // - Intent_One -> Intent_Two (request 1)
        // - Intent_One -> Intent_Three (request 2)
        // - Intent_One -> Intent_four (request 3)

        binding.intentResult.apply {
            this.setOnClickListener {
                val intent = Intent(this@IntentOneActivity, IntentTwoActivity::class.java)
                startActivityForResult(intent, 1)

            }
        }

        // 명시적 인텐트 + 결과받기(ActivityResult API)
        // -> requestCode가 존재하지 않는다
        // -> requestCode 없이도 요청자를 구분할 수 있다.
        val startActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // onActivityResult에 해당하는 부분
            when (it.resultCode) {
                RESULT_OK -> {
                    Log.d("dataa", it.data?.extras?.getString("result")!!)
                }
            }
            // onActivityResult
            // - 모든 intent가 한 곳에서 처리된다 -> 구분이 필요하다(request code)
            // ActivityResult API
            // - 각각의 intent가 처리되는 곳이 별도로 있다 -> 구분이 필요없다
        }

        binding.intentResultAPI.apply {
            this.setOnClickListener {
                val intent = Intent(this@IntentOneActivity, IntentTwoActivity::class.java)
                startActivityLauncher.launch(intent)
            }
        }

        // 명시적 인텐트 + 이미지 URI 전달
        binding.intentACTION.apply {
            this.setOnClickListener {
                val intent = Intent(this@IntentOneActivity, IntentTwoActivity::class.java).apply {
                    val imageUri =
                        Uri.parse("android.resource://" + packageName + "/drawable/" + "lion")
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_STREAM, imageUri)
                    this.setType("image/*")
                }
                startActivity(intent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // requestCode (status code)
        // - 최종결과
        // - 성공, 실패
        when (requestCode) {
            1 -> {
                when (resultCode) {
                    RESULT_OK -> {
                        val data: String? = data?.extras?.getString("result")
                        Log.d("dataa", data!!)
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}