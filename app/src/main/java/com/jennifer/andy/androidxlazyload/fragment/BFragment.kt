package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.jennifer.andy.androidxlazyload.*
import com.jennifer.andy.androidxlazyload.ext.loadFragments
import com.jennifer.andy.androidxlazyload.ext.showHideFragment


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:34
 * Description:
 */

class BFragment : LazyFragment(), View.OnClickListener {

    private lateinit var fragmentsMap: Map<String, Fragment>

    companion object {
        fun newInstance() = BFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_b, container, false)

    override fun lazyInit() {
        view?.findViewById<Button>(R.id.btn_1)?.setOnClickListener(this)
        view?.findViewById<Button>(R.id.btn_2)?.setOnClickListener(this)
        view?.findViewById<Button>(R.id.btn_3)?.setOnClickListener(this)
        fragmentsMap = generate123Fragments()
        loadFragments(R.id.fl_b_container, 0, *fragmentsMap.values.toTypedArray())
    }


    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_1 -> {
                showHideFragment(fragmentsMap.getValue(FRAGMENT_ONE))
            }
            R.id.btn_2 -> {
                showHideFragment(fragmentsMap.getValue(FRAGMENT_TWO))
            }
            R.id.btn_3 -> {
                showHideFragment(fragmentsMap.getValue(FRAGMENT_THREE))
            }
        }
    }

}
