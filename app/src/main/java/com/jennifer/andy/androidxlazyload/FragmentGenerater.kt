package com.jennifer.andy.androidxlazyload

import androidx.fragment.app.Fragment
import com.jennifer.andy.androidxlazyload.fragment.*


const val FRAGMENT_ONE = "fragment_one"
const val FRAGMENT_TWO = "fragment_two"
const val FRAGMENT_THREE = "fragment_three"

const val FRAGMENT_A = "fragment_a"
const val FRAGMENT_B = "fragment_b"
const val FRAGMENT_C = "fragment_c"

/**
 * 获取OneFragment、TwoFragment、ThreeFragment,该集合中的fragment不包含嵌套。
 */
fun generate123Fragments() = mapOf<String, Fragment>(
    FRAGMENT_ONE to OneFragment.newInstance(FRAGMENT_ONE),
    FRAGMENT_TWO to TwoFragment.newInstance(FRAGMENT_TWO),
    FRAGMENT_THREE to ThreeFragment.newInstance(FRAGMENT_THREE)
)

/**
 * 获取OneFragment、TwoFragment、ThreeFragment的Title
 */
fun generate123FragmentTitles() = mutableListOf<String>().apply {
    add(FRAGMENT_ONE)
    add(FRAGMENT_TWO)
    add(FRAGMENT_THREE)
}


/**
 * 获取AFragment、BFragment、CFragment
 */
fun generateABCFragments() = mapOf<String, Fragment>(
    FRAGMENT_A to AFragment.newInstance(),
    FRAGMENT_B to BFragment.newInstance(),
    FRAGMENT_C to CFragment.newInstance()
)

/**
 * 获取AFragment、BFragment、CFragment的Title
 */
fun generateABCFragmentTitles() = mutableListOf<String>().apply {
    add(FRAGMENT_A)
    add(FRAGMENT_B)
    add(FRAGMENT_C)
}

/**
 * 构建多个TextFragment
 */
fun generateTextFragments(amount: Int) = mutableListOf<Fragment>().apply {
    for (i in 0..amount) {
        add(TextFragment.newInstance("Fragment:${i+1}"))
    }
}


/**
 * 构建多个TextFragment的Title
 */
fun generateTextFragmentTitles(amount: Int) = mutableListOf<String>().apply {
    for (i in 0..amount) {
        add("Fragment:${i+1}")
    }
}