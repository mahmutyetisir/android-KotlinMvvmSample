package com.example.kotlinmvvmdaggerrxsample

import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Dagger Mvvm Sample"
    }

    fun clicButtonkOpenPostListActivity(view: View) {
        startActivity(Intent(this, PostListActivity::class.java))
    }
}
