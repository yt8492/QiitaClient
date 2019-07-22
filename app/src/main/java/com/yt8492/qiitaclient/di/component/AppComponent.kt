package com.yt8492.qiitaclient.di.component

import android.app.Application
import com.yt8492.qiitaclient.App
import com.yt8492.qiitaclient.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    fun inject(app: Application)
}