package com.example.androidpractice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.androidpractice.databinding.ActivityRoomBinding

class RoomActivity : AppCompatActivity() {
    lateinit var binding:ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 기본적으로 데이터베이스 작업은 메인 스레드에서 할 수 없다
        // 데이터베이스 작업을 휴대폰이 하는 동안 사용자가 기다려야하기 때문
        // 해결책은 스레드를 이용하거나 async를 이용하면 된다
        val database = Room.databaseBuilder(
            applicationContext,
            UserDatabase::class.java,
            "user-database"
        ).allowMainThreadQueries().build()

        binding.save.setOnClickListener {
            val userProfile = UserProfile("홍", "길동")
            database.userProfileDao().insert(userProfile)
        }

        binding.load.setOnClickListener {
            val userProfiles = database.userProfileDao().getAll()
            userProfiles.forEach {
                Log.d("testt", "" + it.id + it.firstName)
            }
        }

        binding.delete.setOnClickListener {
            database.userProfileDao().delete(1)
        }
    }

    @Entity
    class UserProfile(
        @PrimaryKey(autoGenerate = true)
        val id: Int,

        @ColumnInfo(name = "last_name")
        val lastName: String,

        @ColumnInfo(name = "first_name")
        val firstName: String
    ){
        constructor(lastName: String, firstName: String) : this(0, lastName, firstName)
    }


    @Database(entities = [UserProfile::class], version = 1)
    abstract class UserDatabase: RoomDatabase() {
        abstract fun userProfileDao(): UserProfileDao
    }

    @Dao
    interface UserProfileDao {
        // CRUD -> 데이터 베이스 조작
        // Query -> 데이터 베이스 조회
        @Insert(onConflict = REPLACE)
        fun insert(userProfile: UserProfile)

        @Query("DELETE FROM userprofile WHERE id = :userId")
        fun delete(userId: Int)

        @Query("SELECT * FROM userprofile")
        fun getAll(): List<UserProfile>
    }
}