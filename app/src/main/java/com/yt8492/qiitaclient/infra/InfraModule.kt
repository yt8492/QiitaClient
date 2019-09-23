package com.yt8492.qiitaclient.infra

import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.infra.api.QiitaApi
import com.yt8492.qiitaclient.infra.api.QiitaApiFactory
import com.yt8492.qiitaclient.infra.impl.domain.repository.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InfraModule {

    @Singleton
    @Provides
    fun provideQiitaAqi(): QiitaApi = QiitaApiFactory().create()

    @Singleton
    @Provides
    fun provideArticleRepository(impl: ArticleRepositoryImpl): ArticleRepository = impl
}