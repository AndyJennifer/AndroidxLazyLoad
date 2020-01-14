package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jennifer.andy.androidxlazyload.LogFragment
import com.jennifer.andy.androidxlazyload.R


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:33
 * Description:
 */


class FragmentOne : LogFragment() {

    companion object {
        fun newInstance() = FragmentOne()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

}