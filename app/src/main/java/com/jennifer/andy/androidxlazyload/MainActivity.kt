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
import com.jennifer.andy.androidxlazyload.demo.demo5.Activity5
import com.jennifer.andy.androidxlazyload.demo.demo6.Activity6
import com.jennifer.andy.androidxlazyload.demo.demo7.Activity7

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
        findViewById<Button>(R.id.btn_7).setOnClickListener(this)
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
            R.id.btn_5 -> {//复杂fragment嵌套的懒加载1

                //一级界面用 add+show+hide 显示ABC三个fragment.
                //AFragment: 没有任何嵌套，只是单独的一个Fragment
                //BFragment: 是通过 add+show+hide模式显示 one two three 三个Fragment
                //CFragment: 是通过 ViewPager 模式显示 4个 TextFragment

                startActivity(Intent(this, Activity5::class.java))
            }
            R.id.btn_6 -> {//复杂fragment嵌套的懒加载2

                //一级界面 使用ViewPager 显示ABC三个fragment.
                //AFragment: 没有任何嵌套，只是单独的一个Fragment
                //BFragment: 是通过 add+show+hide模式显示 one two three 三个Fragment
                //CFragment: 是通过 ViewPager 模式显示 4个 TextFragment

                startActivity(Intent(this, Activity6::class.java))
            }
            R.id.btn_7 -> {//ViewPager2懒加载
                startActivity(Intent(this, Activity7::class.java))
            }
        }

    }
}
