package com.yt8492.qiitaclient.ui.articles

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticlesFragmentModule {

    @ContributesAndroidInjector
    abstract fun articlesFragment(): ArticlesFragment
}