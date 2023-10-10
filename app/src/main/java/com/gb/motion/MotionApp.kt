package com.gb.motion

import android.app.Application
import com.gb.motion.koin.activityModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class MotionApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MotionApp)
            modules(listOf(activityModule))
        }
    }
}