package com.example.mazeconnect.di

import androidx.navigation.NavHostController
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.DialogNavigator
import org.koin.dsl.module
import com.example.mazeconnect.MazeViewModel
import org.koin.android.ext.koin.androidContext

val appModule = module {

    single {
        NavHostController(androidContext()).apply {
        navigatorProvider.addNavigator(ComposeNavigator())
        navigatorProvider.addNavigator(DialogNavigator())
        }
        }
       single {
            MazeViewModel(get())
}}