package com.example.kotlinmvvmdaggerrxsample.ui.post

import androidx.lifecycle.MutableLiveData
import com.example.kotlinmvvmdaggerrxsample.model.Post
import com.example.kotlinmvvmdaggerrxsample.viewmodel.BaseViewModel

class PostViewModel : BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()

    fun bind(post: Post) {
        postTitle.value = post.title
        postBody.value = post.body
    }

    fun getPostTitle(): MutableLiveData<String> {
        return postTitle
    }

    fun getPostBody(): MutableLiveData<String> {
        return postBody
    }
}