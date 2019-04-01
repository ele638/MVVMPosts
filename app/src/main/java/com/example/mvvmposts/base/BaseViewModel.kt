package com.example.mvvmposts.base

import androidx.lifecycle.ViewModel
import com.example.mvvmposts.injection.component.DaggerViewModelInjector
import com.example.mvvmposts.injection.component.ViewModelInjector
import com.example.mvvmposts.injection.module.NetworkModule
import com.example.mvvmposts.ui.post.PostListViewModel

abstract class BaseViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init{
        inject()
    }

    private fun inject(){
        when (this){
            is PostListViewModel -> injector.inject(this)
        }
    }
}