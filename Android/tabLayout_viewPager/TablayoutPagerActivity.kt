package com.example.androidpractice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.androidpractice.databinding.ActivityTablayoutPagerBinding
import com.google.android.material.tabs.TabLayout

class TablayoutPagerActivity : AppCompatActivity() {
    lateinit var binding:ActivityTablayoutPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTablayoutPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager

        // tab 레이아웃에 tab을 추가하는 방법
        tabLayout.addTab(tabLayout.newTab().setText("1번째"))
        tabLayout.addTab(tabLayout.newTab().setText("2번째"))
        tabLayout.addTab(tabLayout.newTab().setText("3번째"))

        // pager에 adapter를 장착하는 방법
        viewPager.adapter = FragmentPagerAdapter(supportFragmentManager, 3)
        tabLayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


        })

    }

    class FragmentPagerAdapter(
        fragmentManager: FragmentManager,
        val tabCount: Int,

    ) : FragmentStatePagerAdapter(fragmentManager) {
        override fun getCount(): Int {
            return tabCount
        }

        override fun getItem(position: Int): Fragment {
            when (position) {
                0 -> return FragmentOne()
                1 -> return FragmentOne()
                else -> return FragmentOne()
            }
        }

    }
}