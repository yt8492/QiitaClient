package com.yt8492.qiitaclient

import com.yt8492.qiitaclient.infra.InfraModule
import com.yt8492.qiitaclient.ui.articles.ArticlesFragmentModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ArticlesFragmentModule::class,
        InfraModule::class
    ]
)
interface AppComponent : AndroidInjector<App>