package com.nasa.test.cicerone

import android.app.Application
import com.nasa.test.cicerone.di.DI

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        DI.init(this)
    }
}