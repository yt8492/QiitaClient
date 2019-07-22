package com.yt8492.qiitaclient.articles

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import javax.inject.Inject

class ArticlesViewModelFactory @Inject constructor(
    private val application: Application,
    private val query: String?,
    private val articleRepository: ArticleRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == ArticlesViewModel::class.java) {
            "Unknown ViewModel Class"
        }
        return ArticlesViewModel(
            application,
            query,
            articleRepository
        ) as T
    }
}