package ru.trinitydigital

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.trinitydigital.di.appModules

class ExpandableApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appModules)
    }
}