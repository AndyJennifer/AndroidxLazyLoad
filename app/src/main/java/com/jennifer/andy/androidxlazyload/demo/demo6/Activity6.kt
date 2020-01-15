package com.jennifer.andy.androidxlazyload.demo.demo6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.demo.adapter.FragmentLazyPagerAdapter
import com.jennifer.andy.androidxlazyload.generateABCFragmentTitles
import com.jennifer.andy.androidxlazyload.generateABCFragments

class Activity6 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        initView()
    }

    private fun initView() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager).apply {
            adapter = FragmentLazyPagerAdapter(
                supportFragmentManager,
                generateABCFragments().values.toMutableList(),
                generateABCFragmentTitles()
            )
        }
        findViewById<TabLayout>(R.id.tab_layout).setupWithViewPager(viewPager)
    }

}