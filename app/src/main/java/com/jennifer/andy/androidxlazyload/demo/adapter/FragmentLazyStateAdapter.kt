package com.jennifer.andy.androidxlazyload.demo.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


/**
 * Author:  andy.xwt
 * Date:    2020-01-15 22:00
 * Description:
 */

class FragmentLazyStateAdapter(
    fragmentActivity: FragmentActivity,
    private val fragments: MutableList<Fragment>
) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int) = fragments[position]
}