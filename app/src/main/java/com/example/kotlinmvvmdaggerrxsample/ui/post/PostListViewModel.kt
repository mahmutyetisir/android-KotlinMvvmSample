package com.example.kotlinmvvmdaggerrxsample.ui.post

import com.example.kotlinmvvmdaggerrxsample.network.PostApi
import com.example.kotlinmvvmdaggerrxsample.viewmodel.BaseViewModel
import javax.inject.Inject

class PostListViewModel : BaseViewModel() {

    @Inject
    lateinit var postApi: PostApi
}