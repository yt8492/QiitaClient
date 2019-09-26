package com.yt8492.qiitaclient

import android.app.Application
import com.yt8492.api.ApiModule
import com.yt8492.qiitaclient.ui.articlelist.ArticleListFragmentModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        ArticleListFragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    fun inject(app: Application)
}