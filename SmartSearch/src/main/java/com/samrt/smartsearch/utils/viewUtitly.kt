package com.samrt.smartsearch.utils

import android.content.Context
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.util.*

class viewUtitly {
    companion object {

        @JvmStatic
        public fun showSoftKeyboard(view: View) {
            if (view.requestFocus()) {
                val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?

                // here is one more tricky issue
                // imm.showSoftInputMethod doesn't work well
                // and imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0) doesn't work well for all cases too
                imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        }
    }
}