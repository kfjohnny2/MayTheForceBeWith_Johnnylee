package com.example.maytheforcebewith_johnnylee.application

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication

class MayTheForceBeWithApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        var appContext: Context? = null
            private set
    }
}