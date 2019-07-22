package com.yt8492.qiitaclient.di.component

import com.yt8492.qiitaclient.articles.ArticlesActivity
import com.yt8492.qiitaclient.di.module.ArticlesActivityModule
import com.yt8492.qiitaclient.di.module.ArticlesModule
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