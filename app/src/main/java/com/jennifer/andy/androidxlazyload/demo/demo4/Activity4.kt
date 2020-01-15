package com.jennifer.andy.androidxlazyload.demo.demo4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.ext.loadRootFragment
import com.jennifer.andy.androidxlazyload.fragment.FourFragment


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 14:48
 * Description:
 */

class Activity4 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_4)
        initView()
    }

    private fun initView() {
        loadRootFragment(R.id.fl_container, FourFragment.newInstance())
    }
}