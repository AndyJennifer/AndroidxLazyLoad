package com.jennifer.andy.androidxlazyload.demo.demo3

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.ext.loadFragments
import com.jennifer.andy.androidxlazyload.ext.showHideFragment
import com.jennifer.andy.androidxlazyload.fragment.fragmentOne
import com.jennifer.andy.androidxlazyload.fragment.fragmentThree
import com.jennifer.andy.androidxlazyload.fragment.fragmentTwo
import com.jennifer.andy.androidxlazyload.fragment.generateNormalFragments


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 14:48
 * Description:
 */

class Activity3 : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        initView()
    }

    private fun initView() {
        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_3).setOnClickListener(this)

        loadFragments(R.id.fl_container, 0, *generateNormalFragments().toTypedArray())
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_1 -> {
                showHideFragment(fragmentOne)
            }
            R.id.btn_2 -> {
                showHideFragment(fragmentTwo)
            }
            R.id.btn_3 -> {
                showHideFragment(fragmentThree)
            }
        }
    }
}