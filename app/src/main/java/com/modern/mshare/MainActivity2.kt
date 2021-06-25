package com.modern.mshare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView

class MainActivity2 : AppCompatActivity() ,
    AdapterView.OnItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

}