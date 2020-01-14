package com.jennifer.andy.androidxlazyload.demo.demo2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 14:43
 * Description:支持懒加载的FragmentLazyPagerAdapter,只有主Fragment才会调用resume方法,需要配合[com.jennifer.andy.androidxlazyload.LazyFragment]使用
 */

open class FragmentLazyStatePageAdapter(
    fragmentManager: FragmentManager,
    private val fragments: MutableList<Fragment>
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = fragments[position]

    override fun getCount() = fragments.size

}