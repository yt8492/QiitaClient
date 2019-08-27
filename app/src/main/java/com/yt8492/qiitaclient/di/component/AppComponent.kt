package com.yt8492.qiitaclient.di.component

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
        ArticlesFragmentModule::class,
        QiitaDataSourceModule::class
    ]
)
interface AppComponent : AndroidInjector<App>