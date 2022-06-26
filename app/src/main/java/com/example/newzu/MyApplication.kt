package com.example.newzu

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.requestly.android.core.Requestly

@HiltAndroidApp
class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Requestly.Builder(this, "GzQVcd94eMWPBDNhNLJG")
            .build()
    }
}