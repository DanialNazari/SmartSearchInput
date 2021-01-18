package com.example.smartsearchapplication

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.danialnazari.localeassistant.LocaleUtils
import com.samrt.smartsearch.SmartSearchInputListener
import com.samrt.smartsearch.SmartSearchInputText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smartSearchInputText = findViewById<SmartSearchInputText>(R.id.search_edit_text)
        val searchInputResultTV = findViewById<TextView>(R.id.searchInputResultTV)

        smartSearchInputText.setSearchInputListener(object : SmartSearchInputListener {
            override fun onInputSearchChanged(text: String) {
                searchInputResultTV.text = text
            }

            override fun onInputSearchEmpty() {
                searchInputResultTV.text = ""
            }
        })
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(LocaleUtils.updateBaseContextLocale("fa",newBase))
    }

}