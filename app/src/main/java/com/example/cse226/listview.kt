package com.example.cse226

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class listview : AppCompatActivity() {
    lateinit var lv:ListView
    lateinit var adapter: ArrayAdapter<String>
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// https://www.geeksforgeeks.org/android-listview-in-kotlin/  Article
        setContentView(R.layout.activity_main)
        lv=findViewById(R.id.coustom_listview)
        val arr = arrayOf("one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten")
      // TODO 1 - create the Array Adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)
        // context - current activity
        // int which layout file you the list lay out is already define in android studio so use the predfine data
        // the data you want to display
        lv.adapter = adapter

    }
}