package com.example.kotlinmvvmdaggerrxsample.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlinmvvmdaggerrxsample.di.component.DaggerViewModelInjector
import com.example.kotlinmvvmdaggerrxsample.di.component.ViewModelInjector
import com.example.kotlinmvvmdaggerrxsample.module.NetworkModule
import com.example.kotlinmvvmdaggerrxsample.ui.post.PostListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
        }
    }
}