package com.jennifer.andy.androidxlazyload.data

import androidx.fragment.app.Fragment
import com.jennifer.andy.androidxlazyload.data.normal_fragment.FragmentOne
import com.jennifer.andy.androidxlazyload.data.normal_fragment.FragmentThree
import com.jennifer.andy.androidxlazyload.data.normal_fragment.FragmentTwo


/**
 * 获取正常的Fragment，该集合中的fragment不包含嵌套。
 */
fun generateNormalFragments(): MutableList<Fragment> {
    return mutableListOf<Fragment>().apply {
        add(FragmentOne.newInstance())
        add(FragmentTwo.newInstance())
        add(FragmentThree.newInstance())
    }
}