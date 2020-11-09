package com.example.smartsearchapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.smartsearchapplication.model.District
import com.samrt.smartsearch.SmartSearchInputListener
import com.samrt.smartsearch.SmartSearchInputText
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val smartSearchInputText = findViewById<SmartSearchInputText>(R.id.searchInput)

        smartSearchInputText.setSearchInputListener(object : SmartSearchInputListener {
            override fun onInputSearchChanged(text: String) {
                val districts: MutableList<District> = ArrayList<District>()
                //setUpList(districts)
            }

            override fun onInputSearchEmpty() {
                val districts: MutableList<District> = ArrayList<District>()
                //setUpList(districts)
            }
        })

    }
}