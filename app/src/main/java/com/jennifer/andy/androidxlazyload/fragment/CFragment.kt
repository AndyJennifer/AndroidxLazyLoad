package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.jennifer.andy.androidxlazyload.LazyFragment
import com.jennifer.andy.androidxlazyload.R
import com.jennifer.andy.androidxlazyload.demo.adapter.FragmentLazyStatePageAdapter
import com.jennifer.andy.androidxlazyload.generateTextFragmentTitles
import com.jennifer.andy.androidxlazyload.generateTextFragments


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:33
 * Description:
 */


class CFragment : LazyFragment() {

    companion object {
        fun newInstance() = CFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_c, container, false)


    override fun lazyInit() {
        view?.let {
            val viewPager = it.findViewById<ViewPager>(R.id.view_pager).apply {
                adapter = FragmentLazyStatePageAdapter(
                    childFragmentManager,
                    generateTextFragments(4),
                    generateTextFragmentTitles(4)
                )
            }
            it.findViewById<TabLayout>(R.id.tab_layout)?.setupWithViewPager(viewPager)
        }

    }
}
