package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.jennifer.andy.androidxlazyload.LogFragment
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.ext.loadFragments
import com.jennifer.andy.androidxlazyload.ext.showHideFragment


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:34
 * Description:
 */

class FragmentFour : LogFragment(), View.OnClickListener {

    companion object {
        fun newInstance() = FragmentFour()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_four, container, false)
    }

    override fun onResume() {
        super.onResume()
        initView()
    }

    private fun initView() {
        view?.findViewById<Button>(R.id.btn_1)?.setOnClickListener(this)
        view?.findViewById<Button>(R.id.btn_2)?.setOnClickListener(this)
        view?.findViewById<Button>(R.id.btn_3)?.setOnClickListener(this)
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
