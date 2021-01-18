package com.samrt.smartsearch

import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.samrt.smartsearch.databinding.CustomeSearchViewBinding
import com.samrt.smartsearch.textWatcher.CustomTextWatcher
import com.samrt.smartsearch.textWatcher.CustomTextWatcherInterFace
import com.samrt.smartsearch.utils.viewUtitly


class SmartSearchInputText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private lateinit var smartSearchInputListener: SmartSearchInputListener
    var binding: CustomeSearchViewBinding

    init {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custome_search_view,
            this,
            true
        )

        binding.imageView.setOnClickListener {
            binding.textView.requestFocus()
            viewUtitly.showSoftKeyboard(binding.textView)
        }

        binding.textView.addTextChangedListener(CustomTextWatcher(object :
            CustomTextWatcherInterFace {
            override fun onTextChanged(s: Editable?) {
                if (TextUtils.isEmpty(s)) {
                    binding.imageViewClear.visibility = View.GONE
                    smartSearchInputListener.onInputSearchEmpty()
                } else {
                    binding.imageViewClear.visibility = View.VISIBLE
                    smartSearchInputListener.onInputSearchChanged(s.toString())
                }
            }
        }))

        binding.imageViewClear.setOnClickListener {
            binding.textView.text.clear()
            binding.imageViewClear.visibility = View.GONE
        }
    }

    public fun setSearchInputListener(smartSearchInputListener: SmartSearchInputListener) {
        this.smartSearchInputListener = smartSearchInputListener;
    }

}