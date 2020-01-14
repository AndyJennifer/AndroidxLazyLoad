package com.jennifer.andy.androidxlazyload.demo.demo2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.fragment.generateNormalFragments


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 14:48
 * Description:
 */

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        initView()
    }

    private fun initView() {
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        viewPager.adapter = FragmentLazyStatePageAdapter(supportFragmentManager, generateNormalFragments())
    }

}