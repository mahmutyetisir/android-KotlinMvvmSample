package com.example.kotlinmvvmdaggerrxsample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clicButtonkOpenPostListActivity(view: View) {
        startActivity(Intent(this, PostListActivity::class.java))
    }
}
