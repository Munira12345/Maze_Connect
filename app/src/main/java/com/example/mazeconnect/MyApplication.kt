package com.example.mazeconnect

import android.app.Application
import com.example.mazeconnect.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import com.google.firebase.FirebaseApp
import org.koin.core.context.GlobalContext.startKoin

class MyApplication : Application() {
        override fun onCreate() {
            super.onCreate()
            FirebaseApp.initializeApp(this)
            startKoin {
                androidLogger()// ill have to make this fun later
                androidContext(this@MyApplication) //ill create this fun later too
                modules(
                    listOf(
                        appModule,
                       // splashscreenModule,  // ill create modules while i build the app
                       //authenticationModule, // currently want to add my sign in and sign up to a this named module

                        )
                )
            }
       }
}