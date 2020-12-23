package com.lamnt.foodorder

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

class FoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}