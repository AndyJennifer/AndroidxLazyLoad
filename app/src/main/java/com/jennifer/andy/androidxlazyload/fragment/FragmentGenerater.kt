package com.jennifer.andy.androidxlazyload.fragment

import androidx.fragment.app.Fragment


val fragmentOne = FragmentOne.newInstance()
val fragmentTwo = FragmentTwo.newInstance()
val fragmentThree = FragmentThree.newInstance()
val fragmentFour = FragmentFour.newInstance()

/**
 * 获取正常的Fragment，该集合中的fragment不包含嵌套。
 */
fun generateNormalFragments() = mutableListOf<Fragment>().apply {
    add(fragmentOne)
    add(fragmentTwo)
    add(fragmentThree)
}