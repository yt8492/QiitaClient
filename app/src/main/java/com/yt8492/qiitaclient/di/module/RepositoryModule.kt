package com.yt8492.qiitaclient.di.module

import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import com.yt8492.qiitaclient.data.datasource.ArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun bindArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository = articleRepositoryImpl
}