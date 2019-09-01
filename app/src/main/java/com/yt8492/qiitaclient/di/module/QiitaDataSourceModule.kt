package com.yt8492.qiitaclient.di.module

import com.yt8492.qiitaclient.data.api.service.QiitaApi
import com.yt8492.qiitaclient.data.api.service.QiitaApiFactory
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import com.yt8492.qiitaclient.data.datasource.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class QiitaDataSourceModule {

    @Singleton
    @Provides
    fun provideQiitaApi(): QiitaApi = QiitaApiFactory().create()

    @Provides
    @Singleton
    fun provideArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository =
        articleRepositoryImpl

    companion object {
        private const val BASE_URL = "https://qiita.com"
    }
}