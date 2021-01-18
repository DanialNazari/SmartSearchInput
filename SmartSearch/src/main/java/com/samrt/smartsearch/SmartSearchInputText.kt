package com.samrt.smartsearch

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.SearchView


class SmartSearchInputText @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = R.style.SearchInPutTheme
) : SearchView(context, attrs, defStyleAttr) {

    private lateinit var smartSearchInputListener: SmartSearchInputListener

    init {

        this.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    if (!TextUtils.isEmpty(it)) {
                        smartSearchInputListener.onInputSearchChanged(newText)
                        return false
                    }
                }
                smartSearchInputListener.onInputSearchEmpty()
                return false
            }
        })

        this.isFocusable = true;

        this.setOnClickListener {
            this.setIconifiedByDefault(true);
            this.setFocusable(true);
            this.setIconified(false);
            this.requestFocusFromTouch();
        }

    }

    public fun setSearchInputListener(smartSearchInputListener: SmartSearchInputListener) {
        this.smartSearchInputListener = smartSearchInputListener;
    }

}