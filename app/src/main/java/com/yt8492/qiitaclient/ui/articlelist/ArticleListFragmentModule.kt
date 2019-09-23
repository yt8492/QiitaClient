package com.yt8492.qiitaclient.ui.articlelist

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ArticleListFragmentModule {

    @ContributesAndroidInjector
    abstract fun articleListFragment(): ArticleListFragment
}