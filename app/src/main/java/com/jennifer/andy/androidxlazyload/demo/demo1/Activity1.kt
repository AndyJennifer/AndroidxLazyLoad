package com.jennifer.andy.androidxlazyload.demo.demo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.demo.adapter.FragmentLazyPagerAdapter
import com.jennifer.andy.androidxlazyload.generate123FragmentTitles
import com.jennifer.andy.androidxlazyload.generate123Fragments


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 14:48
 * Description:
 */

class Activity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        initView()
    }

    private fun initView() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager).apply {
            adapter = FragmentLazyPagerAdapter(
                supportFragmentManager,
                generate123Fragments().values.toMutableList(),
                generate123FragmentTitles()
            )
        }
        findViewById<TabLayout>(R.id.tab_layout).setupWithViewPager(viewPager)
    }

}