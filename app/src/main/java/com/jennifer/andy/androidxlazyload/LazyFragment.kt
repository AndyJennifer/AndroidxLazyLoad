package com.jennifer.andy.androidxlazyload

import android.util.Log


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 14:44
 * Description: Androidx 下支持栏加载的fragment
 */

abstract class LazyFragment : LogFragment() {

    private var isLoaded = false

    override fun onResume() {
        super.onResume()
        if (!isLoaded && !isHidden) {
            lazyInit()
            Log.d(TAG, "lazyInit:!!!!!!!")
            isLoaded = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isLoaded = false
    }

    abstract fun lazyInit()

}