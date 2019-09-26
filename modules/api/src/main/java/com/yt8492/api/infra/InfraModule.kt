package com.yt8492.api.infra

import com.yt8492.api.infra.api.QiitaApi
import com.yt8492.api.infra.api.QiitaApiFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class InfraModule {

    @Singleton
    @Provides
    fun provideQiitaAqi(): QiitaApi = QiitaApiFactory().create()
}