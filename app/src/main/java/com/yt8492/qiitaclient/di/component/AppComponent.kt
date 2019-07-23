package com.yt8492.qiitaclient.di.component

import android.app.Application
import com.yt8492.qiitaclient.App
import com.yt8492.qiitaclient.di.module.*
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        ArticlesActivityModule::class,
        QiitaDataSourceModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    fun inject(app: Application)
}