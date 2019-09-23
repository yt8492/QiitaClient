package com.yt8492.qiitaclient

import android.app.Application
import com.yt8492.qiitaclient.App
import com.yt8492.qiitaclient.infra.InfraModule
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(
    includes = [
        InfraModule::class
    ]
)
abstract class AppModule {

    @Binds
    abstract fun bindApplication(app: App): Application
}