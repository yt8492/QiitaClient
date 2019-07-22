package com.yt8492.qiitaclient.di.module

import android.app.Application
import com.yt8492.qiitaclient.App
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun bindApplication(app: App): Application
}