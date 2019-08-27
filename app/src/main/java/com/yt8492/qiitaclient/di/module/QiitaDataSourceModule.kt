package com.yt8492.qiitaclient.di.module

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yt8492.qiitaclient.data.api.service.QiitaApi
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import com.yt8492.qiitaclient.data.datasource.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class QiitaDataSourceModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Singleton
    @Provides
    fun provideQiitaApi(retrofit: Retrofit): QiitaApi =
        retrofit.create()

    @Provides
    @Singleton
    fun provideArticleRepository(articleRepositoryImpl: ArticleRepositoryImpl): ArticleRepository =
        articleRepositoryImpl

    companion object {
        private const val BASE_URL = "https://qiita.com"
    }
}