
package com.ashish060792.funwithkotlin

import android.app.Application

/**
 * Created by Ashish on 9/11/2017.
 */
class App: Application() {

    companion object {
        lateinit var instance: App
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}