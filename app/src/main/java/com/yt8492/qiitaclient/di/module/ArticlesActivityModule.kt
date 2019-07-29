package com.yt8492.qiitaclient.di.module

import com.yt8492.qiitaclient.articles.ArticlesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticlesActivityModule {

    @ContributesAndroidInjector
    abstract fun articlesFragment(): ArticlesFragment
}