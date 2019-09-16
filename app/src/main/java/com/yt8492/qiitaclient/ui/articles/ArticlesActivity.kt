package com.yt8492.qiitaclient.ui.articles

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.databinding.ActivityArticlesBinding

class ArticlesActivity : AppCompatActivity() {

    private val query: String? by lazy {
        intent.getStringExtra(KEY_QUERY)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<ActivityArticlesBinding>(
            this,
            R.layout.activity_articles
        )
        if (savedInstanceState == null) {
            val articlesFragment = ArticlesFragment.newInstance(query)
            supportFragmentManager.commit {
                add(R.id.fragmentContainer, articlesFragment)
            }
        }
    }

    companion object {
        private const val KEY_QUERY = "QUERY"

        fun createIntent(context: Context, query: String?): Intent =
            Intent(context, ArticlesActivity::class.java).apply {
                putExtra(KEY_QUERY, query)
            }
    }
}
