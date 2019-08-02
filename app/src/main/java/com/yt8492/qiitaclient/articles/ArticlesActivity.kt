package com.yt8492.qiitaclient.articles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.yt8492.qiitaclient.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class ArticlesActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    internal lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    private val query: String? by lazy {
        intent.getStringExtra(KEY_QUERY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        val articlesFragment = ArticlesFragment.newInstance(query)
        supportFragmentManager.commit {
            add(R.id.fragmentContainer, articlesFragment)
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentInjector
    }

    companion object {
        const val KEY_QUERY = "QUERY"

        fun createIntent(context: Context, query: String?): Intent =
            Intent(context, ArticlesActivity::class.java).apply {
                putExtra(KEY_QUERY, query)
            }
    }
}
