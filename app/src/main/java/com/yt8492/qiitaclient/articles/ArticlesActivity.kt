package com.yt8492.qiitaclient.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.transaction
import com.yt8492.qiitaclient.R
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class ArticlesActivity : DaggerAppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val articlesFragment = ArticlesFragment.newInstance()
        supportFragmentManager.transaction {
            add(R.id.fragment_container, articlesFragment)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }
}
