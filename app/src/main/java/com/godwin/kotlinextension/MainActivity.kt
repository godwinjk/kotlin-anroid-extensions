package com.godwin.kotlinextension

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.godwin.kotlinextns.AppPreference
import com.godwin.kotlinextns.appPreference

class MainActivity : AppCompatActivity() {
    val pref by appPreference("godwin")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}