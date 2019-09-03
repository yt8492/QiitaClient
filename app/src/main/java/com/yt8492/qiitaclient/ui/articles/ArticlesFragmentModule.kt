package com.yt8492.qiitaclient.ui.articles

import com.yt8492.qiitaclient.ui.articles.ArticlesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticlesFragmentModule {

    @ContributesAndroidInjector
    abstract fun articlesFragment(): ArticlesFragment
}