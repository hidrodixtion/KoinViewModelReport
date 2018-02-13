package com.projectbox.koinviewmodelreport

import android.app.Application
import org.koin.android.architecture.ext.viewModel
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.applicationContext

/**
 * Created by adinugroho
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(myModules))
    }
}

val myModules = applicationContext {
    viewModel { MainVM() }
}