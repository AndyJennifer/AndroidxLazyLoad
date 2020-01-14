package com.jennifer.andy.androidxlazyload.data.normal_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jennifer.andy.androidxlazyload.LogFragment
import com.jennifer.andy.androidxlazyload.R


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:34
 * Description:
 */

class FragmentThree : LogFragment() {

    companion object {
        fun newInstance(): FragmentThree {
            val args = Bundle()
            val fragment = FragmentThree()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

}
