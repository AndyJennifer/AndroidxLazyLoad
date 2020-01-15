package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.jennifer.andy.androidxlazyload.LazyFragment
import com.jennifer.andy.androidxlazyload.R


/**
 * Author:  andy.xwt
 * Date:    2020-01-15 12:20
 * Description:
 */

open class TextFragment : LazyFragment() {

    companion object {
        fun newInstance(text: String) = TextFragment().apply {
            arguments = Bundle().apply { putString("text", text) }
            TAG = text
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_text, container, false)

    override fun lazyInit() {
        view?.findViewById<TextView>(R.id.tv_text)?.text = arguments?.getString("text") ?: ""
    }
}