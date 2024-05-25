package com.example.androidpractice

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.PagerAdapter
import com.example.androidpractice.databinding.ActivityTablayoutPagerSimpleBinding
import com.google.android.material.tabs.TabLayout

class TablayoutPagerSimpleActivity : AppCompatActivity() {
    lateinit var binding:ActivityTablayoutPagerSimpleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTablayoutPagerSimpleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("1번째"))
        tabLayout.addTab(tabLayout.newTab().setText("2번째"))
        tabLayout.addTab(tabLayout.newTab().setText("3번째"))
        viewPager.adapter = ViewPagerAdapter(LayoutInflater.from(this), 3)
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }


        })
    }

    class ViewPagerAdapter(
        val layoutInflater: LayoutInflater,
        val tabCount:Int
    ) : PagerAdapter() {
        override fun getCount(): Int {
            return tabCount
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object` as View

        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            when (position) {
                0 -> {
                    val view = layoutInflater.inflate(R.layout.one_fragment, container, false)
                    container.addView(view)
                    return view
                }
                1 -> {
                    val view = layoutInflater.inflate(R.layout.activity_hw7, container, false)
                    container.addView(view)
                    return view
                }
                else -> {
                    val view = layoutInflater.inflate(R.layout.one_fragment, container, false)
                    container.addView(view)
                    return view
                }
            }
        }

    }
}