package com.example.kotlinmvvmdaggerrxsample.di.component

import com.example.kotlinmvvmdaggerrxsample.module.NetworkModule
import com.example.kotlinmvvmdaggerrxsample.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(postListViewModel: PostListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }

}