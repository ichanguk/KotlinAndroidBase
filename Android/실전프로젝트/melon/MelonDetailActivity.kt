package com.example.androidpractice

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class MelonDetailActivity : AppCompatActivity() {
    lateinit var melonItemList: ArrayList<MelonItem>
    lateinit var playPauseButton: ImageView
    lateinit var mediaPlayer: MediaPlayer
    var currentPosition = 0
        set(value) {
            if (value <= 0) {
                field = 0
            } else if (value >= melonItemList.size) {
                field = melonItemList.size
            } else {
                field = value
            }
        }
    var isPlaying = true
        set(value) {
            if (value == true) {
                playPauseButton.setImageDrawable(
                    this.resources.getDrawable(R.drawable.pause, this.theme)
                )
            } else {
                playPauseButton.setImageDrawable(
                    this.resources.getDrawable(R.drawable.play, this.theme)
                )
            }
            field = value
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_melon_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        melonItemList = intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>
        currentPosition = intent.getIntExtra("position", 0)
        changeThumbnail(melonItemList.get(currentPosition), currentPosition)
        playMelonItem(melonItemList.get(currentPosition))
        playPauseButton = findViewById(R.id.play)
        playPauseButton.setOnClickListener {
            if (isPlaying) {
                isPlaying = false
                mediaPlayer.stop()
            } else {
                isPlaying = true
                playMelonItem(melonItemList.get(currentPosition))
            }
        }
        findViewById<ImageView>(R.id.back).setOnClickListener {
            mediaPlayer.stop()
            currentPosition--
            changeThumbnail(melonItemList.get(currentPosition), currentPosition)
            playMelonItem(melonItemList.get(currentPosition))
        }
        findViewById<ImageView>(R.id.next).setOnClickListener {
            mediaPlayer.stop()
            currentPosition++
            changeThumbnail(melonItemList.get(currentPosition), currentPosition)
            playMelonItem(melonItemList.get(currentPosition))
        }

    }

    fun playMelonItem(melonItem: MelonItem) {
        mediaPlayer = MediaPlayer.create(
            this,
            //Uri.parse(melonItem.song)
            Uri.parse("https://drive.google.com/uc?export=download&id=1tD0wuwcKxTxtCrgTVSZuBSmWlKKd8fV6")
        )
        mediaPlayer.start()
    }

    fun changeThumbnail(melonItem: MelonItem, position:Int) {
        findViewById<ImageView>(R.id.thumbnail).apply {
            // val glide = Glide.with(this@MelonDetailActivity)
            // glide.load(melonItem.thumbnail).into(this)
            if (position % 2 == 0) {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.note))
            } else {
                setImageDrawable(ContextCompat.getDrawable(context, R.drawable.note2))
            }
        }
    }
}
