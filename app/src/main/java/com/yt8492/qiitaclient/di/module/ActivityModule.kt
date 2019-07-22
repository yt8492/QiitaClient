package com.yt8492.qiitaclient.di.module

import com.yt8492.qiitaclient.articles.ArticlesActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [ArticlesActivityModule::class, ArticlesModule::class,
        QiitaDataSourceModule::class])
    abstract fun articlesActivity(): ArticlesActivity
}