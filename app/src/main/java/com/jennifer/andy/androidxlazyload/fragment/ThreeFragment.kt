package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:34
 * Description:
 */

class ThreeFragment : TextFragment () {

    companion object {
        fun newInstance(text: String) = ThreeFragment().apply {
            arguments = Bundle().apply { putString("text", text) }
        }
    }
}
