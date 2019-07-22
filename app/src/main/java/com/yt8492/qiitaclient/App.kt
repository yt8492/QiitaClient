package com.yt8492.qiitaclient

import com.yt8492.qiitaclient.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.create().apply {
            inject(this@App)
        }
    }
}