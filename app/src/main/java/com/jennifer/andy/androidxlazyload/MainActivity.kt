package com.jennifer.andy.androidxlazyload

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.jennifer.andy.androidxlazyload.demo.demo1.Activity1
import com.jennifer.andy.androidxlazyload.demo.demo2.Activity2
import com.jennifer.andy.androidxlazyload.demo.demo3.Activity3
import com.jennifer.andy.androidxlazyload.demo.demo4.Activity4

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_4).setOnClickListener(this)
        findViewById<Button>(R.id.btn_5).setOnClickListener(this)
        findViewById<Button>(R.id.btn_6).setOnClickListener(this)
    }

    override fun onClick(view: View) {

        when (view.id) {
            R.id.btn_1 -> {//view_pager下fragment_state_pager_adapter下的懒加载
                startActivity(Intent(this, Activity1::class.java))
            }
            R.id.btn_2 -> {//view_pager下fragment_pager_adapter下的懒加载
                startActivity(Intent(this, Activity2::class.java))
            }
            R.id.btn_3 -> {//同级fragment下的懒加载
                startActivity(Intent(this, Activity3::class.java))
            }
            R.id.btn_4 -> {//fragment嵌套fragment下的懒加载
                startActivity(Intent(this, Activity4::class.java))
            }
            R.id.btn_5 -> {//fragment嵌套view _pager下的懒加载
            }
            R.id.btn_6 -> {//ViewPager2懒加载
            }
        }

    }
}
