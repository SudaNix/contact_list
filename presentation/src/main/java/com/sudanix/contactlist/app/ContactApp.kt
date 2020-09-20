package com.sudanix.contactlist.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ContactApp : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}