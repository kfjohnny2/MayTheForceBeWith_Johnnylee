package com.example.maytheforcebewith_johnnylee.base

import androidx.lifecycle.ViewModel
import com.example.maytheforcebewith_johnnylee.injection.components.DaggerViewModelInjector
import com.example.maytheforcebewith_johnnylee.injection.components.ViewModelInjector
import com.example.maytheforcebewith_johnnylee.injection.module.NetworkModule
import com.example.maytheforcebewith_johnnylee.ui.main.MainViewModel

open class BaseViewModel : ViewModel(){
    private val injectorApi: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainViewModel -> injectorApi.inject(this)
        }
    }
}