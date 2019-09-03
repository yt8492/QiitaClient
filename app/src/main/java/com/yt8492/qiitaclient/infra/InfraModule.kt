package com.yt8492.qiitaclient.infra

import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.infra.api.QiitaApi
import com.yt8492.qiitaclient.infra.api.QiitaApiFactory
import com.yt8492.qiitaclient.infra.repository.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InfraModule {

    @Singleton
    @Provides
    fun provideQiitaApi(): QiitaApi = QiitaApiFactory().create()

    @Provides
    @Singleton
    fun provideArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository =
        articleRepositoryImpl
}