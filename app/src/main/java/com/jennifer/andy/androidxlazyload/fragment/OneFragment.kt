package com.jennifer.andy.androidxlazyload.fragment

import android.os.Bundle


/**
 * Author:  andy.xwt
 * Date:    2020-01-14 18:33
 * Description:
 */


class OneFragment : TextFragment() {

    companion object {
        fun newInstance(text: String) = OneFragment().apply {
            arguments = Bundle().apply { putString("text", text) }
        }
    }
}
