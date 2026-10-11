package com.mahrous.demo_app.core.app


import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.paperdb.Paper

@HiltAndroidApp
class DemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Paper.init(this)

    }
}