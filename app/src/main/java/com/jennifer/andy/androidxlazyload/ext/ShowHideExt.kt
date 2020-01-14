package com.jennifer.andy.androidxlazyload.ext

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:35
 * Description:
 */

private fun Fragment.loadFragments(
    @IdRes containerViewId: Int,
    showPosition: Int = 0,
    vararg fragments: Fragment
) {
    loadFragmentsTransaction(containerViewId, showPosition, childFragmentManager, *fragments)
}

//调用showHide方法之前需要调用 loadFragments 方法
private fun Fragment.showHideFragment(showFragment: Fragment) {
    showHideFragmentTransaction(childFragmentManager, showFragment)

}

private fun AppCompatActivity.loadFragments(
    @IdRes containerViewId: Int,
    showPosition: Int = 0,
    vararg fragments: Fragment
) {
    loadFragmentsTransaction(containerViewId, showPosition, supportFragmentManager, *fragments)
}

private fun AppCompatActivity.showHideFragment(showFragment: Fragment) {
    showHideFragmentTransaction(supportFragmentManager, showFragment)
}


private fun loadFragmentsTransaction(
    @IdRes containerViewId: Int,
    showPosition: Int = 0,
    fragmentManager: FragmentManager,
    vararg fragments: Fragment
) {

    if (fragments.isNotEmpty()) {
        fragmentManager.beginTransaction().apply {
            for (index in fragments.indices) {
                val fragment = fragments[index]
                add(containerViewId, fragment, fragment.javaClass.name)
                if (showPosition == index) {
                    setMaxLifecycle(fragment, Lifecycle.State.RESUMED)
                } else {
                    hide(fragment)
                    setMaxLifecycle(fragment, Lifecycle.State.STARTED)
                }
            }

        }.commit()
    }
}

private fun showHideFragmentTransaction(fragmentManager: FragmentManager, showFragment: Fragment) {
    fragmentManager.beginTransaction().apply {
        show(showFragment)
        setMaxLifecycle(showFragment, Lifecycle.State.RESUMED)

        //获取其中所有的fragment,其他的fragment进行隐藏
        val fragments = fragmentManager.fragments
        for (fragment in fragments) {
            if (fragment !== showFragment) {
                setMaxLifecycle(fragment, Lifecycle.State.STARTED)
                hide(fragment)
            }
        }
    }.commit()
}
