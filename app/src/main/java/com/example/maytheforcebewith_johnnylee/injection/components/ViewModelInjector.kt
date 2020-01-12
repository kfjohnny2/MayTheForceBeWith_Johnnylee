package com.example.maytheforcebewith_johnnylee.injection.components

import com.example.maytheforcebewith_johnnylee.injection.module.NetworkModule
import com.example.maytheforcebewith_johnnylee.ui.details.DetailsViewModel
import com.example.maytheforcebewith_johnnylee.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for ViewModels.
 */
@Singleton
@Component(modules = [NetworkModule::class])
interface ViewModelInjector {

    /**
     * Injects required dependencies into the specified MainViewModel.
     * @param mainViewModel MainViewModel in which to inject the dependencies
     */
    fun inject(mainViewModel: MainViewModel)

    /**
     * Injects required dependencies into the specified DetailsViewModel.
     * @param detailsViewModel DetailsViewModel in which to inject the dependencies
     */
    fun inject(detailsViewModel: DetailsViewModel)

    @Component.Builder
    interface Builder {

        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}