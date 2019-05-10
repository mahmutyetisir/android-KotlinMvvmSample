package com.example.kotlinmvvmdaggerrxsample.utils

import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("mutableVisibilty")
fun setMutableVisibility(view: View, visibilty: MutableLiveData<Int>?) {

    val parentActivity: AppCompatActivity? = view.getParentActivity()

    if (parentActivity != null && visibilty != null) {
        visibilty.observe(
            parentActivity,
            Observer { visibilityvalue -> view.visibility = visibilityvalue ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null) {
        text.observe(parentActivity, Observer { textValue -> view.text = textValue ?: "" })
    }
}

@BindingAdapter("adapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

