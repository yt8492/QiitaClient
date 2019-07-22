package com.yt8492.qiitaclient.di.component

import com.yt8492.qiitaclient.articles.ArticlesActivity
import com.yt8492.qiitaclient.di.modlue.ActivityModule
import com.yt8492.qiitaclient.di.modlue.ArticlesActivityModule
import com.yt8492.qiitaclient.di.modlue.ArticlesModule
import dagger.Component

@Component(
    modules = [
        ArticlesModule::class,
        ArticlesActivityModule::class
    ]
)
interface ArticlesComponent {

    @Component.Factory
    interface Factory {
        fun create(module: ArticlesModule): ArticlesComponent
    }

    fun inject(activity: ArticlesActivity)
}