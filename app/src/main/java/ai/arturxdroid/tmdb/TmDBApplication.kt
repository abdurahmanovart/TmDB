package ai.arturxdroid.tmdb

import ai.arturxdroid.tmdb.di.AppComponent
import ai.arturxdroid.tmdb.di.DaggerAppComponent
import ai.arturxdroid.tmdb.di.NetworkModule
import android.app.Application

class TmDBApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .build()
    }
}