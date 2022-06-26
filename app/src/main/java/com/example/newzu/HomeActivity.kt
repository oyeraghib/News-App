package com.example.newzu

import android.app.Application
import io.requestly.android.core.Requestly

class HomeActivity: Application() {

    override fun onCreate() {
        super.onCreate()

        Requestly.Builder(this, "GzQVcd94eMWPBDNhNLJG")
            .build()
    }
}